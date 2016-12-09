package main;

import main.actionlisteners.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControlPanelUI {

    private JTable tableOfUsers;
    private JFrame frame;
    private Container contentPane;
    private ArrayList<Account> accounts = new ArrayList<>();
    private String[] columnNames = {"First Name", "Last Name", "Phone", "Books Out"};
    private Object[][] data;

    // Button initalization to prevent null pointer exceptions when button listeners interact with table.
    private JButton createNew = new JButton("CREATE NEW");
    private JButton checkIn = new JButton("CHECK IN");
    private JButton checkOut = new JButton("CHECK OUT");

    public ControlPanelUI(JFrame frame) {
        this.frame = frame;
        this.contentPane = frame.getContentPane();
    }

    public ControlPanelUI() {
    }

    public void setupTable() {
        addAccounts();

        data = new Object[accounts.size()][4];
        tableOfUsers = new JTable(new CustomTable(data, columnNames));
        for (int i = 0; i < data.length; i++) {
            for (int r = 0; r < data[i].length; r++) {
                data[i][0] = accounts.get(i).getFirstName();
                data[i][1] = accounts.get(i).getLastName();
                data[i][2] = accounts.get(i).getPhoneNumber();
                data[i][3] = accounts.get(i).getBooks();
            }
        }

        tableOfUsers.repaint();
        tableOfUsers.revalidate();
    }

    public void addAccounts() {
        AccountInfo ai = new AccountInfo();
        HashMap<Integer, String[]> accountInformation = ai.read();
        for (Map.Entry<Integer, String[]> entry : accountInformation.entrySet()) {
            String[] accountD = entry.getValue();
            accounts.add(new Account(accountD[0], accountD[1], accountD[2], Integer.parseInt(accountD[3])));
        }
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public void createLeftCP() {
        // The entire left panel, including border and color
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(250, contentPane.getHeight()));
        left.setLayout(new BorderLayout());
        left.setBackground(new Color(14, 142, 211));
        left.setBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 5, Color.BLACK));

        // The button region itself, includes the buttons
        JPanel newButtons = new JPanel();
        //newButtons.setBackground(Color.BLACK); // Used to debug regions
        newButtons.setOpaque(false);
        newButtons.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 100;
        gbc.gridwidth = 100;
        gbc.ipady = 20;
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        //JButton checkIn = new JButton("CHECK IN");
        checkIn.setFont(new Font("Arial", Font.BOLD, 15));
        //JButton checkOut = new JButton("CHECK OUT");
        checkOut.setFont(new Font("Arial", Font.BOLD, 15));
        JButton statistics = new JButton("STATISTICS");
        statistics.setFont(new Font("Arial", Font.BOLD, 15));
        statistics.addActionListener(new Statistics());
        //JButton createNew = new JButton("CREATE NEW");
        createNew.setFont(new Font("Arial", Font.BOLD, 15));

        newButtons.add(checkIn, gbc);
        newButtons.add(checkOut, gbc);
        newButtons.add(statistics, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        newButtons.add(createNew, gbc);

        left.add(newButtons, BorderLayout.CENTER);

        // LOGO
        URL url = null;
        try {
            url = MovieStore.class.getResource("resources/logo.png");
        } catch (Exception e) { e.printStackTrace(); }
        ImageIcon icon = new ImageIcon(url);
        JLabel iconLabel = new JLabel(icon);

        // Add button panel to left panel
        left.add(iconLabel, BorderLayout.SOUTH);

        // Final Component Adding
        contentPane.add(left, BorderLayout.WEST);
    }

    public void createRightCP() {
        JPanel right = new JPanel();
        right.setLayout(new BorderLayout());
        //right.setBackground(Color.white); // Used to debug regions

        JPanel bufferRegion = new JPanel();
        // bufferRegion.setBackground(Color.black); // Used to debug regions
        bufferRegion.setLayout(new GridBagLayout());
        GridBagConstraints totalRestraint = new GridBagConstraints();
        setupTable();


        totalRestraint.gridx = 0;
        totalRestraint.gridy = 0;
        totalRestraint.ipady = 10;
        totalRestraint.ipadx = 250;
        totalRestraint.anchor = GridBagConstraints.FIRST_LINE_START;
        JTextField searchTable = new JTextField("SEARCH USERS");
        searchTable.addMouseListener(new SearchBar(tableOfUsers));
        bufferRegion.add(searchTable, totalRestraint);

        totalRestraint.gridy = 0;
        totalRestraint.ipadx = 10;
        totalRestraint.anchor = GridBagConstraints.FIRST_LINE_END;
        JButton goButton = new JButton("GO");
        goButton.addActionListener(new Go(tableOfUsers, searchTable));
        bufferRegion.add(goButton, totalRestraint);

        totalRestraint.gridx = 0;
        totalRestraint.gridy = 1;
        JScrollPane tablePane = new JScrollPane();
        tableOfUsers.getTableHeader().setReorderingAllowed(false);
        tableOfUsers.getTableHeader().setResizingAllowed(false);
        tablePane.setViewportView(tableOfUsers);

        bufferRegion.add(tablePane, totalRestraint);
        right.add(bufferRegion, BorderLayout.CENTER);

        right.setOpaque(false);
        bufferRegion.setOpaque(false);
        contentPane.add(right);


        createNew.addActionListener(new CreateNew(frame, tableOfUsers));
        checkIn.addActionListener(new CheckIn(tableOfUsers, accounts));
        checkOut.addActionListener(new CheckOut(tableOfUsers, accounts));
    }
}