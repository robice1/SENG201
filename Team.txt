import java.util.ArrayList;


public class Team {
	private String name;
	private int numPlayers = 10;
	private ArrayList<Athlete> players;
	
	public Team(String name) {
		this.name = name;
		players = new ArrayList<Athlete>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public boolean addPlayer(Athlete player) {
		if (players.size() < numPlayers) {
			players.add(player);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removePlayer(Athlete player) {
		if (players.contains(player)) {
			players.remove(player);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setUpTeam(ArrayList<Athlete> athletes) {
		players = athletes;
	}
	
	
	public static void main(String[] args) {
		Team fakers = new Team("LA Fakers");
		Team tenders = new Team("Denver Tenders");
		Team deer = new Team("Milwaukee Deer");
		Team undies = new Team("New York Undies");
		Team ice = new Team("Albuquerque Ice");
		Team meat = new Team("Miami Meat");
		Team philly = new Team("Philly 69ers");
		Team starmen = new Team("Houston Starmen");
		Team cows = new Team("Chicago Cows");
	}
}
