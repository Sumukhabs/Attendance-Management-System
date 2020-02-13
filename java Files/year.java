import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.lang.*;
class rr
{
	public static JRadioButton rb;

}
class cs
{
	public static courseselect cst;
}
class year extends JFrame
{
	year(String recevedsem,String user,String sec)
	{
				setContentPane(new JLabel(new ImageIcon("course.jpg")));
				JLabel l0;
				Font f0=new Font("Arial",Font.ITALIC,20);
				Font f3=new Font("Arial",Font.BOLD,12);
				l0=new JLabel("Choose Year:");
				l0.setFont(f0);
				l0.setBounds(50,10,400,200);
				add(l0);
				
				JButton b0,b1;
				b0=new JButton("Done");
				b0.setBounds(460,450,100,30);
				b0.setForeground(Color.DARK_GRAY);
				//b0.setContentAreaFilled(false);
				b0.setBackground(Color.WHITE);
				b0.setBorder(BorderFactory.createBevelBorder(1));
				add(b0);
				
				b1=new JButton("GO BACK");
				b1.setFont(f3);
				b1.setBounds(600,30,100,25);
				b1.setForeground(Color.DARK_GRAY);
				//b1.setContentAreaFilled(false);
				b1.setBackground(Color.WHITE);
				b1.setBorder(BorderFactory.createBevelBorder(1));
				add(b1);
				
				setLayout(null);
				setSize(800,600);
				
				setResizable(false);
				setLocationRelativeTo(null);
				setVisible(true);
				getContentPane().setBackground( Color.CYAN);
				//setContentPane(new JLabel(new ImageIcon("year.jpg")));
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ButtonGroup bg=new ButtonGroup();
				ArrayList<JRadioButton> buttonList = new ArrayList<JRadioButton>();
				
				
				try
				{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","username","password");//your username and password
					String sql="select year from years";
					PreparedStatement ps=conn.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					ArrayList<String> years=new ArrayList<String>();
					while(rs.next())
					{
						years.add(rs.getString("year"));
					}
					int asize=years.size();
					int b=150;
					
					
					for(int i=0;i<asize;i++)
					{
							Font f1=new Font("Arial",Font.BOLD,22);
							rr.rb=new JRadioButton(""+years.get(i)+"");
							buttonList.add(rr.rb);
							rr.rb.setFont(f1);
							rr.rb.setBounds(300,b,100,70);
							rr.rb.setContentAreaFilled(false);
							rr.rb.setForeground(Color.BLACK);
							b=b+50;
							add(rr.rb);
					}
					int bsize=buttonList.size();
					//ButtonGroup bg=new ButttonGroup();
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
											String y=buttonList.get(i).getText();
											setVisible(false);
											cs.cst=new courseselect(recevedsem,user,y,sec);
		
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
					
					
				}
				
				
				
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			
			
			
		
	}
}



//code created by sumukha