package lan.test.zk.component;

import org.zkoss.zk.ui.Page;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.event.ListDataEvent;
import org.zkoss.zul.event.ListDataListener;

/**
 * Demonstates using {@link ListDataListener} to affect to listitems without problems after reattaching listbox
 * @author nik-lazer  13.11.2015   17:36
 */
public class ColoredListbox extends AdvancedListbox {
	private ListDataListener changeModelDataListener;

	@Override
	public void setModel(ListModel<?> model) {
		ListModel<Object> oldModel = getModel();
		if (oldModel != null) {
			oldModel.removeListDataListener(changeModelDataListener);
		}

		super.setModel(model);
		if (model != null) {
			initDataListener();
		}
	}

	/**
	 * After reattaching listbox it's necessary to link custom listner again
	 * @param newpage
	 * @param oldpage
	 */
	public void onPageAttached(Page newpage, Page oldpage) {
		super.onPageAttached(newpage, oldpage);
		if ((getModel() != null) && (changeModelDataListener != null)) {
			getModel().removeListDataListener(changeModelDataListener);;
			getModel().addListDataListener(changeModelDataListener);
		}
	}

	/**
	 * It's necessary to remove custom listener after removing listbox from component's structure
	 * beacuse it mustn't call before Listbox's listner when listitems hasn't been rendnered yet
	 * @param page
	 */
	public void onPageDetached(Page page) {
		super.onPageDetached(page);
		if ((getModel() != null) && (changeModelDataListener != null)) {
			getModel().removeListDataListener(changeModelDataListener);;
		}
	}


	private void initDataListener() {
		if (changeModelDataListener == null) {
			changeModelDataListener = new ColorListDataListener();
		}
		if (getItems() != null) {
			getModel().addListDataListener(changeModelDataListener);
		}
	}

	private class ColorListDataListener implements ListDataListener {
		public void onChange(ListDataEvent event) {
			int type = event.getType();
			int index0 = event.getIndex0();
			int index1 = event.getIndex1();

			if (index0 < 0 || index1 < 0) {
				return;
			}

			for (int i = index0; i <= event.getIndex1(); i++) {
				Listitem listitem = getItemAtIndex(i);
				String style = listitem.getStyle();
				StringBuilder str = new StringBuilder();
				if (type == ListDataEvent.INTERVAL_ADDED) {
					str.append("color: green;");
				} else if (type == ListDataEvent.CONTENTS_CHANGED) {
					str.append("color: blue;");
				}
				listitem.setStyle(str.toString());
			}
		}
	}

}
