package com.ever.cal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ever.cal.R;

import java.util.ArrayList;

public  class newadapter extends BaseAdapter {
    ArrayList<bud> e;
    Context d;

    public newadapter(ArrayList<bud>e,Context d){
        this.d=d;
        this.e=e;

    }


    @Override
    public int getCount() {
        return e.size();
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
        TextView t1, t2, t3,t4;
        Button button;
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(d).inflate(R.layout.rcal2, null, false);
        }
        t1 = v.findViewById(R.id.t1);
        t2 = v.findViewById(R.id.t2);
        t3 = v.findViewById(R.id.t3);
        t4 = v.findViewById(R.id.t4);
        t1.setText(e.get(position).getName());
        t2.setText(e.get(position).getWeight());
        t3.setText(e.get(position).getNumber());
        t4.setText(e.get(position).getCalorei());
        button=v.findViewById(R.id.dele);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sss=e.get(position).getCalorei();
                e.remove(position);

                caloreis.s.notifyDataSetChanged();
                String c=caloreis.textView.getText().toString();
                String st = "";
                for (int i = 0; i < sss.length(); i++)
                    if (sss.charAt(i) > 47 && sss.charAt(i) <= 58)
                        st += sss.charAt(i);
                String st2= "";
                for (int i = 0; i < c.length(); i++)
                    if (c.charAt(i) > 47 && c.charAt(i) <= 58)
                        st2 += c.charAt(i);
                int w=Integer.parseInt(st2)-Integer.parseInt(st);
                caloreis.textView.setText(w+" deaa");

            }
        });


        return v;

    }}










