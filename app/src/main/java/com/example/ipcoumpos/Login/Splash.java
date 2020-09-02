package com.example.ipcoumpos.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ipcoumpos.MainActivity;
import com.example.ipcoumpos.R;

public class Splash extends AppCompatActivity implements Animation.AnimationListener {

    Animation animFadeIn;
    RelativeLayout linearLayout;
    ActionBar actionBar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        actionBar= getSupportActionBar();
        actionBar.hide();

        changestatusbarcolor();
        if(Build.VERSION.SDK_INT>=21){
            /*getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN);*/
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
        }

        // load the animation
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation_fade_in);
        // set animation listener
        animFadeIn.setAnimationListener(this);
        // animation for image
        linearLayout = (RelativeLayout) findViewById(R.id.layout_linear);
        // start the animation
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.startAnimation(animFadeIn);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void changestatusbarcolor(){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP);
        Window window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        // Start Main Screen
        SharedPreferences ss=getSharedPreferences("session",MODE_PRIVATE);
        if (Integer.parseInt(ss.getString("Act","0"))==1){
            Intent i = new Intent(Splash.this, MainActivity.class);
            startActivity(i);
        }else {
            Intent i = new Intent(Splash.this, IntroActivity.class);
            startActivity(i);

        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
