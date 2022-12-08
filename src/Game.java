import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;
//Code referenced from https://www.youtube.com/watch?v=1gir2R7G9ws&list=PLWms45O3n--6TvZmtFHaCWRZwEqnz2MHa&index=1
//Published by RealTutsGML
//This is our main class
public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; //Variables used to control Window dimensions

    private Thread thread; //Initializes thread. We haven't learned about this yet. Kind of tells the computer
    // what path it should take while processing the program (I think?)
    private Handler handler;
    private boolean running = false;
    private Random r;
    private HUD hud = new HUD();



    public Game() {

        hud = new HUD();

        handler = new Handler(); //Handler initialization, see handler class
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Tanks!", this); //Window initialization, see window class



        handler.addObject(new Players(100, 200, ID.Tank1)); //calls handler to make game objects, player 1 and 2
        handler.addObject(new Players(500, 200, ID.Tank2));
    }

    public synchronized void start() { //Starts thread if running is true, starts run method
        if (running)
            return;
        running = true;
        thread = new Thread(this); //Creates thread object, gives location "this" see line 23
        thread.start(); //Starts thread
    }

    public synchronized void stop() { //closes thread, stops program
        try { //Kind of an if statement, will run if it is able to, otherwise does whatever is in catch { }
            thread.join(); //stops thread
            running = false;
        }catch (Exception e) {
            e.printStackTrace(); //Sends an error if the previous statement does not run
        }
    }

    public void run() { //Game loop method
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick(); //Calls tick method repeatedly
                delta--;

            }
            if(running)
                render(); //Calls render method repeatedly
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

        stop(); //runs stop method and ends program
    }




    private void tick() {
        handler.tick(); //calls tick in handler class
        hud.tick();

    }
//Most of this stuff below is confusing, it is creating, storing, and sending graphics to the window. This render method is called repeatedly in the game loop.
    private void render() { //Buffer strategy is where images are stored before they are displayed in the window
        BufferStrategy bs = this.getBufferStrategy(); //Creates BufferStrategy object
        if (bs == null) { //BufferStrategy starts at 0, this if statement changes the value to the recommended value of 3
            this.createBufferStrategy(3); //Creates 3 buffers, Buffer strategy is confusing.
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g); //calls render method in handler class
        hud.render(g);


        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;
    }






    public static void main (String [] args) {

        new Game();
    } //Runs the Game method

}