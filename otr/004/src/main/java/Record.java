import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author Alexey Pobedyonny 18.02.2014
 */
public class Record {
	private final UUID uuid;
	private final Date createDate;
	private long workResult;

	private File file;

	public Record(UUID uuid, Date createDate) {
		this.uuid = uuid;
		this.createDate = createDate;
		this.file = new File("/tmp/" + uuid);
		FileWriter w = null;
		try {
			w = new FileWriter(file);
			w.append(uuid.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void updateFileData() {
		FileWriter w = null;
		try {
			w = new FileWriter(file);
			w.append(String.valueOf(System.currentTimeMillis()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public UUID getUuid() {
		return uuid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setWorkResult(long workResult) {
		this.workResult = workResult;
	}

	public long getWorkResult() {
		return workResult;
	}

	public void cleanUp() {
		file.delete();
	}

	public File getFile() {
		return file;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Record)) return false;

		Record record = (Record) o;

		if (workResult != record.workResult) return false;
		if (!createDate.equals(record.createDate)) return false;
		if (!uuid.equals(record.uuid)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = uuid.hashCode();
		result = 31 * result + createDate.hashCode();
		result = 31 * result + (int) (workResult ^ (workResult >>> 32));
		return result;
	}
}

