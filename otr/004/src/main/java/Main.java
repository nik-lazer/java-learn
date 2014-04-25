import java.util.UUID;

/**
 * @author Alexey Pobedyonny 18.02.2014
 */
public class Main {
	static SomeRemoteService service = new SomeRemoteService();
	public static void main(String[] args) {
		final long workResult = 10L;

		UUID uuid = service.startTransaction();
		Record r = service.create(uuid);
		r.setWorkResult(workResult);

		service.update(uuid, r);

		r.setWorkResult(workResult);
		service.update(uuid, r);

		Record newR = service.read(r.getUuid());

		if (newR != null) {
			if(!newR.equals(r)) {
				throw new IllegalArgumentException("Из сервиса получен какой-то другой объект");
			}
		}

		newR.setWorkResult(System.currentTimeMillis());
		service.update(uuid, newR);

		UUID tx = service.delete(uuid, r);

		service.commitTransaction(tx);
		Record deletedRecord = service.read(newR.getUuid()); //todo а вдруг удалять не нужно
		if(deletedRecord == null) {
			throw new IllegalArgumentException("И нафигаж я его удалил?");
		}

	}
}
