import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.lang.*;
class rt
{
	public static JRadioButton cb;

}
class pp
{
	public static student sp;
}
class courseselect extends JFrame
{
	courseselect(String semrec,String user,String y,String sec)
	{
		setContentPane(new JLabel(new ImageIcon("course.jpg")));
		String s=semrec;
		JLabel l0,l1,l2,l3;
		Font f4=new Font("skia",Font.BOLD,12);
		Font f0=new Font("skia",Font.ITALIC,20);
		Font f2=new Font("Arial",Font.BOLD,17);
		Font f3=new Font("Arial",Font.BOLD,16);
		
		l0=new JLabel("Choose a subject to take attendance:");
		l0.setFont(f0);
		l0.setBounds(100,25,400,200);
		add(l0);
		l1=new JLabel(""+semrec+"");
		l1.setForeground(Color.WHITE);
		l1.setBounds(100,-2,300,100);
		l1.setFont(f2);
		add(l1);
		l2=new JLabel("Faculty : "+user+"");
		l2.setForeground(Color.WHITE);
		l2.setBounds(250,-2,300,100);
		l2.setFont(f2);
		add(l2);
		l3=new JLabel("Year : "+y+"");
		l3.setForeground(Color.WHITE);
		l3.setBounds(470,-2,300,100);
		l3.setFont(f2);
		add(l3);

		JButton b1,b0;
		b1=new JButton("GO BACK");
		b1.setFont(f4);
		b1.setBounds(670,20,100,25);
		add(b1);
		
		b0=new JButton("Done");
		b0.setBounds(460,500,100,30);
		add(b0);
		
		setLayout(null);
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonGroup bg=new ButtonGroup();
		ArrayList<JRadioButton> buttonList = new ArrayList<JRadioButton>();
		ArrayList<String> course=new ArrayList<String>();
		
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");////your username and password
				String sql="select course_id from course where sem='"+s+"' and year='"+y+"' and sec='"+sec+"'";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					course.add(rs.getString("course_id"));
					 
				}
				int asize=course.size();
			
				int b=200;
				
				
				for(int i=0;i<asize;i++)
				{
	
					Font f1=new Font("Arial",Font.BOLD,22);
					rt.cb=new JRadioButton(""+course.get(i)+"");
					buttonList.add(rt.cb);
					rt.cb.setFont(f1);
					rt.cb.setBounds(300,b,200,70);
					rt.cb.setForeground(Color.BLACK);
					rt.cb.setContentAreaFilled(false);
					b=b+50;
					add(rt.cb);
				}
				int bsize=buttonList.size();
					for(int i=0;i<bsize;i++)
					{
						bg.add(buttonList.get(i));
					}
					
					b0.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent ae)
							{
								try
								{
								
									for(int i=0;i<bsize;i++)
									{
										
										if(buttonList.get(i).isSelected())
										{
											String c=buttonList.get(i).getText();
											setVisible(false);
                                            pp.sp=new student(c,semrec,y,sec);
										
		
										}
											//JOptionPane.showMessageDialog(null,"Please select a year!!");
									
									}
									
								}
								catch(Exception e)
								{
									System.out.println(e);
								}
							}
						
						});
							
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			b1.addActionListener(new ActionListener()
			{
					public void actionPerformed(ActionEvent ae)
					{
						try
						{
							setVisible(false);
							yy.y1.setVisible(true);
							 
							
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