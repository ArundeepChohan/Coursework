/**
Filename: Lab4.java
Written by<Arundeep Chohan>
Contact: arundeepchohan2009@hotmail.com
Written on<Oct, 1, 2013>
Course: Cpsc 1150-001
Instructor: Hossein Darbandi
Compiler: Jdk 1.7
Hardware: Intel Core 2

This is a program which prompts user for input from a given menu then it proceeds to prompt user based upon the selection. 
It calculates the perimeter of a triangle or a circle or ends the program.
*/
import java.util.*;
public class Lab4
{
   
   final static double PI = 3.14;
   final static double EPSILON = 0.0001;//Small threshold to test collinearness of a triangle
   
   /** 
      Method main takes a value from method myMenu and invokes an appropriate response
      @param  args
      */
   public static void main (String[] args)  
   {
      // Assigning and declaring variable userOption
      int userOption = 0;
      
      // Sample code to test myMenu
      do 
      {
         userOption = myMenu();
         System.out.println("User selected Option "+userOption);
         // Method call if userOption condition is true
         if (userOption == 1)
            triangle();
         else if (userOption == 2)
            circle();
         else 
         {
            System.out.println("Bye");
            System.exit(0);
         }
      } 
      while (userOption !=3);  
   }
   
   /** 
      Method myMenu displays three options to be selected by keyboard and it 
      returns user selection as an integer number between the values of 1-3.  
      @return selected option: integer 1 or 2 
      */
   public static int myMenu()
   {
      Scanner myInput = new Scanner(System.in);
      int userOption;
      
      // Asks for input and returns userOption
      System.out.println("Options:");  
      System.out.println(" 1. Triangle");  
      System.out.println(" 2. Circle");  
      System.out.println(" 3. Exit");
      
      do
      {
         System.out.println("Select one of the following options:");
         userOption = myInput.nextInt();
      }
      while(userOption != 1 && userOption != 2 && userOption != 3 );
      // To read a number of type float, use : myInput.nextFloat();
      // To read a character use : (myInput.next()).charAt(0)
      
      return userOption;
   }
   
   /**   
      Method triangle prompts user for x, y cordinates, invokes methods checks to 
      see if its  collinear then invokes other methods to calculate the perimeter.
      */
   public static void triangle()
   {
      Scanner myInput = new Scanner(System.in);
      
      // Assign and declare variables(x1,x2,x3,y1,y2,y3) for user inputs 
      double perimeterOfTriangle = 0;
      boolean isCollinear = true;
      double x1,x2,x3,y1,y2,y3;

      
      System.out.println("You have chosen Triangle.");
      System.out.println("Please enter the x-coordinate of point1:");
      x1 = myInput.nextDouble();
      System.out.println("Please enter the y-coordinate of point1:");
      y1 = myInput.nextDouble();
      System.out.println("Please enter the x-coordinate of point2:");
      x2 = myInput.nextDouble();
      System.out.println("Please enter the y-coordinate of point2:");
      y2 = myInput.nextDouble();
      System.out.println("Please enter the x-coordinate of point3:");
      x3 = myInput.nextDouble();
      System.out.println("Please enter the y-coordinate of point3:");
      y3 = myInput.nextDouble();
   
      final double test1 = Math.abs(x1 - x2);
      final double test2 = Math.abs(x1 - x3);
      final double test3 = Math.abs(x2 - x3);
      final double test4 = Math.abs(y1 - y2);
      final double test5 = Math.abs(y1 - y3);
      final double test6 = Math.abs(y2 - y3); 
      
      if(( test1 > EPSILON || test2 > EPSILON || test3 > EPSILON)&&( test4 > EPSILON || test5 > EPSILON || test6 > EPSILON))
      {
         isCollinear = false;
         perimeterOfTriangle = trianglePerimeter(x1,y1,x2,y2,x3,y3); 
      }
      else
      {
         perimeterOfTriangle = collinearValue(test1,test2,test3,x1,y1,x2,y2,x3,y3);
      }
      
      System.out.println("The statement: This Triangle is collinear is " + isCollinear +".");
      System.out.print("The perimeter of a Triangle with point1("+x1+" , "+y1+"),"); 
      System.out.print("point2("+ x2+" , "+y2+"), point3(" + x3 +" , "+y3+") is " + perimeterOfTriangle);
      System.out.println("");
   }
 
