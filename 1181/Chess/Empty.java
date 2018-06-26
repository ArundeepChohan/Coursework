/** 
Filename:Empty.java
Written by Arundeep Chohan
Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program is used to create Piece Empty
*/
import java.awt.Graphics2D;
import java.util.*;
import javax.swing.ImageIcon;  
import java.awt.Image;
import java.awt.image.ImageObserver; 
import java.awt.Color; 

public class Empty extends Piece
{
   /**
      Initializes private variables
      */
   private int row;
   private int col;
   private char team ='e';
      
   /**
      Sets piece to team, x, y coordinates
      @param x the location to be placed
      @param y the location to be placed
      */
   public Empty(int x,int y)
   {
      this.team=team;
      row=y;
      col=x;
   }
   
   /**
      Sets pieces(x,y) coordinates
      @param x the location to be placed
      @param y the location to be placed
      */
   public void move(int x,int y)
   {
      row=y;
      col=x;
   }
   
   /**
      Prints out the image according to the team
      @param g   
      */
   public void paint(Graphics2D g)
   {
      
   }
   
   /**
      Returns team 
      */
   public char team()
   {
      return this.team;
   }
   
   /**
      This method validates move according to movement capablities
      @param from_col The x coordinate from the mousePressed
      @param to_col The x coordinate of the mouseReleased
      @param from_rowThe y coordinate from the mousePressed
      @param to_row The y coordinate of the mouseReleased
      @return boolean The value indicating if you can move this piece
      */
   public boolean movement(int from_col,int from_row,int to_col,int to_row)
   {
      return false;
   }
}
