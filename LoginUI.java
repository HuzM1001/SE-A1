import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {

    public LoginUI() {

        setTitle("Library Management System");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(244, 246, 247));

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(44, 62, 80));
        header.setPreferredSize(new Dimension(450, 70));

        JLabel title = new JLabel("Library Management System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.add(title);

        mainPanel.add(header, BorderLayout.NORTH);

        // Center Form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(244, 246, 247));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        loginLabel.setForeground(new Color(44, 62, 80));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(loginLabel, gbc);

        gbc.gridwidth = 1;

        gbc.gridy++;
        formPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        JTextField username = new JTextField(15);
        formPanel.add(username, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        JPasswordField password = new JPasswordField(15);
        formPanel.add(password, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(41, 128, 185));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setPreferredSize(new Dimension(120, 35));

        formPanel.add(loginBtn, gbc);

        loginBtn.addActionListener(e -> {
            new ViewBooksUI();
            dispose();
        });

        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}