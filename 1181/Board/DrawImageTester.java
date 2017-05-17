import javax.swing.JApplet; 
import java.awt.Graphics2D; 
import java.awt.Graphics; 
import java.awt.Color; 
import javax.swing.JOptionPane; 
import javax.swing.JComponent;



// Sample image 
public class DrawImageTester extends JComponent
{
	    
	public DrawImageTester() {

	}
 		 
	public void paint(Graphics h) {
		Graphics2D g = (Graphics2D)h;
		
		//Clear backgroung 
		g.setBackground(Color.white);

		g.setColor(getBackground());
		g.fillRect(1, 1, getWidth(), getHeight());
 	
			   
		// draw 
		MyImg p1 =  new MyImg(this);
		p1.paint(g);  

	}
}

