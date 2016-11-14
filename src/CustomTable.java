import javax.swing.table.AbstractTableModel;
import java.util.HashMap;

public class CustomTable extends AbstractTableModel {
    private String[] columnNames;
    private HashMap<Integer, Object[]> newData;

    public CustomTable(HashMap<Integer, Object[]> newData, String[] columnNames) {
        this.newData = newData;
        this.columnNames = columnNames;
    }

    public int getColumnCount() { return columnNames.length; }

    public int getRowCount() { return newData.size(); }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object[] rowData = newData.get(row);
        return rowData[col];
    }

    public void setValueAt(Object value, int row, int col) {
        Object[] rowData = newData.get(row);
        rowData[col] = value;

        fireTableCellUpdated(row, col);
    }

    public void removeRow(int row) {
        newData.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
