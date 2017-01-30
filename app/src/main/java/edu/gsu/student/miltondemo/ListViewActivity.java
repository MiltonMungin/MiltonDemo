package edu.gsu.student.miltondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import edu.gsu.student.miltondemo.adapter.ListViewAdapter;

/**
 * Created by miltonm on 1/25/17.
 */

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initialView();
    }

    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "listView was clicked at position:"+position, Toast.LENGTH_SHORT).show();
    }
}
