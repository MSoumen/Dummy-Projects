import java.awt.*;
import java.awt.Window.Type;
import java.awt.event.*;
//import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class KickConfirmation implements ActionListener{
	private String kickoutName;
	private JFrame kickFrame;
	private JPanel contentPane;
	private JButton confirmBtn, cancelBtn;
//	private ConnectDatabase db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new KickConfirmation("sad");
					
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
	public KickConfirmation(String id) {// throws SQLException {
//		db = new ConnectDatabase(id);
		kickoutName = "Soumen";//db.getStudentName(id);
		if(kickoutName.equals("")) {JOptionPane.showMessageDialog(null, "There is no such student with this ID",
																	"Invalid ID", JOptionPane.ERROR_MESSAGE);
//			db.closeConnection();
			//System.exit(0);
		}else {
			kickFrame = new JFrame();
			kickFrame.setResizable(false);
			kickFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			kickFrame.setLocationRelativeTo(null);
			kickFrame.setSize(300, 300);
			kickFrame.setTitle("Confirmation");
			kickFrame.setAlwaysOnTop(true);
			kickFrame.setIconImage(new ImageIcon(getClass().getResource("images/appLogo.png")).getImage());
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			kickFrame.setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("You are going to remove");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(63, 25, 176, 35);
			contentPane.add(lblNewLabel);
			
			JLabel kickoutNameLbl = new JLabel(kickoutName);
			kickoutNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
			kickoutNameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
			kickoutNameLbl.setBounds(10, 58, 266, 35);
			contentPane.add(kickoutNameLbl);
			
			confirmBtn = new JButton("Confirm");
			confirmBtn.setForeground(new Color(255, 255, 255));
			confirmBtn.setBackground(new Color(255, 0, 0));
			confirmBtn.setBounds(51, 144, 85, 45);
			confirmBtn.setFocusable(false);
			confirmBtn.addActionListener(this);
			contentPane.add(confirmBtn);
			
			cancelBtn = new JButton("Cancel");
			cancelBtn.setForeground(new Color(255, 255, 255));
			cancelBtn.setBackground(new Color(0, 0, 0));
			cancelBtn.setBounds(154, 144, 85, 45);
			cancelBtn.setFocusable(false);
			cancelBtn.addActionListener(this);
			contentPane.add(cancelBtn);
			
			kickFrame.setVisible(true);
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource()==confirmBtn) {
//				db.deleteStudentRecord();
				JOptionPane.showMessageDialog(null, kickoutName+" removed Successfully!");
			}
			if(ae.getSource()==cancelBtn) {
//				db.closeConnection();
				
			}
			kickFrame.dispose();	
		}catch(Exception e) {e.printStackTrace();}
	}

}
