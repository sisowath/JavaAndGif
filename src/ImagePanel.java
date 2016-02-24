import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
 
    Image image;  
  
    public ImagePanel() {
        image = Toolkit.getDefaultToolkit().createImage("src/images/loading2.gif");
    }
 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }
 
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {        
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.add(new ImagePanel());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(400, 300);
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setTitle("Fait par :: SUON Samnang");
                    frame.setVisible(true);
                    Thread.sleep(9000);// source de : http://stackoverflow.com/questions/3342651/how-can-i-delay-a-java-program-for-a-few-seconds
                    frame.dispose();// source de : http://stackoverflow.com/questions/18931261/closing-of-jframe-after-clicking-jbutton
                } catch (InterruptedException ex) {
                    Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();        
    }
}
// inspirée de : http://www.coderanch.com/t/506909/GUI/java/insert-gif-image-panel