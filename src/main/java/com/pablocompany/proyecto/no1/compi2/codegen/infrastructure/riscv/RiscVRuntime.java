package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv;

import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.CodeWriter;

/**
 * Principal configurations for the risc V runtime
 *
 */
public class RiscVRuntime {
    private RiscVRuntime() {
    }

    /**
     * Principal code writer method
     *
     */
    public static void emit(CodeWriter out) {
        out.blank().raw("# ---------------- runtime ----------------");

        out.raw("__rt_itoa:");
        for (String l : new String[]{
                "mv a2, a1", "bgez a0, __itoa_nonneg", "li a3, 45", "sb a3, 0(a2)", "addi a2, a2, 1", "sub a0, zero, a0"})
            out.line(l);
        out.raw("__itoa_nonneg:");
        for (String l : new String[]{"mv a4, a2", "li a5, 10"}) out.line(l);
        out.raw("__itoa_loop:");
        for (String l : new String[]{
                "rem a3, a0, a5", "div a0, a0, a5", "addi a3, a3, 48", "sb a3, 0(a2)", "addi a2, a2, 1",
                "bnez a0, __itoa_loop", "sb zero, 0(a2)", "mv a7, a2", "addi a2, a2, -1"})
            out.line(l);
        out.raw("__itoa_rev:");
        for (String l : new String[]{
                "bge a4, a2, __itoa_done", "lb a3, 0(a4)", "lb a6, 0(a2)", "sb a6, 0(a4)", "sb a3, 0(a2)",
                "addi a4, a4, 1", "addi a2, a2, -1", "j __itoa_rev"})
            out.line(l);
        out.raw("__itoa_done:");
        out.line("mv a0, a7").line("ret").blank();

        out.raw("__rt_ftoa:");
        for (String l : new String[]{
                "addi sp, sp, -4", "sw ra, 0(sp)", "fmv.x.w a2, fa0", "bgez a2, __ftoa_pos",
                "li a3, 45", "sb a3, 0(a1)", "addi a1, a1, 1", "fneg.s fa0, fa0"})
            out.line(l);
        out.raw("__ftoa_pos:");
        for (String l : new String[]{
                "fcvt.w.s a0, fa0, rtz", "fcvt.s.w ft3, a0", "fsub.s ft3, fa0, ft3",
                "li a3, 1000000", "fcvt.s.w ft4, a3", "fmul.s ft3, ft3, ft4",
                "jal ra, __rt_itoa", "fcvt.w.s a4, ft3",
                "li a3, 46", "sb a3, 0(a0)", "addi a0, a0, 1", "addi a2, a0, 6", "sb zero, 0(a2)",
                "li a5, 10", "li a6, 6"})
            out.line(l);
        out.raw("__ftoa_frac:");
        for (String l : new String[]{
                "addi a2, a2, -1", "rem a3, a4, a5", "div a4, a4, a5", "addi a3, a3, 48", "sb a3, 0(a2)",
                "addi a6, a6, -1", "bnez a6, __ftoa_frac", "lw ra, 0(sp)", "addi sp, sp, 4", "ret"})
            out.line(l);
        out.blank();

        out.raw("__rt_concat:");
        for (String l : new String[]{"mv a2, a0", "mv a3, a1", "mv a4, a2"}) out.line(l);
        out.raw("__cc_len1:");
        for (String l : new String[]{"lb a5, 0(a4)", "beqz a5, __cc_len1_done", "addi a4, a4, 1", "j __cc_len1"})
            out.line(l);
        out.raw("__cc_len1_done:");
        for (String l : new String[]{"sub a4, a4, a2", "mv a5, a3"}) out.line(l);
        out.raw("__cc_len2:");
        for (String l : new String[]{"lb a6, 0(a5)", "beqz a6, __cc_len2_done", "addi a5, a5, 1", "j __cc_len2"})
            out.line(l);
        out.raw("__cc_len2_done:");
        for (String l : new String[]{"sub a5, a5, a3", "add a0, a4, a5", "addi a0, a0, 1", "li a7, 9", "ecall", "mv a6, a0"})
            out.line(l);
        out.raw("__cc_copy1:");
        for (String l : new String[]{"lb t6, 0(a2)", "beqz t6, __cc_copy2", "sb t6, 0(a6)", "addi a2, a2, 1", "addi a6, a6, 1", "j __cc_copy1"})
            out.line(l);
        out.raw("__cc_copy2:");
        for (String l : new String[]{"lb t6, 0(a3)", "beqz t6, __cc_end", "sb t6, 0(a6)", "addi a3, a3, 1", "addi a6, a6, 1", "j __cc_copy2"})
            out.line(l);
        out.raw("__cc_end:");
        out.line("sb zero, 0(a6)").line("ret").blank();

        out.raw("__rt_readline:");
        for (String l : new String[]{"mv a2, a0", "li a1, 1024", "li a7, 8", "ecall", "li a3, 10"}) out.line(l);
        out.raw("__rl_loop:");
        for (String l : new String[]{"lb a4, 0(a2)", "beqz a4, __rl_done", "beq a4, a3, __rl_cut", "addi a2, a2, 1", "j __rl_loop"})
            out.line(l);
        out.raw("__rl_cut:");
        out.line("sb zero, 0(a2)");
        out.raw("__rl_done:");
        out.line("ret");
    }
}
