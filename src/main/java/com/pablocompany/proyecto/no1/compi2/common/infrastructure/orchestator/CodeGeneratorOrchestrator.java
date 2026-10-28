package com.pablocompany.proyecto.no1.compi2.common.infrastructure.orchestator;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.IndexAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.LoadIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.arrays.StoreIndexed;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.assingation.Store;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.convertion.Convert;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Call;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.CallIndirect;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.functions.Jump;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FramePush;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.FrameRebase;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.heap.HeapAlloc;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Print;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.io.Read;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.LoadLabelAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.labels.MarkLabel;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.BinaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.ConvertToString;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.NewString;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.StringConcat;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.UnaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.AdjustStackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Load;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.LoadAddress;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Move;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Return;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.statements.BranchIf;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Instruction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Operand;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StackTop;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateFunction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.naming.NameMangler;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.CodeGeneratorFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZClassLayoutService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZInheritanceService;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service.ZSymbolLookupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Principal code generator orchestator
 *
 */
public class CodeGeneratorOrchestrator {
    private IntermediateProgram lastProgram;

    public IntermediateProgram buildProgram(Map<String, EditorContext> allContexts, GlobalSymbolTable table, Map<AstNode, Type> typeAnnotations, Map<AstNode, Symbol> resolvedCalls, String mainClassPath) {

        IntermediateBuilder intermediate = new IntermediateBuilder("program", "str");
        CodeGenContext labels = new CodeGenContext();

        ZClassLayoutService layoutService = new ZClassLayoutService(table, new ZInheritanceService(new ZSymbolLookupService(table)));
        for (Symbol cls : layoutService.collectLinkedClasses()) {
            List<String> entries = new ArrayList<>();
            for (Symbol m : cls.getVtable()) {
                entries.add(NameMangler.codeLabel(m));
            }
            intermediate.addVTable(cls.getVtableLabel(), entries);
        }

        for (EditorContext ctx : contextsOf(allContexts, ".y", mainClassPath)) {
            CodeGeneratorFactory.create(".y").generate(ctx, table, typeAnnotations, resolvedCalls, intermediate, labels);
        }
        for (EditorContext ctx : contextsOf(allContexts, ".z", mainClassPath)) {
            CodeGeneratorFactory.create(".z").generate(ctx, table, typeAnnotations, resolvedCalls, intermediate, labels);
        }
        EditorContext mainCtx = allContexts.get(mainClassPath);
        if (mainCtx != null) {
            CodeGeneratorFactory.create(".pig").generate(mainCtx, table, typeAnnotations, resolvedCalls, intermediate, labels);
        }
        lastProgram = intermediate.build();
        return lastProgram;
    }

    /**
     * Extension context generation code
     */
    private List<EditorContext> contextsOf(Map<String, EditorContext> all, String ext, String firstPath) {
        List<EditorContext> result = new ArrayList<>();
        EditorContext first = all.get(firstPath);
        if (first != null && ext.equals(first.getFileExtension())) result.add(first);
        for (Map.Entry<String, EditorContext> e : all.entrySet()) {
            EditorContext c = e.getValue();
            if (c != null && c != first && ext.equals(c.getFileExtension())) result.add(c);
        }
        return result;
    }

    /**
     * Dump instructions as human-readable intermediate representation.
     */
    public String dumpInstructions() {
        if (lastProgram == null) return "";
        StringBuilder sb = new StringBuilder();
        for (IntermediateFunction f : lastProgram.getFunctions()) {
            sb.append(f.getName()).append(":\n");
            int i = 0;
            for (Instruction ins : f.getBody()) {
                sb.append(String.format("  %-4d %s%n", i++, formatInstruction(ins)));
            }
        }
        return sb.toString();
    }

