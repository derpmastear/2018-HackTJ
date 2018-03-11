//I guess this is a thing. -Kwu
//imports
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.lang.*;
import javafx.embed.swing.JFXPanel;
public class MusicDriver
{
   public static void main(String[] args) throws Exception
   {
      try 
      { 
         new JFXPanel();
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
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