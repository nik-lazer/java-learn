package lan.test.zk.composer;

import lan.test.zk.model.PersonGroupModel;
import lan.test.zk.renderer.PersonGroupsRenderer;
import lan.test.zk.util.DataUtil;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Window;

/**
 * composer to manage grid with groups
 * @author nik-lazer  30.12.2014   17:55
 */
public class GroupsComposer extends SelectorComposer<Window> {
	@Wire
	private Grid grid;
	private PersonGroupModel model;

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		model = new PersonGroupModel(DataUtil.getPersons());
		grid.setModel(model);
		grid.setRowRenderer(new PersonGroupsRenderer());
	}
}
