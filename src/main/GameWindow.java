package main;
import javax.swing.JFrame;


public class GameWindow extends JFrame {
    public GameWindow(Game game, MainPanel panel) {
        super();
        Hero hero = game.getHero();
        this.addKeyListener(new InputController(hero));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(panel);
        //this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);  
    }
}