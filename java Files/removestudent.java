import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.lang.*;
class removestudent extends JFrame
{
	removestudent(String course,String sem,String sec,String year)
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
		l0=new JLabel("Enter USN to Remove:");
		l0.setFont(f0);
		l0.setBounds(100,130,300,20);
		add(l0);
		//l1=new JLabel("Enter Student Name:");
		//l1.setFont(f0);
		//l1.setBounds(100,140,200,20);
		//add(l1);
		l2=new JLabel("Section of Student:");
		l2.setFont(f0);
		l2.setBounds(100,250,200,20);
		add(l2);
		
		Font f3=new Font("Georgia",Font.BOLD,22);
		l4=new JLabel("Remove Student");
			l4.setForeground(Color.WHITE);
			l4.setFont(f3);
			l4.setBounds(60,0,750,90);
			add(l4);
		
		JTextField t0,t1;
		t0=new JTextField();
		t0.setBounds(100,160,300,40);
		add(t0);
		//t1=new JTextField();
		//t1.setBounds(100,180,300,40);
		//add(t1);
		
		String s1[]={""+sec+""};
		
		JComboBox c1;
		c1=new JComboBox(s1);
		c1.setBounds(100,280,300,40);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		JButton b0,b1;
		b0=new JButton("Remove");
		b0.setBackground(Color.WHITE);
		b0.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		b0.setBounds(440,400,100,30);
		add(b0);
		
		b1=new JButton("GO BACK");
		b1.setFont(f2);
		b1.setBackground(Color.WHITE);
		b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		b1.setBounds(600,30,100,25);
		add(b1);
		String value= c1.getSelectedItem().toString();
		
		b0.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{	
						try
						{
							if(t0.getText().length()==0)
							{
								JOptionPane.showMessageDialog(null,"Please Fill up all the Fields!!");
							}
							else
							{	
								Class.forName("oracle.jdbc.driver.OracleDriver");
								Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
								String sql="delete from student where USN='"+t0.getText()+"' and course_id='"+course+"' and sem='"+sem+"' and sec='"+sec+"'";
								String sql2="delete from attendance where USN='"+t0.getText()+"' and course_id='"+course+"' and year='"+year+"' and sem='"+sem+"'";
								PreparedStatement ps=conn.prepareStatement(sql);
								PreparedStatement ps2=conn.prepareStatement(sql2);
								ResultSet rs=ps.executeQuery();
								ResultSet rs2=ps2.executeQuery();
								if(rs.next())
								{
									JOptionPane.showMessageDialog(null,"Student Removed Successfully!!");
									pp.sp.dispose();
									pp.sp=new student(course,sem,year,sec);
									dispose();
									//cc.c1.setVisible(true);
								}
							}
						}
						catch(SQLException e)
						{
							System.out.println(e);
							JOptionPane.showMessageDialog(null,"Student Not Present");
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