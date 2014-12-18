package lan.test.zk.composer;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

import java.util.Arrays;
import java.util.List;

/**
 * Composer for listbox behaivior testing
 * @author nik-lazer 09.07.2014   11:30
 */
public class ListBoxComposer extends SelectorComposer<Window> {
	private Listbox table;
	//public ListTest() {
	//}

	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		table =  (Listbox)comp.getFellow("table");
		comp.setSizable(true);
		comp.setTitle("Test");
		List<String> columns = Arrays.asList("eine", "zwei", "drei", "vier");
		final ListModelList tableModel = new ListModelList(columns);
		tableModel.setMultiple(true);
		table.setModel(tableModel);

		for (int i = 0; i < columns.size(); i++) {
			final Listitem listitem = table.getItemAtIndex(i);
			listitem.setSclass("draggable-listitem");
			listitem.setLabel(columns.get(i));
			listitem.setValue(i);
			listitem.setSelected(true);
			listitem.setWidgetOverride("getDragMessage_", "function(){return null;}");
			listitem.setDraggable("true");
			listitem.setDroppable("true");
		}
	}
}
