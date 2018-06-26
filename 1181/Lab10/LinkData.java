/** 
Filename: LinkData.java
Written by Arundeep Chohan

Course:CPSC 1181-001
Instructor:Hossein Darbandi
This creates class LinkData
*/
public class LinkData 
{
   private String linkText;
   private String href;
   private String link;
      
   /**
      This method sets data of LinkData
      @param linkText The linkText of the line
      @param href The href of the line
      @param link The link of the line
      */   
   public LinkData(String linkText,String href,String link)
   {
      this.linkText=linkText;
      this.href=href;
      this.link=link;
   }
   
   /**
      This method retrieves the href
      @return String
      */
   public String getHref()
   {
      return href;
   }
   
   /**
      This method retrieves the link
      @return String
      */
   public String getLink()
   {
      return link;
   }
   
   /**
      This method retrieves the linkText
      @return String
      */
   public String getLinkText()
   {
      return linkText;
   }
}
