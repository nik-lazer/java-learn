package lan.test.zk.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

import java.util.Map;

/**
 * Event for {@link lan.test.zk.component.IteratorListbox} component
 * @author nik-lazer 11.03.2015   21.24
 */
public class IteratorSizeEvent extends Event {
	private static final Log log = LogFactory.getLog(IteratorSizeEvent.class);

	public static final String NAME = "onIteratorSize";

	private String width;

	private IteratorSizeEvent(String name, Component target, String width) {
		super(name, target);
		this.width = width;
	}

	public String getWidth() {
		return width;
	}

	public static IteratorSizeEvent getIteratorSizeEvent(org.zkoss.zk.au.AuRequest request) {
		final Component comp = request.getComponent();
		final Map data = request.getData();
		return new IteratorSizeEvent(request.getCommand(), comp, (String) data.get("width"));
	}
}
