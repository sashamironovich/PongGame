package com.myronovych.pong;

import android.graphics.RectF;

class Bat {
    private RectF mRect;
    private float mLength;
    private float mXCoord;
    private float mBatSpeed;
    private int mScreenX;

    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;

    private int mBatMoving = STOPPED;

    Bat(int sx,int sy){
        mScreenX  = sx;

        mLength  = mScreenX/8;

        float height = sy/40;

        mXCoord = mScreenX/2;
        float mYCoord = sy- height;

        mRect = new RectF(mXCoord,mYCoord,mXCoord+mLength,mYCoord+height);

        //speed
        mBatSpeed = mScreenX;
    }

    RectF getRect(){
        return mRect;
    }
}
