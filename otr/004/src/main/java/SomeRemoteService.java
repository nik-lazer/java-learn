
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CRUD
 * @author Alexey Pobedyonny 18.02.2014
 */
@RemoteService
public class SomeRemoteService {
	Map<UUID, Record> storage = new ConcurrentHashMap<UUID, Record>();
	TxJournal txJournal = new TxJournal(this);

	/**
	 * Создает новую запись
	 * @return вновь созданную запись
	 */
	public
	@NotNull
	Record create(UUID tx) {
		Transaction transaction = txJournal.getTransaction(tx);
		Record r = new Record(UUID.randomUUID(), new Date());
		transaction.addUnit(new UOW(UOW.Action.ADD, r));
		return r;
	}

	/**
	 * Считывает из памяти вновь созданную запись
	 * @param uuid гуид записи
	 * @return считанная запись или null если такой записи нет
	 */
	public
	@Nullable
	Record read(@NotNull UUID uuid) {
		return storage.get(uuid);
	}

	/**
	 * Обновляет запись в памяти или добавляет новую, если такой не было
	 * @param r измененная запись
	 * @return обновленная запись
	 */
	public
	@NotNull
	Record update(UUID tx, Record r) {
		Transaction transaction = txJournal.getTransaction(tx);
		transaction.addUnit(new UOW(UOW.Action.UPDATE, r));
		return r;
	}

	Record innerCreateRecord(Record r) {
		storage.put(r.getUuid(), r);
		return r;
	}

	Record innerUpdateRecord(Record r) {
		Record savedRecord = storage.get(r.getUuid());
		if (savedRecord == null) {
			storage.put(r.getUuid(), r);
			savedRecord = r;
		}
		savedRecord.setWorkResult(r.getWorkResult());
		savedRecord.updateFileData();
		return savedRecord;
	}

	void innerDeleteRecord(Record r) {
		 storage.remove(r.getUuid());
	}

	/**
	 * Удаляет запись
	 * @param r запись для удаления
	 */
	public UUID delete(UUID tx, @NotNull Record r) {
		Transaction transaction = txJournal.getTransaction(tx);
		transaction.addUnit(new UOW(UOW.Action.DELETE, r));
		return null;
	}

	public UUID startTransaction() {
		Transaction transaction = txJournal.getTransaction(null);
		return transaction.getUuid();
	}

	public void commitTransaction(UUID uuid) {
		Transaction transaction = txJournal.getTransaction(uuid);
		transaction.commit();
	}

	public void rollbackTransaction(UUID uuid) {
		Transaction transaction = txJournal.getTransaction(uuid);
		transaction.rollback();
	}
}
