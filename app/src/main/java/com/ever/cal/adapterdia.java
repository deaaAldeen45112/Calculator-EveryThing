package com.ever.cal;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ever.cal.R;

import java.util.ArrayList;

public class adapterdia extends BaseAdapter {
    private ArrayList<savelist>as=new ArrayList<>();
     Context c;

    public adapterdia(Context c, ArrayList<savelist>dat){
        this.as=dat;
        this.c=c;

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
        TextView eq,eq2;
        final ImageView imageView;
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(c).inflate(R.layout.dia, null, false);
        }
             imageView=v.findViewById(R.id.b);

        eq=v.findViewById(R.id.eq);
        eq2=v.findViewById(R.id.eq2);
        eq.setText(as.get(position).getEq());
        eq2.setText(as.get(position).getEq2());
imageView.setTag(as.get(position).getId());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

acsessdatalist acsessdatalist=new acsessdatalist(c);
acsessdatalist.open();
acsessdatalist.deleteData((int) imageView.getTag());
acsessdatalist.close();
            as.remove(position);
            notifyDataSetChanged();

            }
        });
        final TextView finalEq = eq;
        v.findViewById(R.id.lin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.text( finalEq.getText().toString());
            }
        });
        return v;
    }










}
















