//Song platter
import javax.swing.*;
import java.io.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

public class SongPlayer extends JPanel 
{
   private String currentSong;
   private File[] listOfFiles;
   private Media[] listofAllSongs;
   public SongPlayer() 
   {
      
   }
   public static void getSongs()
   {
      File folder = new File("your/path");
      File[] listOfFiles = folder.listFiles();
  
      Media[] listOfAllMusic = new Media[listOfFiles.length];
      for(int a= 0; a < listOfFiles.length; a++)
      {
      }
   }
}