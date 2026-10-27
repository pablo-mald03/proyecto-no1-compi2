package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.shell;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Principal class for terminal launcher
 *
 */
public class TerminalLauncher {

    private static final String[] LINUX_TERMINALS =
            {"gnome-terminal", "konsole", "xfce4-terminal", "lxterminal", "xterm"};

    private TerminalLauncher() {
    }

    /**
     * Method to open the native terminal, runs the command inside workingDir and waits
     */
    public static void launch(File workingDir, List<String> command, String title) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        boolean windows = os.contains("win");

        File script = writeScript(workingDir, command, windows);
        String scriptPath = script.getAbsolutePath();

        List<String> cmd = new ArrayList<>();
        if (windows) {
            cmd.addAll(List.of("cmd.exe", "/c", "start", title, "cmd.exe", "/c", scriptPath));
        } else if (os.contains("mac")) {
            cmd.addAll(List.of("osascript", "-e",
                    "tell application \"Terminal\" to activate", "-e",
                    "tell application \"Terminal\" to do script \"bash " + shQuote(scriptPath) + "\""));
        } else {
            cmd.addAll(linuxTerminalCommand(scriptPath, title));
        }

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.directory(workingDir);
        pb.start();
    }

    /**
     * Method to starts a GUI program without a terminal.
     */
    public static void launchDetached(File workingDir, List<String> command) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(workingDir);
        pb.redirectErrorStream(true);
        pb.redirectOutput(new File(workingDir, "rars.log"));
        pb.start();
    }

    /**
     * Principal method to write the script for te runtime
     *
     */
    private static File writeScript(File dir, List<String> command, boolean windows) throws IOException {
        File script = new File(dir, windows ? "run_terminal.bat" : "run_terminal.sh");
        String body;
        if (windows) {
            body = "@echo off\r\n"
                    + "cd /d \"" + dir.getAbsolutePath() + "\"\r\n"
                    + command.stream().map(a -> "\"" + a + "\"").collect(Collectors.joining(" ")) + "\r\n"
                    + "echo.\r\n"
                    + "echo Programa finalizado (codigo %ERRORLEVEL%).\r\n"
                    + "pause\r\n";
        } else {
            body = "#!/bin/bash\n"
                    + "cd " + shQuote(dir.getAbsolutePath()) + "\n"
                    + command.stream().map(TerminalLauncher::shQuote).collect(Collectors.joining(" ")) + "\n"
                    + "code=$?\n"
                    + "echo\n"
                    + "echo \"Programa finalizado (codigo $code).\"\n"
                    + "read -n 1 -s -r -p \"Presiona cualquier tecla para cerrar...\"\n";
        }
        Files.writeString(script.toPath(), body);
        script.setExecutable(true);
        return script;
    }

    /**
     * Method to execute the linux terminal command
     *
     */
    private static List<String> linuxTerminalCommand(String scriptPath, String title) {
        String term = detectLinuxTerminal();
        String bashCmd = "bash " + shQuote(scriptPath);
        return switch (term) {
            case "gnome-terminal" -> List.of(term, "--title=" + title, "--", "bash", scriptPath);
            case "konsole" -> List.of(term, "-e", "bash", scriptPath);
            case "xfce4-terminal", "lxterminal" -> List.of(term, "-e", bashCmd); // single string
            default -> List.of(term, "-T", title, "-e", "bash", scriptPath);     // xterm
        };
    }

    /**
     * Method to detect the linux terminal
     *
     */
    private static String detectLinuxTerminal() {
        for (String t : LINUX_TERMINALS) {
            try {
                Process p = new ProcessBuilder("which", t).start();
                if (p.waitFor() == 0) return t;
            } catch (Exception ignored) {
            }
        }
        return "xterm";
    }

    /**
     * Method to escape the shell command
     *
     */
    private static String shQuote(String s) {
        return "'" + s.replace("'", "'\\''") + "'";
    }
}