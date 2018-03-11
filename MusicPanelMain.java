//Main panel bullshit

/* Code to get all files in a directory and put in array

File folder = new File("your/path");
File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
    }
  */
  
/*********************************************************************
*Main Panel that contains the other panels.                          *
*Please note that there are only panels on this main panel.          *
*********************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.*;

public class MusicPanelMain extends JPanel
{
   private DetailEditorMusic details;
   private SongPlayer songs;
   private SongPlaylist playlist;
   private JButton songsTab, detailTab;
   private JTabbedPane tabs;
   
   public MusicPanelMain() throws Exception
   {
      setLayout(new BorderLayout());
      
      tabs = new JTabbedPane();
      
      details = new DetailEditorMusic();
      details.setPreferredSize(new Dimension(400, 400));
      tabs.add("Detail Editor", details);
      
      songs = new SongPlayer();
      songs.setPreferredSize(new Dimension(400, 400));
      tabs.add("Player", songs);
      
      playlist = new SongPlaylist();
      songs.setPreferredSize(new Dimension(400, 400));
      tabs.add("Playlists", playlist);
      
      add(tabs, BorderLayout.CENTER);
   }
}

