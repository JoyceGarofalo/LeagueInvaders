import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
	//int x;
	//int y;
	//int width;
	//int height;
	int mode = -1;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);

	}

	void update() {
		super.update();
		Random r = new Random();
		int rand = r.nextInt(100);
		if (rand < 10) {
			mode = r.nextInt(3);
		}
		y+=5;
		if (mode == 0 && x > 0) {
			x -= 2;
		}
		if (mode == 1 && x < LeagueInvaders.WIDTH - width) {
			x += 2;
		}
		if (mode == 2) {

		}

	}
	
	

}
