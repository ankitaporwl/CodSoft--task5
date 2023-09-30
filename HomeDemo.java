import javax.swing.*;
class HomeDemo extends JPanel{
	JButton b1,b2;
	JLabel l1;
	HomeDemo(){
		setLayout(null);
		l1=new JLabel("Admin Page");
		l1.setBounds(100,50,150,30);
		add(l1);
		b1=new JButton("Login");
		b1.setBounds(50,100,80,30);
		add(b1);
		b2=new JButton("Registration");
		b2.setBounds(160,100,120,30);
		add(b2);
	}
}