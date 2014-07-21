package lan.test.zk;

import org.zkoss.lang.Library;
import org.zkoss.zul.Listbox;

/**
 * Расширение  {@link org.zkoss.zul.Listbox}, позводяющая управлять свойством checkmarkDeselectOthers не глобально через
 * параметр конфигурации org.zkoss.zul.listbox.checkmarkDeselectOthers, а индивидуально для каждого компонента
 * @author lazarev_nv 09.07.2014   12:43
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
