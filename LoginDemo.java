import javax.swing.*;
class LoginDemo extends JPanel {
    JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	LoginDemo(){
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
		b1=new JButton("Login");
		b1.setBounds(150,120,80,30);
		add(b1);
		b2=new JButton("Back");
		b2.setBounds(20,400,80,30);
		add(b2);
		
	}
	
}