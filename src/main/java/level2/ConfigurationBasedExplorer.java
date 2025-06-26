package level2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import level1.exercise3.DirectoryExplorer;

public class ConfigurationBasedExplorer {

    public static void executeFromConfig() {

        Properties prop = new Properties();
        String inputDirectoryPath = null;
        String outputFileName = null;
        String outputDirectoryPath = null;
        String fullOutputPath = null;

        String configFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";

        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            prop.load(fis);


            inputDirectoryPath = prop.getProperty("input.directory");
            outputFileName = prop.getProperty("output.filename");
            outputDirectoryPath = prop.getProperty("output.directory");

            fullOutputPath = outputDirectoryPath + File.separator + outputFileName;


            File outputDir = new File(outputDirectoryPath);

            if (!outputDir.exists()) {

                outputDir.mkdirs();

                System.out.println("Output directory created: " + outputDirectoryPath);
            }

            System.out.println("  Reading configuration: ");
            System.out.println("  Reading configuration: " + inputDirectoryPath);
            System.out.println("  Output File Name: " + outputFileName);
            System.out.println("  Output Directory: " + outputDirectoryPath);
            System.out.println("  Complete Departure Route: " + fullOutputPath);


            DirectoryExplorer.listDirectoryTreeToFile(inputDirectoryPath, fullOutputPath);

            System.out.println("\nLevel 2, Exercise 1 completed. Output saved in: " + fullOutputPath);

        } catch (IOException ex) {
            System.err.println("Error loading configuration file or performing file operations: " + ex.getMessage());

        }
    }
}