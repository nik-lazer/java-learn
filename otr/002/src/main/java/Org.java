/**
 * @author Alexey Pobedyonny 28.01.2014
 */
public class Org {
	private long id;
	private int version;
	private String systemName;
	private String name;
	private String externalSystemID;
	private Complex complex;

	public Org() {
	}

	public Org(String systemName, String name) {
		this.systemName = systemName;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExternalSystemID() {
		return externalSystemID;
	}

	public void setExternalSystemID(String externalSystemID) {
		this.externalSystemID = externalSystemID;
	}

	public Complex getComplex() {
		return complex;
	}

	public void setComplex(Complex complex) {
		this.complex = complex;
	}
}
