package lan.test.zk.domain;

/**
 * Domain for Contributor
 * @author nik-lazer  03.04.2015   16:52
 */
public class Contributor {
	String language;
	String name;
	String charset;
	String comment;

	public Contributor(String language, String name, String charset) {
		this.language = language;
		this.name = name;
		this.charset = charset;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
