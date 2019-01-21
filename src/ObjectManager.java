import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	public ObjectManager(Rocketship rocket) {
		// TODO Auto-generated constructor stub
		this.rocket = rocket;
	}
	void update() {
		rocket.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			
		}
	}
	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
			
		}
		
	}
	void addProjectile(Projectile projectile){
		projectiles.add(projectile);
		
	}
	void addAlien(Alien alien) {
		aliens.add(alien);
	}
	
	
	
}
