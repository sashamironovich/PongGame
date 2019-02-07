package com.myronovych.pong;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class PongGame extends SurfaceView implements Runnable {
    private final boolean DEBUGGING = true;

    private SurfaceHolder mOurHolder;
    private Canvas mCanvas;
    private Paint mPaint;

    //frames per second
    private long mFPS;

    private final int MILLIS_IN_SECOND = 1000;

    private int mScreenX;
    private int mScreenY;

    //text
    private int mFontSize;
    private int mFontMargin;

    //objects
    private Bat mBat;
    private Ball mBall;

    private int mScore;
    private int mLives;

    //thread
    private Thread mGameThread = null;
    private volatile boolean mPlaying;
    private boolean mPause = true;


    public PongGame(Context context, int x, int y){
        super(context);

        mScreenX = x;
        mScreenY=y;

        mFontSize = (int)(0.05*mScreenX);
        mFontMargin = (int)(0.15*mScreenY);

        mOurHolder = getHolder();
        mPaint = new Paint();

        //init the bat and ball

        //we are ready to start the game
        startNewGame();



    }

    @Override
    public void run() {

    }

    //when player quits game
    public void pause(){
        mPlaying = false;
        try{
            //stop the thread
            mGameThread.join();
        }catch(InterruptedException e){
            Log.e("Error: " , "joining thread");
        }


    }

    //when player starts the game
    public void resume(){
        mPlaying = true;
        mGameThread = new Thread(this);

        //starting thread
        mGameThread.start();
    }

    //staring the new game
    private void startNewGame(){
        //put the ball back to start position

        //reset score and lives
        mScore = 0;
        mLives = 3;


    }


    //drawing objects and the HUD
    private void draw(){
        if(mOurHolder.getSurface().isValid()){
            //lock the canvas (graphics memory) ready to draw
            mCanvas = mOurHolder.lockCanvas();

            //fill the screen with a solid color
            mCanvas.drawColor(Color.argb(255,26,128,182));

            //choosing color to paint with
            mPaint.setColor(Color.argb(255,255,255,255));

            //draw the bat andd ball

            //Choose the font size
            mPaint.setTextSize(mFontSize);

            //draw HUD
            mCanvas.drawText("Score: " + mScore + " Lives: " + mLives, mFontMargin,mFontSize,mPaint);

            if(DEBUGGING){
                printDebbugingText();
            }

        }
        //display the drawing
        //unlockCanvasAndPost is a method of SurfaceView
        mOurHolder.unlockCanvasAndPost(mCanvas);

    }

    private void printDebbugingText(){
        int debugSize = mFontSize/2;
        int debugStart = 150;
        mPaint.setTextSize(debugSize);
        mCanvas.drawText("FPS: " + mFPS,10,debugStart+debugSize,mPaint);
    }


}
