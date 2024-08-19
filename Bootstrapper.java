public class Bootstrapper {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "java", "-no-verify", "-Xms128M", "-Xmx4096M",
                    "-Dterminal.jline=false", "-Dterminal.ansi=true",
                    "-jar", "carbonspigot.jar"
            );
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
