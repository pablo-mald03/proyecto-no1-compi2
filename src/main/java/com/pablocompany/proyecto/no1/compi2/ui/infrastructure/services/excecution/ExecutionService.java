package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.excecution;

import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums.RarsHelpers;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.shell.TerminalLauncher;

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
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            try (OutputStream out = Files.newOutputStream(CONFIG_PATH)) {
                props.store(out, "Codex Compiler Config");
            }
        } catch (IOException ignored) {
        }
    }

    /**
     * Compile the C code with GCC and run it in the native terminal
     */
    public ExecutionResult compileAndExecute(File projectDir, String cCode) {
        ExecutionResult result = new ExecutionResult();
        try {
            File compiledDir = ensureCompiledDir(projectDir);
            Files.writeString(new File(compiledDir, "main.c").toPath(), cCode);

            result.addStep("Compilando codigo C con GCC...");
            if (!compileWithGCC(compiledDir, result)) {
                result.setSuccess(false);
                result.addStep("ERROR: Fallo la compilacion con GCC");
                return result;
            }

            boolean windows = System.getProperty("os.name").toLowerCase().contains("win");
            File binary = new File(compiledDir, windows ? OUTPUT_BINARY + ".exe" : OUTPUT_BINARY);
            if (!binary.exists()) {
                result.addStep("ERROR: No se encontro el binario ejecutable");
                return result;
            }

            TerminalLauncher.launch(compiledDir, List.of(binary.getAbsolutePath()), "Programa C");
            result.addStep("Terminal abierta con el programa: " + binary.getAbsolutePath());
            result.setSuccess(true);
        } catch (IOException e) {
            result.setSuccess(false);
            result.addStep("ERROR: " + e.getMessage());
        }
        return result;
    }

    /**
     * Method to write the main.s and runs it with RARS inside the native terminal
     */
    public ExecutionResult runRiscVInTerminal(File projectDir, String asmCode, String rarsJarPath) {
        ExecutionResult result = new ExecutionResult();
        try {
            File asmFile = prepareAsm(projectDir, asmCode, rarsJarPath, result);
            if (asmFile == null) return result;

            File dir = asmFile.getParentFile();
            Files.writeString(new File(dir, "RarsRun.java").toPath(), RarsHelpers.RARS_RUN_SOURCE.getValue());

            List<String> cmd = List.of(javaBin(), "-cp", rarsJarPath, "RarsRun.java",
                    "nc", "sm", asmFile.getName());
            TerminalLauncher.launch(dir, cmd, "Programa RISC-V");

            result.addStep("Terminal abierta ejecutando " + asmFile.getName() + " con RARS");
            result.setSuccess(true);
        } catch (IOException e) {
            result.setSuccess(false);
            result.addStep("ERROR al abrir terminal: " + e.getMessage());
        }
        return result;
    }
    
    /**
     * Method to write the main.s and opens it in the RARS GUI
     */
    public ExecutionResult openInRars(File projectDir, String asmCode, String rarsJarPath) {
        ExecutionResult result = new ExecutionResult();
        try {
            File asmFile = prepareAsm(projectDir, asmCode, rarsJarPath, result);
            if (asmFile == null) return result;

            List<String> cmd = List.of(javaBin(), "-jar", rarsJarPath);
            TerminalLauncher.launchDetached(asmFile.getParentFile(), cmd);

            result.addStep("RARS abierto. Archivo generado: " + asmFile.getAbsolutePath());
            result.setSuccess(true);
        } catch (IOException e) {
            result.setSuccess(false);
            result.addStep("ERROR al abrir RARS: " + e.getMessage());
        }
        return result;
    }

    public boolean isRARSAvailable(String rarsJarPath) {
        return rarsJarPath != null && rarsJarPath.endsWith(".jar") && Files.exists(Paths.get(rarsJarPath));
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

    /**
     * Helper method to prepare the asm code
     *
     */
    private File prepareAsm(File projectDir, String asmCode, String rarsJarPath, ExecutionResult result)
            throws IOException {
        if (!isRARSAvailable(rarsJarPath)) {
            result.addStep("ERROR: No se encontro el .jar de RARS");
            return null;
        }
        String javaBin = javaBin();
        if (!Files.exists(Paths.get(javaBin)) && !Files.exists(Paths.get(javaBin + ".exe"))) {
            result.addStep("ERROR: Java no encontrado en: " + javaBin);
            return null;
        }
        File asmFile = new File(ensureCompiledDir(projectDir), "main.s");
        Files.writeString(asmFile.toPath(), asmCode);
        result.addStep("Archivo main.s escrito en " + asmFile.getAbsolutePath());
        return asmFile;
    }

    /**
     * Principal method to detect the java binary
     *
     */
    private String javaBin() {
        return Paths.get(System.getProperty("java.home"), "bin", "java").toString();
    }

    /**
     * Principal method to compile the dir
     *
     */
    private File ensureCompiledDir(File projectDir) {
        File dir = new File(projectDir, COMPILED_FOLDER);
        if (!dir.exists()) dir.mkdirs();
        return dir;
    }
}