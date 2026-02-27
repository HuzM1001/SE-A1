import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ViewBooksUI extends JFrame {

    public ViewBooksUI() {

        setTitle("View Books");
        setSize(850, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(244, 246, 247));

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(44, 62, 80));
        header.setPreferredSize(new Dimension(850, 60));

        JLabel title = new JLabel("Book Management");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        header.add(title, BorderLayout.WEST);
        mainPanel.add(header, BorderLayout.NORTH);

        // Table
        String[] columns = {"ID", "Title", "Author", "ISBN", "Status", "Available"};

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        model.addRow(new Object[]{1, "The Great Gatsby", "F. Scott Fitzgerald", "1234567890", "Available", 5});
        model.addRow(new Object[]{2, "1984", "George Orwell", "9876543210", "Issued", 0});

        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(41, 128, 185));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(244, 246, 247));

        JButton addBtn = new JButton("Add Book");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");

        addBtn.setBackground(new Color(41, 128, 185));
        editBtn.setBackground(new Color(243, 156, 18));
        deleteBtn.setBackground(new Color(192, 57, 43));

        JButton[] buttons = {addBtn, editBtn, deleteBtn};

        for (JButton btn : buttons) {
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setPreferredSize(new Dimension(120, 35));
            bottomPanel.add(btn);
        }

        addBtn.addActionListener(e -> new AddBookUI());

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}