import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	boolean up, down, right, left;
	
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		
		// TODO Auto-generated constructor stub
	}
	void update(){
		super.update();
		if(up) {
			y -= speed;
		}
		else if(right) {
			x += speed;
		}
		else if(left) {
			x -= speed;
		}
		else if(down) {
			y += speed;
		}
		
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
		
	}

}
