//Detail editor
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import org.jaudiotagger.tag.*;
import org.jaudiotagger.audio.*;

public class DetailEditorMusic extends JPanel {
   private JTextField artist, album;
   private JButton find;
   private JLabel folder;
   private JFileChooser chooser;
   private File[] listOfFiles;
   public DetailEditorMusic() {
      setLayout(new BorderLayout());
      //START OF NORTH SUBPANEL
      JPanel northPanel = new JPanel();
      northPanel.setLayout(new GridLayout(1, 2));
      add(northPanel, BorderLayout.NORTH);
      
      folder = new JLabel("Folder directory:");
      folder.setHorizontalAlignment(JLabel.CENTER);
      northPanel.add(folder);
      
      find = new JButton("Find Folder Directory");
      find.addActionListener(new FileListener());
      find.setHorizontalAlignment(JLabel.CENTER);
      find.setPreferredSize(new Dimension(20, 45));
      northPanel.add(find);
      
      chooser = new JFileChooser("C:");
      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      //END OF NORTH SUBPANEL
      
      //START OF CENTER SUBPANEL
      JPanel centerPanel = new JPanel();
      centerPanel.setLayout(new GridLayout(5, 1));
      
      JLabel alb = new JLabel("Album Name:");
      alb.setFont(new Font("Dialog", Font.PLAIN, 18));
      centerPanel.add(alb);
      album = new JTextField();
      centerPanel.add(album);
      JLabel space = new JLabel("");
      space.setFont(new Font("Dialog", Font.PLAIN, 8));
      centerPanel.add(space);
      JLabel art = new JLabel("Contributing Artist(s):");
      art.setFont(new Font("Dialog", Font.PLAIN, 18));
      centerPanel.add(art);
      artist = new JTextField();
      centerPanel.add(artist);
      add(centerPanel, BorderLayout.CENTER);
      //END OF CENTER SUBPANEL
      
      //START OF BOTTOM SUBPANEL
      JButton update = new JButton("Update Details");
      update.addActionListener(new UpdateListener());
      update.setPreferredSize(new Dimension(30, 45));
      add(update, BorderLayout.SOUTH);
      //END OF BOTTOM SUBPANEL
      
   }
   private class FileListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
         int what = chooser.showOpenDialog(find);
         if(what == JFileChooser.APPROVE_OPTION) {
            String direc = chooser.getSelectedFile().toString();
            folder.setText("Folder directory: " + direc);
            try{
               System.setOut(new PrintStream(new FileOutputStream("directory.txt")));
               System.out.print(chooser.getSelectedFile());
               File[] directory = new File(direc).listFiles();
               listOfFiles = directory;   
            }
            catch(FileNotFoundException f){
            }
         }
      }
   }
   private class UpdateListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         try {
            for(int k = 0; k < listOfFiles.length; k++) {
               AudioFile file = AudioFileIO.read(listOfFiles[k]);
               Tag tag = file.getTag();
               if(album.getText().trim() != "") {
                  tag.setField(FieldKey.ALBUM, album.getText());
                  AudioFileIO.write(file);
               }
               if(artist.getText().trim() != "") {
                  tag.setField(FieldKey.ARTIST, artist.getText());
                  AudioFileIO.write(file);
               }
            }
         }
         catch (Exception f) {}
      }
   }
}