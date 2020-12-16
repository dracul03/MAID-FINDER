package com.example.maidfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Jobfinder extends AppCompatActivity {
    RecyclerView recyclerView;
    firebaserecycleradapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singlerow);
        recyclerView=(RecyclerView)findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<jobfindermodelclass> option=
                new FirebaseRecyclerOptions.Builder<jobfindermodelclass>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("house"),jobfindermodelclass.class)
                .build();
         adapter=new firebaserecycleradapter(option);
         recyclerView.setAdapter(adapter);

    }



    @Override
    protected void onStart(){
    super.onStart();
    adapter.startListening();
  }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }

}