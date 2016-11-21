package main.actionlisteners;

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


            for (int i = 0; i < table.getRowCount(); i++) {
                if (name.equalsIgnoreCase(table.getValueAt(i, 0).toString())) {
                    System.out.println("Value is " + table.getValueAt(i, 0).toString() + " and entered was " + name);
                    ((DefaultTableModel)table.getModel()).removeRow(i);
                } else {
                    //table.removeRow(i);
                }
            }
        }
    }

    public void search(String name) {

    }
}
