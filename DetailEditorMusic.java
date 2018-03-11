//Detail editor
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class DetailEditorMusic extends JPanel {
   private JTextField artist, album;
   private JButton find;
   private JLabel folder;
   private JFileChooser select;
   public DetailEditorMusic() {
      find = new JButton("Find Folder Directory");
      find.addActionListener(new FileListener());
      add(find);
      select = new JFileChooser("C:");
   }
   private class FileListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         select.showOpenDialog(find);
      }
   }
}