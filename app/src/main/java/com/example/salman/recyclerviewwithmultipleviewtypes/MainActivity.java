package com.example.salman.recyclerviewwithmultipleviewtypes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<Item> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                arrayList.add(new Item("Item" + i, Item.ItemType.ONE_ITEM));

            } else {
                arrayList.add(new Item("Item" + i, Item.ItemType.TWO_ITEM));
            }
        }

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(MainActivity.this, arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);




    }
}
