package lan.training.advanced.message;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple address service for message system. Use {@link java.lang.Class} as key for recipient
 * @author nik-lazer  29.12.2014   13:47
 */
public class AddressService {
	private Map<Class, Address> addressMap = new HashMap<>();

	public void addAdress(Class clazz, Address address) {
		addressMap.put(clazz, address);
	}

	public Address getAddress(Class clazz) {
		return addressMap.get(clazz);
	}
}
