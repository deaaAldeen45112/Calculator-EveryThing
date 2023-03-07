package com.ever.cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.ever.cal.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class a extends AppCompatActivity {
    Toolbar tool;
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,editText1,editText2;
    Spinner ee1,ee2,ee3,ee4,ee5,ee6,ee7,ee8,ee9,ee10,ee11,ee12,
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
            setContentView(R.layout.activity_a);
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
            editText1 = findViewById(R.id.edit1);
            editText2 = findViewById(R.id.edit2);
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


                    double sum = 0, sumhour = 0, sumre = 0, rephour = 0;
                    HashMap<String, Double> sp = new HashMap<>();
                    String[] strings = new String[13];
                    String[] strings2 = new String[13];
                    double[] strings3 = new double[13];
                    for (int i = 0; i < 13; i++) {
                        strings[i] = "";
                        strings2[i] = "";
                        strings3[i] = 0;
                    }


                    sp.put("A", 4.0);
                    sp.put("A-", 3.67);
                    sp.put("B+", 3.33);
                    sp.put("B", 3.0);
                    sp.put("B-", 2.67);
                    sp.put("C+", 2.33);
                    sp.put("C", 2.0);
                    sp.put("C-", 1.67);
                    sp.put("D", 1.00);
                    sp.put("F", 0.0);

                    int x = 0, y = 0, z = 0;

                    double ed1 = 0, ed2 = 0;
                    double e = 0, sumcre = 0;


                    double re = 0;


                    if (!editText1.getText().toString().equals(""))
                        ed1 = Double.parseDouble(editText1.getText().toString());
                    if (!editText2.getText().toString().equals(""))
                        ed2 = Double.parseDouble(editText2.getText().toString());


                    if (!e1.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e1.getText().toString());

                    }
                    if (!ee1.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee1.getSelectedItem().toString();
                    }
                    if (!c1.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c1.getSelectedItem().toString();
                    }


                    x++;
                    y++;
                    z++;

                    if (!e2.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e2.getText().toString());

                    }
                    if (!ee2.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee2.getSelectedItem().toString();
                    }
                    if (!c2.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c2.getSelectedItem().toString();
                    }

                    x++;
                    y++;
                    z++;
                    if (!e3.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e3.getText().toString());

                    }
                    if (!ee3.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee3.getSelectedItem().toString();
                    }
                    if (!c3.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c3.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;
                    if (!e4.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e4.getText().toString());

                    }
                    if (!ee4.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee4.getSelectedItem().toString();
                    }
                    if (!c4.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c4.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;
                    if (!e5.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e5.getText().toString());

                    }
                    if (!ee5.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee5.getSelectedItem().toString();
                    }
                    if (!c5.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c5.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;
                    if (!e6.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e6.getText().toString());

                    }
                    if (!ee6.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee6.getSelectedItem().toString();
                    }
                    if (!c6.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c6.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;
                    if (!e7.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e7.getText().toString());

                    }
                    if (!ee7.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee7.getSelectedItem().toString();
                    }
                    if (!c7.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c7.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;
                    if (!e8.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e8.getText().toString());

                    }
                    if (!ee8.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee8.getSelectedItem().toString();
                    }
                    if (!c8.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c8.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;

                    if (!e9.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e9.getText().toString());

                    }
                    if (!ee9.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee9.getSelectedItem().toString();
                    }
                    if (!c9.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c9.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;

                    if (!e10.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e10.getText().toString());

                    }
                    if (!ee10.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee10.getSelectedItem().toString();
                    }
                    if (!c10.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c10.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;

                    if (!e11.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e11.getText().toString());

                    }
                    if (!ee11.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee11.getSelectedItem().toString();
                    }
                    if (!c11.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c11.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;
                    if (!e12.getText().toString().equals("")) {
                        strings3[x] = Double.parseDouble(e12.getText().toString());

                    }
                    if (!ee12.getSelectedItem().toString().equals("Enter")) {
                        strings[y] = ee12.getSelectedItem().toString();
                    }
                    if (!c12.getSelectedItem().toString().equals("Enter")) {
                        strings2[z] = c12.getSelectedItem().toString();
                    }
                    x++;
                    y++;
                    z++;
                    for (int i = 0; i < 12; i++) {

                        if (!strings[i].equals("")) {
                            sum += sp.get(strings[i]) * strings3[i];
                            sumhour += strings3[i];
                        }

                        if (!strings2[i].equals("")) {
                            sumre += sp.get(strings2[i]) * strings3[i];
                            rephour += strings3[i];
                        }


                    }

                         double bmi2=  ((BigDecimal.valueOf(sum).subtract(BigDecimal.valueOf(sumre)).add(BigDecimal.valueOf(ed1).multiply(BigDecimal.valueOf(ed2)))).divide(BigDecimal.valueOf(ed2).subtract(BigDecimal.valueOf(rephour)).add(BigDecimal.valueOf(sumhour)),4, RoundingMode.HALF_UP)).doubleValue();
                    con.setText(""+bmi2);


                }
            });
        }

        catch (Exception e){

            Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();

        }

}
    }