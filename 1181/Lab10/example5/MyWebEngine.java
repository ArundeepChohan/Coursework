import java.util.*;
import java.net.*;
import java.io.*;
public class MyWebEngine{
    public static void main (String[] args) throws /*MalformedURLException,*/ IOException {
        int count = 0;
        while(count<2){
            count++;
            try{
                        // String address = "http://java.sun.com/index.html";
                	String address = "http://www.langara.bc.ca/index.html";

  		Socket u = new Socket("www.langara.bc.ca", 80);					
                //URL u = new URL(address);
            //    URLConnection conn = u.openConnection();
                InputStream stream = u.getInputStream();
                Scanner  in = new Scanner(stream);
                while(in.hasNextLine())
                    System.out.println(in.nextLine());
            }catch (ConnectException e){
                System.out.println("time out:"+count);
            }
        }            
    }
}
