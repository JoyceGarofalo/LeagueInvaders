import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien {
	int x;
	int y;
	int width;
	int height;
	int mode = -1;

	Alien(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);
	}

	void update() {
		Random r = new Random();
		int rand = r.nextInt(100);
		if (rand < 10) {
			mode = r.nextInt(3);
		}
		y++;
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
