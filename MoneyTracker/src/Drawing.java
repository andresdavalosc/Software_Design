
import java.awt.*;
import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.util.Observable;
import java.util.Observer;
public class Drawing extends JFrame implements Observer {

    DrawPanel extra;
    JTextField Name;

    public Drawing()
    {
        //super("money");
    }

    public void initialize() {
        setSize(480, 350);
        //this.setLocation(1920,0);
        setTitle("MoneyTracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        extra = new DrawPanel();

        this.add(extra);
        this.setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o)
    {

    }

}
