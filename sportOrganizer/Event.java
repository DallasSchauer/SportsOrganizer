package sportOrganizer;

public class Event {

	protected String username;
	protected String sport;
	protected Schedule gameSchedule;
	protected int numTeams;
	protected int age;
	protected Team[] teamList;
	
	void updateAllStandings () {
		
	}
	
	void addTeam (Team team) {
		
	}
	
	void removeTeam (Team team) {
		
	}
	
	Schedule generateSchedule () {
		Schedule S = new Schedule();
		return S;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSport() {
		return sport;
	}
	
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	public Schedule getGameSchedule() {
		return gameSchedule;
	}
	
	public void setGameSchedule(Schedule gameSchedule) {
		this.gameSchedule = gameSchedule;
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
	
	public Team[] getTeamList() {
		return teamList;
	}
	
	public void setTeamList(Team[] teamList) {
		this.teamList = teamList;
	}
	

}
