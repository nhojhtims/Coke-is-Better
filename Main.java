package com.company;

import java.io.FileReader;
import java.util.Scanner;

public class Main {



    private Player p1;
    private Player p2;
    private Dice dice;
    private final int scoreToWin = 12; //fix the score to win to 30



    void displayGameMenu() {    // display options for player

        System.out.println();
        System.out.println("(1) Start a new game");
        System.out.println("(2) Play one round");
        System.out.println("(3) Who is leading now?");
        System.out.println("(4) Display game help");
        System.out.println("(5) Exit game");
        System.out.println();
        System.out.print("Choose an option: ");

    } //close displayGameMenu


    void selectGameOption(int optionSelected) { //shows game options and give various response based on users' choice
        switch (optionSelected) {
            case 1 -> this.startNewGame(); //start a new game by creating new players and new dice
            case 2 -> {

                this.playOneRound(p1); //roll two dice for player 1
                this.playOneRound(p2); //roll two dice for player 2
            }
            case 3 -> this.whoIsLeading();  //show both players who is winning by showing them each of their total score
            case 4 -> this.displayGameInstruction();  // display Game Instruction
            default -> {            //exit the game
            } //close default
        } // close the switch
    }// close selectGameOption

    //new game object, set up input names and give them dice
    void startNewGame() { //ask for user input to create two player objects
        String p1Name;
        String p2Name;

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter player one name: ");
        p1Name = sc.nextLine(); //get name for player 1
        System.out.print("Please enter player two name: ");
        p2Name = sc.nextLine(); //get name for player 2


        p1 = new Player(p1Name);  //create player1 name into a variable for new game
        p2 = new Player(p2Name);  //create player2 name into a variable for new game
        dice = new Dice(); //create new dice for the new game
    } //close startNewGame

    void playOneRound(Player p) { //engage both players for dice roll.

        int result;
        int firstDiceRoll = dice.rollDice();
        int secondDiceRoll = dice.rollDice();
//        int sum = firstDiceRoll + secondDiceRoll;




        System.out.printf("%s it's your turn!", p.getName());
        System.out.println();
        System.out.printf("%s rolled", p.getName());
        System.out.println();





        int bar = 6; //set the bar's length
        String diceBar1 = "[";   //print out dice1 in stars, like a health bar
        for (int i = 0; i < firstDiceRoll; i++) {
            diceBar1 += "*";
        }
        for (int j = 0; j < bar - firstDiceRoll; j++) {
            diceBar1 += " ";
        }
        System.out.println();
        diceBar1 += "]";
        System.out.println("Die 1: " + diceBar1 + " " + firstDiceRoll);


        String diceBar2 = "[";  //print out dice2 in stars, like a health bar
        for (int i = 0; i < secondDiceRoll; i++) {
            diceBar2 += "*";
        }
        for (int j = 0; j < bar - secondDiceRoll; j++) {
            diceBar2 += " ";
        }
        System.out.println();
        diceBar2 += "]";
        System.out.println("Die 2: " + diceBar2 + " " + secondDiceRoll);






        System.out.println();
        if ((p.getTotalScore() + firstDiceRoll) == scoreToWin || (p.getTotalScore() + secondDiceRoll) == scoreToWin || (p.getTotalScore() + firstDiceRoll + secondDiceRoll) == scoreToWin  ){ //check to see if the player's roll can win
            System.out.println("YOU ARE SO LUCKY!!");
            System.out.println();
        } // close the if statement
        System.out.println();
        System.out.printf("%s's current total score is %d", p.getName(), p.getTotalScore());
        System.out.println();
        System.out.println("Please select which die to keep:");
        System.out.println("1.Keep die1, 2.Keep die2, 3.Keep both dice");
        Scanner sc2 = new Scanner(System.in);
        int d = sc2.nextInt();
        System.out.println();
        switch (d) { // return the result of dice roll based on player choice.
            case 1: //1 = keep the first die value
                result = firstDiceRoll;
                p.setTotalScore(result);
                System.out.printf("%s rolled %d and %d, " + "and kept %d points, " + "for a total of %d points.", p.getName(), firstDiceRoll, secondDiceRoll, result, p.getTotalScore());
                System.out.println();
                break;

            case 2: // 2 = keep the 2nd die value
                result = secondDiceRoll;
                p.setTotalScore(result);
                System.out.printf("%s rolled %d and %d, " + "and kept %d points, " + "for a total of %d points.", p.getName(), firstDiceRoll, secondDiceRoll, result, p.getTotalScore());
                System.out.println();

                break;

            case 3: //3 = keep both dice values
                result = (firstDiceRoll + secondDiceRoll);
                p.setTotalScore(result);
                System.out.printf("%s rolled %d and %d, " + "and scored %d points, " + "for a total of %d points", p.getName(), firstDiceRoll, secondDiceRoll, result, p.getTotalScore());
                System.out.println();

                break;

        } // closing the switch

        System.out.println();
    } // closing playOneRound












