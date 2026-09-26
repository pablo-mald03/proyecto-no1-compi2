/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.types;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This table is a component that represents a Types table
 * @author pablo03
 */
public class TypesTable extends JTable {

    private final DefaultTableModel tableModel;

    public TypesTable() {
        String[] columnNames = {"Nombre", "Tipo", "Cantidad de campos", "Nombre de campos", "Tipos de campos"};
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

    //This method setup the principal design
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
    //This method setup the principal header

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
                if (column > 0) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                }
                return c;
            }
        });
    }

    private void setupRenderer() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);

                if (column > 0) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                } else {
                    setHorizontalAlignment(SwingConstants.LEFT);
                    setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));
                }

                if (!isSelected) {
                    switch (column) {
                        case 0:
                            c.setForeground(new Color(86, 182, 194));
                            break;
                        case 1:
                            c.setForeground(new Color(229, 192, 123));
                            break;
                        case 2:
                            c.setForeground(new Color(152, 195, 121));
                            break;
                        case 3:
                            c.setForeground(new Color(198, 120, 221));
                            break;
                        case 4:
                        case 5:
                            c.setForeground(new Color(171, 178, 191));
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

    private void setupColumnWidths() {
        getColumnModel().getColumn(0).setPreferredWidth(150);
        getColumnModel().getColumn(1).setPreferredWidth(80);
        getColumnModel().getColumn(2).setPreferredWidth(60);

        getColumnModel().getColumn(3).setPreferredWidth(300);

        getColumnModel().getColumn(4).setPreferredWidth(300);

    }

    //Method to load the type symbols to the table.
    public void loadSymbols(List<Symbol> symbols) {

        clear();

        if (symbols == null || symbols.isEmpty()) {
            return;
        }

        Set<String> alreadyAdded = new HashSet<>();

        for (Symbol symbol : symbols) {

            boolean isTypeDefinition = symbol.getKind() == SymbolKind.CLASS
                    || symbol.getKind() == SymbolKind.STRUCT;

            if (!isTypeDefinition) {
                continue;
            }

            if (!alreadyAdded.add(symbol.getName())) {
                continue;
            }

            List<Symbol> members = symbol.getMembers();
            int fieldCount = (members == null) ? 0 : members.size();

            String fieldNames = (members == null || members.isEmpty())
                    ? "-"
                    : members.stream().map(Symbol::getName).collect(Collectors.joining(", "));

            String fieldTypes = (members == null || members.isEmpty())
                    ? "-"
                    : members.stream().map(Symbol::getType).collect(Collectors.joining(", "));

            tableModel.addRow(new Object[]{
                    symbol.getName(),
                    symbol.getKind(),
                    fieldCount,
                    fieldNames,
                    fieldTypes
            });
        }
    }

    public void clear() {
        tableModel.setRowCount(0);
    }
}
