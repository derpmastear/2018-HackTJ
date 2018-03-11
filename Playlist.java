import java.util.*;

public class Playlist
{
   private String myName;
   private ArrayList mySongs;
   public Playlist(String name)
   {
      mySongs = new ArrayList();
      myName = name;
   }
   public void addSong(Sound s)
   {
      mySongs.add(s);
      //adds the song on to the end
   }
   public void insertSong(Sound s, int a)
   {
      mySongs.add(a, s);
      //adds the song in an exact location
   }
   public void removeSong(int a)
   {
      mySongs.remove(a);
      //removes a specific song from the list
   }
}
