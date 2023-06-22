import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updateCredPanel extends JPanel implements ActionListener{
//	private ConnectDatabase db;
	
	private JTextField unameField, passField;
	private JButton updateBtn;

	/**
	 * Create the panel.
	 */
	public updateCredPanel() {
		
		setSize(1000,700);
		setBackground(Color.white);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Your Credentials ");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		lblNewLabel.setBounds(182, 118, 351, 57);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New  Username :");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1.setBounds(139, 218, 204, 28);
		add(lblNewLabel_1);
		
		unameField = new JTextField();
		unameField.setFont(new Font("Arial", Font.PLAIN, 16));
		unameField.setBounds(342, 218, 204, 32);
		add(unameField);
		unameField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password :");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(139, 269, 204, 28);
		add(lblNewLabel_1_1);
		
		passField = new JTextField();
		passField.setToolTipText("Password should contains 1 UPPERCASE, 1 lowercase and 1 symbol");
		passField.setFont(new Font("Arial", Font.PLAIN, 16));
		passField.setColumns(10);
		passField.setBounds(342, 269, 204, 32);
		add(passField);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(464, 334, 90, 35);
		updateBtn.setFocusable(false);
		updateBtn.setContentAreaFilled(false);
		updateBtn.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker(), 3));
		updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updateBtn.setToolTipText("Update Your Username and password for next login");
		updateBtn.addActionListener(this);
		add(updateBtn);

		
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
//			db = new ConnectDatabase();
			
			if(ae.getSource()==updateBtn) {
//				db.updateAdminIdPass(unameField.getText(), passField.getText());
				JOptionPane.showMessageDialog(null, "Username and Password Updated Successfully.",
						"Successfull", JOptionPane.INFORMATION_MESSAGE);
			}
			
			unameField.setText("");
			passField.setText("");
//			db.closeConnection();
		}catch(Exception e) {e.printStackTrace();}
	}
}
