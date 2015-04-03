package lan.test.zk.model;

import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.event.ListDataEvent;

import java.util.Collection;
import java.util.List;

/**
 * Model for {@link org.zkoss.zul.Listbox} with public refresh opportunity
 * @author nik-lazer 29.08.2014   12:07
 */
public class RefreshableListModel<E> extends ListModelList<E> {
	public RefreshableListModel(Collection<? extends E> c) {
		super(c);
	}

	public void refresh() {
		fireEvent(ListDataEvent.CONTENTS_CHANGED, -1, -1);
	}

	public void updateData(List<E> data) {
		super.clear();
		super.addAll(data);
		fireEvent(ListDataEvent.CONTENTS_CHANGED, -1, -1);
	}
}
