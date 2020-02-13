import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.util.List;
//import java.lang.*;
class ss
{
	public static course c1;
}

class section extends JFrame
{
	section(String val,String user)
	{
		
		
		setContentPane(new JLabel(new ImageIcon("course.jpg")));
		
		JLabel l0=new JLabel("Please Choose the Section Below:");
		Font f3=new Font("skia",Font.ITALIC,20);
		l0.setForeground(Color.DARK_GRAY);
		l0.setFont(f3);
		l0.setBounds(100,25,400,200);
		add(l0);
		
		JButton b0,b1,b3;
		Font f1=new Font("Arial",Font.BOLD,22);
		Font f2=new Font("Arial",Font.BOLD,12);
		
		b0=new JButton("A Section");
		b0.setFont(f1);
		b0.setBounds(100,260,250,50);
		b0.setForeground(Color.BLACK);
		b0.setContentAreaFilled(false);
		b0.setBorder(BorderFactory.createBevelBorder(1));
		//b0.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		add(b0);
		b1=new JButton("B Section");
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
		//b3.setContentAreaFilled(false);
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
							String seca=b0.getText();
							setVisible(false);
							ss.c1=new course(val,user,seca);
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
							String secb=b1.getText();
							setVisible(false);
							ss.c1=new course(val,user,secb);
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
							uu.u1.setVisible(true);
							 
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
	}
}

//code created by sumukha