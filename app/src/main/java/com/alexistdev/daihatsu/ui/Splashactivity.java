package com.alexistdev.daihatsu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.alexistdev.daihatsu.R;

import java.util.Timer;
import java.util.TimerTask;


public class Splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        int timeout = 3000; // make the activity visible for 4 seconds

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                finish();
                Intent homepage = new Intent(Splashactivity.this, login.class);
                startActivity(homepage);
            }
        }, timeout);
    }
}