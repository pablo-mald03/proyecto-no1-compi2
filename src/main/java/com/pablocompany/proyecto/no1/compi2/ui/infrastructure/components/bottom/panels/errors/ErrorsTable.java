/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.errors;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.PrincipalColors;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author pablo03
 */
//This class is the principal Table to sho the errors 
public class ErrorsTable extends JTable {

    private final DefaultTableModel tableModel;

    public ErrorsTable() {
        String[] columnNames = {"Lexema", "Línea", "Columna", "Tipo", "Descripción"};
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
    }

    private void setupDesign() {
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());
        setForeground(Theme.FOREGROUND_DARK.getColorSet());
        setSelectionBackground(Theme.SURFACE_DARK.getColorSet());
        setSelectionForeground(Color.WHITE);
        setFont(new Font("Liberation Mono", Font.PLAIN, 13));
        setRowHeight(30);

        setIntercellSpacing(new Dimension(1, 0));
        setFocusable(false);

        setShowVerticalLines(true);
        setShowHorizontalLines(true);
        setGridColor(Theme.BORDER_DARK.getColorSet());
    }

    //Method who setup the header table
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

    //Render the columns
    private void setupRenderer() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);

                if (column == 1 || column == 2 || column == 3) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));
                }

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
                return c;
            }
        };

        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    //Setup the columns width
    private void setupColumnWidths() {
        getColumnModel().getColumn(0).setPreferredWidth(130);

        getColumnModel().getColumn(1).setPreferredWidth(90);
        getColumnModel().getColumn(1).setMaxWidth(120);

        getColumnModel().getColumn(2).setPreferredWidth(90);
        getColumnModel().getColumn(2).setMaxWidth(120);

        getColumnModel().getColumn(3).setPreferredWidth(120);
        getColumnModel().getColumn(3).setMaxWidth(180);

        getColumnModel().getColumn(4).setPreferredWidth(400);
    }

    //Method to fill the table with the errors
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
                error.getLine(),
                error.getColumn(),
                error.getErrorType().getContext(),
                error.getDescription()
            });
        }
    }

    //Method to clear the table
    public void clear() {
        tableModel.setRowCount(0);
    }
}
