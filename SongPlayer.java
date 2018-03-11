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
   private boolean gotMusic;
   private MediaPlayer player;
   //Frontend Things
   private JButton play;
   private JButton pause;
   private JButton stop;
   public SongPlayer() throws Exception//The file path
   {
      setLayout(new BorderLayout());
      Scanner infile = new Scanner( new File("directory.txt") );
      boolean checker = true;
      File directory = new File("directory.txt");
      if(directory.length() == 0)
      {
         checker = false;
      }
      if(checker)
      {
         String s = infile.next();
         getSongs(s);
      }
      JPanel SouthPanel = new JPanel();
      add(SouthPanel, BorderLayout.SOUTH);
      ImageIcon playicon = new ImageIcon("play.png");
      play = new JButton(playicon);
      SouthPanel.add(play);
      play.addActionListener(new PlayListener());
      ImageIcon pauseicon = new ImageIcon("pause.png");
      pause = new JButton(pauseicon);
      SouthPanel.add(pause);
      pause.addActionListener(new PauseListener());
      ImageIcon stopicon = new ImageIcon("stop.png");
      stop = new JButton(stopicon);
      SouthPanel.add(stop);
      stop.addActionListener(new StopListener());
      play.setEnabled(true);
      pause.setEnabled(false);
      stop.setEnabled(false);
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
      gotMusic = true;
   }
   public void play() throws NoSuchElementException
   {
      try{
         boolean checker = true;
         File directory = new File("directory.txt");
         Scanner infile = new Scanner( new File("directory.txt") );
         if(directory.length() == 0)
         {
            JOptionPane.showMessageDialog(null, "You have not chosen a directory yet!", "Error", JOptionPane.ERROR_MESSAGE);
            checker = false;
         }
         if(!gotMusic && checker)
         {
            String s = infile.next();
            getSongs(s);
            player = new MediaPlayer(currentSong);
            player.play();
            play.setEnabled(false);
            pause.setEnabled(true);
            stop.setEnabled(true);
         }
      }
      catch(NoSuchElementException e){
      }
      catch(FileNotFoundException e){
      }
   }
   public void stop() throws NoSuchElementException
   {
      player.stop();
   }
   public void pause() throws NoSuchElementException
   {
      player.pause();
   }

   private class PlayListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
         play();
      }
   }
   private class PauseListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
         pause();
         play.setEnabled(true);
         pause.setEnabled(false);
         stop.setEnabled(true);
      }
   }
   private class StopListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
         stop();
         play.setEnabled(true);
         pause.setEnabled(false);
         stop.setEnabled(false);
      }
   }

}