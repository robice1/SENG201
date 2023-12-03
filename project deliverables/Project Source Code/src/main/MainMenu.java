package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame MainFrame;
	private static WindowManager manager;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu(manager);
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu(WindowManager incomingManager) {
		manager = incomingManager;
		initialize();
		MainFrame.setVisible(true);
	}
	
	public void closeWindow() {
		MainFrame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeMainScreen(this);
		MainFrame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainFrame = new JFrame();
		MainFrame.setTitle("Basketball simulator");
		MainFrame.setBounds(100, 100, 800, 500);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);
		
		JButton PlayButton = new JButton("Play");
		PlayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team.setPicks(10);
				finishedWindow();
			}
		});
		PlayButton.setFont(new Font("Octuple max", Font.PLAIN, 20));
		PlayButton.setBounds(23, 244, 220, 87);
		MainFrame.getContentPane().add(PlayButton);
		
		JButton ExitButton = new JButton("Exit!");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		ExitButton.setFont(new Font("Octuple max", Font.PLAIN, 20));
		ExitButton.setBounds(23, 348, 220, 87);
		MainFrame.getContentPane().add(ExitButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/images/mainLogo.png")));
		lblNewLabel.setBounds(407, 46, 290, 389);
		MainFrame.getContentPane().add(lblNewLabel);
	}
}
