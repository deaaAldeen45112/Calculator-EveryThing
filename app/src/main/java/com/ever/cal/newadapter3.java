
package com.ever.cal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ever.cal.R;

import java.util.ArrayList;

public class newadapter3 extends BaseAdapter {

    ArrayList<String> li;
    Context d;
    public newadapter3(ArrayList<String>li, Context d){
        this.d=d;
        this.li=li;

    }


    @Override
    public int getCount() {
        return li.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final TextView t1, t2;
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(d).inflate(R.layout.steps, null, false);
        }
        t1 = v.findViewById(R.id.steps1);
        t2 = v.findViewById(R.id.steps2);
       t2.setText(li.get(position));
       if(position==0)
           t1.setText(" eq : ");
       else
       t1.setText(position+" )");


        return v;

    }}








