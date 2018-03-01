package com.tutorial.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = 640;

    private Thread thread;
    private boolean running = false;

    private Random r;
    private Handler handler;

    //----------------------------------------------------

    public static void main(String args[]) {
        new Game();
    }

    @Override
    public void run() {

        //Create Game Loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    // Upon call create initial Window.
    public Game() {
        handler = new Handler();

        new Window(WIDTH, HEIGHT, "NEW GAME", this);

        r = new Random();

        handler.AddObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), Color.WHITE, ObjectID.Player));
    }

    // When new Window is created it will start the thread and indicate that game is running.
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    // Stop our threat and indicate game is not running.
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void tick() {
        handler.tick();
    }


    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.green);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }
}
