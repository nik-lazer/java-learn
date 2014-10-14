package lan.concurrent;

/**
 * Тест - запускаем два треда, ждем 10 секунд и разблокируем ресурс
 * @author lazarev_nv 25.12.2013   10:15
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Main started");
		Wrapper wrapper = new Wrapper();
		Worker worker1 = new Worker("qq1", wrapper);
		Worker worker2 = new Worker("qq2", wrapper);
		worker1.start();
		worker2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wrapper.setReady(true);
		System.out.println("Main finished");
	}
}
