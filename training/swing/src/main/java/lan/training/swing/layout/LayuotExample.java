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
		tabbedPane.addTab("Spring", createSpringPanel());
		tabbedPane.addTab("Box", createBoxPanel());
		add(tabbedPane);
		pack();
		setVisible(true);
	}

	private Component createBoxPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEtchedBorder());

		addAButton("Button 1", panel);
		addAButton("Button 2", panel);
		addAButton("Button 3", panel, Component.LEFT_ALIGNMENT);
		addAButton("Long-Named Button 4", panel);
		addAButton("5", panel, Component.RIGHT_ALIGNMENT);
		return panel;
	}

	private void addAButton(String text, Container container) {
		addAButton(text, container, Component.CENTER_ALIGNMENT);
	}

	private void addAButton(String text, Container container, float alignment) {
		JButton button = new JButton(text);
		button.setAlignmentX(alignment);
		container.add(button);
	}

	private Component createSpringPanel() {
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);

		//Create and add the components.
		JLabel label = new JLabel("Label: ");
		JTextField textField = new JTextField("Text field", 15);
		panel.add(label);
		panel.add(textField);

		//Adjust constraints for the label so it's at (5,5).
		layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, panel);

		//Adjust constraints for the text field so it's at
		//(<label's right edge> + 5, 5).
		layout.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, textField, 5, SpringLayout.NORTH, panel);

		//Adjust constraints for the content pane: Its right
		//edge should be 5 pixels beyond the text field's right
		//edge, and its bottom edge should be 5 pixels beyond
		//the bottom edge of the tallest component (which we'll
		//assume is textField).
		layout.putConstraint(SpringLayout.EAST, panel, 5, SpringLayout.EAST, textField);
		layout.putConstraint(SpringLayout.SOUTH, panel, 5, SpringLayout.SOUTH, textField);
		return panel;
	}

	private JPanel createFlowPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
		panel.add(new JButton("One"));
		panel.add(new JButton("Two"));
		panel.add(new JButton("Three"));
		panel.add(new JButton("Four"));
		panel.add(new JButton("Five"));
		panel.add(new JButton("Six"));
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