/** 
Filename: MyTimer.java
Written by Arundeep Chohan

Course:CPSC 1181-001
Instructor:Hossein Darbandi

This program repaints the vehicles and creates an arrayList of vehicles
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.*;
import java.awt.*; 

public class MyTimer extends JComponent
{
  
   private int counter;
   private Timer t;
   private ArrayList<Vehicle> vehicles; 
      
   public MyTimer()
   {
      vehicles = new ArrayList<Vehicle>();//makes 10 vehicles
      int i;
      for(i=0;i<10;i++)
      {
         vehicles.add(randomVehicles());
      }
      counter =0;
      startTimer();
   }
  
   /**
      Starts the timer 
      */
   private void startTimer()
   {
      class TimerListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            counter++;
       //        if (counter >=60)
	    //		t.stop();
            repaint();
         }
      }
      t = new Timer(1000/60 /* 1000 milliSecond*/, new TimerListener());
      t.start(); 
   }
    
   /**
      This method prints out the vehicles
      */
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D)g;
      for(Vehicle e:vehicles)
         e.draw(g2);
   }
   
   /**
      This method generates the vehicles randomly
      */
   public Vehicle randomVehicles()
   {
      Random generator1 = new Random(getWidth());//highest x,y value possible
      Random generator2 = new Random(getHeight());
      Random generator3 = new Random(1);
      int i,j,x=0,y=0;
      boolean isMovingUp = true,isMovingRight = true;
      Vehicle vehicle;
      x = generator1.nextInt();
      y = generator2.nextInt();
      
      if(y>getHeight()/2)
         isMovingUp = true;
      else
         isMovingUp = false;
         
      if(x>getWidth()/2)
         isMovingRight = true;
      else
         isMovingRight = false; 
         
      j = generator3.nextInt();
      if(j == 0)
         vehicle = new Truck(x,y,isMovingUp,isMovingRight);
      else
         vehicle = new Car(x,y,isMovingUp,isMovingRight);
      
      return vehicle;
   }
   
}
