package com.example.memorygame;

public class Score implements Comparable<Score>{
    private String score;
    private String name;


    public Score(String n, String s) {
        this.score = s;
        this.name = n;
    }
    public Score(Score s) {
        this.score = s.getScore();
        this.name = s.getName();
    }

    public String getScore() {
        return this.score;
    }
    public String getName() {
        return this.name;
    }

    public int compareTo(Score other) {
        double tempThisScore = Double.parseDouble(this.score);
        double tempOtherScore = Double.parseDouble(other.score);
        return Double.compare(tempThisScore, tempOtherScore);
    }
}
