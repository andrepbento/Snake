package com.andrebento.snake;

import android.app.Application;

import com.andrebento.models.Game;

/**
 * Created by andre on 18/01/2017.
 */

public class SnakeApplication extends Application {
    private Game snakeGame;

    public SnakeApplication() {
        this.snakeGame = null;
    }

    public Game getSnakeGame() {
        return snakeGame;
    }

    public void setSnakeGame(Game snakeGame) {
        this.snakeGame = snakeGame;
    }
}
