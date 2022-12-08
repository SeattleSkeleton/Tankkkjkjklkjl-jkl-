import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter { //Uses key adapter to listen for keyboard inputs

    private Handler handler;


    public KeyInput (Handler handler) {
        this.handler = handler;

    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);


            if (tempObject.getId() == ID.Tank1) {

                if (key == KeyEvent.VK_W) tempObject.setVelY(-5);
                if (key == KeyEvent.VK_S) tempObject.setVelY(5);
                if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
                if (key == KeyEvent.VK_D) tempObject.setVelX(5);

                if (key == KeyEvent.VK_C){
                    handler.addObject(new Bullets(tempObject.getX(), tempObject.getY(), ID.TankBullet1, tempObject.getFacing() * 5));
                }


            }

            if (tempObject.getId() == ID.Tank2) {

                if (key == KeyEvent.VK_UP) tempObject.setVelY(-5);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);

                if (key == KeyEvent.VK_SPACE){
                    handler.addObject(new Bullets(tempObject.getX(), tempObject.getY(), ID.TankBullet2, tempObject.getFacing() * 5));
                }

            }


        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);


            if (tempObject.getId() == ID.Tank1) {

                if (key == KeyEvent.VK_W) tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) tempObject.setVelY(0);
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);


            }

            if (tempObject.getId() == ID.Tank2) {

                if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);

            }
        }

    }
}
