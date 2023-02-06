import javax.swing.*;
import java.awt.*;

public class GamePlay extends JPanel {
    private ImageIcon titleImage;

    public GamePlay () {

    }

    public void paint(Graphics g) {
        titleImage = new ImageIcon(".//game_images/SnakeTitle5.png");
        Image image = titleImage.getImage();
        Image newImage = image.getScaledInstance(851, 100, Image.SCALE_SMOOTH);
        titleImage = new ImageIcon(newImage);
        titleImage.paintIcon(this, g, 25, 5);

        //Dusplay gameplay border
        g.setColor(Color.DARK_GRAY);
        g.drawRect(24, 74,  851, 577);

        //Display gampleay background
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);

        g.dispose();
    }

}
