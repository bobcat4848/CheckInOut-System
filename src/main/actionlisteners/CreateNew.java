package main.actionlisteners;

import main.Account;
import main.AccountInfo;
import main.ControlPanelUI;
import main.CustomTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNew implements ActionListener {

    private JFrame frame;
    private JTable table;

    public CreateNew(JFrame frame, JTable table) {
        this.frame = frame;
        this.table = table;
    }


    public void actionPerformed(ActionEvent e) {
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField phoneNumber = new JTextField();
        Object[] message = {
                "First Name:", firstName,
                "Last Name:", lastName,
                "Phone Number:", phoneNumber
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Create New", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Account user = new Account(firstName.getText(), lastName.getText(), phoneNumber.getText(), 0);

            String[] userInfo = {user.getFirstName(), user.getLastName(), user.getPhoneNumber(), "0"};
            AccountInfo info = new AccountInfo();
            info.write(userInfo);

            CustomTable custom = (CustomTable) table.getModel();
            custom.addRow(userInfo);
        }
    }
}
