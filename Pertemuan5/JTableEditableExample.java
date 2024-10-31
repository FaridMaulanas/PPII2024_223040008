import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableEditableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Editable Example");

        // Column names and initial data for the table
        String[] columnNames = { "ID", "Name", "Age" };
        Object[][] data = {
            { 1, "John", 25 },
            { 2, "Anna", 30 },
            { 3, "Mike", 35 },
        };

        // Creating DefaultTableModel with data and header
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only the 'Name' column is editable
                return column == 1;
            }
        };

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
