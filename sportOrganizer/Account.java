package sportOrganizer;



public class Account {

protected String username;
protected String password;
protected String email;

public static Account[] accountList = new Account[100];
public static int numAccounts = 0;
	
	protected Account () {
		this.username = null;
		this.password = null;
		this.email = null;
		
		// default constructor ; will not be used
	}
	
	protected Account (String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		
		// add new made account to the list of accounts
		accountList[numAccounts] = this;
		numAccounts++;
		
	}
	
	boolean logIn (String username, String password) {
		for (int i = 0; i < numAccounts; i++) {
			if (username.equals(accountList[i].username)) {
				if (password.equals(accountList[i].password)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	
	void printAccountList () {
		System.out.println("LIST OF ACCOUNTS ----------------------------------------------------");
		for (int i = 0; i < numAccounts; i++) {
			System.out.println("ACCOUNT " + i + "\tUSERNAME: " + accountList[i].username + "; PASSWORD: " + accountList[i].password + "; EMAIL: " + accountList[i].email);
		}
		System.out.println("TOTAL NUMBER OF ACCOUNTS: " + numAccounts);
	}
	
	// Getters and Setters


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

