package com.nathaliebritan.streamess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        imageSplash = (ImageView) findViewById(R.id.img_splash_icon);

        Animation fading =  AnimationUtils.loadAnimation(this, R.anim.animation_fade_out);
        fading.setFillAfter(true);
        fading.setFillEnabled(true);
        fading.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, LoginSignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        imageSplash.setAnimation(fading);
    }
}
