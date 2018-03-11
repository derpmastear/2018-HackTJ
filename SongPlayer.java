//Song platter
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import java.net.*;
import javax.swing.Timer;
import javafx.util.Duration;

public class SongPlayer extends JPanel 
{
   //Backend Things
   private Media currentSong;
   private int currentCount = 0;
   private ArrayList<Media> listOfAllSongs;
   private boolean gotMusic;
   private MediaPlayer player;
   private Timer timer;
   private Duration currentDur;
   
   //Frontend Things
   private JButton play;
   private JButton pause;
   private JButton stop;
   private JLabel time;
   private JLabel currSong;
   public SongPlayer() throws Exception//The file path
   {
      setLayout(new BorderLayout());
      Scanner infile = new Scanner( new File("directory.txt") );
      boolean checker = true;
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
      
      JPanel CenterPanel = new JPanel();
      add(CenterPanel, BorderLayout.CENTER);
      time = new JLabel("0:00");
      time.setFont(new Font("Dialog", Font.PLAIN, 18));
      CenterPanel.add(time);
      currentDur = new Duration(0);
      
      currSong = new JLabel("");
      CenterPanel.add(currSong);
   }
   public void getSongs(String s) throws MalformedURLException
   {
      File folder = new File(s);
      
   
      FilenameFilter txtFileFilter = 
         new FilenameFilter()
         {    
            @Override
            public boolean accept(File dir, String name)
            {
               if(name.endsWith(".mp3") || name.endsWith(".wav"))
               {
                  return true;
               }
               else
               {
                  return false;
               }
            }
         };
      File[] listOfFiles = folder.listFiles(txtFileFilter);
      listOfAllSongs = new ArrayList<Media>();
      
      for(int a= 0; a < listOfFiles.length; a++)
      {
         String t = listOfFiles[a].toURI().toURL().toString();
         //URI u = new URI(listOfFiles[a].getPath());
         listOfAllSongs.add(new Media(listOfFiles[a].toURI().toString()));
      }
      currentSong = listOfAllSongs.get(currentCount); //memes
      gotMusic = true;
   }
   public void play() throws NoSuchElementException
   {
      try{
         File directory = new File("directory.txt");
         Scanner infile = new Scanner( new File("directory.txt") );
         boolean check = false;
         if( player != null) {
            check = (player.getStatus() == MediaPlayer.Status.STOPPED);
         }
         if(!infile.hasNext())
         {
            JOptionPane.showMessageDialog(null, "You have not chosen a directory yet!", "Error", JOptionPane.ERROR_MESSAGE);
         }
         else if(player != null && (player.getStatus() == MediaPlayer.Status.PAUSED || player.getStatus() == MediaPlayer.Status.STOPPED)) {
            player.play();
            play.setEnabled(false);
            pause.setEnabled(true);
            stop.setEnabled(true);
            timer.start();
         }
         else if(!gotMusic)
         {
            String s = infile.nextLine();
            getSongs(s);
            player = new MediaPlayer(currentSong);
            player.seek(currentDur);
            player.play();
            play.setEnabled(false);
            pause.setEnabled(true);
            stop.setEnabled(true);
            timer = new Timer(1000, new TimeListener(player));
            timer.setInitialDelay(1000);
            timer.start();
         }
         player.setOnEndOfMedia(
            new Runnable() {
               @Override
               public void run() {
                  if(currentCount + 1 < listOfAllSongs.size()) {
                     currentSong = listOfAllSongs.get(++currentCount);
                     player.stop();
                     player = new MediaPlayer(currentSong);
                     player.play();
                  }
               }
            });
         player.onEndOfMediaProperty();
      }
      catch(NoSuchElementException e){
      }
      catch(FileNotFoundException e){
      }
      catch(MalformedURLException e){
      }
   }
   public void stop() throws NoSuchElementException
   {
      player.stop();
      timer.stop();
   }
   public void pause() throws NoSuchElementException
   {
      player.pause();
      timer.stop();
      currentDur = player.getCurrentTime();
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
         pause.setEnabled(true);
         stop.setEnabled(false);
         time.setText("0:00");
      }
   }
   private class TimeListener implements ActionListener {
      public MediaPlayer player;
      public TimeListener(MediaPlayer plater){
         player = plater;
      }
      public void actionPerformed(ActionEvent e){
         Duration dur = player.getCurrentTime();
         int seconds = (int)dur.toSeconds() - (int)dur.toMinutes()*60;
         int minutes = (int)dur.toMinutes();
         if(seconds < 10)
         {
            time.setText(minutes + ":0" + seconds);
         }
         else
            time.setText(minutes + ":" + seconds);
      }
   }
}