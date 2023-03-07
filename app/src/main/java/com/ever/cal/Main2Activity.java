package com.ever.cal;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ever.cal.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
Toolbar tool;
    static  ArrayList<String> li;
ListView listView;
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
        setContentView(R.layout.activity_main2);
        tool=findViewById(R.id.tool2);
        setSupportActionBar(tool);
       li =getIntent().getStringArrayListExtra("send");

         listView=findViewById(R.id.list);


     newadapter3 arrayAdapter=new newadapter3(li,this);
          listView.setAdapter(arrayAdapter);


    }
}
