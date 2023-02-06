import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame obj = new JFrame();
        GamePlay gameplay = new GamePlay();

        obj.setBounds(10, 10, 905, 700); //Game Screen
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
        obj.setVisible(true);


    }
}