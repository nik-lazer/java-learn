package lan.test.zk.component;

import lan.test.zk.model.RefreshableListModel;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;

/**
 * Override Listbox for fixing ZK-2486
 * @author nik-lazer 08.10.2014   15:49
 */
public class AdvancedListbox extends Listbox {
	/**
	 * Method is overridden for fixing ZK-2486 - it force to render stubonly cells, which was created by
	 * {@link lan.test.zk.renderer.PersonListItemRenderer}. Model must be to able to refresh it's data. So, in this case
	 * it's {@link lan.test.zk.model.RefreshableListModel}
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
