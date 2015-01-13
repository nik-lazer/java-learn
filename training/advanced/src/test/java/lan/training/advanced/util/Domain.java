package lan.training.advanced.util;

/**
 * Test object with private fields for {@link lan.training.advanced.util.ReflectionHelper} testing
 * @author nik-lazer  13.01.2015   11:41
 */
public class Domain {
	private int id;
	private Integer nextId;
	private String name;

	public Domain() {
	}

	public Domain(int id, String name, Integer nextId) {
		this.id = id;
		this.name = name;
		this.nextId = nextId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getNextId() {
		return nextId;
	}
}
