package com.startuppro;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Awards extends AppCompatActivity {


    ActionBar actionBar;
    ImageView button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awards);

        button=findViewById(R.id.regg);
        actionBar=getSupportActionBar();
        actionBar.hide();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Awards.this, Registeration.class);
                startActivity(in);
            }
        });
    }


}
