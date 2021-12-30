package sportOrganizer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//needs to implement action listener for the buttons to do an action when clicked
public class LoginWindow extends JFrame implements ActionListener{

	//create labels
	static JLabel userLabel;
	static JLabel passLabel;
	
	//create text fields where users can end text
	static JTextField userField;
	static JTextField passField;
	
	//create the create account button
	static JButton createAccountButton;
	
	LoginWindow(){
		
		//initialize
		GridBagConstraints positionConst = null;
		
		setTitle("Login or sign up");
		setResizable(false);
		
		//put text to the labels
		userLabel = new JLabel("Username:");
		passLabel = new JLabel("Password:");
		
		//make userField editable
		userField = new JTextField();
		userField.setEditable(true);
		
		//make passField editable
		passField = new JTextField();
		passField.setEditable(true);
		
		//add action listener to create account button
		createAccountButton = new JButton("Create Account");
		createAccountButton.addActionListener(this);
		
		try {
			//Layout type
			setLayout(new GridBagLayout());
			
			//parameters for userLabel
			positionConst = new GridBagConstraints();
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.WEST;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 0;
			add(userLabel, positionConst);
			
		} catch(Exception e) {
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
