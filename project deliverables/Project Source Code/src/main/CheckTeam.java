package main;

import javax.swing.JOptionPane;

public class CheckTeam {
	private static int minMedsCost = 20000;
	private static WindowManager manager;
	
	public static boolean checkTeam() {
		if (Team.startingFive.size() < 5) {
			JOptionPane.showMessageDialog(GameMenuScreen.getFrmGameMenu(), "Not enough players!", "Insufficient Players", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if ((Team.startingFive.size() + Team.benchFive.size()) < 5 && (5 - (Team.startingFive.size() + Team.benchFive.size()) * minMedsCost > Money.getMoney())) {
			manager.launchSeasonEnd();
			PostGame.getFrmPostGame().dispose();
			return false;
		} else {
			return true;
		}
	}
	
}
