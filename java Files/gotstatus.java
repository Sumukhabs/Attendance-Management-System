import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.lang.*;
class gotstatus extends JFrame
{
	gotstatus(String usn,String year,String course,String sem)
	{
		setContentPane(new JLabel(new ImageIcon("course.jpg")));
		setLayout(null);
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l4,l0,l1,l2,l3,l5;
		Font f3=new Font("Georgia",Font.BOLD,22);
		l4=new JLabel("Student Attendance Status");
			l4.setForeground(Color.WHITE);
			l4.setFont(f3);
			l4.setBounds(60,0,750,90);
			add(l4);
			
			JButton b0=new JButton("DONE");
		b0.setBackground(Color.WHITE);
		b0.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		b0.setBounds(480,480,100,30);
		add(b0);
		
		
		
		b0.addActionListener(new ActionListener()
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
			
			
			try{
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sumukha","sumukha");
				String sql="select USN,no_of_attended_classes,no_of_classes_absent,total_classes,attendance_percent from attendance where USN='"+usn+"'and year='"+year+"'and sem='"+sem+"' and course_id='"+course+"'";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					 String USN=rs.getString("USN");
					 String attended=rs.getString("no_of_attended_classes");
					 String absent=rs.getString("no_of_classes_absent");
					 String total_classes=rs.getString("total_classes");
					 String percent=rs.getString("attendance_percent");
					 
					 l0=new JLabel("USN : "+USN);
					l1=new JLabel("No. of Classes Attended : "+attended);
					l2=new JLabel("No. Of Classes Not Attended : "+absent);
					l3=new JLabel("Total No. of Classes : "+total_classes);
					l5=new JLabel("Percentage of Attended classes : "+percent+"%");
			
					Font f0=new Font("skia",Font.BOLD,23);
			
					l0.setBounds(100,130,500,30);
					l1.setBounds(100,185,500,30);
					l2.setBounds(100,235,500,30);
					l3.setBounds(100,285,500,30);
					l5.setBounds(100,335,500,30);
			
					l0.setFont(f0);
					l1.setFont(f0);
					l2.setFont(f0);
					l3.setFont(f0);
					l5.setFont(f0);
			
						add(l0);
						add(l1);
						add(l2);
						add(l3);
						add(l5);
				}
				
							
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			
			
			
	}
}