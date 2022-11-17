
import java.awt.*;
import javax.swing.*;
import javax.swing.Box;
import javax.swing.JScrollPane;

public class Drawing extends Canvas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ticket");
        JButton button1 = new JButton("ADD");
        JButton button2 = new JButton("REMOVE");
/*        JButton button3 = new JButton("SPLIT");
        JButton button4 = new JButton("EVENLY");*/
        JButton button5 = new JButton("CONFIRM");
        button1.setBounds(120,100, 55, 15);
        button2.setBounds(165,100, 80, 15);
        button5.setBounds(150,320, 80, 15);
        button1.setFont(new Font("Arial", Font.PLAIN, 10));
        button2.setFont(new Font("Arial", Font.PLAIN, 10));
        button5.setFont(new Font("Arial", Font.PLAIN, 10));

        frame.add(button1);
        frame.add(button2);

        frame.add(button5);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }


}
