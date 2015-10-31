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
		try {
			Files.walkFileTree(pathSource, new MyFileVisitor());
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
}


