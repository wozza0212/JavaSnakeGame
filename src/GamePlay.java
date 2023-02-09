import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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

    private int [] fruitXposition = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
            325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600,
            625, 650, 675, 700, 725, 750, 775, 800, 825, 850};

    private int [] fruitYposition = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300,
            325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};

    private ImageIcon fruitImage;

    private Random random = new Random();

    private int xPosition = random.nextInt(34);
    private int yPosition = random.nextInt(23);
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
                headDown = new ImageIcon(".//game_images/SnakeHeadDown.png");
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

            fruitImage = new ImageIcon(".//game_images/egg.png");
            Image egg = fruitImage.getImage();
            Image eggImage = egg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
            //May have to declare new image and change variabble name for two lines above
            fruitImage = new ImageIcon(eggImage);

            if(fruitXposition[xPosition] == snakeXlength[0] && fruitYposition[yPosition] == snakeYlength[0]){
                score = score + 1;
                lengthOfSnake++;
                xPosition = random.nextInt(34);
                yPosition = random.nextInt(23);
            }
            fruitImage.paintIcon(this, g, fruitXposition[xPosition], fruitYposition[yPosition]);

        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.restart();
        if (right) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeYlength[i + 1] = snakeYlength[i];
            }
            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    snakeXlength[i] = snakeXlength[i] + 25;
                } else {
                    snakeXlength[i] = snakeXlength[i - 1];
                }
                if (snakeXlength[i] > 850) {
                    snakeXlength[i] = 25;
                }
            }
            repaint();
        }
        if (left) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeYlength[i + 1] = snakeYlength[i];
            }
            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    snakeXlength[i] = snakeXlength[i] - 25;
                } else {
                    snakeXlength[i] = snakeXlength[i - 1];
                }
                if (snakeXlength[i] < 25) {
                    snakeXlength[i] = 850;
                }
            }
            repaint();
        }
        if (up) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeXlength[i + 1] = snakeXlength[i];
            }
            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    snakeYlength[i] = snakeYlength[i] - 25;
                } else {
                    snakeYlength[i] = snakeYlength[i - 1];
                }
                if (snakeYlength[i] < 75) {
                    snakeYlength[i] = 625;
                }
            }
            repaint();
        }
        if (down) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeXlength[i + 1] = snakeXlength[i];
            }
            for (int i = lengthOfSnake; i >= 0; i--) {
                if (i == 0) {
                    snakeYlength[i] = snakeYlength[i] + 25;
                } else {
                    snakeYlength[i] = snakeYlength[i - 1];
                }
                if (snakeYlength[i] > 625) {
                    snakeYlength[i] = 75;
                }
            }
            repaint();

        }
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
