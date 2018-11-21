/**
Filename: Lab6.java
Written by<Arundeep Chohan>
Course: Cpsc 1150-001
Instructor: Hossein Darbandi
Compiler: Jdk 1.7
Hardware: Intel Core 2

This program gets a user inputted character array, coding and encodes the array with the coding.
It then prints out the binary representation of the encoded array. Futhermore it can take a binary message 
with coding and print out the original message.
*/
import java.util.*;
public class Lab6
{
   /*
      Maximum and minimum values of numbers to be coded.
      */
   final static int LOWERCASEMIN ='a';
   final static int LOWERCASEMAX ='z';
   final static int UPPERCASEMIN ='A';
   final static int UPPERCASEMAX ='Z';
   final static int DIGITMIN ='0';
   final static int DIGITMAX ='9';
   
   /** 
      Method main invokes other methods to get coding, msg, encoded values and get the binary representation of a number.
      @param args
      */
   public static void main (String[] args) 
   {
      char[] msg,encoded;
      String binary="";
      int coding;
      
      msg = myInput(); // Read the message from keyboard
      coding = getCoding();
      System.out.println("Coding is: " + coding); 
      printArray(msg);
      
      encoded = encode(msg,coding);
      printArray(encoded);
      
      binary = charToBinary(encoded);
      System.out.println(binary);
      System.out.println("---------");
      
      decode(binary,coding);
   }
   
   /** 
      Method myInput reads a line of message from keyboard and returns it as an array of char
      @return Array of characters 
      */
   public static char[] myInput()
   {
      String message;
      
      System.out.print("Input : ");
      Scanner input = new Scanner(System.in);
      message = input.nextLine();// Read a line of message
      
      return message.toCharArray();
   }  
   
   /**
      Method getCoding prompts user for proper input between 1 - 10 and returns the value.
      @return A positive integer value between 1 -10
      */
   public static int getCoding()
   {
      int coding;
      Scanner input = new Scanner(System.in);
      
      do
      {
         System.out.print("Enter an integer number between 1-10: ");
         coding = input.nextInt();
      }
      while(coding < 1 || coding > 10);
      
      return coding;
   }
   
   /**
      Method encode codes the original character array based on coding and returns the encoded version.
      @param msg :User inputted message to be encyrpted
      @param coding :User inputted positive number between 1 -10 for coding 
      @return An array of encoded characters 
      */
   public static char[] encode(char[] msg,int coding) 
   {
      int i,valueOfMsg,charShift; 
      char [] encode = new char[msg.length];
      
      for (i = 0; i < msg.length; i++)
      {
         valueOfMsg = msg[i];
         charShift = valueOfMsg + coding;
         //valueOfMsg is the int value of the msg to check for the range
         if(valueOfMsg >= LOWERCASEMIN && valueOfMsg<= LOWERCASEMAX)
            encode[i] = charShift(charShift,LOWERCASEMIN,LOWERCASEMAX);
         else if(valueOfMsg >= UPPERCASEMIN && valueOfMsg <= UPPERCASEMAX)
            encode[i] = charShift(charShift,UPPERCASEMIN,UPPERCASEMAX);
         else if(valueOfMsg >= DIGITMIN && valueOfMsg <= DIGITMAX )
            encode[i] = charShift(charShift,DIGITMIN,DIGITMAX );
         else
            encode[i] = msg[i];
      }
      
      return encode;
   }
   
   /**
      Method charShift converts a character to either its encoded value or decoded  value and returns that value.
      @param charShift :The value of where the character will move based on coding
      @param min :The minimum value of the range of the character
      @param max :The maximum value of the range of the character
      @return Encoded or decoded character
      */
   public static char charShift(int charShift,int min, int max)
   {
      /*
            If coding goes over max or under min it flips to the other side.
            'A' -1 -> 'Z'
            'Z' +1 -> 'A"
            */
      if(charShift > max)
         return (char)((min + (charShift)%max)- 1);
      else if(charShift < min)
      {
         return (char)(max - ((min - charShift)%(max - min))+1);
      }
      return (char)(charShift);
   }
   
   /**
      Method charToBinary returns the binary representation with 8 bits per character.
      @param encoded :The array of encoded character values
      @return String :A binary representation of a given message
      */
   public static String charToBinary(char[] encoded )
   {
      int valueOfMsg,i,j;
      String binary = "";
      String wholeBinary = "";
      
      for (i = 0; i < encoded.length; i++)
      {
         valueOfMsg = (int)encoded[i];
         binary = "";
         /*
                  Converts decimal value to binary representation with at least 8 bits.
                  B->  01000010
                  C ->  01000011
                  D -> 01000100
                  */
         for(j = 0;j < 8;j++)
         {
            binary = (valueOfMsg % 2) + binary;
            valueOfMsg = valueOfMsg / 2;
         }
         wholeBinary = wholeBinary + binary ;
      }
      return wholeBinary;
   }
   
   /**
      Method decode takes in a string divisible by 8, decodes the binary message and prints the original message on the screen.
      @param binary :The string representaion of a binary number
      @param coding :User inputted positive number between 1 -10 for coding 
      */
   public static void decode(String binary,int coding)
   {
      int i, j,valueOfMsg,charShift;
      String decoded = "";
      String bits ="";
      
      if((binary.length()%8) != 0)
      {
         System.out.println("Improper binary input");
         System.exit(0);
      }
      
      for (i = 0; i < binary.length()/8; i++) 
      {
         valueOfMsg = 0;
         bits = binary.substring(i*8,(i*8)+8);
         /*
                  Gets the integer value of every 8 bits
                  (1*2^7) + (0 * 2^6) ...........
                  */
         for(j = 0;j < bits.length();j++)
         {
           if(bits.charAt(j) == '1')
               valueOfMsg = valueOfMsg + (int)Math.pow(2,bits.length()-1-j);
         }
         
         charShift = valueOfMsg - coding;
         //valueOfMsg is the int value of the msg to check for the range
         if(valueOfMsg >= LOWERCASEMIN && valueOfMsg <= LOWERCASEMAX)
            decoded += charShift(charShift,LOWERCASEMIN,LOWERCASEMAX);
         else if(valueOfMsg >= UPPERCASEMIN && valueOfMsg <= UPPERCASEMAX)
            decoded += charShift(charShift,UPPERCASEMIN,UPPERCASEMAX);
         else if(valueOfMsg >= DIGITMIN && valueOfMsg <= DIGITMAX )
            decoded += charShift(charShift,DIGITMIN,DIGITMAX);
         else
            decoded += (char)(valueOfMsg);
      }
      System.out.println(decoded);
   }
   
   /**
      Method printArray prints out the array.
      @param array :An array to be printed
      */
   public static void printArray(char[] array)
   {
      int i;
      
      for(i = 0;i < array.length;i++)
      {
         System.out.println(array[i]);
      }
      System.out.println("\n-----------");
      
   }
}
