/** 
Filename: Vehicle.java
Written by Arundeep Chohan
Written on Oct,30,2012
Course:CPSC 1181-001
Instructor:Hossein Darbandi

Class for drawing and movement
*/
import java.awt.Graphics2D;

public abstract class Vehicle 
{
   public Vehicle(){}//used to declare Vehicles
      
   protected int xLeft;//used to find position and direction of vehicle
   protected int yTop;
   protected boolean isMovingUp;
   protected boolean isMovingRight;
      
   public abstract void draw(Graphics2D g2);//sets movement and draws shape
   public abstract void up();
   public abstract void right();
   public abstract void movement();
}
