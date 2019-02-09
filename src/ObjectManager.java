import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public ObjectManager(Rocketship rocket) {
		// TODO Auto-generated constructor stub
		this.rocket = rocket;
	}

	void update() {
		rocket.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);

	}

	void addAlien(Alien alien) {
		aliens.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		checkCollision();
		for(int al = 0; al < aliens.size(); al++) {
			if(!aliens.get(al).isAlive) {
				aliens.remove(al);
				al--;
			}
		}
		for(int pr = 0; pr < projectiles.size(); pr++) {
			if(!projectiles.get(pr).isAlive) {
				projectiles.remove(pr);
				pr--;
			}
		}
	}
		
	
	void checkCollision() {
		for(Alien alien : aliens) {
			if(rocket.collisionBox.intersects(alien.collisionBox)) {
				rocket.isAlive = false;
			}
		}
		for(Projectile projectile : projectiles) {
			for (int a = 0; a < aliens.size(); a++) {
				if(aliens.get(a).collisionBox.intersects(projectile.collisionBox)) {
					aliens.get(a).isAlive = false;
				}
			}
		}
		for(Alien alien : aliens) {
			for(int p = 0; p < projectiles.size(); p++) {
				if(projectiles.get(p).collisionBox.intersects(alien.collisionBox)) {
					projectiles.get(p).isAlive = false;
				}
			}
		}
			
	}
	
	

}
