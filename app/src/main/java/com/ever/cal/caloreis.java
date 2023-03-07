package com.ever.cal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class caloreis extends AppCompatActivity {
    ListView listView;
    static ListView listView2;
    static TextView textView;
    ArrayList<calclass> a;
    ArrayList<String> as;
    ArrayList<spandcal> weight;
    ArrayList<com.ever.cal.calo> calo;
    Toolbar tool;
    Spinner s1, s2;
    ArrayList<String> sp ;
    ArrayList<calclass> libysp ;
    ArrayList<spandcal> cx ;
    ArrayList<calo> c ;
    ArrayList<String> spinner2 ;
    ArrayList<calclass> listspinner2 ;
    ArrayList<spandcal> spen ;
    ArrayList<calo> cal ;


    Button repet;
    static ArrayList<bud> e = new ArrayList<>();
    static newadapter s;

    accsessdata accsessdata;
    private  a2dpater a2dpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch(MainActivity.Theme){

            case 1:
                setTheme(R.style.AppTheme_NoActionBar2);
                break;
            case 2:
                setTheme(R.style.AppTheme_NoActionBar3);
                break;
            case 3:
                setTheme(R.style.AppTheme_NoActionBar4);
                break;
            case 4:
                setTheme(R.style.AppTheme_NoActionBar5);
                break;
            case 5:
                setTheme(R.style.AppTheme_NoActionBar6);
                break;
            case 6:
                setTheme(R.style.AppTheme_NoActionBar7);
                break;
            case 7:
                setTheme(R.style.AppTheme_NoActionBar1);
                break;
            case 8:
                setTheme(R.style.AppTheme_NoActionBarb);
                break;

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal);
        tool = findViewById(R.id.caltoolbar);
        setSupportActionBar(tool);
        listView2 = findViewById(R.id.lcal2);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        listView = findViewById(R.id.lcal);
        textView = findViewById(R.id.t);
        repet = findViewById(R.id.repet);
        s = new newadapter(e, this);
        accsessdata = new  accsessdata(this);
        accsessdata.open();
        a = accsessdata.getAlltype();
        as = accsessdata.gettype();
        weight = accsessdata.getweancalo();
        calo = accsessdata.getcalo();
        accsessdata.close();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.textsp1, as);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(arrayAdapter);
        a2dpater = new a2dpater(this, a, weight, calo);
        listView.setAdapter(a2dpater);


        repet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("0" + " cal");
                e.clear();
                s.notifyDataSetChanged();
            }
        });


        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String s = (String) parent.getItemAtPosition(position);
                if (!s.equals("Enter type :")) {
                    accsessdata.open();

                    listspinner2 = accsessdata.getconsbytype(s);
                    spinner2 = accsessdata.gettAllname(s);
                    spen = accsessdata.getweancalo(s);
                    cal = accsessdata.getcalo(s);
                    accsessdata.close();
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(caloreis.this,R.layout.textsp1, spinner2);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    s2.setAdapter(arrayAdapter);
                   // Toast.makeText(caloreis.this, listspinner2.get(0).getCa() + "" + spen.get(0).getWeightgram() + "" + deaa.get(0).getCaloreigram(), Toast.LENGTH_SHORT).show();
                    a2dpater.clear();
                    a2dpater.add(listspinner2, spen, cal);
                    a2dpater.notifyDataSetChanged();
                }

                else {

                   // Toast.makeText(caloreis.this, ""+a.size(), Toast.LENGTH_SHORT).show();

                    s2.setSelection(0);
                    accsessdata.open();
                    a = accsessdata.getAlltype();
                    as = accsessdata.gettype();
                    weight = accsessdata.getweancalo();
                    calo = accsessdata.getcalo();
                    accsessdata.close();
                    a2dpater.clear();
                  //  Toast.makeText(caloreis.this, ""+a.size(), Toast.LENGTH_SHORT).show();

                    a2dpater.add(a, weight, calo);
                    a2dpater.notifyDataSetChanged();



                }

 /*                   for (int i=0;i<listspinner2.size();i++){


    total+=listspinner2.get(i).getName()+" "+spinner2.get(i);

}
   */
                }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = parent.getItemAtPosition(position).toString();
                if (!s.equals("Enter name :")) {
                    ArrayList<calclass> fname = new ArrayList<>();
                    ArrayList<spandcal> fcalo = new ArrayList<>();
                    ArrayList<calo> fcalname = new ArrayList<>();
                    String f = "";
                    accsessdata.open();
                    f = accsessdata.gettypeofname(s);
                    fname = accsessdata.getconsbyname(s);
                    fcalo = accsessdata.getweancaloname(s);
                    fcalname = accsessdata.getcaloname(s);
                    a2dpater.clear();
                    a2dpater.add(fname, fcalo, fcalname);
                    a2dpater.notifyDataSetChanged();

                }
}

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }});




    }
    public static void text_plus(String s) {
        int x = 0;
        if (!textView.getText().toString().equals("")) {
            String x1 = textView.getText().toString().replace(" deaa", "");
            x = Integer.parseInt(x1) + Integer.parseInt(s);
        } else {
            x = Integer.parseInt(s);
        }
        textView.setText(x + " cal");
    }


    static boolean go(bud a) {

        try {


            e.add(a);
            listView2.setAdapter(s);


        } catch (Exception e) {

            return false;

        }
        return true;

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        EditText d =(EditText)searchView.findViewById(
                androidx.appcompat.R.id.search_src_text);
        d.setTextColor(Color.WHITE);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.length()>=2)
                    query=query.substring(0,1).toUpperCase()+query.substring(1,query.length()).toLowerCase();

                accsessdata.open();
                final ArrayList<calclass>a=accsessdata.getAlltype3(query);
                final ArrayList<spandcal>weight=accsessdata.getweancalo3(query);
                final ArrayList<calo>  calo=accsessdata.getcalo3(query);
                accsessdata.close();
                a2dpater.clear();
                a2dpater.add( a,weight,calo);
                a2dpater.notifyDataSetChanged();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //query=query.substring(0,1).toUpperCase()+query.substring(1,query.length()).toLowerCase();
                if(query.length()>=2)
                    query=query.substring(0,1).toUpperCase()+query.substring(1,query.length()).toLowerCase();

                accsessdata.open();
                final ArrayList<calclass>    a=accsessdata.getAlltype2(query);
                final ArrayList<spandcal> weight=accsessdata.getweancalo2(query);
                final ArrayList<calo>  calo=accsessdata.getcalo2(query);
                accsessdata.close();
                a2dpater.clear();
                a2dpater.add( a,weight,calo);
                a2dpater.notifyDataSetChanged();


                return true;
            }
        });


        return true;




    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

int y=item.getItemId();
if(y==R.id.save){

    Intent intent=new Intent(getBaseContext(),Mainn2Activity.class);
    intent.putExtra("Ok",textView.getText().toString());
    startActivity(intent);
}


        return true;
    }


}