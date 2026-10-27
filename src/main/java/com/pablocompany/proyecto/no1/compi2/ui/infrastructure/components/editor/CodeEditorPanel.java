package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.codetext.CodeTextPane;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelListener;


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

    private Font baseFont;
    private int zoomPercent = 100;

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

        this.baseFont = editor.getFont();
        installZoomShortcuts();
        installZoomWheel();
    }


    /**
     * Method for applies a zoom level
     */
    public void setZoomPercent(int percent) {
        if (percent == zoomPercent || baseFont == null) return;
        this.zoomPercent = percent;

        float size = Math.max(6f, Math.round(baseFont.getSize2D() * percent / 100f));
        editor.setFont(baseFont.deriveFont(size));

        lineNumbers.syncWithEditorFont();
        statusBar.updateZoom(percent);

        scroll.revalidate();
        scroll.repaint();
    }

    /**
     * Change the 100% font (e.g. a font picker) while keeping the current zoom level
     */
    public void setBaseFont(Font font) {
        if (font == null) return;
        this.baseFont = font;
        int current = zoomPercent;
        this.zoomPercent = -1;
        setZoomPercent(current);
    }

    private void installZoomShortcuts() {
        int ctrl = KeyEvent.CTRL_DOWN_MASK;
        bindZoom("zoom-in", this::zoomIn,
                KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ctrl),
                KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ctrl | KeyEvent.SHIFT_DOWN_MASK),
                KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ctrl),
                KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ctrl));
        bindZoom("zoom-out", this::zoomOut,
                KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ctrl),
                KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ctrl));
        bindZoom("zoom-reset", this::zoomReset,
                KeyStroke.getKeyStroke(KeyEvent.VK_0, ctrl),
                KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, ctrl));
    }

    private void bindZoom(String name, Runnable action, KeyStroke... keys) {
        for (KeyStroke key : keys) {
            editor.getInputMap(JComponent.WHEN_FOCUSED).put(key, name);
        }
        editor.getActionMap().put(name, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
            }
        });
    }

    /**
     * Method for the Ctrl + mouse wheel zooms. Without Ctrl the original scroll
     */
    private void installZoomWheel() {
        MouseWheelListener[] original = scroll.getMouseWheelListeners();
        for (MouseWheelListener l : original) {
            scroll.removeMouseWheelListener(l);
        }
        scroll.addMouseWheelListener(e -> {
            if (e.isControlDown()) {
                if (e.getWheelRotation() < 0) {
                    zoomIn();
                } else if (e.getWheelRotation() > 0) {
                    zoomOut();
                }
                e.consume();
            } else {
                for (MouseWheelListener l : original) {
                    l.mouseWheelMoved(e);
                }
            }
        });
    }

    /**
     * Method for zoom in
     *
     */
    private void zoomIn() {
        if (notifierReference != null) notifierReference.notifyZoomIn();
    }

    /**
     * Method for zoom out
     *
     */
    private void zoomOut() {
        if (notifierReference != null) notifierReference.notifyZoomOut();
    }

    private void zoomReset() {
        if (notifierReference != null) notifierReference.notifyZoomReset();
    }


    /**
     * Set the file extension and update the editor
     */
    public void setFileExtension(String extension, String filePath, String fileName) {
        this.currentExtension = extension;
        editor.setCurrentExtension(extension, filePath, fileName);
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

}
