/** 
Filename: Lab1.java
Written by Arundeep Chohan

Course:CPSC 1181-001
Instructor:Hossein Darbandi
*/
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.text.DecimalFormat;
public class Lab1
{
/** This program prompts user for input(weight and height) and determines bmi along with message indicating status of bmi
*/
  public static void main (String[] args)  
{
   int commaIndex=0;
   double height=0,weight=0;
   String input = JOptionPane.showInputDialog("Enter your weight in pounds followed by a comma followed by your height in inches");
   String nStr = input.trim();
	   System.out.println(nStr);
   boolean check=check(nStr);
   while (check==false)  //
   {
      System.out.println("Input is incorrect");
	String temp =JOptionPane.showInputDialog("(Input was incorrect)Enter your weight in pounds followed by a comma followed by your height in inches");
	nStr= temp.trim();
	check=check(nStr);
   }
   commaIndex = nStr.indexOf(',');             //  Finds the index of the comma and splits the string into 2 Strings   
      System.out.println("The commaIndex is:"+commaIndex);
   String n1 = nStr.substring(0,commaIndex);
   String n2 = nStr.substring(commaIndex+1);
      System.out.println("The weight entered is:"+n1);
      System.out.println("The height entered is:"+n2);
     
   int locationOfApostrophe= n2.indexOf("'");   //  Uses the index of the apostrophe to determine if height is in feet or inches or both 
      System.out.println("The location of any apostrophes:"+locationOfApostrophe);
   if(locationOfApostrophe >=0)
   {
      System.out.println("You have found an apostrophe at index:"+locationOfApostrophe+".You have entered your height in feet and inches.");
   String n3 =(n2.substring(0,locationOfApostrophe));
   String n4 =(n2.substring(locationOfApostrophe+1));
      System.out.println(n3);
      System.out.println(n4);
   height = feetToInches(n3,n4);
   }
   else
   {
      System.out.println(locationOfApostrophe+" is a terminating value, you have found no apostrophes therefore your height was entered in inches."); 
   height = Double. parseDouble(nStr.substring(commaIndex+1));
   }
   weight = Double. parseDouble(nStr.substring(0,commaIndex));
      System.out.println("Your height: "+height);
      System.out.println("Your weight: "+weight);
  if(weight<=0||height<=0)                     // If weight or height are negative values or zero than terminates program
  {
     System.out.println("Your height or weight was an incorrect value.Terminating program.");
     System.exit(0);
  }
 
   NumberFormat formatter = new DecimalFormat("#.#");  // formats number to round to 1 decimal point
   String formattedBMI=formatter.format(bmi(weight,height));
   Double bmi=Double. parseDouble(formattedBMI);
      System.out.println("Bmi before rounding is "+bmi(weight,height));
      System.out.println("Bmi after rounding is "+bmi);
   String msg = message(bmi);
   JOptionPane.showMessageDialog(null," "+"With a weight of "+weight+" lbs"+" and a height of "+height+" inches."+
  "Your bmi is "+bmi+msg);
   
  }

/**  
This method checks if the string is an appropriate input
 @param  nStr A String obtained from input
 @return  check A boolean indicating if string is an appropriate input
*/ 
public static boolean check(String nStr)
{
   boolean check = true;
      if(nStr.indexOf(",")==-1||nStr.lastIndexOf(",")!=nStr.indexOf(",")||nStr.lastIndexOf("'")!=nStr.indexOf("'"))
      {
         return false;
      }	
      
   for(int i =0; i < nStr.length();i++)
      if((nStr.charAt(i) =='.')||(nStr.charAt(i) ==',')||(i==nStr.indexOf("'"))) //checks if input are numbers or decimal,comma,apostrophes
         check =true;
      else if((nStr.charAt(i)>='0') &&(nStr.charAt(i)<='9'))
         check = true;
      else if(nStr.indexOf(",")<nStr.indexOf("'"))
	      check = true;
      else 
      {
         check = false;
         break;
      }
     
      return check;
}

 /**  
This method converts everthing into inches
 @param  part1 String of Feet
 @param  part2 String of Inches
 @return  Double A value of inches from total feet + inches
*/ 
  public static double feetToInches(String part1,String part2)
  {
   Double feet = Double. parseDouble(part1);
   Double inches = Double. parseDouble(part2);
   return (feet*12)+inches;
  }
  
/**  
This method returns a message based on your bmi
 @param  bmi formatted bmi to 2 decimal places
 @return String message indicating status of bmi
*/ 
public static String message(double bmi)
{
   if(bmi>30)
      return  ":A BMI of greater than 30 indicates obesity. If you are obese, try consulting a doctor or losing weight.";
   else if(bmi==30)
      return " :Indicates Borderline between obese and overweight";
   else if((bmi>=25) && (bmi<30))
      return  ":A BMI between 25 and 29.9 suggests you are overweight for your height.";
   else if((bmi>=18.6) &&(bmi<25))
      return  ":A BMI between 18.6 and 24.9 indicates you are at a healthy weight.";
   else if((bmi<18.6) && (bmi>=18))
      return  ":A BMI of less than 18.6 indicates you are thin for your height.";
   else
      return ":A BMI of less than 18 means you are under weight.";
  }
  
/**  
This method calculates the bmi and returns the calculated bmi
 @param  weight Double value obtained from string before comma
 @param  height Double value obtain from string after comma
 @return bmi Double value obtained from calculating the bmi
*/
  public static double bmi(double weight,double height)
  {
     double bmi=(weight/(Math.pow(height,2)))*703;
     return bmi;
  }
}
