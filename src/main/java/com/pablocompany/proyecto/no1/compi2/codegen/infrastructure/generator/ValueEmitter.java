package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Storage;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Cell;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Constant;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generateModels.Text;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort.Value;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.assingation.Store;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.convertion.Convert;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.enums.BinaryOperations;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.BinaryOperation;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.ConvertToString;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.operations.NewString;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Load;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.instructions.stack.Move;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StringRef;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;

/**
 * Principal value emitter value class
 *
 */
public class ValueEmitter {
    private final IntermediateBuilder intermediate;
    private final FunctionFrame frame;

    public ValueEmitter(IntermediateBuilder intermediate, FunctionFrame frame) {
        this.intermediate = intermediate;
        this.frame = frame;
    }

    /**
     * Method to load coerced types
     *
     */
    public void loadCoerced(Value value, Register reg) {
        ValueType src = value.type();
        ValueType dst = reg.getType();

        if (src == dst || src.getStorage() == dst.getStorage()) {
            load(value, reg);
            return;
        }
        if ((src.getStorage() == Storage.WORD || src.getStorage() == Storage.POINTER)
                && (dst.getStorage() == Storage.WORD || dst.getStorage() == Storage.POINTER)) {
            load(value, reg);
            return;
        }
        if (src.getStorage() == Storage.WORD && dst.getStorage() == Storage.FLOAT) {
            Register scratch = Register.ax(ValueType.INT);
            load(value, scratch);
            intermediate.emit(new Convert(scratch, reg, ValueType.FLOAT));
            return;
        }
        if (src.getStorage() == Storage.FLOAT && dst.getStorage() == Storage.WORD) {
            Register scratch = Register.ax(ValueType.FLOAT);
            load(value, scratch);
            intermediate.emit(new Convert(scratch, reg, ValueType.INT));
            return;
        }
        throw new IllegalStateException("Coercion no soportada: " + src + " → " + dst);
    }

    /**
     * Assignation value
     */
    public void load(Value value, Register reg) {
        switch (value) {
            case Constant constant ->
                    intermediate.emit(new Move(new Immediate(constant.getLiteral(), reg.getType()), reg));
            case Text t -> intermediate.emit(new Move(new StringRef(t.getPoolId()), reg));
            case Cell c -> {
                requireCompatible(c.type(), reg.getType());
                intermediate.emit(new Load(MemorySpace.STACK, c.getAddress(), reg));
            }
            default -> throw new IllegalStateException("Valor inesperado: " + value);
        }
    }

    /**
     * Helper to store at register the value
     */
    public void store(Value value, Cell dest) {
        Register scratch = Register.cx(dest.type());
        loadCoerced(value, scratch);
        intermediate.emit(new Store(MemorySpace.STACK, dest.getAddress(), scratch));
    }
    /**
     * Save the register as a temporal
     */
    public Cell spill(Register reg) {
        Cell cell = frame.temp(reg.getType());
        intermediate.emit(new Store(MemorySpace.STACK, cell.getAddress(), reg));
        return cell;
    }

    /**
     * Helper method to find the value
     */
    public void incDec(Value target, BinaryOperations op) {
        Cell cell = requireCell(target);
        ValueType type = cell.type() == ValueType.FLOAT ? ValueType.FLOAT : ValueType.INT;
        Register a = Register.ax(type), b = Register.bx(type), c = Register.cx(type);
        load(cell, a);
        intermediate.emit(new Move(new Immediate("1", type), b));
        intermediate.emit(new BinaryOperation(op, a, b, c));
        intermediate.emit(new Store(MemorySpace.STACK, cell.getAddress(), c));
    }

    /**
     * Translate the value to string
     */
    public Value asString(Value value) {
        if (value.type() == ValueType.STRING) return value;
        Register source = Register.ax(value.type());
        Register buffer = Register.cx(ValueType.STRING);
        load(value, source);
        intermediate.emit(new NewString(buffer));
        intermediate.emit(new ConvertToString(source, buffer));
        return spill(buffer);
    }

    /**
     * Fallback helper require cell method
     *
     */
    public Cell requireCell(Value value) {
        if (value instanceof Cell cell) return cell;
        throw new IllegalStateException("Se esperaba una variable asignable y se obtuvo " + value);
    }

    /**
     * Fallback helper method
     *
     */
    private static void requireCompatible(ValueType memory, ValueType register) {
        if (isWordAligned(memory) && isWordAligned(register)) return;
        if (memory.getStorage() != register.getStorage()) {
            throw new IllegalStateException("No se puede cargar " + memory + " en un registro " + register
                    + " sin conversión explícita (¿mezcla int/float sin cast?)");
        }
    }

    /**
     * Method to returns true for types that are physically a 32-bit word (WORD or POINTER storage).
     */
    private static boolean isWordAligned(ValueType t) {
        return t.getStorage() == Storage.WORD || t.getStorage() == Storage.POINTER;
    }
}
