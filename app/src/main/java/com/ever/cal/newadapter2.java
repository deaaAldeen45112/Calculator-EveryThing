package com.ever.cal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ever.cal.R;

import java.util.ArrayList;

public  class newadapter2 extends BaseAdapter {
    ArrayList<bud2>e;
Context d;
    public newadapter2(ArrayList<bud2>e, Context d){
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
        final TextView t1, t2, t3;
        Button button;
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(d).inflate(R.layout.list, null, false);
        }
        t1 = v.findViewById(R.id.t1);
        t2 = v.findViewById(R.id.t2);
        t3 = v.findViewById(R.id.t3);
        t1.setText(e.get(position).getDate());
        t2.setText(e.get(position).getHour());
        t3.setText(e.get(position).getCalorei());
button=v.findViewById(R.id.b);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        accsessdata2te accsessdatacur=new accsessdata2te(d);
        accsessdatacur.open();
        accsessdatacur.deleteData(t1.getText().toString(),t2.getText().toString());
        accsessdatacur.close();
        Mainn2Activity.ar.remove(position);
        Toast.makeText(d, position+"", Toast.LENGTH_SHORT).show();
     Mainn2Activity.newadapter.notifyDataSetChanged();
    }
});

        return v;

    }}








