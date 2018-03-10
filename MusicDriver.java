//I guess this is a thing. -Kwu
//imports
import javax.swing.JFrame;


public class MusicDriver
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Pirated Music Player");
      frame.setSize(640, 480);
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MusicPanelMain());
      frame.setVisible(true);
   }
}