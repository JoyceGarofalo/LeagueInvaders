import java.awt.Graphics;
import java.util.Random;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	void update() {
		Random r = new Random();
		x = r.nextInt(100);
		y = r.nextInt(100);
		
	}

	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100); 
	}

}
