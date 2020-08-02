package com.startuppro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {
    private PreferenceManager preferenceManager;
    private LinearLayout Layout_bars;
    private TextView[] bottomBars;
    private int[] screens;
    Button Skip, Next;
    private ViewPager vp;
    private MyViewPagerAdapter myvpAdapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        vp = (ViewPager) findViewById(R.id.view_pager);
        Layout_bars = (LinearLayout) findViewById(R.id.layoutBars);
        Skip = (Button) findViewById(R.id.skip);
        Next = (Button) findViewById(R.id.next);
        actionBar=getSupportActionBar();
        actionBar.hide();

        screens = new int[]{
                R.layout.intro_screen1,
                R.layout.intro_screen2,
                R.layout.intro_screen3
        };

        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_FULLSCREEN);
        }



        preferenceManager = new PreferenceManager(this);
        //vp.addOnPageChangeListener(viewPagerPageChangeListener);
        if (!preferenceManager.FirstLaunch()) {
            launchMain();
            finish();
        }

        myvpAdapter = new MyViewPagerAdapter();
        vp.setAdapter(myvpAdapter);
        vp.addOnPageChangeListener(viewPagerPageChangeListener);

        changestatusbarcolor();
        ColoredBars(0);
        skipButton();
        NextButton();
    }

       public void skipButton(){
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMain();
            }
        });
       }
       public void NextButton(){
           Next.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int current=getItem(+1);
                   if(current<screens.length){
                       vp.setCurrentItem(current);
                   }
               }
           });
       }


    private void ColoredBars(int thisScreen) {
        int[] colorsInactive = getResources().getIntArray(R.array.dot_on_page_not_active);
        int[] colorsActive = getResources().getIntArray(R.array.dot_on_page_active);
        bottomBars = new TextView[screens.length];

        Layout_bars.removeAllViews();
        for (int i = 0; i < bottomBars.length; i++) {
            bottomBars[i] = new TextView(this);
            bottomBars[i].setTextSize(35);
            bottomBars[i].setText(Html.fromHtml("&#8226;"));
           // bottomBars[i].setTextColor(colorsInactive[thisScreen]);
            Layout_bars.addView(bottomBars[i]);
            bottomBars[i].setTextColor(colorsInactive[thisScreen]);
        }
        if (bottomBars.length > 0){
            bottomBars[thisScreen].setTextColor(colorsActive[thisScreen]);
        }

    }

    private int getItem(int i) {
        return vp.getCurrentItem() + i;
    }

    private void launchMain() {
        preferenceManager.setFirstTimeLaunch(false);
        startActivity(new Intent(MainScreen.this, Login.class));
        finish();
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener =
            new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            ColoredBars(position);
            if (position == screens.length - 1) {
                Next.setText("start");
                Skip.setVisibility(View.GONE);
                Next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in=new Intent(MainScreen.this,Login.class);
                        startActivity(in);
                        finish();
                        launchMain();
                    }
                });

            } else {
                Next.setText("Next");
                Skip.setVisibility(View.VISIBLE);
                NextButton();
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void changestatusbarcolor(){
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP);
        Window window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    public class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater inflater;

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(screens[position],container,false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return screens.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view=(View)object;
            container.removeView(view);
        }
    }
}
