import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.event.*;
class MenuDemo extends JPanel{
	JTabbedPane tab1;
	BorderLayout border;
	InsertDemo ins;
	SearchDemo src;
	UpdateDemo upt;
	DeleteDemo dtm;
	ShowAllDemo sha;
	Exit ex;
	MenuDemo(){
		border=new BorderLayout();
		setLayout(border);
		tab1=new JTabbedPane();
		ins=new InsertDemo();
		src=new SearchDemo();
		upt=new UpdateDemo();
		sha=new ShowAllDemo();
		dtm=new DeleteDemo();
		ex=new Exit();
		
		tab1.addTab("Insert",ins);
		tab1.addTab("Search",src);
		tab1.addTab("Update",upt);
		tab1.addTab("ShowAll",sha);
		tab1.addTab("Delete",dtm);
		tab1.addTab("Exit",ex);
		tab1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(tab1.getSelectedIndex()==5){
					System.exit(0);
				}
			}
		});
		add(tab1);
	}
}
class InsertDemo extends JPanel implements ActionListener{
	JLabel u1,u2,u3,u4,u5,u6,u7,u8;
	JLabel l;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1;
	InsertDemo(){
		setLayout(null);
		l=new JLabel("Student Page");
		l.setBounds(50,0,120,30);
		add(l);
		u1=new JLabel("Enter Name");
		u1.setBounds(10,40,120,40);
		add(u1);
		t1=new JTextField();
		t1.setBounds(150,40,150,30);
		add(t1);
		
		u2=new JLabel("Enter RollNo");
		u2.setBounds(10,80,120,40);
		add(u2);
		t2=new JTextField();
		t2.setBounds(150,80,150,30);
		add(t2);
		
		u3=new JLabel("Enter Phy Marks");
		u3.setBounds(10,120,120,40);
		add(u3);
		t3=new JTextField();
		t3.setBounds(150,120,150,30);
		add(t3);
		
		u4=new JLabel("Enter Che Marks");
		u4.setBounds(10,160,120,40);
		add(u4);
		t4=new JTextField();
		t4.setBounds(150,160,150,30);
		add(t4);
		
		u5=new JLabel("Enter Maths Marks");
		u5.setBounds(10,200,120,40);
		add(u5);
		t5=new JTextField();
		t5.setBounds(150,200,150,30);
		add(t5);
		
		u6=new JLabel("Enter Hindi Marks");
		u6.setBounds(10,240,120,40);
		add(u6);
		t6=new JTextField();
		t6.setBounds(150,240,150,30);
		add(t6);
		
		u7=new JLabel("Enter English Marks");
		u7.setBounds(10,280,120,40);
		add(u7);
		t7=new JTextField();
		t7.setBounds(150,280,150,30);
		add(t7);
		
		u8=new JLabel("Enter Grade");
		u8.setBounds(10,320,120,40);
		add(u8);
		t8=new JTextField();
		t8.setBounds(150,320,150,30);
		add(t8);
		
		b1=new JButton("Add Student");
		b1.setBounds(100,370,120,30);
		add(b1);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		String s5=t5.getText();
		String s6=t6.getText();
		String s7=t7.getText();
		String s8=t8.getText();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///codsoft","root","123");
			Statement st=con.createStatement();
			st.executeUpdate("insert into student values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')");
			JOptionPane.showMessageDialog(null,"Student Information added successfully","Task Completed",JOptionPane.PLAIN_MESSAGE);
			
			con.close();
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,e1,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
class SearchDemo extends JPanel implements ActionListener{
	JButton b1;
	JTextField t1;
	JLabel u1,u2,u3,u4,u5,u6,u7,u8;
	SearchDemo(){
		setLayout(null);
		u1=new JLabel("Enter RNO.");
		u1.setBounds(20,20,150,30);
		add(u1);
		t1=new JTextField();
		t1.setBounds(150,20,150,30);;
		add(t1);
		b1=new JButton("Search");
		b1.setBounds(100,60,80,30);
		add(b1);
		b1.addActionListener(this);
		u2=new JLabel();
		u2.setBounds(40,100,200,40);
		add(u2);
		u3=new JLabel();
		u3.setBounds(40,140,200,40);
		add(u3);
		u4=new JLabel();
		u4.setBounds(40,180,200,40);
		add(u4);
		u5=new JLabel();
		u5.setBounds(40,220,200,40);
		add(u5);
		u6=new JLabel();
		u6.setBounds(40,260,200,40);
		add(u6);
		u7=new JLabel();
		u7.setBounds(40,300,200,40);
		add(u7);
		u8=new JLabel();
		u8.setBounds(40,340,200,40);
		add(u8);
	}
	public void actionPerformed(ActionEvent e){
		String s1=t1.getText();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///codsoft","root","123");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student where sroll='"+s1+"'");
			if(rs.next()){
			
				u2.setText("Name:\t"+rs.getString(1));
				u3.setText("Phy Marks:\t"+rs.getString(3));
				u4.setText("Che Marks:\t"+rs.getString(4));
				u5.setText("Maths Marks:\t"+rs.getString(5));
				u6.setText("Hindi Marks:\t"+rs.getString(6));
				u7.setText("English Marks:\t"+rs.getString(7));
				u8.setText("Grade:\t"+rs.getString(8));
			}else{
				JOptionPane.showMessageDialog(null,"Invalid roll No","Error",JOptionPane.ERROR_MESSAGE);
				t1.setText("");
			}
			con.close();
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,e1,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
class UpdateDemo extends JPanel implements ActionListener{
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JLabel u1,u2,u3,u4,u5,u6,u7,u8;
	UpdateDemo(){
		setLayout(null);
		u1=new JLabel("Enter RollNo");
		u1.setBounds(10,10,120,40);
		add(u1);
		t1=new JTextField();
		t1.setBounds(150,10,150,30);
		add(t1);
		b1=new JButton("Search");
		b1.setBounds(120,50,80,30);
		add(b1);
		u2=new JLabel("Name");
		u2.setBounds(10,90,120,40);
		add(u2);
		t2=new JTextField();
		t2.setBounds(150,90,150,30);
		add(t2);
		
		u3=new JLabel("Phy Marks");
		u3.setBounds(10,130,120,40);
		add(u3);
		t3=new JTextField();
		t3.setBounds(150,130,150,30);
		add(t3);
		
		u4=new JLabel("Che Marks");
		u4.setBounds(10,170,120,40);
		add(u4);
		t4=new JTextField();
		t4.setBounds(150,170,150,30);
		add(t4);
		
		u5=new JLabel("Maths Marks");
		u5.setBounds(10,210,120,40);
		add(u5);
		t5=new JTextField();
		t5.setBounds(150,210,150,30);
		add(t5);
		
		u6=new JLabel("Hindi Marks");
		u6.setBounds(10,250,120,40);
		add(u6);
		t6=new JTextField();
		t6.setBounds(150,250,150,30);
		add(t6);
		
		u7=new JLabel("English Marks");
		u7.setBounds(10,290,120,40);
		add(u7);
		t7=new JTextField();
		t7.setBounds(150,290,150,30);
		add(t7);
		
		u8=new JLabel("Grade");
		u8.setBounds(10,330,120,40);
		add(u8);
		t8=new JTextField();
		t8.setBounds(150,330,150,30);
		add(t8);
		
		b2=new JButton("Update");
		b2.setBounds(120,370,80,30);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		String s1=t1.getText();
		String s2=t2.getText();
			String s3=t3.getText();
			String s4=t4.getText();
			String s5=t5.getText();
			String s6=t6.getText();
			String s7=t7.getText();
			String s8=t8.getText();
		if(e.getSource()==b1){
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///codsoft","root","123");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student where sroll='"+s1+"'");
			if(rs.next()){
				t2.setText(rs.getString(1));
				t3.setText(rs.getString(3));
				t4.setText(rs.getString(4));
				t5.setText(rs.getString(5));
				t6.setText(rs.getString(6));
				t7.setText(rs.getString(7));
				t8.setText(rs.getString(8));
			}
			else{
				JOptionPane.showMessageDialog(null,"Invalid roll No","Error",JOptionPane.ERROR_MESSAGE);
				t1.setText("");
			}
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null,e1,"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==b2){
			
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///codsoft","root","123");
			Statement st=con.createStatement();
			int x=st.executeUpdate("update student set sname='"+s2+"',pmarks='"+s3+"',cmarks='"+s4+"',mmarks='"+s5+"',hmarks='"+s6+"',emarks='"+s7+"',grade='"+s8+"' where sroll='"+s1+"'");
			if(x!=0){
				JOptionPane.showMessageDialog(null,"Updation successfully done");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
			}
			
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null,e1,"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}
class DeleteDemo extends JPanel implements ActionListener{
	JButton b1;
	JTextField t1;
	JLabel u1;
    DeleteDemo(){
		setLayout(null);
		u1=new JLabel("Enter RNO.");
		u1.setBounds(20,20,150,30);
		add(u1);
		t1=new JTextField();
		t1.setBounds(150,20,150,30);;
		add(t1);
		b1=new JButton("Delete");
		b1.setBounds(100,60,80,30);
		add(b1);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		String s1=t1.getText();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///codsoft","root","123");
			Statement st=con.createStatement();
			int x=st.executeUpdate("delete from student where sroll='"+s1+"'");
			if(x!=0){
			JOptionPane.showMessageDialog(null,"Student information deleted successfully","Task Completed",JOptionPane.PLAIN_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"Invalid roll No","Error",JOptionPane.ERROR_MESSAGE);
			}
			t1.setText("");
			con.close();
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null,e1,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
class ShowAllDemo extends JPanel{
	DefaultTableModel model;
	JTable table;
	JScrollPane sp;
	ShowAllDemo(){
		setLayout(new BorderLayout());
		model=new DefaultTableModel();
		table=new JTable(model);
		model.addColumn("sname");
		model.addColumn("sroll");
		model.addColumn("pmarks");
		model.addColumn("cmarks");
		model.addColumn("mmarks");
		model.addColumn("hmarks");
		model.addColumn("emarks");
		model.addColumn("grade");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///codsoft","root","123");
			Statement st=con.createStatement();
			Timer timer=new Timer(1000,e->{
				try{
			ResultSet rs=st.executeQuery("select * from student");
			while(model.getRowCount()>0){
				model.removeRow(0);
			}
			while(rs.next()){
				String s1=rs.getString("sname");
				String s2=rs.getString("sroll");
				String s3=rs.getString("pmarks");
				String s4=rs.getString("cmarks");
				String s5=rs.getString("mmarks");
				String s6=rs.getString("hmarks");
				String s7=rs.getString("emarks");
				String s8=rs.getString("grade");
				model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7,s8});
			} 
			
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
				}
		});
		sp=new JScrollPane(table);
		add(sp,BorderLayout.CENTER);
		
		timer.start();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
		}

	}
}
class Exit extends JPanel{
	Exit(){
		
	}
}
