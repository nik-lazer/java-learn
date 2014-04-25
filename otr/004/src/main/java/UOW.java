import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Unit of work
 * @author Alexey Pobedyonny 18.02.2014
 */
public class UOW {
	private Action action;
	private Record record;

	public UOW(Action action, Record record) {
		this.action = action;
		this.record = record;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	/**
	 * дополнен список действий
	 * @param someRemoteService
	 */
	public void takeAction(SomeRemoteService someRemoteService) {
		if(action.equals(Action.ADD)) {
			someRemoteService.innerCreateRecord(record);
			return;
		}
		if(action.equals(Action.UPDATE)) {
			someRemoteService.innerUpdateRecord(record);
			return;
		}
		if(action.equals(Action.UPDATE)) {
			someRemoteService.innerDeleteRecord(record);
			return;
		}
	}

	/**
	 * Включена обработка двойного добавления, обновления тем же самым
	 * @param txRecords
	 * @return
	 */
	public static List<UOW> processActions(List<UOW> txRecords) {
		Iterator<UOW> iter = txRecords.iterator();
		boolean isDelete = false;
		boolean isAdded = false;
		Record prevRecord = null;
		while(iter.hasNext()) {
			UOW txRecord = iter.next();
			if(isDelete) {
				iter.remove();
			}
			if (isAdded && (txRecord.action.equals(Action.ADD))) {
				iter.remove();
			}
			if (txRecord.action.equals(Action.UPDATE) && (prevRecord != null) && prevRecord.equals(txRecord.getRecord())) {
				iter.remove();
			}
			if (txRecord.action.equals(Action.ADD)) {
				isAdded = true;
			}
			if(txRecord.action.equals(Action.DELETE)) {
				isDelete = true;
			}
			if (txRecord.action.equals(Action.UPDATE)) {
				prevRecord = txRecord.getRecord();
			}
		}
		return txRecords;
	}

	enum Action {
		ADD, UPDATE, DELETE
	}
}
