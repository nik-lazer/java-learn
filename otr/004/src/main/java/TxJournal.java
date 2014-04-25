import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Журнал транзакций
 */
public class TxJournal {
	private Map<UUID, Transaction> txJournal = new ConcurrentHashMap<UUID, Transaction>();
	private SomeRemoteService service;

	public TxJournal(SomeRemoteService service) {
		this.service = service;
	}

	public Transaction getTransaction(UUID uid) {

		Transaction transaction = null;
		if (uid != null) {
			transaction = txJournal.get(uid);
		}
		if(transaction == null) {
			transaction = new Transaction(service);
			txJournal.put(uid, transaction);
		}
		return transaction;
	}



}
