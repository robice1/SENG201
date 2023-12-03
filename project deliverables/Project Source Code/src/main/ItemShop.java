package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ItemShop {

	
	private static WindowManager manager;
	private JFrame frame;
	private static ArrayList<Item> inventory;
	private int money;
	private int treadmillPrice;
	private int panadolPrice;
	private int jumpRopePrice;
	private int energyDrinkPrice;
	private int dumbbellPrice;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemShop window = new ItemShop();
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
	public ItemShop(WindowManager incomingManager) {

		manager = incomingManager;
		// Initialize the inventory
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
		money = Money.getMoney();
		frame = new JFrame();
		
		treadmillPrice = Treadmill.getPrice();
		panadolPrice = Panadol.getPrice();
		jumpRopePrice = JumpRope.getPrice();
		dumbbellPrice = Dumbbells.getPrice();
		energyDrinkPrice = EnergyDrink.getPrice();
		
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item Shop");
		lblNewLabel.setBounds(142, 10, 166, 49);
		lblNewLabel.setFont(new Font("Octuple max", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel moneyLbl = new JLabel("Money: $" + Money.getMoney());
		moneyLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		moneyLbl.setBounds(347, 15, 144, 37);
		frame.getContentPane().add(moneyLbl);
		
		JPanel panadolPanel = new JPanel();
		panadolPanel.setBackground(new Color(128, 128, 128));
		panadolPanel.setBounds(20, 56, 244, 173);
		frame.getContentPane().add(panadolPanel);
		panadolPanel.setLayout(null);
		
		JLabel panadolLabel = new JLabel("Panadol");
		panadolLabel.setFont(new Font("Octuple max", Font.PLAIN, 15));
		panadolLabel.setBounds(10, 10, 118, 26);
		panadolPanel.add(panadolLabel);
		
		JLabel priceLabel = new JLabel("Price: $" + panadolPrice);
        priceLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
        priceLabel.setBounds(10, 46, 100, 13);
        panadolPanel.add(priceLabel);
		
        JLabel descriptionLabel = new JLabel("Makes an injured athlete healthy again.");
        descriptionLabel.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
        descriptionLabel.setBounds(10, 69, 225, 52);
        panadolPanel.add(descriptionLabel);
        
        JButton buyButton = new JButton("Buy");
        buyButton.setFont(new Font("Octuple max", Font.PLAIN, 15));
        buyButton.setBounds(10, 131, 117, 36);
        panadolPanel.add(buyButton);
        buyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (Money.getMoney() - panadolPrice >= 0) {
            		Panadol panadol = new Panadol();
                    Team.getInventory().add(panadol);
                    System.out.println("Panadol purchased and added to inventory.");
                    Money.setMoney(Money.getMoney() - panadolPrice);
                    moneyLbl.setText("Money: $" + Money.getMoney());
                    System.out.println(panadolPrice);
            	} else {
    	    		JOptionPane.showMessageDialog(frame, "Not enough money!", "Insufficient Funds", JOptionPane.WARNING_MESSAGE);
    	    	}
                
            }
        });
        
		JButton btnBackBtn = new JButton("< Back");
		btnBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchMainMenu();
			}
		});
		btnBackBtn.setFont(new Font("Octuple max", Font.PLAIN, 15));
		btnBackBtn.setBounds(10, 10, 117, 36);
		frame.getContentPane().add(btnBackBtn);
		
		JPanel jumpRopePanel = new JPanel();
        jumpRopePanel.setBackground(new Color(128, 128, 128));
        jumpRopePanel.setBounds(532, 56, 244, 173);
        frame.getContentPane().add(jumpRopePanel);
        jumpRopePanel.setLayout(null);

        JLabel jumpRopeLabel = new JLabel("Jump Rope");
        jumpRopeLabel.setFont(new Font("Octuple max", Font.PLAIN, 15));
        jumpRopeLabel.setBounds(10, 10, 132, 26);
        jumpRopePanel.add(jumpRopeLabel);
        
        JLabel jumpRopePriceLabel = new JLabel("Price: $" + jumpRopePrice);
        jumpRopePriceLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
        jumpRopePriceLabel.setBounds(10, 46, 100, 13);
        jumpRopePanel.add(jumpRopePriceLabel);

        JLabel jumpRopeDescriptionLabel = new JLabel("Adds 5 to an athlete's offensive stat.");
        jumpRopeDescriptionLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
        jumpRopeDescriptionLabel.setBounds(10, 69, 224, 52);
        jumpRopePanel.add(jumpRopeDescriptionLabel);

        JButton buyJumpRopeButton = new JButton("Buy");
        buyJumpRopeButton.setFont(new Font("Octuple max", Font.PLAIN, 15));
        buyJumpRopeButton.setBounds(10, 131, 117, 36);
        jumpRopePanel.add(buyJumpRopeButton);
        buyJumpRopeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (Money.getMoney() - jumpRopePrice >= 0) {
            		JumpRope jumpRope = new JumpRope();
            		Team.getInventory().add(jumpRope);
                    System.out.println("Jump Rope purchased and added to inventory.");
                    Money.setMoney(Money.getMoney() - jumpRopePrice);
                    moneyLbl.setText("Money: $" + Money.getMoney());
            		
            	}   else {
    	    		JOptionPane.showMessageDialog(frame, "Not enough money!", "Insufficient Funds", JOptionPane.WARNING_MESSAGE);
    	    	}
            }
        });


	JPanel treadmillPanel = new JPanel();
	treadmillPanel.setBackground(new Color(128, 128, 128));
	treadmillPanel.setBounds(274, 56, 248, 173);
	frame.getContentPane().add(treadmillPanel);
	treadmillPanel.setLayout(null);
	
	JLabel treadmillLabel = new JLabel("Treadmill");
	treadmillLabel.setFont(new Font("Octuple max", Font.PLAIN, 15));
	treadmillLabel.setBounds(10, 10, 118, 26);
	treadmillPanel.add(treadmillLabel);
	
	JLabel treadmillPriceLabel = new JLabel("Price: $" + treadmillPrice);
	treadmillPriceLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
	treadmillPriceLabel.setBounds(10, 46, 100, 13);
	treadmillPanel.add(treadmillPriceLabel);
	
	JLabel treadmillDescriptionLabel = new JLabel("Adds 5 to an athlete's fitness stat.");
	treadmillDescriptionLabel.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
	treadmillDescriptionLabel.setBounds(10, 69, 228, 52);
	treadmillPanel.add(treadmillDescriptionLabel);
	
	
	
	JButton treadmillBuyButton = new JButton("Buy");
	treadmillBuyButton.setFont(new Font("Octuple max", Font.PLAIN, 15));
	treadmillBuyButton.setBounds(10, 131, 117, 36);
	treadmillPanel.add(treadmillBuyButton);
	
	JPanel panadolPanel_1 = new JPanel();
	panadolPanel_1.setLayout(null);
	panadolPanel_1.setBackground(Color.GRAY);
	panadolPanel_1.setBounds(20, 255, 244, 173);
	frame.getContentPane().add(panadolPanel_1);
	
	JLabel lblEnergyDrink = new JLabel("Energy Drink");
	lblEnergyDrink.setFont(new Font("Octuple max", Font.PLAIN, 15));
	lblEnergyDrink.setBounds(10, 10, 187, 26);
	panadolPanel_1.add(lblEnergyDrink);
	
	JLabel priceLabel_1 = new JLabel("Price: $" + EnergyDrink.getPrice());
	priceLabel_1.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
	priceLabel_1.setBounds(10, 46, 100, 13);
	panadolPanel_1.add(priceLabel_1);
	
	JLabel lblAddsTo = new JLabel("Adds 20 to a players stamina stat.");
	lblAddsTo.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
	lblAddsTo.setBounds(10, 69, 225, 52);
	panadolPanel_1.add(lblAddsTo);
	
	JButton nrgDrnkBuyBtn = new JButton("Buy");
	nrgDrnkBuyBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	    	if (Money.getMoney() - energyDrinkPrice >= 0) {
		        EnergyDrink drink = new EnergyDrink();
		        Team.getInventory().add(drink);
	            Money.setMoney(Money.getMoney() - energyDrinkPrice);
	            moneyLbl.setText("Money: $" + Money.getMoney());
	    	} else {
	    		JOptionPane.showMessageDialog(frame, "Not enough money!", "Insufficient Funds", JOptionPane.WARNING_MESSAGE);
	    	}
		}
	});
	nrgDrnkBuyBtn.setFont(new Font("Octuple max", Font.PLAIN, 15));
	nrgDrnkBuyBtn.setBounds(10, 131, 117, 36);
	panadolPanel_1.add(nrgDrnkBuyBtn);
	
	JPanel dumbbellsPanel = new JPanel();
	dumbbellsPanel.setLayout(null);
	dumbbellsPanel.setBackground(Color.GRAY);
	dumbbellsPanel.setBounds(274, 255, 248, 173);
	frame.getContentPane().add(dumbbellsPanel);
	
	JLabel lblDumbbells = new JLabel("Dumbbells");
	lblDumbbells.setFont(new Font("Octuple max", Font.PLAIN, 15));
	lblDumbbells.setBounds(10, 10, 118, 26);
	dumbbellsPanel.add(lblDumbbells);
	
	JLabel treadmillPriceLabel_1 = new JLabel("Price: $" + Dumbbells.getPrice());
	treadmillPriceLabel_1.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
	treadmillPriceLabel_1.setBounds(10, 46, 100, 13);
	dumbbellsPanel.add(treadmillPriceLabel_1);
	
	JLabel lblAddsTo_1 = new JLabel("Adds 5 to an athletes defensive stat.");
	lblAddsTo_1.setFont(new Font("Myanmar Text", Font.PLAIN, 12));
	lblAddsTo_1.setBounds(10, 69, 228, 52);
	dumbbellsPanel.add(lblAddsTo_1);
	
	JButton DmblsBuyBtn = new JButton("Buy");
	DmblsBuyBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	    	if (Money.getMoney() - dumbbellPrice >= 0) {
		        Dumbbells dumbbell = new Dumbbells();
		        Team.getInventory().add(dumbbell);
		        System.out.println("Dumbbell purchased and added to inventory.");
	            Money.setMoney(Money.getMoney() - dumbbellPrice);
	            moneyLbl.setText("Money: $" + Money.getMoney());
	    	} else {
	    		JOptionPane.showMessageDialog(frame, "Not enough money!", "Insufficient Funds", JOptionPane.WARNING_MESSAGE);
	    	}
		}
	});
	DmblsBuyBtn.setFont(new Font("Octuple max", Font.PLAIN, 15));
	DmblsBuyBtn.setBounds(10, 131, 117, 36);
	dumbbellsPanel.add(DmblsBuyBtn);
	
	
	treadmillBuyButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	if (Money.getMoney() - treadmillPrice >= 0) {
		        Treadmill treadmill = new Treadmill();
		        Team.getInventory().add(treadmill);
		        System.out.println("Treadmill purchased and added to inventory.");
	            Money.setMoney(Money.getMoney() - treadmillPrice);
	            moneyLbl.setText("Money: $" + Money.getMoney());
	    	} else {
	    		JOptionPane.showMessageDialog(frame, "Not enough money!", "Insufficient Funds", JOptionPane.WARNING_MESSAGE);
	    	}

	    }
	});
		
		
	}
    
}
