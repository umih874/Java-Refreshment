package com.tutorial.main;

import java.awt.*;
import java.util.LinkedList;

// Renders the objects. Loops through the objects and renders them.
// Creates a linked list and stores all the objects.
// Responsible for adding and removing any objects.
public class Handler {
    LinkedList<GameObjects> object = new LinkedList<GameObjects>();

    public void tick() {
        for(int i=0; i < object.size(); i++){
            GameObjects tempGameObject = object.get(i);

            tempGameObject.tick();
        }
    }

    public void render(Graphics g) {
        for(int i=0; i < object.size(); i++) {
            GameObjects tempGameObject = object.get(i);

            tempGameObject.render(g);
        }
    }

    public void AddObject(GameObjects object) {
        this.object.add(object);
    }

    public void RemoverObject(GameObjects object) {
        this.object.add(object);
    }

}
