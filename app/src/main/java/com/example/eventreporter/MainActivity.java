package com.example.eventreporter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml.
        ListView eventListView = (ListView) findViewById(R.id.event_list);
        EventAdapter adapter = new EventAdapter(this);

        // Assign adapter to ListView.
        eventListView.setAdapter(adapter);
    }
}

