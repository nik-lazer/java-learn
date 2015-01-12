package lan.training.advanced.message;

import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.AddressService;
import lan.training.advanced.message.Msg;

/**
 * Message system interface
 * Created by nik-lazer on 29.12.14.
 */
public interface MessageSystem {
	public void addService(Recipients key, Abonent abonent);
	public void sendMessage(Msg message);
	public void execForAbonent(Abonent abonent);
	public AddressService getAddressService();
}
