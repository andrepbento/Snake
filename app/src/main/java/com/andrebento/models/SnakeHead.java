package com.andrebento.models;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.andrebento.interfaces.Constants;
import com.andrebento.snake.R;

/**
 * Created by andre on 18/01/2017.
 */

public class SnakeHead extends SnakePiece {
    Context context;

    public SnakeHead(Context context) {
        super(BitmapFactory.decodeResource(context.getResources(), R.drawable.head_right),
                Constants.nHorizontalCells / 2,
                Constants.nVerticalCells / 2,
                Constants.RIGHT);
        this.context = context;
    }

    public void setHeadUp() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.head_up));
    }

    public void setHeadRight() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.head_right));
    }

    public void setHeadDown() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.head_down));
    }

    public void setHeadLeft() {
        super.setImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.head_left));
    }
}
