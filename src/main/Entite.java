package main;
import java.awt.Point;

public abstract class Entite {
    protected Point pos;
    protected int hp, atk, speed;
    protected EntiteView view;
    protected boolean isJumping = false;
    protected int jumpingFrames;
    protected int jumpingHeight = 5;
    // shape hitbox ?
    public Entite(Point pos) {
        this.pos = pos;
        this.speed = 10;
        this.isJumping = false;
        this.jumpingFrames = 0;
    }
    public void jumpMotion() {
        if(isJumping) {
            if(jumpingFrames < 10) {
                jumpingFrames++;
                this.addY(-jumpingHeight);
            } else {
                isJumping = false;
            }
        } else {
            if(jumpingFrames > 0) {
                jumpingFrames--;
                this.addY(jumpingHeight);
            }
        }
    }
    public boolean isJumping() {
        return isJumping || jumpingFrames > 0;
    }
    public void jump() {
        if (!isJumping)
            isJumping = true;
    }

    public Point getPos() {
        return this.pos;
    }
    public void setPos(Point pos) {
        this.pos = pos;
    }
    public int getX() {
        return this.pos.x;
    }
    public int getY() {
        return this.pos.y;
    }
    public void setX(int x) {
        this.pos.x = x;
    }
    public void setY(int y) {
        this.pos.y = y;
    }
    public void addX(int dx) {
        this.pos.x += dx;
    }
    public void addY(int dy) {
        this.pos.y += dy;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAtk() {
        return atk;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }   
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }    
    public EntiteView getView() {
        return this.view;
    }
}
