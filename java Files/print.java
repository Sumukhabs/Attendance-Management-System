import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.lang.*;
class print extends JFrame
{
	print()
	{
		//setContentPane(new JLabel(new ImageIcon("course.jpg")));
		setLayout(null);
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l0,l1;
		l0=new JLabel("USN");
		l1=new JLabel("Search Course");
		l0.setBounds(100,50,100,20);
		l1.setBounds(400,50,100,20);
		add(l0);
		add(l1);
		
		JTextField t0,t1;
		t0=new JTextField();
		t1=new JTextField();
		t0.setBounds(150,50,200,30);
		t1.setBounds(500,50,200,30);
		add(t0);
		add(t1);
		
		JButton b0,b1;
		b0=new JButton("Get");
		b1=new JButton("Search");
		b0.setBounds(200,90,70,30);
		b1.setBounds(550,90,90,30);
		add(b0);
		add(b1);
		
		b0.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
						String sql="create or replace view v1 as (select A.course_id,C.course_name,A.no_of_attended_classes,A.no_of_classes_absent,A.total_classes,A.attendance_percent,A.year,A.sem from attendance A,course C where A.course_id=C.course_id and A.USN='"+b0.getText()+"')";
					    PreparedStatement ps=conn.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						//while(rs.next())
						//{
						//	System.out.println("S");
						//}
						String sql2="select * from v1";
						PreparedStatement ps2=conn.prepareStatement(sql2);
						ResultSet rs2=ps2.executeQuery();
						while(rs2.next())
						{
							System.out.println("attendance_percent");
						}
						
						

					}
					catch(Exception e){
						System.out.println(e);
					}
							
							
						
				}
			});
		
		
	}
}

//code created by sumukha