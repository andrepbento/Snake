package com.andrebento.models;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.andrebento.snake.R;

/**
 * Created by andre on 18/01/2017.
 */

public class SnakeBody extends SnakePiece {
    private Context context;

    public SnakeBody(Context context, int posX, int posY, int direction) {
        super(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_body_horizontal),
                posX, posY, direction);
        this.context = context;
    }

    public void setBodyHorizontal() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_body_horizontal));
    }

    public void setBodyVertical() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_body_vertical));
    }

    public void setBodyDownLeft() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_rot_down_left));
    }

    public void setBodyRightDown() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_rot_down_right));
    }

    public void setBodyUpLeft() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_rot_left_up));
    }

    public void setBodyUpRight() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_rot_right_up));
    }
}
