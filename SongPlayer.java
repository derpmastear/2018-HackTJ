//Song platter
import javax.swing.*;
public class SongPlayer extends JPanel 
{
   private String currentSong;
   private File[] listOfFiles;
   public SongPlayer() 
   {
      
   }
   public static getSongs()
   {
      File folder = new File("your/path");
      File[] listOfFiles = folder.listFiles();
   
      for (int i = 0; i < listOfFiles.length; i++) {
         if (listOfFiles[i].isFile()) {
            System.out.println("File " + listOfFiles[i].getName());
         } else if (listOfFiles[i].isDirectory()) {
            System.out.println("Directory " + listOfFiles[i].getName());
         }
      }
   }
}