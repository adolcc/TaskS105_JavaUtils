package level1.exercise4;

import java.io.BufferedReader;

import java.io.FileReader;

public class DirectoryExplorer {

    public static void readFile(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());

        }
    }

}
