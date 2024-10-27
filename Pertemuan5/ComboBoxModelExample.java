import javax.swing.*;
import java.awt.event.*;

public class ComboBoxModelExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("ComboBoxModel Example");

        // Create a model with options
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Item 1");
        comboBoxModel.addElement("Item 2");
        comboBoxModel.addElement("Item 3");
        comboBoxModel.addElement("Item 4");

        // Create a JComboBox with the model
        JComboBox<String> comboBox = new JComboBox<>(comboBoxModel);

        // Add an action listener to the JComboBox
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected item
                String selectedItem = (String) comboBox.getSelectedItem();
                System.out.println("Selected: " + selectedItem);
            }
        });

        // Set layout and add JComboBox to the JFrame
        frame.setLayout(null);
        comboBox.setBounds(50, 50, 150, 20);
        frame.add(comboBox);

        // Configure the JFrame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
