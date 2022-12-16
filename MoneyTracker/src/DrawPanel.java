import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class DrawPanel extends JPanel   {
    JTextField A_Name;
    JTextField R_Name;
    JLabel  TicketType_Label;
    JLabel Price_Label;
    JLabel Paid_For_Label;
    JLabel UserCount;

    JLabel TicketCount;
    JLabel label;
    JTextField  TicketType;
    JTextField Price;
    JTextField Paid_For;
    JCheckBox Even;
    JCheckBox Odd;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel Panel_Left;
    JPanel Panel_Right;
    JScrollPane scrollPanel;
    TitledBorder border;



    public DrawPanel(){

        //CREATE MAINPANEL
        JPanel mainPanel = new JPanel();
        //mainPanel.setBorder(new TitledBorder("MoneyTracker"));
        border = new TitledBorder("MoneyTracker");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        mainPanel.setLayout((new GridLayout(2,2)));
        mainPanel.setBackground(Color.orange);
        mainPanel.setBorder(border);
        //CREATE OTHER PANELS TO ADD THEM IN MAINPANEL
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        Panel_Left = new JPanel();
        Panel_Right = new JPanel();



        //PANEL1
        panel1.setBorder(new TitledBorder(("ADD USER:")));
        A_Name = new JTextField(10);
        panel1.add(A_Name);
        panel1.add(new JButton("Add"));
        //ADD Panel_Left TO MAIN
        mainPanel.add((panel1));

        //PANEL2
        panel2.setBorder(new TitledBorder(("REMOVE USER:")));
        R_Name = new JTextField(10);
        panel2.add(R_Name);
        panel2.add(new JButton("Remove"));
        //ADD PANEL2 TO MAIN
        mainPanel.add((panel2));




        panel3.setBorder(new TitledBorder("Tickets:"));
        panel3.setLayout((new GridLayout(1,2)));

        //PANELLEFT
        TicketType_Label = new JLabel("TicketType:");
        TicketType = new JTextField(5);

        Price_Label = new JLabel("Price:");
        Price = new JTextField(5);

        Paid_For_Label = new JLabel("Paid For:");
        Paid_For = new JTextField(5);

        //Panel_Left.setEnabled(false);
        Panel_Left.setLayout(new BoxLayout(Panel_Left, BoxLayout.Y_AXIS));

        Panel_Left.add(TicketType_Label);
        Panel_Left.add(TicketType);
        Panel_Left.add(Price_Label);
        Panel_Left.add(Price);
        Panel_Left.add(Paid_For_Label);
        Panel_Left.add(Paid_For);
        panel3.add(Panel_Left);

        //PANELRIGHT
        TicketType_Label = new JLabel("Paid By:");
        TicketType = new JTextField(5);


        Even = new JCheckBox("Split Even");
        Odd = new JCheckBox("Split Odd");

        Paid_For_Label = new JLabel("Confirm:");
        Paid_For = new JTextField(5);

        Panel_Right.setLayout(new BoxLayout(Panel_Right, BoxLayout.Y_AXIS));

        Panel_Right.add(TicketType_Label);
        Panel_Right.add(TicketType);
        Panel_Right.add(Even);
        Panel_Right.add(Odd);
        Panel_Right.add(Paid_For_Label);
        Panel_Right.add(Paid_For);

        panel3.add(Panel_Right);
        mainPanel.add((panel3));

        panel4.setBorder(new TitledBorder("Info:"));
        panel4.setLayout((new GridLayout(3,1)));
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        UserCount = new JLabel("#Users: ");
        TicketCount = new JLabel("#Tickets: ");
        label = new JLabel("Registrations");
        JTextField txt =new JTextField();
        Box verticalBox = Box.createVerticalBox();
        txt.setEnabled(false);
        verticalBox.add(txt);
        scrollPanel = new JScrollPane(verticalBox);
        panel4.add(UserCount);
        panel4.add(TicketCount);
        panel4.add(label);
        panel4.add(verticalBox, BorderLayout.SOUTH);
        panel4.add(scrollPanel);
        mainPanel.add((panel4));


        //ADD Panel3 TO MAIN

        //ADD MAINPANEL TO JPANEL
        this.add(mainPanel);


    }
}
