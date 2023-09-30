import javax.swing.*;
class RegisDemo extends JPanel{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2;
	RegisDemo(){
		setLayout(null);
		l1=new JLabel("Enter Name");
		l1.setBounds(50,20,150,30);
		add(l1);
		t1=new JTextField();
		t1.setBounds(220,20,150,30);
		add(t1);
		l2=new JLabel("Enter Password");
		l2.setBounds(50,70,150,30);
		add(l2);
		t2=new JTextField();
		t2.setBounds(220,70,150,30);
		add(t2);
		l3=new JLabel("Enter Contact No");
		l3.setBounds(50,120,150,30);
		add(l3);
		t3=new JTextField();
		t3.setBounds(220,120,150,30);
		add(t3);
		l4=new JLabel("Enter Email");
		l4.setBounds(50,170,150,30);
		add(l4);
		t4=new JTextField();
		t4.setBounds(220,170,150,30);
		add(t4);
		b1=new JButton("Register");
		b1.setBounds(150,220,120,30);
		add(b1);
		b2=new JButton("Back");
		b2.setBounds(20,400,80,30);
		add(b2);
	}
}