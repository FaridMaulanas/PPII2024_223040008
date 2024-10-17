import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class HelloBorderLayout extends JFrame {
    public HelloBorderLayout(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelPertanyaan = new JLabel("Apakah ibukota Indonesia");
        JLabel labelHasil = new JLabel("jawab pertanyaan diatas");

        JButton buttonA = new JButton("Jakarta");
        JButton buttonB = new JButton("Bandung");
        JButton buttonC = new JButton("Jakarta");

        buttonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("jawaban anda benar");
            }
        });

        buttonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("jawaban anda salah");
            }
        });

        buttonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("jawaban anda salah");
            }
        });

      this.add(labelPertanyaan, BorderLayout.NORTH);  
      this.add(labelHasil, BorderLayout.SOUTH);  
      this.add(buttonA, BorderLayout.WEST);  
      this.add(buttonB, BorderLayout.CENTER);  
      this.add(buttonC, BorderLayout.EAST);  

        this.setSize(400,200);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                HelloBorderLayout h = new HelloBorderLayout();
                h.setVisible(true);
            }
        });
    }


    }



   

