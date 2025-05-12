package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class EntiteView {
    protected Entite entite;
    protected Color color;
    protected int r;
    public EntiteView(Entite entite, Color color, int r) {
        this.entite = entite;
        this.color = color;
        this.r = r;
    }
    public void paint(Graphics g) {
        g.setColor(color);
        Point pos = entite.getPos();
        int x = pos.x;
        int y = pos.y; 
        g.fillOval(x-r, y-r, 2*r, 2*r);
    }
}
