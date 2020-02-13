import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.lang.*;
class addstudent extends JFrame
{
	addstudent(String course,String sem,String sec,String year)
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
		JLabel l0,l1,l2,l4;
		l0=new JLabel("Enter USN:");
		l0.setFont(f0);
		l0.setBounds(100,150,200,20);
		add(l0);
		l1=new JLabel("Enter Student Name:");
		l1.setFont(f0);
		l1.setBounds(100,240,200,20);
		add(l1);
		l2=new JLabel("Section Selected:");
		l2.setFont(f0);
		l2.setBounds(100,340,200,20);
		add(l2);
		Font f3=new Font("Georgia",Font.BOLD,22);
		l4=new JLabel("ADD Student");
			l4.setForeground(Color.WHITE);
			l4.setFont(f3);
			l4.setBounds(60,0,750,90);
			add(l4);
		
		JTextField t0,t1;
		t0=new JTextField();
		t0.setBounds(100,180,300,40);
		add(t0);
		t1=new JTextField();
		t1.setBounds(100,280,300,40);
		add(t1);
		
		String s1[]={""+sec+""};
		
		JComboBox c1;
		c1=new JComboBox(s1);
		c1.setBounds(100,375,300,40);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		JButton b0,b1;
		b0=new JButton("submit");
		b0.setBackground(Color.WHITE);
		b0.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		b0.setBounds(440,480,100,30);
		add(b0);
		
		b1=new JButton("GO BACK");
		b1.setFont(f2);
		b1.setBounds(600,30,100,25);
		b1.setBackground(Color.WHITE);
		b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		add(b1);
		String value= c1.getSelectedItem().toString();
		
		b0.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
							if(t0.getText().length()==0 || t1.getText().length()==0)
							{
								JOptionPane.showMessageDialog(null,"Please Fill up all the Fields!!");
							}
							else
							{	
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");////your username and password
								String sql="insert into student values('"+t0.getText()+"','"+t1.getText()+"','"+course+"','"+sem+"','"+sec+"')";
								String sql2="insert into attendance(USN,course_id,no_of_attended_classes,no_of_classes_absent,total_classes,year,sem) values('"+t0.getText()+"','"+course+"',0,0,0,'"+year+"','"+sem+"')";
								PreparedStatement ps=conn.prepareStatement(sql);
								PreparedStatement ps2=conn.prepareStatement(sql2);
								ResultSet rs=ps.executeQuery();
								ResultSet rs2=ps2.executeQuery();
								if(rs.next())
								{
									JOptionPane.showMessageDialog(null,"Student Added Successfully!!");
									pp.sp.dispose();
									pp.sp=new student(course,sem,year,sec);
									dispose();
						
									//cc.c1.setVisible(true);
									//pp.sp.setVisible(false);
									//pp.sp.setVisible(true);
									
								}
							}
						}
						catch(SQLException e)
						{
							System.out.println(e);
							JOptionPane.showMessageDialog(null,e);
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
							dispose();
							
							
							
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