package edu.gsu.student.miltondemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import edu.gsu.student.miltondemo.R;

/**
 * Created by miltonm on 1/25/17.
 */

public class ListViewAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private Context mContext;

    public ListViewAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        TextView view = new TextView(mContext);
//
        View rowView = mInflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView)rowView.findViewById(R.id.list_view_tv);
        TextView view = new TextView(mContext);
        textView.setText(String.valueOf(position));
        return rowView;
    }
}
