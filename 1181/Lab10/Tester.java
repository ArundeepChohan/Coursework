/** 
Filename: Tester.java
Written by Arundeep Chohan
Course:CPSC 1181-001
Instructor:Hossein Darbandi
This program tests LinkData and LinkFinder
*/
import java.net.*;
import java.io.*;
import java.util.*;
public class Tester
{
   public static void main (String[] args) 
   {
      try
      {
         URL u = new URL("http://langara.bc.ca/");//attempting to open url,sends scanner to LinkFinder,catches exception
         URLConnection conn = u.openConnection();
         InputStream stream = conn.getInputStream();
         Scanner  in = new Scanner(stream);
         LinkFinder lF= new LinkFinder(in);
         lF.save2Html("LinkFinder");
         //lF.load("");
         //lF.setLimit(50);
         //lF.googleSearch();
         lF.save("LinkFinder.txt");
      }
      catch(IOException e)
      {
         System.out.println("File not found");
      }
   }
}
