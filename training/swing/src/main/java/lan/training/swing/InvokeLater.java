package lan.training.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Using invokeLater with multi-threading sample
 * Created by nik-lazer on 02.11.14.
 */
public class InvokeLater extends JFrame {
	private JButton button;

	public InvokeLater() {
		super("InvokeLater");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		button = new JButton("Do long work");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ComplexJobThread().start();
				button.setText("Wait...");
			}
		});

		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(new JTextField(20));
		getContentPane().add(button);
		setSize(400, 200);
		setVisible(true);
	}

	class ComplexJobThread extends Thread {
		public void run() {
			try {
				sleep(3000);
				//SwingUtilities.invokeLater(..) - alternative
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						button.setText("Long work completed");
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new InvokeLater();
	}
}
