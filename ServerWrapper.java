// MCNoVerifer Made by HackerYijia / NotJunar
import java.io.IOException;

public class ServerWrapper {
    public static void main(String[] args) {
        String[] command = new String[] {
            "java", 
            "-noverify", 
            "-Xloggc:gc.log", 
            "-verbose:gc", 
            "-XX:+PrintGCDetails", 
            "-XX:+PrintGCDateStamps", 
            "-XX:+PrintGCTimeStamps",
            "-XX:+UseGCLogFileRotation", 
            "-XX:NumberOfGCLogFiles=5", 
            "-XX:GCLogFileSize=1M", 
            "-Xms128M", 
            "-Xmx3800M", 
            "-Dterminal.jline=false", 
            "-Dterminal.ansi=true", 
            "-jar", 
            "server.jar"
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
