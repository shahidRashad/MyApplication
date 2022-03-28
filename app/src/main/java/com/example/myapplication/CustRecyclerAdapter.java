package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustRecyclerAdapter extends RecyclerView.Adapter<CustRecyclerAdapter.SampleViewHolder> {

    ArrayList<String> personNames;
    ArrayList<Integer> personImages;
    Context context;

    public CustRecyclerAdapter(Context applicationContext, ArrayList<String> personName, ArrayList<Integer> personImages) {
        this.context = applicationContext;
        this.personNames = personName;
        this.personImages = personImages;
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cust_recycler_view,parent,false);
        SampleViewHolder vh = new SampleViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.textView.setText(personNames.get(position));
        holder.imageView.setImageResource(personImages.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), " is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class SampleViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;

        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.namee);
            imageView = (ImageView) itemView.findViewById(R.id.imagee);
        }
    }
}
