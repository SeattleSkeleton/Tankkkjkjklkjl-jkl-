import java.awt.*;
import java.util.LinkedList;

public class Handler { //this class updates objects in the program, loops in our main class call methods within this class

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() { //loop will update object
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g) { //loop will render object
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    } //these methods add and remove objects from the list

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }


    }
