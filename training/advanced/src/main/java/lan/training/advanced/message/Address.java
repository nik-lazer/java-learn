package lan.training.advanced.message;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Address for message system
 * @author nik-lazer  29.12.2014   12:14
 */
public class Address {
	static private AtomicInteger abonentCreator = new AtomicInteger();
	private final int abonentId;

	public Address() {
		this.abonentId = abonentCreator.incrementAndGet();
	}

	@Override
	public int hashCode() {
		return abonentId;
	}

	@Override
	public String toString() {
		return "abonentId=" + abonentId;
	}
}
