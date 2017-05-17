/** 
Filename: LinkFinder.java
Written by Arundeep Chohan
Written on Nov,20,2012
Course:CPSC 1181-001
Instructor:Hossein Darbandi
This creates class LinkFinder
*/
import java.util.*;
import java.net.*;
import java.io.*;
import java.util.*;
public class LinkFinder 
{
   private Scanner in;
   private ArrayList<LinkData> data = new ArrayList();
   private final String con1= "<a href=";
   private final String con2="http://www.";
   private final String con3="</a>";
   private final String con4="</li>";
   private final String con5= ".html";
      
   private int limit=20;
   private int count=0;
   /**
      This method changes the scanner and gets the information from the address 
      @param Scanner
      */   
   public LinkFinder(Scanner in) throws IOException 
   {
      this.in=in;
      getInfo();
      System.out.println("End of Data");
   }
   /**
      This method gets the information from the address and stores the information into an arrayList
      */ 
   public void getInfo() throws IOException 
   {
      String href="";
      String link="";
      String linkText="";
      while(in.hasNextLine())
      {
         href=in.nextLine();
         if(href.contains(con1)&&href.contains(con3)&&count<limit)//should print 20 Links at the start
         {
            href=fixHref(href);//basically gets a substring starting from href
            linkText=getLinkText(href);
            link=getLink(href);
            System.out.println(linkText);
            System.out.println(href);
            System.out.println(link);
            data.add(new LinkData(linkText,href,link));
            count++;
         }
      }
         in.close();
   }
   /**
      This method gets the href from the line
      @param href The line from the page
      @return String
      */ 
   public String fixHref(String href)
   {
      return href.substring(href.indexOf(con1)/*,href.indexOf(con4)*/);
   }
   
   /**
      This method gets the Link from the page
      @param href The line from the page
      @return String
      */
   public String getLink(String href)
   {
      String link="";
      link=href.substring(href.indexOf("=")+2,href.indexOf(">")-1);
      if(link.contains(con2)&&link.contains(con5))
         return link;
      if(link.contains(con2))
         return link+con5;
      if(link.contains(con5))
         return con2+link;
      
      return con2+link+con5;
   }
   
   /**
      This method gets the linkText from the page
      @param href The line from the page
      @return String
      */
   public String getLinkText(String href)
   {
      String linkText="";
      linkText=href.substring(href.indexOf(">"),href.indexOf(con3));
      return linkText;
   }
   
   /**
      This method saves the ArrayList of LinkData in the fileName provided
      @param fileName String name of file to search for or save to
      */
   public void save(String fileName)
   {
      try
      {
         File file = new File(fileName);
         PrintWriter out = new PrintWriter(file);
         out.println("<Normal File>");
         out.println("<head> <title> output of lab10 </title>");
         out.println("</body>"); 
         for(LinkData e:data)
         {
            //out.println(e.getLinkText());     //from what I saw these weren't printed
            out.println(e.getHref()); 
            //out.println(e.getLink()); 
         }
         out.println("</body>"); 
         out.println("</Normal File>");
         out.close();
      }
      catch(IOException e)
      {
         System.out.println("File not found");
      }
   }
   
   /**
      This method loads the content of the file into the the ArrayList of LinkData
      @param fileName String name of file to search for or save to
      */
   public void load(String fileName)
   {
      try
      {
         File file = new File(fileName);
         Scanner load = new Scanner(file);
         this.in =load;
         getInfo();
      }
      catch(IOException e)
      {
         System.out.println("File not found");
      }
      finally
      {
         in.close();
      }
   } 
   
   /**
      This method  saves the content of the ArrayList in a HTML format with extension html like: filename.html
      @param fileName String name of file to search for or save to
      */
   public void save2Html(String fileName)
   {
      try
      {
         File file = new File(fileName+con5);
         PrintWriter out = new PrintWriter(file);
         out.println("<html>");
         out.println("<head> <title> output of lab10 </title>");
         out.println("</body>"); 
         for(LinkData e:data)
         {
            //out.println(e.getLinkText());  //from what I saw these weren't printed
            out.println(e.getHref()); 
            //out.println(e.getLink()); 
            
         }
         out.println("</body>");
         out.println("</html>");
         out.close();
      }
      catch(IOException e)
      {
         System.out.println("File not found");
      }
   }
   
   /**
      This method sets the limit of matches
      @param x Max value of matches
      */
   public void setLimit(int x)
   {
      if(x>0)
         limit=x;
   }
   
   /**
      This method sorts through all possible searches 
      */
   public void googleSearch()
   {
      int x=count;
      int size=data.size();
      for(int i =0;i <limit&&x<size;i++)
      {
         try
         {
            URL u = new URL(data.get(x).getHref()); //attempting to open url,sends scanner to LinkFinder,catches exception
            URLConnection conn = u.openConnection();
            InputStream stream = conn.getInputStream();
            Scanner many = new Scanner(stream);
            in=many;
            getInfo();
            x++;
            size=data.size();
         }
         catch(IOException e)
         {
           System.out.println("File not found"); 
         }
         
      }
      
   }
}