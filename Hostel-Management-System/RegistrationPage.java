import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.sql.SQLException;
import java.text.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistrationPage extends JFrame implements ActionListener, FocusListener{
	
//	private ConnectDatabase db;
	private JPanel contentPane;
	private JTextField nameField, fnameField, mnameField, villField, 
						poField, psField, pinField, dobField, bloodField, 
						phoneField, alterPhField;
	private JTextField regNoField;
	private JLabel picsLbl, signLbl;;
	private JButton submitBtn, resetBtn, cancelBtn, backBtn, picsBtn, signBtn;;
	private JComboBox<String> semCombo, deptCombo, casteCombo, distCombo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPage frame = new RegistrationPage();
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
	public RegistrationPage() {// throws SQLException {
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);
		Font lblFont = new Font("Century Gothic", Font.PLAIN, 20);
//		db = new ConnectDatabase();
		
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 70, 1280, 750);
		contentPane = new RegistrationBackground();
		contentPane.setOpaque(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setIconImage(new ImageIcon(getClass().getResource("images/appLogo.png")).getImage());
		
		JLabel lblNewLabel = new JLabel("Student Registration Form");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.decode("#ae52d4"));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(400, 10, 500, 56);
		contentPane.add(lblNewLabel);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setFont(lblFont);
		nameLbl.setBounds(147, 100, 200, 23);
		contentPane.add(nameLbl);
													// each  component group is 50px vertically spaced
													// component inside group is 25px spaced
		//Personal Details
		nameField = new JTextField();
		nameField.setFont(fieldFont);
		nameField.setBounds(147, 125, 200, 25);
		nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		nameField.setBackground(Color.white);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel fnameLbl = new JLabel("Father's Name");
		fnameLbl.setFont(lblFont);
		fnameLbl.setBounds(147, 175, 200, 23);
		contentPane.add(fnameLbl);
		
		fnameField = new JTextField();
		fnameField.setFont(fieldFont);
		fnameField.setColumns(10);
		fnameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		fnameField.setBounds(147, 200, 200, 25);
		fnameField.setBackground(Color.white);
		contentPane.add(fnameField);
		
		JLabel mnameLbl = new JLabel("Mother's Name");
		mnameLbl.setFont(lblFont);
		mnameLbl.setBounds(147, 250, 200, 23);
		contentPane.add(mnameLbl);
		
		mnameField = new JTextField();
		mnameField.setFont(fieldFont);
		mnameField.setColumns(10);
		mnameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		mnameField.setBounds(147, 275, 200, 25);
		mnameField.setBackground(Color.white);
		contentPane.add(mnameField);
		
		JLabel dobLbl = new JLabel("Date Of Birth");
		dobLbl.setFont(lblFont);
		dobLbl.setBounds(147, 325, 200, 23);
		contentPane.add(dobLbl);
		
		DateFormat df = new SimpleDateFormat("DD/mm/yyyy");
		dobField = new JFormattedTextField(df);
		dobField.setText("dd/mm/yyyy");
		dobField.setToolTipText("Date/Month/Year");
		dobField.setFont(fieldFont);
		dobField.setColumns(10);
		dobField.setBounds(147, 350, 200, 25);
		dobField.setBackground(Color.white);
		dobField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		dobField.addFocusListener(this);
		contentPane.add(dobField);
		
		JLabel casteLbl = new JLabel("Caste");
		casteLbl.setFont(lblFont);
		casteLbl.setBounds(147, 400, 200, 23);
		contentPane.add(casteLbl);
		
		casteCombo = new JComboBox<>();
		casteCombo.setModel(new DefaultComboBoxModel<>(new String[] {"GEN", "OBC-A", "OBC-B", "SC", "ST"}));
		casteCombo.setMaximumRowCount(5);
		casteCombo.setSelectedIndex(0);
		casteCombo.setBounds(147, 425, 200, 25);
		casteCombo.setFont(fieldFont);
		casteCombo.setOpaque(true);
		contentPane.add(casteCombo);
		
		JLabel ppLbl = new JLabel("Personal Phone");
		ppLbl.setFont(lblFont);
		ppLbl.setBounds(147, 475, 200, 23);
		contentPane.add(ppLbl);
		
		phoneField = new JTextField();
		phoneField.setFont(fieldFont);
		phoneField.setColumns(10);
		phoneField.setBounds(147, 500, 200, 25);
		phoneField.setBackground(Color.white);
		phoneField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		contentPane.add(phoneField);
		
		JLabel papLbl = new JLabel("Parents Phone");
		papLbl.setFont(lblFont);
		papLbl.setBounds(147, 550, 200, 23);
		contentPane.add(papLbl);
		
		alterPhField = new JTextField();
		alterPhField.setFont(fieldFont);
		alterPhField.setColumns(10);
		alterPhField.setBounds(147, 575, 200, 25);
		alterPhField.setBackground(Color.white);
		alterPhField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		contentPane.add(alterPhField);
		
		JLabel bgLbl = new JLabel("Blood Group");
		bgLbl.setFont(lblFont);
		bgLbl.setBounds(375, 550, 165, 23);
		contentPane.add(bgLbl);
		
		bloodField = new JTextField();
		bloodField.setFont(fieldFont);
		bloodField.setColumns(10);
		bloodField.setBounds(375, 575, 165, 25);
		bloodField.setBackground(Color.white);
		bloodField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		contentPane.add(bloodField);
		
		//Educational
		JLabel regLbl = new JLabel("Registration No");
		regLbl.setFont(lblFont);
		regLbl.setBounds(400, 100, 200, 23);
		contentPane.add(regLbl);
		
		regNoField = new JTextField();
		regNoField.setToolTipText("10 Digits number that starts with ' D '");
		regNoField.setFont(fieldFont);
		regNoField.setColumns(10);
		regNoField.setBounds(400, 125, 200, 25);
		regNoField.setBackground(Color.white);
		regNoField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		contentPane.add(regNoField);
		
		JLabel deptLbl = new JLabel("Department");
		deptLbl.setFont(lblFont);
		deptLbl.setBounds(400, 175, 200, 23);
		contentPane.add(deptLbl);
		
		deptCombo = new JComboBox<>();
		deptCombo.setModel(new DefaultComboBoxModel<>(new String[] {"CE", "EE", "ME", "CST"}));
		deptCombo.setSelectedIndex(0);
		deptCombo.setMaximumRowCount(4);
		deptCombo.setBounds(400, 200, 200, 25);
		deptCombo.setFont(fieldFont);
		deptCombo.setOpaque(true);
		contentPane.add(deptCombo);
		
		JLabel semLbl = new JLabel("Semester");
		semLbl.setFont(lblFont);
		semLbl.setBounds(400, 250, 200, 23);
		contentPane.add(semLbl);
		
		semCombo = new JComboBox<>();
		semCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th"}));
		semCombo.setMaximumRowCount(6);
		semCombo.setSelectedIndex(0);
		semCombo.setBounds(400, 275, 200, 25);
		semCombo.setFont(fieldFont);
		semCombo.setOpaque(true);
		contentPane.add(semCombo);
		
		// Address details
		JLabel villLbl = new JLabel("Village");
		villLbl.setFont(lblFont);
		villLbl.setBounds(654, 100, 130, 23);
		contentPane.add(villLbl);
		
		villField = new JTextField();
		villField.setFont(fieldFont);
		villField.setColumns(10);
		villField.setBounds(654, 125, 200, 25);
		villField.setBackground(Color.white);
		villField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		contentPane.add(villField);
		
		JLabel poLbl = new JLabel("Post Office");
		poLbl.setFont(lblFont);
		poLbl.setBounds(654, 175, 200, 23);
		contentPane.add(poLbl);
		
		poField = new JTextField();
		poField.setFont(fieldFont);
		poField.setColumns(10);
		poField.setBounds(654, 200, 200, 25);
		poField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		poField.setBackground(Color.white);
		contentPane.add(poField);
		
		JLabel psLbl = new JLabel("Police Station");
		psLbl.setFont(lblFont);
		psLbl.setBounds(654, 250, 200, 23);
		contentPane.add(psLbl);
		
		psField = new JTextField();
		psField.setFont(fieldFont);
		psField.setColumns(10);
		psField.setBounds(654, 275, 200, 25);
		psField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		psField.setBackground(Color.white);
		contentPane.add(psField);
		
		JLabel pinLbl = new JLabel("Pincode");
		pinLbl.setFont(lblFont);
		pinLbl.setBounds(654, 325, 130, 23);
		contentPane.add(pinLbl);
		
		pinField = new JTextField();
		pinField.setFont(fieldFont);
		pinField.setColumns(10);
		pinField.setBounds(654, 350, 130, 25);
		pinField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		pinField.setBackground(Color.white);
		contentPane.add(pinField);
		
		JLabel distLbl = new JLabel("District");
		distLbl.setFont(lblFont);
		distLbl.setBounds(654, 400, 130, 23);
		contentPane.add(distLbl);
		
		distCombo = new JComboBox<>();
		distCombo.setModel(new DefaultComboBoxModel<>(new String[] {"Alipurduar", "Bankura", "Birbhum", 
				"Cooch Behar", "Dakshin Dinajpur", "Darjeeling", "Hooghly", "Howrah", "Jalpaiguri", "Jhargram",
				"Kalimpong", "Kolkata", "Malda", "Murshidabad", "Nadia", "North 24 Parganas", "Paschim Medinipur",
				"Paschim Bardhaman", "Purba Bardhaman", "Purba Medinipur", "Purulia", "South 24 Parganas", 
				"Uttar Dinajpur"}));
		distCombo.setMaximumRowCount(23);
		distCombo.setSelectedIndex(0);
		distCombo.setBounds(654, 425, 200, 25);
		distCombo.setFont(fieldFont);
		distCombo.setOpaque(true);
		contentPane.add(distCombo);		
		
		//Photo details
		picsLbl = new JLabel("");
		picsLbl.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		picsLbl.setBounds(930, 85, 170, 200);
		contentPane.add(picsLbl);
		
		picsBtn = new JButton("Choose Face Image");
		picsBtn.setForeground(Color.WHITE);
		picsBtn.setBackground(Color.decode("#7b1fa2"));
		picsBtn.setBorder(BorderFactory.createLineBorder(Color.white, 3));
		picsBtn.setBounds(935, 290, 160, 30);
		contentPane.add(picsBtn);
		picsBtn.addActionListener(this);
		
		signLbl = new JLabel("");
		signLbl.setBounds(915, 350, 200, 50);
		signLbl.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		contentPane.add(signLbl);
		
		signBtn = new JButton("Choose Signature");
		signBtn.setForeground(Color.WHITE);
		signBtn.setBackground(Color.decode("#7b1fa2"));
		signBtn.setBorder(BorderFactory.createLineBorder(Color.white, 3));
		signBtn.setBounds(920, 405, 190, 30);
		contentPane.add(signBtn);
		signBtn.addActionListener(this);
		
		// Control Buttons
		submitBtn = new JButton("Submit");
		submitBtn.setForeground(Color.WHITE);
		submitBtn.setBackground(new Color(0, 153, 51));
		submitBtn.setBounds(755, 561, 100, 50);
		submitBtn.setFocusable(false);
		submitBtn.setBorder(BorderFactory.createLineBorder(Color.white, 3));
		submitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submitBtn.addActionListener(this);
		contentPane.add(submitBtn);
		
		resetBtn = new JButton("Reset");
		resetBtn.setForeground(Color.red);
		resetBtn.setBackground(Color.white);
		resetBtn.setFocusable(false);
		resetBtn.setBounds(885, 561, 100, 50);
		resetBtn.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		resetBtn.addActionListener(this);
		contentPane.add(resetBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setBackground(new Color(204, 0, 51));
		cancelBtn.setBounds(1015, 561, 100, 50);
		cancelBtn.setFocusable(false);
		cancelBtn.setBorder(BorderFactory.createLineBorder(Color.white, 3));
		cancelBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cancelBtn.addActionListener(this);
		contentPane.add(cancelBtn);
		
		backBtn = new JButton("Back");
		backBtn.setToolTipText("Go To Login Page");
		backBtn.setForeground(Color.WHITE);
		backBtn.setBackground(Color.decode("#7b1fa2"));
		backBtn.setBorder(BorderFactory.createLineBorder(Color.white, 3));
		backBtn.setBounds(10, 10, 70, 40);
		
		backBtn.setFocusable(false);
		backBtn.addActionListener(this);
		contentPane.add(backBtn);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			if(ae.getSource()==submitBtn) {
				if(regNoField.getText().equals("") || nameField.getText().equals("") || dobField.getText().equals("")
					|| fnameField.getText().equals("") || psField.getText().equals("") || poField.getText().equals("")) {
							
					JOptionPane.showMessageDialog(null, "Please fill all the values !", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					String address = "VILL: "+villField.getText().toUpperCase()
									+", PO: "+poField.getText().toUpperCase()
									+", PS: "+psField.getText().toUpperCase();
					
					String[] studentData = new String[]{ regNoField.getText(),nameField.getText().toUpperCase(),
							deptCombo.getSelectedItem().toString(),semCombo.getSelectedItem().toString(), fnameField.getText().toUpperCase(),
							mnameField.getText().toUpperCase(), casteCombo.getSelectedItem().toString(), address,
							pinField.getText(),distCombo.getSelectedItem().toString(), phoneField.getText(), dobField.getText(),
							bloodField.getText().toUpperCase(), alterPhField.getText()};
					
//					db.registerStudent(studentData);
//					db.closeConnection();
					
					PasswordDialog passwordDialog = new PasswordDialog(studentData[0]);
					passwordDialog.setVisible(true);
				}			
			}
			
			if(ae.getSource()==resetBtn) {
				regNoField.setText(null);
				nameField.setText(null);
				fnameField.setText(null);
				mnameField.setText(null);
				villField.setText(null);
				poField.setText(null);
				psField.setText(null);
				pinField.setText(null);
				dobField.setText("dd/mm/yyyy");
				bloodField.setText(null);
				phoneField.setText(null);
				alterPhField.setText(null);
				deptCombo.setSelectedIndex(0);
				semCombo.setSelectedIndex(0);
				distCombo.setSelectedIndex(0);
				casteCombo.setSelectedIndex(0);
				picsLbl.setIcon(null);
				signLbl.setIcon(null);
				revalidate();
				repaint();
			}
			
			if(ae.getSource()==backBtn || ae.getSource()==cancelBtn) {
				LoginPage obj = new LoginPage();
				obj.setVisible(true);
				this.dispose();
				//this.setVisible(false);
			}
			
			if(ae.getSource()==picsBtn) {
				imageUploader(ae, picsLbl);
			}
			if(ae.getSource()==signBtn) {
				imageUploader(ae, signLbl);
			}
			
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public void focusGained(FocusEvent fe) {
		if(fe.getSource()==dobField) dobField.setText("");
	}
	public void focusLost(FocusEvent fe) {}
	
	private void imageUploader(ActionEvent ev, JComponent com) {
		JFileChooser choose = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png", "jpeg");
		choose.setFileFilter(filter);
		int response = choose.showOpenDialog(null);
		if(response == JFileChooser.APPROVE_OPTION) {
			File f = choose.getSelectedFile();
			try {
				if(f.getAbsolutePath() != null) {
					ImageIcon face = new ImageIcon(scaleImg(com.getWidth(), com.getHeight(), ImageIO.read(new File(f.getAbsolutePath()))));
					//ImageIO.write(givenImg, "jpg", new File("student_imgs/"+fileName+".jpg"));
					((JLabel) com).setIcon(face);
				}
				
			} catch(Exception e) {e.printStackTrace();}
		}
		
	}
	
	private BufferedImage scaleImg(int w, int h, BufferedImage img) throws Exception{
		BufferedImage bi = new BufferedImage(w,h, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) bi.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2d.drawImage(img, 0,0, w,h,null);
		g2d.dispose();
	
		return bi;
	}
	
}

class RegistrationBackground extends JPanel{
		public void paintComponent(Graphics g) {
			g.setColor(Color.decode("#ffffff"));
			g.fillRect(0, 0, getWidth(), getHeight());
			g.drawImage(new ImageIcon(getClass().getResource("images/BPCIT.png")).getImage(), 33,500, null);

//			repaint();
		}
	}
