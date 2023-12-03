package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;


public class SetupWindow {
	public static String teamName;
	private JFrame setupFrame;
	private JTextField nameField;
	private static WindowManager manager;
	private boolean nameCheck;
	public static String difficulty;
	public boolean diffCheck;
	public String nameLbl;
	JLabel teamNameLbl = new JLabel("Team Name: ");
	private int money;
	private int remPicks;
	private ArrayList<Item> inventory;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupWindow window = new SetupWindow(null);
					window.setupFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupWindow(WindowManager incomingManager) {
		manager = incomingManager;
		initialize();
		setupFrame.setVisible(true);
	}
	
	public void closeWindow() {
		setupFrame.dispose();
	}
	
	public void continueToDraft() {
		
		manager.launchDraft();
		setupFrame.dispose();
	}
	
	public static String getTeamName() {
		return teamName;
	}
	public static String getDiff() {
		return difficulty;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setupFrame = new JFrame();
		setupFrame.setBounds(100, 100, 800, 500);
		setupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupFrame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Team Name:");
		lblNewLabel.setFont(new Font("Octuple max", Font.PLAIN, 20));
		lblNewLabel.setBounds(173, 22, 307, 52);
		setupFrame.getContentPane().add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Octuple max", Font.PLAIN, 15));
		nameField.setBounds(173, 84, 417, 52);
		setupFrame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Min. 3 Characters");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(195, 146, 284, 20);
		setupFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Max. 15 Characters");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(195, 169, 284, 20);
		setupFrame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("No special characters");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(195, 192, 284, 20);
		setupFrame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel diffLabel = new JLabel("Select Diff");
		diffLabel.setForeground(new Color(255, 0, 0));
		diffLabel.setFont(new Font("Octuple max", Font.PLAIN, 20));
		diffLabel.setBounds(246, 354, 456, 52);
		setupFrame.getContentPane().add(diffLabel);
		
		
		JButton difficultyButton = new JButton("Select Difficulty");
		difficultyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] choices = {"Easy","Hard"};
				String selection = (String) JOptionPane.showInputDialog(
				                    setupFrame,
				                    "Select Difficulty",
				                    "Difficulty Selection",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    choices,
				                    null);

				// Make sure to check that the String isn't null!
				diffCheck = false;
				if (selection != null) {
					if (selection == "Easy") {
						diffLabel.setText("Easy");
						diffCheck = true;
						difficulty = "easy";
					} else if (selection == "Hard") {
						diffCheck = true;
						difficulty = "hard";
						diffLabel.setText("Hard");
					}
				}
			}
		});
		
		difficultyButton.setFont(new Font("Octuple max", Font.PLAIN, 17));
		difficultyButton.setBounds(246, 280, 264, 64);
		setupFrame.getContentPane().add(difficultyButton);
		
		
		JLabel teamNameLbl = new JLabel("Team Name: ");
		teamNameLbl.setFont(new Font("Octuple max", Font.PLAIN, 15));
		teamNameLbl.setBounds(109, 222, 623, 35);
		setupFrame.getContentPane().add(teamNameLbl);
		
		JButton nameOK = new JButton("OK");
		nameOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameCheck = false;
				teamName = nameField.getText();
				if (teamName.matches(".*[^a-zA-Z0-9 ].*")) {
					teamNameLbl.setForeground(new Color(255,0,0));
					teamNameLbl.setText("Name contains special characters, please re-enter");
					nameCheck = false;
				} else if (teamName.length() < 3) {
						teamNameLbl.setForeground(new Color(255,0,0));
						teamNameLbl.setText("Too short, please re-enter");
						nameCheck = false;
				} else if (teamName.length() > 15) {
					teamNameLbl.setForeground(new Color(255,0,0));
					teamNameLbl.setText("Too long, please re-enter");
					nameCheck = false;
				} else {
					teamNameLbl.setForeground(new Color(0,0,0));
					teamNameLbl.setText("Team name: " + nameField.getText());
					Team playerTeam = new Team(null);
					playerTeam.setName(teamName);
					Player player = new Player(teamName);
					nameCheck = true;
				}	
			}
			
		});
		nameOK.setForeground(new Color(0, 128, 0));
		nameOK.setFont(new Font("Octuple max", Font.PLAIN, 15));
		nameOK.setBounds(600, 84, 93, 52);
		setupFrame.getContentPane().add(nameOK);
		
		JButton continueButton = new JButton("Continue>");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameCheck == false && diffCheck == false) {
					teamNameLbl.setForeground(new Color(255,0,0));
					diffLabel.setForeground(new Color(255,0,0));
					teamNameLbl.setText("Please choose a valid name");
					diffLabel.setText("Please select a difficulty");
				} else if (nameCheck == true && diffCheck == false) {
					diffLabel.setForeground(new Color(255,0,0));
					diffLabel.setText("Please select a difficulty");
				} else if (nameCheck == false && diffCheck == true) {
					teamNameLbl.setForeground(new Color(255,0,0));
					teamNameLbl.setText("Please choose a valid name");
				} else {
					teamNameLbl.setForeground(new Color(0,0,0));
					diffLabel.setForeground(new Color(0,0,0));
					if(difficulty == "easy") {
						Money.setMoney(4000000);
					} else {
						Money.setMoney(3250000);
					}
					
					inventory = new ArrayList<>(); 
					Team.setInventory(inventory);
					Team.week = 0;
					Team.points = 0;
					continueToDraft();
				}
				
				
			}
		});
		continueButton.setFont(new Font("Octuple max", Font.PLAIN, 15));
		continueButton.setBounds(639, 416, 137, 37);
		setupFrame.getContentPane().add(continueButton);

	}
}
