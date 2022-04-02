package com.example.memorygame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.core.content.ContextCompat;

public class CardButton extends androidx.appcompat.widget.AppCompatButton {

    protected int row;
    protected int column;
    protected int cardId;

    protected boolean flipped;
    protected boolean matched;

    protected Drawable frontImage;
    protected Drawable backImage;

    public CardButton(Context context, int r, int c, int cId) {

        super(context);

        row = r;
        column = c;
        cardId = cId;

        frontImage = ContextCompat.getDrawable(context, cId);
        backImage = ContextCompat.getDrawable(context, R.drawable.card_back);
        setBackground(backImage);

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(r), GridLayout.spec(c));
        layoutParams.width = (int) getResources().getDisplayMetrics().density * 60;
        layoutParams.height = (int) getResources().getDisplayMetrics().density * 90;
        setLayoutParams(layoutParams);

    }

    public boolean getMatched() {
        return matched;
    }

    public void setMatched(boolean m) {
        matched = m;
    }

    public int getCardId() {
        return cardId;
    }

    public void flip() {
        if(matched) return;

        if(flipped) {
            setBackground(backImage);
            flipped = false;
        } else {
            setBackground(frontImage);
            flipped = true;
        }
    }



}
