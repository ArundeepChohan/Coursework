/** 
Filename: Board.java
Written by Arundeep Chohan
Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program is create the class Board
*/
import java.util.*;
import java.awt.Graphics2D; 
import java.awt.Graphics;  
import javax.swing.ImageIcon;  
import java.awt.Image;
import java.awt.image.ImageObserver;
import static java.lang.Math.*;

public class Board extends ChessBoard 
{
   /**
      Initializes private variables
      */
   private static Piece[][]board;
   private static final int SIZE = 8;
   private static final int Black_Back_Row=0;
   private static final int Black_Pawn_Row=1;
   private static final int White_Back_Row=SIZE-1;
   private static final int White_Pawn_Row=SIZE-2;  
   private static final int Off_Set =45; 
   private static final int Max_Size =405; 
   private static char TURN;
      
   ImageObserver observer;
   ImageIcon imIcon;
   
   /**
      This method sets the observer of Board
      @param observer The observer of Board
      */
   public Board(ImageObserver observer)
   {
      this.observer=observer;
   }
   
   /**
      This method sets the initial starting of the pieces on the board 
      */
   public void start()
   {
      this.TURN='w';
      board=new Piece[SIZE][SIZE];
      backPiece('b');
      backPiece('w');
      center();
      pawns('b');
      pawns('w');
   }
   
   /**
      This method sets the type and position of the back pieces
      @param type A char of w or b
      */
   public void backPiece(char type)
   {
      int x=0,y;
      if(type =='w')
         y = White_Back_Row;
      else
      {
         y = Black_Back_Row;
      }
      
      place(new Rook(type,x,y),x,y);
      x++;
      place(new Knight(type,x,y),x,y);
      x++;
      place(new Bishop(type,x,y),x,y);
      x++;
      place(new Queen(type,x,y),x,y);
      x++;
      place(new King(type,x,y),x,y);
      x++;
      place(new Bishop(type,x,y),x,y);
      x++;
      place(new Knight(type,x,y),x,y);
      x++;
      place(new Rook(type,x,y),x,y);
      x++;
   }
   
   /**
      This method sets the inner dimensions of the boards with empty pieces
      */
   public void center()
   {
      int x,y;
      for(y = Black_Pawn_Row+1;y < White_Pawn_Row;y++)
      {
         for(x = 0;x < SIZE;x++)
         {
            place(new Empty(x,y),x,y);
         }
      }
   }
   
   /**  
      This method sets the pawns type and starting position
      @param type Type of piece
      */
   public void pawns(char type)
   {
      int x,y;
      if(type =='w')
         y = White_Pawn_Row;
      else
         y = Black_Pawn_Row;
      for(x=0;x<SIZE;x++)
      {
         place(new Pawn(type,x,y),x,y);
      }
   }
  
   
   /**
      This method prints out the current boarder layout
      */
   public void print(Graphics2D g)
   {
      int y,x;
      for(y=0;y<SIZE;y++)
         for(x=0;x<SIZE;x++)
           look(x,y).paint(g);
   }
   
   /**
      This method prints out the current boarder layout
      @param g 
      */
   public void paint(Graphics2D g)
   {
      ImageIcon blackbg = new ImageIcon("image/black.png");
      Image im = blackbg.getImage();
      ImageIcon whitebg = new ImageIcon("image/white.png");
      Image im2= whitebg.getImage();
      
      int y,x,squareColor;
      
      //x=Off_Set/2;
      //y=Off_Set/2;
      //border(g,x,y);
      for(y=Off_Set;y<Max_Size;y+=Off_Set)
      {
         for(x=Off_Set;x<Max_Size;x+=Off_Set)
         { 
            squareColor=y+x;
            if(squareColor%2==1)//changes black/white square
               g.drawImage(im,y,x,observer);
            else
            {
               g.drawImage(im2,y,x,observer);
            }
         }
      }
      //y=Max_Size+(Off_Set/2)
      //x=Max_Size+(Off_Set/2)
      //board(g,x,y);
   }
   
