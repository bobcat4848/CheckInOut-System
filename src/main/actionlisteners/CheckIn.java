package main.actionlisteners;

import main.Account;
import main.AccountInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckIn implements ActionListener {

    private JTable table;
    private ArrayList<Account> accounts;

    public CheckIn(JTable table, ArrayList<Account> accounts) {
        this.table = table;
        this.accounts = accounts;
    }

    public void actionPerformed(ActionEvent e) {
        int index = table.getSelectedRow();
        if (table.getSelectedRow() > 1) {
            index = table.getSelectedRow() - 1;
        }
        int books = accounts.get(index).getBooks();
        System.out.println(books);

        if (books > 0) {
            table.setValueAt(books - 1, table.getSelectedRow(), 3);

            accounts.get(index).addBook(-1);
            System.out.println("Books: " + accounts.get(index).getBooks());
            /*
            AccountInfo info = new AccountInfo();
            HashMap<Integer, String[]> accountData = info.read();
            String[] userData = accountData.get(table.getSelectedRow());
            userData[userData.length-1] = Integer.toString(books-1);
            accountData.put(table.getSelectedRow(), userData);*/
        }
    }
}
