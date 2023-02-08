import javax.swing.*;
import java.awt.*;

public class GamePlay extends JPanel {

    private int [] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon headRight;
    private ImageIcon headLeft;
    private ImageIcon headUp;
    private ImageIcon headDown;


    private ImageIcon titleImage;

    public GamePlay () {

    }

    public void paint(Graphics g) {
        titleImage = new ImageIcon(".//game_images/SnakeTitle5.png");
        Image image = titleImage.getImage();
        Image newImage = image.getScaledInstance(851, 120, Image.SCALE_SMOOTH);
        titleImage = new ImageIcon(newImage);
        titleImage.paintIcon(this, g, 25, 5);

        //Display gameplay border
        g.setColor(Color.DARK_GRAY);
        g.drawRect(24, 74,  851, 577);

        //Display gameplay background
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);

        g.dispose();
    }

}
