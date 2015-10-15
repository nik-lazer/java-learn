package lan.training.io.contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik-lazer on 01.10.15.
 */
public class StreamContactManager {
	public static void addContact(Contact contact, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file, true);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeUTF(contact.name);
		dos.writeInt(contact.age);
		dos.writeLong(contact.cellPhone);
		dos.close();
		bos.close();
		fos.close();
	}

	public static List<Contact> getContacts(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);

		List<Contact> contacts = new ArrayList<Contact>();
		while (dis.available() > 0) {
			String name = dis.readUTF();
			int age = dis.readInt();
			long cellPhone = dis.readLong();
			Contact contact = new Contact(name, age, cellPhone);
			contacts.add(contact);
		}
		return contacts;
	}

	public static void main(String[] args) {
		File file = new File("contacts.dat");
		try {
			addContact(new Contact("Bugs Bunny", 22, 2025551212L), file);
			addContact(new Contact("Daffy Duck", 33, 3035551212L), file);

			System.out.println(getContacts(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
