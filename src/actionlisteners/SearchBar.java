package actionlisteners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchBar extends MouseAdapter implements ActionListener  {

    private CP table = new resources.CP();

    public void mouseEntered(MouseEvent e) {
        JTextField searchBar = (JTextField) e.getSource();

        if (searchBar.getText().equalsIgnoreCase("SEARCH USERS")) {
            searchBar.setText("");
        }
    }

    public void mouseExited(MouseEvent e) {
        JTextField searchBar = (JTextField) e.getSource();

        if (searchBar.getText().equals("")) {
            searchBar.setText("SEARCH USERS");
        }
    }

    public void actionPerformed(ActionEvent e) {
        JTextField searchBar = (JTextField) e.getSource();


        if (!searchBar.getText().equals("")) {
            new Go(table).actionPerformed(e);
        }
    }
}
