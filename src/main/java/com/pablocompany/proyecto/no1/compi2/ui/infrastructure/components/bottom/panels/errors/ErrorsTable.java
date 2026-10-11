/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.errors;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.PrincipalColors;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

/**
 * This class is the principal Table to show the errors
 * @author pablo03
 */
public class ErrorsTable extends JTable {

    private static final int MIN_ROW_HEIGHT = 30;
    private static final int MIN_CHARS_PER_LINE = 10;
    private static final int SAFETY_PX = 4;

    private final DefaultTableModel tableModel;
    private boolean adjustingHeights = false;

    public ErrorsTable() {
        String[] columnNames = {"Lexema", "Archivo", "Directorio", "Línea", "Columna", "Tipo", "Descripción"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setModel(tableModel);

        setupDesign();

        setupHeader();

        setupRenderer();

        setupColumnWidths();

        setRowHeight(MIN_ROW_HEIGHT);
    }

    /**
     * This method set up the desing of the table
     *
     */
    private void setupDesign() {
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());
        setForeground(Theme.FOREGROUND_DARK.getColorSet());
        setSelectionBackground(Theme.SURFACE_DARK.getColorSet());
        setSelectionForeground(Color.WHITE);
        setFont(new Font("Liberation Mono", Font.PLAIN, 13));
        setRowHeight(MIN_ROW_HEIGHT);

        setIntercellSpacing(new Dimension(1, 0));
        setFocusable(false);

        setShowVerticalLines(true);
        setShowHorizontalLines(true);
        setGridColor(Theme.BORDER_DARK.getColorSet());
    }

