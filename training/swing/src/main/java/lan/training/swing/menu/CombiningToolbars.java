package lan.training.swing.menu;

import javax.swing.*;
import javax.swing.plaf.basic.BasicDesktopPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * {@link javax.swing.JToolBar} example
 * Created by nik-lazer on 03.11.14.
 */
public class CombiningToolbars extends JFrame {
	public CombiningToolbars() {
		super("CombiningToolbars");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JToolBar toolbar1 = new JToolBar();
		toolbar1.add(new OpenAction());
		toolbar1.add(new SaveAction());
		toolbar1.addSeparator();
		toolbar1.add(new JButton("Style"));

		JToolBar toolbar2 = new JToolBar();
		toolbar2.add(new JButton("Color"));
		toolbar2.add(new JComboBox(new String[]{"Red", "Green"}));
		toolbar2.add(Box.createGlue());

		JToolBar toolbar3 = new JToolBar();
		toolbar3.add(new JButton("normal"));
		toolbar3.add(new JButton("bold"));
		toolbar3.add(new JButton("underscored"));

		Box first = Box.createHorizontalBox();
		first.add(toolbar1);
		first.add(Box.createHorizontalStrut(5));
		first.add(toolbar2);
		Box all = Box.createVerticalBox();
		first.setAlignmentX(Component.LEFT_ALIGNMENT);
		toolbar3.setAlignmentX(Component.LEFT_ALIGNMENT);
		all.add(first);
		all.add(toolbar3);
		getContentPane().add(all, "North");
		setSize(400, 300);
		setVisible(true);
	}

	class OpenAction extends AbstractAction {
		public OpenAction() {
			putValue(AbstractAction.SMALL_ICON, new ImageIcon(CombiningToolbars.class.getResource("open.png")));
		}

		public void actionPerformed(ActionEvent e) {
			// Nothing to do
		}
	}

	class SaveAction extends AbstractAction {
		public SaveAction() {
			putValue(AbstractAction.SMALL_ICON, new ImageIcon(CombiningToolbars.class.getResource("save.png")));
		}

		public void actionPerformed(ActionEvent e) { //
			// Nothing to do
		}
	}

	public static void main(String[] args) {
			new CombiningToolbars();
	}
}
