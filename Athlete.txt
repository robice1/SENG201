
public class Athlete {
	private String name;
	private int fitness;
	private int stamina;
	private int offense;
	private int defense;
	private boolean injured;
	private String position;
	
	public Athlete(String name, int fitness, int offense, int defense) {
		this.name = name;
		this.fitness = fitness;
		this.offense = offense;
		this.defense = defense;
		stamina = 100;
		injured = false;
		if (offense > fitness && fitness > defense || fitness > offense && offense > defense) {
			position = "PG";
		}
		else if (offense > defense && defense > fitness) {
			position = "SG";
		}
		else if (fitness > defense && defense > offense) {
			position = "SF";
		}
		else if (defense > fitness && fitness > offense) {
			position = "PF";
		}
		else {
			position = "C";
		}
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String nickname) {
		name = nickname;
	}
	
	public int getFitness() {
		return fitness;
	}
	
	public void setFitness(int newFitness) {
		fitness = newFitness;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public void setStamina(int newStamina) {
		stamina = newStamina;
	}
	
	public int getOffense() {
		return offense;
	}
	
	public void setOffense(int offenseStat) {
		offense = offenseStat;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void setDefense(int defenseStat) {
		defense = defenseStat;
	}
	
	public void updateInjured() {
		if (stamina <= 0) {
			injured = true;
		}
	}
	
	public String getPosition() {
		return position;
	}
	
	public boolean getInjured() {
		return injured;
	}
	
	public static void main(String[] args) {
		Athlete fakers1 = new Athlete("DeBron", 60, 84, 47);
		Athlete fakers2 = new Athlete("Russ", 81, 69, 67);
		Athlete fakers3 = new Athlete("John", 67, 69, 82);
		Athlete fakers4 = new Athlete("Craig", 72, 70, 88);
		Athlete fakers5 = new Athlete("Steve", 60, 85, 88);
		Athlete fakers6 = new Athlete("Magic", 60, 85, 88);
		Athlete fakers7 = new Athlete("Coby", 60, 85, 88);
		Athlete fakers8 = new Athlete("Mitch", 60, 85, 88);
		Athlete fakers9 = new Athlete("Carmelo", 60, 85, 88);
		Athlete fakers10 = new Athlete("Nene", 60, 85, 88);
		
		Athlete tenders1 = new Athlete("Nikola", 75, 90, 84);
		Athlete tenders2 = new Athlete("Bruce", 75, 90, 84);
		Athlete tenders3 = new Athlete("Moses", 75, 90, 84);
		Athlete tenders4 = new Athlete("Ronald", 75, 90, 84);
		Athlete tenders5 = new Athlete("Brick", 75, 90, 84);
		Athlete tenders6 = new Athlete("Todd", 75, 90, 84);
		Athlete tenders7 = new Athlete("LaMarcus", 75, 90, 84);
		Athlete tenders8 = new Athlete("Chris", 75, 90, 84);
		Athlete tenders9 = new Athlete("Dikembe", 75, 90, 84);
		Athlete tenders10 = new Athlete("Tyrell", 75, 90, 84);
		
		Athlete deer1 = new Athlete("Giannis", 75, 90, 84);
		Athlete deer2 = new Athlete("Grayson", 75, 90, 84);
		Athlete deer3 = new Athlete("Bobby", 75, 90, 84);
		Athlete deer4 = new Athlete("Jrue", 75, 90, 84);
		Athlete deer5 = new Athlete("Goran", 75, 90, 84);
		Athlete deer6 = new Athlete("Pat", 75, 90, 84);
		Athlete deer7 = new Athlete("Thanasis", 75, 90, 84);
		Athlete deer8 = new Athlete("Jae", 75, 90, 84);
		Athlete deer9 = new Athlete("Meyers", 75, 90, 84);
		Athlete deer10 = new Athlete("Khris", 75, 90, 84);
		
		Athlete undies1 = new Athlete("Jack", 75, 90, 84);
		Athlete undies2 = new Athlete("Julius", 75, 90, 84);
		Athlete undies3 = new Athlete("Jalen", 75, 90, 84);
		Athlete undies4 = new Athlete("RJ", 75, 90, 84);
		Athlete undies5 = new Athlete("Josh", 75, 90, 84);
		Athlete undies6 = new Athlete("Derrick", 75, 90, 84);
		Athlete undies7 = new Athlete("Mitchell", 75, 90, 84);
		Athlete undies8 = new Athlete("Immanuel", 75, 90, 84);
		Athlete undies9 = new Athlete("Obi", 75, 90, 84);
		Athlete undies10 = new Athlete("Isaiah", 75, 90, 84);

		Athlete ice1 = new Athlete("Robbie", 75, 90, 84);
		Athlete ice2 = new Athlete("Tuco", 75, 90, 84);
		Athlete ice3 = new Athlete("Gene", 75, 90, 84);
		Athlete ice4 = new Athlete("Mike", 75, 90, 84);
		Athlete ice5 = new Athlete("Gus", 75, 90, 84);
		Athlete ice6 = new Athlete("Jesse", 75, 90, 84);
		Athlete ice7 = new Athlete("Saul", 75, 90, 84);
		Athlete ice8 = new Athlete("Flynn", 75, 90, 84);
		Athlete ice9 = new Athlete("Walter", 75, 90, 84);
		Athlete ice10 = new Athlete("Skyler", 75, 90, 84);
		
		Athlete meat1 = new Athlete("Jimmy", 80, 80, 80);
		Athlete meat2 = new Athlete("Kevin", 80, 80, 80);
		Athlete meat3 = new Athlete("Tyler", 80, 80, 80);
		Athlete meat4 = new Athlete("Bam", 80, 80, 80);
		Athlete meat5 = new Athlete("Kyle", 80, 80, 80);
		Athlete meat6 = new Athlete("Udonis", 80, 80, 80);
		Athlete meat7 = new Athlete("Cody", 80, 80, 80);
		Athlete meat8 = new Athlete("Max", 80, 80, 80);
		Athlete meat9 = new Athlete("Victor", 80, 80, 80);
		Athlete meat10 = new Athlete("Duncan", 80, 80, 80);
		
		Athlete philly1 = new Athlete("Joel", 80, 80, 80);
		Athlete philly2 = new Athlete("James", 80, 80, 80);
		Athlete philly3 = new Athlete("Tyrese", 80, 80, 80);
		Athlete philly4 = new Athlete("Tobias", 80, 80, 80);
		Athlete philly5 = new Athlete("Mac", 80, 80, 80);
		Athlete philly6 = new Athlete("PJ", 80, 80, 80);
		Athlete philly7 = new Athlete("Jalen", 80, 80, 80);
		Athlete philly8 = new Athlete("Paul", 80, 80, 80);
		Athlete philly9 = new Athlete("Anthony", 80, 80, 80);
		Athlete philly10 = new Athlete("George", 80, 80, 80);
		
		Athlete starmen1 = new Athlete("Jaden", 80, 80, 80);
		Athlete starmen2 = new Athlete("Alperen", 80, 80, 80);
		Athlete starmen3 = new Athlete("Jabari", 80, 80, 80);
		Athlete starmen4 = new Athlete("Boban", 80, 80, 80);
		Athlete starmen5 = new Athlete("Kevin", 80, 80, 80);
		Athlete starmen6 = new Athlete("Kenyon", 80, 80, 80);
		Athlete starmen7 = new Athlete("Frank", 80, 80, 80);
		Athlete starmen8 = new Athlete("Josh", 80, 80, 80);
		Athlete starmen9 = new Athlete("Sean", 80, 80, 80);
		Athlete starmen10 = new Athlete("Darius", 80, 80, 80);

		Athlete cows1 = new Athlete("Zach", 80, 80, 80);
		Athlete cows2 = new Athlete("Colby", 80, 80, 80);
		Athlete cows3 = new Athlete("Patrick", 80, 80, 80);
		Athlete cows4 = new Athlete("Chandler", 80, 80, 80);
		Athlete cows5 = new Athlete("DeMar", 80, 80, 80);
		Athlete cows6 = new Athlete("Andre", 80, 80, 80);
		Athlete cows7 = new Athlete("Derrick", 80, 80, 80);
		Athlete cows8 = new Athlete("Patrick", 80, 80, 80);
		Athlete cows9 = new Athlete("Terry", 80, 80, 80);
		Athlete cows10 = new Athlete("Justin", 80, 80, 80);

		
	}
}
