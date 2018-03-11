//Playlist Creator
//imports 
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class SongPlaylist extends JPanel
{
   private File FileWithPlaylists;
   public SongPlaylist() throws Exception
   {
      FileWithPlaylists = new File("playlists.txt");
      Scanner infile = new Scanner( new File("playlists.txt") );
      int numberOfPlaylists = Integer.parseInt(infile.next());
   }
}