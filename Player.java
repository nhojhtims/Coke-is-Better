package com.company;

public class Player {
    private final String name;
    private int totalScore;

    Player(String name){ //create a player that has a name
        this.name = name;
    } //close Player(String name)

    String getName(){ //return the name that user has given
        return name;
    } //close getName

    int getTotalScore(){ //return the sum of total score for a player
        return totalScore;
    }//close getTotalScore

    void setTotalScore(int score){ //accumulates each roll, or score
        totalScore += score;
    }//close setTotalScore

    int resetScore() { //resetting score sum back to 0
        totalScore = 0;
        return 0;
    }// close resetScore

} //close this class