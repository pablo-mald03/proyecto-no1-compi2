package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.compilation.CompilationArtifact;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.factory.BackendFactory;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.service.CompilationService;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.GenerationOptions;
import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.CompilationContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.SymbolCollectorOrchestrator;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.orchestator.TypeCheckerOrchestrator;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.ParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.common.domain.resolver.ReferenceResolverOrchestrator;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.orchestator.ArraySizeValidatorOrchestrator;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.orchestator.CodeGeneratorOrchestrator;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.parsing.ParserFactory;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.DependencyGraph;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.importResolver.DependencyAnalyzer;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileNode;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileTreePanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.utils.WorkspacePaths;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.validator.ClassFileNameValidator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.*;

/**
 * Service responsible for compilation orchestration, context management and Main Class configuration.
 *
 * @author pablo03
 */
@Getter
public class WorkspaceCompilationService {

    private final WorkspaceNotifier notifier;
    private final FileTreePanel fileTreePanel;
    private final Map<String, EditorContext> fileContexts;

    private CompilationContext compilationContext;
    @Getter(AccessLevel.NONE)
    private final Map<Target, String> compiledOutput;
    private boolean isCompiled;

    private String mainClassPath;
    private FileNode mainClassNode;

    private final CodeGeneratorOrchestrator orchestrator;
    private final CompilationService compilationService;

    @Setter
    private WorkspaceEditorService editorService;

    public WorkspaceCompilationService(WorkspaceNotifier notifier, FileTreePanel fileTreePanel) {
        this.notifier = notifier;
        this.fileTreePanel = fileTreePanel;
        this.fileContexts = new HashMap<>();
        this.compiledOutput = new EnumMap<>(Target.class);
        this.isCompiled = false;
        this.mainClassPath = null;
        this.mainClassNode = null;
        this.compilationService = new CompilationService(BackendFactory.withDefaults());
        this.orchestrator = new CodeGeneratorOrchestrator();
    }

    /**
     * Set the selected file in the file tree as Main Class
     */
    public void setSelectedAsMainClass() {
        DefaultMutableTreeNode node = fileTreePanel.getSelectedNode();
        if (node == null) {
            return;
        }

        Object userObj = node.getUserObject();
        if (!(userObj instanceof FileNode fileNode)) {
            return;
        }

        if (fileNode.isDirectory() || !fileNode.getExtension().equals(".pig")) {
            notifier.alertToast("Solo los archivos .pig pueden ser Main Class", true);
            return;
        }

        this.mainClassPath = fileNode.getFilePath();
        this.mainClassNode = fileNode;

        notifier.notifyMainClassChanged(fileNode.getName());
        notifier.logInfo("Main Class establecida: " + fileNode.getName());
    }

    /**
     * Get the main class node
     */
    public FileNode getMainClass() {
        return mainClassNode;
    }

    /**
     * Check if a main class is selected
     */
    public boolean hasMainClass() {
        return mainClassNode != null;
    }

    /**
     * Clear the main class (when closing project)
     */
    public void clearMainClass() {
        this.mainClassPath = null;
        this.mainClassNode = null;
    }

    /**
     * Method to get the compiled output
     *
     */
    public String getCompiledOutput(Target target) {
        return compiledOutput.get(target);
    }

    /**
     * Get or create EditorContext for a file
     */
    public EditorContext getContextForFile(String filePath) {
        return fileContexts.computeIfAbsent(filePath, k -> {
            EditorContext context = new EditorContext();

            DefaultMutableTreeNode node = fileTreePanel.getFileNodes().get(filePath);
            if (node != null && node.getUserObject() instanceof FileNode fileNode) {
                if (fileNode.getContent() != null) {
                    context.setSourceCode(fileNode.getContent());
                }
            }
            return context;
        });
    }

    /**
     * Update context for a file with new content
     */
    public void updateContextForFile(String filePath, String content) {
        EditorContext context = getContextForFile(filePath);
        context.setSourceCode(content);

        DefaultMutableTreeNode node = fileTreePanel.getFileNodes().get(filePath);
        if (node != null && node.getUserObject() instanceof FileNode fileNode) {
            fileNode.setContent(content);
            fileNode.updateContextFromContent();
        }
    }

    /**
     * Get all compilation errors from all files
     */
    public List<CompilerError> getAllCompilationErrors() {
        List<CompilerError> allErrors = new ArrayList<>();
        for (Map.Entry<String, EditorContext> entry : fileContexts.entrySet()) {
            String filePath = entry.getKey();
            EditorContext context = entry.getValue();

            List<CompilerError> fileErrors = context.getAllCompilerErrors();
            if (fileErrors != null) {
                for (CompilerError error : fileErrors) {
                    error.setFilePath(filePath);
                    error.setFileName(new File(filePath).getName());
                }
                allErrors.addAll(fileErrors);
            }
        }
        return allErrors;
    }

