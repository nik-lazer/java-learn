package lan.training.swing.file;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nik-lazer on 04.11.14.
 */
public class SimpleFileChooser extends JFrame {
	JFileChooser fc = new JFileChooser();

	public SimpleFileChooser() {
		super("SimpleFileChooser");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JButton open = new JButton("Open" );
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setDialogTitle("Select folder");
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int res = fc.showOpenDialog(SimpleFileChooser.this);
				if (res == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(SimpleFileChooser.this, fc.getSelectedFile());
				}
			}
		});
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setDialogTitle("File saving");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int res = fc.showSaveDialog(SimpleFileChooser.this);
				if (res == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(SimpleFileChooser.this, "File saved");
				}
			}
		});

		JPanel contents = new JPanel();
		contents.add(open);
		contents.add(save);
		setContentPane(contents);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SimpleFileChooser();
	}
}
