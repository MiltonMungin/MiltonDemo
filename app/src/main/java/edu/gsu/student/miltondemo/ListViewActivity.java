package edu.gsu.student.miltondemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gsu.student.miltondemo.adapter.ListViewAdapter;
import edu.gsu.student.miltondemo.adapter.ViewPagerAdapter;
import edu.gsu.student.miltondemo.fragment.HeaderFragmentOne;
import edu.gsu.student.miltondemo.fragment.HeaderFragmentThree;
import edu.gsu.student.miltondemo.fragment.HeaderFragmentTwo;
import util.UtilLog;

/**
 * Created by miltonm on 1/25/17.
 */

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ViewPager viewPager;
    private ListView listView;
    private ArrayList<String> listResult;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<String>();
        createFakeResult();
        initialView();

    }

    private void createFakeResult(){
        listResult.add("AA");
        listResult.add("BBBB");
        listResult.add("C");
        listResult.add("DDDDD");
        listResult.add("EEEEEEEEEE");
        listResult.add("F");
        listResult.add("G");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");
    }

    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);

        //View view = getLayoutInflater().inflate(R.layout.list_view_header, null);
        //LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);

        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);

        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager_header);

        fragmentList.add(new HeaderFragmentOne());
        fragmentList.add(new HeaderFragmentTwo());
        fragmentList.add(new HeaderFragmentThree());


        ViewPagerAdapter viewPageAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());

        viewPageAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPageAdapter);


        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "listView was clicked at position:"+position, Toast.LENGTH_SHORT).show();
        UtilLog.logD("testListViewActivity", String.valueOf(position));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message", "ListViewActivity");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
