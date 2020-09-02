package com.example.ipcoumpos.bottomnavigation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ipcoumpos.AdminModel;
import com.example.ipcoumpos.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainPage extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    ImageView nav,chati,noti;
    FloatingActionButton fab;

    //    ActionBar actionBar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        bottomNavigation.setItemIconTintList(null);


//        chati=findViewById(R.id.chat);
//        chati.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(MainPage.this, ChatList.class);
//                startActivity(in);
//
//            }
//        });
//
//        noti=findViewById(R.id.notification);
//        noti.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent in = new Intent(MainPage.this, Notification.class);
//                startActivity(in);
//
//            }
//        });
//
         fab = findViewById(R.id.fab);
         fab.setVisibility(View.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent in =new Intent(MainPage.this,FeedPost.class);
//                startActivity(in);
            }
        });
//
//
//        openFragment(new Timline());

        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.white));

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showFloatingActionButton() {
        fab.setVisibility(View.VISIBLE);
        bottomNavigation.setVisibility(View.VISIBLE);

    };

    public void hideFloatingActionButton() {
        fab.setVisibility(View.GONE);
        bottomNavigation.setVisibility(View.GONE);
    };

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;

                    switch (item.getItemId()) {

//                        case R.id.navigation_timeline:
//                            fragment = new Timline();
//                            fab.setVisibility(View.VISIBLE);
//                            break;
                        case R.id.navigation_home:
                            fragment = new AdminModel();
                            fab.setVisibility(View.GONE);
                            break;
//
//                        case R.id.performeance:
//                            fragment = new PerformeanceFragment();
//                            fab.setVisibility(View.GONE);
//                            break;
//                        case R.id.navigation_profile:
//                            fragment = new ProfileFragment();
//                            fab.setVisibility(View.GONE);
//                            break;
                    }
                    return loadFragment(fragment);
                }

            };

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
