package com.example.maidfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class housepostjob extends AppCompatActivity {
    DatabaseReference reference;
    FirebaseDatabase rootNode;
    TextInputLayout mskills,myourname,mexpectedsal,mhemail;
    String maids;
    Button post,postgoback;
    String username;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housepostjob);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("house");
        mskills=findViewById(R.id.Skills);
        mhemail=findViewById(R.id.shift);
        myourname=findViewById(R.id.yourname);
        mexpectedsal=findViewById(R.id.salary);
        post=findViewById(R.id.housepostbutton);
        postgoback=findViewById(R.id.housepostgoback);
        userdata();
        post.setOnClickListener((View.OnClickListener) view -> {

            String Skills = mskills.getEditText().getText().toString();
            String name = myourname.getEditText().getText().toString();
            String salary= mexpectedsal.getEditText().getText().toString();
            String shift=mhemail.getEditText().getText().toString();
            helperclass3 helperClass = new helperclass3(Skills,name,salary,shift,email);
            reference.child(username).setValue(helperClass);
            Toast.makeText(this,"You posted successfully",Toast.LENGTH_SHORT).show();

        });
        postgoback.setOnClickListener((View.OnClickListener) view -> {
            Intent intent = new Intent(getApplicationContext(),Profile.class);
            startActivity(intent);
            finish();
        });
    }
    private void userdata() {
        Intent intent=getIntent();
        username = intent.getStringExtra("username");
        email=intent.getStringExtra("email");

    }}