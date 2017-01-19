package com.andrebento.interfaces;

/**
 * Created by andre on 18/01/2017.
 */

public class Constants {
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;

    public static final int nVerticalCells = 10;
    public static final int nHorizontalCells = 20;

    public static int randomMinMax(int min, int max) {
        return min + (int)(Math.random() * max);
    }
}

