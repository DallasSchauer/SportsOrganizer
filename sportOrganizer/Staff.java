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
	
	protected void createLeague (String name, String sport, int maxTeams, int numGames, int age) {
		League leg = new League (name, sport, maxTeams, numGames, age);

	}

	protected void createTournamet (String name, String sport, int age, int type) {
		
	}

	protected void editScore (Game game, int score1, int score2) {

	}

	protected void cancelGame (Game game) {

	}

	protected void assignOfficialToGame (Game game, Official official) {

	}
}
