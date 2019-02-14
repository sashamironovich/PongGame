package com.myronovych.pong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

public class PongActivity extends Activity {

    private PongGame mPongGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        mPongGame = new PongGame(this,size.x,size.y);
        setContentView(mPongGame);
    }

    @Override
    protected void onResume(){
        super.onResume();
        //more code later
        mPongGame.resume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        //more code later
        mPongGame.pause();
    }
}
