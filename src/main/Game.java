package main;
public class Game implements Runnable {
    private GameWindow frame;
    private MainPanel panel;
    private Thread gameThread;
    private final int NB_FPS = 60;
       
    private Hero hero;
    public Game() {
        this.hero = new Hero();
        this.panel = new MainPanel();
        this.frame = new GameWindow(this, panel);        
        panel.addEntiteView(hero.getView()); 
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000/NB_FPS;
        double lastFrame = System.nanoTime();
        double now;

        int frames = 0;
        long lastCheckFPS = System.currentTimeMillis();
        while(true) {
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame) {
                //hero.jumpMotion();
                frame.repaint();
                lastFrame = now;
                frames++;
            }
            long nowFPS = System.currentTimeMillis();
            if(nowFPS - lastCheckFPS >= 1000) {
                lastCheckFPS = nowFPS;
                System.out.println("FPS: "+frames);
                frames = 0;
            }
        }
    }
    public Hero getHero() {
        return this.hero;
    }
    public GameWindow getFrame() {
        return this.frame;
    }
}