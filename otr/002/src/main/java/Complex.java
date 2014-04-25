import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexey Pobedyonny 28.01.2014
 */
public class Complex {
	private long id;
	private int version;
	private String systemName;
	private String name;

	private Set<Org> orgs = new HashSet<Org>();

	public Complex() {
	}

	public Complex(String systemName,String name) {
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

	public Set<Org> getOrgs() {
		return orgs;
	}

	public void setOrgs(Set<Org> orgs) {
		this.orgs = orgs;
	}
}
