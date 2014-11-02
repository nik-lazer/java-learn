package lan.training.swing.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello wold Swing example
 * Created by nik-lazer on 22.10.14.
 */
public final class DialogExample implements Runnable {

	public static void main(String[] args) {
		// Start UI code in manage thread:
		SwingUtilities.invokeLater (new DialogExample());
	}

	public void run() {
		final JFrame frame = new JFrame ("Hello, World!");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		// alternative: frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

		// Add to panel label with text
		//frame.getContentPane().add (new JLabel("Hello, World!")); - old style
		frame.add(new JLabel("Hello World"), BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		frame.add(buttonPanel, BorderLayout.SOUTH);
		JButton button = new JButton("dialog");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = createDialog(frame, "Simple dialog");
				dialog.setVisible(true);
			}
		});
		JButton modalButton = new JButton("modal dialog");
		modalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = createDialog(null, "Modal dialog");
				dialog.setModal(true);
				dialog.setVisible(true);
			}
		});
		buttonPanel.add(button);
		buttonPanel.add(modalButton);

		// pack() set optimal size for window.

		frame.pack();

		// show window

		frame.setVisible(true);
	}

	private JDialog createDialog(JFrame frame, String title) {
		JDialog dialog = new JDialog(frame, title);
		dialog.setSize(300, 200);
		dialog.add(new JLabel("It's dialog"), BorderLayout.CENTER);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		return dialog;
	}
}
