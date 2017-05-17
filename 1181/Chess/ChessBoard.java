/** 
Filename: ChessBoard.java
Written by Arundeep Chohan
Written on Nov,9,2012
Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program is used to create ChessBoard 
*/
import javax.swing.JApplet; 
import java.awt.Graphics2D; 
import java.awt.Graphics;  
import javax.swing.JOptionPane; 
import javax.swing.JComponent;
import java.awt.Color; 

public class ChessBoard extends JApplet
{
	public ChessBoard() 
   {
      
	}
   
   /**
      Prints out Board
      @param g   
      */
   public void paint(Graphics h) 
   {
      Graphics2D g = (Graphics2D)h;
		
		//Clear background 
		g.setBackground(Color.white);

		g.setColor(getBackground());
		g.fillRect(1, 1, getWidth(), getHeight());
 	
		// draw 
      Board p1 =  new Board(this);
      p1.paint(g);//paints the background 
      p1.start();//populates the board
      //p1.print(g);//if testing take this one out else you'll print twice(image overlap)
                  //prints out current layout
      /*
            Testing the board class
            -->insert TestCases.java
            */
      //----------------------------------------------------
      //It is White's Turn
      System.out.println(p1.validateMove(0,0,1,1));//this is a black movement->false
      System.out.println(p1.validateMove(0,6,0,5));//this is a white movement->true
   
      //Testing if it can move to that piece
      p1.moveTo(0,6,0,5);//it should move a pawn(0,6) to (0,5)
      p1.print(g);
      p1.turn();
      
      //It is Black's Turn
      System.out.println(p1.validateMove(0,0,1,1));//this is a black movement->false
      System.out.println(p1.validateMove(0,6,0,5));//this is a white movement->false
      System.out.println(p1.validateMove(0,1,0,2));//this is a black movement->true
   }
	   
       
//~ //----------------------------------------------------------------------------------------------------------------------------------
   //~ /**
      //~ This method validates move according to location and turn
      //~ @param from_col The x coordinate from the mousePressed
      //~ @param to_col The x coordinate of the mouseReleased
      //~ @param from_rowThe y coordinate from the mousePressed
      //~ @param to_row The y coordinate of the mouseReleased
      //~ @return boolean The value indicating if you can move this piece
      //~ */
   //~ public boolean validateMove(int from_col,int from_row,int to_col,int to_row)
   //~ {
      //~ if(range(from_col,from_row)==false||range(to_col,to_row)==false)
         //~ return false;
      //~ else if(look(from_col,from_row).team()!= this.TURN)
         //~ return false;
       
      //~ if()//-->only Knight can bypass
      //~ {
         //~ if(inWay(from_col,from_rowl,to_col,to_rowl)==true) 
            //~ return false;
         //~ else
            //~ return (look(from_col,from_row).movement(from_col,from_row,to_col,to_row));
      //~ }
   //~ }
   //~ /**
      //~ This method validates move according to location 
      //~ @param x The x coordinate
      //~ @param y The y coordinate
      //~ */
   //~ public boolean range(int x,int y)
   //~ {
		//~ if(x<0||y<0||x>SIZE||y>SIZE)
			//~ return false;
		//~ return true;
   //~ }
   //~ /**
      //~ This method validates move according to if a piece is in the way
      //~ @param from_col The x coordinate from the mousePressed
      //~ @param to_col The x coordinate of the mouseReleased
      //~ @param from_rowThe y coordinate from the mousePressed
      //~ @param to_row The y coordinate of the mouseReleased
      //~ @return boolean The value indicating if you can move this piece
      //~ */
   //~ public boolean inWay(int from_col,int from_row,int to_col,int to_row)
   //~ {
      //~ int allYValues,allXValues,i,j;
      //~ allYValues=Math.abs(from_row-to_row);
      //~ allXValues=Math.abs(from_col-to_col);//abs
      
      //~ if(allYValues>1)
      //~ {
		//~ if(allXValues>1)
		//~ {
			//~ for(i=1;i<allYValues;i++,j++)
			//~ {
				//~ if(look(from_row+i,from_col+j).team()!='e')
						//~ return true;
			//~ }
		//~ }
		//~ else
		//~ {
			//~ for(i=1;i<allYValues;i++)
			//~ {
				//~ if(look(from_row+i,from_col).team()!='e')
					//~ return true; 
			//~ }
		//~ }
      //~ }
      //~ else
      //~ {
         //~ if(allXValues>1)
         //~ {
            //~ for(j=1;j<allXValues;j++)
            //~ {
               //~ if(look(from_row,from_col+j).team()!='e')
                     //~ return true;
            //~ }
         //~ }
      //~ }
      
      //~ return false;
   //~ }
   
   //~ /**
      //~ This method implements movement
      //~ @param from_col The x coordinate from the mousePressed
      //~ @param to_col The x coordinate of the mouseReleased
      //~ @param from_rowThe y coordinate from the mousePressed
      //~ @param to_row The y coordinate of the mouseReleased
      //~ @return boolean The value indicating if you can move this piece
      //~ */
   //~ public void moveTo(int from_col,int from_row,int to_col,int to_row)
   //~ {
      //~ look(from_col,from_row).move(to_col,to_row);
      //~ place(look(from_col,from_row),to_col,to_row);
      //~ remove(from_col,from_row);
   //~ }
 //----------------------------------------------------------------------------------------------------------------------------------

}