import java.awt.*;

//Contains in game objects like players, projectiles, or anything we want to make appear on screen
public abstract class GameObject {
    protected int x, y; //Protected variables ***
    protected ID id; //allows game objects to contain an id
    protected int velX, velY;
    protected int facing = 1;

    public GameObject (int x, int y, ID id) { //This will be used as a constructor to create gameobjects, similar to objects like Scanner is constructed.
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick(); //game objects will be updated using the tick method
    public abstract void render(Graphics g);//game objects will be updated using the render method
    public abstract Rectangle getBounds();

//These methods are called to change positions of a game object
    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getFacing() {
        return facing;

    }

    public void setId(ID id) {

        this.id = id;
    }

    public ID getId() {

        return id;
    }

//These methods are used to change velocity
    public int getVelX() {

        return velX;
    }

    public void setVelX(int velX) {

        this.velX = velX;
    }


    public int getVelY() {

        return velY;
    }

    public void setVelY(int velY) {

        this.velY = velY;
    }



}
