package com.andrebento.models;

import android.content.Context;
import android.graphics.Canvas;

import com.andrebento.interfaces.Constants;

/**
 * Created by andre on 18/01/2017.
 */

public class Game {
    private boolean running;
    private long sleepTime;

    public static int height, width, cellHeight, cellWidth;

    private Snake snake;
    private Food food;
    private int score;
    private int lifes;

    public Game(Context context, int width, int height) {
        this.running = true;
        this.sleepTime = MySharedPreferences.loadVelocity(context);
        this.width = width;
        this.height = height;
        cellWidth = this.width / Constants.nHorizontalCells;
        cellHeight = this.height / Constants.nVerticalCells;
        this.snake = new Snake(context);
        this.food = new Food(context);
        this.score = 0;
        this.lifes = 3;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public long getSleepTime() {
        return this.sleepTime;
    }

    public void setSnakeDirection(int newDirection) {
        this.snake.setHeadDirection(newDirection);
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLifes() {
        return this.lifes;
    }

    public void update() {
        snake.move();
        snake.eat(this, food);
        if(snake.detectColision()) {
            lifes--;
            if(lifes <= 0)
                running = !running;
        }
    }

    public void draw(Canvas canvas) {
        snake.draw(canvas);
        food.draw(canvas);
    }
}
