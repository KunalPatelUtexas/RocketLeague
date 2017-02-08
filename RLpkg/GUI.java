package RLpkg;
/*
 * Kunal Patel
 * kunal.bharat.patel94@gmail.com
 */

import javax.swing.AbstractButton;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;


public class GUI extends JFrame{
	
	//Class Declarations
	JTextField text_input;
	JButton PS4, Xbox, PC;
	StringBuilder selection;
	JLabel Instr;
	Deque<User> Users = new LinkedList<User>();
	
	//Constructor
	public GUI() {
		super("Rocket League Tracker");
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.fill = GridBagConstraints.VERTICAL;
        
		
		Instr = new JLabel("Enter your username and select your platform.");
        gBC.gridx = 1;
        gBC.gridy = 0;
        container.add(Instr, gBC);
        
		text_input = new JTextField(10);
        gBC.gridx = 1;
        gBC.gridy = 2;
        container.add(text_input, gBC);

		PS4 = new JButton("PS4");
        gBC.gridx = 0;
        gBC.gridy = 3;
        PS4.addActionListener(new ButtonHandler());
        container.add(PS4, gBC);        

        Xbox = new JButton("Xbox One");
        gBC.gridx = 1;
        gBC.gridy = 3;        
        Xbox.addActionListener(new ButtonHandler());
        container.add(Xbox, gBC);

        PC = new JButton("PC");
        gBC.gridx = 2;
        gBC.gridy = 3;
        PC.addActionListener(new ButtonHandler());
        container.add(PC, gBC);

		setSize(500, 200);
		setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//Inner Class ButtonHandler
	private class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == PS4) {
				//selection = new StringBuilder("PS4");
				if(!text_input.getText().isEmpty()){
					Users.add(new User(text_input.getText().trim(), "PS4"));
					text_input.setText("");
				}
			}
			if (e.getSource() == Xbox) {
				//selection = new StringBuilder("XboxOne");
				if(!text_input.getText().isEmpty()){
					Users.add(new User(text_input.getText().trim(), "XboxOne"));
					text_input.setText("");
				}
			}
			if (e.getSource() == PC) {
				//selection = new StringBuilder("steam");
				if(!text_input.getText().isEmpty()){
					Users.add(new User(text_input.getText().trim(), "steam"));
					text_input.setText("");
				}
			}
			//JOptionPane.showMessageDialog(null, disp);
		}
	}
	//Main Program that starts Execution

	public static void main(String args[]) {
		GUI test = new GUI();
	}

}
