package com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors;

/**
 * Principal service class to translate the parsing errors
 *
 */
public class TranslatorErrorService {

    /**
     * Translation service method
     *
     */
    public static String translateError(String message) {

        message = message.replace("expecting", "se esperaba:");
        message = message.replace("extraneous", "Inesperado,");
        message = message.replace("input", "se encontro:");
        message = message.replace("mismatched", "Inaceptable,");
        message = message.replace("at", "antes de");
        message = message.replace("missing", "Falto colocar");
        message = message.replace("no", "No");
        message = message.replace("alternantes", "alternativa");
        message = message.replace("deive", "de codigo");

        return message;
    }
}
