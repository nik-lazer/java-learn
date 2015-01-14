package lan.training.advanced.parser.dom;

import lan.training.advanced.parser.ResourceParser;
import lan.training.advanced.resource.Resource;
import lan.training.advanced.util.ReflectionHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DOM parser for resources
 * @author nik-lazer  14.01.2015   14:06
 */
public class ResourceDomParser implements ResourceParser {
	private static Logger log = Logger.getLogger(ResourceDomParser.class.getName());
	@Override
	public Resource parse(String fileName) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		f.setValidating(false);
		DocumentBuilder builder = null;
		try {
			builder = f.newDocumentBuilder();
			Document doc = builder.parse(fileName);
			return parseDocument(doc);
		} catch (Exception e) {
			log.log(Level.SEVERE, "Resource DOM parsing exception", e);
		}
		return null;
	}

	private Resource parseDocument(Document document) {
		Node node = document.getFirstChild();
		String nodeName = node.getNodeName();
		if ("class".equals(nodeName)) {
			String className = node.getAttributes().getNamedItem("name").getNodeValue();
			Object object = ReflectionHelper.createInstance(className);
			NodeList list = node.getChildNodes();
			for (int i=0; i<list.getLength(); i++) {
				if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Node child = list.item(i);
					ReflectionHelper.setFieldValue(object, child.getNodeName(), child.getFirstChild().getNodeValue());
				}
			}
			return (Resource)object;

		}
		return null;
	}
}
