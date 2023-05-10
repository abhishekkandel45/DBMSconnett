//Create an GUI JAVA application to calculate BMI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BMICalculator extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1,b2;
    BMICalculator()
    {
        super("BMI Calculator");
        setLayout(new FlowLayout());
        l1=new JLabel("Height");
        l2=new JLabel("Weight");
        l3=new JLabel("BMI");
        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        b1=new JButton("Calculate");
        b2=new JButton("Clear");
        add(l1);add(t1);add(l2);add(t2);add(l3);add(t3);add(b1);add(b2);
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


                double height=Double.parseDouble(t1.getText());
                double weight=Double.parseDouble(t2.getText());
                double bmi=weight/(height*height);
                t3.setText(String.valueOf(bmi));


         if(ae.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");

        }
    }
}
    public static void main(String args[])
    {
        new BMICalculator();
    }
}
