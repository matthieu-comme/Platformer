package main;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputController implements KeyListener {
    Hero hero;
    public InputController(Hero hero) {
        this.hero = hero;
    }
    public void keyPressed(KeyEvent e) {
        int delta = hero.getSpeed();
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                hero.addX(delta);
                break;
            case KeyEvent.VK_LEFT:
                hero.addX(-delta);
                break;
            case KeyEvent.VK_UP:
                hero.addY(-delta);
                //hero.jump();
                break;
            case KeyEvent.VK_DOWN:
                hero.addY(delta);
                break;
        }
        //System.out.println(e.getExtendedKeyCode()+"" + hero);
    }
    public void keyReleased(KeyEvent e) {
        //System.out.println("Released " + e);
    }
    public void keyTyped(KeyEvent e) {
        //System.out.println("Typed " + e);
    }
}
