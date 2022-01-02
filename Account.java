package sportOrganizer;

public class Account {

protected String username;
protected String password;
protected String email;

public static Account[] accountList = new Account[100];
public static int numAccounts = 0;
public static String currentAccount;

	
	protected Account () {
		this.username = null;
		this.password = null;
		this.email = null;

		// default constructor; will not be used
	}
	
	protected Account (String username, String password, String email) {
		if (numAccounts == 100) {
			System.out.println("Accounts are full. No more can be made.");
			return;
		}

		this.username = username;
		this.password = password;
		this.email = email;

		// add new made account to the list of accounts
		accountList[numAccounts] = this;
		numAccounts++;
		
	}

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

	public String getCurrentAccount() {
		return currentAccount;
	}
	
	public void setCurrentAccount(String currentAccount) {
		this.currentAccount = currentAccount;
	}
}
