import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame frame = new JFrame();

	GamePanel game = new GamePanel();

	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.setup();

	}

	void setup() {
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setVisible(true);
		frame.addKeyListener(game);
		frame.pack();
	}

}
