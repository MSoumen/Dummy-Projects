import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Window.Type;
//import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
	private JTextField ansField, idField;
	private JComboBox<String> quesCombo;
	private JLabel resultLabel;
	private JButton submitBtn, cancelBtn;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ForgetPassword frame = new ForgetPassword();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ForgetPassword() {
		Font lblFont = new Font("Century Gothic", Font.BOLD, 18);
		Font fieldFont = new Font("arial", Font.PLAIN, 16);
		
		setType(Type.UTILITY);
		setTitle("Forgot Password !");
		setSize(536,320);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("images/appLogo.png")).getImage());
		
		JLabel lblBorderId = new JLabel("Border ID");
		lblBorderId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBorderId.setFont(lblFont);
		lblBorderId.setBounds(10, 50, 150, 28);
		getContentPane().add(lblBorderId);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(186, 50, 208, 28);
		idField.setFont(fieldFont);
		getContentPane().add(idField);
		
		JLabel lblYourAnswer = new JLabel("Your Answer");
		lblYourAnswer.setHorizontalAlignment(SwingConstants.TRAILING);
		lblYourAnswer.setFont(lblFont);
		lblYourAnswer.setBounds(10, 149, 150, 28);
		getContentPane().add(lblYourAnswer);
		
		ansField = new JTextField();
		ansField.setColumns(10);
		ansField.setBounds(186, 149, 208, 28);
		ansField.setFont(fieldFont);
		getContentPane().add(ansField);
		
		
		JLabel lblQuestionType = new JLabel("Question Type");
		lblQuestionType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQuestionType.setFont(lblFont);
		lblQuestionType.setBounds(10, 102, 150, 28);
		getContentPane().add(lblQuestionType);
		
		quesCombo = new JComboBox<String>();
		quesCombo.setModel(new DefaultComboBoxModel<>(new String[] {"Your Nickname", "Your Pet Name", "Your Favourite Book", "The Person You Loved Most"}));
		quesCombo.setSelectedIndex(0);
		quesCombo.setFont(fieldFont);
		quesCombo.setBounds(186, 101, 208, 28);
		getContentPane().add(quesCombo);
		
		resultLabel = new JLabel("");
		resultLabel.setBounds(10, 199, 500, 40);
		resultLabel.setForeground(Color.red);
		resultLabel.setHorizontalAlignment(JLabel.CENTER);
		resultLabel.setFont(lblFont);
		getContentPane().add(resultLabel);
		
		submitBtn = new JButton("Submit");
		submitBtn.setForeground(Color.BLACK);
		submitBtn.setBackground(Color.GREEN);
		submitBtn.setBounds(414, 141, 85, 36);
		submitBtn.addActionListener(this);
		getContentPane().add(submitBtn);
		
		cancelBtn = new JButton("Back");
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setBackground(Color.RED);
		cancelBtn.setBounds(414, 94, 85, 36);
		cancelBtn.addActionListener(this);
		getContentPane().add(cancelBtn);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
//			ConnectDatabase db = new ConnectDatabase();
			
			if(e.getSource()==submitBtn) {
				if(ansField.getText().equals("") || idField.getText().equals("")) {
					JOptionPane.showMessageDialog(this,"Please Fill all the Fields", "Error",JOptionPane.ERROR_MESSAGE );
				}else {
					String questionTopic = "";
					if(quesCombo.getSelectedIndex()==0) questionTopic = "nickname";
					else if(quesCombo.getSelectedIndex()==1) questionTopic="pet";
					else if(quesCombo.getSelectedIndex()==2) questionTopic="book";
					else questionTopic = "person";
					
					String fetchedPassword ="12345",// db.getStudentPassword(idField.getText(), questionTopic, ansField.getText()),
							output = ""; 
					if(fetchedPassword.equals("")) output = "Wrong Credentials, Contact Hostel Super";
					else output = "Your Password : "+fetchedPassword;
					// magic end
					resultLabel.setText(output);
				}
			}
		
		if(e.getSource()==cancelBtn) this.dispose();
			
//		db.closeConnection();
		} catch(Exception x) {x.printStackTrace();}
		
	}
}
