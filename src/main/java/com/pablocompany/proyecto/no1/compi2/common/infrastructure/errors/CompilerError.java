package com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author pablo03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompilerError {
    
    private String lexeme;
    private int line;
    private int column;
    private ErrorType errorType;
    private String description;

    private String filePath;
    private String fileName;
    
}
