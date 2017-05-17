/** 
Filename: Star.java
Written by Arundeep Chohan
Written on Oct,9,2012
Course:CPSC 1181-001
Instructor:Hossein Darbandi

This program calculates the position of the points in the star and draws the stars
*/
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.*; 
import javax.swing.*; 
import java.awt.geom.*;
/**
   A Star shape that can be positioned anywhere on the screen.
*/
public class Star
{
   /**
      Variables to calculate the location of the individual points of the star
      */
	private static final int radiusIncrement =-15;
	private final static double FACTOR = 2.63;
	private final static double ALFA = 18*Math.PI/180;
	private final static double BETA = 54*Math.PI/180;

	
	private final static double[] X = {0,Math.cos(BETA)/FACTOR, Math.cos(ALFA ),
                                            Math.cos(ALFA )/FACTOR,	Math.cos(BETA),0,
                                            -Math.cos(BETA),-Math.cos(ALFA)/FACTOR,
                                            -Math.cos(ALFA ),-Math.cos(BETA)/FACTOR,0};
                                            
	private final static double[] Y = {-1,-Math.sin(BETA)/FACTOR, -Math.sin(ALFA ),
                                            Math.sin(ALFA )/FACTOR,	Math.sin(BETA),1/FACTOR,
                                            Math.sin(BETA),Math.sin(ALFA )/FACTOR,
                                            -Math.sin(ALFA ),-Math.sin(BETA)/FACTOR,-1};
	
	private int[] xCoordOfStar; // x coordinates of the vertices of the star as pixel
	private int[] yCoordOfStar; // x coordinates of the vertices of the star as pixel			
									
   /**
	Calculates the coordinates of a 5 points star 
	@param radius, the length in pixel of each arm of the star from its center 
	@param x the x coordinate of the center of the star
	@param y the y coordinate of the center of the star
	*/
	public void setStartCoordinates(double radius , double x, double y)
   {
		xCoordOfStar = new int[X.length];
		yCoordOfStar = new int[Y.length];
		int i; 
		for(i = 0; i<X.length; i++)
      {
			xCoordOfStar[i] = (int)(radius*X[i]+x);
			yCoordOfStar[i] = (int)(radius*Y[i]+y);
		}	
	}
   
   /**
      This method calculates the start position of where to draw the star
      @param radius the radius to the outside of the star
      @param angle the angle to the pont on the perimeter of the circle
      @param x the given x coordinate of the origin
      @param y the given y coordinate of the origin
      */
   public void move(double radius, double angle, double x, double y)
   {
      double pX=0,pY=0;
      pX=x+((radius)*Math.cos(Math.toRadians(angle)));
      pY=y+((radius)*Math.sin(Math.toRadians(angle))); 
      radius=15;//outside star radius
      setStartCoordinates(radius,pX,pY);//moves start coordinates to new values
   }
   
   /**
      This method draws out the polygon,fills it with random colours and sets the borders
      @param g2 Graphics used for drawing
       */
   public void draw(Graphics2D g2)
   {
      final int maxColor=256;
      final double border =5.0;
      int i;
      int R = (int)(Math.random()*maxColor);
      int G = (int)(Math.random()*maxColor);
      int B= (int)(Math.random()*maxColor);
      g2.drawPolygon (xCoordOfStar, yCoordOfStar,X.length);
      Color color = new Color(R, G, B);
      g2.setColor(color);
      g2.setStroke(new BasicStroke((float)border));
      g2.fillPolygon(xCoordOfStar, yCoordOfStar,X.length);
   } 
}