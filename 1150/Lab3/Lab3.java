/**
Filename: Lab3.java
Written by<Arundeep Chohan>
Contact: arundeepchohan2009@hotmail.com
Written on<Sept, 24,2013>
Course: Cpsc 1150-001
Instructor: Hossein Darbandi
Compiler: Jdk 1.7
Hardware: Intel Core 2

This program calculates how long it would take for iBalance to get under 0 and displays answer in proper format
*/
public class Lab3
{
   public static void main (String[] args)
  {
      // Assigning and declaring variables
      final double INTEREST_RATE = 1 + (0.06/12);
      final double WITHDRAW = 500;
      int year;
      int month;
      double iBalance = 0;
      double firstMonthsInterest;
     
      // Read input argument
      if (args.length < 1)
      {
         System.out.println("Input a number"); 
         // Terminate the program if user has not input a number
         System.exit(0); 
      }
      else
         // iBalance gets the value of user input
        iBalance  = Double.parseDouble(args[0]); 
      
      // Your codes go here
      // if interestRate > withdraw iBalance will loop infinitely due to always increasing or staying the same
      firstMonthsInterest = iBalance * (INTEREST_RATE - 1);
      if(firstMonthsInterest >= WITHDRAW )
      {
         System.out.println("Infinite Loop"); 
         System.exit(0);
      } 
      
      //loops for Balance so it goes under 0, increments month by 1 
      for (month = 0;iBalance > 0 ;month++)
      {
         //System.out.println(iBalance); 
         iBalance *= INTEREST_RATE;
         //System.out.println(iBalance); 
         iBalance -= WITHDRAW;
         //System.out.println(iBalance); 
      }
      
      //gets month and converts to years as it is a integer it would return 1st whole number
      year = month/12;
      month %=12;
      
      //saying to display years or months if there is a value greater then 0 for either or both
      if ((year > 1) && (month > 1))
        System.out.println(year + " years and "+month +" months");
      else if ((year > 1) && (month == 1))
         System.out.println(year + " years and "+month +" month");
      else if ((year > 1) && (month == 0))
         System.out.println(year + " years ");
      else if((year == 1) && (month > 1))
         System.out.println(year + " year and "+month +" months"); 
      else if ((year == 1) && (month == 1))
         System.out.println(year + " year and "+month +" month");
      else if ((year == 1) && (month == 0))
         System.out.println(year +" year");
      else if ((year == 0) && (month > 1))
         System.out.println(month +" months");
      else if((year == 0) && (month == 1))
         System.out.println(month +" month");
      else
         System.out.println("No time has passed");
   }
}
               // Sample output to test the program