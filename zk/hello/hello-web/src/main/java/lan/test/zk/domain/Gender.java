package lan.test.zk.domain;

/**
 * TODO: comment
 * @author lazarev.nikolay 25.08.2014   10:30
 */
public enum Gender {
	MALE("m"),
	FEMALE("f");

	private String title;

	Gender(String title) {
		this.title = title;
	}

	public String toString() {
		return title;
	}

	public String getTitle() {
		return title;
	}
}
