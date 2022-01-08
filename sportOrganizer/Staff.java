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
	
	// FUNCTION: CREATE LEAGUE
	// Makes sure the given information is valid and creates a league then adds it to the list of all leagues in the system.
	protected void createLeague (String name, String sport, int maxTeams, int numGames, int age) {
		if (maxTeams < 0 || maxTeams > 128) {
			System.out.println("ERROR: Maximum number of teams must be between 0-128.");
		}
		if (numGames < 0 || numGames > 32) {
			System.out.println("ERROR: Number of games must be between 0-32.");
		}
		if (age < 0 || age > 18) {
			System.out.println("ERROR: Ages must be between 0 and 18. If league is for adults, please enter 18.");
		}

		League leg = new League (name, sport, maxTeams, numGames, age);
		Event.EventNode.leagueList.addNode(leg);

	}

	// FUNCTION: CREATE TOURNAMENT
	// Makes sure the given information is valid and creates a tournament then adds it to the list of all tournaments in the system.
	protected void createTournament (String name, String sport, int maxTeams, int age, int type) {
		if (maxTeams < 0 || maxTeams > 128) {
			System.out.println("ERROR: Maximum number of teams must be between 0-128.");
		}
		
		if (age < 0 || age > 18) {
			System.out.println("ERROR: Ages must be between 0 and 18. If league is for adults, please enter 18.");
		}
		if (type < 0 || age > 2) {
			System.out.println("ERROR: Invalid tournament type.");
		}

		Tournament to = new Tournament (name, sport, maxTeams, age, type);
		Event.EventNode.tournamentList.addNode(to);
	}

	// FUNCTION: SUBMIT SCORE
	// Submits a score for a game. 
	protected void editScore (Game game, int score1, int score2) {
		if (score1 < 0 || score2 < 0) {
			System.out.println("Not a valid score. Submit a new one.");
		}
		game.score[0] = score1;
		game.score[1] = score2;
		if (game.played == false) {
			game.played = true;
		}	
	}

	// FUNCTION: CANCEL GAME
	// Cancels a game.
	protected void cancelGame (Game game) {

	}

	// FUNCTION: ASSIGN OFFICIAL TO GAME
	// Assigns official to a game as the game's referee.
	protected void assignOfficialToGame (Game game, Official official) {
		game.referee = official;
	}
}
