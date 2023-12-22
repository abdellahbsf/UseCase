import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class usecase {

    public static void main(String[] args) {
        try {
            // Step 3: Run the Flicker tool
            String workingDir = System.getProperty("user.dir");
            // String flickerDirectory = workingDir + "\\flicker";
            String flickerCommand = "java -cp .\\flicker\\commons-net-3.6.jar;json-simple-1.1;. -jar .\\flicker\\flicker-1.0.jar -no_ntp";
            executeCommandInDirectory(flickerCommand, workingDir);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void executeCommandInDirectory(String command, String directory)
            throws IOException, InterruptedException {
        // Create ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Set command and directory
        processBuilder.command("cmd", "/c", "start", "cmd.exe", "/K", command);
        processBuilder.directory(new java.io.File(directory));
        // Merge standard output and error streams
        processBuilder.redirectErrorStream(true);

        // Start the process
        Process process = processBuilder.start();

        // Read output from the process
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Wait for the process to finish
        int exitCode = process.waitFor();

        // Check if the command was successful
        if (exitCode == 0) {
            System.out.println("Command executed successfully");
        } else {
            System.out.println("Command failed with error code: " + exitCode);
        }
    }
}
