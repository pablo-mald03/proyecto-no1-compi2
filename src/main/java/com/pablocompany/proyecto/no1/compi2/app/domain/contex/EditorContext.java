/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablocompany.proyecto.no1.compi2.app.domain.contex;

import com.pablocompany.proyecto.no1.compi2.app.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.errors.CompilerError;
import lombok.Data;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo03
 */
@Data
public class EditorContext {

    private String graphvizCode;

    private String sourceCode;

    private List<Token> tokens;

    private List<CompilerError> lexicalErrors;

    private List<CompilerError> parserErrors;

    private List<CompilerError> semanticErrors;

    private ParseTree parseTree;

    /*   private com.pablocompany.practica.no1.compi2.domain.semantic.AstNode ast;*/

    private String compiledCode;

    private boolean isParsed;

 /*   private Environment globalEnvironment;

    //Pointer to the current enviroment in runtime
    private Environment currentEnvironment;
*/

    //This is the pointer to the scoped registry
    /*    private Map<String, Environment> scopeRegistry;*/

    public EditorContext() {
        this.tokens = new ArrayList<>();
        this.compiledCode = "";
        this.isParsed = false;
        this.lexicalErrors = new ArrayList<>();
        this.parserErrors = new ArrayList<>();
        this.semanticErrors = new ArrayList<>();

/*        this.globalEnvironment = new Environment("Global");
        this.currentEnvironment = this.globalEnvironment;*/
    }

    //This method add a new error to the list
    public void addLexicalError(String lexeme, int line, int column, String filePath, String fileName) {
        this.lexicalErrors.add(new CompilerError(lexeme, line, column, ErrorType.LEXIC, "Caracter no definido en el lenguaje", filePath, fileName));
    }

    /*The method clears the lexical arraylist*/
    public void clearLexicalErrors() {
        this.lexicalErrors.clear();
    }

    /*The method clears the parser arraylist*/
    public void clearParsingErrors() {
        this.parserErrors.clear();
    }

    /*The method clears the semantic arraylist*/
    public void clearSemanticErrors() {
        this.semanticErrors.clear();
    }

    /*This method returns the compiler errors (merged)*/
    public List<CompilerError> getAllCompilerErrors() {
        List<CompilerError> errors = new ArrayList<>();

        errors.addAll(lexicalErrors);
        errors.addAll(parserErrors);
        errors.addAll(semanticErrors);

        return errors;
    }

    //This method create a new scope into the global enviroment
/*
    public void enterScope(String scopeName) {
        currentEnvironment = new Environment(currentEnvironment, scopeName);
    }

    //This method closes the pointer to the current enviroment and returns up to the principal scope
    public void exitScope() {
        if (currentEnvironment.getParent() != null) {
            currentEnvironment = currentEnvironment.getParent();
        }
    }
*/

    //This method clears the compilated code
    public void clearCompilatedCode() {
        this.compiledCode = "";
    }

    //This method clear all the memory in the instances
    public void clearAll() {
        this.compiledCode = "";
        this.isParsed = false;

        // this.ast = null;
    }

}
