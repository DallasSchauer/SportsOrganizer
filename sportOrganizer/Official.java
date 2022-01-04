package sportOrganizer;

public class Official extends Account {
	protected String name;
	protected long[] availability; // possibly represent dates as dd/mm/yy
	protected int availableDaysCount; // keeps track of length of availability.
	protected Game[] schedule; // possibly represent times as dd/mm/yy/start time in military
	// 2912212200 would represent 10 pm, December 29 2021? Just a possible solution. 
	protected int scheduleShiftsCount; // keeps track of number of shifts on the schedule.

	// default constructor; do not plan to use.
	public Official () {
		super();
	}
	
	// CONSTRUCTOR: OFFICIAL
	// Creates a new official with the arguments in its fields as well as initializing as an empty availability and schedule.
	public Official (String username, String password, String email, String name) {
		super(username, password, email);

		this.name = name;
		this.availability = new long[100];
		this.availableDaysCount = 0;
		
		//this.schedule = new long[100];
		/*
		 * This is giving me an error since schedule is declared as an array of type Game, but here it is being assigned 
		 * an array of 100 long. I am not sure which one needs to be changed.
		 */
		
		this.scheduleShiftsCount = 0;
	}

	// FUNCTION: SUBMIT SCORE
	// Submits a score for a game. 
	protected void submitScore (Game game, int score1, int score2) {
		if (score1 < 0 || score2 < 0) {
			System.out.println("Not a valid score. Submit a new one.");
		}
		game.score[0] = score1;
		game.score[1] = score2;
		game.played = true;
		removeGameFromSchedule(game);
	}

	// FUNCTION: ADD AVAILABILITY 
	// Adds an available day to an officials available days list.
	protected void addAvailability (long day) {
		if (day < 0) {
			System.out.println("Invalid availability. Try again.");
			return;
		}

		this.availability[availableDaysCount] = day;
		this.availableDaysCount++;
	}

	// FUNCTION: ADD GAME TO SCHEDULE
	// Adds a game to an officials list of games they are scheduled to officiate.
	protected void addGameToSchedule (Game game) {
		if (this.scheduleShiftsCount == 100) {
			System.out.println("Schedule is full, cannot add another game.");
			return;
		}
		this.schedule[this.scheduleShiftsCount] = game;
		this.scheduleShiftsCount++;
	}

	// FUNCTION: REMOVE GAME FROM SCHEDULE
	// Traverses through the official's scheduled games and searches for the game that matches it.
	// When it finds the game, it removes the game.
	protected void removeGameFromSchedule (Game game) {
		for (int i = 0; i < this.scheduleShiftsCount; i++) {
			if (this.schedule[i].time == game.time) {
				if (this.schedule[i].participants[0].name.equals(game.participants[0].name) && 
				this.schedule[i].participants[1].name.equals(game.participants[1].name)) {
					this.schedule[i] = null;
					this.scheduleShiftsCount--;
				}
			}
		}
	}

	protected void printSchedule () {
		System.out.println("PRINTING " + this.name + "'S SCHEDULE -----");
		for (int i = 0; i < scheduleShiftsCount; i++) {
			Game temp = this.schedule[i];
			System.out.println(
				"TIME: " + temp.time + 
				"\nTEAM 1: " + temp.participants[0] +
				"\nTEAM 2: " + temp.participants[1] +
				"\nLOCATION: " + temp.location +
				"\nOFFICIAL: " + temp.referee.name);
		}
	}
}