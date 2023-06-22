import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;
import javax.swing.*;

public class mealPanel extends JPanel implements ActionListener{
//	private ConnectDatabase db;
	private JTextField idField;
	private JLabel nameLbl, fnameLbl;
	private JButton verifyBtn, payBtn;
	private JLabel paidByLbl;
	private JTextField mealChargeField;
	private JTextField otherChargeField;
	private JLabel lblNowDueAmount;
	private JLabel dueOtherLbl;
	private JLabel dueMealLbl;
	private JLabel lblManageMealCharge;
	
	public mealPanel() {// throws SQLException{
		setBackground(Color.white);
		setSize(1000, 700);
		setLayout(null);
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID :");
		lblEnterStudentId.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblEnterStudentId.setBounds(132, 164, 160, 40);
		add(lblEnterStudentId);
		
		idField = new JTextField();
		idField.setToolTipText("Student's Registration Number, Starts with 'D'");
		idField.setForeground(new Color(220, 20, 60));
		idField.setFont(new Font("Arial", Font.PLAIN, 20));
		idField.setColumns(10);
		idField.setBounds(302, 164, 160, 40);
		add(idField);
		
		verifyBtn = new JButton("Validate");
		verifyBtn.setBounds(472, 164, 81, 40);
		verifyBtn.setFocusable(false);
		verifyBtn.setContentAreaFilled(false);
		verifyBtn.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker(), 3));
		verifyBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		verifyBtn.setToolTipText("Get students details from Database");
		verifyBtn.addActionListener(this);
		add(verifyBtn);
		
		nameLbl = new JLabel();
		nameLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		nameLbl.setHorizontalAlignment(SwingConstants.LEFT);
		nameLbl.setBounds(574, 164, 251, 40);
		add(nameLbl);
		
		fnameLbl = new JLabel();
		fnameLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		fnameLbl.setHorizontalAlignment(SwingConstants.LEFT);
		fnameLbl.setBounds(574, 210, 251, 40);
		add(fnameLbl);
		
		paidByLbl = new JLabel();
		paidByLbl.setText("Insert Amout Paid By ");
		paidByLbl.setHorizontalAlignment(SwingConstants.LEFT);
		paidByLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		paidByLbl.setBounds(132, 234, 456, 40);
		add(paidByLbl);
		
		JLabel lblNewLabel = new JLabel("Meal Charge");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(146, 278, 152, 40);
		add(lblNewLabel);
		mealChargeField = new JTextField();
		mealChargeField.setToolTipText("Only Integer Value will Be Accepted");
		mealChargeField.setForeground(Color.DARK_GRAY);
		mealChargeField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mealChargeField.setColumns(10);
		mealChargeField.setBounds(171, 317, 100, 40);
		add(mealChargeField);
		
		JLabel lblOtherCharge = new JLabel("Other Charges");
		lblOtherCharge.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtherCharge.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblOtherCharge.setBounds(302, 278, 154, 40);
		add(lblOtherCharge);
		otherChargeField = new JTextField();
		otherChargeField.setToolTipText("Electricity + Bed Charges");
		otherChargeField.setForeground(Color.DARK_GRAY);
		otherChargeField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		otherChargeField.setColumns(10);
		otherChargeField.setBounds(323, 317, 100, 40);
		add(otherChargeField);
		
		payBtn = new JButton("Pay");
		payBtn.setBounds(453, 320, 100, 40);
		payBtn.setEnabled(false);
		payBtn.setFocusable(false);
		payBtn.setContentAreaFilled(false);
		payBtn.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker(), 3));
		payBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		payBtn.setToolTipText("Pay Money against Student's meal charge");
		payBtn.addActionListener(this);
		add(payBtn);
		
		lblNowDueAmount = new JLabel();
		lblNowDueAmount.setText("Now Due Amount :");
		lblNowDueAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblNowDueAmount.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNowDueAmount.setBounds(146, 398, 230, 40);
		add(lblNowDueAmount);
		
		dueOtherLbl = new JLabel("");
		dueOtherLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dueOtherLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		dueOtherLbl.setBounds(323, 448, 152, 40);
		add(dueOtherLbl);
		
		dueMealLbl = new JLabel("");
		dueMealLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dueMealLbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
		dueMealLbl.setBounds(171, 448, 160, 40);
		add(dueMealLbl);
		
		lblManageMealCharge = new JLabel("Manage Meal Charge ");
		lblManageMealCharge.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		lblManageMealCharge.setBounds(227, 57, 329, 40);
		add(lblManageMealCharge);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
//			db = new ConnectDatabase(idField.getText());
			
			if(ae.getSource()==verifyBtn) {
				String studDetails ="Soumen Mahata CST";// db.getStudentName()+",  "+db.getStudentEdu();
				nameLbl.setText(studDetails);
				fnameLbl.setText("S/O: Mr. Khagendranath Mahata");//+db.getFathersName());
				payBtn.setEnabled(true);
				paidByLbl.setText("Insert Amount Paid By Soumen");//+db.getStudentName());
				
				mealChargeField.setText("");
				otherChargeField.setText("");
				dueMealLbl.setText("");
				dueOtherLbl.setText("");
			}
			
			if(ae.getSource()==payBtn) {
				int mealChrg = Integer.valueOf(mealChargeField.getText());
				int otherChrg = Integer.valueOf(otherChargeField.getText());
//				db.giveStudentCharges(mealChrg, otherChrg);
				
				dueMealLbl.setText("Meal = 1200.00/-");//+db.getStudentMealCharge()+"/-");
				dueOtherLbl.setText("Other = 100.00/-");//+db.getStudentExtraCharge()+"/-");
				
				payBtn.setEnabled(false);
			}
			
//			db.closeConnection();
		}catch(Exception e) {e.printStackTrace();}
		
	}
}
