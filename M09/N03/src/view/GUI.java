package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RocketController;

public class GUI {
	
	private RocketController rocketController;
	private String title1, title2;
	
	public GUI(RocketController rocketController, String title1, String title2) {
		this.rocketController = rocketController;
		this.title1 = title1;
		this.title2 = title2;
		
		this.createFrame();
	}
	
	public void createFrame() {
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("Carrera de coets");
		frame.setBounds(15, 15, 310, 230); // x, y, width, height
		frame.setResizable(false);
		
		Border loweredEtchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(loweredEtchedBorder, title1);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(loweredEtchedBorder, title2);
		
		JPanel panel1 = createPanel(titledBorder1);
		JPanel panel2 = createPanel(titledBorder2);
		
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);

		frame.setVisible(true);
	}
	
	public JPanel createPanel(TitledBorder titledBorder) {
		JPanel panel = new JPanel();
		
		panel.setBorder(titledBorder);
		panel.setLayout(new GridLayout(2, 1)); // rows, cols
		
		JPanel panel1, panel2;
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		JLabel label1, label2;
		JTextField textField1, textField2;
		JButton button1, button2;
		
		label1 = new JLabel("Velocitat:");
		label2 = new JLabel("Increment:");
		
		textField1 = new JTextField(10); // targetVelocity
		textField2 = new JTextField(10); // increment
		
		button1 = new JButton("Modificar");
		button2 = new JButton("Modificar");

		MyListener listener1, listener2;
		
		listener1 = new MyListener(titledBorder.getTitle(), textField1, 1);
		listener2 = new MyListener(titledBorder.getTitle(), textField2, 2);
		
		button1.addActionListener(listener1);
		button2.addActionListener(listener2);
		
		panel1.add(label1);
		panel1.add(textField1);
		panel1.add(button1);
		panel2.add(label2);
		panel2.add(textField2);
		panel2.add(button2);

		panel.add(panel1);
		panel.add(panel2);
		
		return panel;
	}
	
	private class MyListener implements ActionListener {
		
		private String identifier;
		private JTextField textField;
		private int option;
		
		public MyListener(String identifier, JTextField textField, int option) {
			this.identifier = identifier;
			this.textField = textField;
			this.option = option;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			// System.out.println(identifier + " " + textField.getText()); // TODO
			
			try {
				int input = Integer.parseInt(textField.getText());
				
				rocketController.threads(identifier, input, option);
			} catch (NumberFormatException e) {
				System.err.println("Introdueix un número enter.");
			}
		}
		
	}
	
}