   /**   
      Method trianglePerimeter calculate the perimeter of a triangle and returns the perimeter.
      @param x1 :A double value of point1's x value of the triangle
      @param x2 :A double value of point2's x value of the triangle
      @param x3 :A double value of point3's x value of the triangle
      @param y1 :A double value of point1's y value of the triangle
      @param y2 :A double value of point2's y value of the triangle
      @param y3 :A double value of point3's y value of the triangle
      @return distance :The total value between the points of a triangle given its x,y coordinates
      */
   public static double trianglePerimeter(double x1,double  y1,double x2,double y2,double x3,double y3)
   {
      double distance = 0;
      
      //Returns the total distance between all points
      distance += Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
      distance += Math.sqrt(Math.pow((x1-x3),2)+Math.pow((y1-y3),2));
      distance += Math.sqrt(Math.pow((x2-x3),2)+Math.pow((y2-y3),2));

      return distance;
   }
   
   /** 
      Method collinearValue takes in values of the x,y coordinates and calculates the distance of a triangle reduced to a collinear line.
      @param test1 :Testing of collinearness
      @param test2 :Testing of collinearness
      @param test3 :Testing of collinearness
      @param x1 :A double value of point1's x value of the triangle
      @param x2 :A double value of point2's x value of the triangle
      @param x3 :A double value of point3's x value of the triangle
      @param y1 :A double value of point1's y value of the triangle
      @param y2 :A double value of point2's y value of the triangle
      @param y3 :A double value of point3's y value of the triangle
      @return double :A value consisting of the distance reduced to a line
      */
   public static double collinearValue(double test1,double test2,double test3,double x1,double y1,double x2,double y2,double x3,double y3)
   {
      if((test1 < EPSILON) && (test2 < EPSILON) && (test3 < EPSILON))
      {
         if(((y1 >= y2) && (y1 <= y3))||((y1 >= y2) && (y1 >= y3)))
            return Math.abs(y2 - y3);
         else if(((y2 >= y1) && (y2 <= y3))||((y2 <= y1) && (y2 >= y3)))
            return Math.abs(y1 - y3);
         else
            return Math.abs(y1 - y2);
      }
      else
      {
         if(((x1 >= x2) && (x1 <= x3))||((x1 >= x2) && (x1 >= x3)))
            return Math.abs(x2 - x3);
         else if(((x2 >= x1) && (x2 <= x3))||((x2 <= x1) && (x2 >= x3)))
            return Math.abs(x1 - x3);
         else
            return Math.abs(x1 - x2);
      }
   }
   
   /**   
      Method circle prompts user for a positive radius and invokes other methods to calculate the perimeter.
      */
   public static void circle()
   {
      Scanner myInput = new Scanner(System.in);
      
      //Assign and declare variables radius,perimeterOfCircle,centerX, centerY
      double perimeterOfCircle = 0;
      double centerX,centerY,radius;
      
      System.out.println("You have chosen Circle:"); 
      System.out.println("Enter center's x coordinate"); 
      centerX = myInput.nextDouble();
      System.out.println("Enter center's y coordinate"); 
      centerY = myInput.nextDouble();
      
      System.out.println("Enter radius"); 
      radius = myInput.nextDouble();
      //Make sure radius is a nonnegative value
      while (radius < 0)
      { 
        System.out.println("Enter a nonnegative radius"); 
        radius = myInput.nextDouble();
      }
        perimeterOfCircle = circlePerimeter(radius);
        System.out.println("The perimeter of the Circle("+centerX+" , "+centerY+") with radius: "+radius +" is " + perimeterOfCircle);
   }
   
   /**   
      Method circlePerimeter calculates the perimeter of a circle given a postive radius value.
      @param  radius :A postive number given by the user
      @return double :The value of the perimeter of a circle
      */
   public static double circlePerimeter(double radius)
   {
      //Return value of perimeter 
      return 2*PI*radius;
   }
   
}

       
  