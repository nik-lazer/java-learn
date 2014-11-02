package lan.training.swing.file;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by nik-lazer on 04.11.14.
 */
public class FilteringFiles extends JFrame {
	public FilteringFiles() {
		super("FilteringFiles");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);

		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select test file");
		chooser.addChoosableFileFilter(new TextFilesFilter());
		int res = chooser.showOpenDialog(this);
		if (res == JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(this, chooser.getSelectedFile());
		}
	}

	class TextFilesFilter extends FileFilter {
		@Override
		public boolean accept(File file) {
			if (file.isDirectory()) {
				return true;
			}
			return (file.getName().endsWith("txt"));
		}

		public String getDescription() {
			return "Text files (*.txt)";
		}
	}

	public static void main(String[] args) {
		new FilteringFiles();
	}
}
