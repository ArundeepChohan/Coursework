/** 
Filename: Pawn.java
Written by Arundeep Chohan
Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program is used to create Piece Pawn
*/
import java.util.*;
import javax.swing.ImageIcon;  
import java.awt.Graphics2D; 
import java.awt.Image;
import java.awt.image.ImageObserver; 
import static java.lang.Math.*;

public class Pawn extends Piece
{
   /**
      Initializes private variables
      */
   private int row;
   private int col;
   private boolean isFirstTurn = true;
      
   /**
      Sets piece to team, x, y coordinates
      @param x the location to be placed
      @param y the location to be placed
      @param team the team to be set to
      */    
   public Pawn(char team,int x,int y)
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
      ImageIcon blackPawn = new ImageIcon("image/bP.png");
      Image im = blackPawn.getImage();
      ImageIcon whitePawn = new ImageIcon("image/wP.png");
      Image im2= whitePawn.getImage();
      
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
      int moveX=0,moveY;
      
      if(isFirstTurn)
         moveY=2;
      else 
         moveY=1;
      
      if(Math.abs(from_row-to_row)==moveY)//abs
      {
         this.isFirstTurn=false;
         return true;
      }
      
      if(Math.abs(from_row-to_row)==1)
      {
         this.isFirstTurn=false;
         return true;
      }
      
      return false;//put in after done abs
   }
}
