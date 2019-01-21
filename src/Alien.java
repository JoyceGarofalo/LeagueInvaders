import java.awt.Color;
import java.awt.Graphics;

public class Alien {
	int x;
	int y;
	int width;
	int height;
	Alien(int x, int y, int width, int height){
		
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect(x, y, width, height);
	}
	void update() {
		y++;
	}
	
	
}
