package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PostGame {
	
	private static WindowManager manager;
	private static JFrame frmPostGame;
	private int selDiff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostGame window = new PostGame();
					window.getFrmPostGame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PostGame(WindowManager incomingManager) {
		manager = incomingManager;
		initialize();
		getFrmPostGame().setVisible(true);
	}

	
	public void launchMainMenu() {
		manager.launchMainMenu();
		getFrmPostGame().dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		selDiff = PreGame.getDiff();
		setFrmPostGame(new JFrame());
		getFrmPostGame().setTitle("Post Game");
		getFrmPostGame().setBounds(100, 100, 800, 500);
		getFrmPostGame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmPostGame().getContentPane().setLayout(null);
		
		JLabel congratsLabel = new JLabel("null");
		congratsLabel.setFont(new Font("Octuple max", Font.PLAIN, 15));
		congratsLabel.setBounds(198, 22, 351, 38);
		getFrmPostGame().getContentPane().add(congratsLabel);
		
		JLabel finalScoreLbl = new JLabel("Final Score: " + Matchup.getFinalScorePlayer() + " - " + Matchup.getFinalScoreOpp());
		finalScoreLbl.setFont(new Font("Nirmala UI", Font.PLAIN, 20));
		finalScoreLbl.setBounds(301, 71, 413, 38);
		getFrmPostGame().getContentPane().add(finalScoreLbl);

		
		JButton btnNewButton = new JButton("Back To Locker");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Team.getWeek() < 15) {
					Team.incrementWeek();
					Matchup.setFinalScoreOpp(0);
					Matchup.setFinalScorePlayer(0);
					launchMainMenu();
				} else {
					manager.launchSeasonEnd();
					getFrmPostGame().dispose();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Octuple max", Font.PLAIN, 15));
		btnNewButton.setBounds(558, 399, 218, 54);
		getFrmPostGame().getContentPane().add(btnNewButton);
		
		JLabel rewardLabel = new JLabel("Rewards: ");
		rewardLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rewardLabel.setBounds(78, 151, 320, 38);
		getFrmPostGame().getContentPane().add(rewardLabel);
		
		System.out.println("Player Score: " + Matchup.getFinalScorePlayer() + "-- Opp score: " + Matchup.getFinalScoreOpp());
		
		if (Matchup.getFinalScorePlayer() > Matchup.getFinalScoreOpp()) {
			Team.incrementWins();
			congratsLabel.setText("Congrats! You won!");
			if(selDiff == -1) {
				
				Team.addPoints(3);
				Money.setMoney(Money.getMoney()+ 100000);
				rewardLabel.setText("Rewards: 3pts, $100000");
				
			} else if (selDiff == 0) {
				
				Team.addPoints(5);
				Money.setMoney(Money.getMoney()+ 125000);
				rewardLabel.setText("Rewards: 5pts, $125000");
			} else if (selDiff == 1) {
				
				Team.addPoints(8);
				Money.setMoney(Money.getMoney()+ 150000);
				rewardLabel.setText("Rewards: 8pts, $150000");
			}
		} else if (Matchup.getFinalScorePlayer() < Matchup.getFinalScoreOpp()) {
			congratsLabel.setText("We'll get 'em next time");
			if(selDiff == -1) {
				
				Team.addPoints(0);
				Money.setMoney(Money.getMoney()+ 10000);
				rewardLabel.setText("Rewards: 0pts, $10000");
			} else if (selDiff == 0) {
				
				Team.addPoints(0);
				Money.setMoney(Money.getMoney()+ 12500);
				rewardLabel.setText("Rewards: 3pts, $12500");
			} else if (selDiff == 1) {
				
				Team.addPoints(0);
				Money.setMoney(Money.getMoney()+ 15000);
				rewardLabel.setText("Rewards: 0pts, $15000");
			}
			
		} else {
			congratsLabel.setText("Draw! So close");
			if(selDiff == -1) {
				
				Team.addPoints(0);
				Money.setMoney(Money.getMoney()+ 50000);
				rewardLabel.setText("Rewards: 1pts, $50000");
			} else if (selDiff == 0) {
				
				Team.addPoints(0);
				Money.setMoney(Money.getMoney()+ 75000);
				rewardLabel.setText("Rewards: 1pts, $75000");
			} else if (selDiff == 1) {
				
				Team.addPoints(0);
				Money.setMoney(Money.getMoney()+ 100000);
				rewardLabel.setText("Rewards: 2pts, $100000");
			}
			
		}
		

	}

	public static JFrame getFrmPostGame() {
		return frmPostGame;
	}

	public void setFrmPostGame(JFrame frmPostGame) {
		this.frmPostGame = frmPostGame;
	}

}
