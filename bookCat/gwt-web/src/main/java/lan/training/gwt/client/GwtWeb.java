package lan.training.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import lan.training.gwt.client.ui.GridPanel;
import lan.training.gwt.client.ui.TreePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtWeb implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
	                                           + "attempting to contact the server. Please check your network "
	                                           + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final BookRemoteServiceAsync bookService = GWT.create(BookRemoteService.class);

	private final Messages messages = GWT.create(Messages.class);

	private TreePanel treePanel;
	private GridPanel gridPanel;


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		DockPanel dockPanel = new DockPanel();
		dockPanel.setWidth("100%");
		dockPanel.setHeight("100%");

		dockPanel.setBorderWidth(5);
		gridPanel = new GridPanel();
		treePanel = new TreePanel(gridPanel);
		dockPanel.add(new Label("north"), DockPanel.NORTH);
		dockPanel.add(treePanel, DockPanel.WEST);
		dockPanel.add(new Label("south"), DockPanel.SOUTH);
		ScrollPanel scroller = new ScrollPanel(gridPanel);
		scroller.setSize("500px", "500px");
		dockPanel.add(scroller, DockPanel.CENTER);

		RootPanel.get().add(dockPanel);

	}
}
