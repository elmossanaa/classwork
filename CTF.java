package classwork1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CTF extends JFrame {
	private JTextField c;
	private JLabel label;
	private final int w = 350;
	private final int h = 250;
	private JPanel panel;
	private JButton button;
	
	public CTF() {
		super("Celsius to Fahrenheit");
		setSize(w,h);
		buildPanel();
		add(panel);
		setVisible(true);
	}

	private void buildPanel() {
		panel = new JPanel();
		label = new JLabel("enter a Celsius temperature");
		c = new JTextField(20);
		button = new JButton("click me to turn into Fahrenheit");
		panel.add(label);
		panel.add(c);
		panel.add(button);
		button.addActionListener(new Fahrenheit_Calc());
		
	}
	public class Fahrenheit_Calc implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = c.getText();
			double F = (9/5)*Double.parseDouble(input) + 32;
			JOptionPane.showMessageDialog(null,"Fahrenheit is " + F);
			
			
			
		}
}
}
