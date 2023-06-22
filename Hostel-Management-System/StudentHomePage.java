import java.awt.*;
import java.awt.event.*;
//import java.sql.SQLException;
import javax.swing.*;

public class StudentHomePage extends JFrame implements ActionListener{

	private JPanel contentPane, deckPanel, complainPanel, mealPanel, menuPanel;
	private JLabel welcomeLbl;
	private JButton mealInfoBtn, complainInfoBtn;
//	private ConnectDatabase database;
	private CardLayout cardLT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHomePage frame = new StudentHomePage("D181904337");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public StudentHomePage(String id) {// throws SQLException {
//		database = new ConnectDatabase(id);
		String studName  = "Soumen Mahata";//database.getStudentName();
		
		setTitle(studName+"'s Home");
//		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 780);
		setLocationRelativeTo(null);
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		setIconImage(new ImageIcon(getClass().getResource("images/appLogo.png")).getImage());
		
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.decode("#9955ff"));
		menuPanel.setPreferredSize(new Dimension(333,400));
		contentPane.add(menuPanel, BorderLayout.WEST);
		menuPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello,");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.decode("#ebddff"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 333, 60);
		menuPanel.add(lblNewLabel);
		
		welcomeLbl = new JLabel(studName);
		welcomeLbl.setBounds(0, 50, 333, 60);
		welcomeLbl.setForeground(Color.decode("#ebddff"));
		menuPanel.add(welcomeLbl);
		welcomeLbl.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		mealInfoBtn = new JButton("Meal Information");
		mealInfoBtn.setHorizontalAlignment(SwingConstants.LEFT);
		mealInfoBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		mealInfoBtn.setBackground(Color.white);
		mealInfoBtn.setBounds(75, 137, 277, 55);
		mealInfoBtn.setFocusable(false);
		mealInfoBtn.setBorderPainted(false);
		//mealInfoBtn.setContentAreaFilled(false);
		//mealInfoBtn.setIcon(new ImageIcon(getClass().getResource("images/mealInfo.png")));
		
		mealInfoBtn.addActionListener(this);
		menuPanel.add(mealInfoBtn);
		
		complainInfoBtn = new JButton("Send Complain");
		complainInfoBtn.setHorizontalAlignment(SwingConstants.LEFT);
		complainInfoBtn.setVerticalAlignment(SwingConstants.CENTER);
		complainInfoBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		complainInfoBtn.setBounds(75, 202, 277, 55);
		complainInfoBtn.setFocusable(false);
		complainInfoBtn.setBorderPainted(false);
		complainInfoBtn.setContentAreaFilled(false);
		complainInfoBtn.setForeground(Color.WHITE);//decode("#e5d5ff"));
		complainInfoBtn.addActionListener(this);
		menuPanel.add(complainInfoBtn);
		
		cardLT = new CardLayout();
		
		deckPanel = new JPanel();
		contentPane.add(deckPanel, BorderLayout.CENTER);
		deckPanel.setLayout(cardLT);
		
		mealPanel = new StudentMealPanel(id);
		deckPanel.add(mealPanel, "mealP");
		
		complainPanel = new StudentComplainSendPanel(id);
		deckPanel.add(complainPanel, "complainP");
		
//		database.closeConnection();
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mealInfoBtn) {
			repaint();
			mealInfoBtn.setContentAreaFilled(true);
			mealInfoBtn.setBackground(Color.WHITE);
			mealInfoBtn.setForeground(Color.BLACK);
			complainInfoBtn.setContentAreaFilled(false);
			complainInfoBtn.setForeground(Color.decode("#e5d5ff"));
			cardLT.show(deckPanel, "mealP");
		}
		if(ae.getSource()==complainInfoBtn) { 
			repaint();
			complainInfoBtn.setContentAreaFilled(true);
			complainInfoBtn.setBackground(Color.white);
			complainInfoBtn.setForeground(Color.BLACK);
			mealInfoBtn.setContentAreaFilled(false);
			mealInfoBtn.setForeground(Color.decode("#e5d5ff"));
			cardLT.show(deckPanel, "complainP");}
	}
}
