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
      northPanel.add(folder);
      
      find = new JButton("Find Folder Directory");
      find.addActionListener(new FileListener());
      find.setHorizontalAlignment(JLabel.CENTER);
      northPanel.add(find);
      
      chooser = new JFileChooser("C:");
      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      //END OF NORTH SUBPANEL
      
      //START OF CENTER SUBPANEL
      JPanel centerPanel = new JPanel();
      centerPanel.setLayout(new GridLayout(5, 1));
      
      centerPanel.add(new JLabel("Album Name:"));
      album = new JTextField();
      centerPanel.add(album);
      centerPanel.add(new JLabel(""));
      centerPanel.add(new JLabel("Contributing Artist(s):"));
      artist = new JTextField();
      centerPanel.add(artist);
      add(centerPanel, BorderLayout.CENTER);
      //END OF CENTER SUBPANEL
      
      //START OF BOTTOM SUBPANEL
      JButton update = new JButton("Update Details");
      update.addActionListener(new UpdateListener());
      add(update, BorderLayout.SOUTH);
      //END OF BOTTOM SUBPANEL
      
   }
   private class FileListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
         chooser.showOpenDialog(find);
         folder.setText("Folder directory: " + chooser.getSelectedFile());
         try{
            System.setOut(new PrintStream(new FileOutputStream("directory.txt")));
            System.out.print(chooser.getSelectedFile());
            listOfFiles = new File(folder.getText()).listFiles();
            
            
         }
         catch(FileNotFoundException f){
         }
      }
   }
   private class UpdateListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         try {
            for(int k = 0; k < listOfFiles.length; k++) {
               AudioFile file = AudioFileIO.read(listOfFiles[k]);
               Tag tag = file.getTag();
               tag.setField(FieldKey.ALBUM, album.getText());
               tag.setField(FieldKey.ARTIST, artist.getText());
               AudioFileIO.write(file);
            }
         }
         catch (Exception f) {}
      }
   }
}