package sportOrganizer;

public class Team {
	protected String name;
	protected String sport;
	protected int age;
	public String[] playerList;
	public int playerCount;
	
	public Team(String name, String sport, int age) {
		this.name = name;
		this.sport = sport;
		this.age = age;
	}

}