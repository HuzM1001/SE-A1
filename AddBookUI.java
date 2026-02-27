import javax.swing.*;
import java.awt.*;

public class AddBookUI extends JFrame {

    private JTextField titleField, authorField, isbnField;
    private JSpinner quantitySpinner;

    public AddBookUI() {

        setTitle("Add New Book");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel heading = new JLabel("Add New Book");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(150, 20, 200, 30);
        panel.add(heading);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(50, 80, 100, 25);
        panel.add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(150, 80, 200, 25);
        panel.add(titleField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(50, 120, 100, 25);
        panel.add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(150, 120, 200, 25);
        panel.add(authorField);

        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setBounds(50, 160, 100, 25);
        panel.add(isbnLabel);

        isbnField = new JTextField();
        isbnField.setBounds(150, 160, 200, 25);
        panel.add(isbnField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 200, 100, 25);
        panel.add(quantityLabel);

        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        quantitySpinner.setBounds(150, 200, 60, 25);
        panel.add(quantitySpinner);

        JButton addButton = new JButton("Add Book");
        addButton.setBounds(100, 250, 120, 35);
        panel.add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(240, 250, 120, 35);
        panel.add(cancelButton);

        cancelButton.addActionListener(e -> dispose());

        add(panel);
        setVisible(true);
    }
}