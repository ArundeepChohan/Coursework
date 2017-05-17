import java.util.*;
public class Main
{
   public static void main(String[]args)
   {
      int num1,num2;
      int that,sum;
      
      Scanner myInput = new Scanner(System.in);
      
      num1=myInput.nextInt();
      num2=myInput.nextInt();
      
      sum=num1;
      that=num2;
      
      Adder x =new Adder();
      x.calculate(1);
      System.out.println(x.evaluate());
      
      //~ sum+that;
      //~ sum-that;
      //~ sum*that;
      
   }
}