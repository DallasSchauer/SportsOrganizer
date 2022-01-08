package sportOrganizer;

public class League extends Event {
    int numGames;
    Game[] schedule; // probably will change to Schedule soon if that is necessary.
    int[][] teamRecords; // array of array of records that matches each team.
    


    League() {
        // default constructor, avoid using.
    }

    League (String name, String sport, int maxTeams, int numGames, int age) {
        this.name = name;
        this.sport = name;
        this.maxTeams = maxTeams;
        this.numGames = numGames;
        this.age = age;

        this.participants = new Team[maxTeams];
        this.schedule = new Game[numGames * maxTeams];
        this.teamRecords = new int[maxTeams][2];
    }

    // 	FUNCTION: ADD TEAM
	//  Adds a team to an event.
	void addTeam (Team team) {
		if (numTeams >= maxTeams) {
			System.out.println("Event is full. Team cannot be added.");
			return;
		}
		
		this.participants[numTeams] = team;
        this.teamRecords[numTeams][0] = 0;
        this.teamRecords[numTeams][1] = 0;

		this.numTeams++;
	}
	
	// FUNCTION: REMOVE TEAM
	// Searches for a team in an event and removes them if they are found.
	void removeTeam (Team team) {
        if (numTeams == 0) {
            System.out.println("Event is empty. Team cannot be revmoed.");
        }
		
        int retValue;

		if ((retValue = searchTeam(team)) == -1) {
			System.out.println("Team not found.");
			return;
		}
		
		for (int i = retValue; i < numTeams; i++) {
			participants[i] = participants[i+1];
            teamRecords[i][0] = teamRecords[i+1][0];
            teamRecords[i][1] = teamRecords[i+1][1];
		}
		numTeams--;
	}
}
