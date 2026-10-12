package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.excecution;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Service for compiling and executing C code
 *
 * @author pablo03
 */
public class ExecutionService {

    private static final String COMPILED_FOLDER = "compiled";
    private static final String OUTPUT_BINARY = "main";

    // En ExecutionService o un ConfigService
    private static final Path CONFIG_PATH = Paths.get(System.getProperty("user.home"), ".codex", "config.properties");

    public static String getRarsPath() {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(CONFIG_PATH)) {
            props.load(in);
            return props.getProperty("rars.jar.path");
        } catch (IOException e) {
            return null;
        }
    }

    public static void setRarsPath(String path) {
        Properties props = new Properties();
        props.setProperty("rars.jar.path", path);
        try (OutputStream out = Files.newOutputStream(CONFIG_PATH)) {
            props.store(out, "Codex Compiler Config");
        } catch (IOException e) {
            //Error
        }
    }

    /**
     * Compile and execute the C code in a native terminal
     */
    public ExecutionResult compileAndExecute(File projectDir, String cCode) {
        ExecutionResult result = new ExecutionResult();

        try {
            File compiledDir = new File(projectDir, COMPILED_FOLDER);
            if (!compiledDir.exists()) {
                compiledDir.mkdirs();
            }

            File cFile = new File(compiledDir, "main.c");
            try (FileWriter writer = new FileWriter(cFile)) {
                writer.write(cCode);
            }

            result.addStep("Compilando codigo C con GCC...");
            boolean compileSuccess = compileWithGCC(compiledDir, result);

            if (!compileSuccess) {
                result.setSuccess(false);
                result.addStep("ERROR: Fallo la compilacion con GCC");
                return result;
            }

            openNativeTerminal(compiledDir, result);

            result.setSuccess(true);

        } catch (IOException e) {
            result.setSuccess(false);
            result.addStep("ERROR: " + e.getMessage());
        }

        return result;
    }

    /**
     * Principal method t run the assemler code with risc V
     *
     */
    public ExecutionResult assembleAndRunRiscV(File projectDir, String asmCode, String rarsJarPath) {
        ExecutionResult result = new ExecutionResult();

        try {
            Path asmPath = Paths.get(projectDir.getAbsolutePath(), "compiled", "main.s");
            Files.createDirectories(asmPath.getParent());
            Files.writeString(asmPath, asmCode);
            result.addStep("Archivo main.s escrito en " + asmPath);

            String javaBin = Paths.get(System.getProperty("java.home"), "bin", "java").toString();
            if (!Files.exists(Paths.get(javaBin))) {
                result.addStep("Java no encontrado en: " + javaBin);
                return result;
            }

            ProcessBuilder pb = new ProcessBuilder(
                    javaBin, "-jar", rarsJarPath,
                    "me",
                    asmPath.toString()
            );
            pb.directory(projectDir);
            pb.redirectErrorStream(false);

            result.addStep("Invocando RARS...");
            Process process = pb.start();

            StringBuilder stdout = new StringBuilder();
            StringBuilder stderr = new StringBuilder();

            Thread outThread = new Thread(() -> {
                try (BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = r.readLine()) != null) stdout.append(line).append("\n");
                } catch (IOException ignored) {
                }
            });
            Thread errThread = new Thread(() -> {
                try (BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                    String line;
                    while ((line = r.readLine()) != null) stderr.append(line).append("\n");
                } catch (IOException ignored) {
                }
            });

            outThread.start();
            errThread.start();

            int exitCode = process.waitFor();
            outThread.join();
            errThread.join();

            String programOutput = stdout.toString().trim();
            String rarsMessages = stderr.toString().trim();

            if (exitCode == 0) {
                result.setSuccess(true);
                result.setOutput(programOutput.isEmpty() ? "(sin salida)" : programOutput);
                result.addStep("Programa RISC-V ejecutado correctamente");
            } else {
                result.setSuccess(false);
                result.setOutput(programOutput + (rarsMessages.isEmpty() ? "" : "\n--- MENSAJES DE RARS ---\n" + rarsMessages));
                result.addStep("RARS terminó con código: " + exitCode);
            }

        } catch (Exception e) {
            result.setSuccess(false);
            result.setOutput("Error al ejecutar RARS: " + e.getMessage());
            result.addStep("Fallo en la ejecución RISC-V");
        }

        return result;
    }

    public boolean isRARSAvailable(String rarsJarPath) {
        return rarsJarPath != null && Files.exists(Paths.get(rarsJarPath)) && rarsJarPath.endsWith(".jar");
    }


    /**
     * Compile C code using GCC
     */
    private boolean compileWithGCC(File compiledDir, ExecutionResult result) {
        try {
            List<String> command = new ArrayList<>();
            command.add("gcc");
            command.add("main.c");
            command.add("-o");
            command.add(OUTPUT_BINARY);
            command.add("-Wall");
            command.add("-Wextra");

            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(compiledDir);
            pb.redirectErrorStream(true);

            Process process = pb.start();

            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                result.addStep("Compilacion exitosa");
                return true;
            } else {
                result.addStep("Errores de compilacion:");
                result.addStep(output.toString());
                return false;
            }

        } catch (IOException | InterruptedException e) {
            result.addStep("Error al compilar: " + e.getMessage());
            return false;
        }
    }

    /**
     * Open the compiled program in a native terminal
     */
    private void openNativeTerminal(File compiledDir, ExecutionResult result) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String executable = OUTPUT_BINARY;

            if (os.contains("win")) {
                executable = OUTPUT_BINARY + ".exe";
            }

            File binaryFile = new File(compiledDir, executable);
            if (!binaryFile.exists()) {
                result.addStep("ERROR: No se encontro el binario ejecutable");
                return;
            }

            // Build and start the terminal command
            ProcessBuilder pb = buildTerminalCommand(os, binaryFile, compiledDir);
            pb.start();

            result.addStep("Terminal abierta con el programa: " + binaryFile.getAbsolutePath());

        } catch (IOException e) {
            result.addStep("ERROR al abrir terminal: " + e.getMessage());
        }
    }

    /**
     * Build the appropriate terminal command based on OS
     */
    private ProcessBuilder buildTerminalCommand(String os, File binaryFile, File workingDir) {
        ProcessBuilder pb;

        if (os.contains("win")) {
            // Windows: Use cmd.exe with start to open new window
            List<String> cmd = new ArrayList<>();
            cmd.add("cmd.exe");
            cmd.add("/c");
            cmd.add("start");
            cmd.add("cmd.exe");
            cmd.add("/k");
            cmd.add(binaryFile.getAbsolutePath());
            cmd.add("&");
            cmd.add("pause");
            pb = new ProcessBuilder(cmd);

        } else if (os.contains("mac")) {
            // macOS: Use Terminal.app
            List<String> cmd = new ArrayList<>();
            cmd.add("osascript");
            cmd.add("-e");
            cmd.add("tell application \"Terminal\" to do script \"" +
                    binaryFile.getAbsolutePath() + " ; echo 'Presiona cualquier tecla para cerrar...' ; read -n 1\"");
            pb = new ProcessBuilder(cmd);

        } else {
            // Linux: Use xterm, gnome-terminal, or konsole
            String terminal = detectLinuxTerminal();
            List<String> cmd = new ArrayList<>();
            cmd.add(terminal);
            cmd.add("-e");
            cmd.add("bash -c \"" + binaryFile.getAbsolutePath() + " ; echo 'Presiona cualquier tecla para cerrar...' ; read -n 1\"");
            pb = new ProcessBuilder(cmd);
        }

        pb.directory(workingDir);
        pb.redirectErrorStream(true);

        return pb;
    }

    /**
     * Detect available terminal on Linux
     */
    private String detectLinuxTerminal() {
        // Check common terminals
        String[] terminals = {"gnome-terminal", "konsole", "xterm", "lxterminal", "xfce4-terminal"};

        for (String terminal : terminals) {
            try {
                ProcessBuilder pb = new ProcessBuilder("which", terminal);
                Process process = pb.start();
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    return terminal;
                }
            } catch (Exception e) {
                // Continue to next
            }
        }

        // Fallback to xterm (most common)
        return "xterm";
    }

    /**
     * Check if GCC is available on the system
     */
    public boolean isGCCAvailable() {
        try {
            ProcessBuilder pb = new ProcessBuilder("gcc", "--version");
            Process process = pb.start();
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (Exception e) {
            return false;
        }
    }


}