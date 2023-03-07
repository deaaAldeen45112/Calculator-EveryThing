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

public class bmi extends AppCompatActivity {
    Toolbar tool;
    EditText editText1,editText2;
    TextView textViewbmi;
    Button bubm;
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
            setContentView(R.layout.activity_bmi);
            tool = findViewById(R.id.bmitoolbar);
            setSupportActionBar(tool);
            editText1 = findViewById(R.id.bmi1);
            editText2 = findViewById(R.id.bmi2);
            textViewbmi = findViewById(R.id.bmitext);
            bubm = findViewById(R.id.bmifi);






            bubm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
try{
                    if (!editText1.getText().toString().equals("") && !editText2.getText().toString().equals("")) {

                       // double bmi = Double.parseDouble(editText1.getText().toString()) / Math.pow(Double.parseDouble(editText2.getText().toString()) / 100, 2);
                        double bmi=(BigDecimal.valueOf( Double.parseDouble(editText1.getText().toString())).divide(BigDecimal.valueOf(Math.pow(Double.parseDouble(editText2.getText().toString()) / 100, 2)),4, RoundingMode.HALF_UP)).doubleValue();


                      if(bmi>=18&&bmi<18.5)
                            textViewbmi.setText(  bmi+"  Underweight");
                       else if(bmi>=18.5&&bmi<=24.9)
                            textViewbmi.setText( bmi+"  Healthy");
                       else if(bmi>=25&&bmi<=29.9)
                            textViewbmi.setText( bmi+"  Overweight");
                       else if(bmi>=30&&bmi<=34.9)
                            textViewbmi.setText("" + bmi+" OBESE");
                       else if(bmi>=35)
                            textViewbmi.setText("" + bmi+" Extremely OBESE");
else
                        textViewbmi.setText("" + bmi);
                    }                }
 catch (Exception e){

                        Toast.makeText(getBaseContext(),"error",Toast.LENGTH_SHORT).show();

                    }

                }
            });


        }
        catch (Exception e){

            Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();

        }






    }
}
