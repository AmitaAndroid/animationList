package com.practice.animaionlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FootballActivity extends Activity{

    ImageView ball;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
        ball=(ImageView)findViewById(R.id.ball);

        String footballAnimation=getIntent().getStringExtra("footballAnimation");

        switch (footballAnimation){
            case "Anticipate":
                animation = AnimationUtils.loadAnimation(this, R.anim.anticipate_interpolator_eg);
                break;
            case "Overshoot":
                animation = AnimationUtils.loadAnimation(this, R.anim.anticipate_overdose_eg);
                break;
            case "Mix":
                animation=AnimationUtils.loadAnimation(this, R.anim.mix_interpolator);
                break;
            default:
                animation = AnimationUtils.loadAnimation(this, R.anim.anticipate_interpolator_eg);
                break;
        }
        ball.startAnimation(animation);
    }
}
