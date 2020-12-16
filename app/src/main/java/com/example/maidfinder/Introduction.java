package com.example.maidfinder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Introduction extends AppCompatActivity {
    LottieAnimationView ltview;
    TextView tview;
    private static final int SPLASH_TIME_OUT=5500;
    SharedPreferences msharedPref;
    Timer timer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        ltview = findViewById(R.id.userlogo);
        tview=findViewById(R.id.textView);
        ltview.animate().translationX(1600).setDuration(1000).setStartDelay(4000);
        tview.animate().translationX(-1600).setDuration(1000).setStartDelay(4000);

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(Introduction.this,walkthrough.class);
                startActivity(intent);
                finish();
            }
        },4700);
    }
}