    /** Principal method to format instructions */
    private String formatInstruction(Instruction ins) {
        if (ins instanceof MarkLabel ml)
            return ml.getName() + ":";
        if (ins instanceof BranchIf bi)
            return "if " + (bi.isJumpWhen() ? "" : "!") + fmtReg(bi.getCondition()) + " goto " + bi.getTarget();
        if (ins instanceof Jump j)
            return "goto " + j.getTarget();
        if (ins instanceof Call c)
            return "call " + c.getFunction();
        if (ins instanceof CallIndirect ci)
            return "call *" + fmtReg(ci.getTargetRegister());
        if (ins instanceof Return)
            return "return";
        if (ins instanceof Move mv)
            return fmtReg(mv.getDestination()) + " = " + fmtOp(mv.getSource());
        if (ins instanceof Load ld)
            return fmtReg(ld.getDestination()) + " = load[" + ld.getSpace().name().toLowerCase() + "] " + fmtAddr(ld.getAddress());
        if (ins instanceof LoadAddress la)
            return fmtReg(la.getDestination()) + " = addr " + fmtAddr(la.getAddress());
        if (ins instanceof LoadLabelAddress lla)
            return fmtReg(lla.getDestination()) + " = label_addr &" + lla.getLabel();
        if (ins instanceof Store st)
            return "store[" + st.getMemorySpace().name().toLowerCase() + "] " + fmtAddr(st.getAddress()) + " <- " + fmtReg(st.getSource());
        if (ins instanceof BinaryOperation bo)
            return fmtReg(bo.getDestination()) + " = " + fmtReg(bo.getLeft()) + " " + bo.getOperator().getSymbol() + " " + fmtReg(bo.getRight());
        if (ins instanceof UnaryOperation uo)
            return fmtReg(uo.getDestination()) + " = " + uo.getOperator().name().toLowerCase() + " " + fmtReg(uo.getSource());
        if (ins instanceof Convert cv)
            return fmtReg(cv.getDestination()) + " = convert(" + cv.getTarget().name().toLowerCase() + ") " + fmtReg(cv.getSource());
        if (ins instanceof ConvertToString cs)
            return fmtReg(cs.getTarget()) + " = to_string " + fmtReg(cs.getSource());
        if (ins instanceof NewString ns)
            return fmtReg(ns.getDestination()) + " = new_string";
        if (ins instanceof StringConcat sc)
            return fmtReg(sc.getDestination()) + " = concat(" + fmtReg(sc.getLeft()) + ", " + fmtReg(sc.getRight()) + ")";
        if (ins instanceof IndexAddress ia)
            return fmtReg(ia.getDestination()) + " = index_addr " + fmtReg(ia.getBase()) + "[" + fmtReg(ia.getIndex()) + "]";
        if (ins instanceof LoadIndexed li)
            return fmtReg(li.getDestination()) + " = load_indexed " + fmtAddr(li.getBase()) + "[" + fmtReg(li.getIndex()) + "]";
        if (ins instanceof StoreIndexed si)
            return "store_indexed " + fmtAddr(si.getBase()) + "[" + fmtReg(si.getIndex()) + "] <- " + fmtReg(si.getSource());
        if (ins instanceof HeapAlloc ha)
            return fmtReg(ha.getDestination()) + " = heap_alloc " + (ha.getDynamicSlots() != null ? fmtOp(ha.getDynamicSlots()) + " slots" : ha.getSlots() + " slots");
        if (ins instanceof FramePush)
            return "frame_push";
        if (ins instanceof FramePop)
            return "frame_pop";
        if (ins instanceof FrameRebase fr)
            return "frame_rebase -" + fr.getSlotsBelowTop();
        if (ins instanceof AdjustStackTop ast)
            return "adjust_stack " + (ast.getDelta() >= 0 ? "+" : "") + ast.getDelta();
        if (ins instanceof Print pr)
            return "print" + (pr.isNewLine() ? "ln" : "") + " " + fmtReg(pr.getSource());
        if (ins instanceof Read rd)
            return fmtAddr(rd.getTarget()) + " = read(" + rd.getType().name().toLowerCase() + ")";
        return ins.toString();
    }

    private String fmtReg(Register r) {
        return r.getRole().name() + "_" + r.getType().name().toLowerCase();
    }

    private String fmtAddr(Address addr) {
        if (addr instanceof StackTop st) return "stack[" + st.getOffset() + "]";
        return addr.toString();
    }

    private String fmtOp(Operand op) {
        if (op instanceof Register r) return fmtReg(r);
        if (op instanceof Immediate imm) return imm.getLiteral() + ":" + imm.getType().name().toLowerCase();
        return op.toString();
    }
}