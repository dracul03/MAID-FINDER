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

public class signup extends AppCompatActivity {
    TextInputLayout mname, musername, memail, mphone, mpassword, maddress, maddress2;
    Button mregister, mgotosignin;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mregister = findViewById(R.id.registerme);
        mgotosignin = findViewById(R.id.backtologin);
        mname = findViewById(R.id.name);
        musername = findViewById(R.id.username);
        mpassword = findViewById(R.id.password);
        memail = findViewById(R.id.email);
        mphone = findViewById(R.id.phone);
        maddress = findViewById(R.id.address);
        maddress2 = findViewById(R.id.address2);



        mgotosignin.setOnClickListener((View.OnClickListener) view -> {
            Intent intent=new Intent(signup.this,loginactivity.class);
            startActivity(intent);
            finish();
        });
        mregister.setOnClickListener((View.OnClickListener) view -> {
            validateregistration(view);
        });
    }


    private Boolean validatename() {
        String val = mname.getEditText().getText().toString();
        if (val.isEmpty()) {
            mname.setError("Field cant be empty");
            return false;
        } else {
            mname.setError(null);
            mname.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateusername() {
        String val = mname.getEditText().getText().toString();
        if (val.isEmpty()) {
            mname.setError("Field cant be empty");
            return false;
        } else if (val.length() > 20) {
            musername.setError("Username exceeding limit:(");
            return false;

        } else {
            mname.setError(null);
            mname.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatemail() {
        String val = memail.getEditText().getText().toString();
        String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            memail.setError("Field cant be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            memail.setError("InvalidEmailaddress");
            return false;
        } else {
            memail.setError(null);
            memail.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatepassword() {
        String val = mpassword.getEditText().getText().toString();
        if (val.isEmpty()) {
            mpassword.setError("Field cant be empty");
            return false;
        } else {
            mpassword.setError(null);
            mpassword.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateaddress() {
        String val = maddress.getEditText().getText().toString();
        if (val.isEmpty()) {
            maddress.setError("Field cant be empty");
            return false;
        } else {
            maddress.setError(null);
            maddress.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateaddress2() {
        String val = maddress2.getEditText().getText().toString();
        if (val.isEmpty()) {
            maddress2.setError("Field cant be empty");
            return false;
        } else {
            maddress2.setError(null);
            maddress2.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatephone() {
        String val = mphone.getEditText().getText().toString();
        if (val.isEmpty()) {
            mphone.setError("Field cant be empty");
            return false;
        } else {
            mphone.setError(null);
            mphone.setErrorEnabled(false);
            return true;
        }

    }

    public void validateregistration(View view) {
        if (!validateaddress()|!validateaddress2()|!validatemail()|!validatename()|!validatepassword()|!validatephone()|!validateusername())
        {return;
        }
        else{
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("User");
            String name = mname.getEditText().getText().toString();
            String username = musername.getEditText().getText().toString();
            String email = memail.getEditText().getText().toString();
            String phone = mphone.getEditText().getText().toString();
            String password = mpassword.getEditText().getText().toString();
            String address = maddress.getEditText().getText().toString();
            String address2 = maddress2.getEditText().getText().toString();
            UserHelperClass helperClass = new UserHelperClass(name, username, email, phone, password, address, address2);
            reference.child(username).setValue(helperClass);
            Toast.makeText(this,"You did it",Toast.LENGTH_SHORT).show();
        }


    }
}