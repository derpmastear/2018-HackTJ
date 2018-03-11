//I guess this is a thing. -Kwu
//imports
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.lang.*;

public class MusicDriver
{
   public static void main(String[] args) throws Exception
   {
      try 
      { 
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
      } 
      catch(Exception e){ 
      }
      JFrame frame = new JFrame("thiCS");
      frame.setSize(640, 480);
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MusicPanelMain());
      frame.setVisible(true);
   }
}