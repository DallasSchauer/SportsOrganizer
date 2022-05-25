package sportOrganizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//needs to implement action listener for the buttons to do an action when clicked
public class GUILoginWindow extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//create labels
	static JLabel userLabel;
	static JLabel passLabel;
	static JLabel errorLabel;
	
	//create text fields where users can edit text
	static JTextField userField;
	static JTextField passField;
	
	//create the buttons
	static JButton createAccountButton;
	static JButton loginButton;
	
	public GUILoginWindow(){
		
		setTitle("Login or sign up");
		setResizable(false);
		
		//put text to the labels
		userLabel = new JLabel("Username:");
		passLabel = new JLabel("Password:");
		errorLabel = new JLabel("Enter login information");
		
		//make userField editable and set the number of columns used to calculate width
		userField = new JTextField(25);
		userField.setEditable(true);
		
		//make passField editable and set the number of columns used to calculate width
		passField = new JTextField(25);
		passField.setEditable(true);
		
		//add action listener to create account button
		createAccountButton = new JButton("Create Account");
		createAccountButton.addActionListener(this);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		
		//initialize variable for setting parameters for each element in the window
		GridBagConstraints positionConst = null;
		positionConst = new GridBagConstraints();
		
		try {
			//Layout type
			//Grid bag layout positions elements in/across cells in a grid
			setLayout(new GridBagLayout());
			
			//password label
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 3;
			positionConst.gridx = 1;
			positionConst.gridy = 0;
			add(errorLabel, positionConst);
			
			//parameters for userLabel
			//insets are the spaces around each element used as "padding" (top, left, bottom, right)
			positionConst.insets = new Insets(3, 3, 3, 3);
			//anchoring the element within its position in its grid space
			positionConst.anchor = GridBagConstraints.CENTER;
			//elements in grid bag layout can span multiple cells if desired
			positionConst.gridwidth = 1;
			//cell in x pos 0
			positionConst.gridx = 0;
			//cell in y pos 0
			positionConst.gridy = 1;
			//add userLabel to the window with the set parameters above
			add(userLabel, positionConst);
			
			//set new parameters for each element to be added to the window (the field for the username)
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 1;
			add(userField, positionConst);
			
			//password label
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
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
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 1;
			positionConst.gridx = 1;
			positionConst.gridy = 3;
			add(createAccountButton, positionConst);
			
			//login button
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.LINE_END;
			positionConst.gridwidth = 1;
			positionConst.gridx = 2;
			positionConst.gridy = 3;
			add(loginButton, positionConst);
			
		} catch(Exception e) {

		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		//Code executes upon given action
		if(event.getSource() == createAccountButton) {
	    	//run the window in its own thread
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	
	            		//Creates the "create account" window
	                    GUICreateAccount accountWindow = new GUICreateAccount();
	                    
	                    //make window visible
	                    accountWindow.setVisible(true);

	                    //when program is started, set the size of the window to a fraction of the screen size
	                    Dimension bounds = Toolkit.getDefaultToolkit().getScreenSize();
	                    accountWindow.setSize(bounds.width / 2, bounds.height / 2);
	                    
	                    //sizes window to the edge of elements in the window
	                    //loginWindow.pack();
	            }
	        });
		}
		if(event.getSource() == loginButton) {
			int i = 0;
			boolean validCredentials = false;
			
			//find and login with credentials
			for(i = 0; i < Account.numAccounts; ++i) {
				if(Account.accountList[i].getUsername().equals(userField.getText()) &&
						Account.accountList[i].getPassword().equals(passField.getText())) {
					validCredentials = true;
					break;
				}
			}
			
			if(validCredentials == true) {
				Account.currentAccount = Account.accountList[i].getUsername();
		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	
		            		//Creates the "create account" window
		                    GUIMainWindow mainWindow = new GUIMainWindow();
		                    
		                    //make window visible
		                    mainWindow.setVisible(true);

		                    //when program is started, make the window maximized
		                    mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
		            }
		        });
			}
			else {
				errorLabel.setForeground(Color.RED);
				errorLabel.setText("Invalid credentials");
			}
		}
	}
}
