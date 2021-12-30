package sportOrganizer;

public class Coach extends Account {
protected Team[] teamList;
protected int teamCount;

	// default constructor, shouldn't really be used.
	public Coach() {
		super();
	}
	
	// CONSTRUCTOR: COACH
	// Actual constructor that will create a coach object and initialize it's variables.
	public Coach (String username, String password, String email) {
		super(username, password, email);
		this.teamList = new Team[10];
		this.teamCount = 0;
	}

	// FUNCTION: CREATE TEAM
	// Creates a new team object and adds to the coach's team list.
	protected void createTeam (String name, String sport, int age) {
		if (teamCount == 10) {
			System.out.println("No more teams can be created.");
		}

		// Initialize teamList and teamCount.
		this.teamList[teamCount] = new Team (name, sport, age);
		this.teamCount++;
	}

	// FUNCTION: ADD PLAYER TO TEAM
	// Add a player to a team with a specified team and name. Players are just strings.
	protected void addPlayerToTeam (Team team, String name) {
		// Add player to a team's player list. The length should work as the appropriate index.
		this.team.playerList[team.playerCount] = name;
		this.team.playerCount++;
	}

	// FUNCTION: PRINT ALL TEAMS
	// Debugging function to help print all teams a coach has created and all the players on the roster.
	protected void printAllTeams () {
		for (int i = 0; i < this.teamCount; i++) {
			System.out.println ("Team" + i ": " + this.teamList[i].name);
			for (int j = 0; j < this.teamList[i].playerList.length; j++) {
				System.out.println (this.teamList[i].playerList[j]);
			}
		}
	}
}
