/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author karel
 */
public class TableFunc {
    public static void centerHeaderTable(JTable t) {
        TableCellRenderer rendererFromHeader = t.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        JTableHeader header = t.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
    }

    public static void centeringRow(JTable j) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < j.getColumnCount(); i++) {
            j.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        centerHeaderTable(j);
    }
}
