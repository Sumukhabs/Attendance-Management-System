import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
class cc
{
	public static section s1;
}

class Update extends JFrame
{
	Update(String uname)
	{
		//String uname=st;
		setContentPane(new JLabel(new ImageIcon("course.jpg")));
		JLabel l0;
		Font f0=new Font("Georgia",Font.BOLD,24);
		l0=new JLabel("Choose a Semister Below:");
		l0.setFont(f0);
		l0.setForeground( Color.DARK_GRAY);
		l0.setBounds(60,80,400,90);
		add(l0);
	
		JButton b0,b1,b2,b3,b4,b5,b6;
		Font f1=new Font("Arial",Font.BOLD,20);
		Font f2=new Font("Arial",Font.BOLD,12);
	
		b0=new JButton("3rd Semister");
		b0.setFont(f1);
		b0.setForeground( Color.BLACK);
		b0.setBackground( Color.WHITE);
		b0.setBounds(200,180,150,40);
		//b0.setContentAreaFilled(false);
		b0.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		//b0.setBorder(BorderFactory.createBevelBorder(1));
		add(b0);
		b1=new JButton("4th Semister");
		b1.setFont(f1);
		b1.setForeground( Color.BLACK);
		b1.setBackground( Color.WHITE);
		b1.setBounds(450,180,150,40);
		//b1.setContentAreaFilled(false);
		b1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		//b1.setBorder(BorderFactory.createBevelBorder(1));
		add(b1);
		b2=new JButton("5th Semister");
		b2.setFont(f1);
		b2.setForeground( Color.BLACK);
		b2.setBackground( Color.WHITE);
		b2.setBounds(200,280,150,40);
		//b2.setContentAreaFilled(false);
		b2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		//b2.setBorder(BorderFactory.createBevelBorder(1));
		add(b2);
		b3=new JButton("6th Semister");
		b3.setFont(f1);
		b3.setForeground( Color.BLACK);
		b3.setBackground( Color.WHITE);
		b3.setBounds(450,280,150,40);
		//b3.setContentAreaFilled(false);
		//b3.setBorder(BorderFactory.createBevelBorder(1));
		b3.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		add(b3);
		b4=new JButton("7th Semister");
		b4.setFont(f1);
		b4.setForeground( Color.BLACK);
		b4.setBackground( Color.WHITE);
		b4.setBounds(200,380,150,40);
		//b4.setContentAreaFilled(false);
		b4.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		//b4.setBorder(BorderFactory.createBevelBorder(1));
		add(b4);
		b5=new JButton("8th Semister");
		b5.setFont(f1);
		b5.setForeground( Color.BLACK);
		b5.setBackground( Color.WHITE);
		b5.setBounds(450,380,150,40);
		//b5.setContentAreaFilled(false);
		//b5.setBorder(BorderFactory.createBevelBorder(1));
		b5.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 4));
		add(b5);
		b6=new JButton("GO BACK");
		b6.setFont(f2);
		b6.setBackground(Color.WHITE);
		b6.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		b6.setBounds(600,30,100,25);
		add(b6);
		
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b0.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your ussername and password
							String sql="select * from semister where sem='"+b0.getText()+"'";
							PreparedStatement ps=conn.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							if(rs.next())
							{
								String sem3=b0.getText();
								setVisible(false);
								cc.s1=new section(sem3,uname);
							}
							rs.close();
							ps.close();
							conn.close();
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
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
							String sql="select * from semister where sem='"+b1.getText()+"'";
							PreparedStatement ps=conn.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								String sem4=b1.getText();
								setVisible(false);
								cc.s1=new section(sem4,uname);
							}
							rs.close();
							ps.close();
							conn.close();
							
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
			
			b2.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
							String sql="select * from semister where sem='"+b2.getText()+"'";
							PreparedStatement ps=conn.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								String sem5=b2.getText();
								setVisible(false);
								cc.s1=new section(sem5,uname);							
							}
							rs.close();
							ps.close();
							conn.close();
							
							
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
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");////your username and password
							String sql="select * from semister where sem='"+b3.getText()+"'";
							PreparedStatement ps=conn.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								String sem6=b3.getText();
								setVisible(false);
								cc.s1=new section(sem6,uname);
							}
							rs.close();
							ps.close();
							conn.close();
							
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
			
			b4.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
							String sql="select * from semister where sem='"+b4.getText()+"'";
							PreparedStatement ps=conn.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								String sem7=b4.getText();
								setVisible(false);
								cc.s1=new section(sem7,uname);
							}
							rs.close();
							ps.close();
							conn.close();
							
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
			
			b5.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","un","password");//your username and password
							String sql="select * from semister where sem='"+b5.getText()+"'";
							PreparedStatement ps=conn.prepareStatement(sql);
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								String sem8=b6.getText();
								setVisible(false);
								cc.s1=new section(sem8,uname);
							}
							rs.close();
							ps.close();
							conn.close();
							
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});

			
			b6.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{
						try
						{
							setVisible(false);
							hh.h1.setVisible(true);
							 
							
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