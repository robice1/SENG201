package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeasonEnd {

	private JFrame frame;
	private static WindowManager manager;

	/**
	 * Launch the application.
	 */
	public void backToMain() {
		manager.launchMain();
		frame.dispose();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeasonEnd window = new SeasonEnd();
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
	public SeasonEnd(WindowManager incomingManager) {
		
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("End Of Season");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(295, 28, 278, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel finalPointsLbl = new JLabel("Season Points: " + Team.getPoints());
		finalPointsLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		finalPointsLbl.setHorizontalAlignment(SwingConstants.LEFT);
		finalPointsLbl.setBounds(75, 150, 144, 51);
		frame.getContentPane().add(finalPointsLbl);
		
		JButton btnNewButton = new JButton("Back to Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FreeAgents.clearFreeAgents();
				Team.clearTeam();
				backToMain();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(226, 325, 264, 44);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblTeam = new JLabel("Team Rating: " + Team.getTeamRating());
		lblTeam.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTeam.setBounds(75, 211, 144, 51);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblWins = new JLabel("Wins: " + Team.getWins());
		lblWins.setHorizontalAlignment(SwingConstants.LEFT);
		lblWins.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWins.setBounds(75, 267, 144, 51);
		frame.getContentPane().add(lblWins);
	}
}
