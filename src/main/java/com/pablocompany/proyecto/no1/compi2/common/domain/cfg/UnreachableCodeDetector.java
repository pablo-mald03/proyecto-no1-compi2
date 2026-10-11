package com.pablocompany.proyecto.no1.compi2.common.domain.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;

import java.util.*;

/**
 * Principal unreachable code detector class
 *
 */
public class UnreachableCodeDetector {

    /**
     * Detector method
     * */
    public void detect(CFG cfg, EditorContext context) {
        if (cfg == null || cfg.getEntryId() < 0) return;

        Set<Integer> reachable = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(cfg.getEntryId());
        reachable.add(cfg.getEntryId());

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int succ : cfg.getSuccessors().getOrDefault(current, List.of())) {
                if (!reachable.contains(succ)) {
                    reachable.add(succ);
                    queue.add(succ);
                }
            }
        }

        for (CFGNode node : cfg.getNodes().values()) {
            if (reachable.contains(node.getId())) continue;
            if (node.getType() == NodeType.ENTRY || node.getType() == NodeType.EXIT) continue;
            if (node.getType() == NodeType.MERGE) continue;
            if (node.getAstNode() == null) continue;

            reportUnreachable(node, context);
        }
    }

    /**
     * Principal report unreachable method
     *
     */
    private void reportUnreachable(CFGNode node, EditorContext context) {
        CompilerError error = new CompilerError();
        error.setLexeme(node.getLabel());
        error.setLine(node.getLine());
        error.setColumn(node.getColumn());
        error.setErrorType(ErrorType.SEMANTIC);
        error.setDescription("Codigo inalcanzable: " + node.getLabel());
        error.setFilePath(context.getFilePath());
        error.setFileName(context.getFileName());
        context.getSemanticErrors().add(error);
    }
}