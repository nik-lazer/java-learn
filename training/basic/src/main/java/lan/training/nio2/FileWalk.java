package lan.training.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by nik-lazer on 29.10.15.
 */
public class FileWalk {
	public static void main(String[] args) {
		ClassLoader classLoader = PathSample.class.getClassLoader();
		Path path = new File(classLoader.getResource("nio2/walk").getFile()).toPath();

		Path pathSource = Paths.get(path.toUri());
		System.out.printf("Path: %s%n", path);
		try {
			System.out.println("Simple walk started");
			Files.walkFileTree(pathSource, new MyFileVisitor());
			System.out.println("Simple walk finished");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Find walk started");
			Files.walkFileTree(pathSource, new MyFileFindVisitor("glob:file*.txt"));
			System.out.println("Find walk finished");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class MyFileVisitor extends SimpleFileVisitor<Path> {
		public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
			System.out.println("file name:" + path.getFileName());
			return FileVisitResult.CONTINUE;
		}
		public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes){
			System.out.println("----------Directory name:" + path + "----------");
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			System.out.println("----------Directory name:" + dir + " visited----------");
			return FileVisitResult.CONTINUE;
		}
	}

	static class MyFileFindVisitor extends SimpleFileVisitor<Path> {
		private PathMatcher matcher;

		public MyFileFindVisitor(String pattern) {
			try {
				matcher = FileSystems.getDefault().getPathMatcher(pattern);
			} catch(IllegalArgumentException iae) {
				System.err.println("Invalid pattern; did you forget to prefix \"glob:\"?(as in  glob:*.java)");
				System.exit(1);
			}

		}
		public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes){
			find(path);
			return FileVisitResult.CONTINUE;
		}
		private void find(Path path) {
			Path name = path.getFileName();
			if(matcher.matches(name))
				System.out.println("Matching file:" + path.getFileName());
		}
		public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes){
			find(path);
			return FileVisitResult.CONTINUE;
		}
	}
}


