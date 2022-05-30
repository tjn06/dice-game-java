package com.labb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SimpleDiceGame {

    public static void main(String[] args) {

        HashMap<String, Integer> inputs = userInputs();

        ArrayList<Player> allPlayers = initialize(inputs.get("participating"), inputs.get("dices"), inputs.get("sides"));

        takeTurn(allPlayers);

        ArrayList<Player> winners = getWinners(allPlayers);

        presentWinners(winners);

    }

    private static HashMap<String, Integer> userInputs() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> inputsArr = new HashMap<String, Integer>();
        System.out.println("How many players are participating?");
        inputsArr.put("participating", sc.nextInt());
        System.out.println("How many dices should each player have?");
        inputsArr.put("dices", sc.nextInt());
        System.out.println("How many sides should the dice have?");
        inputsArr.put("sides",sc.nextInt());
        return inputsArr;
    }

    private static ArrayList<Player> initialize(int players, int dices, int sides) {
        Scanner input = new Scanner(System.in);
        ArrayList<Player> playersList = new ArrayList<Player>();

        for (int i = 0; i < players; i++){
            Player player = new Player();
            System.out.println("Give player " + (i+1) + " a name.");
            player.name = input.nextLine();
            for (int j = 0; j < dices; j++){
                player.addDie(sides);
            }
            playersList.add(player);
        }
        return playersList;
    };

    private static void takeTurn(ArrayList<Player> players) {
        Scanner input = new Scanner(System.in);
        int roundsToPlay = 5;
        int sides = players.get(0).dieList.get(0).getSides();

        for (int rounds = 0; rounds < roundsToPlay; rounds++) {
            System.out.println("\nRound " + (rounds+1));

            for (int i = 0; i < players.size(); i++) {
                System.out.println(players.get(i).name + ", guess the total value of your dice roll(with " + players.get(i).dieList.size() + " dice" +
                        " and " + sides +  " side(s)).") ;
                int tempGuess = input.nextInt();
                players.get(i).rollDice();
                int totalValue = players.get(i).getDieValue();
                System.out.println("Total value(correct answer):  " + totalValue);

                if (tempGuess == totalValue) {
                    players.get(i).increaseScore();
                    System.out.println(players.get(i).getName() + " got one point! " + "total point(s): " + players.get(i).getPoints() + "\n");
                } else {
                    System.out.println(players.get(i).getName() + " guessed incorrectly, " + "total point(s): " + players.get(i).getPoints() + "\n");
                }
            }
            System.out.println("End of round " + (rounds+1));
        }
    };

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winnersList = new ArrayList<Player>();

        int maxScore = Integer.MIN_VALUE;
        for (Player player : players) {
            maxScore = Math.max(maxScore, player.getPoints());
        }
        for (Player player : players) {
            if (player.getPoints() == maxScore) {
                winnersList.add(player);
            }
        }
        return winnersList;
    };

    private static void presentWinners(ArrayList<Player> winners) {
        if (winners.get(0).getPoints() != 0) {

            if (winners.size() > 1) {
                System.out.println("\nThe winners are ");

            } else {
                System.out.println("\nThe winner is ");
            }

            for (int i = 0; i < winners.size(); i++) {
                System.out.println(winners.get(i).name + " on " + winners.get(i).getPoints() + " points");
            }

        } else {
            System.out.println("No points, no winner, loooosers!");
        }

    }


}


