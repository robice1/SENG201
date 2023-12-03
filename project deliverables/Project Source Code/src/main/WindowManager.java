package main;

public class WindowManager {
	
	public void launchMain() {
		MainMenu mainScreen = new MainMenu(this);
		FreeAgents.addPlayers();
	}
	
	public void closeMainScreen(MainMenu mainScreen) {
		mainScreen.closeWindow();
		launchSetup();
	}

	public void launchSetup() {
		SetupWindow setupScreen = new SetupWindow(this);
	}
	
	
	public void backToMain (SetupWindow setupScreen) {
		setupScreen.closeWindow();
		launchMain();
	}
	
	public void launchDraft() {
		DraftScreen draftScreen = new DraftScreen(this);
	}
	
	public void launchSeasonEnd() {
		SeasonEnd endSeason = new SeasonEnd(this);
	}
	
	public void launchDraftFromMain() {
		DraftScreen draftScreen = new DraftScreen(this);
	}
	
	public void launchMainMenu() {
		GameMenuScreen mainMenu = new GameMenuScreen(this);
	}
	
	public void openGameWindow() {
		GameWindow gameWindow = new GameWindow(this);
	}
	
	public void openRecap() {
		PostGame postGameWindow = new PostGame(this);
	}
	
	public void launchItemShop() {
		ItemShop shopWindow = new ItemShop(this);
	}
	
	public void launchPreGame() {
		PreGame preGame = new PreGame(this);
	}
	
	public void setupContinue (SetupWindow setupScreen) {
		setupScreen.closeWindow();
		launchDraft();
	}

	public static void main(String[] args) {
		WindowManager manager = new WindowManager();
		manager.launchMain();

	}

}
