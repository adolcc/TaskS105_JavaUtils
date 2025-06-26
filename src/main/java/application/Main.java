package application;

import level1.model.FileInfo;

import level2.ConfigurationBasedExplorer;

import java.io.File;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory to explore (for Level 1): ");

        String inputPathRaw = scanner.nextLine();

        String inputPath = inputPathRaw.replace("/", File.separator).replace("\\", File.separator);

        String outputPath = "output" + File.separator + "directory_tree.txt";

        String serPath = "output" + File.separator + "file_info.ser";


        File outputDir = new File("output");

        if (!outputDir.exists()) {

            outputDir.mkdirs();

        }

        System.out.println("\n--- Level 1 - Exercise 1: Basic Directory Listing ---");
        level1.exercise1.DirectoryExplorer.listDirectoryContents(inputPath);

        System.out.println("\n--- Exercise 2: Recursive tree with details ---");
        level1.exercise2.DirectoryExplorer.listDirectoryTree(inputPath);

        System.out.println("\n--- Exercise 3: Save tree in archive ---");
        level1.exercise3.DirectoryExplorer.listDirectoryTreeToFile(inputPath, outputPath);

        System.out.println("\n--- Exercise 4: Read generated file ---");
        level1.exercise4.DirectoryExplorer.readFile(outputPath);

        System.out.println("\n--- Exercise 5: Serialize and deserialize object ---");

        FileInfo info = new FileInfo("example.txt", false, System.currentTimeMillis());

        level1.exercise5.DirectoryExplorer.serializeObject(info, serPath);

        FileInfo loadedInfo = (FileInfo) level1.exercise5.DirectoryExplorer.deserializeObject(serPath);
        if (loadedInfo != null) {
            System.out.println("Data loaded: " + loadedInfo);
        }

        System.out.println("\n--- Level 2 - Exercise 1: Execute tree from configuration file ---");

        ConfigurationBasedExplorer.executeFromConfig();

        scanner.close();

    }

}