    /**
     * Clear all compilation data from all files
     */
    public void clearAllCompilationData() {
        for (Map.Entry<String, EditorContext> entry : fileContexts.entrySet()) {
            entry.getValue().clearParsingErrors();
            entry.getValue().clearSemanticErrors();
        }

        for (DefaultMutableTreeNode node : fileTreePanel.getFileNodes().values()) {
            if (node.getUserObject() instanceof FileNode fileNode) {
                fileNode.clearCompilationData();
            }
        }
    }

    /**
     * Compile all files in the project
     */
    public boolean compileAllFiles() {
        if (!hasMainClass()) {
            notifier.alertToast("Debes seleccionar una Main Class antes de compilar", true);
            notifier.logError("No hay Main Class seleccionada");
            return false;
        }

        this.compilationContext = new CompilationContext();
        this.clearAllCompilationData();
        compiledOutput.clear();
        isCompiled = false;

        notifier.logWarning("Iniciando proceso de compilacion...");
        notifier.logInfo("Main Class: " + mainClassNode.getName());

        notifier.logInfo("Analisis sintactico en curso...");

        // SYNTACTIC PHASE
        this.executeParsingPhase();

        boolean syntacticErrors = this.verifyErrors("Error de compilacion: se encontraron: ");
        if (syntacticErrors) {
            return false;
        }
        notifier.logSuccess("Analisis sintactico completado");

        // AST BUILDING PHASE
        notifier.logWarning("Validando nombres de archivos .z...");

        ClassFileNameValidator classFileNameValidator = new ClassFileNameValidator();
        classFileNameValidator.validate(this.fileContexts);

        boolean classFileNameErrors = this.verifyErrors("Error de nombres de archivo: se encontraron: ");
        if (classFileNameErrors) {
            return false;
        }

        notifier.logSuccess("Validacion de nombres .z completada");

        // VERIFY STEPS
        DependencyAnalyzer dependencyAnalyzer = new DependencyAnalyzer();
        DependencyGraph dependencyGraph = dependencyAnalyzer.analyze(this.fileContexts);

        this.compilationContext.setDependencyGraph(dependencyGraph);

        if (dependencyGraph.hasErrors()) {
            for (CompilerError error : dependencyGraph.getErrors()) {
                EditorContext ctx = fileContexts.get(error.getFilePath());
                if (ctx != null) {
                    ctx.getSemanticErrors().add(error);
                }
            }
            this.verifyErrors("Error de importaciones: se encontraron: ");
            return false;
        }

        notifier.logSuccess("Verificacion de importaciones completada");

        notifier.logInfo("Recolectando simbolos...");

        SymbolCollectorOrchestrator symbolCollector = new SymbolCollectorOrchestrator(this.compilationContext.getDependencyGraph());
        GlobalSymbolTable symbolTable = symbolCollector.collectAll(this.fileContexts, this.compilationContext.getDependencyGraph().getTopologicalOrder());
        this.compilationContext.setSymbolTable(symbolTable);

        notifier.logSuccess("Recoleccion de simbolos completada");

        notifier.logInfo("Resolviendo referencias...");

        ReferenceResolverOrchestrator referenceResolver = new ReferenceResolverOrchestrator(this.compilationContext.getDependencyGraph());
        referenceResolver.resolveAll(this.fileContexts, this.compilationContext.getDependencyGraph().getTopologicalOrder(), this.compilationContext.getSymbolTable());

        boolean referenceErrors = this.verifyErrors("Error de referencias: se encontraron: ");
        if (referenceErrors) {
            return false;
        }

        notifier.logSuccess("Resolucion de referencias completada");

        notifier.logInfo("Verificando tipos...");

        TypeCheckerOrchestrator typeChecker = new TypeCheckerOrchestrator();
        typeChecker.checkAll(
                this.fileContexts,
                this.compilationContext.getDependencyGraph().getTopologicalOrder(),
                this.compilationContext.getSymbolTable(),
                this.compilationContext.getTypeAnnotations(),
                this.compilationContext.getResolvedCalls()
        );
        boolean typeErrors = this.verifyErrors("Error de tipos: se encontraron: ");
        if (typeErrors) {
            return false;
        }

        notifier.logSuccess("Verificacion de tipos completada");

        this.notifier.loadSymbolsTable(symbolTable.getAllSymbols());
        this.notifier.loadTypesTable(symbolTable.getAllSymbols());

        notifier.logInfo("Validando tamanios de arreglos...");

        ArraySizeValidatorOrchestrator arraySizeValidator = new ArraySizeValidatorOrchestrator();
        arraySizeValidator.validateAll(
                this.fileContexts,
                this.compilationContext.getDependencyGraph().getTopologicalOrder(),
                this.compilationContext.getSymbolTable()
        );

        boolean arraySizeErrors = this.verifyErrors("Error de tamanios de arreglos: se encontraron: ");
        if (arraySizeErrors) {
            return false;
        }

        notifier.logSuccess("Validacion de tamaños de arreglos completada");

        // 3D CODE PHASE
        notifier.logInfo("Generacion de codigo 3D en curso...");

        IntermediateProgram program = orchestrator.buildProgram(
                fileContexts,
                compilationContext.getSymbolTable(),
                compilationContext.getTypeAnnotations(),
                compilationContext.getResolvedCalls(),
                mainClassPath
        );

        List<CompilationArtifact> artifacts = compilationService.generateAll(program, GenerationOptions.defaults());

        compiledOutput.clear();
        for (CompilationArtifact artifact : artifacts) {
            compiledOutput.put(artifact.getTarget(), artifact.getContent());
            generateCompiledFile(artifact);
        }

        generateQuadruplesFile(orchestrator.dumpInstructions());
        this.notifier.loadQuadruplesTable(program);

        this.isCompiled = true;
        notifier.logSuccess("Generacion de codigo 3D completado");
        return true;
    }

