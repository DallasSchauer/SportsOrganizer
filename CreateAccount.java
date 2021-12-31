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
public class CreateAccount extends JFrame implements ActionListener {

	//create labels
	static JLabel userLabel;
	static JLabel passLabel;
	static JLabel emailLabel;
	
	//create text fields where users can edit text
	static JTextField userField;
	static JTextField passField;
	static JTextField emailField;
	
	//create the buttons
	static JButton createAccountButton;
	
	CreateAccount() {
		
		setTitle("Login or sign up");
		setResizable(false);
		
		//put text to the labels
		userLabel = new JLabel("Choose a username:");
		passLabel = new JLabel("Choose a password:");
		emailLabel = new JLabel("Choose an email:");
		
		//make userField editable and set the number of columns used to calculate width
		userField = new JTextField(25);
		userField.setEditable(true);
		
		//make passField editable and set the number of columns used to calculate width
		passField = new JTextField(25);
		passField.setEditable(true);
		
		//make passField editable and set the number of columns used to calculate width
		emailField = new JTextField(25);
		emailField.setEditable(true);
		
		//add action listener to create account button
		createAccountButton = new JButton("Create Account");
		createAccountButton.addActionListener(this);
		
		//initialize variable for setting parameters for each element in the window
		GridBagConstraints positionConst = null;
		positionConst = new GridBagConstraints();
		
		try {
			//Layout type
			//Grid bag layout positions elements in/across cells in a grid
			setLayout(new GridBagLayout());
			
			//parameters for emailLabel
			//insets are the spaces around each element used as "padding" (top, left, bottom, right)
			positionConst.insets = new Insets(3, 3, 3, 3);
			//anchoring the element within its position in its grid space
			positionConst.anchor = GridBagConstraints.WEST;
			//elements in grid bag layout can span multiple cells if desired
			positionConst.gridwidth = 1;
			//cell in x pos 0
			positionConst.gridx = 0;
			//cell in y pos 0
			positionConst.gridy = 0;
			//add userLabel to the window with the set parameters above
			add(emailLabel, positionConst);
			
			//set new parameters for each element to be added to the window (the field for the email)
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 0;
			add(emailField, positionConst);
			
			//user label
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.WEST;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 1;
			add(userLabel, positionConst);
			
			//user field
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 1;
			add(userField, positionConst);
			
			//password label
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.WEST;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 2;
			add(passLabel, positionConst);
			
			//password field
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 2;
			add(passField, positionConst);
			
			//create account button
			positionConst.insets = new Insets(3, 3, 3, 3);
			//using fill and .both instead of anchor to fill the entire cell with the button
			positionConst.fill = GridBagConstraints.BOTH;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 3;
			add(createAccountButton, positionConst);
			
		} catch(Exception e) {

		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		//Code executes upon given action
		if(event.getSource() == createAccountButton) {
			//Get the Strings from the fields when the create account button is pushed
			String email = emailField.getText();
			String username = userField.getText();
			String password = passField.getText();
			
			//Pass a new account these parameters
			Account newAccount = new Account(username, password, email);
		
			//Prints all accounts for testing purposes
			/*
			for(int i = 0; i < Account.numAccounts; ++i) {
				System.out.println(Account.accountList[i].getEmail() + ", " + Account.accountList[i].getUsername() + 
						", " + Account.accountList[i].getPassword());
			}
			*/
		}
	}
}
