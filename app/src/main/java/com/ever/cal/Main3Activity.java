package com.ever.cal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Main3Activity extends AppCompatActivity {
Toolbar tool;
Button b2;
Button b1;
static int x=0;
 static int y=0;


    @Override
    protected void onResume() {
        super.onResume();
        x=0;
        y=0;
    }

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
        setContentView(R.layout.gpa);
        tool=findViewById(R.id.gpa);
        setSupportActionBar(tool);
        b2=findViewById(R.id.m2);
        b1=findViewById(R.id.aplus1);
        x=0;
        y=0;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(getBaseContext(),a.class);


                startActivity(view);

            }
        });
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent view = new Intent(getBaseContext(),Main4Activity.class);


        startActivity(view);

    }
});

    }
}