   /**
      This method prints out the border
      @param g 
      @param x
      @param y
      */
   public void border(Graphics2D g,int x,int y)
   {
      
   }
   
   /**
      This method places the piece at the given x, y coordinates on the board
      @param Piece type of piece etc.Rook
      @param x the x location on the board
      @param y the y location on the board
      */
   public void place(Piece piece,int x,int y )
   {
      piece.move(x,y);
      board[y][x]=piece;
   }
   
   /**
      This method changes the turn 
      */
   public void turn()
   {
      if(this.TURN =='w')
         this.TURN = 'b';   
      if(this.TURN =='b')
         this.TURN = 'w';
   }
   //----------------------------------------------------------------------------------------------------------------------------------
   /**
      This method validates move according to location and turn
      @param from_col The x coordinate from the mousePressed
      @param to_col The x coordinate of the mouseReleased
      @param from_rowThe y coordinate from the mousePressed
      @param to_row The y coordinate of the mouseReleased
      @return boolean The value indicating if you can move this piece
      */
   public boolean validateMove(int from_col,int from_row,int to_col,int to_row)
   {
      if(range(from_col,from_row)==false||range(to_col,to_row)==false)
         return false;
      else if(look(from_col,from_row).team()!= this.TURN)
         return false;
       
      //~ if()//-->only Knight can bypass
         //~ if(inWay(from_col,from_rowl,to_col,to_rowl)==true) 
         //~ return false;
     
         return (look(from_col,from_row).movement(from_col,from_row,to_col,to_row));
   }
   /**
      This method validates move according to location 
      @param x The x coordinate
      @param y The y coordinate
      */
   public boolean range(int x,int y)
   {
		if(x<0||y<0||x>SIZE||y>SIZE)
			return false;
		return true;
   }
   /**
      This method validates move according to if a piece is in the way
      @param from_col The x coordinate from the mousePressed
      @param to_col The x coordinate of the mouseReleased
      @param from_rowThe y coordinate from the mousePressed
      @param to_row The y coordinate of the mouseReleased
      @return boolean The value indicating if you can move this piece
      */
   public boolean inWay(int from_col,int from_row,int to_col,int to_row)
   {
      int allYValues,allXValues,i,j=0;
      allYValues=Math.abs(from_row-to_row);
      allXValues=Math.abs(from_col-to_col);//abs
      
      if(allYValues>1)
      {
		if(allXValues>1)
		{
			for(i=1;i<allYValues;i++,j++)
			{
				if(look(from_row+i,from_col+j).team()!='e')
						return true;
			}
		}
		else
		{
			for(i=1;i<allYValues;i++)
			{
				if(look(from_row+i,from_col).team()!='e')
					return true; 
			}
		}
      }
      else
      {
         if(allXValues>1)
         {
            for(j=1;j<allXValues;j++)
            {
               if(look(from_row,from_col+j).team()!='e')
                     return true;
            }
         }
      }
      
      return false;
   }
   
   /**
      This method implements movement
      @param from_col The x coordinate from the mousePressed
      @param to_col The x coordinate of the mouseReleased
      @param from_rowThe y coordinate from the mousePressed
      @param to_row The y coordinate of the mouseReleased
      @return boolean The value indicating if you can move this piece
      */
   public void moveTo(int from_col,int from_row,int to_col,int to_row)
   {
      look(from_col,from_row).move(to_col,to_row);
      place(look(from_col,from_row),to_col,to_row);
      remove(from_col,from_row);
   }
 //----------------------------------------------------------------------------------------------------------------------------------
   /**
      This method sets x,y cooordinate board to Empty piece
      @param x The coordinate of x for removal of piece
      @param y The coordinate of y for removal of piece
      */
   public void remove(int x,int y )
   {
      place(new Empty(x,y),x,y);
   }
   
   /**
      This method return the piece at a given x,y location
      @param x The coordinate of x for the piece
      @param y The coordinate of y for the piece
      */
   public Piece look(int x,int y )
   {
      return board[y][x];
   }
}
