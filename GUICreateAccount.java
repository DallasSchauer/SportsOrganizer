package sportOrganizer;

import java.awt.Color;
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
public class GUICreateAccount extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// create labels
	static JLabel userLabel;
	static JLabel passLabel;
	static JLabel emailLabel;
	static JLabel errorLabel;

	// create text fields where users can edit text
	static JTextField userField;
	static JTextField passField;
	static JTextField emailField;

	// create the buttons
	static JButton createAccountButton;

	GUICreateAccount() {

		setTitle("Login or sign up");
		setResizable(false);

		// put text to the labels
		userLabel = new JLabel("Choose a username:");
		passLabel = new JLabel("Choose a password:");
		emailLabel = new JLabel("Choose an email:");
		errorLabel = new JLabel("Account Creation");

		// make userField editable and set the number of columns used to calculate width
		userField = new JTextField(25);
		userField.setEditable(true);

		// make passField editable and set the number of columns used to calculate width
		passField = new JTextField(25);
		passField.setEditable(true);

		// make passField editable and set the number of columns used to calculate width
		emailField = new JTextField(25);
		emailField.setEditable(true);

		// add action listener to create account button
		createAccountButton = new JButton("Create Account");
		createAccountButton.addActionListener(this);

		// initialize variable for setting parameters for each element in the window
		GridBagConstraints positionConst = null;
		positionConst = new GridBagConstraints();

		try {
			// Layout type
			// Grid bag layout positions elements in/across cells in a grid
			setLayout(new GridBagLayout());

			// error label
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.fill = GridBagConstraints.CENTER;
			positionConst.gridwidth = 3;
			positionConst.gridx = 1;
			positionConst.gridy = 0;
			add(errorLabel, positionConst);

			// parameters for emailLabel
			// insets are the spaces around each element used as "padding" (top, left,
			// bottom, right)
			positionConst.insets = new Insets(3, 3, 3, 3);
			// anchoring the element within its position in its grid space
			positionConst.anchor = GridBagConstraints.WEST;
			// elements in grid bag layout can span multiple cells if desired
			positionConst.gridwidth = 1;
			// cell in x pos 0
			positionConst.gridx = 0;
			// cell in y pos 0
			positionConst.gridy = 1;
			// add userLabel to the window with the set parameters above
			add(emailLabel, positionConst);

			// set new parameters for each element to be added to the window (the field for
			// the email)
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 1;
			add(emailField, positionConst);

			// user label
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.WEST;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 2;
			add(userLabel, positionConst);

			// user field
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 2;
			add(userField, positionConst);

			// password label
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.WEST;
			positionConst.gridwidth = 1;
			positionConst.gridx = 0;
			positionConst.gridy = 3;
			add(passLabel, positionConst);

			// password field
			positionConst.insets = new Insets(3, 3, 3, 3);
			positionConst.anchor = GridBagConstraints.CENTER;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 3;
			add(passField, positionConst);

			// create account button
			positionConst.insets = new Insets(3, 3, 3, 3);
			// using fill and .both instead of anchor to fill the entire cell with the
			// button
			positionConst.fill = GridBagConstraints.BOTH;
			positionConst.gridwidth = 2;
			positionConst.gridx = 1;
			positionConst.gridy = 4;
			add(createAccountButton, positionConst);

		} catch (Exception e) {

		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Code executes upon given action
		if (event.getSource() == createAccountButton) {
			// Get the Strings from the fields when the create account button is pushed
			String username = userField.getText();
			String email = emailField.getText();
			int i = 0;
			boolean validEmail = true;
			boolean validUser = true;

			// check to see if username or email is already taken
			for (i = 0; i < Account.numAccounts; ++i) {
				if (Account.accountList[i].getEmail().equals(email)) {
					validEmail = false;
				}
				if (Account.accountList[i].getUsername().equals(username)) {
					validUser = false;
				}
			}

			// only add account if both email and username are unique
			if (validEmail == true && validUser == true) {

				// We can suppress this warning because this will add an account to the account
				// data structure in its constructor

				@SuppressWarnings("unused")
				Account newAccount = new Account(username, passField.getText(), email);
			} else if (validEmail == true && validUser == false) {
				errorLabel.setForeground(Color.RED);
				errorLabel.setText("Username already taken");
			} else if (validEmail == false) {
				errorLabel.setForeground(Color.RED);
				errorLabel.setText("Email already taken");
			}
			// Prints all accounts for testing purposes

			/*
			 * for(i = 0; i < Account.numAccounts; ++i) {
			 * System.out.println(Account.accountList[i].getEmail() + ", " +
			 * Account.accountList[i].getUsername() + ", " +
			 * Account.accountList[i].getPassword()); }
			 */
		}
	}
}
