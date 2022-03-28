package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustCardAdapter extends RecyclerView.Adapter<CustCardAdapter.MyViewholder> {

    Context c;
    String[] personName;
    int[] personImages;

    public CustCardAdapter(RecyclerWithCard context, String[] personName, int[] personImages) {
        this.c=context;
        this.personImages=personImages;
        this.personName=personName;
    }


    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cust_card_activity,parent,false);
        MyViewholder myViewholder = new MyViewholder(v);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, final int position) {
        holder.iv.setImageResource(personImages[position]);
        holder.tv.setText(personName[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c, SecondCardActivty.class);
                i.putExtra("image",personImages[position]);
                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return personName.length;
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tv;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.pimage);
            tv = (TextView) itemView.findViewById(R.id.name1);
        }
    }
}
