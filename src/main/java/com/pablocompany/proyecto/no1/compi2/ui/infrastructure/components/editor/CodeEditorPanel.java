package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.codetext.CodeTextPane;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;


/**
 * Class used to represents an editor panel
 * @author pablo03
 */
@Getter
public class CodeEditorPanel extends JPanel {

    private final CodeTextPane editor;
    private final LineNumberView lineNumbers;
    private final JScrollPane scroll;
    private final EditorStatusBar statusBar;
    private WorkspaceNotifier notifierReference;
    private String currentExtension = "";

    private boolean editable;

    public CodeEditorPanel(WorkspaceNotifier notifierReference) {
        setLayout(new BorderLayout());
        setBackground(Theme.SIDEBAR_LIGHT.getColorSet());

        this.notifierReference = notifierReference;

        this.editable = true;
        editor = new CodeTextPane(this.notifierReference);
        editor.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        editor.setForeground(Theme.FOREGROUND_DARK.getColorSet());

        scroll = new JScrollPane(editor);
        lineNumbers = new LineNumberView(editor);
        scroll.setRowHeaderView(lineNumbers);

        statusBar = new EditorStatusBar();

        add(scroll, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder());

        editor.setCaretColor(Theme.FOREGROUND_DARK.getColorSet());
        editor.addCaretListener(e -> updateCaretPosition());
    }

    // ==========================================
    // EXTENSION MANAGEMENT
    // ==========================================

    /**
     * Set the file extension and update the editor
     */
    public void setFileExtension(String extension) {
        this.currentExtension = extension;
        editor.setCurrentExtension(extension);
    }

    /**
     * Get the current file extension
     */
    public String getFileExtension() {
        return currentExtension;
    }

    /**
     * Set whether the editor is editable
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
        editor.setEditable(editable);

        if (!editable) {
            editor.setBackground(Theme.SIDEBAR_DARKT.getColorSet());
            editor.setToolTipText("Archivo en modo de solo lectura (ByteCode)");
        } else {
            editor.setBackground(Theme.BACKGROUND_DARK.getColorSet());
            editor.setToolTipText(null);
        }
    }


    /**
     * This method updates the caret position to the sidebar
     *
     */
    private void updateCaretPosition() {
        try {
            int caret = editor.getCaretPosition();
            int line = editor.getDocument()
                    .getDefaultRootElement()
                    .getElementIndex(caret);
            int lineStart = editor.getDocument()
                    .getDefaultRootElement()
                    .getElement(line)
                    .getStartOffset();
            int column = caret - lineStart;
            statusBar.updateCursor(line + 1, column + 1);
            lineNumbers.repaint();
        } catch (Exception ignored) {
            /* Do nothing*/
        }
    }

    /**
     * Set the code content in the editor
     */
    public void setCode(String code) {
        editor.setText(code != null ? code : "");
        updateCaretPosition();
    }

    /**
     * Get the code content from the editor
     */
    public String getCode() {
        return editor.getText();
    }


    //This method is the principal to compile the code
   /* public boolean compile(WorkspaceNotifier notifier) {
       /* if (getCode().isBlank()) {
            notifier.logError("El codigo fuente esta vacio");
            return false;
        }

        this.editor.clearCompiledCode();
        this.editor.clearStackView();
        this.editor.clearAll();

        try {

            this.editor.getEditorContext().clearParsingErrors();
            this.editor.getEditorContext().setSourceCode(getCode());

            //Parsing delegated
            CodexSyntaxAnalizer analyzer = new CodexSyntaxAnalizer();
            boolean isSyntaxValid = analyzer.executeParsingPhase(this.editor.getEditorContext(), notifier);

            this.notifierReference.notifyAstRepresentation(getAst());
            this.notifierReference.notifyStackView(getStackList());

            if (!isSyntaxValid) {
                notifier.notifyErrorsUpdated(this.editor.getEditorContext().getCompilerErrors());
                notifier.logError("Se encontraron errores Sintacticos");
                return false;
            }

            // --- SEMANTIC PART ---
            //Semantic delegated
            CodexSemanticAnalyzer semanticAnalyzer = new CodexSemanticAnalyzer();
            boolean isSemanticValid = semanticAnalyzer.executeSemanticPhase(this.editor.getEditorContext(), notifier);

            notifier.notifySymbolUpdated(this.editor.getEditorContext().getGlobalEnvironment().getAllSymbolsForUI());
            notifier.notifyTypesUpdated(this.editor.getEditorContext().getGlobalEnvironment().getAllStructsForUI());

            if (!isSemanticValid) {
                notifier.notifyErrorsUpdated(this.editor.getEditorContext().getCompilerErrors());
                notifier.logError("Se encontraron errores Semanticos");
                return false;
            }

            this.notifierReference.notifyCompiledCode(getCompiledCode());

            notifier.logSuccess("Compilación exitosa.");
            return true;

        } catch (Exception e) {
            notifier.logError("Fallo crítico del compilador: " + e.getMessage());
            return false;
        }

    }*/

    //This method indicate if the code is compiled
    /*public String getCompiledCode() {
        return this.editor.getEditorContext().getCompiledCode();
    }

    //This method return the stack list
    public List<ParseStep> getStackList() {
        return this.editor.getEditorContext().getStackSteps();
    }

    //This method return the ast string
    public String getAst() {
        return this.editor.getEditorContext().getGraphvizCode();
    }*/

}
