/** 
Filename: MyTimeViewerjava
Written by Arundeep Chohan

Course:CPSC 1181-001
Instructor:Hossein Darbandi

Construct a frame to hold timer component
*/
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyTimerViewer
{
   private static final int FRAME_WIDTH = 800;
   private static final int FRAME_HEIGHT = 600;
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("My Vehicle");
      frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      MyTimer comp = new MyTimer();
      frame.add(comp);
      frame.setVisible(true);
   }
 }
