package lan.concurrent;

/**
 * Обораяиваемый потоконебезопасный интерфейс
 * @author lazarev_nv 25.12.2013   09:59
 */
interface MyObj {
	void setReady(boolean flag);
	boolean isReady();
}
