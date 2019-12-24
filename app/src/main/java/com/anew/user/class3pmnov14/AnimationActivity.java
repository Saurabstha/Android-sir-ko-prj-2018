package com.anew.user.class3pmnov14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class AnimationActivity extends AppCompatActivity {
    LinearLayout view1,view2,view3,view4;
    Animation rotate,alpha,scale,combine,translate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        view1=findViewById(R.id.view1);
        view2=findViewById(R.id.view2);
        view3=findViewById(R.id.view3);
        view4=findViewById(R.id.view4);
        alpha= AnimationUtils.loadAnimation(this,R.anim.alpha);
        rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);
        scale= AnimationUtils.loadAnimation(this,R.anim.scale);
        combine= AnimationUtils.loadAnimation(this,R.anim.combine);
        translate= AnimationUtils.loadAnimation(this,R.anim.translate);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view1.startAnimation(alpha);
                view2.startAnimation(combine);
                view3.startAnimation(translate);
                view4.startAnimation(rotate);

            }
        });
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                view1.startAnimation(scale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view1.startAnimation(alpha);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
