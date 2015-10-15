package lan.training.concurrent.task;

import lan.training.concurrent.task.MyObj;

/**
 * {@link lan.concurrent.task.MyObj} implementation
 * @author nik-lazer 25.12.2013   10:02
 */
public class MyObjImpl implements MyObj {
	private boolean ready = false;

	@Override
	public void setReady(boolean flag) {
		ready = flag;
	}

	@Override
	public boolean isReady() {
		return ready;
	}
}
