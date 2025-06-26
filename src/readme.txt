# How to Run This Java Project

This document provides the essential commands to compile and run the project from your terminal.

---

## Prerequisites

* Java Development Kit (JDK) 17.
* Apache Maven

---

## Instructions:

1.  **Navigate to the Project Root:**
    Open your terminal and change directory to the root of this project (where the 'pom.xml' file is located).

    ```bash
    cd your_project_folder
    ```

2.  **Compile the Project:**
    Execute the following command to compile the Java code and package it:

    ```bash
    mvn clean install
    ```

3.  **Run the Main Application:**
    After successful compilation, run the application using this command:

    ```bash
    mvn exec:java -Dexec.mainClass="application.Main"
    ```
    * **Note:** When prompted, enter an absolute directory path for Level 1 exercises (e.g., `/Users/your_username/Documents/MyFolder`).
    * Level 2 exercises read their configuration from `src/main/resources/config.properties`. Edit this file to change input/output paths for Level 2.

---

## Important Configuration

For Level 2 Exercise 1, ensure your `src/main/resources/config.properties` file is set up correctly with the desired paths.

Example `config.properties` content:
```properties
input.directory=/Users/your_username/Documents/MyTestDirectory
output.filename=directory_tree_from_config.txt
output.directory=output
