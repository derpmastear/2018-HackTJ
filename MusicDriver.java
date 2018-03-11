//I guess this is a thing. -Kwu
//imports
import javax.swing.JFrame;
import javax.swing.UIManager.*;

public class MusicDriver
{
   public static void main(String[] args)
   {
      try {
         for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (Exception e) {
      // If Nimbus is not available, you can set the GUI to another look and feel.
      }
      JFrame frame = new JFrame("thiCS");
      frame.setSize(640, 480);
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MusicPanelMain());
      frame.setVisible(true);
   }
}