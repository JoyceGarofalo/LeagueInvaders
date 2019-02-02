import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer = new Timer(1000 / 60, this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font subFont;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager objectM;

	void startGame() {
		timer.start();

	}

	GamePanel() {
		startGame();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subFont = new Font("Arial", Font.PLAIN, 20);
		objectM = new ObjectManager(rocket);

	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectM.update();
		objectM.manageEnemies();

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("League Invaders", 65, 150);
		g.setFont(subFont);
		g.drawString("press enter to start", 152, 350);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		objectM.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 126, 150);
		g.setFont(subFont);
		g.drawString("press enter to restart", 150, 350);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) {
			currentState += 1;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up = true;
		} else if (e.getKeyCode() == 39) {
			rocket.right = true;
		} else if (e.getKeyCode() == 40) {
			rocket.down = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			objectM.addProjectile(new Projectile(rocket.x, rocket.y, 10, 10));
			/*
			 * Random r = new Random(); int rand = r.nextInt(500); Alien alien = new
			 * Alien(rand, 0, 100, 100); objectM.addAlien(alien);
			 */
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up = false;
		} else if (e.getKeyCode() == 39) {
			rocket.right = false;
		} else if (e.getKeyCode() == 40) {
			rocket.down = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left = false;
		}

	}
}
