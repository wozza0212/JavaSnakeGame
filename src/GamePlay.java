import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

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

    private int lengthOfSnake = 3;

    private Timer timer;
    private int delay = 100;

    private ImageIcon tail;
    private int moves = 0;
    private int score = 0;


    private ImageIcon titleImage;

    public GamePlay () {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        if (moves == 0){
            snakeXlength[0] = 100;
            snakeXlength[1] = 75;
            snakeXlength[2] = 50;

            snakeYlength[0] = 100;
            snakeYlength[1] = 100;
            snakeYlength[2] = 100;


        }

        //Display title
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

        //draw snake start
        headRight = new ImageIcon(".//game_images/SnakeHeadRight.png");
        Image snakeRight = headRight.getImage();
        Image headRightImage = snakeRight.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        headRight = new ImageIcon(headRightImage);
        headRight.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);

        for(int i = 0; i<lengthOfSnake; i++) {
            if (i==0 && right){
                headRight = new ImageIcon(".//game_images/SnakeHeadRight.png");
                snakeRight = headRight.getImage();
                headRightImage = snakeRight.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                //May have to declare new image and change variabble name for two lines above
                headRight = new ImageIcon(headRightImage);
                headRight.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i==0 && left){
                headLeft = new ImageIcon(".//game_images/SnakeHeadLeft.png");
                Image snakeLeft = headLeft.getImage();
                Image headLeftImage = snakeLeft.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                //May have to declare new image and change variabble name for two lines above
                headLeft = new ImageIcon(headLeftImage);
                headLeft.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i==0 && up){
                headUp = new ImageIcon(".//game_images/SnakeHeadUp.png");
                Image snakeUp = headUp.getImage();
                Image headUpImage = snakeUp.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                //May have to declare new image and change variabble name for two lines above
                headUp = new ImageIcon(headUpImage);
                headUp.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if (i==0 && down){
                headDown = new ImageIcon(".//game_images/SnakeHeadRight.png");
                Image snakeDown = headDown.getImage();
                Image headDownImage = snakeDown.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                //May have to declare new image and change variabble name for two lines above
                headDown = new ImageIcon(headDownImage);
                headDown.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
            }
            if(i!=0) {
                tail = new ImageIcon(".//game_images/SnakeBody.png");
                Image snakeBody = tail.getImage();
                Image bodyImage = snakeBody.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                //May have to declare new image and change variabble name for two lines above
                tail = new ImageIcon(bodyImage);
                tail.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);

            }

        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            moves++;
            right = true;
            if(!left) {
                right = true;
            }else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            moves++;
            left = true;
            if(!right) {
                left = true;
            }else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            moves++;
            up = true;
            if(!down) {
                up = true;
            }else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            moves++;
            down = true;
            if(!up) {
                down = true;
            }else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
