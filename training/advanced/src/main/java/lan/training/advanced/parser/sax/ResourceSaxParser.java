package lan.training.advanced.parser.sax;

import lan.training.advanced.util.ReflectionHelper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.logging.Logger;

/**
 * SAX parser for resources
 * @author nik-lazer  14.01.2015   12:17
 */
public class ResourceSaxParser extends DefaultHandler {
	private static Logger log = Logger.getLogger(ResourceSaxParser.class.getName());

	private static String CLASSNAME = "class";
	private String element = null;
	private Object object = null;
	@Override
	public void startDocument() throws SAXException {
		log.fine("start document");
	}

	@Override
	public void endDocument() throws SAXException {
		log.fine("end document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName != CLASSNAME){
			element = qName;
		}
		else{
			String className = attributes.getValue(0);
			log.fine("Class name: " + className);
			object = ReflectionHelper.createInstance(className);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		element = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(element != null){
			String value = new String(ch, start, length);
			log.fine(element + " = " + value);
			ReflectionHelper.setFieldValue(object, element, value);
		}
	}

	public Object getObject(){
		return object;
	}
}
