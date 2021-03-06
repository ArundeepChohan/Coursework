/** 
Filename: Knight.java
Written by Arundeep Chohan
Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program is used to create Piece Knight
*/
import java.util.*;
import javax.swing.ImageIcon;  
import java.awt.Graphics2D; 
import java.awt.Image;
import java.awt.image.ImageObserver; 
import static java.lang.Math.*;

public class Knight extends Piece
{
   /**
      Initializes private variables
      */
   private int row;
   private int col;
      
   /**
      Sets piece to team, x, y coordinates
      @param x the location to be placed
      @param y the location to be placed
      @param team the team to be set to
      */      
   public Knight(char team,int x,int y)
   {
      this.team = team;
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
      ImageIcon blackKnight= new ImageIcon("image/bKn.png");
      Image im = blackKnight.getImage();
      ImageIcon whiteKnight = new ImageIcon("image/wKn.png");
      Image im2= whiteKnight.getImage();
      
      if(this.team=='b')
         g.drawImage(im,(col*this.Off_Set)+this.Off_Set,(row*this.Off_Set)+this.Off_Set, observer);
      else
         g.drawImage(im2,(col*this.Off_Set)+this.Off_Set,(row*this.Off_Set)+this.Off_Set,observer);
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
      if(Math.abs(from_row-to_row)==2&&Math.abs(from_col-to_col)==1)//abs
         return true;
      if(Math.abs(from_row-to_row)==1&&Math.abs(from_col-to_col)==2)
         return true;
      
      return false;
   }
   
}
