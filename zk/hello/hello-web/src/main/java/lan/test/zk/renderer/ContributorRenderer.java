package lan.test.zk.renderer;

import lan.test.zk.domain.Contributor;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Textbox;

/**
 * Renderer for grid in {@link lan.test.zk.composer.IndexComposer}
 * @author nik-lazer  03.04.2015   17:05
 */
public class ContributorRenderer implements RowRenderer<Contributor> {
	public void render(Row row, Contributor data, int index) throws Exception {
		row.appendChild(new Label(data.getLanguage()));
		row.appendChild(new Label(data.getName()));
		row.appendChild(new Label(data.getCharset()));
		row.appendChild(new Textbox());
	}
}
