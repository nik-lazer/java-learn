package lan.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Look-and-Feel Swing example
 * Created by nik-lazer on 22.10.14.
 */
public class LookAndFeelTest {
	public static void main(String[] args) {
		final JFrame frame = new JFrame ("Hello, World!");
		frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);

		JPanel textPanel = new JPanel();
		textPanel.add(new JLabel("Look and Feel test"));
		panel.add(textPanel);
		JPanel buttonPanel = new JPanel();
		JButton metalButton = new JButton("Metal");
		metalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMetalStyle(frame);
			}
		});
		JButton motifButton = new JButton("Motif");
		motifButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMotifStyle(frame);
			}
		});
		JButton windowsButton = new JButton("Windows");
		windowsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setWindowsStyle(frame);
			}
		});
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		buttonPanel.add(metalButton);
		buttonPanel.add(motifButton);
		buttonPanel.add(windowsButton);
		buttonPanel.add(closeButton);
		panel.add(buttonPanel);

		// pack() set optimal size for window.

		frame.pack();

		// show window

		frame.setVisible(true);
	}

	private static void setMetalStyle(Component component) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			SwingUtilities.updateComponentTreeUI(component);
		}
		catch (Exception e){
			System.out.println("Ошибка при загрузке Metal-Look-And-Feel");
		}
	}

	private static void setMotifStyle(Component component) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			SwingUtilities.updateComponentTreeUI(component);
		}
		catch (Exception e){
			System.out.println("Ошибка при загрузке Motif-Look-And-Feel");
		}
	}

	private static void setWindowsStyle(Component component) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(component);
		}
		catch (Exception e){
			System.out.println("Ошибка при загрузке Windows-Look-And-Feel");
		}
	}
}
