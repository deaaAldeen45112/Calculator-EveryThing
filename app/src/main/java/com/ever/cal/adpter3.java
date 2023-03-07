package com.ever.cal;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.ever.cal.R;


import java.util.ArrayList;

;

public class adpter3 extends BaseAdapter {
    private ArrayList<calclass>as=new ArrayList<>();
    private ArrayList<spandcal>we=new ArrayList<>();
    private ArrayList<calo>caloArrayList=new ArrayList<>();
    Context c;
    TextView ed;

    public adpter3(Context c, ArrayList<calclass>dat, ArrayList<spandcal>we, ArrayList<calo>caloArrayList){

        this.we=we;
        this.as=dat;
        this.c=c;
        this.caloArrayList=caloArrayList;
    }

    @Override
    public int getCount() {
        return as.size();
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
        final TextView t1, t2, t3;
        final Spinner s1, s2;
        Button checkBox;
        ArrayList<String> add = new ArrayList<>();
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(c).inflate(R.layout.rcal, null, false);
        }
        t1 = v.findViewById(R.id.ct1);
        s1 = v.findViewById(R.id.cts2);
        t3 = v.findViewById(R.id.ct3);
        s2 = v.findViewById(R.id.cts);
        checkBox = v.findViewById(R.id.checkbox);
            t1.setText(as.get(position).getName());
            t3.setText(as.get(position).getCa());
       // Toast.makeText(c,as.get(position).getName()+"  "+as.get(position).getCa() , Toast.LENGTH_SHORT).show();

        return v;
    }










}
















