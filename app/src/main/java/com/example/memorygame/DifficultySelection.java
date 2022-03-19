package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultySelection extends AppCompatActivity {
    private Button buttonEasy;
    private Button buttonMedium;
    private Button buttonHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selection);

        //For all the buttons add an attribute that affects difficulty
        //Easy button
        buttonEasy = findViewById(R.id.button_easy);
        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DifficultySelection.this, GameBoard.class);
                startActivity(intent);
            }
        });

        //Medium button
        buttonMedium = findViewById(R.id.button_medium);
        buttonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DifficultySelection.this, GameBoard.class);
                startActivity(intent);
            }
        });

        //Hard button
        buttonHard = findViewById(R.id.button_hard);
        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DifficultySelection.this, GameBoard.class);
                startActivity(intent);
            }
        });
    }
}