//Simple Java DBMS with JDBC and Swing GUI to Store and Retrieve Data from Database (Name of Database is "dbms") table name is "student" and columns are "id" and "name"

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2;
    Main()
    {
        super("DBMS");
        setLayout(new FlowLayout());
        l1=new JLabel("ID");
        l2=new JLabel("Name");
        l3=new JLabel();
        t1=new JTextField(20);
        t2=new JTextField(20);
        b1=new JButton("Store");
        b2=new JButton("Retrieve");
        add(l1);add(t1);add(l2);add(t2);add(b1);add(b2); add(l3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
                Statement st=con.createStatement();
                String id=t1.getText();
                String name=t2.getText();
                String query="insert into student values('"+id+"','"+name+"')";
                st.executeUpdate(query);
                l3.setText("Data Stored Successfully");
                con.close();
            }
            catch(Exception e)
            {
                l3.setText("Error Occured");
            }
        }
        else if(ae.getSource()==b2)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","root");
                Statement st=con.createStatement();
                String id=t1.getText();
                String query="select * from student where id='"+id+"'";
                ResultSet rs=st.executeQuery(query);
                if(rs.next())
                {
                    String name=rs.getString("name");
                    t2.setText(name);
                    l3.setText("Data Retrieved Successfully");
                }
                else
                {
                    l3.setText("No Data Found");
                }
                con.close();
            }
            catch(Exception e)
            {
                l3.setText("Error Occured");
            }
        }
    }
    public static void main(String args[])
    {
        new Main();
    }
}