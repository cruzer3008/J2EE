import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Demo{
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JLabel l1 = new JLabel("Source");
		JTextField t1 = new JTextField(40);
		JLabel l2 = new JLabel("Destination");
		JTextField t2 = new JTextField(40);
		JButton b1 = new JButton("Start");
		JButton b2 = new JButton("Stop");
		JTextArea ta = new JTextArea(40,40);
		
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(b1);
		f.add(ta);
		f.setVisible(true);
		f.setSize(800, 800);
		f.setLayout(new FlowLayout());
		
		JProgressBar pb = new JProgressBar(0,100);
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String src = t1.getText();
				String dest = t2.getText();
				pb.setVisible(true);
				pb.setString("Copying");
				pb.setIndeterminate(true);
				try {
					f.add(pb);
					f.add(b2);
					f.setVisible(true);
					String content = new String(Files.readAllBytes(Paths.get(src)));
					PrintWriter pout = new PrintWriter(dest);
					pout.println(content);
					pout.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pb.setVisible(false);
				String src = t2.getText();
				try {
					String content = new String(Files.readAllBytes(Paths.get(src)));
					ta.setText(content);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
}