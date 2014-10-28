package lan.training.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nik-lazer on 29.10.14.
 */
public class TextOutput extends JFrame {
	public static void main(String[] args) {
		new TextOutput();
	}

	public TextOutput() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		JLabel sLabel = new JLabel("simple label");
		JLabel htmlLabel = new JLabel("<html><font size=4 color=blue><ul>List:<li>One<li>Two</ul></font></html>");
		JButton button = new JButton("ToolTip");
		button.setToolTipText("This is tooltip for button");
		jPanel.add(sLabel);
		jPanel.add(htmlLabel);
		jPanel.add(button);
		add(jPanel);
		pack();
		setVisible(true);
	}
}
