import javax.swing.JButton;
import javax.swing.JFrame;
 // Import JPanel for setting layout
import java.awt.FlowLayout; // Import FlowLayout

public class HelloFlowLayout extends JFrame {
    public HelloFlowLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set layout
        this.setLayout(new FlowLayout());
        
        // Create buttons
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button10 = new JButton("10");

        // Add buttons to the frame
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(button10);
        
        // Set frame size
        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                HelloFlowLayout h = new HelloFlowLayout();
                h.setVisible(true);
            }
        });
    }
}
