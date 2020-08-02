package com.startuppro;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Jury extends AppCompatActivity {


    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jury);
        actionBar=getSupportActionBar();
        actionBar.hide();

    }


}
