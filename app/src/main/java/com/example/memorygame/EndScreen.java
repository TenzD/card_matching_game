package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EndScreen extends AppCompatActivity {
    private Button buttonPlayAgain;
    private Button buttonLeaderboard;
    private Button buttonExit;
    private static ArrayList<Score> scores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        ((TextView)findViewById(R.id.time_taken)).setText(GameBoard.getTimerText());
        ((TextView)findViewById(R.id.user_name)).setText(NameInput.getName());
        ((TextView)findViewById(R.id.user_score)).setText("User Score: " + GameBoard.getScore());

        Score userScore = new Score(NameInput.getName(), GameBoard.getScore());
        scores.add(userScore);

        buttonPlayAgain = findViewById(R.id.button_play_again);
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndScreen.this, NameInput.class);
                startActivity(intent);
            }
        });

        buttonLeaderboard = findViewById(R.id.button_end_leaderboard);
        buttonLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndScreen.this, Leaderboard.class);
                startActivity(intent);
            }
        });

        buttonExit = findViewById(R.id.button_end_exit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); //for some reason this is need to close here, not sure why
                System.exit(0);
            }
        });
    }

    public static ArrayList<Score> getScores() {
        return scores;
    }

}