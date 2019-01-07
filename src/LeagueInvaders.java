import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	int height = 800;
	int width = 500;
	GamePanel game = new GamePanel();

	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.setup();

	}

	void setup() {
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.addKeyListener(game);
		frame.pack();
	}

}
