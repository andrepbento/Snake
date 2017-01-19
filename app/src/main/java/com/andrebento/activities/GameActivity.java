package com.andrebento.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrebento.interfaces.Constants;
import com.andrebento.models.Game;
import com.andrebento.snake.R;
import com.andrebento.snake.SnakeApplication;
import com.andrebento.views.GameView;

public class GameActivity extends Activity implements View.OnClickListener {
    TextView tvScore;
    ImageView ivHeart1, ivHeart2, ivHeart3;

    protected GameView snakeGameView;
    private Thread gameThread;

    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvScore = (TextView) findViewById(R.id.tv_score);

        ivHeart1 = (ImageView) findViewById(R.id.iv_life_1);
        ivHeart2 = (ImageView) findViewById(R.id.iv_life_2);
        ivHeart3 = (ImageView) findViewById(R.id.iv_life_3);

        this.snakeGameView = new GameView(getApplicationContext());
        ((FrameLayout) findViewById(R.id.fl_game_view)).addView(snakeGameView);


        if(savedInstanceState == null) {
            snakeGameView.post(new Runnable() {
                @Override
                public void run() {
                    snakeGameView.setSnakeGame(new Game(getApplicationContext(), snakeGameView.getMeasuredWidth(),
                            snakeGameView.getMeasuredHeight()));
                    tvScore.setText(String.valueOf(snakeGameView.getSnakeGame().getScore()));
                    gameThread.start();
                }
            });
        } else {
            SnakeApplication snakeApplication = (SnakeApplication) getApplication();
            this.snakeGameView.setSnakeGame(snakeApplication.getSnakeGame());
        }

        gameThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(snakeGameView.getSnakeGame().isRunning()) {
                    snakeGameView.getSnakeGame().update();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvScore.setText(String.valueOf(snakeGameView.getSnakeGame().getScore()));
                            switch (snakeGameView.getSnakeGame().getLifes()) {
                                case 1:
                                    ivHeart2.setVisibility(View.INVISIBLE);
                                    break;
                                case 2:
                                    ivHeart3.setVisibility(View.INVISIBLE);
                                    break;
                            }
                            snakeGameView.invalidate();
                        }
                    });
                    try {
                        Thread.sleep(snakeGameView.getSnakeGame().getSleepTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        prepareTouchSettings();
    }

    @Override
    protected void onPause() {
        super.onPause();
        snakeGameView.getSnakeGame().setRunning(false);
    }

    private void prepareTouchSettings() {
        gestureDetector = new GestureDetector(new MyGestureDetector());

        gestureListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        };

        this.snakeGameView.setOnClickListener(this);
        this.snakeGameView.setOnTouchListener(gestureListener);
    }

    @Override
    public void onClick(View view) {

    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               float velocityX, float velocityY) {

            switch (getSlope(e1.getX(), e1.getY(), e2.getX(), e2.getY())) {
                case 1:
                    Log.i("SwipeUp","SnakeUp");
                    snakeGameView.getSnakeGame().setSnakeDirection(Constants.UP);
                    return true;
                case 2:
                    Log.i("SwipeLeft", "SnakeLeft");
                    snakeGameView.getSnakeGame().setSnakeDirection(Constants.LEFT);
                    return true;
                case 3:
                    Log.i("SwipeDown","SnakeDown");
                    snakeGameView.getSnakeGame().setSnakeDirection(Constants.DOWN);
                    return true;
                case 4:
                    Log.i("SwipeRight", "SnakeRight");
                    snakeGameView.getSnakeGame().setSnakeDirection(Constants.RIGHT);
                    return true;
            }
            return false;
        }

        private int getSlope(float x1, float y1, float x2, float y2) {
            Double angle = Math.toDegrees(Math.atan2(y1 - y2, x2 - x1));
            if (angle > 45 && angle <= 135)
                // top
                return 1;
            if (angle >= 135 && angle < 180 || angle < -135 && angle > -180)
                // left
                return 2;
            if (angle < -45 && angle>= -135)
                // down
                return 3;
            if (angle > -45 && angle <= 45)
                // right
                return 4;
            return 0;
        }
    }
}
