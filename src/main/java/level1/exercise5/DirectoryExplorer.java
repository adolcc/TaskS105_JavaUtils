package level1.exercise5;

import java.io.*;

public class DirectoryExplorer {

    public static void serializeObject(Object obj, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(obj);
            System.out.println("Object serialize on: " + filePath);
        } catch (Exception e) {
            System.err.println("Error serialized: " + e.getMessage());
        }
    }

    public static Object deserializeObject(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = in.readObject();
            System.out.println("Object deserialize from: " + filePath);
            return obj;
        } catch (Exception e) {
            System.err.println("Error deserialize: " + e.getMessage());
            return null;
        }
    }
}
