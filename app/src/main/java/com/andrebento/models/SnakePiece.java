package com.andrebento.models;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by andre on 18/01/2017.
 */

public class SnakePiece {
    private Bitmap image;
    private int posX, posY;
    private int direction;

    public SnakePiece(Bitmap image, int posX, int posY, int direction) {
        this.image = Bitmap.createScaledBitmap(image, Game.cellWidth, Game.cellHeight, false);
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
    }

    public void setImage(Bitmap image) {
        this.image = Bitmap.createScaledBitmap(image, Game.cellWidth, Game.cellHeight, false);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, posX * Game.cellWidth, posY * Game.cellHeight, null);
    }
}