    void whoIsLeading() { //this shows players which one of them is ahead by displaying both players' total score
        System.out.println();
        if (p1.getTotalScore() == p2.getTotalScore()) {
            System.out.format("Its currently a draw, " + "%s has %d, %s has %d", p1.getName(), p1.getTotalScore(), p2.getName(), p2.getTotalScore()
            );
        } else if (p1.getTotalScore() > p2.getTotalScore()) {
            System.out.printf("%s is leading, %s has %d points, " + "%s has %d points", p1.getName(), p1.getName(), p1.getTotalScore(), p2.getName(), p2.getTotalScore());
        } else if (p1.getTotalScore() < p2.getTotalScore()) {
            System.out.format("%s is leading, %s has %d points, " + "%s has %d points.", p2.getName(), p2.getName(), p2.getTotalScore(), p1.getName(), p1.getTotalScore()
            );
        }
        System.out.println();
    } // closing whoIsLeading

    void displayGameInstruction() {  //show game instruction if called
        System.out.println();
        System.out.println("The goal is to hit 30 without going over it.");
        System.out.println("All players roll a dice twice per turn.");
        System.out.println("You can choose to keep the first rolled die, or second, or both.");
        System.out.println("For each player, result is incremented after each turn.");
        System.out.println("If a player's sum exceeds 30, that player's sum get returned to 0.");
        System.out.println("First player to get 30 wins the game.");

    } // closing displayGameInstruction

    boolean checkIfAnyoneHasWon() { //checks to see if anyone has won or bust


        if (p1.getTotalScore() == scoreToWin && p2.getTotalScore() == scoreToWin ){
            System.out.println("Both players hit 30! It's a draw!");
            return true;
        } //closing if statement for a draw

        else if (p1.getTotalScore() == scoreToWin) {//player1 win condition
            System.out.printf("%s just hit 30! %s is the WINNER!", p1.getName(), p1.getName());
            return true;
        } //closing elseif statement if player1 has won

        else if (p2.getTotalScore() == scoreToWin) { //player2 win condition
            System.out.printf("%s just hit 30! %s is the WINNER!", p2.getName(), p2.getName());
            return true;
        }//closing elseif statement


        else if (p1.getTotalScore() >= scoreToWin && p2.getTotalScore() >= scoreToWin) { //bust condition for both players
            System.out.format("Both %s and %s went over 30! Resetting their scores back to 0!", p1.getName(), p2.getName());
            System.out.println();
            p1.resetScore();
            p2.resetScore();

            return false;
        } //closing elseif statement



        else if (p1.getTotalScore() >= scoreToWin) {//player1 bust condition
            System.out.format("%s went over 30 to %d, resetting score to 0.  ", p1.getName(), p1.getTotalScore());
            System.out.println();
            p1.resetScore();
            return false;
        }//closing elseif statement

        else if (p2.getTotalScore() >= scoreToWin) {//player2 bust condition
            System.out.format("%s went over 30 to %d, resetting score to 0. ", p2.getName(), p2.getTotalScore());
            System.out.println();
            p2.resetScore();

            return false;
            }//closing elseif statement




//         else if (p1.getTotalScore() != scoreToWin && p2.getTotalScore() == scoreToWin) {
//            System.out.format("%s won", p2.getName());
//            return true;
//        }
        return false;
    } //closing the boolean function of checking if anyone has won

