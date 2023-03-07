package com.ever.cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ever.cal.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
Toolbar tool;
EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12;
EditText ee1,ee2,ee3,ee4,ee5,ee6,ee7,ee8,ee9,ee10,ee11,ee12,gb,hb,
 c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
TextView con;
Button fi;
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
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.a);
            tool = findViewById(R.id.gpa2);
            setSupportActionBar(tool);


            con = findViewById(R.id.cong);
            e1 = findViewById(R.id.e1);
            ee1 = findViewById(R.id.ee1);
            e2 = findViewById(R.id.e2);
            ee2 = findViewById(R.id.ee2);
            e3 = findViewById(R.id.e3);
            ee3 = findViewById(R.id.ee3);
            e4 = findViewById(R.id.e4);
            ee4 = findViewById(R.id.ee4);
            e5 = findViewById(R.id.e5);
            ee5 = findViewById(R.id.ee5);
            e6 = findViewById(R.id.e6);
            ee6 = findViewById(R.id.ee6);
            e7 = findViewById(R.id.e7);
            ee7 = findViewById(R.id.ee7);
            e8 = findViewById(R.id.e8);
            ee8 = findViewById(R.id.ee8);
            e9 = findViewById(R.id.e9);
            ee9 = findViewById(R.id.ee9);
            e10 = findViewById(R.id.e10);
            ee10 = findViewById(R.id.ee10);
            e11 = findViewById(R.id.e11);
            ee11 = findViewById(R.id.ee11);
            e12 = findViewById(R.id.e12);
            ee12 = findViewById(R.id.ee12);
            gb = findViewById(R.id.gb);
            hb = findViewById(R.id.gh);
            fi = findViewById(R.id.finish);
            c1 = findViewById(R.id.c1);
            c2 = findViewById(R.id.c2);
            c3 = findViewById(R.id.c3);
            c4 = findViewById(R.id.c4);
            c5 = findViewById(R.id.c5);
            c6 = findViewById(R.id.c6);
            c7 = findViewById(R.id.c7);
            c8 = findViewById(R.id.c8);
            c9 = findViewById(R.id.c9);
            c10 = findViewById(R.id.c10);
            c11 = findViewById(R.id.c11);
            c12 = findViewById(R.id.c12);



            fi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    double gpabefor = 0;
                    int timebefor = 0;
                    if (!gb.getText().toString().equals(""))
                        gpabefor = Double.parseDouble(gb.getText().toString());
                    if (!hb.getText().toString().equals(""))
                        timebefor = Integer.parseInt(hb.getText().toString());
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (!ee1.getText().toString().equals(""))
                        arrayList.add(ee1.getText().toString());
                    if (!ee2.getText().toString().equals(""))
                        arrayList.add(ee2.getText().toString());
                    if (!ee3.getText().toString().equals(""))
                        arrayList.add(ee3.getText().toString());
                    if (!ee4.getText().toString().equals(""))
                        arrayList.add(ee4.getText().toString());
                    if (!ee5.getText().toString().equals(""))
                        arrayList.add(ee5.getText().toString());
                    if (!ee6.getText().toString().equals(""))
                        arrayList.add(ee6.getText().toString());
                    if (!ee7.getText().toString().equals(""))
                        arrayList.add(ee7.getText().toString());
                    if (!ee8.getText().toString().equals(""))
                        arrayList.add(ee8.getText().toString());
                    if (!ee9.getText().toString().equals(""))
                        arrayList.add(ee9.getText().toString());
                    if (!ee10.getText().toString().equals(""))
                        arrayList.add(ee10.getText().toString());
                    if (!ee11.getText().toString().equals(""))
                        arrayList.add(ee11.getText().toString());
                    if (!ee12.getText().toString().equals(""))
                        arrayList.add(ee12.getText().toString());
                    ArrayList<Double> arrayList2 = new ArrayList<>();
                    if (!e1.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e1.getText().toString()));
                    if (!e2.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e2.getText().toString()));
                    if (!e3.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e3.getText().toString()));
                    if (!e4.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e4.getText().toString()));
                    if (!e5.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e5.getText().toString()));
                    if (!e6.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e6.getText().toString()));
                    if (!e7.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e7.getText().toString()));
                    if (!e8.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e8.getText().toString()));
                    if (!e9.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e9.getText().toString()));
                    if (!e10.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e10.getText().toString()));
                    if (!e11.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e11.getText().toString()));
                    if (!e12.getText().toString().equals(""))
                        arrayList2.add(Double.parseDouble(e12.getText().toString()));
                    int o = 0;
                    double[] arrayList3 = new double[13];
                    for (int i = 0; i < 13; i++)
                        arrayList3[i] = 0;
                    if (!c1.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c2.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c3.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c4.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c5.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c6.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c7.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c8.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c9.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c10.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c11.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());
                    if (!c12.getText().toString().equals(""))
                        arrayList3[o++] = Double.parseDouble(c1.getText().toString());


                    String lettergrd = "";
                    double credit = 0;
                    double caltimes = 0;
                    double totalcal = 0;
                    double totalcredit = 0;
                    double finalgpa = 0;
                    double gpa = 0;

                    double A = 4.0;
                    double AMINUS = 3.67;
                    double BPLUS = 3.33;
                    double B = 3.0;
                    double BMINUS = 2.67;
                    double CPLUS = 2.33;
                    double C = 2.0;
                    double CMINUS = 1.67;
                    double D = 1.00;
                    double F = 0.0;
                    double repet = 0, repetsum = 0, crere = 0;


                    for (int i = 0; i < arrayList.size(); i++) {

                        if (!arrayList.get(i).toString().equals(""))
                            caltimes = Double.parseDouble(arrayList.get(i));
                        if (!arrayList2.get(i).toString().equals(""))
                            credit = arrayList2.get(i);
                        if (arrayList3[i] != 0 && !arrayList2.get(i).toString().equals("")) {
                            repetsum += arrayList3[i] * credit;
                            crere += credit;
                        }
                        totalcredit = totalcredit + credit;
                        totalcal = totalcal + caltimes * credit;

                    }
                    //   finalgpa = totalcal / totalcredit;
                   gpa=(BigDecimal.valueOf(totalcal).add(BigDecimal.valueOf(gpabefor).multiply(BigDecimal.valueOf(timebefor))).subtract(BigDecimal.valueOf(repetsum))).divide(BigDecimal.valueOf(totalcredit).add(BigDecimal.valueOf(timebefor)).subtract(BigDecimal.valueOf(crere)),4,RoundingMode.HALF_UP).doubleValue();
                  //  gpa = (((totalcal + (gpabefor * timebefor) - repetsum) / (totalcredit + timebefor - crere)));


                    con.setText("" + gpa);
                    arrayList.clear();
                    arrayList2.clear();
                }


            });
        }
        catch (Exception e){

            Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();

        }
    }


    }


