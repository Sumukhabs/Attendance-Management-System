import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.*;
class uu
{
	public static Update u1;
}
class mm
{
	public static status s1;
	public static String name;
	//public static print p1;
}
class Home extends JFrame
{
	Home(String st)
	{
			String uname=st;
			setContentPane(new JLabel(new ImageIcon("course.jpg")));
			JLabel l0,l1;
			JButton b0,b1,b2;
			Font f1=new Font("Georgia",Font.BOLD,25);
			Font f2=new Font("Sitka Display",Font.ITALIC,30);
			Font f3=new Font("Arial",Font.BOLD,20);
			
			
			l1=new JLabel("Name Of the Department or Branch");// write branch or department name
			l1.setForeground(Color.WHITE);
			l1.setFont(f1);
			l1.setBounds(60,0,750,90);
			add(l1);
			b0=new JButton("Update Attendance");
			b0.setFont(f3);
			b0.setBounds(160,250,470,50);
			b0.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
			b0.setBackground( Color.PINK);
			add(b0);
			b1=new JButton("Get Attendance Status of Students");
			b1.setFont(f3);
			b1.setBounds(160,350,470,50);
			b1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
			b1.setBackground( Color.PINK);
			add(b1);
			//b2=new JButton("Print Attendance of a Student");
			///b2.setFont(f3);
			//b2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
			//code created by sumukha
			//b2.setBackground( Color.PINK);
			//add(b2);
			
			setLayout(null);
			setResizable(false);
			
			setVisible(true);
			setSize(800,600);
			setLocationRelativeTo(null);
			//b0.setBackground( Color.WHITE);
			//getContentPane().setBackground( Color.CYAN);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
			try{
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","**username","**password**");//insert your database username and password
				String sql="select name from admin where username='"+uname+"'";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					 mm.name = rs.getString("name");
					 l0=new JLabel("Welcome, "+mm.name);
					 l0.setFont(f2);
					 l0.setBounds(60,100,400,90);
					 add(l0);
				}
				rs.close();
				ps.close();
				conn.close();
				
							
			}
			catch(Exception e){
				System.out.println(e);
			}
			

			
			b0.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//username and password of database here
								String sql="select name from admin where username='"+uname+"'";
								PreparedStatement ps=conn.prepareStatement(sql);
								ResultSet rs=ps.executeQuery();
								while(rs.next())
								{
									String name = rs.getString("name");
									setVisible(false);
									uu.u1=new Update(name);
								}
								
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
							mm.s1=new status(mm.name);
							setVisible(false);
								
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
			
								
			//b2.addActionListener(new ActionListener()
			//{
				//	public void actionPerformed(ActionEvent ae)
				//	{	
				//		try
				//		{
				//			mm.p1=new print();
				//			setVisible(false);		
						//}
						//catch(Exception e)
						//{
							//System.out.println(e);
						//}
					//}
			//});
	}
}
