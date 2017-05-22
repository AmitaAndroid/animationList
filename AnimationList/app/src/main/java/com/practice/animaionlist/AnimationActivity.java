package com.practice.animaionlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    ImageView imageView;
    Animation animation;
    int index=0;
//    int imageArray[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageView=(ImageView)findViewById(R.id.imageView);

        int position=getIntent().getIntExtra("position",0);

        runSlider();

        switch (position){
            case 0:
                animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim1);
        }

        imageView.startAnimation(animation);
    }

    private void runSlider() {Thread timer = new Thread()
    {
        public void run()
        {
            try
            {
                sleep(2000);
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageView.setImageResource(R.drawable.a);
                    }
                });

                sleep(2000);
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageView.setImageResource(R.drawable.b);
                    }
                });

                sleep(2000);
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageView.setImageResource(R.drawable.c);
                    }
                });

                sleep(2000);
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageView.setImageResource(R.drawable.d);
                    }
                });

                sleep(2000);
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageView.setImageResource(R.drawable.e);
                    }
                });

                sleep(2000);
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageView.setImageResource(R.drawable.f);
                    }
                });

                sleep(2000);
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageView.setImageResource(R.drawable.g);
                    }
                });

                sleep(2000);
                runOnUiThread(new Runnable() {
                    public void run() {
                        imageView.setImageResource(R.drawable.h);
                        index=10;
                    }
                });
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    };
        timer.start();
    }
}
