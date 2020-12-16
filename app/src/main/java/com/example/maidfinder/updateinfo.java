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

public class updateinfo extends AppCompatActivity {
    String _name, _username, _email, _address, _address2, _phoneno, _password;
    DatabaseReference reference;
    TextInputLayout newname, newusername, newpassword, newphone, newaddress, newemail, newaddress2,updatedname;
    Button mupdate,mgoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateinfo);
        reference = FirebaseDatabase.getInstance().getReference("User");
        newname = findViewById(R.id.updatename);
        newusername = findViewById(R.id.updateusername);
        newpassword = findViewById(R.id.updatepassword);
        newphone = findViewById(R.id.updatephone);
        newemail = findViewById(R.id.updateemail);
        newaddress = findViewById(R.id.updateaddress);
        newaddress2 = findViewById(R.id.updateaddress2);
        mupdate=findViewById(R.id.update);
        mgoback=findViewById(R.id.letsgoback);
        updatedname=findViewById(R.id.updatedefaultname);

        userdata();
        updatedname.getEditText().setText(_name);
        mupdate.setOnClickListener((View.OnClickListener) view -> {

            update(view);
        });
        mgoback.setOnClickListener((View.OnClickListener) view -> {
            Intent intent = new Intent(getApplicationContext(),Profile.class);
            intent.putExtra("name",_name);
            intent.putExtra("username", _username );
            intent.putExtra("phone", _username );
            intent.putExtra("email",_email);
            intent.putExtra("address",_address);
            intent.putExtra("address2", _address2);
            intent.putExtra("password", _password);
            startActivity(intent);
            finish();
        });
        

    }

    private void userdata() {
        Intent intent = getIntent();
        _name = intent.getStringExtra("name");
        _username = intent.getStringExtra("username");
        _email = intent.getStringExtra("email");
        _address = intent.getStringExtra("address");
        _address2 = intent.getStringExtra("address2");
        _phoneno = intent.getStringExtra("phone");
        _password = intent.getStringExtra("password");


    }

    public void update(View view) {
        if (!ispasschanged()&&!isnamechanged()&&!isemailchanged()&&!isphonechanged()&&!isadresschanged()&&!isadress2changed()) {
            Toast.makeText(this, "Data is same lol", Toast.LENGTH_SHORT).show();
        }
        else{
            ispasschanged();
            isnamechanged();
            isemailchanged();
            isphonechanged();
            isadresschanged();
            isadress2changed();
            isusernamehanged();

            Toast.makeText(this, "Data is updated", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isnamechanged() {
        if (!_name.equals(newname.getEditText().toString())) {
            reference.child(_username).child("name").setValue(newname.getEditText().getText().toString());
            _name=newname.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean ispasschanged() {
        if (!_password.equals(newpassword.getEditText().toString())) {
            reference.child(_username).child("password").setValue(newpassword.getEditText().getText().toString());
            _password=newpassword.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isemailchanged() {
        if (!_email.equals(newemail.getEditText().toString())) {
            reference.child(_username).child("email").setValue(newemail.getEditText().getText().toString());
            _email=newemail.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isphonechanged() {
        if (!_phoneno.equals(newphone.getEditText().toString())) {
            reference.child(_username).child("phone").setValue(newphone.getEditText().getText().toString());
            _phoneno=newphone.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isadresschanged() {
        if (!_address.equals(newaddress.getEditText().toString())) {
            reference.child(_username).child("address").setValue(newaddress.getEditText().getText().toString());
            _address=newaddress.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isadress2changed() {
        if (!_address2.equals(newaddress2.getEditText().toString())) {
            reference.child(_username).child("address2").setValue(newaddress2.getEditText().getText().toString());
            _address2=newaddress2.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isusernamehanged() {
        if (!_address2.equals(newusername.getEditText().toString())) {
            reference.child(_username).child("username").setValue(newusername.getEditText().getText().toString());
            _username=newusername.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }
}