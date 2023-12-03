package main;

import java.util.ArrayList;
/**
 * Holds the information about the Free Agents
 *
 */
public class FreeAgents {
	
	public static ArrayList<Athlete> freeAgentsList = new ArrayList<>();
	
	/**
	 * Adds the players to the Free Agent List
	 */
	public static void addPlayers() {
		Athlete free1 = new Athlete("Ben");
		Athlete free2 = new Athlete("Garry");
		Athlete free3 = new Athlete("Gus");
		Athlete free4 = new Athlete("Cameron");
		Athlete free5 = new Athlete("Jorden");
		Athlete free6 = new Athlete("Hayden");
		Athlete free7 = new Athlete("Martin");
		Athlete free8 = new Athlete("Harley");
		Athlete free9 = new Athlete("Jarrod");
		Athlete free10 = new Athlete("Matthew");

		Athlete free11 = new Athlete("Eric");
		Athlete free12 = new Athlete("Josh");
		Athlete free13 = new Athlete("Hamish");
		Athlete free14 = new Athlete("Flynn");
		Athlete free15 = new Athlete("Craig");
		Athlete free16 = new Athlete("Shunna");
		Athlete free17 = new Athlete("Swae");
		Athlete free18 = new Athlete("Kendrick");
		Athlete free19 = new Athlete("Kanye");
		Athlete free20 = new Athlete("Che");

		Athlete free21 = new Athlete("Russel");
		Athlete free22 = new Athlete("Luke");
		Athlete free23 = new Athlete("Logan");
		Athlete free24 = new Athlete("Luka");
		Athlete free25 = new Athlete("Charles");
		Athlete free26 = new Athlete("Jamie");
		Athlete free27 = new Athlete("Will");
		Athlete free28 = new Athlete("Richard");
		Athlete free29 = new Athlete("Dalene");
		Athlete free30 = new Athlete("Jack");
		
		freeAgentsList.add(free30);
		freeAgentsList.add(free2);
		freeAgentsList.add(free3);
		freeAgentsList.add(free4);
		freeAgentsList.add(free5);
		freeAgentsList.add(free6);
		freeAgentsList.add(free7);
		freeAgentsList.add(free8);
		freeAgentsList.add(free9);
		freeAgentsList.add(free10);
		freeAgentsList.add(free11);
		freeAgentsList.add(free12);
		freeAgentsList.add(free13);
		freeAgentsList.add(free14);
		freeAgentsList.add(free15);
		freeAgentsList.add(free16);
		freeAgentsList.add(free17);
		freeAgentsList.add(free18);
		freeAgentsList.add(free19);
		freeAgentsList.add(free20);
		freeAgentsList.add(free21);
		freeAgentsList.add(free22);
		freeAgentsList.add(free23);
		freeAgentsList.add(free24);
		freeAgentsList.add(free25);
		freeAgentsList.add(free26);
		freeAgentsList.add(free27);
		freeAgentsList.add(free28);
		freeAgentsList.add(free29);
		freeAgentsList.add(free1);
	}
	
	/**
	 * Returns the free agent list
	 * @return free agent list
	 */
	public static ArrayList<Athlete> getFreeAgents() {
		return freeAgentsList;
	}
	/**
	 * Removes a player from free agency
	 * @param player the player to remove
	 */
	public static void removeFreeAgent(Athlete player) {
		freeAgentsList.remove(player);
	}
	
	/**
	 * Adds a player to the free agent list
	 * @param player the player to add
	 */
	public static void addFreeAgent(Athlete player) {
		freeAgentsList.add(player);
	}
	
	/**
	 * Removes all free agents
	 */
	public static void clearFreeAgents() {
		freeAgentsList.clear();	
	}
	
	public static void main(String[] args) {
		
	}
}
