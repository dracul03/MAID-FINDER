package com.example.maidfinder;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class firebaserecycleradapter extends FirebaseRecyclerAdapter<jobfindermodelclass,firebaserecycleradapter.myviewholder> {
    public firebaserecycleradapter(@NonNull FirebaseRecyclerOptions<jobfindermodelclass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull jobfindermodelclass model) {
        holder.name.setText(model.getName());
        holder.skills.setText(model.getskills());
        holder.email.setText(model.getEmail());
        holder.salary.setText(model.getSalary());
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow2,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name,email,skills,salary;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.imageView2);
            name= (TextView) itemView.findViewById(R.id.a);
            skills=(TextView) itemView.findViewById(R.id.b);
            email=(TextView) itemView.findViewById(R.id.c);
            salary=(TextView)itemView.findViewById(R.id.d);
        }
    }

}