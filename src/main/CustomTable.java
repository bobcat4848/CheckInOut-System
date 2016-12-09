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

    public void addRow(String[] data) {
        Object[][] oldArray = this.data;
        this.data = new Object[oldArray.length+1][4];

        for (int i = 0; i < oldArray.length; i++) {
            this.data[i] = oldArray[i];
        }

        this.data[this.data.length-1][0] = data[0];
        this.data[this.data.length-1][1] = data[1];
        this.data[this.data.length-1][2] = data[2];
        this.data[this.data.length-1][3] = data[3];
        fireTableDataChanged();
    }
}