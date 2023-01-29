package view.panels;

import controller.RegistrationController;
import factory.Factory;
import factory.IFactory;
import ticket.Ticket;
import user.User;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.*;


public class DrawPanel extends JPanel {

    JButton Confirm;
    JButton addUser;
    JButton removeUser;
    JTextField A_Name;
    JTextField R_Name;
    JLabel  TicketType_Label;
    JLabel Price_Label;
    JLabel Paid_For_Label;
    JLabel UserCount;

    JLabel TicketCount;
    JTextField  TicketType;
    JTextField Paid_by;
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
    String Name;
    RegistrationController controller;
    User user;
    Ticket ticket;
    double Price_ticket = 0;
    String Type_ticket;
    int Count=0;
    boolean removed=false;
    boolean duplicated_name =false;
    HashMap<Integer, User> Hash_Users = new HashMap<>();
    ArrayList<User> List_of_Users = new ArrayList<>();
    boolean userIsFound= false;
    boolean Paid_for_userIsFound = false;
    int ticketCount=0;
    String PaidFor;
    String[] paidFor_list;
    ArrayList<User> split = new ArrayList<>();
    User paidFor_;
    boolean paidForIsFound = false;

    public DrawPanel(RegistrationController controller,ListPanel panel){
        this.controller = controller;
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
        addUser = new JButton("Add");
        panel1.add(this.addUser);
        //ADD Panel_Left TO MAIN
        mainPanel.add((panel1));

        //PANEL2
        panel2.setBorder(new TitledBorder(("REMOVE USER:")));
        R_Name = new JTextField(10);
        panel2.add(R_Name);
        removeUser =new JButton("Remove");
        panel2.add(this.removeUser);
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
        Paid_by = new JTextField(5);


        Even = new JCheckBox("Split Even");
        Odd = new JCheckBox("Split Odd");

        Confirm = new JButton("Confirm");

        Panel_Right.setLayout(new BoxLayout(Panel_Right, BoxLayout.Y_AXIS));

        Panel_Right.add(TicketType_Label);
        Panel_Right.add(Paid_by);
        Panel_Right.add(Even);
        Panel_Right.add(Odd);
        Panel_Right.add(Confirm);

        panel3.add(Panel_Right);
        mainPanel.add((panel3));

        panel4.setBorder(new TitledBorder("Info"));
        panel4.setLayout((new GridLayout(3,1)));
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        UserCount = new JLabel("#Users: ");
        TicketCount = new JLabel("#Tickets: ");



        scrollPanel = new JScrollPane(panel4);
        panel4.add(UserCount);
        panel4.add(TicketCount);
        panel4.add(panel);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add((scrollPanel));

        UserAdded_Listener();
        UserRemoved_Listener();
        Confirm_Listener();


        //ADD MAINPANEL TO JPANEL
        this.add(mainPanel);


    }
    public void UserAdded_Listener() {
        this.addUser.addActionListener(listener ->
        {
            Name = A_Name.getText();
            for (User list_of_user : List_of_Users) {
                if (Name.equals(list_of_user.getName())) {
                    JOptionPane.showMessageDialog(null, "this name already exist. please give me the name and surname in this case");
                    duplicated_name = true;
                    break;
                }
            }
            if (Name.equals("")) {
                JOptionPane.showMessageDialog(null, "no name was given");

            } else if(!duplicated_name){
                Count++;
                A_Name.setText("");
                UserCount.setText("#Users : " + Count);
                IFactory factory = Factory.IFactory();
                this.user = factory.getUser(Name, 0);
                Hash_Users.put(Count, user);
                List_of_Users.add(user);
                controller.UserAdd(user);
            }
            duplicated_name=false;
        });
    }

    public void UserRemoved_Listener() {
        this.removeUser.addActionListener(listener ->
        {
            Name = R_Name.getText();
            for (int i : Hash_Users.keySet()) {
                if (Name.equals(Hash_Users.get(i).getName())) {
                    if(Count>=1) {
                        Count--;
                    }else{
                        Count=0;
                    }
                    R_Name.setText("");
                    IFactory factory = Factory.IFactory();
                    this.user = factory.getUser(Name, 0);
                    controller.UserRemove(user);
                    Hash_Users.remove(i,user);
                    System.out.println(i);
                    List_of_Users.remove(i-1);
                    UserCount.setText("#Users : " + Count);
                    removed = true;
                }
            }
            if(!removed) {
                if(Name.equals("")){
                    JOptionPane.showMessageDialog(null,  "please, insert a name");
                }else{
                    JOptionPane.showMessageDialog(null, Name + " not found!");
                }
            }
            removed = false;
        });
    }

    public void Confirm_Listener() {
        this.Confirm.addActionListener(listener ->
        {
                PaidFor = Paid_For.getText();
                paidFor_list = PaidFor.split(",");
                paidForIsFound = false;
                split.clear();
                for (int i : Hash_Users.keySet()) {
                    if(Paid_by.getText().equals(Hash_Users.get(i).getName())){
                        user=Hash_Users.get(i);
                        userIsFound = true;
                    }
                    for (int j = 0; j <= paidFor_list.length - 1; j++)
                    {
                        if (paidFor_list[j].equals(Hash_Users.get(i).getName())) {
                            paidFor_ = Hash_Users.get(i);
                            split.add(paidFor_);
                            paidForIsFound = true;
                        }
                    }
                }

                if(TicketType.getText().isEmpty() || Paid_by.getText().isEmpty() || TicketType.getText().isEmpty() || Paid_For.getText().isEmpty() || Price.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "not everything was filled in!");
                }else if(Even.isSelected() && Odd.isSelected()){
                    JOptionPane.showMessageDialog(null, "both boxes cant be selected");
                }else if (!Even.isSelected() && !Odd.isSelected()) {
                    JOptionPane.showMessageDialog(null, "select a box");
                } else if(paidForIsFound && userIsFound && Even.isSelected()){
                    ticketCount++;
                    TicketCount.setText("#Tickets: " + ticketCount);
                    IFactory factory = Factory.IFactory();
                    Price_ticket = Double.parseDouble((Price.getText()));
                    Type_ticket = TicketType.getText();
                    this.ticket = factory.getTicket(Price_ticket,user,Type_ticket,Even.isSelected(),split);
                    controller.TicketAdd(ticket);
                    userIsFound = false;
                }else if(paidForIsFound && userIsFound && Odd.isSelected()){
                     ticketCount++;
                     TicketCount.setText("#Tickets: " + ticketCount);
                     IFactory factory = Factory.IFactory();
                     Type_ticket = TicketType.getText();
                    Price_ticket = Double.parseDouble((Price.getText()));
                    this.ticket = factory.getTicket(Price_ticket,user,Type_ticket,Even.isSelected(),split);
                     controller.TicketAdd(ticket);
                     Paid_for_userIsFound= false;

                }

        });
    }
}
