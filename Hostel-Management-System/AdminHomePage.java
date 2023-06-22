import java.awt.*;
import java.awt.event.*;
//import java.sql.SQLException;
import javax.swing.*;

public class AdminHomePage extends JFrame implements ActionListener{
	
//	private ConnectDatabase database;
	private JPanel deckP, contentPane, menuPanel;
	private JButton studCompBtn, updateBtn, kickBtn, mealBtn;
	private CardLayout cardLT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePage frame = new AdminHomePage();
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
	public AdminHomePage() { // throws SQLException {
//		database = new ConnectDatabase();
		
		setResizable(false);
		setSize(1180, 750);
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("images/appLogo.png")).getImage());
		
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.decode("#9955ff"));
		menuPanel.setPreferredSize(new Dimension(300,400));
		contentPane.add(menuPanel, BorderLayout.WEST);
		menuPanel.setLayout(null);

		JLabel welcomeLbl = new JLabel("WELCOME SIR");
		welcomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLbl.setFont(new Font("Century Gothic", Font.BOLD, 32));
		welcomeLbl.setForeground(Color.decode("#ebddff"));
		welcomeLbl.setBounds(10, 10, 290, 65);
		menuPanel.add(welcomeLbl);
		
		studCompBtn = new JButton("Students Complains");
		studCompBtn.setBounds(35,125, 283,65);
		studCompBtn.setBorder(null);
		studCompBtn.setBorderPainted(false);
		studCompBtn.setBackground(Color.white);
		studCompBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		studCompBtn.setFocusable(false);
		studCompBtn.addActionListener(this);
		menuPanel.add(studCompBtn);
		
		
		mealBtn = new JButton("Meal Charge");
		mealBtn.setBounds(35,200, 283,65);
		mealBtn.setBorder(null);
		mealBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		mealBtn.setBorderPainted(false);
		mealBtn.setContentAreaFilled(false);
		mealBtn.setForeground(Color.white);
		mealBtn.setFocusable(false);
		mealBtn.addActionListener(this);
		menuPanel.add(mealBtn);
		
		kickBtn = new JButton("Remove Student");
		kickBtn.setBounds(35,275, 283,65);
		kickBtn.setBorder(null);
		kickBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		kickBtn.setFocusable(false);
		kickBtn.setBorderPainted(false);
		kickBtn.setContentAreaFilled(false);
		kickBtn.setForeground(Color.white);
		kickBtn.addActionListener(this);
		menuPanel.add(kickBtn);
		
		updateBtn = new JButton("Update Credentials");
		updateBtn.setBounds(35,350, 283, 65);
		updateBtn.setBorder(null);
		updateBtn.setFocusable(false);
		updateBtn.setBorderPainted(false);
		updateBtn.setContentAreaFilled(false);
		updateBtn.setForeground(Color.white);
		updateBtn.setFont(new Font("Century Gothic", Font.BOLD, 20));
		updateBtn.addActionListener(this);
		menuPanel.add(updateBtn);
		
		
		cardLT = new CardLayout();
		deckP = new JPanel(cardLT);
		contentPane.add(deckP, BorderLayout.CENTER);
		
		JPanel complainPanel = new complainPanel();
		deckP.add(complainPanel, "Complain");
		
		JPanel mealPanel = new mealPanel();
		deckP.add(mealPanel, "Meal");
		
		JPanel kickPanel = new kickStudPanel();
		deckP.add(kickPanel, "Kickout");
		
		JPanel updatePanel = new updateCredPanel();
		deckP.add(updatePanel, "Update");
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent eve) {
//				try {
//					if(((complainPanel) complainPanel).allSolved()) database.deleteAllFromTable("complain_box");
//					
//					database.closeConnection();
//				} catch (SQLException e) {e.printStackTrace();}
				dispose();
			}
		});
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==studCompBtn) {
			cardLT.show(deckP, "Complain");
			enableBtn(studCompBtn);
			disableBtn(mealBtn);
			disableBtn(kickBtn);
			disableBtn(updateBtn);
			repaint();
		}
		
		if(ae.getSource()==mealBtn) {
			cardLT.show(deckP, "Meal");
			disableBtn(studCompBtn);
			enableBtn(mealBtn);
			disableBtn(kickBtn);
			disableBtn(updateBtn);
			repaint();
		}
		if(ae.getSource()==kickBtn) {
			cardLT.show(deckP, "Kickout");
			disableBtn(studCompBtn);
			disableBtn(mealBtn);
			enableBtn(kickBtn);
			disableBtn(updateBtn);
			repaint();
		}
		if(ae.getSource()==updateBtn) {
			cardLT.show(deckP, "Update");
			disableBtn(studCompBtn);
			disableBtn(mealBtn);
			disableBtn(kickBtn);
			enableBtn(updateBtn);
			repaint();
		}
	}
	
	private void disableBtn(JButton btn) {
		btn.setContentAreaFilled(false);
//		btn.setBackground(Color.decode("#9955ff"));
		btn.setForeground(Color.white);
	}
	private void enableBtn(JButton btn) {
		btn.setContentAreaFilled(true);
		btn.setForeground(Color.black);
		btn.setBackground(Color.white);
	}
}
