import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//This class creates the window
public class Window extends Canvas{

    public Window (int width, int height, String title, Game game) { //This method describes our window
        JFrame frame = new JFrame(title); //creates JFrame object

        frame.setPreferredSize(new Dimension(width, height)); //Controls default window dimensions
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Window closes when the x is pressed
        frame.setResizable(false);  //Window is not resizeable
        frame.setLocationRelativeTo(null); //Controls location window appears on screen (Center)
        frame.add(game); //Applies the game class to the window
        frame.setVisible(true); //Window will not appear without this
        game.run();
        game.start();
    }


}