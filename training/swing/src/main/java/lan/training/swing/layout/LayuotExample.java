package lan.training.swing.layout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Layouts example
 * @author nik-lazer 28.10.2014   13:54
 */
public class LayuotExample extends JFrame {

	public static void main(String[] args) {
		new LayuotExample();
	}

	public LayuotExample() {
		super("Layout example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Flow", createFlowPanel());
		tabbedPane.addTab("Border", createBorderPanel());
		tabbedPane.addTab("Grid", createGridPanel());
		tabbedPane.addTab("GridBox", createGridBoxPanel());
		add(tabbedPane);
		pack();
		setVisible(true);
	}

	private JPanel createFlowPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(new JButton("One"));
		panel.add(new JButton("Two"));
		panel.add(new JButton("Three"));
		return panel;
	}

	private JPanel createBorderPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		northPanel.add(new JLabel("North"));
		northPanel.setBorder(BorderFactory.createEtchedBorder());

		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createEtchedBorder());
		centerPanel.add(new JLabel("Center"));

		JPanel southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		southPanel.add(new JLabel("South"));

		JPanel westPanel = new JPanel();
		westPanel.setBorder(BorderFactory.createEtchedBorder());
		westPanel.add(new JLabel("West"));

		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(BorderFactory.createEtchedBorder());
		eastPanel.add(new JLabel("East"));

		panel.add(northPanel, BorderLayout.NORTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(southPanel, BorderLayout.SOUTH);
		panel.add(westPanel, BorderLayout.WEST);
		panel.add(eastPanel, BorderLayout.EAST);
	 	return panel;
	}

	private JPanel createGridPanel() {
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(2, 4, 5, 12);
		panel.setLayout(layout);
		for (int i=0; i<8; i++) {
			panel.add(new JButton("Button " + i));
		}
		return panel;
	}

	private JPanel createGridBoxPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JButton button = new JButton("Button 1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(button, c);

		button = new JButton("Button 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(button, c);

		button = new JButton("Button 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(button, c);

		button = new JButton("Long-Named Button 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(button, c);

		button = new JButton("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;       //third row
		panel.add(button, c);
		return panel;
	}
}