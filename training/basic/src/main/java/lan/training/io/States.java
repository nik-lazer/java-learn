package lan.training.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * {@link java.io.FileReader} and {@link java.io.BufferedReader} using example
 * @author nik-lazer  01.10.2015   17:36
 */
public class States {
	public static void main(String[] args) {
		try {
			ClassLoader classLoader = States.class.getClassLoader();
			File file = new File(classLoader.getResource("states.txt").getFile());
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			try {
				String line = bufferedReader.readLine();
				while (line != null) {
					System.out.println("line:" + line);
					line = bufferedReader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
