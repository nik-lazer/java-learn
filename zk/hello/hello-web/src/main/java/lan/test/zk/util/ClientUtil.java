package lan.test.zk.util;

import lan.test.zk.au.PointerPopupAuResponse;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.sys.ExecutionCtrl;
import org.zkoss.zk.ui.util.Clients;

/**
 * Helper for calling client widgets
 * @author nik-lazer  06.02.2015   16:21
 */
public class ClientUtil {
	public static void showPointerPopup(Component component, String title, String msg, String desc, String type) {
		Execution exec = Executions.getCurrent();
		Page page = component != null ? component.getPage() : null;
		if (page == null && exec instanceof ExecutionCtrl)
			page = ((ExecutionCtrl) exec).getCurrentPage();
		if (type == null)
			type = Clients.NOTIFICATION_TYPE_INFO;
		Clients.response(new PointerPopupAuResponse(title, msg, desc, type, page, component, "after_start", 0, false));
	}
}
