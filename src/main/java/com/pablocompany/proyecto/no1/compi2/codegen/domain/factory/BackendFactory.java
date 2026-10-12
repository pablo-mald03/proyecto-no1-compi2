package com.pablocompany.proyecto.no1.compi2.codegen.domain.factory;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.TargetBackend;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c.generate.CBackend;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.riscv.ports.RiscVBackend;
import com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils.GenerationOptions;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Principal factory to generate the 3D code
 *
 */
public class BackendFactory {
    private final Map<Target, Function<GenerationOptions, TargetBackend>> creators = new EnumMap<>(Target.class);

    /**
     * Principal backend factory method for the default compiler options
     *
     */
    public static BackendFactory withDefaults() {
        return new BackendFactory()
                .register(Target.C, CBackend::new)
                .register(Target.RISCV, RiscVBackend::new);
    }

    /**
     * Principal backend helper to register the code compilation source
     *
     */
    public BackendFactory register(Target target, Function<GenerationOptions, TargetBackend> creator) {
        creators.put(target, creator);
        return this;
    }

    /**
     * Principal method to create a new backend
     *
     */
    public TargetBackend create(Target target, GenerationOptions options) {
        Function<GenerationOptions, TargetBackend> creator = creators.get(target);
        if (creator == null) throw new IllegalArgumentException("Backend no registrado: " + target);
        return creator.apply(options);
    }
}