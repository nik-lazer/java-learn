package lan.training.nio2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by nik-lazer on 25.10.15.
 */
public class PathSample {
	public static void main(String[] args) {
		ClassLoader classLoader = PathSample.class.getClassLoader();
		File file = new File(classLoader.getResource("nio2.txt").getFile());
		Path testFilePath = Paths.get(file.toURI());
		System.out.println("Printing file information: ");
		System.out.println("\t file name: " + testFilePath.getFileName());
		System.out.println("\t root of the path: " + testFilePath.getRoot());
		System.out.println("\t parent of the target: " + testFilePath.getParent());

// print path elements
		System.out.println("Printing elements of the path: ");
		for(Path element : testFilePath) {
			System.out.println("\t path element: " + element);
		}
	}
}
