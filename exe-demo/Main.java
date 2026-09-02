// Lightweight standalone demo compiled & packaged to a Windows .exe by GitHub Actions.
// Purpose: verify that  local `git push` -> GitHub Actions -> packaged .exe  works.
// No external dependencies, no JavaFX. Double-click the .exe to run.
public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  Hello from a GitHub-Actions-built .exe");
        System.out.println("  java.version : " + System.getProperty("java.version"));
        System.out.println("  os.name      : " + System.getProperty("os.name"));
        System.out.println("  java.home    : " + System.getProperty("java.home"));
        System.out.println("==============================================");
        System.out.println();
        System.out.println("Local push -> cloud Actions -> .exe : SUCCESS");
        System.out.println();
        System.out.println("Press Enter to close...");
        try { System.in.read(); } catch (Exception ignored) { }
    }
}
