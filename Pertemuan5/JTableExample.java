import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableExample {
    public static void main(String[] args) {
        // Creating frame
        JFrame frame = new JFrame("JTable Example");

        // Column names and initial data for the table
        String[] columnNames = { "ID", "Name", "Age" };
        Object[][] data = {
            { 1, "John", 25 },
            { 2, "Anna", 30 },
            { 3, "Mike", 35 },
        };

        // Creating table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        // Creating JTable with the model
        JTable table = new JTable(model);
        
        // Creating JScrollPane to hold the JTable
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Adding JScrollPane to frame
        frame.add(scrollPane);
        
        // Frame configuration
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
