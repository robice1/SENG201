package main;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.List;




public class DraftScreen {

	private ArrayList<Athlete> freeAgentsList = new ArrayList<>();
	
	public DefaultListModel<Athlete> myTeamListModel = new DefaultListModel<>();
	private JFrame frame;
	public int teamRating;
	private static WindowManager manager;
	private int money;

	/**
	 * Launch the application.
	 * @return 
	 */

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DraftScreen window = new DraftScreen();
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
	public DraftScreen(WindowManager incomingManager) {
		money = Money.getMoney();
        
		// We have some list of items already
		manager = incomingManager;
		
		initialize();
		frame.setVisible(true);
	}
	

	public void launchMainMenu() {
		manager.launchMainMenu();
		frame.dispose();
	}
	
	public void closeWindow() {
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		freeAgentsList = FreeAgents.getFreeAgents();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		JLabel lblNewLabel = new JLabel("Avaliable Players");
		lblNewLabel.setFont(new Font("Octuple max", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 102, 205, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMyTeam = new JLabel("My Team");
		lblMyTeam.setFont(new Font("Octuple max", Font.PLAIN, 15));
		lblMyTeam.setBounds(307, 102, 205, 24);
		frame.getContentPane().add(lblMyTeam);
		
		JLabel playerNumWarning = new JLabel("");
		playerNumWarning.setForeground(new Color(255, 0, 0));
		playerNumWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		playerNumWarning.setBounds(559, 354, 217, 24);
		frame.getContentPane().add(playerNumWarning);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Team.playerTeam.getNumPlayers() < 5) {
					playerNumWarning.setText("Please select at least 5 players for your team");
				} else {
					for(Athlete player : Team.playerTeam.getPlayers()) {
						if (!Team.getAllPlayers().contains(player)) {
							Team.getAllPlayers().add(player);
						}
					}
					launchMainMenu();
				}	
			}
		});
		btnNewButton.setFont(new Font("Octuple max", Font.PLAIN, 15));
		btnNewButton.setBounds(559, 394, 217, 46);
		frame.getContentPane().add(btnNewButton);
		
		JLabel MoneyLabel = new JLabel("Money: $" + money);
		MoneyLabel.setBackground(new Color(0, 128, 64));
		MoneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MoneyLabel.setBounds(144, 10, 165, 24);
		frame.getContentPane().add(MoneyLabel);
		
		JLabel PicksLabel = new JLabel("Team size: " + Team.playerTeam.getNumPlayers());
		PicksLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PicksLabel.setBounds(336, 10, 165, 24);
		frame.getContentPane().add(PicksLabel);
		
		JLabel RatingLabel = new JLabel("My Team Rating: " + teamRating);
		RatingLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RatingLabel.setBounds(511, 10, 165, 24);
		frame.getContentPane().add(RatingLabel);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
		// Add the existing items to the ListModel

		// Create the actual JList, notice that we put the athleteListModel in as an argument to new JList
		JList<Athlete> freeAgentListGUI = new JList<>(athleteListModel);
		freeAgentListGUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(freeAgentListGUI);
		
		scrollPane.setBounds(22, 132, 225, 308);
		frame.getContentPane().add(scrollPane);

		DefaultListModel<Athlete> myTeamListModel = new DefaultListModel<>();
		JList<Athlete> myTeamListGUI = new JList<>(myTeamListModel);

		ScrollPane myTeamScrollPane = new ScrollPane();
		myTeamScrollPane.add(myTeamListGUI);
		myTeamScrollPane.setBounds(303, 132, 225, 308); 
		frame.getContentPane().add(myTeamScrollPane);

		// Update myTeamListGUI with the elements from the myTeam ArrayList
		for (Athlete player : Team.getAllPlayers()) {
		    myTeamListModel.addElement(player);
		}
		
		athleteListModel.addAll(freeAgentsList);
		freeAgentListGUI.addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        // Get the selected player from the JList
		        Athlete selectedPlayer = freeAgentListGUI.getSelectedValue();
		        
		        // Add the selected player to the ArrayList if it's not null
		        if (selectedPlayer != null && selectedPlayer.getPrice() <= money) {
		        	
		        	Team.playerTeam.addPlayer(selectedPlayer);  
		            freeAgentsList.remove(selectedPlayer);
		            
		            athleteListModel.removeElement(selectedPlayer);
		            myTeamListModel.addElement(selectedPlayer);
		            
		            //Update money
		            Money.setMoney(money - selectedPlayer.getPrice());
		            money = Money.getMoney();
		            MoneyLabel.setText("Money $" + String.valueOf(money));
		            
		            //Update total picks
		            
		            PicksLabel.setText("Remaining Picks: " + String.valueOf(Team.playerTeam.getNumPlayers()));

		            teamRating = Team.getTeamRating();
		            RatingLabel.setText("Team Rating: " + String.valueOf(teamRating));
		            
		        }
		    }
		});
		
		myTeamListGUI.addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        // Get the selected player from the JList
		        Athlete selectedPlayerMyTeam = myTeamListGUI.getSelectedValue();
		        
		        // remove the selected player to the ArrayList if it's not null
		        if (selectedPlayerMyTeam != null) {
		        	Team.playerTeam.removePlayer(selectedPlayerMyTeam);
		            
		            myTeamListModel.removeElement(selectedPlayerMyTeam);
		            athleteListModel.addElement(selectedPlayerMyTeam);
		            System.out.println("Selected player: " + selectedPlayerMyTeam.getName());
		            
		            Money.setMoney(money + selectedPlayerMyTeam.getPrice());
		            money = Money.getMoney();
		            MoneyLabel.setText("Money $" + String.valueOf(money));
		            PicksLabel.setText("Team Size: " + String.valueOf(Team.playerTeam.getNumPlayers()));
		            teamRating = Team.getTeamRating();
		            RatingLabel.setText("Team Rating: " + String.valueOf(teamRating));
		            
		        }
		    }
		});
		
		
		freeAgentListGUI.getSelectedValue();
		
		
		
	}
}


