package lan.training.swing.applet;

import javax.swing.*;

/**
 * Hello world applet
 * @author nik-lazer 28.10.2014   12:36
 */
public class HelloWorldApplet extends JApplet {
	//Called when this applet is loaded into the browser.
	public void init() {
		//Execute a job on the event-dispatching thread; creating this applet's GUI.
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					JLabel lbl = new JLabel("Hello World");
					add(lbl);
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't complete successfully");
		}
	}
}
