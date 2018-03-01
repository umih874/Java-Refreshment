package com.tutorial.main;

import java.awt.*;

public class Player extends GameObjects {

    Color color;
    int height = 10;
    int width = 50;

    public Player(int x, int y, Color color, ObjectID id) {
        super(x, y, id);

        velX = 1;

        this.color = color;
    }

    public void tick() {
        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y,width,height);
    }
}
