package com.practice.animaionlist;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.app.ActionBar.LayoutParams;
public class AnimationActivity extends Activity {

    ImageSwitcher imageSwitcher;
    Animation animation;
//    int index = 0;
    //    int imageArray[]={R.drawable.a,R.drawable.f,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.b,R.drawable.g,R.drawable.h};
    private int animationCounter = 1;
    private Handler imageSwitcherHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT));
                return myView;
            }
        });
        imageSwitcherHandler = new Handler(Looper.getMainLooper());
        String animationType = getIntent().getStringExtra("animationType");

//"Scale","Translate","Rotate", "Fade In","Fade Out", "Parallel","Sequential"

        switch (animationType) {
            case "Scale":
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                break;
            case "Translate":
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                break;
            case "Rotate":
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                break;
            case "Fade In":
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                break;
            case "Fade Out":
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                break;
            case "Parallel":
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.parallel);
                break;
            case "Sequential":
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sequential);
                break;
            default:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                break;
        }
        imageSwitcher.setInAnimation(animation);
//        imageSwitcher.setInAnimation(animation);

        imageSwitcherHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (animationCounter++) {
                    case 1:
                        imageSwitcher.setImageResource(R.drawable.a);
                        break;
                    case 2:
                        imageSwitcher.setImageResource(R.drawable.b);
                        break;
                    case 3:
                        imageSwitcher.setImageResource(R.drawable.c);
                        break;
                    case 4:
                        imageSwitcher.setImageResource(R.drawable.d);
                        break;
                    case 5:
                        imageSwitcher.setImageResource(R.drawable.e);
                        break;
                    case 6:
                        imageSwitcher.setImageResource(R.drawable.f);
                        break;
                    case 7:
                        imageSwitcher.setImageResource(R.drawable.g);
                        break;
                    case 8:
                        imageSwitcher.setImageResource(R.drawable.h);
                        break;
                    case 9:
                        imageSwitcher.setImageResource(R.drawable.i);
                        break;

                }
                animationCounter %= 9;
                if (animationCounter == 0) animationCounter = 1;

                imageSwitcherHandler.postDelayed(this, 3000);
            }
        });
    }
}
