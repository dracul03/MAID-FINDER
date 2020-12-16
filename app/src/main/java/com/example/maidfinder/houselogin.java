package com.example.maidfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class houselogin extends AppCompatActivity {

    Button mhouseregister;
    Button mhouseloginbutton;
    TextInputLayout muserlogin,mpasslogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houselogin);
        mhouseregister=findViewById(R.id.houseregister);
        mhouseloginbutton=findViewById(R.id.houselogin);
        muserlogin=findViewById(R.id.houseuser);
        mpasslogin=findViewById(R.id.houseloginpass);

        mhouseregister.setOnClickListener((View.OnClickListener) view -> {
            Intent intent=new Intent(houselogin.this,houseregister.class);
            startActivity(intent);
            finish();
        });
        mhouseloginbutton.setOnClickListener((View.OnClickListener) view -> {
            logUser(view);
        });


    }

    private Boolean ValidateUsername(){
        String val = muserlogin.getEditText().getText().toString();
        if(val.isEmpty()){
            muserlogin.setError("Field cant be empty");
            return false;
        }
        else{
            muserlogin.setError(null);
           muserlogin.setErrorEnabled(false);
            return true;
        }


    }
    private Boolean validatePassword(){
        String val=mpasslogin.getEditText().getText().toString();
        if(val.isEmpty()){
            mpasslogin.setError("Field cant be empty");
            return false;
        }
        else{
            mpasslogin.setError(null);
            mpasslogin.setErrorEnabled(false);
            return true;
        }

    }
    public void logUser(View view){
        if(!ValidateUsername() | !validatePassword()){
            return;
        }
        else{
            isUser();
        }
    }
    private void isUser(){
        String etrdusername=muserlogin.getEditText().getText().toString();
        String etrdpassword=mpasslogin.getEditText().getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("houseUser");
        Query checkUser=reference.orderByChild("username").equalTo(etrdusername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    muserlogin.setError(null);
                    muserlogin.setErrorEnabled(false);
                    String passfromDB=snapshot.child(etrdusername).child("password").getValue(String.class);
                    if(passfromDB.equals(etrdpassword)){
                        String namefromDB=snapshot.child(etrdusername).child("name").getValue(String.class);
                        String usrnamefromDB=snapshot.child(etrdusername).child("username").getValue(String.class);
                        String phonefromDB=snapshot.child(etrdusername).child("phone").getValue(String.class);
                        String emailfromDB=snapshot.child(etrdusername).child("email").getValue(String.class);
                        String addressfromDB=snapshot.child(etrdusername).child("address").getValue(String.class);
                        String address2fromDB=snapshot.child(etrdusername).child("address2").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(),houseprofile.class);
                        intent.putExtra("name",namefromDB);
                        intent.putExtra("username",usrnamefromDB);
                        intent.putExtra("phone",phonefromDB);
                        intent.putExtra("email",emailfromDB);
                        intent.putExtra("address",addressfromDB);
                        intent.putExtra("address2",address2fromDB);
                        intent.putExtra("password",passfromDB);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        mpasslogin.setError("Wrong Password :(");
                    }}
                else{
                    muserlogin.setError("User does not exist :(");
                    muserlogin.requestFocus();

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}