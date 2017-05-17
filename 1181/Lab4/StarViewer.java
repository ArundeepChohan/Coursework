/** 
Filename: StarViewer.java
Written by Arundeep Chohan
Written on Oct,9,2012
Course:CPSC 1181-001
Instructor:Hossein Darbandi
This program displays the stars in a jFrame
*/
import javax.swing.JFrame;
public class StarViewer
{
   //initializes the size of the frame
   private static final int FRAME_WIDTH = 600;
   private static final int FRAME_HEIGHT = 600;
      
   /**
      This method creates a jFrame and adds the StarComponent
      */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Stars");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      StarComponent component = new StarComponent();
      //adds component to frame and draws out the stars on the frame
      frame.add(component);
      frame.setVisible(true);
   }
      /**
            This method returns the height of the frame
            */
      public static int getFrameHeight()
      {
         return FRAME_HEIGHT;
      }
      /**
            This method returns the width of the frame
            */
      public static int getFrameWidth()
      {
         return FRAME_WIDTH;
      }
}

