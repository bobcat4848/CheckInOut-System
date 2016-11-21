package main;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class CustomTable extends AbstractTableModel {
    private String[] columnNames;
    private Object[][] data;

    // Create a custom table that isn't editable by the user by clicking
    public CustomTable(Object[][] data, String[] columnNames) {
        this.columnNames = columnNames;
        this.data = data;
    }

    public int getColumnCount() { return columnNames.length; }

    public int getRowCount() { return data.length; }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    public void removeAllRows() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }

        fireTableDataChanged();
    }
}