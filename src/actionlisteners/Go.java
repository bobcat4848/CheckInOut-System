package actionlisteners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Go implements ActionListener {

    private JTable table;

    public Go(JTable table) {
        this.table = table;
    }

    public void actionPerformed(ActionEvent e) {
        String searchCritera = "";

        if (e.getSource() instanceof JTextField) {
            JTextField field = (JTextField) e.getSource();
            searchCritera = field.getText();

            for (int i = 0; i < table.getRowCount(); i++) {
                table.removeAll();
            }
        }
        JButton go = (JButton) e.getSource();

    }
}
