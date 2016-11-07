import actionlisteners.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ControlPanelUI {

    public static JTable tableOfUsers;
    private Container contentPane;
    private ArrayList<Account> accounts = new ArrayList<>();
    private String[] columnNames = {"First Name", "Last Name", "Books Out"};
    private Object[][] data;

    public ControlPanelUI(Container contentPane) { this.contentPane = contentPane; }
    public ControlPanelUI() {  }

    public void renderTable() {
        addDebugAccounts();

        data = new Object[accounts.size()][3];
        tableOfUsers = new JTable(new CustomTable(data, columnNames));
        for (int i = 0; i < data.length; i++) {
            for (int r = 0; r < data[i].length; r++) {
                data[i][0] = accounts.get(i).getFirstName();
                data[i][1] = accounts.get(i).getLastName();
                data[i][2] = accounts.get(i).getCheckedOutBooks();
            }
        }
    }

    public void addDebugAccounts() {
        accounts.add(new Account("Jacob", "Cuomo", "6162323562", new HashMap<>()));
        accounts.add(new Account("Cool", "Dude", "232562623", new HashMap<>()));
        accounts.add(new Account("Sleeping", "Widow", "23213425", new HashMap<>()));
        accounts.add(new Account("Unknown", "Target", "98674203", new HashMap<>()));
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

        JButton checkIn = new JButton("CHECK IN");
        checkIn.setFont(new Font("Arial", Font.BOLD, 15));
        checkIn.addActionListener(new CheckIn());
        JButton checkOut = new JButton("CHECK OUT");
        checkOut.setFont(new Font("Arial", Font.BOLD, 15));
        checkOut.addActionListener(new CheckOut());
        JButton statistics = new JButton("STATISTICS");
        statistics.setFont(new Font("Arial", Font.BOLD, 15));
        statistics.addActionListener(new Statistics());
        JButton createNew = new JButton("CREATE NEW");
        createNew.setFont(new Font("Arial", Font.BOLD, 15));
        createNew.addActionListener(new CreateNew());

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

        totalRestraint.gridx = 0;
        totalRestraint.gridy = 0;
        totalRestraint.ipady = 10;
        totalRestraint.ipadx = 250;
        totalRestraint.anchor = GridBagConstraints.FIRST_LINE_START;
        JTextField searchTable = new JTextField("SEARCH USERS");
        searchTable.addMouseListener(new SearchBar());
        bufferRegion.add(searchTable, totalRestraint);

        totalRestraint.gridy = 0;
        totalRestraint.ipadx = 10;
        totalRestraint.anchor = GridBagConstraints.FIRST_LINE_END;
        JButton goButton = new JButton("GO");
        goButton.addActionListener(new Go(tableOfUsers));
        bufferRegion.add(goButton, totalRestraint);

        totalRestraint.gridx = 0;
        totalRestraint.gridy = 1;
        renderTable();
        JScrollPane tablePane = new JScrollPane();
        tableOfUsers.getTableHeader().setReorderingAllowed(false);
        tableOfUsers.getTableHeader().setResizingAllowed(false);
        tablePane.setViewportView(tableOfUsers);

        bufferRegion.add(tablePane, totalRestraint);
        right.add(bufferRegion, BorderLayout.CENTER);

        right.setOpaque(false);
        bufferRegion.setOpaque(false);
        contentPane.add(right);
    }
}