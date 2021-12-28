package sportOrganizer;

public class Account {

protected String username;
protected String password;
protected String email;

	
	protected Account () {
		this.username = null;
		this.password = null;
		this.email = null;
	}
	
	protected Account (String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		
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
}

