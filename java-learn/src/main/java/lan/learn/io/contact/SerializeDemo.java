package lan.learn.io.contact;

import java.io.*;
import java.util.GregorianCalendar;

/**
 * Created by nik-lazer on 02.10.15.
 */
public class SerializeDemo {
	private static void serialize(File file) {
		try {
			GregorianCalendar gc1 = new GregorianCalendar(1950, 3, 21);
			GregorianCalendar gc2 = new GregorianCalendar(1956, 5, 31);
			ExtendedContact contact1 = new ExtendedContact("Bugs Bunny", 22, 2025551212L, gc1, "New York");
			ExtendedContact contact2 = new ExtendedContact("Daffy Duck", 33, 3035551212L, gc2, "London");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contact1);
			oos.writeObject(contact2);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void deserialize(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				Object obj = ois.readObject();
				if (obj instanceof ExtendedContact) {
					ExtendedContact contact = (ExtendedContact) obj;
					System.out.println("contact=" + contact);
					System.out.println("city=" + contact.getCity());
				} else {
					System.out.println("wrong class");
				}
			}
			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		File file = new File("contacts.ser");
		serialize(file);
		deserialize(file);
	}
}
