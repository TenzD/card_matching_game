package com.example.memorygame;

public class Score {
    private String score;
    private String name;

    public Score(String n, String s) {
        score = s;
        name = n;
    }
    public Score(Score s) {
        score = s.getScore();
        name = s.getName();
    }

    public String getScore() {
        return score;
    }
    public String getName() {
        return name;
    }

}
