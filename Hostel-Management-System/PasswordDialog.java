import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
//import java.sql.*;

public class PasswordDialog extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField regNoField, passField, ansField;
	
	private JButton submitBtn, cancelBtn;
	private JComboBox<String> quesCombo;
	private String studentID;
//	private ConnectDatabase db;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PasswordDialog frame = new PasswordDialog("Hello");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PasswordDialog(String id) {// throws SQLException {
		studentID = id;
//		db = new ConnectDatabase(studentID);
		Font lblFont = new Font("Century Gothic", Font.BOLD, 18);
		Font fieldFont = new Font("arial", Font.PLAIN, 16);
		
		setType(Type.UTILITY);
		setTitle("Authentication Process");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 450, 310);
		setSize(492,354);
		setLocationRelativeTo(null);
		this.setUndecorated(false);
		setIconImage(new ImageIcon(getClass().getResource("images/appLogo.png")).getImage());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration No");
		lblNewLabel.setFont(lblFont);
		lblNewLabel.setBounds(28, 27, 166, 28);
		contentPane.add(lblNewLabel);
		
		regNoField = new JTextField();
		regNoField.setFont(fieldFont);
		regNoField.setBounds(204, 27, 215, 28);
		contentPane.add(regNoField);
		regNoField.setColumns(10);
		
		JLabel lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setFont(lblFont);
		lblCreatePassword.setBounds(28, 78, 166, 28);
		contentPane.add(lblCreatePassword);
		
		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(204, 78, 215, 28);
		passField.setFont(fieldFont);
		contentPane.add(passField);
		
		
		JLabel lblQuestionType = new JLabel("Question Type");
		lblQuestionType.setFont(lblFont);
		lblQuestionType.setBounds(28, 132, 150, 28);
		contentPane.add(lblQuestionType);
		
		quesCombo = new JComboBox<>();
		quesCombo.setFont(fieldFont);
		quesCombo.setModel(new DefaultComboBoxModel<>(new String[] {"Your Nickname", "Your Pet Name", 
				"Your Favourite Book", "The Person You Loved Most"}));
		quesCombo.setSelectedIndex(0);
		quesCombo.setBounds(204, 131, 215, 28);
		contentPane.add(quesCombo);
		
		JLabel lblYourAnswer = new JLabel("Your Answer");
		lblYourAnswer.setFont(lblFont);
		lblYourAnswer.setBounds(28, 179, 150, 28);
		contentPane.add(lblYourAnswer);
		
		ansField = new JTextField();
		ansField.setColumns(10);
		ansField.setBounds(204, 179, 215, 28);
		ansField.setFont(fieldFont);
		contentPane.add(ansField);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBackground(new Color(0, 153, 51));
		submitBtn.setForeground(Color.WHITE);
		//submitBtn.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		submitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submitBtn.setBounds(204, 238, 85, 36);
		submitBtn.addActionListener(this);
		contentPane.add(submitBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setBackground(Color.RED);
		cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//cancelBtn.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		cancelBtn.setBounds(327, 238, 85, 36);
		cancelBtn.addActionListener(this);
		contentPane.add(cancelBtn);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitBtn) {
			//checking for Registration mismatch
			if(regNoField.getText().equals(studentID)) {
				String ques = "";
				if(quesCombo.getSelectedIndex()==0) ques = "nickname";
				else if(quesCombo.getSelectedIndex()==1) ques="pet";
				else if(quesCombo.getSelectedIndex()==2) ques="book";
				else ques = "person";
				
				try {
//					db.studentPasswordRegister(studentID, passField.getText(), ques, ansField.getText());
//					db.closeConnection();
				}catch(Exception ev) {ev.printStackTrace();}
				
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null,"Registration Numbers are not same !","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==cancelBtn) this.dispose();
	}
}
