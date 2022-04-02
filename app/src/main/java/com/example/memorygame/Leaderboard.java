package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Leaderboard extends AppCompatActivity {
    private Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        buttonExit = findViewById(R.id.button_leaderboard_exit);
        buttonExit.setOnClickListener(new View.OnClickListener() { //there probably need an probably need an if else for different scenarios
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Leaderboard.this, MainActivity.class);
                startActivity(intent); // starts a new activity after a button press
            }
        });

        androidx.gridlayout.widget.GridLayout leaderboardGrid  = findViewById(R.id.leaderboard_grid);

        // render scores
        for(int i = 0; i < EndScreen.getScores().size(); i++) {
            TextView score = new TextView(this);
            score.setText((EndScreen.getScores().get(i).getName() + ": " + EndScreen.getScores().get(i).getScore()));
            leaderboardGrid.addView(score);
        }

    }
}