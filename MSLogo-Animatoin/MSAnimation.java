import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
/**
* This Program is buit using the concept of MouseListener class. Microsoft Logo is a used here for reference
*/

public class MSAnimation extends JFrame {
	public static void main(String[] args){
		new MSAnimation();
	}

	MSAnimation(){
		setTitle("Microsoft");
		setBounds(800,100,400,426);
		// setType(Type.UTILITY);
		
		getContentPane().add(new MSlogo());
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		// setLocationRelativeTo(null);
		setVisible(true);
	}
}

class MSlogo extends JPanel implements ActionListener,MouseListener {
	Timer timer;
	int redW = 190,redH = 190, greenX=200, greenH=190, 
		yellowX=200,yellowY=200, blueY=200, blueW=190;
	// int frameCounter;
	boolean mouseEntered;

	MSlogo(){
		timer = new Timer(5, this);
		timer.stop();
		mouseEntered = false;
		// frameCounter = 0;

		setSize(400,400);
		setBackground(Color.decode("#747474").darker());
		addMouseListener(this);
		// timer.start();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setPaint(Color.decode("#F25022")); //red
		g2d.fillRect(0,0,redW, redH);
		
		g2d.setPaint(Color.decode("#7FBA00")); //green
		g2d.fillRect(greenX,0,190, greenH);
		
		g2d.setPaint(Color.decode("#FFB900")); //yellow
		g2d.fillRect(yellowX,yellowY,190, 190);
		
		g2d.setPaint(Color.decode("#00A4EF")); //blue
		g2d.fillRect(0,blueY,blueW, 190);

	}

	public void actionPerformed(ActionEvent e){
		// frameCounter++;
		// System.out.print("Frame "+frameCounter+"\n");
		// System.out.print(""+redW+" "+redH+" --- "+greenX+" "+greenH+"\n"
		// 	+yellowX+" "+yellowY+" --- "+blueY+" "+blueW+"\n\n");
	
		if(mouseEntered && redW>=0){
			redW-=1; redH-=1;
			greenX+=1; greenH-=1;
			yellowX+=1; yellowY+=1;
			blueY+=1; blueW-=1;	
		}else if(!mouseEntered && redW<190 && greenX>200 && yellowX>200 && blueW<190){
			redW+=1; redH+=1;
			greenX-=1; greenH+=1;
			yellowX-=1; yellowY-=1;
			blueY-=1; blueW+=1;
		} //else timer.stop();
		
		revalidate();
		repaint();
	}

	public void mouseEntered(MouseEvent e){ 
			timer.start();
			mouseEntered = true;
	}
	public void mouseExited(MouseEvent e){
		mouseEntered = false;
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){ timer.start();}
	public void mousePressed(MouseEvent e){ timer.stop();}	
}