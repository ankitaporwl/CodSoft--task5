import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class FDemo extends JFrame implements ActionListener{
	CardLayout card;
	Container cn=getContentPane();
	HomeDemo hm;
	LoginDemo lg;
	RegisDemo rg;
	MenuDemo mn;
	FDemo(){
		setTitle("Student Management System");
		card=new CardLayout();
		setLayout(card);
		hm=new HomeDemo();
		add("home",hm);
		lg=new LoginDemo();
		add("login",lg);
		rg=new RegisDemo();
		add("regi",rg);
		mn=new MenuDemo();
		add("menu",mn);
		setResizable(false);
		lg.b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///codsoft","root","123");
			Statement st=con.createStatement();
			String s1=lg.t1.getText();
			String s2=lg.t2.getText();
			if(s1.isEmpty()||s2.isEmpty()){
				JOptionPane.showMessageDialog(null,"Username and password are required","Error",JOptionPane.ERROR_MESSAGE);
			}else{
			ResultSet rs=st.executeQuery("select * from register where name='"+s1+"' AND password='"+s2+"'");
			lg.t1.setText("");
			lg.t2.setText("");
			if(rs.next()){
				card.show(cn,"menu");
			}else{
				
				JOptionPane.showMessageDialog(null,"Invalid User name and password","Invalid Login",JOptionPane.ERROR_MESSAGE);
			}
			con.close();
				}}
			catch(Exception e1){
				JOptionPane.showMessageDialog(null,e1,"Error",JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		lg.b2.addActionListener(this);
		hm.b1.addActionListener(this);
		hm.b2.addActionListener(this);
		rg.b2.addActionListener(this);
		rg.b1.addActionListener(new ActionListener(){
			public void  actionPerformed(ActionEvent e){
				String s1=rg.t1.getText();
			String s2=rg.t2.getText();
			String s3=rg.t3.getText();
			String s4=rg.t4.getText();
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///codsoft","root","123");
			Statement st=con.createStatement();
			if(s1.isEmpty()||s2.isEmpty()){
				JOptionPane.showMessageDialog(null,"Username and password are required","Error",JOptionPane.ERROR_MESSAGE);
			}else{
			st.executeUpdate("insert into register values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
			rg.t1.setText("");
			rg.t2.setText("");
			rg.t3.setText("");
			rg.t4.setText("");
			card.show(cn,"login");
			con.close();}
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null,e1,"Error",JOptionPane.ERROR_MESSAGE);
			}
			}
		});
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==hm.b1){
			card.next(cn);
		}
		if(e.getSource()==lg.b2||e.getSource()==rg.b2){
			card.show(cn,"home");
		}
		if(e.getSource()==hm.b2){
			card.show(cn,"regi");
		}
		
	}
}
class student{
	public static void main(String ar[]){
		FDemo f=new FDemo();
		f.setVisible(true);
		int x,y,w,h;
		w=500;
		h=500;
		Toolkit t=Toolkit.getDefaultToolkit();
		Image i=t.getImage("food.png");
		Dimension d=t.getScreenSize();
		x=(d.width-w)/2;
		y=(d.height-h)/2;
		f.setBounds(x,y,w,h);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setIconImage(i);
	}
}