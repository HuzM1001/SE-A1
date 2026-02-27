
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewBooksUI extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public ViewBooksUI() {

        setTitle("View Books");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Top Search Panel
        JPanel topPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton addButton = new JButton("Add Book");

        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);

        panel.add(topPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {"ID", "Title", "Author", "ISBN", "Status", "Available"};

        model = new DefaultTableModel(columns, 0);

        model.addRow(new Object[]{1, "The Great Gatsby", "F. Scott Fitzgerald", "1234567890", "Available", 5});
        model.addRow(new Object[]{2, "To Kill a Mockingbird", "Harper Lee", "9876543210", "Issued", 0});
        model.addRow(new Object[]{3, "1984", "George Orwell", "1122334455", "Available", 3});

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Buttons
        JPanel bottomPanel = new JPanel();
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        bottomPanel.add(editButton);
        bottomPanel.add(deleteButton);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Add Book button action
        addButton.addActionListener(e -> new AddBookUI());

        add(panel);
        setVisible(true);
    }
}