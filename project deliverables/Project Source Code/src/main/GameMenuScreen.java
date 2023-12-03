package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JTabbedPane;

public class GameMenuScreen {

	private static JFrame frmGameMenu;
	private static WindowManager manager;
    private Athlete selectedStarter;
    private Athlete selectedReserve;
    private Athlete selectedInjured;
    private ScrollPane scrollPane;
    private Athlete selectedForUse;
    
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMenuScreen window = new GameMenuScreen();
					window.getFrmGameMenu().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public GameMenuScreen(WindowManager incomingManager) {
		
		manager = incomingManager;	
		initialize();
		getFrmGameMenu().setVisible(true);
	}
	
	public static JFrame getFrmGameMenu() {
		return frmGameMenu;
	}


	public void setFrmGameMenu(JFrame frmGameMenu) {
		this.frmGameMenu = frmGameMenu;
	}

	public void continueToDraft() {
		manager.launchDraft();
		getFrmGameMenu().dispose();
	}
	
	public void launchItemShop() {
		manager.launchItemShop();
		getFrmGameMenu().dispose();
	}
	
	public void launchPreGame() {
		manager.launchPreGame();
		getFrmGameMenu().dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		Team.teamInjuries();
		setFrmGameMenu(new JFrame());
		getFrmGameMenu().setTitle("Locker Menu");
		getFrmGameMenu().setBounds(100, 100, 800, 500);
		getFrmGameMenu().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmGameMenu().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(SetupWindow.teamName + "'s Locker");
		lblNewLabel.setFont(new Font("Octuple max", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 766, 54);
		getFrmGameMenu().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("My Starters:");
		lblNewLabel_1.setFont(new Font("Octuple max", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 57, 163, 39);
		getFrmGameMenu().getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Injuries:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(507, 116, 123, 20);
		getFrmGameMenu().getContentPane().add(lblNewLabel_3);
		
		
        DefaultListModel<Athlete> myTeamInjuries = new DefaultListModel<>();
		DefaultListModel<Athlete> myTeamListModel = new DefaultListModel<>();
		DefaultListModel<Athlete> myReservesListModel = new DefaultListModel<>();
		
		for (Athlete player : Team.injuredPlayers) {
			myTeamInjuries.addElement(player);
		}
		for (Athlete player : Team.playerTeam.getPlayers()) {
			if (myTeamListModel.size() <= 4) {
				myTeamListModel.addElement(player);
				Team.startingFive.add(player);
			} else {
				myReservesListModel.addElement(player);
				Team.benchFive.add(player);
			}
		}
		
		JList<Athlete> myPlayerList = new JList<>(myTeamListModel);
		myPlayerList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		myPlayerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myPlayerList.setBounds(10, 97, 335, 110);
		getFrmGameMenu().getContentPane().add(myPlayerList);
		
		JLabel lblNewLabel_2 = new JLabel("Team Rating: " + Team.getTeamRating() );
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 422, 134, 41);
		getFrmGameMenu().getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Buy and sell players");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continueToDraft();
			}
		});

		btnNewButton.setBounds(10, 391, 163, 32);
		getFrmGameMenu().getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Money: $" + Money.getMoney());
		lblNewLabel_2_1.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(146, 422, 134, 41);
		getFrmGameMenu().getContentPane().add(lblNewLabel_2_1);
		
		JList<Athlete> myReserves = new JList<Athlete>(myReservesListModel);
		myReserves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myReserves.setFont(new Font("Tahoma", Font.PLAIN, 13));
		myReserves.setBounds(10, 248, 335, 110);
		getFrmGameMenu().getContentPane().add(myReserves);
		
		JList<Athlete> injuriesList = new JList<Athlete>(myTeamInjuries);
		injuriesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		injuriesList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		injuriesList.setBounds(507, 146, 269, 251);
		getFrmGameMenu().getContentPane().add(injuriesList);
		
		JLabel lblNewLabel_1_2 = new JLabel("My Bench:");
		lblNewLabel_1_2.setFont(new Font("Octuple max", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(20, 210, 163, 39);
		getFrmGameMenu().getContentPane().add(lblNewLabel_1_2);
		
		myPlayerList.addListSelectionListener(e -> {
		    selectedStarter = myPlayerList.getSelectedValue();
		    selectedForUse = myPlayerList.getSelectedValue();
		});

		myReserves.addListSelectionListener(e -> {
		    selectedReserve = myReserves.getSelectedValue();
		    selectedForUse = myReserves.getSelectedValue();
		});
		
		injuriesList.addListSelectionListener(e -> {
			selectedForUse = injuriesList.getSelectedValue();
		});
		
		JLabel swapErrorLabel = new JLabel("");
		swapErrorLabel.setForeground(new Color(255, 0, 0));
		swapErrorLabel.setBounds(10, 368, 293, 13);
		getFrmGameMenu().getContentPane().add(swapErrorLabel);
		
		JButton btnSwapPlayers = new JButton("Swap Players");
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
			        myReserves.clearSelection();
			        
			        // Reset the selected players
			        selectedStarter = null;
			        selectedReserve = null;
			    } else {
			    	swapErrorLabel.setText("Please select a player from each squad to swap");
			    }
		    }
		});
		
		btnSwapPlayers.setBounds(185, 391, 113, 32);
		getFrmGameMenu().getContentPane().add(btnSwapPlayers);
		
		JButton btnNewButton_1 = new JButton("Buy new items");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchItemShop();
			}
		});
		btnNewButton_1.setBounds(315, 394, 149, 27);
		getFrmGameMenu().getContentPane().add(btnNewButton_1);
		
        // Create the ScrollPane
        scrollPane = new ScrollPane();
        scrollPane.setBounds(355, 96, 149, 261);
        getFrmGameMenu().getContentPane().add(scrollPane);

        // Create a Label to display the inventory title
        JLabel inventoryLabel = new JLabel("Inventory:");
        inventoryLabel.setFont(new Font("Octuple max", Font.PLAIN, 15));
        inventoryLabel.setBounds(355, 57, 163, 39);
        getFrmGameMenu().getContentPane().add(inventoryLabel);
        
        // Create a JList to display the inventory items
        DefaultListModel<Purchasable> inventoryListModel = new DefaultListModel<>();
        JList<Purchasable> inventoryList = new JList<>(inventoryListModel);
        inventoryList.setFont(new Font("Tahoma", Font.PLAIN, 13));
        inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.add(inventoryList);
        
        ArrayList<Item> inventoryItems = Team.getInventory();
        if (inventoryItems != null) {
        	for (Purchasable item : inventoryItems) {
                inventoryListModel.addElement(item);
            }
        }
        
        JButton useItemButton = new JButton("Use Item");
        useItemButton.setBounds(315, 362, 149, 27);
        useItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //useSelectedItem();
                //Athlete selectedPlayer = myPlayerList.getSelectedValue();
                
                Purchasable selectedItem = inventoryList.getSelectedValue();

                if (selectedForUse != null && selectedItem != null) {

                	if(selectedItem.getName() == "Panadol") {
                	} else if (selectedItem.getName() == "Panadol") {
                		selectedForUse.setInjured(false);
                	} else if (selectedItem.getName() == "Jump Rope") {
                		selectedForUse.setOffense(selectedForUse.getOffense() + 5);
                		selectedForUse.setOverall(selectedForUse.getFitness(),selectedForUse.getDefense(),selectedForUse.getOffense());
                	} else if (selectedItem.getName() == "Dumbbels") {
                		selectedForUse.setDefense(selectedForUse.getDefense() + 5);
                		selectedForUse.setOverall(selectedForUse.getFitness(),selectedForUse.getDefense(),selectedForUse.getOffense());
                	} else if (selectedItem.getName() == "Energy Drink") {
                		selectedForUse.setStamina(selectedForUse.getStamina() + 20);
                	} else if (selectedItem.getName() == "Treadmill") {
                		selectedForUse.setFitness(selectedForUse.getFitness() + 5);
                		selectedForUse.setOverall(selectedForUse.getFitness(),selectedForUse.getDefense(),selectedForUse.getOffense());
                	}
                	
                	inventoryListModel.removeElement(selectedItem);
                	Team.getInventory().remove(selectedItem);
                    
                    inventoryList.clearSelection();
                    myPlayerList.clearSelection();
                    myReserves.clearSelection();
                    
                    selectedForUse = null;
                    selectedItem = null;
                    
                    Team.getTeamRating();
                } else {
                    System.out.println("Please select a player and an item" + selectedForUse);
                }
            }
        });
        getFrmGameMenu().getContentPane().add(useItemButton);
        
        JButton btnNewButton_3 = new JButton("Play next game");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CheckTeam.checkTeam();
        		if (CheckTeam.checkTeam()) {
            		launchPreGame();
        		}
        	}
        });
        btnNewButton_3.setFont(new Font("Octuple max", Font.PLAIN, 15));
        btnNewButton_3.setBounds(507, 406, 269, 47);
        getFrmGameMenu().getContentPane().add(btnNewButton_3);
        
        JLabel seasonPointsLbl = new JLabel("Season Points:" + Team.getPoints());
        seasonPointsLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
        seasonPointsLbl.setBounds(537, 54, 123, 20);
        getFrmGameMenu().getContentPane().add(seasonPointsLbl);
        
        JLabel lblWeek = new JLabel("Week: " + Team.getWeek());
        lblWeek.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
        lblWeek.setBounds(539, 84, 123, 20);
        getFrmGameMenu().getContentPane().add(lblWeek);
		}



	
}
