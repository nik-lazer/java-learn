package lan.test.zk.constraint;

import lan.test.zk.util.ClientUtil;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.CustomConstraint;

/**
 * Validator for find dialog with custom popup notification
 * @author nik-lazer  06.02.2015   16:15
 */
public class PopupNoEmptyConstraint implements Constraint, CustomConstraint {
	public void validate(Component comp, Object value) throws WrongValueException {
		if (value != null && ((String)value).isEmpty()) {
			throw new WrongValueException(comp, "Value must be not empty");
		}
	}

	public void showCustomError(Component comp, WrongValueException ex) {
		if ((comp != null) && (ex != null)) {
			ClientUtil.showPointerPopup(comp, "Error!", "Find next button clicked!", ex.getMessage(), null);
		}
	}
}
