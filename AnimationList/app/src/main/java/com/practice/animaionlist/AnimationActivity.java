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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageView=(ImageView)findViewById(R.id.imageView);

        int position=getIntent().getIntExtra("position",0);

        switch (position){
            case 0:
                animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim1);
        }

        imageView.startAnimation(animation);
    }
}
