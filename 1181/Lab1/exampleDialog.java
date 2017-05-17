/** program to demonstrate using JpOptionPan*/
import javax.swing.JOptionPane;
public class exampleDialog
{
  public static void main (String[] args)  {
    String nStr = JOptionPane.showInputDialog("Enter a number");
    Double n = Double. parseDouble(nStr); 
    Double n2 = Math.pow(n,2);	  
    JOptionPane.showMessageDialog(null,"the square of "+n + "= " +n2);

  }
}