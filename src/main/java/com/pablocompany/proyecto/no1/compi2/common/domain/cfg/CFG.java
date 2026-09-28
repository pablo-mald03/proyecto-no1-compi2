package com.pablocompany.proyecto.no1.compi2.common.domain.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Control flow graph representation class
 *
 */
@Data
public class CFG {

    private final Map<Integer, CFGNode> nodes = new LinkedHashMap<>();
    private final Map<Integer, List<Integer>> successors = new LinkedHashMap<>();
    private final Map<Integer, List<Integer>> predecessors = new LinkedHashMap<>();
    private int nextId = 0;
    private int entryId = -1;
    private int exitId = -1;

    /**
     * Principal method to create a new node
     *
     */
    public CFGNode createNode(String label, NodeType type, AstNode astNode) {
        int id = nextId++;
        CFGNode node = new CFGNode(id, label, type);
        if (astNode != null) {
            node.setAstNode(astNode);
            node.setLine(astNode.getLine());
            node.setColumn(astNode.getColumn());
        }
        nodes.put(id, node);
        successors.put(id, new ArrayList<>());
        predecessors.put(id, new ArrayList<>());
        return node;
    }

    /**
     * Method to add a new edge
     *
     */
    public void addEdge(int from, int to) {
        if (from < 0 || to < 0) return;
        if (!nodes.containsKey(from) || !nodes.containsKey(to)) return;
        if (!successors.get(from).contains(to)) {
            successors.get(from).add(to);
        }
        if (!predecessors.get(to).contains(from)) {
            predecessors.get(to).add(from);
        }
    }

    /**
     * Helper to add a new edge from node
     *
     */
    public void addEdge(CFGNode from, CFGNode to) {
        if (from == null || to == null) return;
        addEdge(from.getId(), to.getId());
    }

    /**
     * Get success nodes
     *
     */
    public List<CFGNode> getSuccessors(CFGNode node) {
        List<CFGNode> result = new ArrayList<>();
        for (int id : successors.getOrDefault(node.getId(), List.of())) {
            result.add(nodes.get(id));
        }
        return result;
    }

    /**
     * Get predecessors helper
     *
     */
    public List<CFGNode> getPredecessors(CFGNode node) {
        List<CFGNode> result = new ArrayList<>();
        for (int id : predecessors.getOrDefault(node.getId(), List.of())) {
            result.add(nodes.get(id));
        }
        return result;
    }
}