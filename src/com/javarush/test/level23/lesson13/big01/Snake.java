package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by BELSHINA on 23.10.2016.
 */
public class Snake {
    private ArrayList<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }
    public int getX() {
        return sections.get(0).getX();
    }
    public int getY() {
        return sections.get(0).getY();
    }
    public void move() {

        int x = sections.get(0).getX();
        int y = sections.get(0).getY();
            if (direction == SnakeDirection.UP) {
                sections.add(0, new SnakeSection(x, y - 1));
            } else if (direction == SnakeDirection.DOWN) {
                sections.add(0, new SnakeSection(x, y + 1));
            } else if (direction == SnakeDirection.LEFT) {
                sections.add(0, new SnakeSection(x - 1, y));
            } else if (direction == SnakeDirection.RIGHT) {
                sections.add(0, new SnakeSection(x + 1, y));
            }
            sections.remove(sections.size() - 1);

            if (x < 0 || x > Room.game.getWidth() || y < 0 || y > Room.game.getHeight()) {
                isAlive = false;
            }

            for(SnakeSection s : sections) {
                if(x == s.getX() && y == s.getY()) {
                    isAlive = false;
                }
            }

            if(x == Room.game.getMouse().getX() && y == Room.game.getMouse().getY()) {
                Room.game.eatMouse();
            }


    }

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
    public SnakeDirection getDirection() {
        return direction;
    }
}
