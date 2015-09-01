package lan.learn.basic;

/**
 * Example for equals and hashCode methods
 * @author nik-lazer  31.08.2015   16:37
 */
public class EqualsExample {
	public String s;
	int x;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		EqualsExample that = (EqualsExample) o;

		if (x != that.x) {
			return false;
		}
		if (s != null ? !s.equals(that.s) : that.s != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = s != null ? s.hashCode() : 0;
		result = 31 * result + x;
		return result;
	}
}
