/** 
Filename: King.java
Written by Arundeep Chohan
Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program is used to create Piece King
*/
import java.util.*;
import javax.swing.ImageIcon;  
import java.awt.Graphics2D; 
import java.awt.Image;
import java.awt.image.ImageObserver; 
import java.awt.Color; 

public class King extends Piece
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
   public King(char team,int x,int y)
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
      ImageIcon blackKing = new ImageIcon("image/bK.png");
      Image im = blackKing.getImage();
      ImageIcon whiteKing = new ImageIcon("image/wK.png");
      Image im2= whiteKing.getImage();
      
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
      int moveY=from_row-to_row;
      int moveX=from_col-to_col;
      
      return ((Math.abs(moveY)<2)&&(Math.abs(moveX)<2));//abs
   }
}
