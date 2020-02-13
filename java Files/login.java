//code created by sumukha
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.*;
class hh
{
	public static Home h1;
}
class Login extends JFrame
{
		JLabel l0,l1,l2,l3;
		JTextField t1;
		JPasswordField t2;
		JButton b1;
		Login()
		{
			setContentPane(new JLabel(new ImageIcon("login.jpg")));
			Font f1=new Font("Arial",Font.BOLD,24);
			Font f2=new Font("Georgia",Font.BOLD,30);
			Font f3=new Font("Arial",Font.BOLD,17);
			l1=new JLabel("Login Page");
			l1.setFont(f1);
			l2=new JLabel("UserName");
			l2.setForeground(Color.BLACK);
			l2.setFont(f3);
			t1=new JTextField();
			l3=new JLabel("Password");
			l3.setForeground(Color.BLACK);
			l3.setFont(f3);
			t2=new JPasswordField();
			b1=new JButton("Login");
			l0=new JLabel(" Name of the College,city name");
			l0.setFont(f2);
			l0.setForeground(Color.BLACK);
			l0.setBounds(100,10,800,50);
			l1.setBounds(300,100,200,40);
			l2.setBounds(280,200,100,20);
			t1.setBounds(280,230,200,30);
			l3.setBounds(280,280,100,20);
			t2.setBounds(280,310,200,30); 
			b1.setBounds(280,375,200,30); 
			add(l0);
			add(l1);
			add(l2);
			add(t1);
			add(l3);
			add(t2);
			add(b1);
			setLayout(null);
			setSize(800,600);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","**username**","**password**"); //insert your database username and password
						String sql="select * from admin where username='"+t1.getText()+"' and password='"+t2.getText()+"'";
					    PreparedStatement ps=conn.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						if(rs.next()){
							JOptionPane.showMessageDialog(null,"Login Sussessfull!!");
							setVisible(false);
							String val=t1.getText();
						    hh.h1=new Home(val);
						    
 						}
						else{
							JOptionPane.showMessageDialog(null,"Invalid username or password!!!");
						}
					}
					catch(Exception e){
						System.out.println(e);
					}
							
							
						
				}
			});
		}


	public static void main(String[] args){
		Login login=new Login();
	}
}
//code created by sumukha