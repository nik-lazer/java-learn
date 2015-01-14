package lan.training.advanced.resource;

import lan.training.advanced.base.VFS;
import lan.training.advanced.parser.sax.ResourceSaxParser;
import lan.training.advanced.vfs.VFSImpl;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.logging.Logger;

/**
 * Factory for xml resources
 * @author nik-lazer  13.01.2015   13:16
 */
public class ResourceFactory {
	private static String BASE_DIR = "data";

	private static ResourceFactory instance = new ResourceFactory(BASE_DIR);
	private static Logger log = Logger.getLogger(ResourceFactory.class.getName());

	private VFS vfs;
	private GMResource gmResource;
	private FrontendResource frontendResource;
	private AccountResource accountResource;

	public static ResourceFactory getInstance() {
		return instance;
	}

	private ResourceFactory(String baseDir) {
		String dir = getClass().getResource(baseDir).getFile();
		vfs = new VFSImpl(dir);
	}

	public static GMResource getGMResource() {
		if (instance.gmResource == null) {
			instance.gmResource = (GMResource) instance.getResource("gm.xml");
		}
		return instance.gmResource;
	}

	public static FrontendResource getFrontendResource() {
		if (instance.frontendResource == null) {
			instance.frontendResource = (FrontendResource) instance.getResource("frontend.xml");
		}
		return instance.frontendResource;
	}

	public static AccountResource getAccountResource() {
		if (instance.accountResource == null) {
			instance.accountResource = (AccountResource) instance.getResource("account.xml");
		}
		return instance.accountResource;
	}

	private Resource getResource(String xmlName) {
		if (vfs.isExist(xmlName)) {
			try {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser = factory.newSAXParser();
				ResourceSaxParser handler = new ResourceSaxParser();
				saxParser.parse(vfs.getAbsolutePath(xmlName), handler);
				return (Resource)handler.getObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			log.severe("Resource " + xmlName + " not exists!");
		}
		return null;
	}
}
