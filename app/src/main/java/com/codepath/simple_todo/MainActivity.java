package com.codepath.simple_todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String>items;
    ArrayAdapter<String >itemsAdapter;
    ListView LvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        LvItems = (ListView) findViewById(R.id.LvItems);
        LvItems.setAdapter(itemsAdapter);


        //Mock data
        items.add("First Item");
        items.add("Second Item");
    }
    public void onAddItem (View v) {
        EditText etNewItem= (EditText) findViewById(R.id.etNewItem );
        String itemText =etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText ("");




    }
}
