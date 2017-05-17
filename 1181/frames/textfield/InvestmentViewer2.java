import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
   This program displays the growth of an investment. 
*/
public class InvestmentViewer2
{  
   public static void main(String[] args)
   {  
      JFrame frame = new JFrame();

      // The label and text field for entering the interest rate
      JLabel rateLabel = new JLabel("Interest Rate: ");

      final int FIELD_WIDTH = 10;
      final JTextField rateField = new JTextField(FIELD_WIDTH);
      rateField.setText("" + DEFAULT_RATE);

      // The button to trigger the calculation
      JButton button = new JButton("Add Interest");

      // The application adds interest to this bank account
      final BankAccount account = new BankAccount(INITIAL_BALANCE);

      // The label for displaying the results
      final JLabel resultLabel = new JLabel(
            "balance=" + account.getBalance());

      // The panel that holds the user interface components
      JPanel panel = new JPanel();
      panel.add(rateLabel);
      panel.add(rateField);
      panel.add(button);
      panel.add(resultLabel);      
      frame.add(panel);
  
      class AddInterestListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            double rate = Double.parseDouble(
                  rateField.getText());
            double interest = account.getBalance() 
                  * rate / 100;
            account.deposit(interest);
            resultLabel.setText(
                  "balance=" + account.getBalance());
         }            
      }

      ActionListener listener = new AddInterestListener();
      button.addActionListener(listener);

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   private static final double DEFAULT_RATE = 10;
   private static final double INITIAL_BALANCE = 1000;

   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 200;
}
