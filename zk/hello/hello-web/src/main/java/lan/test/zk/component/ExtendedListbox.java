package lan.test.zk.component;

import org.zkoss.lang.Library;
import org.zkoss.zul.Listbox;

/**
 * Extension  {@link org.zkoss.zul.Listbox}, to ability change property checkmarkDeselectOthers for current component instead
 * of uding global zk-configuration property org.zkoss.zul.listbox.checkmarkDeselectOthers
 * @author nik-lazer 09.07.2014   12:43
 */
public class ExtendedListbox extends Listbox {
	private Boolean checkmarkDeselectOther = false;

	public ExtendedListbox() {
		super();
	}

	public ExtendedListbox(boolean checkmarkDeselectOther) {
		super();
		setCheckmarkDeselectOther(checkmarkDeselectOther);
	}

	private boolean isCheckmarkDeselectOther() {
		return checkmarkDeselectOther;
	}

	public void setCheckmarkDeselectOther(Boolean checkmarkDeselectOther) {
		this.checkmarkDeselectOther = checkmarkDeselectOther;
	}

	protected void renderProperties(org.zkoss.zk.ui.sys.ContentRenderer renderer)
			throws java.io.IOException {
		super.renderProperties(renderer);
		renderer.render("_cdo", checkmarkDeselectOther);
	}
}
