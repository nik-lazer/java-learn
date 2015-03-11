package lan.test.zk.component;

import lan.test.zk.event.IteratorSizeEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listbox;

/**
 * Component with managed client-side width calculation
 * @author nik-lazer 11.03.2015   19.15
 */
public class IteratorListbox extends Listbox {
	private static final Log log = LogFactory.getLog(IteratorListbox.class);

	@Override
	public void service(org.zkoss.zk.au.AuRequest request, boolean everError) {
		final String cmd = request.getCommand();
		if (cmd.equals(IteratorSizeEvent.NAME)) {
			IteratorSizeEvent evt = IteratorSizeEvent.getIteratorSizeEvent(request);
			Events.postEvent(evt);
		} else {
			super.service(request, everError);
		}
	}
}
