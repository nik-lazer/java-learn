package lan.test.zk.portlet;

import org.zkoss.lang.Library;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.sys.PageCtrl;
import org.zkoss.zul.impl.PageRenderer;

import java.io.IOException;
import java.io.Writer;

/**
 * Custom page renderer trying
 * @author nik-lazer 21.07.2014   09:06
 */
public class PortletPageRenderer extends PageRenderer {
	/** Renders the desktop and the page.
	 */
	protected
	void renderDesktop(Execution exec, Page page, Writer out)
			throws IOException {
		PortletHtmlPageRenders.setContentType(exec, page);

		final PageCtrl pageCtrl = (PageCtrl)page;
		write(out, PortletHtmlPageRenders.outFirstLine(exec, page)); //might null
		write(out, PortletHtmlPageRenders.outDocType(exec, page)); //might null
		Double number = exec.getBrowser("mobile");

		out.write("<html");
		if (number == null || number.intValue() == 0) {
			Double ie = exec.getBrowser("ie");
			// let ie <= 8 support VML on javascript
			if (ie != null && ie < 9)
				out.write(" xmlns:v=\"urn:schemas-microsft.com:vml\"");

			write(out, pageCtrl.getRootAttributes());
			out.write(">\n<head>\n"
			          // B70-ZK-2065: Remove meta for validation.
			          //	+ "<meta http-equiv=\"Pragma\" content=\"no-cache\" />\n"
			          //	+ "<meta http-equiv=\"Expires\" content=\"-1\" />\n"
			          + "<title>");
		} else {
			write(out, pageCtrl.getRootAttributes());
			out.write(">\n<head>\n");
			// B70-ZK-2065: Remove meta for validation.
			//	+ "<meta http-equiv=\"Pragma\" content=\"no-cache\" />\n"
			//	+ "<meta http-equiv=\"Expires\" content=\"-1\" />\n");

			String viewport = page.getViewport();
			if (!"auto".equals(viewport))
				out.write("<meta name=\"viewport\" content=\"" + viewport + "\" > \n");
			else if (!"true".equals(Library.getProperty("org.zkoss.zul.tablet.meta.viewport.disabled", "false")))
				out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" > \n");

			out.write("<title>");
		}
		write(out, page.getTitle());
		out.write("</title>\n");
		outHeaders(exec, page, out);
		out.write("</head>\n");

		out.write("<body>\n");
		PortletHtmlPageRenders.outPageContent(exec, page, out, false);
		writeln(out, PortletHtmlPageRenders.outUnavailable(exec));
		out.write("\n</body>\n</html>\n");
	}

	private static void outHeaders(Execution exec, Page page, Writer out)
			throws IOException {
		out.write(PortletHtmlPageRenders.outHeaders(exec, page, true));
		out.write(PortletHtmlPageRenders.outLangStyleSheets(exec, null, null));
		out.write(PortletHtmlPageRenders.outLangJavaScripts(exec, null, null));
		out.write(PortletHtmlPageRenders.outHeaders(exec, page, false));
	}
	private static void write(Writer out, String s) throws IOException {
		if (s != null) out.write(s);
	}
	private static void writeln(Writer out, String s) throws IOException {
		if (s != null) {
			out.write(s);
			out.write('\n');
		}
	}

}
