/** 
Filename: Piece.java
Written by Arundeep Chohan
Written on Nov,9,2012
Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program is used to create abstract class Piece
*/
import java.util.*;
import javax.swing.ImageIcon;  
import java.awt.Graphics2D; 
import java.awt.Image;
import java.awt.image.ImageObserver; 
import java.awt.Color; 

abstract class Piece implements ChessPaint 
{
   /**
      Initializes private variables
      */
   ImageObserver observer;
   ImageIcon imIcon;
   public char team;
   public static final int Off_Set =45;
      
   public Piece()
   {  
   }
   /**
      Prints out the image according to the team
      @param g   
      */
   abstract public void paint(Graphics2D g);
   /**
      Returns team 
      */  
   abstract public char team();
   /**
      This method validates move according to movement capablities
      @param from_col The x coordinate from the mousePressed
      @param to_col The x coordinate of the mouseReleased
      @param from_rowThe y coordinate from the mousePressed
      @param to_row The y coordinate of the mouseReleased
      @return boolean The value indicating if you can move this piece
      */
   abstract public boolean movement(int from_col,int from_row,int to_col,int to_row);
   /**
      Sets pieces(x,y) coordinates
      @param x the location to be placed
      @param y the location to be placed
      */
   abstract public void move(int x,int y);
}