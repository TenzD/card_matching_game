package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonLeader;
    private Button buttonExit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start Game Button
        buttonStart = findViewById(R.id.button_start_game);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NameInput.class);
                startActivity(intent); // starts a new activity after a button press
            }
        });

        //Leaderboard button
        buttonLeader = findViewById(R.id.button_start_leaderboard);
        buttonLeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Leaderboard.class);
                startActivity(intent);
            }
        });

        //Exit Button
        buttonExit = findViewById(R.id.button_exit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0); // exits the app
            }
        });

    }
}