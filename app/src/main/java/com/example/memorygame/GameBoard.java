package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard extends AppCompatActivity implements View.OnClickListener {

    private TextView cardText;

    private TextView timerText;
    private Timer timer;
    private TimerTask timerTask;
    private static Double time = 0.0;

    private int[] cardImages;
    private int[] cardLocations;
    private int totalCards;
    private int cardsLeft;

    private CardButton selectedCard1;
    private CardButton selectedCard2;
    private boolean occupied = false;

    private static double score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        score = 0;

        timerText = findViewById(R.id.timer);
        timer = new Timer();
        time = 0.0;
        startTimer();

        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.game_grid);

        // GameBoard sizes for all difficulties
        if(DifficultySelection.getDifficulty() == "easy") {
            gridLayout.setColumnCount(4);
            gridLayout.setRowCount(2);
        }
        if(DifficultySelection.getDifficulty() == "medium") {
            gridLayout.setColumnCount(4);
            gridLayout.setRowCount(3);
        }
        if(DifficultySelection.getDifficulty() == "hard") {
            gridLayout.setColumnCount(4);
            gridLayout.setRowCount(4);
        }

        int columnCount = gridLayout.getColumnCount();
        int rowCount = gridLayout.getRowCount();
        totalCards = columnCount * rowCount;
        cardsLeft = totalCards;

        cardText = findViewById(R.id.cards_left);
        cardText.setText("Cards Left: " + totalCards);

        cardImages = new int[totalCards/2];

        if(DifficultySelection.getDifficulty() == "easy" || DifficultySelection.getDifficulty() == "medium" | DifficultySelection.getDifficulty() == "hard") {
            cardImages[0] = R.drawable.card_1;
            cardImages[1] = R.drawable.card_2;
            cardImages[2] = R.drawable.card_3;
            cardImages[3] = R.drawable.card_4;
        }
        if(DifficultySelection.getDifficulty() == "medium" || DifficultySelection.getDifficulty() == "hard") {
            cardImages[4] = R.drawable.card_5;
            cardImages[5] = R.drawable.card_6;
        }
        if(DifficultySelection.getDifficulty() == "hard") {
            cardImages[6] = R.drawable.card_7;
            cardImages[7] = R.drawable.card_8;
        }

        cardLocations = new int[totalCards];

        for(int i = 0; i < cardImages.length; i++) {
            cardLocations[i] = cardImages[i];
            cardLocations[i + totalCards/2] = cardImages[i];
        }

        shuffleCards();

        // inserting cards in the card grid
        for(int r = 0; r < rowCount; r++) {
            for(int c = 0; c < columnCount; c++) {
                CardButton card = new CardButton(this, r, c, cardLocations[r * columnCount + c]);
                card.setId(cardLocations[r * columnCount + c]);
                card.setOnClickListener(this);
                gridLayout.addView(card);
            }
        }


    }

    private void shuffleCards() {
        Random random = new Random();

        for(int i = 0; i < totalCards; i++) {
            int temp = cardLocations[i];
            int index = random.nextInt(totalCards/2);
            cardLocations[i] = cardLocations[index];
            cardLocations[index] = temp;
        }
    }

    private void addScore() {
        double modifier = (DifficultySelection.getDifficulty() == "easy" ? 1 : DifficultySelection.getDifficulty() == "medium" ? 1.2 : 1.4);
        score += ((int) ((100-time > 0 ? 100 - time : 10) + modifier)) * 1.0; // less score is rewarded overtime
    }

    public static String getScore() { return score + ""; }


    private void startTimer() {
        timerTask = new TimerTask() {

            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerText.setText(getTimerText());
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public static String getTimerText() {
        int currentTime = (int) Math.round(time);
        int seconds = ((currentTime % 86400) % 3600) % 60;
        int minutes = ((currentTime % 86400) % 3600) / 60;

        return "Time Elapsed: " + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
    }

    @Override
    public void onClick(View view) {

        CardButton card = (CardButton) view; //the selected card

        if(occupied) return;
        if(card.getMatched()) return;

        if(selectedCard1 == null) {
            selectedCard1 = card;
            selectedCard1.flip();
            return;
        }

        if(selectedCard1.getCardId() == card.getCardId() && (selectedCard1.row != card.row || selectedCard1.column != card.column)) {
            selectedCard2 = card;
            selectedCard2.flip();

            selectedCard2.setMatched(true);
            selectedCard1.setMatched(true);

            selectedCard1 = null;

            cardsLeft -= 2; // both cards match, remove 2 from total
            cardText.setText("Cards Left: " + cardsLeft);
            addScore();

            // Win Condition
            if(cardsLeft == 0) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        timerTask.cancel();
                        Intent intent = new Intent(GameBoard.this, EndScreen.class);
                        startActivity(intent);
                    }
                }, 500);
            }



        } else { // flip over the two selected cards
            occupied = true; //no other cards should be able to be selected
            selectedCard2 = card;
            selectedCard2.flip();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectedCard2.flip();
                    selectedCard1.flip();
                    selectedCard1 = null; //resets selected cards
                    selectedCard2 = null;
                    occupied = false;
                }
            }, 400); // delays the card flip
        }
    }

}