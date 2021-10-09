package classwork1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

class mpg extends JFrame{
	private JPanel panel;
	private JLabel gallon;
	private JLabel miles;
	private JButton button;
	private JTextField field;
	private JTextField field2;
	private final int w = 300;
	private final int h = 200;
	
	public mpg() {
		super("mpg");
		setSize(w,h);
		buildPanel();
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void buildPanel() {
		panel = new JPanel();
		gallon = new JLabel("enter the number of gallons of gas the car holds");
		field = new JTextField(20);
		miles = new JLabel("the number of miles it can be driven on a full tank.");
		field2 = new JTextField(20);
		button = new JButton("click me");
		panel.add(gallon);
		panel.add(field);
		panel.add(miles);
		panel.add(field2);
		panel.add(button);
		button.addActionListener(new calc());		
	}
	public class calc implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double mpg;
			String m = field.getText();
			String g = field2.getText();
			mpg = Double.parseDouble(m)/ Double.parseDouble(g);
			JOptionPane.showMessageDialog(null, "the Miles-per-Gallon is" + mpg);
			
		}
	}
}
