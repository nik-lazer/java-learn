package lan.training.advanced.base;

import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.MessageSystem;
import lan.training.advanced.message.MessageSystemImpl;

/**
 * Frontend interface
 * Created by nik-lazer on 29.12.14.
 */
public interface Frontend extends Abonent {
	public MessageSystem getMessageSystem();
	public void updateUserId(String name, int userId);
}
