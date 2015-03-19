package lan.test.zk.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.lang.Objects;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.Textbox;

import java.io.IOException;

/**
 * It has custom main tooltip. If main tooltip is empty, component use value for title
 * @author nik-lazer 19.03.2015   20.58
 */
public class ExtendedTextbox extends Textbox {
	private static final Log log = LogFactory.getLog(ExtendedTextbox.class);

	String mainTooltip;

	public ExtendedTextbox() {
		addEventListener(Events.ON_CHANGE, new SerializableEventListener<Event>() {
			public void onEvent(Event event) throws Exception {
				setTooltiptext(getTooltip());
			}
		});
	}

	@Override
	protected void renderProperties(ContentRenderer renderer) throws IOException {
		super.renderProperties(renderer);
		render(renderer, "zclass", getZclass());
	}

	public String getMainTooltip() {
		return mainTooltip;
	}

	public void setMainTooltip(String mainTooltip) {
		if (!Objects.equals(getMainTooltip(), mainTooltip)) {
			this.mainTooltip = mainTooltip;
			setTooltiptext(getTooltip());
		}
	}

	public String getTooltip() {
		if (mainTooltip != null && !mainTooltip.isEmpty()) {
			return mainTooltip;
		} else {
			return getValue();
		}
	}

	@Override
	public String getZclass() {
		return super.getZclass();
	}

	@Override
	public void setText(String value) throws WrongValueException {
		String val = getValue();
		super.setText(value);
		if (!Objects.equals(_value, val)) {
			setTooltiptext(getTooltip());
		}
	}
}
