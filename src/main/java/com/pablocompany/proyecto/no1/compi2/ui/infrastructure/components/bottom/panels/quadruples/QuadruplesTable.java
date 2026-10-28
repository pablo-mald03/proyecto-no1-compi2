package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.quadruples;

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
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateFunction;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

/**
 * Table component to display compiler intermediate code quadruples.
 *
 * @author pablo03
 */
public class QuadruplesTable extends JTable {

    private final DefaultTableModel tableModel;

    public QuadruplesTable() {
        String[] columnNames = {"#", "Función", "Operador", "Argumento 1", "Argumento 2", "Resultado"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setModel(tableModel);

        setupDesign();
        setupHeader();
        setupRenderer();
        setupColumnWidths();
    }

    private void setupDesign() {
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());
        setForeground(Theme.FOREGROUND_DARK.getColorSet());
        setSelectionBackground(Theme.SURFACE_DARK.getColorSet());
        setSelectionForeground(Color.WHITE);
        setFont(new Font("Liberation Mono", Font.PLAIN, 13));
        setRowHeight(30);

        setIntercellSpacing(new Dimension(1, 0));
        setFocusable(false);

        setShowVerticalLines(true);
        setShowHorizontalLines(true);
        setGridColor(Theme.BORDER_DARK.getColorSet());
    }

