// Cam Crawford

import javax.swing.*;
import java.awt.event.*;

public class LatinTranslator extends JFrame {
	private JButton sinister;
	private JButton dexter;
	private JButton medium;
	private JLabel translation;
	private JPanel panel;
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 70;
	
	public LatinTranslator() {
		setTitle("Latin Translator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sinister = new JButton("SINISTER");
		dexter = new JButton("DEXTER");
		medium = new JButton("MEDIUM");
		translation = new JLabel("Latin Translator");
		
		sinister.addActionListener(new ButtonListener());
		dexter.addActionListener(new ButtonListener());
		medium.addActionListener(new ButtonListener());
		
		panel = new JPanel();
		panel.add(translation);
		panel.add(medium);
		panel.add(dexter);
		panel.add(sinister);
		
		add(panel);
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if(actionCommand.equals("SINISTER")) {
				translation.setText("Left");
			} else if(actionCommand.equals("DEXTER")) {
				translation.setText("Right");
			} else {
				translation.setText("Center");
			}
		}
	}
	
	public static void main(String[] args) {
		new LatinTranslator();
	}
}