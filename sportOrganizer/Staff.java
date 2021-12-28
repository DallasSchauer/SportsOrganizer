package sportOrganizer;

public class Staff extends Account {

	public Staff() {
		super();
	}
	
	public Staff (String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
