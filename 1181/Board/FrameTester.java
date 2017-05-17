import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
   This program demonstrates how to install an action listener.
*/
public class FrameTester
{  
	public static void main(String[] args)
	{  
		JFrame frame = new JFrame();
	
		DrawImageTester theImgTester = new DrawImageTester(); 
		frame.add(theImgTester);
     
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 600;
}
