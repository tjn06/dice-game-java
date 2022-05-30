package com.labb;

import java.util.ArrayList;

public class Player {
    String name; //Name of player
    int points = 0; //Total points of player
    ArrayList<Die> dieList = new ArrayList<>(); //List of dies, amount of dice?
    
    public void rollDice() {
        for (Die i: dieList)
        {
            i.roll();
        }
        System.out.println("You roll the dice! \n");
    }

    public int getDieValue() {
        int sum = 0;
        for (int i = 0; i < dieList.size(); i++) {
            sum = (sum + dieList.get(i).getCurrentValue());
            System.out.println("Dice " + (i+1) + " rolled, value: " + dieList.get(i).getCurrentValue());
        }
        return sum;
    };

    public void increaseScore() {
        points++;
    }

    public void addDie(int sides) {
        dieList.add(new Die(sides));
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

}
