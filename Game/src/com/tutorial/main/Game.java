package com.tutorial.main;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = 640;

    public Game() {
        new Window(WIDTH, HEIGHT, "NEW GAME", this);
    }

    public synchronized void start() {

    }

    public static void main(String args[]) {
        new Game();
    }

    @Override
    public void run() {

    }
}