    /**
     * Method who set up the headers of the table
     */
    private void setupHeader() {
        JTableHeader header = getTableHeader();
        header.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        header.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        header.setFont(new Font("Liberation Mono", Font.BOLD, 13));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_DARK.getColorSet()));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = headerRenderer.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);
                if (column == 1 || column == 2 || column == 3) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                }
                return c;
            }
        });
    }

    /**
     * Padding horizontal total (izquierda + derecha) que usa cada columna.
     * Debe coincidir con los bordes definidos en el renderer.
     */
    private int horizontalPadding(int column) {
        return (column >= 1 && column <= 4) ? 10 : 30;
    }

    /**
     * Cuantos caracteres caben por linea en una columna, segun su ancho actual
     * y el ancho de un caracter de la fuente (monoespaciada, asi que es exacto).
     */
    private int maxCharsPerLine(int column) {
        int colWidth = getColumnModel().getColumn(column).getWidth();
        int charWidth = getFontMetrics(getFont()).charWidth('W');
        int available = colWidth - horizontalPadding(column) - SAFETY_PX;
        return Math.max(MIN_CHARS_PER_LINE, available / Math.max(1, charWidth));
    }

    private static String escapeHtml(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    /**
     * Convierte el texto en HTML con saltos de linea (<br>) respetando el limite
     * de caracteres por linea. Corta por palabras y, si una palabra sola no cabe
     * (rutas, lexemas largos), la parte en trozos.
     */
    private String toWrappedHtml(String text, int maxChars) {
        StringBuilder out = new StringBuilder("<html>");
        String[] paragraphs = text.split("\n", -1);

        for (int p = 0; p < paragraphs.length; p++) {
            if (p > 0) {
                out.append("<br>");
            }

            int len = 0; // caracteres en la linea visual actual
            for (String word : paragraphs[p].split(" ", -1)) {

                // Palabra mas larga que una linea completa: partirla
                while (word.length() > maxChars) {
                    if (len > 0) {
                        out.append("<br>");
                        len = 0;
                    }
                    out.append(escapeHtml(word.substring(0, maxChars))).append("<br>");
                    word = word.substring(maxChars);
                }

                int needed = (len == 0 ? 0 : 1) + word.length();
                if (len > 0 && len + needed > maxChars) {
                    out.append("<br>");
                    len = 0;
                    needed = word.length();
                }
                if (len > 0) {
                    out.append(' ');
                }
                out.append(escapeHtml(word));
                len += needed;
            }
        }
        return out.toString();
    }

    /**
     * Render the columns method
     *
     */
    private void setupRenderer() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);

                // Center alignment for specific columns
                if (column == 1 || column == 2 || column == 3 || column == 4) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
                }

                setVerticalAlignment(SwingConstants.CENTER);

                if (!isSelected) {
                    switch (column) {
                        case 0:
                            c.setForeground(PrincipalColors.COLOR_LEXEME_TABLE.getColorSet());
                            break;
                        case 1:
                        case 2:
                            c.setForeground(PrincipalColors.COLOR_NUMBER_TABLE.getColorSet());
                            break;
                        case 3:
                            c.setForeground(PrincipalColors.COLOR_TYPE_TABLE.getColorSet());
                            break;
                        case 4:
                            c.setForeground(PrincipalColors.COLOR_ERROR_TABLE.getColorSet());
                            break;
                        default:
                            c.setForeground(Theme.FOREGROUND_DARK.getColorSet());
                    }
                }

                // Auto-wrap de cualquier columna de texto (los numeros no son String)
                if (value instanceof String) {
                    String text = (String) value;
                    int maxChars = maxCharsPerLine(column);
                    if (text.length() > maxChars || text.indexOf('\n') >= 0) {
                        setText(toWrappedHtml(text, maxChars));
                    }
                }

                return c;
            }
        };

        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    /**
     * Set up the columns width
     *
     */
    private void setupColumnWidths() {

        getColumnModel().getColumn(0).setPreferredWidth(120);

        getColumnModel().getColumn(1).setPreferredWidth(100);

        getColumnModel().getColumn(2).setPreferredWidth(120);

        getColumnModel().getColumn(3).setPreferredWidth(90);
        getColumnModel().getColumn(3).setMaxWidth(110);

        getColumnModel().getColumn(4).setPreferredWidth(90);
        getColumnModel().getColumn(4).setMaxWidth(110);

        getColumnModel().getColumn(5).setPreferredWidth(120);
        getColumnModel().getColumn(5).setMaxWidth(120);

        getColumnModel().getColumn(6).setPreferredWidth(350);
        // Allow description column to grow
        getColumnModel().getColumn(6).setMinWidth(200);
    }

    /**
     * Calcula el alto de cada fila segun la celda mas alta (sin tope maximo).
     */
    private void adjustRowHeights() {
        if (adjustingHeights) {
            return;
        }
        adjustingHeights = true;
        try {
            for (int row = 0; row < getRowCount(); row++) {
                int rowHeight = MIN_ROW_HEIGHT;

                for (int column = 0; column < getColumnCount(); column++) {
                    if (!(getValueAt(row, column) instanceof String)) {
                        continue;
                    }
                    Component comp = prepareRenderer(getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height + 4);
                }

                // Solo si cambia: setRowHeight dispara otro layout y podria ciclar
                if (getRowHeight(row) != rowHeight) {
                    setRowHeight(row, rowHeight);
                }
            }
        } finally {
            adjustingHeights = false;
        }
    }

    /**
     * Method to fill the table with the errors
     */
    public void loadErrors(List<CompilerError> errors) {

        if ((errors == null || errors.isEmpty()) && tableModel.getRowCount() == 0) {
            return;
        }

        clear();

        if (errors == null || errors.isEmpty()) {
            return;
        }

        for (CompilerError error : errors) {
            tableModel.addRow(new Object[]{
                    error.getLexeme(),
                    error.getFileName(),
                    error.getFilePath(),
                    error.getLine(),
                    error.getColumn(),
                    error.getErrorType().getContext(),
                    error.getDescription()
            });
        }

        adjustRowHeights();
    }

    /**
     * Method to clear the table
     */
    public void clear() {
        tableModel.setRowCount(0);
        // Reset row heights
        setRowHeight(MIN_ROW_HEIGHT);
    }

    /**
     * Override to recalculate row heights when columns are resized
     */
    @Override
    public void doLayout() {
        super.doLayout();
        // Only recalculate if there are rows
        if (getRowCount() > 0) {
            adjustRowHeights();
        }
    }
}