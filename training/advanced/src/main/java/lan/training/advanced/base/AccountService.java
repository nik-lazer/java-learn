package lan.training.advanced.base;

import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.MessageSystem;

/**
 * AccountService interface
 * Created by nik-lazer on 29.12.14.
 */
public interface AccountService extends Abonent {
	public Integer getUserId(String name);
	public MessageSystem getMessageSystem();
}
