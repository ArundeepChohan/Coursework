/** 
Filename: StarComponent.java
Written by Arundeep Chohan

Course:CPSC 1181-001
Instructor:Hossein Darbandi
This program adds the stars into an arraylist and draws out the stars 
*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.*;
public class StarComponent extends JComponent
{
   public final int RADIUS_DECREMENT=-15;
   public final int LARGEST_RADIUS = 225;
   public final int STAR_RADIUS = 15;
   public final int NUM_OF_STARS = 10;
   public final int A_DECREMENT = 30;
   public final int POINT1 = 0,POINT2 = 90,POINT3 = 270,POINT4 = 360; 
   //points where we exclude them.....3,6,9,12 on a clock
   
   //Create an arrayList of stars
   ArrayList<Star>stars = new ArrayList<Star>();
   
   /**
      This method adds the stars into arrayList and draws them out sequentially
      @param  g Graphics used for drawing
      */
   public void paintComponent(Graphics g)
   {  
      //initializes variables
      int x,y;
      Graphics2D g2 = (Graphics2D) g;
   
      //start radius of where to draw the star
      x = (int)StarViewer.getFrameHeight()/2;//frame width
      y = (int)StarViewer.getFrameWidth()/2;//frame height
      
      //Creates the stars
      innerStars(x,y);
      outterStars(x,y);
      
      //Draws out the stars
      for(Star e:stars)
      {
         e.draw(g2);
      }
   }
   /**
      This method creates the inner stars starting from radius 225
      down to radius 15
      @param x the x coordinate of the origin
      @param y the y coordinate of the origin
      */
   public void innerStars(double x,double y)
   {
      double radius = LARGEST_RADIUS;
      for(;radius>STAR_RADIUS;)
      {
         Star star1 = new Star();
         star1.setStartCoordinates(radius,x,y);
         stars.add(star1);
         radius+=RADIUS_DECREMENT;
      }
   }
   
   /**
      This method creates 10 stars all around the origin
      @param x the x coordinate of the origin
      @param y the y coordinate of the origin
      */
   public void outterStars(double x,double y)
   {
      int i;
      double angle = 0;
      for(i = 0;i<NUM_OF_STARS;)
      {
         if(angle != POINT1 && angle != POINT2 && angle != POINT3 && angle <= POINT4)
         {
            Star star2 = new Star();
            //
            star2.move(LARGEST_RADIUS,angle,x,y);
            stars.add(star2);
            i++;
         }
         angle+=A_DECREMENT;
      }
   }
}
 
