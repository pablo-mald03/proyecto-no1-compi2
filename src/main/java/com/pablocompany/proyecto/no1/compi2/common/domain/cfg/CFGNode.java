package com.pablocompany.proyecto.no1.compi2.common.domain.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Principal CFG Node for the graph
 *
 */
@Data
@AllArgsConstructor
public class CFGNode {

    private int id;
    private String label;
    private NodeType type;
    private AstNode astNode;
    private int line;
    private int column;

    public CFGNode(int id, String label, NodeType type) {
        this.id = id;
        this.label = label;
        this.type = type;
        this.astNode = null;
        this.line = 0;
        this.column = 0;
    }
}