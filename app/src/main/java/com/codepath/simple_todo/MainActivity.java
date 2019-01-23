package com.codepath.simple_todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        Toast.makeText(getApplicationContext(), "Item Added on List", Toast.LENGTH_SHORT).show();




    }
    private void setupListViewListerner(){
        LvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}
