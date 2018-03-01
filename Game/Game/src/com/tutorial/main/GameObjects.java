package com.tutorial.main;

import java.awt.*;

// Refers to all game objects. Such as player, AI, blocks, etc...
public abstract class GameObjects {

    // Indicates the coordinates of the object on the screen.
    // Protective means that only be accessed by the object that inherits GameObject.
    protected int x,y;
    // Indicated which object it is.
    protected ObjectID id;
    // Indicates how fast object if moving. (i.e. how far is does it travel each tick)
    protected int velX, velY;

    public GameObjects(int x, int y, ObjectID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    // ----------- GETTERS AND SETTERS ---------------
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(ObjectID id) {
        this.id = id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getX() {
        return x;
    }

    public  int getY() {
        return y;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return  velY;
    }

    public ObjectID getId() {
        return id;
    }
    //---------------------------------------
}
