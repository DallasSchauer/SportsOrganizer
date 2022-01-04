package sportOrganizer;

public class League extends Event {
    String name;
    String sport;
    int maxTeams;
    int numGames;
    int age;
    Team[] participants;
    Game[] schedule;


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
    }
}
