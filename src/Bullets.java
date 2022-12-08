import java.awt.*;
import java.io.Console;
import java.util.Scanner;

public class Bullets extends GameObject {

    Handler handler = new Handler();

    public Bullets(int x, int y, ID id, int velX) {
        super(x, y, id);
        int angle1 = 0;
        int angle2 = 0;
        int power1 = 0;
        int power2 = 0;
        this.handler = handler;
        if (id == ID.TankBullet1) {

            velX = 5;
        } else if (id == ID.TankBullet2) {
            velX = -5;

        }
        velY = -5;
        this.velX =velX;

}
    public double bullPhys(double vel){
        double g = -9.8;
        return 0.0;

    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, 4, 4);
    }
    double count = 0;

    Scanner s = new Scanner(System.in);

    double velUpY = -10;
    double velDownY = 10;

    public void tick() {
        x += velX;
        velUpY = velUpY + (0.3);
        velDownY = velDownY - (0.3);
        y += velUpY;
        y+= velDownY;

    }


    public void render(Graphics g) {
        if(id == ID.TankBullet1) g.setColor(Color.BLUE);
        else if(id == ID.TankBullet2) g.setColor(Color.RED);
        g.fillRect(x, y + 8, 16,16);

    }



}
