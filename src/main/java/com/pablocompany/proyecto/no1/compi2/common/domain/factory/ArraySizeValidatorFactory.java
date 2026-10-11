package com.pablocompany.proyecto.no1.compi2.common.domain.factory;

import com.pablocompany.proyecto.no1.compi2.common.domain.arraySize.ArraySizeValidator;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.sizeValidation.PigArraySizeValidatorAdapter;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.sizeValidation.ZArraySizeValidatorAdapter;

/**
 * Principal factoryc lass that returns the appropriate array size validator for a file extension.
 */
public class ArraySizeValidatorFactory {


    public static ArraySizeValidator create(String fileExtension) {
        if (fileExtension == null) return null;
        return switch (fileExtension) {
            case ".pig" -> new PigArraySizeValidatorAdapter();
            // case ".y" -> new YArraySizeValidatorAdapter();
            case ".z" -> new ZArraySizeValidatorAdapter();
            default -> null;
        };
    }
}