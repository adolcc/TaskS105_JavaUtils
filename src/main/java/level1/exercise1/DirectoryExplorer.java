package level1.exercise1;

import java.io.File;

import java.util.Arrays;

public class DirectoryExplorer {

    public static void listDirectoryContents(String path) {

        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The directory does not exist or is invalid.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) return;

        Arrays.sort(files);

        for (File file : files) {
            System.out.println(file.getName());
        }
    }

}
