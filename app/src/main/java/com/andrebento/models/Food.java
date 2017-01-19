package com.andrebento.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.andrebento.interfaces.Constants;
import com.andrebento.snake.R;

/**
 * Created by andre on 18/01/2017.
 */

public class Food {
    private Bitmap image;
    private int posX, posY;

    public Food(Context context) {
        image = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.food),
                Game.cellWidth, Game.cellHeight, false);
        setRandomPosition();
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setRandomPosition() {
        this.posX = Constants.randomMinMax(0, Constants.nHorizontalCells - 1);
        this.posY = Constants.randomMinMax(0, Constants.nVerticalCells - 1);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, posX * Game.cellWidth, posY * Game.cellHeight, null);
    }
}
