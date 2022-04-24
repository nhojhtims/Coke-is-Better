package com.company;

import java.util.Random;

public class Dice {

    private final static int numberOfSides = 6; //create a random pool from 0 - 5

    int rollDice() { //roll dice function

        int result;
        Random randomNumberGenerator = new Random(); // create a new random number generator
        result = randomNumberGenerator.nextInt(numberOfSides) + 1; //because a die does not have 0 so add 1 to the random value
        return result;
    } //close roll dice function
}//close Dice class