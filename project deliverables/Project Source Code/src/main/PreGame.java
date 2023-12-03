package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PreGame {

	private JFrame frmPregame;
	private static WindowManager manager;
	private static int selectedDiff;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreGame window = new PreGame();
					window.frmPregame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PreGame(WindowManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmPregame.setVisible(true);
	}
	
	public void launchMainMenu() {
		manager.launchMainMenu();
		frmPregame.dispose();
	}
	
	public void launchGameWindow() {
		manager.openGameWindow();
		frmPregame.dispose();
	}
	
	public static void setDiff(int newDiff) {
		selectedDiff = newDiff;
	}
	public static int getDiff() {
		return selectedDiff;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		selectedDiff = 5;
		Matchup.setFinalScoreOpp(0);
		Matchup.setFinalScorePlayer(0);
		frmPregame = new JFrame();
		frmPregame.setFont(new Font("VELOCISTA", Font.PLAIN, 12));
		frmPregame.setTitle("Pregame");
		frmPregame.setBounds(100, 100, 800, 500);
		frmPregame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPregame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose Opposition");
		lblNewLabel.setFont(new Font("Octuple max", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 76, 308, 42);
		frmPregame.getContentPane().add(lblNewLabel);
		
		JLabel selDiffLabel = new JLabel("Selected Difficulty:");
		selDiffLabel.setFont(new Font("Octuple max", Font.PLAIN, 15));
		selDiffLabel.setBounds(24, 374, 350, 48);
		frmPregame.getContentPane().add(selDiffLabel);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selDiffLabel.setText("Selected Difficulty: Easy");
				setDiff(-1);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(24, 140, 250, 35);
		frmPregame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Rewards: 3pts, $100000");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(298, 144, 270, 26);
		frmPregame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Rewards: 5pts, $125000");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(298, 229, 270, 26);
		frmPregame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Rewards: 8pts, $150000");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(298, 317, 270, 26);
		frmPregame.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnMedium = new JButton("Medium");
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selDiffLabel.setText("Selected Difficulty: Medium");
				setDiff(0);
			}
		});
		btnMedium.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMedium.setBounds(24, 225, 250, 35);
		frmPregame.getContentPane().add(btnMedium);
		
		JButton btnHard = new JButton("Hard");
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selDiffLabel.setText("Selected Difficulty: Hard");
				setDiff(1);
			}
		});
		btnHard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHard.setBounds(24, 313, 250, 35);
		frmPregame.getContentPane().add(btnHard);
		
		JButton btnNewButton_2 = new JButton("< Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchMainMenu();
			}
		});
		btnNewButton_2.setFont(new Font("Octuple max", Font.PLAIN, 20));
		btnNewButton_2.setBounds(10, 10, 200, 56);
		frmPregame.getContentPane().add(btnNewButton_2);
		
		JLabel lblPleaseSelectA = new JLabel();
		lblPleaseSelectA.setForeground(new Color(255, 0, 0));
		lblPleaseSelectA.setFont(new Font("Octuple max", Font.PLAIN, 15));
		lblPleaseSelectA.setBounds(497, 353, 279, 48);
		frmPregame.getContentPane().add(lblPleaseSelectA);
		
		JButton btnNewButton_2_1 = new JButton("Continue >");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedDiff != 5) {
					Player.incrementWeek();
					Matchup.setPlayerScore(0);
					Matchup.setOppScore(0);
					launchGameWindow();
				} else {
					lblPleaseSelectA.setText("Please select a difficulty");
				}

			}
		});
		btnNewButton_2_1.setFont(new Font("Octuple max", Font.PLAIN, 20));
		btnNewButton_2_1.setBounds(576, 397, 200, 56);
		frmPregame.getContentPane().add(btnNewButton_2_1);
		

		

	}

}
