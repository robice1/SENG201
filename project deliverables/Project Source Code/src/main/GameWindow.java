package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class GameWindow {

	private static int oppScore;
	private static int playerScore;
	private JFrame frame;
	private static WindowManager manager;
    private Athlete selectedStarter;
    private Athlete selectedReserve;
    private OpponentTeam oppTeam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow(WindowManager incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public static int getOppScore() {
		return oppScore;
	}
	
	public static void setOppScore(int newPoints) {
		oppScore += newPoints;
	}

	
	public static int getPlayerScore() {
		return playerScore;
	}
	
	public static void setPlayerScore(int newPoints) {
		playerScore += newPoints;
	}
	
	public void launchRecap() {
		manager.openRecap();
		frame.dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Team.teamInjuries();
		playerScore = 0;
		oppScore = 0;
		oppTeam = Matchup.createOpponentTeam();
		Matchup.setHalf(0);
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel playerTeamLabel = new JLabel(Team.playerTeam.getName());
		playerTeamLabel.setFont(new Font("Octuple max", Font.PLAIN, 20));
		playerTeamLabel.setBounds(21, 28, 303, 48);
		frame.getContentPane().add(playerTeamLabel);
		
		JLabel lblVs = new JLabel("VS.");
		lblVs.setFont(new Font("Octuple max", Font.PLAIN, 20));
		lblVs.setBounds(326, 28, 65, 48);
		frame.getContentPane().add(lblVs);
		
		JLabel oppLabel = new JLabel(oppTeam.getName());
		oppLabel.setFont(new Font("Octuple max", Font.PLAIN, 20));
		oppLabel.setBounds(401, 28, 375, 48);
		frame.getContentPane().add(oppLabel);
		
		
		DefaultListModel<Athlete> myTeamInjuries = new DefaultListModel<>();
		DefaultListModel<Athlete> myTeamListModel = new DefaultListModel<>();
		DefaultListModel<Athlete> myReservesListModel = new DefaultListModel<>();
		// Add the existing items to the ListModel

		for (Athlete player : Team.injuredPlayers) {
			myTeamInjuries.addElement(player);
		}
		
		for (Athlete player : Team.playerTeam.getPlayers()) {
			if (Team.playerTeam.getStarters().contains(player)) {
				myTeamListModel.addElement(player);

			} else {
				myReservesListModel.addElement(player);

			}
		}

		JList<Athlete> myPlayerList = new JList<Athlete>(myTeamListModel);
		myPlayerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myPlayerList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		myPlayerList.setBounds(21, 104, 312, 110);
		frame.getContentPane().add(myPlayerList);
		
		JList<Athlete> myReserveList = new JList<Athlete>(myReservesListModel);
		myReserveList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myReserveList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		myReserveList.setBounds(21, 257, 312, 147);
		frame.getContentPane().add(myReserveList);
		
		JLabel lblNewLabel_1 = new JLabel("Bench");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(21, 227, 86, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("On the court");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(21, 74, 86, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Items");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(360, 74, 86, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		
		DefaultListModel<Purchasable> inventoryListModel = new DefaultListModel<>();
        JList<Purchasable> inventoryList = new JList<>(inventoryListModel);
        inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inventoryList.setFont(new Font("Tahoma", Font.PLAIN, 13));
        inventoryList.setBounds(360, 104, 126, 110);
		frame.getContentPane().add(inventoryList);
		
        ArrayList<Item> inventoryItems = Team.getInventory();
        if (inventoryItems != null) {
        	for (Purchasable item : inventoryItems) {
                inventoryListModel.addElement(item);
            }
        }
		
        JButton useItemButton = new JButton("Use Item");
        useItemButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        useItemButton.setBounds(142, 414, 110, 39);
        useItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //useSelectedItem();
                Athlete selectedPlayer = myPlayerList.getSelectedValue();
                Purchasable selectedItem = inventoryList.getSelectedValue();

                if (selectedPlayer != null && selectedItem != null) {
                    // Perform the desired action here, using the selected player and item
                    // For example:
                	if(selectedItem.getName() == "Panadol") {
                	} else if (selectedItem.getName() == "Panadol") {
                		selectedPlayer.setInjured(false);	
                	} else if (selectedItem.getName() == "Jump Rope") {
                		selectedPlayer.setOffense(selectedPlayer.getOffense() + 5);
                		selectedPlayer.setOverall(selectedPlayer.getFitness(),selectedPlayer.getDefense(),selectedPlayer.getOffense());
                	} else if (selectedItem.getName() == "Dumbbels") {
                		System.out.println(selectedPlayer.getDefense());
                		selectedPlayer.setDefense(selectedPlayer.getDefense() + 5);
                		selectedPlayer.setOverall(selectedPlayer.getFitness(),selectedPlayer.getDefense(),selectedPlayer.getOffense());
                		System.out.println(selectedPlayer.getDefense());
                	} else if (selectedItem.getName() == "Energy Drink") {
                		selectedPlayer.setStamina(selectedPlayer.getStamina() + 20);
                	} else if (selectedItem.getName() == "Treadmill") {
                		selectedPlayer.setFitness(selectedPlayer.getFitness() + 5);
                		selectedPlayer.setOverall(selectedPlayer.getFitness(),selectedPlayer.getDefense(),selectedPlayer.getOffense());
                	}
                	
                	inventoryListModel.removeElement(selectedItem);
                	Team.getInventory().remove(selectedItem);
                    
                    // Clear the selections
                    inventoryList.clearSelection();
                    myPlayerList.clearSelection();
                    myReserveList.clearSelection();
                    
                    // Reset the selected players and item
                    selectedPlayer = null;
                    selectedItem = null;
                } else {
                    System.out.println("Please select a player and an item");
                }
            }
        });
        frame.getContentPane().add(useItemButton);
		
		JLabel oppTeamScore = new JLabel("0");
		oppTeamScore.setFont(new Font("Tahoma", Font.PLAIN, 25));
		oppTeamScore.setBounds(700, 108, 47, 39);
		frame.getContentPane().add(oppTeamScore);
        
		JLabel playerTeamScore = new JLabel("0");
		playerTeamScore.setFont(new Font("Tahoma", Font.PLAIN, 25));
		playerTeamScore.setBounds(571, 106, 45, 39);
		frame.getContentPane().add(playerTeamScore);
		
		JLabel timeLabel = new JLabel("Start Of First Half");
		timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timeLabel.setBounds(571, 145, 152, 26);
		frame.getContentPane().add(timeLabel);
		
		JButton btnFinishGame = new JButton("Go to recap");
		btnFinishGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchRecap();
			}
		});
		
		btnFinishGame.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFinishGame.setBounds(600, 414, 176, 39);
		frame.getContentPane().add(btnFinishGame);
		btnFinishGame.setVisible(false);
		
		JButton btnPlayNextHalf = new JButton("Sim next half");
		btnPlayNextHalf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	

				oppScore += Matchup.oppHalfScore();
				playerScore += Matchup.playerHalfScore();
				playerTeamScore.setText(String.valueOf(playerScore));
				oppTeamScore.setText(String.valueOf(oppScore));
				Matchup.nextHalf();
				
				if (Matchup.getHalf() == 1) {
					timeLabel.setText("Half-Time");
				} else if (Matchup.getHalf() == 2) {
					timeLabel.setText("End of Regulation");
					
					Matchup.setFinalScorePlayer(playerScore);
					Matchup.setFinalScoreOpp(oppScore);
					btnPlayNextHalf.setVisible(false);
					btnFinishGame.setVisible(true);
				}
				
			}
		});
		btnPlayNextHalf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPlayNextHalf.setBounds(600, 414, 176, 39);
		frame.getContentPane().add(btnPlayNextHalf);
		
		myPlayerList.addListSelectionListener(e -> {
		    selectedStarter = myPlayerList.getSelectedValue();
		});

		myReserveList.addListSelectionListener(e -> {
		    selectedReserve = myReserveList.getSelectedValue();
		});
		
		JLabel swapErrorLabel = new JLabel("");
		swapErrorLabel.setForeground(new Color(255, 0, 0));
		swapErrorLabel.setBounds(10, 368, 293, 13);
		frame.getContentPane().add(swapErrorLabel);
		
		JButton btnSwapPlayers = new JButton("Sub Player");
		btnSwapPlayers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSwapPlayers.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			    if (selectedStarter != null && selectedReserve != null) {
			        // Swap the players between the lists
			    	swapErrorLabel.setText("");
			    	Team.startingFive.add(selectedReserve);
			        myTeamListModel.addElement(selectedReserve);
			        
			        Team.benchFive.add(selectedStarter);
			        myReservesListModel.addElement(selectedStarter);
			        
			        Team.startingFive.remove(selectedReserve);
			        myTeamListModel.removeElement(selectedStarter);
			        Team.benchFive.remove(selectedStarter);
			        myReservesListModel.removeElement(selectedReserve);
			        
			        // Clear the selections
			        myPlayerList.clearSelection();
			        myReserveList.clearSelection();
			        
			        // Reset the selected players
			        selectedStarter = null;
			        selectedReserve = null;
			    } else {
			    	swapErrorLabel.setText("Please select a player from each squad to swap");
			    }
		    }
		});
		btnSwapPlayers.setBounds(21, 414, 110, 39);
		frame.getContentPane().add(btnSwapPlayers);
		
		JLabel playerTeamScore_1 = new JLabel("-");
		playerTeamScore_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		playerTeamScore_1.setBounds(634, 104, 23, 39);
		frame.getContentPane().add(playerTeamScore_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Injuries");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(360, 227, 86, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JList<Athlete> injuriesList = new JList<Athlete>(myTeamInjuries);
		injuriesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		injuriesList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		injuriesList.setBounds(370, 257, 330, 147);
		frame.getContentPane().add(injuriesList);
		


		}
	}
