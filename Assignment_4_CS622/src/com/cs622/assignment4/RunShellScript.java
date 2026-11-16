package com.cs622.assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class RunShellScript {

    public static void main(String[] args) {
        try {
            // Path to the shell script
            String scriptPath = "C:/Users/91918/OneDrive/Desktop/CS622/Assignment_4_cs622/find_duplicates.sh";

            // Directory to search for duplicates (TestFolder path)
            String folderPath = "C:/Users/91918/OneDrive/Desktop/CS622/Assignment_4_cs622/TestFolder";

            // ProcessBuilder to execute the shell script using Git Bash
            ProcessBuilder processBuilder = new ProcessBuilder("C:/Program Files/Git/bin/bash.exe", scriptPath, folderPath);

            // Set the working directory for the ProcessBuilder (same directory as the shell script)
            processBuilder.directory(new File("C:/Users/91918/OneDrive/Desktop/CS622/Assignment_4_cs622"));

            // Start the process (run the shell script)
            Process process = processBuilder.start();

            // Capture the output of the shell script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print the output to the console
            }

            // Wait for the script to finish executing and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Script exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
