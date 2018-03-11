//Playlist Creator
//imports 
import javax.swing.*;
import java.lang.*;

public class SongPlaylist extends JPanel
{
   private File FileWithPlaylists;
   public SongPlaylist() 
   {
      FileWithPlaylists = new File("playlists.txt");
      Scanner infile = new Scanner( new File(filename) );
      int numberOfPlaylists = infile.next();
   }
}