package edu.gsu.student.miltondemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gsu.student.miltondemo.R;
import util.UtilDensity;

/**
 * Created by miltonm on 1/25/17.
 */

public class ListViewAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private final ArrayList<String> listResult;
    private Context mContext;

    public ListViewAdapter(Context context, ArrayList<String> resultList) {
        mContext = context;
        this.listResult = resultList;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listResult.size();
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
        ViewHolder holder;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.textView1 = (TextView)convertView.findViewById(R.id.list_view_tv1);
            holder.textView2 = (TextView)convertView.findViewById(R.id.list_view_tv2);
            holder.textView3 = (TextView)convertView.findViewById(R.id.list_view_tv3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.textView1.setText(String.valueOf(position));
        holder.textView3.setText(String.valueOf(position));
        holder.textView2.setText(listResult.get(position));
        if(position%2 == 0) {
            holder.textView1.setVisibility(View.VISIBLE);
            holder.textView3.setVisibility(View.INVISIBLE);
            holder.lp.setMargins(UtilDensity.dip2px(mContext, 50),0,0,0);
            holder.lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            holder.textView2.setBackgroundResource(R.drawable.chatfrom_bg_focused);
            holder.textView2.setLayoutParams(holder.lp);
        } else {
            holder.textView1.setVisibility(View.INVISIBLE);
            holder.textView3.setVisibility(View.VISIBLE);
            holder.lp.setMargins(0,0,UtilDensity.dip2px(mContext, 50), 0);
            holder.lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            holder.textView2.setBackgroundResource(R.drawable.chatto_bg_focused);
            holder.textView2.setLayoutParams(holder.lp);
        }

/*        View rowView = mInflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView)rowView.findViewById(R.id.list_view_tv);
        TextView view = new TextView(mContext);
        textView.setText(String.valueOf(position));*/
/*        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/

        return convertView;
    }


}

class ViewHolder {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
}
