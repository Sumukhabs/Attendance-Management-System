import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class courseinput extends JFrame
{
	courseinput(String sem,String user,String sec)
	{
		
		setContentPane(new JLabel(new ImageIcon("course.jpg")));
		
		JLabel l0,l1,l2,l3;
		Font f0=new Font("Arial",Font.BOLD,20);
		Font f2=new Font("Arial",Font.BOLD,12);
		Font f4=new Font("Georgia",Font.BOLD,25);
		
		l0=new JLabel("Course Code");
		l0.setFont(f0);
		l0.setBounds(100,100,200,20);
		add(l0);
		l1=new JLabel("Course Name");
		l1.setFont(f0);
		l1.setBounds(100,200,200,20);
		add(l1);
		l2=new JLabel("Year");
		l2.setFont(f0);
		l2.setBounds(100,300,200,20);
		add(l2);
		//l3=new JLabel("Faculty Name");
		//l3.setFont(f0);
		//l3.setBounds(100,330,200,20);
		//add(l3);
		l3=new JLabel("Add Course");
			l3.setForeground(Color.WHITE);
			l3.setFont(f4);
			l3.setBounds(60,0,750,90);
			add(l3);
		
		
		
		JTextField t0,t1,t2,t3;
		t0=new JTextField();
		t0.setBounds(100,140,300,40);
		add(t0);
		t1=new JTextField();
		t1.setBounds(100,240,300,40);
		add(t1);
		t2=new JTextField();
		t2.setBounds(100,340,300,40);
		add(t2);
		//t3=new JTextField();
		//t3.setBounds(100,360,300,40);
		//add(t3);
		
		JButton b0,b1;
		b0=new JButton("submit");
		b0.setBounds(440,500,100,30);
		b0.setForeground(Color.DARK_GRAY);
		//b0.setContentAreaFilled(false);
		b0.setBackground(Color.WHITE);
		b0.setBorder(BorderFactory.createBevelBorder(1));
		add(b0);
		
		b1=new JButton("GO BACK");
		b1.setFont(f2);
		b1.setBounds(600,30,100,25);
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.WHITE);
		b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		add(b1);
		
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
							if(t0.getText().length()==0 || t1.getText().length()==0 || t2.getText().length()==0)
							{
								JOptionPane.showMessageDialog(null,"Please Fill up all the Fields!!");
							}
							else
							{	
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","uname","password");//your username and password
								String sql="insert into course values('"+t0.getText()+"','"+t1.getText()+"','"+sem+"','"+user+"','"+t2.getText()+"','"+sec+"')";
								PreparedStatement ps=conn.prepareStatement(sql);
								ResultSet rs=ps.executeQuery();
								if(rs.next())
								{
									JOptionPane.showMessageDialog(null,"Course Added Successfully!!");
									dispose();
									ss.c1.setVisible(true);
								}
							}
						}
						catch(SQLException e)
						{
							System.out.println(e);
							JOptionPane.showMessageDialog(null,"Course Already Present!!");
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
							ss.c1.setVisible(true);
							 
							
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
		