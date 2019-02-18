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
		
		if(right) {
			x += speed;
		}
		else if(left) {
			x -= speed;
		}
		if(x > 500) {
			x=0;
		}
		if(x < 0) {
			x=500;
		}

		
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
		
		
	}

}
