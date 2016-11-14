package actionlisteners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchBar extends MouseAdapter implements ActionListener  {

    private JTable table;
    private JTextField searchBar;

    public SearchBar(JTable table) {
        this.table = table;
    }

    public void mouseEntered(MouseEvent e) {
        searchBar = (JTextField) e.getSource();

        if (searchBar.getText().equalsIgnoreCase("SEARCH USERS")) {
            searchBar.setText("");
        }
    }

    public void mouseExited(MouseEvent e) {
        searchBar = (JTextField) e.getSource();

        if (searchBar.getText().equals("")) {
            searchBar.setText("SEARCH USERS");
        }
    }

    public void actionPerformed(ActionEvent e) {
        searchBar = (JTextField) e.getSource();


        if (!searchBar.getText().equals("")) {
            new Go(table, searchBar).actionPerformed(e);
        }
    }
}
