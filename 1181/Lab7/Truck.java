/** 
Filename: Truck.java
Written by Arundeep Chohan

Course:CPSC 1181-001
Instructor:Hossein Darbandi

Class for drawing and movement of the truck
*/
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
 
/**
A truck shape that can be positioned anywhere on the screen.
*/
class Truck extends Vehicle
 {
   public static int WIDTH = 90;
   public static int HEIGHT = 45;
   private int xLeft;
   private int yTop;
   /**
      Constructs a truck with a given top left corner
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
      */
   public Truck(int x, int y,boolean isMovingUp,boolean isMovingRight)
   {
      this.xLeft = x;
      this.yTop = y;
      this.isMovingUp = isMovingUp;
      this.isMovingRight = isMovingRight;
   }

   /**
      Draws the truck
      @param g2 the graphics context
      */
   public void draw(Graphics2D g2)
   {
      Rectangle front 
            = new Rectangle(xLeft, yTop+10, 10, HEIGHT); 
      Rectangle body 
            = new Rectangle(xLeft+10, yTop, WIDTH, HEIGHT);      
      Ellipse2D.Double tire1 
            = new Ellipse2D.Double(xLeft, yTop + HEIGHT, 10, 10);
      Ellipse2D.Double tire2
            = new Ellipse2D.Double(xLeft +10, yTop + HEIGHT, 10, 10);
      Ellipse2D.Double tire3
            = new Ellipse2D.Double(xLeft +20, yTop + HEIGHT, 10, 10);
      Ellipse2D.Double tire4
            = new Ellipse2D.Double(xLeft +(WIDTH-20), yTop + HEIGHT, 10, 10);
      Ellipse2D.Double tire5
            = new Ellipse2D.Double(xLeft +(WIDTH-10), yTop + HEIGHT, 10, 10);
     
      
      g2.draw(front);
      g2.draw(body);
      g2.draw(tire1);
      g2.draw(tire2);
      g2.draw(tire3);
      g2.draw(tire4);
      g2.draw(tire5);
      
      up();
      right();
      movement();
     
   }
   
   /**
      This method changes the x,y coordinates based on movement
      */ 
   public void movement()
   {
      if(this.isMovingUp == true)
      {
         if(this.isMovingRight == true)
         {
            this.xLeft+=WIDTH;
            this.yTop+=HEIGHT;
         }
         else
         {
            this.xLeft-=WIDTH;
            this.yTop+=HEIGHT;
         }
      }
      else 
      {
         if(this.isMovingRight == true)
         {
            this.xLeft+=WIDTH;
            this.yTop-=HEIGHT;
         }
         else
         {
            this.xLeft-=WIDTH;
            this.yTop-=HEIGHT;
         }
      }
   }
   
   /**
      Changes direction on collision
      */
   public void up()
   {
      if(this.yTop+HEIGHT >= 600)
         this.isMovingUp = false;
            
      if(this.yTop-HEIGHT <= 0)
         this.isMovingUp = true;
   }
   
   /**
      Changes direction on collision
      */
   public void right()
   {
      if(this.xLeft+WIDTH >= 800)
         this.isMovingRight = false;
            
      if(this.xLeft-WIDTH<=0)
         this.isMovingRight = true;
     
   }

 }
