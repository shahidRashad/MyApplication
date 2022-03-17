package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapt extends BaseAdapter {
    Context c;
    String[] fruit;
    int [] fruitimg;
    LayoutInflater inflater;

    public CustomAdapt(Context applicationContext, String[] fruit, int[] fruitimg) {
        c=applicationContext;
        this.fruit=fruit;
        this.fruitimg=fruitimg;
    }

    @Override
    public int getCount() {
        return fruit.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = LayoutInflater.from(c);
        view = inflater.inflate(R.layout.customlayout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.customimage);
        TextView textView = (TextView) view.findViewById(R.id.text);
        imageView.setImageResource(fruitimg[i]);
        textView.setText(fruit[i]);
        return view;
    }
}
