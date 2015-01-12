package lan.training.advanced.vfs;

import lan.training.advanced.base.VFS;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VFS implementation
 * @author nik-lazer  12.01.2015   13:50
 */
public class VFSImpl implements VFS {
	private static Logger log = Logger.getLogger(VFSImpl.class.getName());
	private String rootDir;

	public VFSImpl(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	public boolean isExist(String path) {
		File file = getFile(path);
		return file.exists();
	}

	@Override
	public boolean isDirectory(String path) {
		File file = getFile(path);
		return file.isDirectory();
	}

	@Override
	public String getAbsolutePath(String file) {
		File f = getFile(file);
		return f.getAbsolutePath();
	}

	@Override
	public byte[] getBytes(String file) {
		try {
			FileInputStream fis = new FileInputStream(getFile(file));
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			return bytes;
		} catch (FileNotFoundException e) {
			log.log(Level.WARNING, "File not found", e);
		} catch (IOException e) {
			log.log(Level.WARNING, "IO exception", e);
		}
		return new byte[0];
	}

	@Override
	public String getUFT8Text(String file) {
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(getFile(file)), "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String s;
			StringBuffer sb = new StringBuffer();
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			log.log(Level.WARNING, "File not found", e);
		} catch (UnsupportedEncodingException e) {
			log.log(Level.WARNING, "Unsupported encoding", e);
		} catch (IOException e) {
			log.log(Level.WARNING, "IO exception", e);
		}
		return null;
	}

	@Override
	public Iterator<String> getIterator(String startDir) {
		return new VFSIterator(startDir);
	}

	private File getFile(String path) {
		return new File(rootDir, path);
	}

	private class VFSIterator implements Iterator<String> {
        private Queue<File> files = new LinkedList<>();

		private VFSIterator(String startDir) {
			File file = getFile(startDir);
			files.add(file);
		}

		@Override
		public boolean hasNext() {
			return !files.isEmpty();
		}

		@Override
		public String next() {
			File file = files.peek();
			if (file.isDirectory()) {
				for (File f: file.listFiles()) {
					files.add(f);
				}
			}
			return files.poll().getAbsolutePath();
		}

		@Override
		public void remove() {

		}
	}
}
