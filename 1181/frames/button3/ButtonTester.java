import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
   This program demonstrates how to install an action listener.
*/
public class ButtonTester
{  
   public static void main(String[] args)
   {  
      JFrame frame = new JFrame();
      JButton button1 = new JButton("Click me 1!");
		JButton button2 = new JButton("Click me 2!");
		JPanel panel = new JPanel();
      panel.add(button1);
		panel.add(button2);
		frame.add(panel);
     
      ActionListener listener1 = new ClickListener(1);
	//	ActionListener listener2 = new ClickListener(2);
      button1.addActionListener(listener1);
		button2.addActionListener(listener1);

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   private static final int FRAME_WIDTH = 100;
   private static final int FRAME_HEIGHT = 60;
}
