//Song platter
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

public class SongPlayer extends JPanel 
{
   //Backend Things
   private Media currentSong;
   private File[] listOfFiles;
   private ArrayList<Media> listOfAllSongs;
   //Frontend Things
   private JButton play;
   public SongPlayer() throws Exception//The file path
   {
      setLayout(new BorderLayout());
      Scanner infile = new Scanner( new File("directory.txt") );
      boolean checker = true;
      File directory = new File("directory.txt");
      if(directory.length() == 0)
      {
         JOptionPane.showMessageDialog(null, "You have not chosen a directory yet!", "Error", JOptionPane.ERROR_MESSAGE);
         checker = false;
      }
      if(checker)
      {
         String s = infile.next();
         getSongs(s);
      }
      JPanel SouthPanel = new JPanel();
      add(SouthPanel, BorderLayout.SOUTH);
      play = new JButton("Play!");
      SouthPanel.add(play);
      play.addActionListener(new PlayListener());
   }
   public void getSongs(String s)
   {
      File folder = new File(s);
      File[] listOfFiles = folder.listFiles();
  
      listOfAllSongs = new ArrayList<Media>();
      for(int a= 0; a < listOfFiles.length; a++)
      {
         listOfAllSongs.add(new Media(listOfFiles[a].getPath()));
      }
      currentSong = listOfAllSongs.get(1);
   }
   public void play()
   {
      MediaPlayer player = new MediaPlayer(currentSong);
      player.play();
   }
     private class PlayListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         play();
      }
   }

}