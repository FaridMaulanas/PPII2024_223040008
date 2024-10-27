import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicJListExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dynamic JList Example");
        
        // DefaultListModel to hold list items
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Dynamic Item 1");
        listModel.addElement("Dynamic Item 2");
        listModel.addElement("Dynamic Item 3");
        
        // JList with model
        JList<String> list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // JScrollPane for JList
        JScrollPane scrollPane = new JScrollPane(list);
        
        // Button to add new items
        JButton addButton = new JButton("Add Item");
        addButton.setBounds(50, 170, 100, 30);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel.addElement("New Item");
            }
        });
        
        // Button to remove selected item
        JButton removeButton = new JButton("Remove Item");
        removeButton.setBounds(160, 170, 120, 30);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });
        
        // Setting layout and adding components to frame
        frame.setLayout(null);
        scrollPane.setBounds(50, 50, 150, 100);
        frame.add(scrollPane);
        frame.add(addButton);
        frame.add(removeButton);
        
        // Frame configuration
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
