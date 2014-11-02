package lan.training.swing.dialog;

import javax.swing.*;
import javax.swing.border.Border;
import java.beans.*; //Property change stuff
import java.awt.*;
import java.awt.event.*;

/**
 * Created by nik-lazer on 04.11.14.
 */
public class DialogDemo extends JPanel {
	JLabel label;
	ImageIcon icon = createImageIcon("images/middle.gif");
	JFrame frame;
	String simpleDialogDesc = "Some simple message dialogs";
	String iconDesc = "A JOptionPane has its choice of icons";
	String moreDialogDesc = "Some more dialogs";
	CustomDialog customDialog;

	/**
	 * Creates the GUI shown inside the frame's content pane.
	 */
	public DialogDemo(JFrame frame) {
		super(new BorderLayout());
		this.frame = frame;
		customDialog = new CustomDialog(frame, "geisel", this);
		customDialog.pack();

		//Create the components.
		JPanel frequentPanel = createSimpleDialogBox();
		JPanel featurePanel = createFeatureDialogBox();
		JPanel iconPanel = createIconDialogBox();
		label = new JLabel("Click the \"Show it!\" button to bring up the selected dialog.", JLabel.CENTER);

		//Lay them out.
		Border padding = BorderFactory.createEmptyBorder(20, 20, 5, 20);
		frequentPanel.setBorder(padding);
		featurePanel.setBorder(padding);
		iconPanel.setBorder(padding);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Simple Modal Dialogs", null, frequentPanel, simpleDialogDesc); //tooltip text
		tabbedPane.addTab("More Dialogs", null, featurePanel, moreDialogDesc); //tooltip text
		tabbedPane.addTab("Dialog Icons", null, iconPanel, iconDesc); //tooltip text

		add(tabbedPane, BorderLayout.CENTER);
		add(label, BorderLayout.PAGE_END);
		label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

	/**
	 * Sets the text displayed at the bottom of the frame.
	 */
	void setLabel(String newText) {
		label.setText(newText);
	}

	/**
	 * Returns an ImageIcon, or null if the path was invalid.
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = DialogDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Creates the panel shown by the first tab.
	 */
	private JPanel createSimpleDialogBox() {
		final int numButtons = 4;
		JRadioButton[] radioButtons = new JRadioButton[numButtons];
		final ButtonGroup group = new ButtonGroup();

		radioButtons[0] = new JRadioButton("OK (in the L&F's words)");
		radioButtons[0].setActionCommand(DialogCommand.DEFAULT_MESSAGE_COMMAND.toString());

		radioButtons[1] = new JRadioButton("Yes/No (in the L&F's words)");
		radioButtons[1].setActionCommand(DialogCommand.YES_NO_COMMAND.toString());

		radioButtons[2] = new JRadioButton("Yes/No (in the programmer's words)");
		radioButtons[2].setActionCommand(DialogCommand.YEAH_NAH_COMMAND.toString());

		radioButtons[3] = new JRadioButton("Yes/No/Cancel (in the programmer's words)");
		radioButtons[3].setActionCommand(DialogCommand.YNC_COMMAND.toString());

		for (int i = 0; i < numButtons; i++) {
			group.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);

		JButton showItButton = new JButton("Show it!");
		showItButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();

				//ok dialog
				if (DialogCommand.DEFAULT_MESSAGE_COMMAND.toString().equals(command)) {
					JOptionPane.showMessageDialog(frame, "Eggs aren't supposed to be green.");

					//yes/no dialog
				} else if (DialogCommand.YES_NO_COMMAND.toString().equals(command)) {
					int n = JOptionPane.showConfirmDialog(
							frame, "Would you like green eggs and ham?",
							"An Inane Question",
							JOptionPane.YES_NO_OPTION);
					if (n == JOptionPane.YES_OPTION) {
						setLabel("Ewww!");
					} else if (n == JOptionPane.NO_OPTION) {
						setLabel("Me neither!");
					} else {
						setLabel("Come on -- tell me!");
					}

					//yes/no (not in those words)
				} else if (DialogCommand.YEAH_NAH_COMMAND.toString().equals(command)) {
					Object[] options = {"Yes, please", "No way!"};
					int n = JOptionPane.showOptionDialog(frame,
							"Would you like green eggs and ham?",
							"A Silly Question",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[0]);
					if (n == JOptionPane.YES_OPTION) {
						setLabel("You're kidding!");
					} else if (n == JOptionPane.NO_OPTION) {
						setLabel("I don't like them, either.");
					} else {
						setLabel("Come on -- 'fess up!");
					}

					//yes/no/cancel (not in those words)
				} else if (DialogCommand.YNC_COMMAND.toString().equals(command)) {
					Object[] options = {"Yes, please",
							"No, thanks",
							"No eggs, no ham!"};
					int n = JOptionPane.showOptionDialog(frame,
							"Would you like some green eggs to go with that ham?",
							"A Silly Question",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[2]);
					if (n == JOptionPane.YES_OPTION) {
						setLabel("Here you go: green eggs and ham!");
					} else if (n == JOptionPane.NO_OPTION) {
						setLabel("OK, just the ham, then.");
					} else if (n == JOptionPane.CANCEL_OPTION) {
						setLabel("Well, I'm certainly not going to eat them!");
					} else {
						setLabel("Please tell me what you want!");
					}
				}
			}
		});

		return createPane(simpleDialogDesc + ":", radioButtons, showItButton);
	}

	/**
	 * Used by createSimpleDialogBox and createFeatureDialogBox
	 * to create a pane containing a description, a single column
	 * of radio buttons, and the Show it! button.
	 */
	private JPanel createPane(String description,
							  JRadioButton[] radioButtons,
							  JButton showButton) {

		JPanel box = new JPanel();
		JLabel label = new JLabel(description);

		box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
		box.add(label);

		for (JRadioButton radioButton : radioButtons) {
			box.add(radioButton);
		}

		JPanel pane = new JPanel(new BorderLayout());
		pane.add(box, BorderLayout.PAGE_START);
		pane.add(showButton, BorderLayout.PAGE_END);
		return pane;
	}

	/**
	 * Like createPane, but creates a pane with 2 columns of radio
	 * buttons.  The number of buttons passed in *must* be even.
	 */
	private JPanel create2ColPane(String description,
								  JRadioButton[] radioButtons,
								  JButton showButton) {
		JLabel label = new JLabel(description);
		int numPerColumn = radioButtons.length / 2;

		JPanel grid = new JPanel(new GridLayout(0, 2));
		for (int i = 0; i < numPerColumn; i++) {
			grid.add(radioButtons[i]);
			grid.add(radioButtons[i + numPerColumn]);
		}

		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
		box.add(label);
		grid.setAlignmentX(0.0f);
		box.add(grid);

		JPanel pane = new JPanel(new BorderLayout());
		pane.add(box, BorderLayout.PAGE_START);
		pane.add(showButton, BorderLayout.PAGE_END);

		return pane;
	}

	/*
	 * Creates the panel shown by the 3rd tab.
	 * These dialogs are implemented using showMessageDialog, but
	 * you can specify the icon (using similar code) for any other
	 * kind of dialog, as well.
	 */
	private JPanel createIconDialogBox() {
		final int numButtons = 6;
		JRadioButton[] radioButtons = new JRadioButton[numButtons];
		final ButtonGroup group = new ButtonGroup();

		radioButtons[0] = new JRadioButton("Plain (no icon)");
		radioButtons[0].setActionCommand(DialogCommand.PLAIN_COMMAND.toString());

		radioButtons[1] = new JRadioButton("Information icon");
		radioButtons[1].setActionCommand(DialogCommand.INFO_COMMAND.toString());

		radioButtons[2] = new JRadioButton("Question icon");
		radioButtons[2].setActionCommand(DialogCommand.QUESTION_COMMAND.toString());

		radioButtons[3] = new JRadioButton("Error icon");
		radioButtons[3].setActionCommand(DialogCommand.ERROR_COMMAND.toString());

		radioButtons[4] = new JRadioButton("Warning icon");
		radioButtons[4].setActionCommand(DialogCommand.WARNING_COMMAND.toString());

		radioButtons[5] = new JRadioButton("Custom icon");
		radioButtons[5].setActionCommand(DialogCommand.CUSTOM_COMMAND.toString());

		for (int i = 0; i < numButtons; i++) {
			group.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);

		JButton showItButton = new JButton("Show it!");
		showItButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();

				//no icon
				if (DialogCommand.PLAIN_COMMAND.toString().equals(command)) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"A plain message",
							JOptionPane.PLAIN_MESSAGE);
					//information icon
				} else if (DialogCommand.INFO_COMMAND.toString().equals(command)) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"Inane informational dialog",
							JOptionPane.INFORMATION_MESSAGE);

					//XXX: It doesn't make sense to make a question with
					//XXX: only one button.
					//XXX: See "Yes/No (but not in those words)" for a better solution.
					//question icon
				} else if (DialogCommand.QUESTION_COMMAND.toString().equals(command)) {
					JOptionPane.showMessageDialog(frame,
							"You shouldn't use a message dialog "
									+ "(like this)\n"
									+ "for a question, OK?",
							"Inane question",
							JOptionPane.QUESTION_MESSAGE);
					//error icon
				} else if (DialogCommand.ERROR_COMMAND.toString().equals(command)) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"Inane error",
							JOptionPane.ERROR_MESSAGE);
					//warning icon
				} else if (DialogCommand.WARNING_COMMAND.toString().equals(command)) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
					//custom icon
				} else if (DialogCommand.CUSTOM_COMMAND.toString().equals(command)) {
					JOptionPane.showMessageDialog(frame,
							"Eggs aren't supposed to be green.",
							"Inane custom dialog",
							JOptionPane.INFORMATION_MESSAGE,
							icon);
				}
			}
		});

		return create2ColPane(iconDesc + ":", radioButtons, showItButton);
	}

	/**
	 * Creates the panel shown by the second tab.
	 */
	private JPanel createFeatureDialogBox() {
		final int numButtons = 5;
		JRadioButton[] radioButtons = new JRadioButton[numButtons];
		final ButtonGroup group = new ButtonGroup();

		radioButtons[0] = new JRadioButton("Pick one of several choices");
		radioButtons[0].setActionCommand(DialogCommand.PICK_ONE_COMMAND.toString());

		radioButtons[1] = new JRadioButton("Enter some text");
		radioButtons[1].setActionCommand(DialogCommand.TEXT_ENTERED_COMMAND.toString());

		radioButtons[2] = new JRadioButton("Non-auto-closing dialog");
		radioButtons[2].setActionCommand(DialogCommand.NON_AUTO_COMMAND.toString());

		radioButtons[3] = new JRadioButton("Input-validating dialog (with custom message area)");
		radioButtons[3].setActionCommand(DialogCommand.CUSTOM_OPTION_COMMAND.toString());

		radioButtons[4] = new JRadioButton("Non-modal dialog");
		radioButtons[4].setActionCommand(DialogCommand.NON_MODAL_COMMAND.toString());

		for (int i = 0; i < numButtons; i++) {
			group.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);

		JButton showItButton = new JButton("Show it!");
		showItButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();

				//pick one of many
				if (DialogCommand.PICK_ONE_COMMAND.toString().equals(command)) {
					Object[] possibilities = {"ham", "spam", "yam"};
					String s = (String) JOptionPane.showInputDialog(
							frame,
							"Complete the sentence:\n\"Green eggs and...\"",
							"Customized Dialog",
							JOptionPane.PLAIN_MESSAGE,
							icon,
							possibilities,
							"ham");

					//If a string was returned, say so.
					if ((s != null) && (s.length() > 0)) {
						setLabel("Green eggs and... " + s + "!");
						return;
					}

					//If you're here, the return value was null/empty.
					setLabel("Come on, finish the sentence!");

					//text input
				} else if (DialogCommand.TEXT_ENTERED_COMMAND.toString().equals(command)) {
					String s = (String) JOptionPane.showInputDialog(
							frame,
							"Complete the sentence:\n\"Green eggs and...\"",
							"Customized Dialog",
							JOptionPane.PLAIN_MESSAGE,
							icon,
							null,
							"ham");

					//If a string was returned, say so.
					if ((s != null) && (s.length() > 0)) {
						setLabel("Green eggs and... " + s + "!");
						return;
					}

					//If you're here, the return value was null/empty.
					setLabel("Come on, finish the sentence!");

					//non-auto-closing dialog
				} else if (DialogCommand.NON_AUTO_COMMAND.toString().equals(command)) {
					final JOptionPane optionPane = new JOptionPane(
							"The only way to close this dialog is by\n"
									+ "pressing one of the following buttons.\n"
									+ "Do you understand?",
							JOptionPane.QUESTION_MESSAGE,
							JOptionPane.YES_NO_OPTION);

					//You can't use pane.createDialog() because that
					//method sets up the JDialog with a property change
					//listener that automatically closes the window
					//when a button is clicked.
					final JDialog dialog = new JDialog(frame, "Click a button", true);
					dialog.setContentPane(optionPane);
					dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
					dialog.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							setLabel("Thwarted user attempt to close window.");
						}
					});
					optionPane.addPropertyChangeListener(
							new PropertyChangeListener() {
								public void propertyChange(PropertyChangeEvent e) {
									String prop = e.getPropertyName();

									if (dialog.isVisible()
											&& (e.getSource() == optionPane)
											&& (JOptionPane.VALUE_PROPERTY.equals(prop))) {
										//If you were going to check something
										//before closing the window, you'd do
										//it here.
										dialog.setVisible(false);
									}
								}
							});
					dialog.pack();
					dialog.setLocationRelativeTo(frame);
					dialog.setVisible(true);

					int value = (Integer) optionPane.getValue();
					if (value == JOptionPane.YES_OPTION) {
						setLabel("Good.");
					} else if (value == JOptionPane.NO_OPTION) {
						setLabel("Try using the window decorations "
								+ "to close the non-auto-closing dialog. "
								+ "You can't!");
					} else {
						setLabel("Window unavoidably closed (ESC?).");
					}

					//non-auto-closing dialog with custom message area
					//NOTE: if you don't intend to check the input,
					//then just use showInputDialog instead.
				} else if (DialogCommand.CUSTOM_OPTION_COMMAND.toString().equals(command)) {
					customDialog.setLocationRelativeTo(frame);
					customDialog.setVisible(true);

					String s = customDialog.getValidatedText();
					if (s != null) {
						//The text is valid.
						setLabel("Congratulations!  You entered \"" + s + "\".");
					}

					//non-modal dialog
				} else if (DialogCommand.NON_MODAL_COMMAND.toString().equals(command)) {
					//Create the dialog.
					final JDialog dialog = new JDialog(frame, "A Non-Modal Dialog");

					//Add contents to it. It must have a close button,
					//since some L&Fs (notably Java/Metal) don't provide one
					//in the window decorations for dialogs.
					JLabel label = new JLabel("<html><p align=center>"
							+ "This is a non-modal dialog.<br>"
							+ "You can have one or more of these up<br>"
							+ "and still use the main window.");
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setFont(label.getFont().deriveFont(Font.PLAIN, 14.0f));

					JButton closeButton = new JButton("Close");
					closeButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dialog.setVisible(false);
							dialog.dispose();
						}
					});
					JPanel closePanel = new JPanel();
					closePanel.setLayout(new BoxLayout(closePanel,
							BoxLayout.LINE_AXIS));
					closePanel.add(Box.createHorizontalGlue());
					closePanel.add(closeButton);
					closePanel.setBorder(BorderFactory.
							createEmptyBorder(0, 0, 5, 5));

					JPanel contentPane = new JPanel(new BorderLayout());
					contentPane.add(label, BorderLayout.CENTER);
					contentPane.add(closePanel, BorderLayout.PAGE_END);
					contentPane.setOpaque(true);
					dialog.setContentPane(contentPane);

					//Show it.
					dialog.setSize(new Dimension(300, 150));
					dialog.setLocationRelativeTo(frame);
					dialog.setVisible(true);
				}
			}
		});

		return createPane(moreDialogDesc + ":", radioButtons, showItButton);
	}

	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("DialogDemo");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		DialogDemo newContentPane = new DialogDemo(frame);
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
