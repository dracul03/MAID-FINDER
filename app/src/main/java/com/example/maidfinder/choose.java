package com.example.maidfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class choose extends AppCompatActivity {
    LottieAnimationView maidanim;
    LottieAnimationView houseanim;
    private static final int SPLASH_TIME_OUT=5500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        maidanim = findViewById(R.id.maidlogo);
        houseanim=findViewById(R.id.houselogo);
        maidanim.animate().setDuration(0);
        houseanim.animate().setDuration(0);
        maidanim.setOnClickListener((View.OnClickListener) view -> {
            Intent intent=new Intent(choose.this,loginactivity.class);
            startActivity(intent);
            finish();
        });
        houseanim.setOnClickListener((View.OnClickListener) view -> {
            Intent intent=new Intent(choose.this,houselogin.class);
            startActivity(intent);
            finish();
        });

    }
}