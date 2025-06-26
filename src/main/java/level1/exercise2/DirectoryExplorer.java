package level1.exercise2;

import java.io.File;

import java.text.SimpleDateFormat;

import java.util.Arrays;

public class DirectoryExplorer {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void listDirectoryTree(String path) {

        File root = new File(path);

        if (!root.exists() || !root.isDirectory()) {

            System.out.println("Invalid directory");

            return;
        }

        walkDirectoryTree(root, 0);
    }

    private static void walkDirectoryTree(File dir, int level) {

        File[] files = dir.listFiles();

        if (files == null) return;

        Arrays.sort(files);

        for (File file : files) {

            String indent = " ".repeat(level * 4);

            String type = file.isDirectory() ? "D" : "F";

            String date = DATE_FORMAT.format(file.lastModified());

            System.out.printf("%s[%s] %s -- Last modified: %s%n", indent, type, file.getName(), date);

            if (file.isDirectory()) {

                walkDirectoryTree(file, level + 1);

            }
        }
    }

}
