import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.lang.*;

class zz
{
	public static JRadioButton r1,r2;
	public static String sem,year,course,sec;
	public static JPanel pan;
}

class student extends JFrame
{
	student(String course,String semi,String year,String sec)
	{
		zz.course=course;
		zz.sem=semi;
		zz.year=year;
		zz.sec=sec;
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(1920,1040);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		zz.pan=new JPanel();
		zz.pan.setMinimumSize(new Dimension(1880, 5000));
		zz.pan.setPreferredSize(new Dimension(1880,5000 ));
		zz.pan.setLayout(null);
		zz.pan.setVisible(true);
		
		JScrollPane scrPane = new JScrollPane(zz.pan);
		scrPane.getViewport().setMinimumSize(new Dimension(160, 200));
		scrPane.getViewport().setPreferredSize(new Dimension(160, 200));
		scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		getContentPane().add(scrPane);
		setContentPane(scrPane);
		
		JLabel l0,l1,l2,l3,l4,l5,l6;
		Font f0=new Font("Arial",Font.BOLD,22);
		l0=new JLabel("Subject :"+course+"");
		l1=new JLabel("Semister :"+semi+"");
		l2=new JLabel("Year :"+year+"");
		l3=new JLabel("Section : "+sec+"");
		l3.setBounds(50,40,300,100);
		l3.setFont(f0);
		zz.pan.add(l3);
		l0.setFont(f0);
		l1.setFont(f0);		
		l2.setFont(f0);
		l0.setBounds(380,40,300,100);
		l1.setBounds(700,40,300,100);
		l2.setBounds(1050,40,300,100);
		zz.pan.add(l0);
		zz.pan.add(l1);
		zz.pan.add(l2);
		
		Font f5=new Font("Arial",Font.BOLD,24);
		l4=new JLabel("NAME");
		l4.setForeground(Color.BLACK);
		l4.setBounds(350,200,300,100);
		l4.setFont(f5);
		zz.pan.add(l4);
		l5=new JLabel("USN");
		l5.setForeground(Color.BLACK);
		l5.setBounds(600,200,300,100);
		l5.setFont(f5);
		zz.pan.add(l5);
		l6=new JLabel("ATTANDANCE STATUS");
		l6.setForeground(Color.BLACK);
		l6.setBounds(850,200,300,100);
		l6.setFont(f5);
		zz.pan.add(l6);
		
		JButton b0,b1,b2;
		Font f1=new Font("Arial",Font.BOLD,12);
		b0=new JButton("GO BACK");
		b0.setFont(f1);
		b0.setBounds(1750,20,100,25);
		b0.setBackground(Color.WHITE);
		b0.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		zz.pan.add(b0);
		
		Font f2=new Font("Arial",Font.BOLD,18);
		b1=new JButton("ADD STUDENT");
		b1.setFont(f2);
		b1.setBounds(1300,100,200,40);
		b1.setBackground( Color.WHITE);
		b1.setForeground(Color.GRAY);
		//b1.setContentAreaFilled(false);
		b1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		zz.pan.add(b1);
		b2=new JButton("REMOVE STUDENT");
		b2.setFont(f2);
		b2.setBounds(1500,100,220,40);
		b2.setBackground( Color.WHITE);
		b2.setForeground(Color.GRAY);
		//b2.setContentAreaFilled(false);
		b2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		zz.pan.add(b2);
		zz.pan.setBackground(Color.YELLOW);
		
		//JRadioButton r1=new JRadioButton("A Section");
		//JRadioButton r2=new JRadioButton("B Section");
		//r1.setFont(f2);
		//r2.setFont(f2);
		//r1.setBounds(700,180,200,40);
		//r2.setBounds(1000,180,200,40);
		
		//pan.add(r1);
		//pan.add(r2);
		//bg.add(r1);
		//bg.add(r2);
		
		
		
		b0.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent ae)
							{
								try
								{
									setVisible(false);
									cs.cst.setVisible(true);
							 
							
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
									
									new addstudent(course,semi,sec,year);
									
								
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
							
							new removestudent(course,semi,sec,year);
								
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}
			});	
			
			ArrayList<String> Name=new ArrayList<String>();
			ArrayList<String> USN=new ArrayList<String>();
		try{
	
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
				String sql="select USN,name from student where sem='"+semi+"' and course_id='"+course+"' and sec='"+sec+"' order by USN";
				PreparedStatement ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					Name.add(rs.getString("name"));
					USN.add(rs.getString("USN"));

				}
				int Nsize=Name.size();
				int b=300;
				JButton b3=new JButton("SUBMIT");
				ArrayList<JRadioButton> buttonList = new ArrayList<JRadioButton>();
				ArrayList<JRadioButton> buttonList2 = new ArrayList<JRadioButton>();
				ArrayList<String> usnarray= new ArrayList<String>();
				//JRadioButton r1,r2;
				//String usn;
					for(int i=0;i<Nsize;i++)
					{	
								
								Font f3=new Font("Arial",Font.BOLD,18);
								JLabel bn=new JLabel(""+Name.get(i)+"");
								bn.setFont(f3);
								bn.setBounds(350,b,300,50);
								zz.pan.add(bn);
								ButtonGroup bg=new ButtonGroup();
								zz.r1=new JRadioButton("P");
								zz.r2=new JRadioButton("A");
								Font f4=new Font("Arial",Font.BOLD,20);
								bg.add(zz.r1);
								bg.add(zz.r2);
								zz.r1.setFont(f4);
								zz.r2.setFont(f4);
								zz.r1.setBounds(900,b,50,40);
								zz.r2.setBounds(950,b,50,40);
								zz.pan.add(zz.r1);
								zz.pan.add(zz.r2);
								zz.r1.setBackground(Color.YELLOW);
								zz.r2.setBackground(Color.YELLOW);
								
								//Font f5=new Font("Arial",Font.BOLD,18);
								JLabel bu=new JLabel(""+USN.get(i)+"");
								bu.setFont(f3);
								bu.setBounds(600,b,300,50);
								//c=c+50;
								zz.pan.add(bu);
								
								usnarray.add(""+USN.get(i)+"");
								
								b3.setBounds(1100,b+300,100,30);
								b3.setForeground(Color.DARK_GRAY);
								b3.setBackground(Color.WHITE);
								b3.setBorder(BorderFactory.createBevelBorder(1));
								zz.pan.add(b3);
								
							
								
								buttonList.add(zz.r1);
								buttonList2.add(zz.r2);
								
								
								b=b+50;
								
					}
					int bl1=buttonList.size();
					int bl2=buttonList2.size();
					//System.out.println(bl1);
					b3.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent ae)
									{
										try
										{
											Class.forName("oracle.jdbc.driver.OracleDriver");
											Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
											
										
											if(!zz.r1.isSelected() && !zz.r2.isSelected())
											{
												JOptionPane.showMessageDialog(null,"Please Update all Students Details");
											}
											else
											{
												for(int i=0;i<bl1;i++)
												{
													if(buttonList.get(i).isSelected())
													{
													
														String sql="update attendance set no_of_attended_classes=no_of_attended_classes+1 where USN='"+usnarray.get(i)+"' and course_id='"+zz.course+"' and year='"+zz.year+"' and sem='"+zz.sem+"'";
														PreparedStatement ps=conn.prepareStatement(sql);
														ResultSet rs=ps.executeQuery();
													}	
													else
													{
														String sql2="update attendance set no_of_classes_absent=no_of_classes_absent+1 where USN='"+usnarray.get(i)+"' and course_id='"+zz.course+"' and year='"+zz.year+"' and sem='"+zz.sem+"'";
														PreparedStatement ps2=conn.prepareStatement(sql2);
														ResultSet rs2=ps2.executeQuery();
													}

													
												}
														
													 try 
													{
														CallableStatement storedProc = conn.prepareCall("{call cpr}");
														
														storedProc.execute();
													} 
													catch (SQLException e) 
													{
														e.printStackTrace();
													}																								
												//if(zz.r2.isSelected())
												//{
												//	String sql2="update attendance set no_of_classes_absent=no_of_classes_absent+1 where USN='"+zz.usn+"' and course_id='"+zz.course+"' and year='"+zz.year+"' and sem='"+zz.sem+"'";
												//	PreparedStatement ps2=conn.prepareStatement(sql2);
												//	ResultSet rs2=ps2.executeQuery();
												//}
												JOptionPane.showMessageDialog(null,"Attendance Updated");
												setVisible(false);
												hh.h1.setVisible(true);
											}
										}
								
																											
										catch(Exception e)
										{
											System.out.println(e);
											
											JOptionPane.showMessageDialog(null,e);
										}
											
									}	
										
								});
								
				
				//int Usize=USN.size();
				//int c=300;

					//for(int i=0;i<Usize;i++)
					//{
					///	Font f3=new Font("Arial",Font.BOLD,18);
					//	JLabel bu=new JLabel(""+USN.get(i)+"");
					//	bu.setFont(f3);
					//	bu.setBounds(600,c,300,50);
					//	c=c+50;
					//	pan.add(bu);
					//}
					
					
			
							
			}
			catch(Exception e){
				System.out.println(e);
			}
		
		
		
	}
	
				
}

//code created by sumukha