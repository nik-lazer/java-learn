package lan.training.advanced.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Helper for delays
 * Created by nik-lazer on 30.12.14.
 */
public class TimeHelper {
	private static Logger log = Logger.getLogger(TimeHelper.class.getName());
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			log.log(Level.WARNING, "TimeHelper was interrupted", e);
		}
	}
}
