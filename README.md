# CS622 – Assignment 4: Running a Shell Script from Java

A Java program that launches a Bash script (`find_duplicates.sh`) as an external process, passes it a target folder, and streams the script's output back into the Java console. The script scans the folder for duplicate files.

**Course:** CS622, Boston University
**Package:** `com.cs622.assignment4`

---

## How it works

1. `RunShellScript` builds a `ProcessBuilder` that calls Git Bash (`bash.exe`) with two arguments:
   - the path to `find_duplicates.sh`
   - the path to the folder to scan (`TestFolder`)
2. The working directory is set to the project folder so the script can resolve relative paths.
3. The process is started, and its standard output is read line by line and printed to the Java console.
4. The program waits for the script to finish and prints its exit code.

```
Java (RunShellScript)  -->  ProcessBuilder  -->  Git Bash  -->  find_duplicates.sh  -->  TestFolder
        ^                                                              |
        |______________________ stdout streamed back __________________|
```

## Project structure

```
Assignment_4_cs622/
├── find_duplicates.sh        # Bash script that finds duplicate files
├── TestFolder/               # Sample folder scanned for duplicates
└── src/
    └── com/cs622/assignment4/
        └── RunShellScript.java
```

## Requirements

- Java JDK 8 or later
- [Git for Windows](https://git-scm.com/download/win) (provides `bash.exe`)
- Windows (paths in the code are Windows-style)

## Setup and run

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   ```
2. Open `RunShellScript.java` and update these paths to match your machine:
   ```java
   String scriptPath = "C:/path/to/find_duplicates.sh";
   String folderPath = "C:/path/to/TestFolder";
   ```
   Also update the Git Bash location if it is not at `C:/Program Files/Git/bin/bash.exe`.
3. Compile and run:
   ```bash
   javac -d out src/com/cs622/assignment4/RunShellScript.java
   java -cp out com.cs622.assignment4.RunShellScript
   ```
   Or run it directly from your IDE (IntelliJ / Eclipse / VS Code).

## Example output

```
<duplicate files found by find_duplicates.sh are listed here>
Script exited with code: 0
```

An exit code of `0` means the script finished successfully.

## Concepts demonstrated

- Running external processes with `ProcessBuilder`
- Setting a working directory for a child process
- Reading process output with `BufferedReader` / `InputStreamReader`
- Using `waitFor()` to get an exit code
- Integrating Java with shell scripting

## Possible improvements

- Use relative paths or command-line arguments instead of hardcoded paths
- Also capture `stderr` (`processBuilder.redirectErrorStream(true)`)
- Detect the OS and choose `bash` accordingly for Linux/macOS

## Author

Bhargav Sai Gundapaneni
M.S. Software Development, Boston University
