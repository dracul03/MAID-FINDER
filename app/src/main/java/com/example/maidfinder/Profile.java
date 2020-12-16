package com.example.maidfinder;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Profile extends AppCompatActivity {

    LottieAnimationView mpostjob,mwork,mupdateprofile,mneedskills;
    String _username,_name,_email,_phoneno,_password,_address,_address2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        mpostjob = findViewById(R.id.welcomeanim1);
        mwork = findViewById(R.id.welcomeanim2);
        mupdateprofile= findViewById(R.id.welcomeanim3);
        mneedskills = findViewById(R.id.welcomeanim4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mupdateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata();
                Intent intent = new Intent(getApplicationContext(),updateinfo.class);
                intent.putExtra("name",_name);
                intent.putExtra("username",_username);
                intent.putExtra("phone",_phoneno);
                intent.putExtra("email",_email);
                intent.putExtra("password",_password);
                intent.putExtra("address",_address);
                intent.putExtra("address2",_address2);
                startActivity(intent);
                finish();
            }
        });
        mpostjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdata();
                Intent intent = new Intent(getApplicationContext(),postjob.class);
                intent.putExtra("name",_name);
                intent.putExtra("username",_username);
                intent.putExtra("phone",_phoneno);
                intent.putExtra("email",_email);
                intent.putExtra("password",_password);
                intent.putExtra("address",_address);
                intent.putExtra("address2",_address2);
                startActivity(intent);
                finish();
            }
        });
        mwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Jobfinder.class);
                startActivity(intent);
            }
        });

    }



    private void userdata(){
        Intent intent=getIntent();
        _name=intent.getStringExtra("name");
        _username=intent.getStringExtra("username");
        _email=intent.getStringExtra("email");
        _address=intent.getStringExtra("address");
        _address2=intent.getStringExtra("address2");
        _phoneno=intent.getStringExtra("phone");
        _password=intent.getStringExtra("password");

        //fullname.settext();



    }
}