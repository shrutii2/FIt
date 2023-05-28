package com.rishav.instaclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class subscriptionplans extends AppCompatActivity {


    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriptionplans);


        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        button1= findViewById(R.id.startyoga1);
        button2= findViewById(R.id.startyoga2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(subscriptionplans.this,SecondActivity.class);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(subscriptionplans.this,SecondActivity2.class);
            }
        });
    }



    public void beforeage18(View view) {
        Intent intent = new Intent(subscriptionplans.this,SecondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent = new Intent(subscriptionplans.this,SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(subscriptionplans.this,FoodActivity.class);
        startActivity(intent);
    }
}