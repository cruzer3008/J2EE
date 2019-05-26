import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TL{
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		JRadioButton r1;
		JRadioButton r2;
		JRadioButton r3;
		
		r1 = new JRadioButton("Red");
		r1.setBounds(75,50,100,30);
		r2 = new JRadioButton("Yellow");
		r2.setBounds(75,75,100,30);
		r3 = new JRadioButton("Green");
		r3.setBounds(75,100,100,30);
		JButton submit = new JButton("Submit");
		submit.setBounds(75,150,100,30);

		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(submit);
			
		f.add(r1);
		f.add(r2);
		f.add(r3);
		f.add(submit);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
		JTextField tf = new JTextField(10);
		tf.setBounds(75, 200, 50, 50);
		f.add(tf);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(r1.isSelected()) {
					tf.setText("Stop");
					tf.setForeground(Color.red);
				}
				if(r2.isSelected()) {
					tf.setText("Ready");
					tf.setForeground(Color.yellow);
				}
				
				if(r3.isSelected()) {
					tf.setText("Go");
					tf.setForeground(Color.green);				
				}
			}
		});
	}
}
