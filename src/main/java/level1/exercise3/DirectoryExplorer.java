package level1.exercise3;

import java.io.BufferedWriter;

import java.io.File;

import java.io.FileWriter;

import java.text.SimpleDateFormat;

import java.util.Arrays;

public class DirectoryExplorer {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void listDirectoryTreeToFile(String path, String outputPath) {

        File root = new File(path);

        if (!root.exists() || !root.isDirectory()) {

            System.out.println("Invalid directory");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            walkAndWriteDirectoryTree(root, 0, writer);
            System.out.println("Tree safe on: " + outputPath);
        } catch (Exception e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }
    }

    private static void walkAndWriteDirectoryTree(File dir, int level, BufferedWriter writer) throws Exception {

        File[] files = dir.listFiles();

        if (files == null) return;

        Arrays.sort(files);

        for (File file : files) {

            String indent = " ".repeat(level * 4);

            String type = file.isDirectory() ? "D" : "F";

            String date = DATE_FORMAT.format(file.lastModified());

            String line = String.format("%s[%s] %s -- Last modified: %s", indent, type, file.getName(), date);

            writer.write(line);

            writer.newLine();

            if (file.isDirectory()) {

                walkAndWriteDirectoryTree(file, level + 1, writer);

            }
        }
    }

}
