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

import java.util.Map;


public class postjob extends AppCompatActivity {
    DatabaseReference reference;
    FirebaseDatabase rootNode;
    TextInputLayout mskills,mworkinghours,mexpectedsal,mshifts;
    String maids;
    Button post,postgoback;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postjob);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Maid");
        mskills=findViewById(R.id.SKILLS);
        mshifts=findViewById(R.id.shiftpreference);
        mworkinghours=findViewById(R.id.workinghours);
        mexpectedsal=findViewById(R.id.expectedsalary);
        post=findViewById(R.id.post);
        postgoback=findViewById(R.id.postgoback);
        userdata();
        post.setOnClickListener((View.OnClickListener) view -> {

            String skills = mskills.getEditText().getText().toString();
            String workinghours = mworkinghours.getEditText().getText().toString();
            String expectedsal= mexpectedsal.getEditText().getText().toString();
            String shift= mshifts.getEditText().getText().toString();
            userhelperclass2 helperClass = new userhelperclass2(skills,workinghours,expectedsal,shift);
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

    }
}