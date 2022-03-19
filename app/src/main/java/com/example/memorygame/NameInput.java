package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NameInput extends AppCompatActivity {

    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        buttonNext = findViewById(R.id.button_name_input);
        buttonNext.setOnClickListener(new View.OnClickListener() { //add something to check if name is not null,
            @Override                                               //and has some sort of value inside of it
            public void onClick(View view) {
                Intent intent = new Intent(NameInput.this, DifficultySelection.class);
                startActivity(intent);
            }
        });
    }
}