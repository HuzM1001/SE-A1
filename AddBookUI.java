import javax.swing.*;
import java.awt.*;

public class AddBookUI extends JFrame {

    public AddBookUI() {

        setTitle("Add New Book");
        setSize(500, 450);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(244, 246, 247));

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(44, 62, 80));
        header.setPreferredSize(new Dimension(500, 60));

        JLabel title = new JLabel("Add New Book");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        header.add(title);

        mainPanel.add(header, BorderLayout.NORTH);

        // Form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(244, 246, 247));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        String[] labels = {"Title:", "Author:", "ISBN:", "Quantity:"};
        JTextField titleField = new JTextField(18);
        JTextField authorField = new JTextField(18);
        JTextField isbnField = new JTextField(18);
        JSpinner quantity = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        Component[] fields = {titleField, authorField, isbnField, quantity};

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            formPanel.add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1;
            formPanel.add(fields[i], gbc);
        }

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        JButton addBtn = new JButton("Add Book");
        addBtn.setBackground(new Color(39, 174, 96));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusPainted(false);
        addBtn.setPreferredSize(new Dimension(140, 40));

        formPanel.add(addBtn, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }
}