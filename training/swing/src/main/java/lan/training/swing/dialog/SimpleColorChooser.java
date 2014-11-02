package lan.training.swing.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nik-lazer on 04.11.14.
 */
public class SimpleColorChooser extends JFrame {
	JPanel contents = new JPanel();
	private JColorChooser chooser = new JColorChooser();

	public SimpleColorChooser() {
		super("SimpleColorChooser");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JButton choose = new JButton("Background color selection");
		choose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = chooser.showDialog(SimpleColorChooser.this, "Select color", contents.getBackground());
				if (color != null) {
					contents.setBackground(color);
					contents.repaint();
				}
			}
		});
		contents.add(choose);
		setContentPane(contents);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SimpleColorChooser();
	}
}
