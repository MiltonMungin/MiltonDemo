package edu.gsu.student.miltondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import edu.gsu.student.miltondemo.adapter.ListViewAdapter;

/**
 * Created by miltonm on 1/25/17.
 */

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initialView();
    }

    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this);
        listView.setAdapter(listViewAdapter);
    }
}
