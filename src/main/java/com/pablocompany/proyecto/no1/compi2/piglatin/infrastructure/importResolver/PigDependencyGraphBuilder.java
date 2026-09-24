package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.importResolver;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.semantic.DependencyGraphBuilder;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.DependencyGraph;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports.ImportNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers.ImportCollectorVisitor;

import java.util.*;

/**
 * Principal graph dependency builder
 *
 */
public class PigDependencyGraphBuilder implements DependencyGraphBuilder {

    /**
     * Builder method of dependency graph
     *
     */
    @Override
    public DependencyGraph build(List<EditorContext> pigFiles, Map<String, EditorContext> allContexts) {
        DependencyGraph graph = new DependencyGraph();

        for (EditorContext pigContext : pigFiles) {
            List<ImportNode> imports = collectImports(pigContext);
            for (ImportNode importNode : imports) {
                resolveImport(importNode, allContexts, graph);
                if (importNode.getResolvedPath() != null) {
                    graph.addDependency(pigContext.getFilePath(), importNode.getResolvedPath());
                }
            }
        }

        graph.setTopologicalOrder(topologicalSort(graph));
        return graph;
    }

    /**
     * Runs the ImportCollectorVisitor over the .pig AST.
     */
    private List<ImportNode> collectImports(EditorContext pigContext) {
        if (!(pigContext.getAstNode() instanceof PigLatinAstNode pigAst)) {
            return Collections.emptyList();
        }

        ImportCollectorVisitor collector = new ImportCollectorVisitor(
                pigContext.getFilePath(),
                pigContext.getFileName()
        );
        pigAst.accept(collector);
        return collector.getImports();
    }

    /**
     * Resolves the raw import path against the workspace contexts.
     */
    private void resolveImport(ImportNode importNode, Map<String, EditorContext> allContexts, DependencyGraph graph) {
        String raw = importNode.getRawPath();
        String workspacePath = toWorkspacePath(raw);

        EditorContext target = allContexts.get(workspacePath);

        if (target == null) {
            graph.addError(buildError(
                    importNode,
                    "El archivo importado no existe: " + raw
            ));
            return;
        }

        if (".pig".equals(target.getFileExtension())) {
            graph.addError(buildError(
                    importNode,
                    "Un archivo .pig no puede importar otro .pig: " + raw
            ));
            return;
        }

        importNode.setResolvedPath(target.getFilePath());
        graph.getImportResolutionMap().put(importNode.getRawPath(), target.getFilePath());
    }

    /**
     * Converts "src.Persona.z" -> "src/Persona.z"
     * The last dot (before extension) is preserved.
     * Dots before that become slashes.
     */
    private String toWorkspacePath(String rawPath) {
        int lastDot = rawPath.lastIndexOf('.');
        if (lastDot == -1) {
            return rawPath;
        }

        String prefix = rawPath.substring(0, lastDot);
        String extension = rawPath.substring(lastDot);

        return prefix.replace('.', '/') + extension;
    }

    /**
     * Auxiliary build error
     *
     */
    private CompilerError buildError(ImportNode importNode, String description) {
        CompilerError error = new CompilerError();
        error.setLexeme(importNode.getRawPath());
        error.setLine(importNode.getLine());
        error.setColumn(importNode.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription(description);
        error.setFilePath(importNode.getDeclaredIn());
        error.setFileName(importNode.getDeclaredInName());
        return error;
    }

    /**
     * Kahn's algorithm. Detects cycles (should not happen with the .pig rule,
     * but kept as a safety net).
     */
    private List<String> topologicalSort(DependencyGraph graph) {
        Map<String, Integer> inDegree = new HashMap<>();

        for (String node : graph.getAdjacency().keySet()) {
            inDegree.putIfAbsent(node, 0);
        }
        for (List<String> deps : graph.getAdjacency().values()) {
            for (String dep : deps) {
                inDegree.merge(dep, 1, Integer::sum);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);

            for (String dep : graph.getDependenciesOf(current)) {
                int newDegree = inDegree.merge(dep, -1, Integer::sum);
                if (newDegree == 0) {
                    queue.add(dep);
                }
            }
        }

        if (order.size() < inDegree.size()) {
            CompilerError cycleError = new CompilerError();
            cycleError.setErrorType(ErrorType.SEMANTIC);
            cycleError.setDescription("Se detecto un ciclo en las dependencias entre archivos");
            graph.addError(cycleError);
        }

        return order;
    }

}