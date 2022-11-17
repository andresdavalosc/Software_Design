package my;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
public class SwingDemo {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Groups");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button1 = new JButton("ADD");
        JButton button2 = new JButton("REMOVE");
        JButton button3 = new JButton("SPLIT");
        JButton button4 = new JButton("EVENLY");
        JButton button5 = new JButton("CONFIRM");

        Box box = new Box(BoxLayout.X_AXIS);
        box.add(button1);
        box.add(button2);
        box.add(button3);
        box.add(button4);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(box);
        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.setSize(550, 250);
        frame.setVisible(true);
    }
}