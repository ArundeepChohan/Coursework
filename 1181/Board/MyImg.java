import javax.swing.ImageIcon; 
import java.awt.Graphics2D; 
import java.awt.Image;
import java.awt.image.ImageObserver; 
import java.awt.Color; 



public class MyImg implements ChessPaint{
	ImageIcon imIcon;
	ImageObserver observer;
	int row;
	int col;
	         
	public MyImg(ImageObserver observer) {
	 	//this.row = row;
		//this.col = col;
		this.observer = observer;
		imIcon = new ImageIcon("image/black.png"); 
	}

	public void paint(Graphics2D g) {
	 	Image im = imIcon.getImage();
		int w= im.getWidth(observer);
		int h= im.getHeight(observer);
		g.drawImage(im, 50, 50,w,h, observer);  
		
		ImageIcon anoherOne = new ImageIcon("image/wQ.png");
		g.drawImage(anoherOne.getImage(), 50, 50,observer);    
	}

}

