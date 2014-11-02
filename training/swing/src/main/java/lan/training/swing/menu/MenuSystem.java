package lan.training.swing.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * {@link JMenu} using example
 * Created by nik-lazer on 02.11.14.
 */
public class MenuSystem extends JFrame {
	private JMenuBar menuBar;

	public MenuSystem() {
		super("MenuSystem");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createWhoMenu());
		setJMenuBar(menuBar);
		setSize(300, 200);
		setVisible(true);
	}

	private JMenu createWhoMenu() {
		JMenu menu = new JMenu("Test");
		JCheckBoxMenuItem checkBoxItem1 = new JCheckBoxMenuItem("checkBoxItem 1");
		JCheckBoxMenuItem checkBoxItem2 = new JCheckBoxMenuItem("checkBoxItem 2");
		JCheckBoxMenuItem checkBoxItem3 = new JCheckBoxMenuItem("checkBoxItem 3");
		JRadioButtonMenuItem radioItem1 = new JRadioButtonMenuItem("radioItem 1");
		JRadioButtonMenuItem radioItem2 = new JRadioButtonMenuItem("radioItem 2");
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioItem1);
		bg.add(radioItem2);
		menu.add(checkBoxItem1);
		menu.add(checkBoxItem2);
		menu.add(checkBoxItem3);
		menu.add(new JSeparator());
		menu.add(radioItem1);
		menu.add(radioItem2);
		return menu;
	}

	private JMenu createFileMenu() {
		JMenu file = new JMenu("File");
		JMenuItem open = new JMenuItem("Open", new ImageIcon(MenuSystem.class.getResource("open.png")));
		open.setMnemonic('O');
		open.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
		JMenuItem exit = new JMenuItem(new ExitAction());
		exit.setMnemonic('O');
		exit.setAccelerator(KeyStroke.getKeyStroke('E', KeyEvent.CTRL_MASK));
		file.add(open);
		file.addSeparator();
		file.add(exit);
		return file;
	}

	class ExitAction extends AbstractAction {
		public ExitAction() {
			putValue(NAME, "Exit");
		}

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new MenuSystem();
	}
}
