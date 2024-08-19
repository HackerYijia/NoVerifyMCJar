// MCNoVerifer 0.1.2 Maded by NotJunar/HackerYijia
import java.io.IOException;
public class ServerWrapper {
    public static void main(String[] args) {
        String[] command = new String[] {
            "java", "-noverify", "-Xms128M", "-Xmx4096M",
            "-Dterminal.jline=false", "-Dterminal.ansi=true",
            "-jar", "carbonspigot.jar"
        };

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.inheritIO();
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            int exitValue = process.waitFor();
            System.out.println("Server exited with value: " + exitValue);

        } catch (IOException e) {
            System.err.println("Error launching server: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Server interrupted: " + e.getMessage());
        }
    }
}