package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

/**
 * Created by Lucas on 05/03/2021.
 */
public class MainActivity extends Activity {

    private StringAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAdapter = new StringAdapter(this, R.layout.list_item, R.id.list_item_textview);

        ListView listView = (ListView) findViewById(R.id.activity_main_listview);
        listView.setAdapter(mAdapter);
    }
}
