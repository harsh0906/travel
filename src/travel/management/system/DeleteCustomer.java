package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class DeleteCustomer extends JFrame implements ActionListener{
    JButton b1,b2;
    String username;
    DeleteCustomer(String user){
        this.username = user;
        setBounds(660,240,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel ("DELETE CUSTOMER DETAILS");
        heading.setFont(new Font("Tahoma",Font.PLAIN, 20));
        heading.setBounds(110,10,2000,30);
        add(heading);
        
        JLabel ll = new JLabel("Username");
        ll.setBounds(30,70,100,16);
        add(ll);
        
        JLabel l1 = new JLabel();
        l1.setBounds(250,70,200,16);
        add(l1);
        
        JLabel l2 = new JLabel("Name");
        l2.setBounds(30,110,100,16);
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(250,110,200,16);
        add(l3);
                
        JLabel l4 = new JLabel("Id");
        l4.setBounds(30,150,100,16);
        add(l4);
        
        JLabel l5 = new JLabel();
        l5.setBounds(250,150,200,16);
        add(l5);  
        
        JLabel l6 = new JLabel("Number");
        l6.setBounds(30,190,100,16);
        add(l6);
        
        JLabel l7 = new JLabel();
        l7.setBounds(250,90,200,16);
        add(l7);
        
        JLabel l8 = new JLabel("Gender");
        l8.setBounds(30,225,100,16);
        add(l8);
        
        JLabel l9 = new JLabel();
        l9.setBounds(250,230,200,16);
        add(l9);
        
        JLabel l10 = new JLabel("Country");
        l10.setBounds(30,270,100,16);
        add(l10);
        
        JLabel l11 = new JLabel();
        l11.setBounds(250,270,200,16);
        add(l11);
        
        JLabel l12 = new JLabel("Address");
        l12.setBounds(30,310,100,16);
        add(l12);
        
        JLabel l13 = new JLabel();
        l13.setBounds(250,110,100,16);
        add(l13);
        
        JLabel l14 = new JLabel("Phone");
        l14.setBounds(30,350,100,16);
        add(l14);
        
        JLabel l15 = new JLabel();
        l15.setBounds(250,350,200,16);
        add(l15);
        
        JLabel l18 = new JLabel("Email");
        l18.setBounds(30,390,100,16);
        add(l18);
        
        JLabel l19 = new JLabel();
        l19.setBounds(250,390,200,16);
        add(l19);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                ll.setText(rs.getString("username"));
                l2.setText(rs.getString("name"));
                l4.setText(rs.getString("id_type"));
                l6.setText(rs.getString("number"));
                l8.setText(rs.getString("gender"));
                l10.setText(rs.getString("country"));
                l12.setText(rs.getString("address"));
                l14.setText(rs.getString("phone"));
                l18.setText(rs.getString("email"));
            }
        }catch(Exception e){}
        
        b1 = new JButton("Delete");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(80,450,100,25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(210,450,100,25);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon il = new  ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/delete.png"));
        Image i2 = il.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ll0 = new JLabel(i3);
        ll0.setBounds(500,100,300,300);
        add(ll0);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username = '"+username+"'");
                c.s.executeUpdate("delete from bookHotel where username ='"+username+"'");
                c.s.executeUpdate("delete from bookpackage where username ='"+username+"'");
                c.s.executeUpdate("delete from customer where username ='"+username+"'");
                
                JOptionPane.showMessageDialog(null, "Customer Details Deleted Successfully");
                System.exit(0);
                
            }catch(Exception e){}
        }else if(ae.getSource() == b2){
            this.setVisible(false);
            
        }
    }
    
    public static void main(String[] args){
        
        new DeleteCustomer("").setVisible(true);
        
    }
}