    private void setupHeader() {
        JTableHeader header = getTableHeader();
        header.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        header.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        header.setFont(new Font("Liberation Mono", Font.BOLD, 13));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_DARK.getColorSet()));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = headerRenderer.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);
                if (column == 0 || column == 2) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                }
                return c;
            }
        });
    }

    private void setupRenderer() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);

                if (column == 0 || column == 2) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));
                }

                if (!isSelected) {
                    switch (column) {
                        case 0:
                            c.setForeground(new Color(171, 178, 191)); // Subtle gray for index
                            break;
                        case 1:
                            c.setForeground(new Color(229, 192, 123)); // Warm yellow/gold for function
                            break;
                        case 2:
                            c.setForeground(new Color(86, 182, 194));  // Cyan for operator
                            break;
                        case 3:
                        case 4:
                            c.setForeground(new Color(152, 195, 121)); // Green for operands
                            break;
                        case 5:
                            c.setForeground(new Color(198, 120, 221)); // Purple for destination / target
                            break;
                        default:
                            c.setForeground(Theme.FOREGROUND_DARK.getColorSet());
                    }
                }
                return c;
            }
        };

        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    private void setupColumnWidths() {
        getColumnModel().getColumn(0).setPreferredWidth(55);
        getColumnModel().getColumn(0).setMaxWidth(80);

        getColumnModel().getColumn(1).setPreferredWidth(140);
        getColumnModel().getColumn(2).setPreferredWidth(120);
        getColumnModel().getColumn(3).setPreferredWidth(140);
        getColumnModel().getColumn(4).setPreferredWidth(140);
        getColumnModel().getColumn(5).setPreferredWidth(140);
    }

    /**
     * Loads the quadruples corresponding to an intermediate program into the table.
     */
    public void loadProgram(IntermediateProgram program) {
        clear();
        if (program == null || program.getFunctions() == null) {
            return;
        }

        int globalIndex = 0;
        for (IntermediateFunction function : program.getFunctions()) {
            String functionName = function.getName();
            for (Instruction ins : function.getBody()) {
                QuadrupleTuple tuple = toQuadruple(ins);
                tableModel.addRow(new Object[]{
                        globalIndex++,
                        functionName,
                        tuple.operator,
                        tuple.arg1,
                        tuple.arg2,
                        tuple.result
                });
            }
        }
    }

    public void clear() {
        tableModel.setRowCount(0);
    }

    // -------------------------------------------------------------------------
    // Quadruple conversion helper
    // -------------------------------------------------------------------------

    private record QuadrupleTuple(String operator, String arg1, String arg2, String result) {}

    private QuadrupleTuple toQuadruple(Instruction ins) {
        if (ins instanceof BinaryOperation bo) {
            return new QuadrupleTuple(bo.getOperator().getSymbol(), fmtReg(bo.getLeft()), fmtReg(bo.getRight()), fmtReg(bo.getDestination()));
        }
        if (ins instanceof UnaryOperation uo) {
            return new QuadrupleTuple(uo.getOperator().name(), fmtReg(uo.getSource()), "-", fmtReg(uo.getDestination()));
        }
        if (ins instanceof Move mv) {
            return new QuadrupleTuple("=", fmtOp(mv.getSource()), "-", fmtReg(mv.getDestination()));
        }
        if (ins instanceof Load ld) {
            return new QuadrupleTuple("LOAD[" + ld.getSpace().name().toLowerCase() + "]", fmtAddr(ld.getAddress()), "-", fmtReg(ld.getDestination()));
        }
        if (ins instanceof Store st) {
            return new QuadrupleTuple("STORE[" + st.getMemorySpace().name().toLowerCase() + "]", fmtReg(st.getSource()), "-", fmtAddr(st.getAddress()));
        }
        if (ins instanceof LoadAddress la) {
            return new QuadrupleTuple("ADDR", fmtAddr(la.getAddress()), "-", fmtReg(la.getDestination()));
        }
        if (ins instanceof LoadLabelAddress lla) {
            return new QuadrupleTuple("LABEL_ADDR", "&" + lla.getLabel(), "-", fmtReg(lla.getDestination()));
        }
        if (ins instanceof IndexAddress ia) {
            return new QuadrupleTuple("INDEX_ADDR", fmtReg(ia.getBase()), fmtReg(ia.getIndex()), fmtReg(ia.getDestination()));
        }
        if (ins instanceof LoadIndexed li) {
            return new QuadrupleTuple("LOAD_INDEXED", fmtAddr(li.getBase()), fmtReg(li.getIndex()), fmtReg(li.getDestination()));
        }
        if (ins instanceof StoreIndexed si) {
            return new QuadrupleTuple("STORE_INDEXED", fmtReg(si.getSource()), fmtReg(si.getIndex()), fmtAddr(si.getBase()));
        }
        if (ins instanceof MarkLabel ml) {
            return new QuadrupleTuple("LABEL", ml.getName(), "-", "-");
        }
        if (ins instanceof Jump j) {
            return new QuadrupleTuple("GOTO", "-", "-", j.getTarget());
        }
        if (ins instanceof BranchIf bi) {
            return new QuadrupleTuple(bi.isJumpWhen() ? "IF_TRUE" : "IF_FALSE", fmtReg(bi.getCondition()), "-", bi.getTarget());
        }
        if (ins instanceof Call c) {
            return new QuadrupleTuple("CALL", c.getFunction(), "-", "-");
        }
        if (ins instanceof CallIndirect ci) {
            return new QuadrupleTuple("CALL_IND", fmtReg(ci.getTargetRegister()), "-", "-");
        }
        if (ins instanceof Return) {
            return new QuadrupleTuple("RETURN", "-", "-", "-");
        }
        if (ins instanceof Print pr) {
            return new QuadrupleTuple(pr.isNewLine() ? "PRINTLN" : "PRINT", fmtReg(pr.getSource()), "-", "-");
        }
        if (ins instanceof Read rd) {
            return new QuadrupleTuple("READ[" + rd.getType().name().toLowerCase() + "]", "-", "-", fmtAddr(rd.getTarget()));
        }
        if (ins instanceof HeapAlloc ha) {
            String slotsDesc = ha.getDynamicSlots() != null ? fmtOp(ha.getDynamicSlots()) : (ha.getSlots() + " slots");
            return new QuadrupleTuple("HEAP_ALLOC", slotsDesc, "-", fmtReg(ha.getDestination()));
        }
        if (ins instanceof FramePush) {
            return new QuadrupleTuple("FRAME_PUSH", "-", "-", "-");
        }
        if (ins instanceof FramePop) {
            return new QuadrupleTuple("FRAME_POP", "-", "-", "-");
        }
        if (ins instanceof FrameRebase fr) {
            return new QuadrupleTuple("FRAME_REBASE", "-" + fr.getSlotsBelowTop(), "-", "-");
        }
        if (ins instanceof AdjustStackTop ast) {
            return new QuadrupleTuple("ADJUST_STACK", (ast.getDelta() >= 0 ? "+" : "") + ast.getDelta(), "-", "-");
        }
        if (ins instanceof Convert cv) {
            return new QuadrupleTuple("CONVERT[" + cv.getTarget().name().toLowerCase() + "]", fmtReg(cv.getSource()), "-", fmtReg(cv.getDestination()));
        }
        if (ins instanceof ConvertToString cs) {
            return new QuadrupleTuple("TO_STRING", fmtReg(cs.getSource()), "-", fmtReg(cs.getTarget()));
        }
        if (ins instanceof NewString ns) {
            return new QuadrupleTuple("NEW_STRING", "-", "-", fmtReg(ns.getDestination()));
        }
        if (ins instanceof StringConcat sc) {
            return new QuadrupleTuple("CONCAT", fmtReg(sc.getLeft()), fmtReg(sc.getRight()), fmtReg(sc.getDestination()));
        }

        return new QuadrupleTuple(ins.getClass().getSimpleName(), ins.toString(), "-", "-");
    }

    private static String fmtReg(Register r) {
        if (r == null) return "-";
        return r.getRole().name() + "_" + r.getType().name().toLowerCase();
    }

    private static String fmtAddr(Address addr) {
        if (addr == null) return "-";
        if (addr instanceof StackTop st) return "stack[" + st.getOffset() + "]";
        return addr.toString();
    }

    private static String fmtOp(Operand op) {
        if (op == null) return "-";
        if (op instanceof Register r) return fmtReg(r);
        if (op instanceof Immediate imm) return imm.getLiteral() + ":" + imm.getType().name().toLowerCase();
        return op.toString();
    }
}