    /**
     * Parse single file using the appropriate parser
     */
    private void parseFile(FileNode fileNode) {
        if (fileNode.isDirectory()) return;

        String filePath = fileNode.getFilePath();
        String extension = fileNode.getExtension();
        String content = fileNode.getContent();
        String fileName = fileNode.getName();

        if (content == null || content.isEmpty()) {
            return;
        }

        EditorContext context = getContextForFile(filePath);
        context.setSourceCode(content);
        context.setFileName(fileName);
        context.setFilePath(filePath);
        context.setFileExtension(extension);

        ParserAnalyzer parser = ParserFactory.getParser(extension);
        if (parser != null) {
            parser.parse(context);

            fileNode.getEditorContext().setParsed(true);

            String compiledCode = context.getCompiledCode();
            if (compiledCode != null && !compiledCode.isEmpty()) {
                fileNode.getEditorContext().setCompiledCode(compiledCode);
                fileNode.getEditorContext().setCompiled(true);
            }

            List<CompilerError> errors = context.getAllCompilerErrors();
            if (errors != null && !errors.isEmpty()) {
                for (CompilerError error : errors) {
                    error.setFilePath(filePath);
                    error.setFileName(fileName);
                }
                fileNode.addAllCompilationErrors(errors);
            }
        }
    }

    /**
     * Execute parsing phase for all project files
     */
    private void executeParsingPhase() {
        List<FileNode> allFiles = new ArrayList<>();
        collectAllFiles(fileTreePanel.getRootNode(), allFiles);

        List<FileNode> pigLatinFiles = new ArrayList<>();
        List<FileNode> zettaradianFiles = new ArrayList<>();
        List<FileNode> yFiles = new ArrayList<>();

        for (FileNode file : allFiles) {
            if (file.isDirectory()) continue;
            String ext = file.getExtension();
            switch (ext) {
                case ".pig":
                    pigLatinFiles.add(file);
                    break;
                case ".z":
                    zettaradianFiles.add(file);
                    break;
                case ".y":
                    yFiles.add(file);
                    break;
            }
        }

        // Phase 1: Parse all .y files (configurations)
        for (FileNode file : yFiles) {
            parseFile(file);
        }

        // Phase 2: Parse all Zettaradian files (.z)
        for (FileNode file : zettaradianFiles) {
            parseFile(file);
        }

        // Phase 3: Parse all PigLatin files (.pig)
        for (FileNode file : pigLatinFiles) {
            parseFile(file);
        }
    }

