package sportOrganizer;

public class Official extends Account {

	public Official () {
		super();
	}
	
	public Official (String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
