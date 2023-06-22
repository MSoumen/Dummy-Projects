import java.awt.*;
import java.awt.event.*;
//import java.sql.SQLException;
import javax.swing.*;

public class kickStudPanel extends JPanel implements ActionListener{
	
	private JButton kickBtn;
	private JTextField kickIDField;
	/**
	 * Create the panel.
	 */
	public kickStudPanel() {
		setBackground(Color.white);
		setSize(1000, 700);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Student ID :");
		lblNewLabel.setBounds(204, 196, 176, 31);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		add(lblNewLabel);
		
		kickIDField = new JTextField();
		kickIDField.setBounds(370, 196, 176, 31);
		kickIDField.setForeground(new Color(220, 20, 60));
		kickIDField.setFont(new Font("Arial", Font.PLAIN, 20));
		kickIDField.setColumns(10);
		add(kickIDField);
		
		kickBtn = new JButton("Kick");
		kickBtn.setBounds(454, 237, 92, 37);
		kickBtn.setFocusable(false);
		kickBtn.setContentAreaFilled(false);
		kickBtn.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		kickBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		kickBtn.setToolTipText("Remove the Student & his all Data From Student Database");
		kickBtn.addActionListener(this);
		add(kickBtn);
		
		JLabel lblRemoveStudentsFrom = new JLabel("Remove Students From Hostel");
		lblRemoveStudentsFrom.setFont(new Font("Century Gothic", Font.PLAIN, 28));
		lblRemoveStudentsFrom.setBounds(161, 70, 415, 48);
		add(lblRemoveStudentsFrom);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			new KickConfirmation(kickIDField.getText());
//			kickIDField.setText("");
		
		} catch (Exception e) {e.printStackTrace();}
		
	}
}
