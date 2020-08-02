package com.startuppro;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Process extends AppCompatActivity {

    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        actionBar=getSupportActionBar();
        actionBar.hide();

    }


}
