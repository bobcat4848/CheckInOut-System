package actionlisteners;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Go implements ActionListener {

    private JTable table;
    private JTextField textfield;

    public Go(JTable table, JTextField textField) {
        this.table = table;
        this.textfield = textField;
    }

    public void actionPerformed(ActionEvent e) {
        if (!textfield.getText().equals("") || textfield != null) {
            String name = textfield.getText();

            for (int i = 0; i <= table.getRowCount(); i++) {
                if (name != table.getValueAt(i, 0)) {
                    ((DefaultTableModel)table.getModel()).removeRow(i);
                } else {
                    name = (String) table.getValueAt(i, 0);
                    clearTable();
                    table.setValueAt(name, i, 0);
                }
            }
            table.repaint();

            //search(name);
        }
    }

    public void search(String name) {

    }

    public void clearTable() {
        for (int i = 0; i < table.getColumnCount(); i++) {
            for (int j = 0; j < table.getRowCount(); j++) {
                table.setValueAt(null, j, i);
            }
        }
    }
}
