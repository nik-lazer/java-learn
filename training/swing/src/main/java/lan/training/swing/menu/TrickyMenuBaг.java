package lan.training.swing.menu;

import javax.swing.*;

/**
 * {@link javax.swing.JMenuBar} using example
 * Created by nik-lazer on 03.11.14.
 */
public class TrickyMenuBaг extends JFrame {
	public TrickyMenuBaг() {
		super("TrickyMenuBar");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(new JMenu("Main"));
		menuBar.add(new JMenu("Edit"));
		menuBar.add(Box.createHorizontalGlue());
		JLabel label = new JLabel("Label");
		label.setBorder(BorderFactory.createEtchedBorder());
		menuBar.add(label);
		setJMenuBar(menuBar);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TrickyMenuBaг();
	}
}
