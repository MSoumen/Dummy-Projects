import java.awt.*;
import java.awt.event.*;
//import java.sql.SQLException;
import javax.swing.*;

public class complainPanel extends JPanel implements ActionListener {
//	private ConnectDatabase database;
	private String[] complainArr= {"Light is not working!", "water less remaining"}, 
			nameArr= {"Soumen", "Koushik"}, 
			timeArr= {"12:05", "11:11"};
	private String studentIdentity;
	private int msgIdx=0;
	private JLabel identityLbl;
	private JTextArea textArea;
	private JButton nextMsgBtn, deleteMsgBtn;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public complainPanel() {// throws SQLException {
//		database = new ConnectDatabase();
//		complainArr = database.getComplainArr();
//		nameArr = database.getcomplainerNameArr();
//		timeArr = database.getComplainTimeArr();
		
		
		studentIdentity = nameArr[0]+" wrote at "+timeArr[0];
		
		setSize(1000, 700);
		setBackground(Color.WHITE);
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(156, 156, 487, 314);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Ink Free", Font.BOLD, 26));
		textArea.setLineWrap(true);
		textArea.setBackground(Color.decode("#fbda75"));
		textArea.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
		textArea.setText(complainArr[0]);
		scrollPane.setViewportView(textArea);
		
		
		identityLbl = new JLabel(studentIdentity);
		identityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(identityLbl);
		
		nextMsgBtn = new JButton("Next");
		nextMsgBtn.setBounds(538, 111, 85, 35);
		nextMsgBtn.setFocusable(false);
		nextMsgBtn.setContentAreaFilled(false);
		nextMsgBtn.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker(), 3));
		nextMsgBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextMsgBtn.setToolTipText("View Next Complain");
		add(nextMsgBtn);
		nextMsgBtn.addActionListener(this);
		
		deleteMsgBtn = new JButton("Solved");
		deleteMsgBtn.setBounds(178, 111, 85, 35);
		deleteMsgBtn.setContentAreaFilled(false);
		deleteMsgBtn.setFocusable(false);
		deleteMsgBtn.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		deleteMsgBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteMsgBtn.setToolTipText("Delete this Complain and marked as Solved");
		add(deleteMsgBtn);
		deleteMsgBtn.addActionListener(this);
		
		
		if(complainArr.length<=1) {nextMsgBtn.setEnabled(false); deleteMsgBtn.setEnabled(false);}
		
//		try {
//			if(allSolved()) database.deleteAllFromTable("complain_box");
//			
//			database.closeConnection();
//		} catch (SQLException e) {e.printStackTrace();}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nextMsgBtn) {
			if(msgIdx>=complainArr.length-1) msgIdx=-1;
			msgIdx++;
			textArea.setText(complainArr[msgIdx]);
			studentIdentity = nameArr[msgIdx]+" wrote at "+timeArr[msgIdx];
			identityLbl.setText(studentIdentity);
			
		}
		
		if(e.getSource()==deleteMsgBtn) {
			complainArr[msgIdx] = "SOLVED! :)";
			nameArr[msgIdx] = "- - -";
			timeArr[msgIdx] = "- - -";
			msgIdx++;
			if(msgIdx>=complainArr.length) msgIdx=0;
			textArea.setText(complainArr[msgIdx]);
			studentIdentity = nameArr[msgIdx]+" wrote at "+timeArr[msgIdx];
			identityLbl.setText(studentIdentity);
		}
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.drawImage(new ImageIcon(getClass().getResource("images/studComp2.png")).getImage(), 150, 100, null);
	}
	
	boolean allSolved() {
		for(String name: nameArr) {
			if(!name.equals("- - -")) return false;
		}
		
		return true;
	}

}
