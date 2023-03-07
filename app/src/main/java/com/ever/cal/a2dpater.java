package com.ever.cal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.ever.cal.R;

import java.util.ArrayList;

public class a2dpater extends BaseAdapter {
    private ArrayList<calclass>as=new ArrayList<>();
    private ArrayList<spandcal>we=new ArrayList<>();
    private ArrayList<calo>caloArrayList=new ArrayList<>();
    Context c;
    TextView ed;
    TextView t1, t2, t3;
    Spinner s1, s2;
    Button checkBox;
    ArrayList<String> add = new ArrayList<>();
    int  [] spinner =new int [800];
    int  [] spinner2 =new int [800];



    public a2dpater(Context c, ArrayList<calclass>dat, ArrayList<spandcal>we, ArrayList<calo>caloArrayList){
        for (int i = 0; i < 800; i++) {
            spinner[i] = 0;
            spinner2[i] = 0;

        }
        this.we=we;
        this.as=dat;
        this.c=c;
        this.caloArrayList=caloArrayList;
    }

    public void add(ArrayList<calclass>dat, ArrayList<spandcal>we, ArrayList<calo>caloArrayList){
        for (int i = 0; i < 800; i++) {
            spinner[i] = 0;
            spinner2[i] = 0;

        }
        this.we=we;
        this.as=dat;
        this.caloArrayList=caloArrayList;
    }

    public void clear(){
        this.we.clear();
        this.as.clear();
        this.caloArrayList.clear();
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
        TextView t1, t2, t3;
        Spinner s1, s2;
        Button checkBox;
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
        //Toast.makeText(c, ""+we.size()+" "+we.get(position).getWeightser(), Toast.LENGTH_SHORT).show();
        ArrayAdapter<String> array = new ArrayAdapter<>(c, android.R.layout.simple_spinner_item,new String[]{we.get(position).getWeightser(),we.get(position).getWeightgram(),we.get(position).getWeightoz()});
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(array);
        s1.setTag(position);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss = t3.getText().toString();
                String st = "";
                for (int i = 0; i < ss.length(); i++)
                    if (ss.charAt(i) > 47 && ss.charAt(i) <= 58)
                        st += ss.charAt(i);
               caloreis.text_plus(st);

               caloreis.go(new bud (t1.getText().toString(),s1.getSelectedItem().toString(),s2.getSelectedItem().toString(),t3.getText().toString()));



            }});

       s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position2, long id) {



                spinner[position]=position2;


               final  int x= (int )s1.getTag();

                caloreis ca=new caloreis();
                String st="";
                int in=Integer.parseInt(s2.getSelectedItem().toString());
                for (int i=0;i<caloArrayList.get(x).getCaloreiser().length();i++)
                    if(caloArrayList.get(x).getCaloreiser().charAt(i)>47&&caloArrayList.get(x).getCaloreiser().charAt(i)<=58)
                        st+=caloArrayList.get(x).getCaloreiser().charAt(i);
                int ser=Integer.parseInt(st);
                st="";
                for (int i=0;i<caloArrayList.get(x).getCaloreigram().length();i++)
                    if(caloArrayList.get(x).getCaloreigram().charAt(i)>47&&caloArrayList.get(x).getCaloreigram().charAt(i)<=58)
                        st+=caloArrayList.get(x).getCaloreigram().charAt(i);
                int gr=Integer.parseInt(st);
                st="";
                for (int i=0;i<caloArrayList.get(x).getCaloreioz().length();i++)
                    if(caloArrayList.get(x).getCaloreioz().charAt(i)>47&&caloArrayList.get(x).getCaloreioz().charAt(i)<=58)
                        st+=caloArrayList.get(x).getCaloreioz().charAt(i);

                int oz=Integer.parseInt(st);
                switch (position2){
                    case 0:
                        t3.setTag("ser");
                        t3.setText(ser*in+""+" cal");

                        break;
                    case 1:
                        t3.setTag("gram");
                        t3.setText(gr*in+""+" cal");
                        break;
                    case 2:
                        t3.setTag("oz");
                        t3.setText( oz*in+""+" cal");
                        break;


                }

           }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s1.setSelection(spinner[position]);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position2, long id) {

                spinner2[position]=position2;


                final  int x= (int )s1.getTag();
                String s="",st="";
                if(t3.getTag().toString().equals("oz"))
                    s=caloArrayList.get(x).getCaloreioz();
                else  if(t3.getTag().toString().equals("gram"))
                    s=caloArrayList.get(x).getCaloreigram();
                else {
                    if(t3.getTag().toString().equals("ser"))
                        s = caloArrayList.get(x).getCaloreiser();
                }

                for (int i=0;i<s.length();i++)
                    if(s.charAt(i)>47&&s.charAt(i)<=58)
                        st+=s.charAt(i);
                int in=Integer.parseInt(st);
                switch (position2+1) {
                    case 1:
                        in*=1;
                        break;
                    case 2:
                        in*=2;
                        break;
                    case 3:
                        in*=3;
                        break;
                    case 4:
                        in*=4;
                        break;
                    case 5:
                        in*=5;
                        break;
                    case 6:
                        in*=6;
                        break;
                }
                String st2=String.valueOf(in);
                s=s.replace(st,st2);
                t3.setText(s);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        s2.setSelection(spinner2[position]);


        return v;
    }










    }
















