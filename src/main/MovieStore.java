package main;/*
    Manage video rentals and controls when videos are checked out,
    due to return, overdue fees and for added complexity create a summary
    of those accounts which are overdue for contact.
*/
// TODO: Action Listeners

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MovieStore extends JFrame {

    // Control Panel
    // MAIN METHOD
    public static void main(String[] args) {
        MovieStore ms = new MovieStore();

        AccountInfo info = new AccountInfo();
        ArrayList<Account> writeData = new ControlPanelUI().getAccounts();
        ms.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                for (int i = 0; i < writeData.size(); i++) {
                    String[] accountInfo = {writeData.get(i).getFirstName(), writeData.get(i).getLastName(),
                            writeData.get(i).getPhoneNumber(), Integer.toString(writeData.get(i).getBooks())};

                    info.write(accountInfo);
                }
            }
        });

        ms.setSize(800, 600);
        ms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ms.setResizable(false);
        ms.setVisible(true);
    }

    // Add components and functionality to control panel here.
    private MovieStore() {
        // Main Frame, Includes entire window excluding title bar.
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(Color.DARK_GRAY);

        ControlPanelUI controlPanel = new ControlPanelUI(this);
        controlPanel.createLeftCP();
        controlPanel.createRightCP();
    }


}
