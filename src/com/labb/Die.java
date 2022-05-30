package com.labb;

import java.util.Random;

public class Die {
    int currentValue; //Value now
    int sides; //Sides of die
    private static Random staticRandom = new Random(); // Random generator

    public Die (int sides) {
        this.sides = sides;
    }

    public void roll() {
        this.currentValue = staticRandom.nextInt(this.sides) + 1;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getSides() {
        return sides;
    }

}
