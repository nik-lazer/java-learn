package lan.training.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by nik-lazer on 25.10.15.
 */
public class PathSample {
	public static void main(String[] args) {
		simplePath();
		addiditionalPath();
	}

	private static void addiditionalPath() {
		ClassLoader classLoader = PathSample.class.getClassLoader();
		Path path = new File(classLoader.getResource("nio2/nio2.txt").getFile()).toPath();
		System.out.printf("The file name is %s%n", path.getFileName());
		System.out.printf("It's URI is %s%n", path.toUri());
		try {
			System.out.printf("It's real path is %s%n", path.toRealPath(LinkOption.NOFOLLOW_LINKS));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("It's absolute path is %s%n", path.toAbsolutePath());
		System.out.printf("It's normalized path is %s%n", path.normalize());
	}

	private static void simplePath() {
		ClassLoader classLoader = PathSample.class.getClassLoader();
		File file = new File(classLoader.getResource("nio2/nio2.txt").getFile());
		Path testFilePath = Paths.get(file.toURI());
		System.out.println("Printing file information: ");
		System.out.println("\tfile name: " + testFilePath.getFileName());
		System.out.println("\troot of the path: " + testFilePath.getRoot());
		System.out.println("\tparent of the target: " + testFilePath.getParent());

		// print path elements
		System.out.println("Printing elements of the path: ");
		for(Path element : testFilePath) {
			System.out.println("\tpath element: " + element);
		}

	}
}
