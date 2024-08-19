import java.io.File;
import java.io.IOException;

public class Wrapper {
    public static void main(String[] args) throws IOException {
        String[] command = new String[] {
            "java", "-no-verify", "-Xms128M", "-Xmx4096M",
            "-Dterminal.jline=false", "-Dterminal.ansi=true",
            "-jar", "carbonspigot.jar"
        };
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(new File("."));
        Process p = pb.start();
    }
}