package lan.training.swing;

import javax.swing.*;

/**
 * Hello wold Swing example
 * Created by nik-lazer on 22.10.14.
 */
public final class HelloWorld implements Runnable {

	public static void main(String[] args) {
		// Start UI code in manage thread:
		SwingUtilities.invokeLater (new HelloWorld());
	}

	public void run() {
		JFrame frame = new JFrame ("Hello, World!");
		frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		// alternative: frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// Add to panel label with text
		//frame.getContentPane().add (new JLabel("Hello, World!")); - old style
		frame.add(new JLabel("Hello World"));

		// pack() set optimal size for window.

		frame.pack();

		// show window

		frame.setVisible(true);
	}
}
