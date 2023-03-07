package com.ever.cal;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.ever.cal.R;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.LocalDate;
import org.threeten.bp.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class age extends AppCompatActivity {
Toolbar tool;
EditText e;
TextView tv,tv2,tv3;
Button fi;
    LocalDate now;
int error=0;
DatePickerDialog datePickerDialog;
ImageView imageButton;

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
            AndroidThreeTen.init(this);
            setContentView(R.layout.activity_age);
            tool = findViewById(R.id.agetoolbar);
            e = findViewById(R.id.ecl);
            tv = findViewById(R.id.tv);
            tv2 = findViewById(R.id.tv2);
            fi = findViewById(R.id.fi);
            tv3 = findViewById(R.id.tv3);
            imageButton=findViewById(R.id.imcle);
        now = LocalDate.now();
        datePickerDialog=new DatePickerDialog(age.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                e.setText((dayOfMonth)+"/"+(month+1)+"/"+year);
            }
        },now.getYear(),now.getMonthValue(),now.getDayOfMonth());

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

            fi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!e.getText().toString().equals("")) {
                        String s = e.getText().toString();
                        String[] ss = new String[4];
                        for (int i = 0; i < 4; i++)
                            ss[i] = "";
                        int c = 0;
                        for (int i = 0; i < s.length(); i++)
                            if (s.charAt(i)>47&&s.charAt(i)<58)
                                ss[c] += s.charAt(i);
                            else if(s.charAt(i) == '/')
                                c++;
                            else if(s.charAt(i)!=' ')
                                error++;

                            if(c==2&&error==0){

                        LocalDate l = LocalDate.of(Integer.parseInt(ss[2]), Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));
                        //gets localDate
                        Period diff = Period.between(l, now); //difference between the dates is calculated*/
                        tv.setText(" " + diff.getYears() + " Years " + diff.getMonths() + " Month " + diff.getDays() + " Day ");




                                try {
                            tv2.setText(calculateBornDay(s));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (Integer.parseInt(ss[1]) < now.getMonthValue()) {
                            LocalDate l2 = LocalDate.of(now.getYear() + 1, Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));
                              Period diff2 = Period.between(l2, now); //difference between the dates is calculated*/
                            tv3.setText(" " + Math.abs(diff2.getYears()) + " Years " + Math.abs(diff2.getMonths()) + " Month " + Math.abs(diff2.getDays()) + " Day ");
                        } else if (Integer.parseInt(ss[1]) == now.getMonthValue() && Integer.parseInt(ss[1]) < now.getDayOfMonth()) {
                            LocalDate l2 = LocalDate.of(now.getYear() + 1, Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));
                               Period diff2 = Period.between(l2, now); //difference between the dates is calculated*/
                            tv3.setText(" " + Math.abs(diff2.getYears()) + " Years " + Math.abs(diff2.getMonths()) + " Month " + Math.abs(diff2.getDays()) + " Day ");
                        } else {
                            LocalDate l2 = LocalDate.of(now.getYear(), Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));
                              Period diff2 = Period.between(l2, now); //difference between the dates is calculated*/
                            tv3.setText(" " +Math.abs(diff2.getYears())+ " Years " +  Math.abs(diff2.getMonths()) + " Month " +  Math.abs(diff2.getDays())+ " Day ");
                        }
                    }


                            else
                                Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_SHORT).show();

        }}
    });


}

    public static String calculateBornDay(String s1) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEEEEEEEE");
        Date d = sdf.parse(s1);

        String s = sdf1.format(d);
        if(s.equals("Fri"))
            s="Friday";
        else if(s.equals("Sun"))
            s="Sunday";
        else if(s.equals("Mon"))
            s="Monday";
        else if(s.equals("Sat"))
            s="Saturday";
        else if(s.equals("Tue"))
            s="Tuesday";
        else if(s.equals("Thu"))
            s="Thursday";
        else if(s.equals("Wed"))
            s="Wednesday";
        return s;
    }


}

