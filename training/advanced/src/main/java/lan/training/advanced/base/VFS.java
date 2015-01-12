package lan.training.advanced.base;

import java.util.Iterator;

/**
 * Virtual file system
 * @author nik-lazer  12.01.2015   13:49
 */
public interface VFS {
	boolean isExist(String path);
	boolean isDirectory(String path);
	String getAbsolutePath(String file);
	byte[] getBytes(String file);
	String getUFT8Text(String file);
	Iterator<String> getIterator(String startDir);
}
