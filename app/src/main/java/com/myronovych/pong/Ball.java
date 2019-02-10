package com.myronovych.pong;

import android.graphics.RectF;

class Ball {
    private RectF mRect;
    private float mXVelocity;
    private float mYVelocity;
    private float mBallWidth;
    private float mBallHeight;


    Ball(int screenX){
        mBallWidth = screenX/100;
        mBallHeight = screenX/100;

        mRect = new RectF();
    }

    RectF getRect(){
        return mRect;
    }

    void update(long fps){
        mRect.left = mRect.left+(mXVelocity/fps);
        mRect.top = mRect.top+(mYVelocity/fps);

        mRect.right = mRect.left+mBallWidth;
        mRect.bottom = mRect.top+mBallHeight;
    }

    void reverseYVelocity(){
        mYVelocity = -mYVelocity;
    }

    void reverseXVelocity(){
        mXVelocity = -mXVelocity;
    }

    void reset(int x ,int y){
        mRect.left=x/2;
        mRect.top=0;
        mRect.right=x/2+mBallWidth;
        mRect.bottom = mBallHeight;

        mYVelocity = -(y/3);
        mXVelocity = y/3;
    }

    void increaseVelocity(){
        mXVelocity=mXVelocity*1.1f;
        mYVelocity=mYVelocity*1.1f;
    }

    void batBounce(RectF batPosition){
        //centre of bat
        float batCenter = batPosition.left+(batPosition.width()/2);

        //detect the centre of the ball
        float ballCenter = mRect.left+(mBallWidth/2);

        //where on the bat did the ball hit
        float relativeIntersact = batCenter-ballCenter;

        //pick a bounce direction
        if(relativeIntersact<0){
            //go right
            mXVelocity = Math.abs(mXVelocity);
        }else{
            //go left
            mXVelocity = -Math.abs(mXVelocity);

        }

        reverseYVelocity();
    }
}
