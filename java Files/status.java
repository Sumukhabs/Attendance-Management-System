import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.lang.*;
class status extends JFrame
{
	status(String name)
	{
		setContentPane(new JLabel(new ImageIcon("course.jpg")));
		setLayout(null);
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f0=new Font("Arial",Font.BOLD,20);
		Font f2=new Font("Arial",Font.BOLD,12);
		JLabel l0,l1,l2,l3,l4;
		l0=new JLabel("Enter USN:");
		l0.setFont(f0);
		l0.setBounds(100,130,200,20);
		add(l0);
		l1=new JLabel("select Year:");
		l1.setFont(f0);
		l1.setBounds(100,220,200,20);
		add(l1);
		l2=new JLabel("Choose course:");
		l2.setFont(f0);
		l2.setBounds(100,310,200,20);
		add(l2);
		l3=new JLabel("select Sem:");
		l3.setFont(f0);
		l3.setBounds(100,400,200,20);
		add(l3);
		Font f3=new Font("Georgia",Font.BOLD,22);
		l4=new JLabel("Enter Student Details to fetch status");
			l4.setForeground(Color.WHITE);
			l4.setFont(f3);
			l4.setBounds(60,0,750,90);
			add(l4);
		
		JTextField t0,t1;
		t0=new JTextField();
		t0.setBounds(100,160,300,40);
		add(t0);
		
				ArrayList<String> s2=new ArrayList<String>();
		s2.add("-Select any-");
		try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
						String sql="select year from years";
					    PreparedStatement ps=conn.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						while(rs.next()){
							s2.add(rs.getString("year"));
						    
 						}
					}
					catch(Exception e){
						System.out.println(e);
					}
			
		
		JComboBox c2;
		c2=new JComboBox(s2.toArray());
		c2.setBounds(100,250,200,40);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		ArrayList<String> s5=new ArrayList<String>();
		s5.add("-Select any-");
		try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","usrname","password");//your username and password
						String sql="select course_id from course where lecture_name='"+name+"'";
					    PreparedStatement ps=conn.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						while(rs.next()){
							s5.add(rs.getString("course_id"));
						    
 						}
					}
					catch(Exception e){
						System.out.println(e);
					}
		JComboBox c1=new JComboBox(s5.toArray());
		c1.setBounds(100,340,300,40);
		add(c1);
		
		
		//String s1[]={"-Select any-","A Secton","B Section"};
		//JComboBox c1;
		//c1=new JComboBox(s1);
		//c1.setBounds(100,340,200,40);
		//c1.setBackground(Color.WHITE);
		//add(c1);
		

		
		String s3[]={"-Select any-","3rd Semister","4th Semister","5th Semister","6th Semister","7th Semister","8th Semister"};
		
		JComboBox c3;
		c3=new JComboBox(s3);
		c3.setBounds(100,430,200,40);
		c3.setBackground(Color.WHITE);
		add(c3);
		
		JButton b0=new JButton("Get Status");
		b0.setBackground(Color.WHITE);
		b0.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		b0.setBounds(480,480,100,30);
		add(b0);
		
		JButton b1=new JButton("GO BACK");
		b1.setFont(f2);
		b1.setBounds(600,30,100,25);
		b1.setBackground(Color.WHITE);
		b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		add(b1);
		
		b1.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{
						try
						{
							dispose();
							hh.h1.setVisible(true);
							
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});
			
			b0.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
								String usn=""+t0.getText()+"";
								String year=c2.getSelectedItem().toString();
								String course=c1.getSelectedItem().toString();
								String sem=c3.getSelectedItem().toString();
								try 
							{
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
								CallableStatement storedProc = conn.prepareCall("{call cpr2}");
														
								storedProc.execute();
							} 
							catch (SQLException e) 
							{
								e.printStackTrace();
							}		
								setVisible(false);
								new gotstatus(usn,year,course,sem); 
								
								
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
