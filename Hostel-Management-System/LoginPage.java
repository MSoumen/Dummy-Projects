import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener, MouseListener{

	private BackgroundImagePanel contentPane;
	private JButton btnClose, btnCancel, minimizeBtn, btnSubmit;
	private JRadioButton superRB, studentRB;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblForgot, lblRegister;
	private Color baseColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setSize(1280,670);
		setUndecorated(true);
		setShape(new RoundRectangle2D.Double(0,0, getWidth(),getHeight(), 80,80));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("HMS Login Page");
		setIconImage(new ImageIcon(getClass().getResource("images/appLogo.png")).getImage());
		
		baseColor = new Color(138, 43, 226);
		
		contentPane = new BackgroundImagePanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup btnGrp = new ButtonGroup();
		
		studentRB = new JRadioButton("Border Login");
		studentRB.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		studentRB.setBounds(818, 116, 200, 35);
		studentRB.setFocusable(false);
		studentRB.setContentAreaFilled(false);
		studentRB.setIcon(new ImageIcon(getClass().getResource("/images/border.png")));
		studentRB.setSelectedIcon(new ImageIcon(getClass().getResource("/images/borderSelected.png")));
		studentRB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		studentRB.setToolTipText("Login As Hostel Student");
		btnGrp.add(studentRB);
		studentRB.setSelected(true);
		contentPane.add(studentRB);
		
		superRB = new JRadioButton("Admin Login");
		superRB.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		superRB.setBounds(1020, 116, 168, 35);
		superRB.setFocusable(false);
		superRB.setContentAreaFilled(false);
		superRB.setIcon(new ImageIcon(getClass().getResource("/images/admin.png")));
		superRB.setSelectedIcon(new ImageIcon(getClass().getResource("/images/adminSelected.png")));
		superRB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		superRB.setToolTipText("Login As Administrator");
		btnGrp.add(superRB);
		contentPane.add(superRB);
		
		ImageIcon exitIcon = new ImageIcon(getClass().getResource("/images/exit1.png"));
		btnClose = new JButton(exitIcon);
		btnClose.setRolloverIcon(new ImageIcon(getClass().getResource("/images/exit2.png")));
		btnClose.setFocusable(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setBounds(1219, 22, 20, 20);
		btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClose.setToolTipText("Close");
		btnClose.addActionListener(this);
		contentPane.add(btnClose);

		minimizeBtn = new JButton(new ImageIcon(getClass().getResource("/images/minimize.png")));
		minimizeBtn.setRolloverIcon(new ImageIcon(getClass().getResource("/images/miniSelected.png")));
		minimizeBtn.setFocusable(false);
		minimizeBtn.setContentAreaFilled(false);
		minimizeBtn.setBorderPainted(false);
		minimizeBtn.setBounds(1180, 22, 20, 20);
		minimizeBtn.setToolTipText("Minimize");
		minimizeBtn.addActionListener(this);
		contentPane.add(minimizeBtn);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 80));
		lblNewLabel.setBounds(38, 116, 445, 110);
		contentPane.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("2");
		lblTo.setVerticalAlignment(SwingConstants.TOP);
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Century Gothic", Font.BOLD, 60));
		lblTo.setBounds(48, 225, 134, 86);
		contentPane.add(lblTo);
		
		JLabel lblHostelManagementSystem = new JLabel("MANAGE YOUR HOSTEL");
		lblHostelManagementSystem.setVerticalAlignment(SwingConstants.TOP);
		lblHostelManagementSystem.setForeground(Color.WHITE);
		lblHostelManagementSystem.setFont(new Font("Century Gothic", Font.BOLD, 60));
		lblHostelManagementSystem.setBounds(38, 304, 715, 86);
		contentPane.add(lblHostelManagementSystem);
		
		JLabel lblNewLabel_1 = new JLabel("Your All In One Solution for Hostel Management");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(38, 400, 715, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setForeground(baseColor);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setBounds(834, 180, 168, 58);
		contentPane.add(lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		txtUsername.setBounds(834, 234, 345, 58);
		txtUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, baseColor));
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setForeground(baseColor);
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblNewLabel_2_1.setBounds(834, 310, 168, 58);
		contentPane.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		passwordField.setBounds(834, 363, 345, 58);
		passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, baseColor));
		contentPane.add(passwordField);
		
		lblRegister = new JLabel("<HTML><U>Create a New Account</U></HTML>");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(138, 43, 226));
		lblRegister.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblRegister.setBounds(834, 445, 168, 51);
		lblRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblRegister.addMouseListener(this);
		contentPane.add(lblRegister);
		
		lblForgot = new JLabel("<HTML><U>Forgot Password ?</U></HTML>");
		lblForgot.setForeground(new Color(138, 43, 226));
		lblForgot.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblForgot.setBounds(1033, 432, 202, 51);
		lblForgot.addMouseListener(this);
		contentPane.add(lblForgot);
		
		btnSubmit = new JButton("");
		btnSubmit.setBounds(1053, 510, 152, 52);
		btnSubmit.setBorderPainted(false);
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setIcon(new ImageIcon(getClass().getResource("images/submit.png")));
		btnSubmit.setRolloverIcon(new ImageIcon(getClass().getResource("images/submitHover.png")));
		btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSubmit.setFocusable(false);
		btnSubmit.addActionListener(this);
		contentPane.add(btnSubmit);
		
		btnCancel = new JButton("");
		btnCancel.setBounds(1053, 583, 152, 52);
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setIcon(new ImageIcon(getClass().getResource("images/cancel.png")));
		btnCancel.setRolloverIcon(new ImageIcon(getClass().getResource("images/cancelHover.png")));
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnClose || e.getSource()==btnCancel) dispose();
		if(e.getSource()==minimizeBtn) setState(JFrame.ICONIFIED);
		
		if(e.getSource()==btnSubmit) {
			String tableName = "";
			if(superRB.isSelected()) tableName = "super_login";
			else tableName = "border_login";
			
			try {
//				ConnectDatabase db = new ConnectDatabase();
//				if(true) {
				if(txtUsername.getText().equals("soumen") && new String(passwordField.getPassword()).equals("123")) {
//				if(db.signIn(tableName, txtUsername.getText(), new String(passwordField.getPassword()))) {
					if(tableName.equals("border_login")) {
						StudentHomePage homepage = new StudentHomePage(txtUsername.getText());
						homepage.setVisible(true);
						
					}else {
						AdminHomePage homepage = new AdminHomePage();
						homepage.setVisible(true);
					}
					dispose();
					
				}
				else JOptionPane.showMessageDialog(null, "Username and \"Password\" is not matched"); 
					
//				db.closeConnection();
			}catch(Exception x) {x.printStackTrace();}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			if(e.getSource()==lblRegister) {
				RegistrationPage obj = new RegistrationPage();
				obj.setVisible(true);
				this.dispose();
			}
			if(e.getSource()==lblForgot) {
				ForgetPassword obj = new ForgetPassword();
				obj.setVisible(true);
				obj.setFocusable(true);
			}
			
		}catch(Exception x) {x.printStackTrace();}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==lblForgot) lblForgot.setForeground(Color.RED);
		if(e.getSource()==lblRegister) lblRegister.setForeground(Color.GREEN.darker());
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==lblForgot) lblForgot.setForeground(baseColor);
		if(e.getSource()==lblRegister) lblRegister.setForeground(baseColor);
	}
}

class BackgroundImagePanel extends JPanel{
	Image backImage= new ImageIcon(getClass().getResource("/images/login2.png")).getImage();
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(backImage, 0,0, null);
	}
}
