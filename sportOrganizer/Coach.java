package sportOrganizer;

public class Coach extends Account {

	public Coach() {
		super();
	}
	
	public Coach (String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
