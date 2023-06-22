import java.awt.*;
import java.awt.event.*;
//import java.sql.SQLException;
import javax.swing.*;

class StudentMealPanel extends JPanel implements ActionListener {
	private JLabel mealLbl, elecLbl, mealStatusLbl;
	private JButton refreshBtn;
	private JToggleButton mealTogBtn;
//	private ConnectDatabase database;
	private String studID, mealChrg, exChrg;
	boolean mealOn;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	StudentMealPanel(String id){// throws SQLException {
		studID = id;
//		database = new ConnectDatabase(id);
		
		setBackground(Color.white);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Meal Charge : Rs. ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(234, 256, 274, 51);
		add(lblNewLabel);
		
		JLabel lblElectricityCharge = new JLabel("Electricity Charge : Rs.");
		lblElectricityCharge.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblElectricityCharge.setBounds(234, 298, 274, 51);
		add(lblElectricityCharge);
		
		mealChrg = getMealCharge();
		mealLbl = new JLabel(mealChrg);
		mealLbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		mealLbl.setBounds(415, 256, 223, 51);
		add(mealLbl);
		
		exChrg = getExtraCharge();
		elecLbl = new JLabel(exChrg);
		elecLbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		elecLbl.setBounds(458, 298, 223, 51);
		add(elecLbl);
		
		refreshBtn = new JButton("");
		refreshBtn.setBounds(452, 359, 56, 45);
		refreshBtn.setIcon(new ImageIcon(getClass().getResource("images/refresh.png")));
		refreshBtn.setRolloverIcon(new ImageIcon(getClass().getResource("images/refreshRoll.png")));
		refreshBtn.setToolTipText("Refresh Charges");
		refreshBtn.setContentAreaFilled(false);
		refreshBtn.setBorderPainted(false);
		refreshBtn.setFocusable(false);
		refreshBtn.addActionListener(this);
		add(refreshBtn);
		
		mealStatusLbl = new JLabel("");
		mealStatusLbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		mealStatusLbl.setBounds(342, 195, 130, 51);
		add(mealStatusLbl);
		
		mealTogBtn = new JToggleButton("", true);
		ImageIcon mealOnIco = new ImageIcon(getClass().getResource("images/mealOn.png"));
		ImageIcon mealOffIco = new ImageIcon(getClass().getResource("images/mealOff.png"));
		mealTogBtn.setIcon(mealOnIco);
		mealTogBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		mealTogBtn.setContentAreaFilled(false);
		mealTogBtn.setBorderPainted(false);
		mealTogBtn.setFocusable(false);
		mealTogBtn.setToolTipText("Click to Enable/Disable Meal Facility");
		mealOn = mealTogBtn.isSelected();
		
		mealStatusLbl.setText("Meal ON");
		
		mealTogBtn.setBounds(272, 196, 60, 60);
		mealTogBtn.addItemListener((ItemEvent ie)->{
			if(mealOn) {
				mealTogBtn.setIcon(mealOffIco);
				mealStatusLbl.setText("Meal OFF"); mealOn=false;
			}
			else {
				mealTogBtn.setIcon(mealOnIco);
				mealStatusLbl.setText("Meal ON"); mealOn=true;
			}
//			revalidate();
		});
		add(mealTogBtn);
		
//		database.closeConnection();
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			
			if(ae.getSource()==refreshBtn) {
//				database = new ConnectDatabase(studID);
				mealLbl.setText(getMealCharge());
				elecLbl.setText(getExtraCharge());
//				database.closeConnection();
			}
		}catch(Exception e) {e.printStackTrace();}
		
	}
	
	private String getMealCharge() {// throws SQLException {
		return "2200.00";//database.getStudentMealCharge();
	}
	private String getExtraCharge() {// throws SQLException {
		return "100.00";// database.getStudentExtraCharge();
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon(getClass().getResource("images/testMeal1.png")).getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.drawImage(img, 20, 50, null);
	}
}
