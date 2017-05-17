import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
   An action listener that prints a message.
*/
public class ClickListener implements ActionListener
{
   private int id;
   public ClickListener (int id){
		this.id = id;
	}  
   public void actionPerformed(ActionEvent event)
   {
		JButton theB= (JButton)event.getSource();
		String str = theB.getText();
   //   System.out.println(" clicked.");
	 System.out.println(str);

   }            
}
