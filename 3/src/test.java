import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class test {
	public static void main(String[] args) {
		JFrame f;
		JLabel label1,label2,label3,label4,label5,lb1,lb2,lb3,lb4,lb5;
		JButton jb1,jb2,jb3;
		JTextField txt1,txt2,txt3,txt4,txt5,tx1,tx2,tx3,tx4,tx5;
		
		f = new JFrame();
		
		label1 = new JLabel("Customer Number");
		label2 = new JLabel("Customer Name");
		label3 = new JLabel("State");
		label4 = new JLabel("Credit Limit");
		label5 = new JLabel("Rep No");
		
		lb1 = new JLabel("Rep No");
		lb2 = new JLabel("Rep Name");
		lb3 = new JLabel("State");
		lb4 = new JLabel("Comission");
		lb5 = new JLabel("Rate");
		
		jb1 = new JButton("Insert 1");
		jb2 = new JButton("Insert 2");
		jb3 = new JButton("Show");
		
		txt1 = new JTextField(20);
		txt2 = new JTextField(20);
		txt3 = new JTextField(20);
		txt4 = new JTextField(20);
		txt5 = new JTextField(20);

		tx1 = new JTextField(20);
		tx2 = new JTextField(20);
		tx3 = new JTextField(20);
		tx4 = new JTextField(20);
		tx5 = new JTextField(20);
		
		JTextArea ta = new JTextArea(20,40);
		
		f.setLayout(new FlowLayout());
		f.add(label1);
		f.add(txt1);
		f.add(label2);
		f.add(txt2);
		f.add(label3);
		f.add(txt3);
		f.add(label4);
		f.add(txt4);
		f.add(label5);
		f.add(txt5);
		f.add(jb1);
		
		f.add(lb1);
		f.add(tx1);
		f.add(lb2);
		f.add(tx2);
		f.add(lb3);
		f.add(tx3);
		f.add(lb4);
		f.add(tx4);
		f.add(lb5);
		f.add(tx5);
		f.add(jb2);
		
		f.add(jb3);
		f.add(ta);
		f.setVisible(true);
		f.setSize(800,800);
		
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int cnum = Integer.parseInt(txt1.getText());
				String cname = txt2.getText();
				String state = txt3.getText();
				int climit = Integer.parseInt(txt4.getText());
				int repno = Integer.parseInt(txt5.getText());
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
					if(conn!=null) {
						Statement stmt = (Statement)conn.createStatement();
						stmt.executeUpdate("insert into Customer values ("+cnum+",'"+cname+"','"+state+"',"+climit+","+repno+");");
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
		});
		
		
		
		
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int repno = Integer.parseInt(tx1.getText());
				String repname = tx2.getText();
				String state = tx3.getText();
				int comission = Integer.parseInt(tx4.getText());
				int rate = Integer.parseInt(tx5.getText());
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
					if(conn!=null) {
						Statement stmt = (Statement)conn.createStatement();
						stmt.executeUpdate("insert into Representative values ("+repno+",'"+repname+"','"+state+"',"+comission+","+rate+");");
					}
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			
		});
		
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
					if(conn!=null) {
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery("select * from Representative where RepNo in (select RepNo from Customer where Credit_Limit>15000);");
						String s = "";
						ta.setText("");
						while(rs.next()) {
							s+=rs.getInt(1)+" ";
							s+=rs.getString(2)+" ";
							s+=rs.getString(3)+" ";
							s+=rs.getInt(4)+" ";
							s+=rs.getInt(5)+" ";
							s+="\n";
						}
						System.out.println(s);
						ta.append(s);
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		
		
				
	}
}
