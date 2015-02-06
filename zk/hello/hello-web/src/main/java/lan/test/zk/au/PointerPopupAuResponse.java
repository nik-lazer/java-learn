package lan.test.zk.au;

import org.zkoss.zk.au.AuResponse;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;

/**
 * Send showPointerPopup command to client
 * @author nik-lazer  05.02.2015   16:07
 */
public class PointerPopupAuResponse extends AuResponse {
	public PointerPopupAuResponse(String title, String msg, String desc, String type, Page page, Component ref,
	                      String position, int duration, boolean closable) {
		super("showPointerPopup", new Object[] {
				title, msg, desc, type, page.getUuid(), ref, position, null, duration, closable });
	}

	/** Shows notification at given coordinate
	 */
	public PointerPopupAuResponse(String title, String msg, String desc, String type, Page page, Component ref,
	                      int x, int y, int duration, boolean closable) {
		super("showPointerPopup", new Object[] {
				title, msg, desc, type, page.getUuid(), ref, null, new int[]{x, y}, duration, closable });
	}
}
