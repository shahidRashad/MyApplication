package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchViewEx extends AppCompatActivity {

    SearchView search;
    ListView listview;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_ex);

        search = (SearchView) findViewById(R.id.searchview);
        listview = (ListView) findViewById(R.id.list);
        list = new ArrayList<String>();
        list.add("Cristiano Ronaldo");
        list.add("Lionel Messi");
        list.add("Neymar");
        list.add("Mbappe");
        list.add("Haland");
        list.add("Luiz Suarez");
        list.add("Paul Pogba");
        list.add("Bruno Fernandes");
        list.add("Debruine");
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(getApplicationContext(), "No Match Found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}