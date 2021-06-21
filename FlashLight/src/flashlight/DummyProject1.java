package flashlight;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

class DummyProject1 extends JFrame{
	DummyProject1(){
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		getContentPane().add(new DummyPanel());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

class DummyPanel extends JPanel implements ActionListener{
	Random rand;
	Timer time;
	DummyPanel(){
	 rand = new Random();
	 time = new Timer(500, this);
	 time.start();
	 //create blank cursor
	 BufferedImage cursorImg = new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB);
	 Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0,0), "blank__");
	 setCursor(blankCursor);

	}

        @Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		int red1 = rand.nextInt(255);
		int green1 = rand.nextInt(255);
		int blue1 = rand.nextInt(255);
		Color color1 = new Color(red1, green1, blue1);

		int red2 = rand.nextInt(255);
		int green2 = rand.nextInt(255);
		int blue2 = rand.nextInt(255);
		Color color2 = new Color(red2, green2, blue2);

		GradientPaint gradientColor = new GradientPaint(0,0,color1.brighter(), 1200,1200,color2.brighter());
		System.out.print("Color 1:"+gradientColor.getColor1()+"  Color 2:"+gradientColor.getColor2()+"\n");

		// g2d.setPaint(randomColor.brighter());
		g2d.setPaint(gradientColor);
		g2d.fillRect(0,0, this.getWidth(), this.getHeight());
	}

        @Override
	public void actionPerformed(ActionEvent e){
		repaint();
	}
}