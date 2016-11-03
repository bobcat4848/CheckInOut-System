/*
    Manage video rentals and controls when videos are checked out,
    due to return, overdue fees and for added complexity create a summary
    of those accounts which are overdue for contact.
*/
// TODO: Action Listeners

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MovieStore extends JFrame {

    // Control Panel
    // MAIN METHOD
    public static void main(String[] args) {
        MovieStore ms = new MovieStore();

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

        CP controlPanel = new CP(container);
        controlPanel.createLeftCP();
        controlPanel.createRightCP();
    }


}
