package com.rishav.instaclone;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SecondActivity2 extends AppCompatActivity {


    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        newArray = new int[]{

                R.id.bow_pose,R.id.bridge_pose, R.id.chair_pose,R.id.child_pose, R.id.cobler_pose, R.id.cow_pose, R.id.playji_pose, R.id.pauseji_pose, R.id.plank_pose,R.id.crunches_pose, R.id.situp_pose, R.id.rotation_pose, R.id.twist_pose,R.id.windmill_pose, R.id.legup_pose,


        };
    }




    public void Imagebuttonclicked(View view) {

        for(int i=0; i<newArray.length; i++){
            if(view.getId()==newArray[i]){
                int value = i+1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}