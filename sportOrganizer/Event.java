package sportOrganizer;



public class Event {

	protected String name; // name of event.
	protected String sport; // sport name.
	protected int numTeams; // number of teams actually registered in the event.
	protected int maxTeams; // maximum number of teams that can be in the event.
	protected int age; // age level of players that can be in the event.
	protected Team[] participants; // list of teams in the event.

	// took these from schedule, i'm starting to think that class is not necessary.
	protected long startDate; // the earliest date a game can be scheduled.
	protected long endDate; // the latest date a game can be scheduled.
	protected long startTime; // the earliest acceptable time in a day a game can be scheduled for. tttt format.
	protected long endTime; // the latest acceptable time in a day a game can be schedule for. tttt
	protected String[] locations; // possible locations that the games can take place.
	protected boolean[] days; // 7 index array that represents dates of the week (0 = Sunday, 6 = Saturday). Can be edited so schedule knows what days can be scheduled on.

	

	public class EventNode {
		Event event;
		EventNode next;

		public static EventNode tournamentList;
		public static EventNode leagueList;

		EventNode () {
			event = null;
			next = null;
		}

		EventNode (Event event) {
			this.event = event;
			next = null;
		}

		// FUNCTION: ADD NODE
		// Adds a node to the level of events. 
		public void addNode (Event event) {
			EventNode temp;
			if (event instanceof League) {
				temp = leagueList.next;
			} else if (event instanceof Tournament) {
				temp = tournamentList.next;
			} else {
				System.out.println("ERROR: Event is not of type league or tournament.");
				return;
			}

			while (temp != null) {
				temp = temp.next;
			}

			temp = new EventNode(event);
		}

		public void removeNode (Event event) {
			EventNode temp, prev = null;
			if (event instanceof League) {
				temp = leagueList;
			} else if (event instanceof Tournament) {
				temp = tournamentList;
			} else {
				System.out.println("ERROR: Event is not of type league or tournament.");
				return;
			}

			while (temp != null) {
				if (temp.event.equals(event)) {
					prev.next = temp.next;
					return;
				}
				prev = temp;
				temp = temp.next;
			}

			return;
		}
	}
	
	// 	FUNCTION: ADD TEAM
	//  Adds a team to an event.
	void addTeam (Team team) {
		if (numTeams >= maxTeams) {
			System.out.println("Event is full. Team cannot be added.");
			return;
		}
		
		this.participants[numTeams] = team;
		this.numTeams++;

		if (this instanceof League) {

		}
	}
	
	// FUNCTION: REMOVE TEAM
	// Searches for a team in an event and removes them if they are found.
	void removeTeam (Team team) {
		int retValue;

		if ((retValue = searchTeam(team)) == -1) {
			System.out.println("Team not found.");
			return;
		}
		
		for (int i = retValue; i < numTeams; i++) {
			participants[i] = participants[i+1];
		}
		numTeams--;
	}

	// FUNCTION: SEARCH TEAM
	// Searches an event for a team and returns their array index.
	protected int searchTeam (Team team) {
		for (int i = 0; i < numTeams; i++) {
			if (this.participants[i].equals(team)) {
				return i;
			}
		}
		return -1;
	}

	// FUNCTION: SET START AND END DATES
	// Used to set the first and last days of the event
	protected void setStartAndEnd (long start, long end) {
		if (Utils.compareDates(start, end) == end) {
			System.out.println("ERROR: End date cannot be chronologically earlier than the end date.");
		}

		this.startDate = start;
		this.endDate = end;
	}

	// FUNCTION: SET START AND END TIMES
	// Used to set the earliest and last days of the event.
	protected void setTimes (long start, long end) {
		if (start < 0 || start > 2359 || end < 0 || end > 2359) {
			System.out.println("ERROR: Times given are not valid. Use military time 0000 - 2359.");
		}
		this.startTime = start;
		this.endTime = end;
	}

	// FUNCTION: SET DAYS
	// Used to set what days are available for scheduling.
	protected void setDays (boolean sun, boolean mon, boolean tue, boolean wed, boolean thur, boolean fri, boolean sat) {
		days[0] = sun;
		days[1] = mon;
		days[2] = tue;
		days[3] = wed;
		days[4] = thur;
		days[5] = fri;
		days[6] = sat;
	}

	// FUNCTION: ADD LOCATION
	// Used to add possible locations for games to take place.
	protected void addLocation (String location) {
		int tracker = 0;
		
		while (!locations[tracker].equals(null)) {
			tracker++;
		}
		
		locations[tracker] = location;
	}
	
	Schedule generateSchedule () {
		Schedule S = new Schedule();
		return S;
	}

	// GETTERS AND SETTERS ---------------------------------------------------------------
	
	public String getSport() {
		return sport;
	}
	
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	public int getNumTeams() {
		return numTeams;
	}
	
	public void setNumTeams(int numTeams) {
		this.numTeams = numTeams;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Team[] getParticipants () {
		return participants;
	}
	
	public void setParticipants (Team[] teamList) {
		this.participants = teamList;
	}
	

}
