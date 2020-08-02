package com.startuppro;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class Splash extends AppCompatActivity {
//    Animation animFadeIn;
//    RelativeLayout linearLayout;
//    ActionBar actionBar;
//    ImageView imageView;
private VideoView videoBG;
//    MediaPlayer mMediaPlayer;
//    int mCurrentVideoPosition;
    ActionBar actionBar;


//    private boolean ispaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        actionBar=getSupportActionBar();
        actionBar.hide();
////        StatusBarUtil.setTransparent(MainActivity.this );
//        // Hook up the VideoView to our UI.
        videoBG = (VideoView) findViewById(R.id.videoView);
//
//        // Build your video Uri
//        Uri uri = Uri.parse("android.resource://" // First start with this,
//                + getPackageName() // then retrieve your package name,
//                + "/" // add a slash,
//                + R.raw.splash); // and then finally add your video resource. Make sure it is stored
//        // in the raw folder.
//
//        // Set the new Uri to our VideoView
//        videoBG.setVideoURI(uri);
//        // Start the VideoView
//        videoBG.start();
//
//        // Set an OnPreparedListener for our VideoView. For more information about VideoViews,
//        // check out the Android Docs: https://developer.android.com/reference/android/widget/VideoView.html
//        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mMediaPlayer = mediaPlayer;
//                // We want our video to play over and over so we set looping to true.
//                mMediaPlayer.setLooping(true);
//                // We then seek to the current posistion if it has been set and play the video.
//                if (mCurrentVideoPosition != 0) {
//                    mMediaPlayer.seekTo(mCurrentVideoPosition);
//                    mMediaPlayer.start();
//                }
//            }
//        });
//
//
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////        actionBar=getSupportActionBar();
////        actionBar.hide();
////        imageView=findViewById(R.id.image);
////
////        changestatusbarcolor();
////        if(Build.VERSION.SDK_INT>=21){
////            /*getWindow().getDecorView().setSystemUiVisibility(
////                    View.SYSTEM_UI_FLAG_FULLSCREEN);*/
////            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
////                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
////        }
////        else {
////            View decorView = getWindow().getDecorView();
////            // Hide the status bar.
////            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
////            decorView.setSystemUiVisibility(uiOptions);
////            // Remember that you should never show the action bar if the
////            // status bar is hidden, so hide that too if necessary.
////        }
////
////        // load the animation
////        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
////                R.anim.animation_fade_in);
////        // set animation listener
////        animFadeIn.setAnimationListener(this);
////        // animation for image
////        linearLayout = (RelativeLayout) findViewById(R.id.layout_linear);
////        // start the animation
////        linearLayout.setVisibility(View.VISIBLE);
////        linearLayout.startAnimation(animFadeIn);
//    }
//
//    private void jump() {
//
//        // Jump to your Next Activity or MainActivity
//        Intent intent = new Intent(Splash.this, Login.class);
//        startActivity(intent);
//
//        Splash.this.finish();
//
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        // Capture the current video position and pause the video.
//        mCurrentVideoPosition = mMediaPlayer.getCurrentPosition();
//        videoBG.pause();
//        ispaused = true;
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (ispaused) {
//            jump();
//        }
//        // Restart the video when resuming the Activity
////        videoBG.start();
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // When the Activity is destroyed, release our MediaPlayer and set it to null.
//      mMediaPlayer.release();
//      mMediaPlayer = null;
//
//    }
//
////    private void changestatusbarcolor(){
////        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP);
////        Window window=getWindow();
////        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
////        window.setStatusBarColor(Color.TRANSPARENT);
////    }
////
////    @Override
////    public void onAnimationStart(Animation animation) {
////
////    }
////
////    @Override
////    public void onAnimationEnd(Animation animation) {
////
////        // Start Main Screen
////        Intent i = new Intent(Splash.this, Login.class);
////        startActivity(i);
////        this.finish();
////    }
////
////    @Override
////    public void onAnimationRepeat(Animation animation) {
////
////    }
//        videoBG = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mysplash);
        videoBG.setVideoURI(video);

        videoBG.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                startNextActivity();
            }
        });

        videoBG.start();
    }

    private void startNextActivity() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, MainScreen.class));
        finish();
    }
}
