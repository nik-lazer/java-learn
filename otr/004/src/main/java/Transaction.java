import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Транзакция. Позволяет добавлять {@link UOW} для разных записей, также имеет возможности по бекапу и рестору файлов
 */
public class Transaction {
	private final SomeRemoteService service;
	private UUID uuid;
	private Map<UUID, List<UOW>> uowMap = new LinkedHashMap<UUID, List<UOW>>();

	public void addUnit(UOW unit) {
		List<UOW> list = uowMap.get(unit.getRecord().getUuid());
		if (list == null) {
			list = new LinkedList<UOW>();
			list.add(unit);
		}
	}

	public void removeUnit(UOW unit) {
		List<UOW> list = uowMap.get(unit.getRecord().getUuid());
		if (list == null) {
			list.remove(unit);
		}
	}

	public Transaction(SomeRemoteService service) {
		this.service = service;
		uuid = UUID.randomUUID();
	}

	public UUID getUuid() {
		return uuid;
	}

	public void commit() {
		Iterator<UUID> iterator = uowMap.keySet().iterator();
		while (iterator.hasNext()) {
			UUID key =  iterator.next();
			Record r = uowMap.get(key).get(0).getRecord();
			backupFile(r);
			List<UOW> txRecords = UOW.processActions(uowMap.get(key));
			for (UOW txRecord : txRecords) {
				txRecord.takeAction(service);
			}
		}

	}

	public void rollback() {
		Iterator iterator = uowMap.keySet().iterator();
		while (iterator.hasNext()) {
			Record r = service.read(uuid);
			restoreFile(r);
			iterator.next();
		}
		uowMap.clear();
	}

	private void backupFile(Record r) {
		Path newPath = getTmpPath(r);
		try {
			Files.copy(Paths.get(r.getFile().getPath()), newPath, REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void restoreFile(Record r) {
		Path newPath = getTmpPath(r);
		try {
			Files.copy(newPath, Paths.get(r.getFile().getPath()), REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Path getTmpPath(Record r) {
		Path newPath = Paths.get("/tmp/"+getUuid()+ "/"+r.getFile().getName());
		return newPath;
	}
}