    /**
     * Collect all file nodes recursively
     */
    private void collectAllFiles(DefaultMutableTreeNode node, List<FileNode> files) {
        Object userObj = node.getUserObject();
        if (userObj instanceof FileNode fileNode) {
            if (!fileNode.isDirectory()) {
                files.add(fileNode);
            }
        }

        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            collectAllFiles(child, files);
        }
    }

    /**
     * Verify errors in different phases
     */
    private boolean verifyErrors(String message) {
        List<CompilerError> allErrors = getAllCompilationErrors();
        notifier.notifyErrorsUpdated(allErrors);

        if (!allErrors.isEmpty()) {
            notifier.logError(message + allErrors.size() + " errores");
            return true;
        }

        return false;
    }

    /**
     * Generate the quadruples file in compiled/cuartetas.txt
     */
    private void generateQuadruplesFile(String quadruplesText) {
        try {
            String quadPath = "compiled/cuartetas.txt";

            DefaultMutableTreeNode compiledFolderNode = fileTreePanel.findNodeByPath("compiled");
            if (compiledFolderNode == null) {
                fileTreePanel.createNewFile("compiled", true);
            }

            DefaultMutableTreeNode quadFileNode = fileTreePanel.getFileNodes().get(quadPath);
            if (quadFileNode != null && quadFileNode.getUserObject() instanceof FileNode existingFile) {
                existingFile.setContent(quadruplesText);
                existingFile.getEditorContext().setCompiledCode(quadruplesText);
                existingFile.getEditorContext().setCompiled(true);
                existingFile.setModified(false);

                updateContextForFile(quadPath, quadruplesText);
                notifier.notifySaveFile(quadPath, quadruplesText);

                if (editorService != null) {
                    editorService.updateEditorContentIfOpen(quadPath, quadruplesText, false);
                }
            } else {
                fileTreePanel.createNewFile("cuartetas.txt", false, "compiled");

                DefaultMutableTreeNode newNode = fileTreePanel.getFileNodes().get(quadPath);
                if (newNode != null && newNode.getUserObject() instanceof FileNode node) {
                    node.setContent(quadruplesText);
                    node.getEditorContext().setCompiledCode(quadruplesText);
                    node.getEditorContext().setCompiled(true);
                    node.setModified(false);

                    updateContextForFile(quadPath, quadruplesText);
                    notifier.notifySaveFile(quadPath, quadruplesText);
                }
            }

            fileTreePanel.reloadTree();
            notifier.logInfo("Cuartetas generadas en: " + quadPath);

        } catch (Exception e) {
            notifier.logError("Error al generar el archivo de cuartetas: " + e.getMessage());
        }
    }

    /**
     * Generate the final .c compiled file in compiled/main.c
     */
    private void generateCompiledFile(CompilationArtifact artifact) {
        String compiledPath = "compiled/" + artifact.getFileName();
        String compiledCode = artifact.getContent();

        try {
            DefaultMutableTreeNode compiledFolderNode = fileTreePanel.findNodeByPath("compiled");
            if (compiledFolderNode == null) {
                fileTreePanel.createNewFile("compiled", true);
            }

            DefaultMutableTreeNode compiledFileNode = fileTreePanel.getFileNodes().get(compiledPath);
            if (compiledFileNode != null && compiledFileNode.getUserObject() instanceof FileNode existingFile) {
                existingFile.setContent(compiledCode);
                existingFile.getEditorContext().setCompiledCode(compiledCode);
                existingFile.getEditorContext().setCompiled(true);
                existingFile.setModified(false);

                updateContextForFile(compiledPath, compiledCode);
                notifier.notifySaveFile(compiledPath, compiledCode);

                if (editorService != null) {
                    editorService.updateEditorContentIfOpen(compiledPath, compiledCode, false);
                }
            } else {
                fileTreePanel.createNewFile(artifact.getFileName(), false, "compiled");

                DefaultMutableTreeNode newNode = fileTreePanel.getFileNodes().get(compiledPath);
                if (newNode != null && newNode.getUserObject() instanceof FileNode node) {
                    node.setContent(compiledCode);
                    node.getEditorContext().setCompiledCode(compiledCode);
                    node.getEditorContext().setCompiled(true);
                    node.setModified(false);

                    updateContextForFile(compiledPath, compiledCode);
                    notifier.notifySaveFile(compiledPath, compiledCode);
                }
            }

            fileTreePanel.reloadTree();
            notifier.logInfo("Codigo compilado generado en: " + compiledPath);

        } catch (Exception e) {
            notifier.logError("Error al generar el archivo compilado: " + e.getMessage());
        }
    }

    /**
     * Method to re-key contexts and Main Class path after a file/folder rename.
     */
    public void handlePathRenamed(String oldPath, String newPath) {
        for (String key : new ArrayList<>(fileContexts.keySet())) {
            if (WorkspacePaths.isSameOrInside(key, oldPath)) {
                fileContexts.put(WorkspacePaths.replacePrefix(key, oldPath, newPath), fileContexts.remove(key));
            }
        }

        if (mainClassPath != null && WorkspacePaths.isSameOrInside(mainClassPath, oldPath)) {
            mainClassPath = WorkspacePaths.replacePrefix(mainClassPath, oldPath, newPath);
            notifier.notifyMainClassChanged(mainClassNode.getName());
        }
    }

    /**
     * Method to drop contexts after a file/folder removal.
     */
    public void handlePathRemoved(String path) {
        fileContexts.keySet().removeIf(key -> WorkspacePaths.isSameOrInside(key, path));

        if (mainClassPath != null && WorkspacePaths.isSameOrInside(mainClassPath, path)) {
            clearMainClass();
            notifier.logWarning("Se elimino la Main Class. Selecciona otra antes de compilar.");
        }
    }
}
