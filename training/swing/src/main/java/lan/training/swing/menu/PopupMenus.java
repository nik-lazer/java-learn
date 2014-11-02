package lan.training.swing.menu;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * {@link JPopupMenu} using example
 * Created by nik-lazer on 03.11.14.
 */
public class PopupMenus extends JFrame {
	private JPopupMenu popup;

	public PopupMenus() {
		super("PopupMenus");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		popup = createPopupMenu();
		addMouseListener(new ML());
		setSize(300, 200);
		setVisible(true);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu pm = new JPopupMenu();
		JMenuItem good = new JMenuItem("good");
		JMenuItem excellent = new JMenuItem("excellent");
		pm.add(good);
		pm.add(excellent);
		return pm;
	}

	class ML extends MouseAdapter {
		public void mouseClicked(MouseEvent me) {
			if (SwingUtilities.isRightMouseButton(me)) {
				popup.show(getContentPane(), me.getX(), me.getY());
			}
		}
	}

	public static void main(String[] args) {
		new PopupMenus();
	}
}