    public static void main(String[] args) {  //create a banner of welcome to 30 or bust
        System.out.println("           888       888 8888888888 888      .d8888b.   .d88888b.  888b     d888 8888888888         \n" +
                "           888   o   888 888        888     d88P  Y88b d88P\" \"Y88b 8888b   d8888 888                \n" +
                "           888  d8b  888 888        888     888    888 888     888 88888b.d88888 888                \n" +
                "           888 d888b 888 8888888    888     888        888     888 888Y88888P888 8888888            \n" +
                "           888d88888b888 888        888     888        888     888 888 Y888P 888 888                \n" +
                "           88888P Y88888 888        888     888    888 888     888 888  Y8P  888 888                \n" +
                "           8888P   Y8888 888        888     Y88b  d88P Y88b. .d88P 888   \"   888 888                \n" +
                "           888P     Y888 8888888888 88888888 \"Y8888P\"   \"Y88888P\"  888       888 8888888888         \n" +
                "                                                                                                    \n" +
                "                                                                                                    \n" +
                "                                                                                                    \n" +
                "                                    88888888888 .d88888b.                                           \n" +
                "                                        888    d88P\" \"Y88b                                          \n" +
                "                                        888    888     888                                          \n" +
                "                                        888    888     888                                          \n" +
                "                                        888    888     888                                          \n" +
                "                                        888    888     888                                          \n" +
                "                                        888    Y88b. .d88P                                          \n" +
                "                                        888     \"Y88888P\"                                           \n" +
                "                                                                                                    \n" +
                "                                                                                                    \n" +
                "                                                                                                    \n" +
                " .d8888b.   .d8888b.        .d88888b.  8888888b.       888888b.   888     888  .d8888b. 88888888888 \n" +
                "d88P  Y88b d88P  Y88b      d88P\" \"Y88b 888   Y88b      888  \"88b  888     888 d88P  Y88b    888     \n" +
                "     .d88P 888    888      888     888 888    888      888  .88P  888     888 Y88b.         888     \n" +
                "    8888\"  888    888      888     888 888   d88P      8888888K.  888     888  \"Y888b.      888     \n" +
                "     \"Y8b. 888    888      888     888 8888888P\"       888  \"Y88b 888     888     \"Y88b.    888     \n" +
                "888    888 888    888      888     888 888 T88b        888    888 888     888       \"888    888     \n" +
                "Y88b  d88P Y88b  d88P      Y88b. .d88P 888  T88b       888   d88P Y88b. .d88P Y88b  d88P    888     \n" +
                " \"Y8888P\"   \"Y8888P\"        \"Y88888P\"  888   T88b      8888888P\"   \"Y88888P\"   \"Y8888P\"     888     \n" +
                "                                                                                                     ");
        System.out.println();
        System.out.println();
        System.out.println("Welcome to 30 or Bust!");
        System.out.println("The goal is to hit 30 without going over it.");
        System.out.println("Each turn both you and your opponent will roll two dice.");
        System.out.println("You can choose to keep the first rolled die, or second, or both.");
        System.out.println("For each player, result is incremented after each turn.");
        System.out.println("If a player's sum exceeds 30, that player's sum get returned to 0.");
        System.out.println("First player to get 30 wins the game");
        System.out.println("Are you ready? Let go!");
        System.out.println();
        System.out.println();

        Main game = new Main(); //create a new game with Main.java

        int optionSelected; //create an option variable for the while loop

        while (true) { //a while loop checking if the game should continue. If the winning condition function returns true, end the game
            game.displayGameMenu();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            optionSelected = sc.nextInt();

            while (optionSelected > 5 || optionSelected < 0) { //a while loop with false check to determine what option does the user want

                System.out.print("Option entered invalid, please enter a number from 1 to 5: ");
                optionSelected = sc.nextInt();
            }//closing bracket for the game option while loop
            if (optionSelected == 5) { //quit the game if user input a 5
                System.out.println("Exiting game");
                break;
            }// closing bracket for the if above

            game.selectGameOption(optionSelected); //pass in the user selected option

            boolean anyoneWin = game.checkIfAnyoneHasWon(); //call for the checkAnyOneWin function to decide if any player has won, and decide if the game should continue
            if (anyoneWin) {
                System.out.println();
                System.out.println("Game ended.");
                break;
            } // closing bracket for the if above
        } //closing bracket for the first while loop
    }// closing main arg

}