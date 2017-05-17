/* Class Args read a number from argument list and print its square.

   to run the program after compiling type:   java Args 30 in command window.

*/

public class Args

{

   public static void main (String[] args)

  {

     double aNumber=0;

     // Read input argument

     if (args.length < 1){ 

        System.out.println("Input a number"); 

        System.exit(0); // Terminate the program if user has not input a number

      }

      else

        aNumber = Double.parseDouble(args[0]); 

     

     // Your codes go here

     System.out.println(aNumber*aNumber); // Sample output to test the program

      

  }

}


