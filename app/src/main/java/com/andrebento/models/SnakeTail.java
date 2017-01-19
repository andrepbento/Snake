package com.andrebento.models;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.andrebento.snake.R;

/**
 * Created by andre on 18/01/2017.
 */

public class SnakeTail extends SnakePiece {
    private Context context;

    public SnakeTail(Context context, int posX, int posY, int direction) {
        super(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_tail_right),
                posX, posY, direction);
        this.context = context;
    }

    public void setTailUp() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_tail_up));
    }

    public void setTailRight() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_tail_right));
    }

    public void setTailDown() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_tail_down));
    }

    public void setTailLeft() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.snake_tail_left));
    }
}
