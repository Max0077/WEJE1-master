package com.jspiders.serialization.objects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		String filename = "serialization.ser";

		Demo object = new Demo(10, "Hello");

		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			System.out.println("Writing object to file...");

			Thread.sleep(3000);

			out.writeObject(object);
			System.out.println("Object serialized");

			Thread.sleep(3000);

			FileInputStream file1 = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file1);

			System.out.println("Reading object from file...");

			Thread.sleep(3000);

			Demo readObject = (Demo) in.readObject();
			System.out.println(readObject.a + "\n" + readObject.b);

			Thread.sleep(3000);

			System.out.println("Object deserialized");

			out.close();
			in.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
