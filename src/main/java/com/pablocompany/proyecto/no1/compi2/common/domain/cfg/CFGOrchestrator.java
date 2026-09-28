package com.pablocompany.proyecto.no1.compi2.common.domain.cfg;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Principal class orchestator for the CFG implementations
 *
 */
public class CFGOrchestrator {

    /**
     * Principal method to analyze all files
     *
     */
    public Map<String, CFG> buildAll(Map<String, EditorContext> allContexts) {
        Map<String, CFG> result = new HashMap<>();

        for (String filePath : allContexts.keySet()) {
            EditorContext ctx = allContexts.get(filePath);
            if (ctx == null) continue;
            if (!ctx.isParsed()) continue;

            CFGBuilder builder = CFGBuilderFactory.create(ctx.getFileExtension());
            if (builder == null) continue;

            CFG cfg = builder.build(ctx.getAstNode(), ctx);
            if (cfg != null) {
                result.put(filePath, cfg);
            }
        }

        return result;
    }
}