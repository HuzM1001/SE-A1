import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardUI extends JFrame {

    private JPanel contentPanel;

    public DashboardUI() {

        setTitle("Library Management System");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // =======================
        // TOP NAVBAR
        // =======================
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(37, 99, 235));
        topBar.setPreferredSize(new Dimension(1100, 60));

        JLabel title = new JLabel("  Library Management System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JLabel profile = new JLabel("Admin  ");
        profile.setForeground(Color.WHITE);
        profile.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        topBar.add(title, BorderLayout.WEST);
        topBar.add(profile, BorderLayout.EAST);

        add(topBar, BorderLayout.NORTH);

        // =======================
        // SIDEBAR
        // =======================
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(31, 42, 56));
        sidebar.setPreferredSize(new Dimension(220, 650));
        sidebar.setLayout(new GridLayout(6, 1, 0, 10));

        String[] menuItems = {"Dashboard", "Add Book", "View Books", "Members", "Reports", "Logout"};

        for (String item : menuItems) {
            JButton btn = createSidebarButton(item);
            sidebar.add(btn);

            btn.addActionListener(e -> switchContent(item));
        }

        add(sidebar, BorderLayout.WEST);

        // =======================
        // MAIN CONTENT PANEL
        // =======================
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(248, 250, 252));
        add(contentPanel, BorderLayout.CENTER);

        switchContent("Dashboard");

        setVisible(true);
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(31, 42, 56));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        button.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(37, 99, 235));
            }
            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(31, 42, 56));
            }
        });

        return button;
    }

    private void switchContent(String name) {

        contentPanel.removeAll();

        if (name.equals("Dashboard")) {
            contentPanel.add(createDashboardPanel(), BorderLayout.CENTER);
        }
        else if (name.equals("Add Book")) {
            contentPanel.add(createAddBookPanel(), BorderLayout.CENTER);
        }
        else if (name.equals("View Books")) {
            contentPanel.add(createViewBooksPanel(), BorderLayout.CENTER);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // =======================
    // DASHBOARD CARDS
    // =======================
    private JPanel createDashboardPanel() {

        JPanel panel = new JPanel(new GridLayout(1, 3, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        panel.setBackground(new Color(248, 250, 252));

        panel.add(createCard("Total Books", "245"));
        panel.add(createCard("Issued Books", "87"));
        panel.add(createCard("Members", "132"));

        return panel;
    }

    private JPanel createCard(String title, String value) {

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));

        JLabel titleLabel = new JLabel("  " + title);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        valueLabel.setForeground(new Color(37, 99, 235));

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    // =======================
    // ADD BOOK PANEL
    // =======================
    private JPanel createAddBookPanel() {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(248, 250, 252));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        String[] labels = {"Title:", "Author:", "ISBN:", "Quantity:"};

        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField isbnField = new JTextField(20);
        JSpinner quantity = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        Component[] fields = {titleField, authorField, isbnField, quantity};

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1;
            panel.add(fields[i], gbc);
        }

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        JButton addBtn = new JButton("Add Book");
        addBtn.setBackground(new Color(37, 99, 235));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusPainted(false);
        addBtn.setPreferredSize(new Dimension(140, 40));

        panel.add(addBtn, gbc);

        return panel;
    }

    // =======================
    // VIEW BOOKS PANEL
    // =======================
    private JPanel createViewBooksPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setBackground(new Color(248, 250, 252));

        String[] columns = {"ID", "Title", "Author", "ISBN", "Status", "Available"};

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        model.addRow(new Object[]{1, "The Great Gatsby", "F. Scott Fitzgerald", "1234567890", "Available", 5});
        model.addRow(new Object[]{2, "1984", "George Orwell", "9876543210", "Issued", 0});

        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(37, 99, 235));
        table.getTableHeader().setForeground(Color.WHITE);

        table.setSelectionBackground(new Color(191, 219, 254));

        JScrollPane scroll = new JScrollPane(table);

        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        new DashboardUI();
    }
}