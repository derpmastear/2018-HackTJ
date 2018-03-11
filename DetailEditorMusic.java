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
      setLayout(new BorderLayout());
      JPanel northPanel = new JPanel();
      add(northPanel, BorderLayout.NORTH);
      folder.setText("Folder directory");
      northPanel.add(folder);
      northPanel.setLayout(new GridLayout(1, 2));
      find = new JButton("Find Folder Directory");
      find.addActionListener(new FileListener());
      northPanel.add(find);
      select = new JFileChooser("C:");
   }
   private class FileListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         select.showOpenDialog(find);
      }
   }
}