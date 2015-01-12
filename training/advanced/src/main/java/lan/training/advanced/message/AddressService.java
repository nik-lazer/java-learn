package lan.training.advanced.message;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple address service for message system. Use {@link java.lang.Class} as key for recipient
 * @author nik-lazer  29.12.2014   13:47
 */
public class AddressService {
	private Map<Recipients, Address> addressMap = new HashMap<>();

	public void addAdress(Recipients key, Address address) {
		addressMap.put(key, address);
	}

	public Address getAddress(Recipients key) {
		return addressMap.get(key);
	}
}
