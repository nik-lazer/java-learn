package lan.test.zk;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.StubComponent;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ext.Paginal;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Override Listbox for fixing ZK-2486
 * @author nik-lazer 08.10.2014   15:49
 */
public class AdvancedListbox extends Listbox {
	/**
	 * Method is overridden for fixing ZK-2486 - it force to render stubonly cells, which was created by
	 * {@link lan.test.zk.PersonListItemRenderer}. Model must be to able to refresh it's data. So, in this case
	 * it's {@link lan.test.zk.RefreshableListModel}
	 */
	public void onPagingInitRender() {
		ListModel<Object> model = getModel();
		if ((model != null) && (model instanceof RefreshableListModel)) {
			RefreshableListModel<Object> refreshableModel = (RefreshableListModel<Object>) getModel();
			refreshableModel.refresh();
		}
		super.onPagingInitRender();
	}
}
