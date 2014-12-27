package lan.test.zk.composer;

import lan.test.zk.util.CookieUtil;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.metainfo.EventHandler;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.South;
import org.zkoss.zul.Window;

import java.util.logging.Logger;

/**
 * Composer for using {@link org.zkoss.zul.Borderlayout} splittable feature
 * @author nik-lazer  27.12.2014   13:31
 */
public class BorderlayoutComposer extends SelectorComposer<Window> {
	private static Logger log = Logger.getLogger(BorderlayoutComposer.class.getName());
	private static final String SIZE_COOKIE_NAME = "southSize";
	@Wire
	Borderlayout main;
	@Wire
	Center mainCenter;
	@Wire
	South mainSouth;

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		String userSize = CookieUtil.getCookie(SIZE_COOKIE_NAME);
		if (userSize != null) {
			mainSouth.setSize(userSize);
		}
		mainSouth.addEventListener("onSize", new EventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				handleSize();
			}
		});
	}

	public void handleSize() {
		String size = mainSouth.getSize();
		CookieUtil.setCookie(SIZE_COOKIE_NAME, size);
		log.info("Setting south size = " + size);
	}
}
