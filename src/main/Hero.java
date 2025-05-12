package main;
import java.awt.Point;
public class Hero extends Entite { 
    public Hero() {
        super(new Point(200,200));
        this.hp = 3;
        this.atk = 1;
        this.view = new HeroView(this);
    }
    @Override
    public String toString() {
        return "Hero:[x="+pos.x+", y="+pos.y+", hp="+hp+", atk="+atk+"]";
    }
}
