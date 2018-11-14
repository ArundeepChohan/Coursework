/** 
Filename: Chess.java
Written by Arundeep Chohan
Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program implements a mouseListener for the ChessBoard componenet
*/
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Chess
{  
   /*
      Initializes private variables
      */
   private static int from_x;
   private static int from_y;  
   private static int to_x;
   private static int to_y;
   private static final int Off_Set = 45;
      
	private static final int FRAME_WIDTH =500;
	private static final int FRAME_HEIGHT = 500;
      
	public static void main(String[] args)
	{  
		JFrame frame = new JFrame();
		final ChessBoard board = new ChessBoard();
      	
	class MousePressListener implements MouseListener
	{  
		public void mousePressed(MouseEvent event)
		{  
			from_x = event.getX();//here I'm storing the x,y of the piece to be moved
			from_y = event.getY();
		}

		public void mouseReleased(MouseEvent event) 
		{
		    to_x = event.getX();//here I'm storing the x,y of the location to be moved to
		    to_y = event.getY();
		    
		    System.out.println();
		    System.out.println("X and y coordinates of from:"+from_x +" , "+from_y);
		    System.out.println("X and y coordinates of from:"+((from_x/Off_Set)-1) +" , "+((from_y/Off_Set)-1));
		    System.out.println();
		    System.out.println("X and y coordinates of where to go:"+to_x+" , "+to_y);
		    System.out.println("X and y coordinates of where to go:"+((to_x/Off_Set)-1)+" , "+((to_y/Off_Set)-1));
	   
		    //~ if(validateMove(((from_x/Off_Set)-1),((from_y/Off_Set)-1),((to_x/Off_Set)-1),((to_y/Off_Set)-1)))
		    //~ {
		       moveTo(((from_x/Off_Set)-1),((from_y/Off_Set)-1),((to_x/Off_Set)-1),((to_y/Off_Set)-1));
		    //~ }
		 }
         
		 // Do-nothing methods
		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
      }
         
      MouseListener listener = new MousePressListener();
      board.addMouseListener(listener);
      
		frame.add(board);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
