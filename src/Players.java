import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;



public class Players extends GameObject { //This class inherits methods from the GameObject class

    Handler handler = new Handler();
    ;


    public Players(int x, int y, ID id) { //constructs GameObject method
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, 32, 32);
    }

    public Rectangle getBoundsCol() {

        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        if(velX < 0) facing = -1;
        else if (velX > 0) facing = 1;


        x += velX; //updates position of players based on Vel values
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 32);
        y = Game.clamp(y, 0, Game.HEIGHT - 64);
        //Keeps players from exiting the screen

        collision();


    }

    private void collision()
    {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(id == ID.Tank1) {
                if (tempObject.getId() == ID.TankBullet2) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        HUD.HEALTH -= 2;


                        //collision code

                    }
                }
            }



        }



    }



    public void render(Graphics g) {
        if(id == ID.Tank1)  g.setColor(Color.BLUE);
        else if (id == ID.Tank2) g.setColor(Color.RED);
        g.fillRect(x, y, 32,32);

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
        g2d.draw(getBoundsCol());


    }



}

