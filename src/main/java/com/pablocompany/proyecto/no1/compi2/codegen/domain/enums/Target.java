package com.pablocompany.proyecto.no1.compi2.codegen.domain.enums;

import lombok.Getter;

/**
 * Principal enum target representation
 *
 */
@Getter
public enum Target {
    C("C (gcc)", "c"),
    RISCV("RISC-V RV32IMF (RARS)", "s");

    private final String displayName;
    private final String fileExtension;

    Target(String displayName, String fileExtension) {
        this.displayName = displayName;
        this.fileExtension = fileExtension;
    }
}
