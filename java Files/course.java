import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class yy
{
	public static year y1;
}

class course extends JFrame
{
	course(String val,String user,String sec)
	{
		setContentPane(new JLabel(new ImageIcon("course.jpg")));
		String recevedsem=val;
		
		JButton b0,b1,b3;
		Font f1=new Font("Arial",Font.BOLD,22);
		Font f2=new Font("Arial",Font.BOLD,12);
		
		JLabel l0=new JLabel("Please Choose Any Option Below:");
		Font f3=new Font("party LET",Font.ITALIC,20);
		l0.setForeground(Color.DARK_GRAY);
		l0.setFont(f3);
		l0.setBounds(100,25,400,200);
		add(l0);
		
		b0=new JButton("CONFIGURE COURSE");
		b0.setFont(f1);
		b0.setBounds(100,260,290,50);
		b0.setForeground(Color.BLACK);
		b0.setContentAreaFilled(false);
		b0.setBorder(BorderFactory.createBevelBorder(1));
		add(b0);
		b1=new JButton("CHOOSE COURSE");
		b1.setFont(f1);
		b1.setBounds(400,260,280,50);
		b1.setForeground(Color.BLACK);
		b1.setContentAreaFilled(false);
		b1.setBorder(BorderFactory.createBevelBorder(1));
		//b1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		add(b1);
		b3=new JButton("GO BACK");
		b3.setFont(f2);
		b3.setBounds(600,30,100,25);
		b3.setForeground(Color.BLACK);
		b3.setBackground(Color.WHITE);
		b3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		add(b3);
		setLayout(null);
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b0.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
							setVisible(false);
							new courseinput(recevedsem,user,sec);
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
			
			b1.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
							setVisible(false);
							yy.y1=new year(recevedsem,user,sec);
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
			
			b3.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{
						try
						{
							setVisible(false);
							cc.s1.setVisible(true);
							 
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
			
		
		
		
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


//code created by sumukha
