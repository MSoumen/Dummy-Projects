import java.awt.*;
import java.awt.event.*;
//import java.sql.SQLException;
import javax.swing.*;

class StudentComplainSendPanel extends JPanel implements ActionListener {
	
	private JLabel submitLbl;
	private JTextPane complainBox;
	private JButton complainBtn;
//	private ConnectDatabase database;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	StudentComplainSendPanel(String id) {//throws SQLException {
//		database = new ConnectDatabase(id);
		
		setBackground(Color.white);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		
		scrollPane.setBounds(30,30, 500, 300);
		add(scrollPane);
		
		complainBox = new JTextPane();
		complainBox.setFont(new Font("Ink Free", Font.BOLD, 26));
		complainBox.setOpaque(true);
		complainBox.setBackground(Color.decode("#fbda75"));
		complainBox.setToolTipText("Write your Complain here");
		scrollPane.setViewportView(complainBox);
		
		JLabel lblNewLabel_1 = new JLabel("Write Your Complain");
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		complainBtn = new JButton();
		complainBtn.setBounds(540, 280, 50, 50);
		complainBtn.setIcon(new ImageIcon(getClass().getResource("images/send.png")));
		complainBtn.setRolloverIcon(new ImageIcon(getClass().getResource("images/sendRoll.png")));
		complainBtn.setToolTipText("Send your Complain");
		complainBtn.setContentAreaFilled(false);
		complainBtn.setBorderPainted(false);
		complainBtn.setFocusable(false);
		complainBtn.addActionListener(this);
		add(complainBtn);
		
		submitLbl = new JLabel("");
		submitLbl.setForeground(Color.RED);
		submitLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		submitLbl.setBounds(30, 339, 461, 52);
		add(submitLbl);
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource()==complainBtn) {
//				database.sentComplain(complainBox.getText()); 
				submitLbl.setText("Complain Registered!");
			}
		}catch(Exception e) {e.printStackTrace();} 
		finally {
			complainBtn.setEnabled(false);
			submitLbl.setText("Complain Registration Failed!");
		}
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon(getClass().getResource("images/studComp1.png")).getImage();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.drawImage(img, 380, 420, null);
		img = new ImageIcon(getClass().getResource("images/studComp2.png")).getImage();
		g2d.drawImage(img, 30, 5, null);
	}

}
