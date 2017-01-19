package com.andrebento.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.andrebento.interfaces.Constants;
import com.andrebento.models.Game;

/**
 * Created by andre on 18/01/2017.
 */

public class GameView extends View {
    private Game snakeGame;

    public GameView(Context context) {
        super(context);
        this.snakeGame = null;
    }

    public Game getSnakeGame() {
        return this.snakeGame;
    }

    public void setSnakeGame(Game snakeGame) {
        this.snakeGame = snakeGame;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //drawGrid(canvas);
        snakeGame.draw(canvas);
        //printLog();
    }

    private void printLog() {
        System.out.println("L:"+Game.width+"\tA:"+Game.height+"\n"
            +"HC:"+ Constants.nHorizontalCells+"\t"+"VC:"+Constants.nVerticalCells);
    }

    private void drawGrid(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5.0f);
        paint.setStyle(Paint.Style.STROKE);

        for(int x = 0; x < Constants.nHorizontalCells; x++)
            for(int y = 0; y < Constants.nVerticalCells; y++)
                canvas.drawRect(x * Game.cellHeight, y * Game.cellWidth,
                        (x + 1) * Game.cellHeight,
                        (y + 1) * Game.cellWidth, paint);
    }
}
