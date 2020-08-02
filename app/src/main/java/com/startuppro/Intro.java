package com.startuppro;

import android.content.Intent;
import android.content.pm.PackageManager;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;


public class Intro extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



     FloatingActionButton fabp,fabc,fabw,fabm;
      Animation animopen,animclose,animrotate,animanti;

    RecyclerViewAdapter_H myAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Hardware_ModelClass> mylist;


    boolean isOpen = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fabp=findViewById(R.id.fab);
        fabc=findViewById(R.id.call);
        fabw=findViewById(R.id.what);
        fabm=findViewById(R.id.map);




        animopen= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        animclose=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        animrotate=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        animanti=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anti);



        fabp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    fabm.startAnimation(animclose);
                    fabc.startAnimation(animclose);
                    fabw.startAnimation(animclose);
                    fabp.startAnimation(animanti);
                    fabc.setClickable(false);
                    fabw.setClickable(false);
                    fabm.setClickable(false);

                    isOpen = false;
                } else

                {
                    fabm.startAnimation(animopen);
                    fabc.startAnimation(animopen);
                    fabw.startAnimation(animopen);
                    fabp.startAnimation(animrotate);
                    fabc.setClickable(true);
                    fabw.setClickable(true);
                    fabm.setClickable(true);
                    isOpen = true;
                }

            }
        });

        fabm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address="J3JJ+59 Delhi";
                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


        fabw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contact = "+91 8826836995"; // use country code with your phone number
                String url = "https://api.whatsapp.com/send?phone=" + contact;
                try {
                    PackageManager pm = getPackageManager();
                    pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        fabc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone="+91 8826836995";
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("tel://"+phone)));
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mylist=new ArrayList<>();
        mylist.add(new Hardware_ModelClass("Information Technology",R.drawable.itha));
        mylist.add(new Hardware_ModelClass("Electronics & Telecom",R.drawable.elecha));
        mylist.add(new Hardware_ModelClass("Education",R.drawable.eduuha));
        mylist.add(new Hardware_ModelClass("Service Provider",R.drawable.servha));
        mylist.add(new Hardware_ModelClass("Travel",R.drawable.travhaa));
        mylist.add(new Hardware_ModelClass("Other",R.drawable.othha));



        recyclerView=findViewById(R.id.recycler_H);
        myAdapter=new RecyclerViewAdapter_H(this,mylist);

        layoutManager=new GridLayoutManager(getApplicationContext(),
                2,GridLayoutManager.VERTICAL,false);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }










    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action

            Intent intent = new Intent(Intro.this, Awards.class);
            startActivity(intent);


        } else if (id == R.id.nav_gallery) {

            Intent inten = new Intent(Intro.this, Process.class);
            startActivity(inten);

        } else if (id == R.id.nav_slideshow) {

            Intent intnt = new Intent(Intro.this, Jury.class);
            startActivity(intnt);


        } else if (id == R.id.nav_manage) {

            Intent itent = new Intent(Intro.this, Media.class);
            startActivity(itent);


        }
        else if (id == R.id.nav) {

            Intent ntent = new Intent(Intro.this, AboutUs.class);
            startActivity(ntent);


        }else if (id == R.id.nav_send) {
            Intent intent = new Intent(Intro.this, ContactUs.class);
            startActivity(intent);

        }else if (id == R.id.register) {
            Intent intent = new Intent(Intro.this, Registeration.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_pri) {
            Intent intent = new Intent(Intro.this, PrivacyPolicy.class);
            startActivity(intent);

        }

        else if (id == R.id.logout) {



                    FirebaseAuth.getInstance().signOut();

                    Intent intent = new Intent(Intro.this, Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(intent);


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
