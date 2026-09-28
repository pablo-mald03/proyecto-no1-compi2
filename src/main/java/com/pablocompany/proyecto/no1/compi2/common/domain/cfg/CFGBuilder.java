package com.pablocompany.proyecto.no1.compi2.common.domain.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;

/**
 * Class to build the control flow graph
 *
 */
public interface CFGBuilder {
    CFG build(AstNode ast, EditorContext context);

    String getSupportedExtension();
}