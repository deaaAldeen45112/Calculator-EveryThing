package com.ever.cal;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class convert extends AppCompatActivity {
    int po,po2,pop;
    Button b;
    boolean sel=false,se1,se2;
Toolbar toolbar;
Spinner spinner,s1,s2;
EditText e1;
EditText e2;
convert2 c=new convert2();
convert2.length  d= c.new length();
convert2.Mass d2= c.new Mass();
convert2.Pressure d3= c.new Pressure();
convert2.TIME d4= c.new TIME();

convert2.Datastorgetrasfer d5= c.new Datastorgetrasfer();
    convert2.Frequency f= c.new Frequency();
    convert2.FuelEconomy u= c.new FuelEconomy();
    convert2.Volume v= c.new Volume();
    convert2.Energy e= c.new Energy();
    convert2.Datastorge s= c.new Datastorge();
    convert2.Speed p= c.new Speed();
    convert2. Area a= c.new Area();
String [] length={ "Kilometre","Metre","Centimetre","Millimetre","Micrometre","Nanometre" ,"Mile", "Yard", "Foot", "Inch"};
double[] length2={ d.Kilometre,d.Metre,d.Centimetre,d.Millimetre,d.Micrometre,d.Nanometre,d.Mile , d.Yard, d.Foot,d.Inch};
String [] Mass={"Kilogram", "Gram", "Milligram" ,"Microgram","Nanogram", "Imperial ton", "Pound", "Ounce" ,"Stone"  ,"US ton"};
double [] Mass2={d2.Kilogram, d2.Gram, d2.Milligram ,d2.Microgram,d2.Nanogram, d2.Imperialton, d2.Pound, d2.Ounce ,d2.Stone  ,d2.USton};
String []Pressure={"Pascal","Pound-Force per Square inch","Standerd atmosphere","Torr","Bar"};
double []Pressure2={d3.Pascal,d3.PoundForceBar,d3.Standerdatmosphere,d3.Torr,d3.Bar};
String [] TIME={"Second" , "Minute","Hour","Day","Month","Week","Year","Decade","Century","MilliSecond","MicroSecond","NanoSecond"};
double [] Time2={d4.Second , d4.Minute,d4.Hour,d4.Day,d4.Month,d4.Week,d4.Year,d4.Decade,d4.Century,d4.MilliSecond, d4.MicroSecond,d4.NanoSecond};
String []Datastorgetrasfer={"bit per second","kilobit per second","Kibibit per second","Megabit per second","Mebibit per second","Gigabit per second","Gibibit per second","Terabit per second","Tebibit per second","kiloByte per second","MegaByte per second","GigaByte per second","TeraByte per second"};
double []Datastorgetrasfer2={d5.bitpersecond,d5.kilobitpersecond,d5.Kibibitpersecond,d5.Megabitpersecond,d5.Mebibitpersecond,d5.Gigabitpersecond,d5.Gibibitpersecond,d5.Terabitpersecond,d5.Tebibitpersecond,d5.kiloBytepersecond,d5.MegaBytepersecond,d5.GigaBytepersecond,d5.TeraBytepersecond};
String []Frequency={"Kilohertz" ,"Megahertz","Gigahertz", "hertz"};
double[]Frequency2={f.Kilohertz ,f.Megahertz,f.Gigahertz, f.hertz};
String [] FuelEconomy={"Kilo Per liter","mile per US gallon","mile US gallon","liter per 100Km"};
double[] FuelEconomy2={u.KiloPerliter,u.mileperUSgallon,u.mileUSgallon,u.literper100Km};
String [] Volume={"US liquid gallon","US liquid quart", "US liquid pint", "US legal cup", "fluid ounce", "US table spoon", "US teaspoon", "Milliliter", "gallon", "Imperail pint","Imperail quart","Imperail cup","Imperail tablespoon","Imperail teaspoon" ,"liter","cubic inch","the cubic foot"};
double [] Volume2={v.USliquidgallon,v.USliquidquart, v.USliquidpint, v.USlegalcup, v.fluidounce, v.UStablespoon, v.USteaspoon, v.Milliliter, v.gallon, v.Imperailpint,v.Imperailquart,v.Imperailcup,v.Imperailtablespoon,v.Imperailteaspoon ,v.liter,v.cubicinch,v.thecubicfoot};
String [] Energy={"Joule","KiloJoule","Gramcalorie","Kilocalorie","Watt hour","KiloWatt hour","Electron Volt","British thermal unit","US therm","Foot_Pound"};
double[] Energy2={e.Joule,e.KiloJoule,e.Gramcalorie,e.Kilocalorie,e.Watthour,e.KiloWatthour,e.ElectronVolt,e.Britishthermalunit,e.UStherm,e.Foot_Pound};
String[] Datastorge={"bit","kilobit","Kibibit","Megabit","Mebibit","Gigabit","Gibibit","Terabit","Tebibit","Petabit","Pebibit","Byte","kiloByte","KibiByte","MegaByte","MebiByte","GigaByte","GibiByte","TeraByte","TebiByte","PetaByte","PebiByte"};
double[] Datastorge2={s.bit,s.kilobit,s.Kibibit,s.Megabit,s.Mebibit,s.Gigabit,s.Gibibit,s.Terabit,s.Tebibit,s.Petabit,s.Pebibit,s.Byte,s.kiloByte,s.KibiByte,s.MegaByte,s.MebiByte,s.GigaByte,s.GibiByte,s.TeraByte,s.TebiByte,s.PetaByte,s.PebiByte};
String [] Temperature={"Celsius",  "Fahranheit", "Kelvin"};
String []Speed={"Miles Per Hour", "Foot Per Second", "Kilometre Per Hour","Knot","Metre Per Second"};
double []Speed2={p.MilesPerHour, p.FootPerSecond, p.KiloPerHour,p.Knot,p.MetrePerSecond};
String [] Area={"Square Kilometre", "Square Metre", "Square Mile", "Square Yard","Square Foot", "Square Inch", "Hectare", "Acre"};
double[] Area2={a.SquareKilometre, a.SquareMetre, a.SquareMile, a.SquareYard,a.SquareFoot, a.SquareInch, a.Hectare, a.Acre};
String [] cov={ "length","Mass","Time", "Pressure", "Speed", "Temperature", "Digital storge", "Energy", "Volume", "FuelEconomy","Area","Data Transfer Rate","Frequency"};
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
            setContentView(R.layout.activity_convert);
            toolbar = findViewById(R.id.cvtoolbar);
            setSupportActionBar(toolbar);
            spinner = findViewById(R.id.parentsp);
            s1 = findViewById(R.id.chid1sp);
            s2 = findViewById(R.id.chid2sp);
            e1 = findViewById(R.id.cve1);
            e2 = findViewById(R.id.cve2);



            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,  R.layout.textsp1, cov);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);

            e1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable a) {



                    if (se1== true) {
                        int Enum=0,dotnum=0,Epos=-2,dotpos=-2,minpo=-2,minnum=0,numpos=0;


for(int i=0;i<a.toString().length();i++){
    if(a.toString().charAt(i)=='E')
    {
        Enum++;
        Epos=i;

    }
    if(a.toString().charAt(i)=='.')
    {
        dotnum++;
        dotpos=i;
    }
    if(a.toString().charAt(i)=='-')
    {
        minnum++;
        minpo=i;

    }

}

if(Enum<=1&&minnum<=1&&dotnum<=1&&((a.toString().length()>1&&minpo==0&&a.toString().charAt(1)>='0'&&a.toString().charAt(1)<='9')||minpo==-2)&&((Epos>dotpos)||Epos==-2||dotpos==-2)&&Epos!=0&&dotpos!=0&&Epos!=a.toString().length()-1&&dotpos!=a.toString().length()-1){



                        String s = setEdi(a.toString());
                        if (!s.equals(a.toString())) {
                            int cursorPosition = e1.getSelectionStart();
                            e1.setText(s);


                            if (s.length() < a.length()) {
                                if (cursorPosition > 0)
                                    e1.setSelection(cursorPosition - 1);

                            } else if (s.length() > a.length()) {
                                if (cursorPosition + 1 < s.length() + 1)
                                    e1.setSelection(cursorPosition + 1);

                            } else if (s.length() == a.length())
                                e1.setSelection(cursorPosition);
                            String sq = "";
                            for (int i = 0; i < s.length(); i++) {
                                if (s.charAt(i) != ',')
                                    sq += s.charAt(i);

                            }
                            s = sq;
                        }


                        switch (pop) {

                            case 0:

                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an = (BigDecimal.valueOf(length2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(length2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                    if ((long) an == an)
                                        e2.setText(setEdi(String.valueOf((long) an)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }


                                break;
                            case 1:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an2 = (BigDecimal.valueOf(Mass2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Mass2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                    if ((long) an2 == an2)
                                        e2.setText(setEdi(String.valueOf((long) an2)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an2)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 2:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an3 = (BigDecimal.valueOf(Time2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Time2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                    if ((long) an3 == an3)
                                        e2.setText(setEdi(String.valueOf((long) an3)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an3)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 3:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an4 = (BigDecimal.valueOf(Pressure2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Pressure2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                    if ((long) an4 == an4)
                                        e2.setText(setEdi(String.valueOf((long) an4)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an4)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 4:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an5 = (BigDecimal.valueOf(Speed2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Speed2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                    if ((long) an5 == an5)
                                        e2.setText(setEdi(String.valueOf((long) an5)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an5)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 5: {
                                if (po == 0 && po2 == 1) {


                                    //double ans = (Double.parseDouble(s.toString()) * (9.0 / 5)) + 32;
                                    if (!s.equals("")) {
                                        String sq = "";
                                        for (int i = 0; i < s.length(); i++) {
                                            if (s.charAt(i) != ',')
                                                sq += s.charAt(i);

                                        }
                                        s = sq;
                                        double ans = ((BigDecimal.valueOf(9).divide(BigDecimal.valueOf(5), 100, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).add(BigDecimal.valueOf(32)).doubleValue();

                                        if ((long) ans == ans)
                                            e2.setText(setEdi(String.valueOf((long) ans)));
                                        else
                                            e2.setText(setEdi(String.valueOf(ans)));
                                    }
                                    if (s.equals("")) {

                                        e2.setText("");
                                    }
                                } else if (po == 1 && po2 == 0) {

                                    //double ans = (Double.parseDouble(s.toString()) - 32) * (5.0 / 9);
                                    if (!s.equals("")) {
                                        String sq = "";
                                        for (int i = 0; i < s.length(); i++) {
                                            if (s.charAt(i) != ',')
                                                sq += s.charAt(i);

                                        }
                                        s = sq;
                                        double ans = (BigDecimal.valueOf(5).divide(BigDecimal.valueOf(9), 100, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())).subtract(BigDecimal.valueOf(32))).doubleValue();

                                        if ((long) ans == ans)
                                            e2.setText(setEdi(String.valueOf((long) ans)));
                                        else
                                            e2.setText(setEdi(String.valueOf(ans)));
                                    }
                                    if (s.equals("")) {

                                        e2.setText("");
                                    }
                                } else if (po == 2 && po2 == 1) {


                                    //   double ans = (Double.parseDouble(s.toString()) - 273.15) * (9.0 / 5) + 32;
                                    if (!s.equals("")) {
                                        String sq = "";
                                        for (int i = 0; i < s.length(); i++) {
                                            if (s.charAt(i) != ',')
                                                sq += s.charAt(i);

                                        }
                                        s = sq;
                                        double ans = ((BigDecimal.valueOf(9).divide(BigDecimal.valueOf(5), 100, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())).subtract(BigDecimal.valueOf(273.15)))).add(BigDecimal.valueOf(32)).doubleValue();

                                        if ((long) ans == ans)
                                            e2.setText(setEdi(String.valueOf((long) ans)));
                                        else
                                            e2.setText(setEdi(String.valueOf(ans)));
                                    }
                                    if (s.equals("")) {

                                        e2.setText("");
                                    }
                                } else if (po == 1 && po2 == 2) {


                                    //    double ans = (Double.parseDouble(s.toString()) - 32) * (5.0 / 9) + 273.15;
                                    if (!s.equals("")) {
                                        String sq = "";
                                        for (int i = 0; i < s.length(); i++) {
                                            if (s.charAt(i) != ',')
                                                sq += s.charAt(i);

                                        }
                                        s = sq;
                                        double ans = ((BigDecimal.valueOf(5).divide(BigDecimal.valueOf(9), 100, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())).subtract(BigDecimal.valueOf(32)))).add(BigDecimal.valueOf(273.15)).doubleValue();

                                        if ((long) ans == ans)
                                            e2.setText(setEdi(String.valueOf((long) ans)));
                                        else
                                            e2.setText(setEdi(String.valueOf(ans)));
                                    }
                                    if (s.equals("")) {

                                        e2.setText("");
                                    }
                                } else if (po == 0 && po2 == 2) {

                                    //double ans = Double.parseDouble(s.toString()) + 273.15;
                                    if (!s.equals("")) {
                                        String sq = "";
                                        for (int i = 0; i < s.length(); i++) {
                                            if (s.charAt(i) != ',')
                                                sq += s.charAt(i);

                                        }
                                        s = sq;
                                        double ans = BigDecimal.valueOf(Double.parseDouble(s.toString())).add(BigDecimal.valueOf(273.15)).doubleValue();


                                        if ((long) ans == ans)
                                            e2.setText(setEdi(String.valueOf((long) ans)));
                                        else
                                            e2.setText(setEdi(String.valueOf(ans)));
                                    }
                                    if (s.equals("")) {

                                        e2.setText("");
                                    }
                                } else if (po == 2 && po2 == 0) {


                                    //  double ans = (Double.parseDouble(s.toString()) - 273.15);
                                    if (!s.equals("")) {
                                        String sq = "";
                                        for (int i = 0; i < s.length(); i++) {
                                            if (s.charAt(i) != ',')
                                                sq += s.charAt(i);

                                        }
                                        s = sq;
                                        double ans = BigDecimal.valueOf(Double.parseDouble(s.toString())).subtract(BigDecimal.valueOf(273.15)).doubleValue();


                                        if ((long) ans == ans)
                                            e2.setText(setEdi(String.valueOf((long) ans)));
                                        else
                                            e2.setText(setEdi(String.valueOf(ans)));
                                    }
                                    if (s.equals("")) {

                                        e2.setText("");
                                    }
                                }
                            }

                            break;
                            case 6:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an7 = (BigDecimal.valueOf(Datastorge2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Datastorge2[po2]), 100, RoundingMode.HALF_UP).doubleValue();


                                    if ((long) an7 == an7)
                                        e2.setText(setEdi(String.valueOf((long) an7)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an7)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 7:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an8 = (BigDecimal.valueOf(Energy2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Energy2[po2]), 100, RoundingMode.HALF_UP).doubleValue();


                                    if ((long) an8 == an8)
                                        e2.setText(setEdi(String.valueOf((long) an8)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an8)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 8:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an9 = (BigDecimal.valueOf(Volume2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Volume2[po2]), 100, RoundingMode.HALF_UP).doubleValue();


                                    if ((long) an9 == an9)
                                        e2.setText(setEdi(String.valueOf((long) an9)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an9)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 9:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an10 = (BigDecimal.valueOf(FuelEconomy2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(FuelEconomy2[po2]), 100, RoundingMode.HALF_UP).doubleValue();


                                    if ((long) an10 == an10)
                                        e2.setText(setEdi(String.valueOf((long) an10)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an10)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 10:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an11 = (BigDecimal.valueOf(Area2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Area2[po2]), 100, RoundingMode.HALF_UP).doubleValue();


                                    if ((long) an11 == an11)
                                        e2.setText(setEdi(String.valueOf((long) an11)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an11)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 11:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an12 = (BigDecimal.valueOf(Datastorgetrasfer2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Datastorgetrasfer2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                    if ((long) an12 == an12)
                                        e2.setText(setEdi(String.valueOf((long) an12)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an12)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;
                            case 12:
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double an13 = (BigDecimal.valueOf(Frequency2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Frequency2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                    if ((long) an13 == an13)
                                        e2.setText(setEdi(String.valueOf((long) an13)));
                                    else
                                        e2.setText(setEdi(String.valueOf(an13)));
                                }
                                if (s.equals("")) {

                                    e2.setText("");
                                }
                                break;


                        }

                    }
                }
}            });



            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    pop = position;

                    switch (position) {

                        case 0:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter<String> arrayAdapter0 = new ArrayAdapter<String>(convert.this,R.layout.textsp1, length);
                            arrayAdapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter0);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;
                                    if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            s2.setAdapter(arrayAdapter0);
                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;
                                    if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                    sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });


                            break;
                        case 1:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(convert.this, R.layout.textsp1, Mass);
                            arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter1);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;
                                    if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            s2.setAdapter(arrayAdapter1);
                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;
                                    if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                    sel=false;

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                            break;
                        case 2:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter2 = new ArrayAdapter(convert.this, R.layout.textsp1, TIME);
                            arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter2);
                            s2.setAdapter(arrayAdapter2);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;

                                        if(sel==false) {
                                            e1.setText("");
                                            e2.setText("");

                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });


                            break;

                        case 3:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter3 = new ArrayAdapter(convert.this, R.layout.textsp1, Pressure);
                            arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter3);
                            s2.setAdapter(arrayAdapter3);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });


                            break;
                        case 4:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter4 = new ArrayAdapter(convert.this, R.layout.textsp1, Speed);
                            arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter4);
                            s2.setAdapter(arrayAdapter4);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                      po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });


                            break;
                        case 5:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter5 = new ArrayAdapter(convert.this, R.layout.textsp1, Temperature);
                            arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter5);
                            s2.setAdapter(arrayAdapter5);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;
                                    if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;
                                    if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            break;
                        case 6:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter6 = new ArrayAdapter(convert.this,  R.layout.textsp1, Datastorge);
                            arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter6);
                            s2.setAdapter(arrayAdapter6);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            break;
                        case 7:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter7 = new ArrayAdapter(convert.this,  R.layout.textsp1, Energy);
                            arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter7);
                            s2.setAdapter(arrayAdapter7);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            break;
                        case 8:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter8 = new ArrayAdapter(convert.this,  R.layout.textsp1, Volume);
                            arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter8);
                            s2.setAdapter(arrayAdapter8);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            break;
                        case 9:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter9 = new ArrayAdapter(convert.this,  R.layout.textsp1, FuelEconomy);
                            arrayAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter9);
                            s2.setAdapter(arrayAdapter9);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            break;
                        case 10:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter10 = new ArrayAdapter(convert.this,  R.layout.textsp1, Area);
                            arrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter10);
                            s2.setAdapter(arrayAdapter10);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            break;
                        case 11:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter11 = new ArrayAdapter(convert.this,  R.layout.textsp1, Datastorgetrasfer);
                            arrayAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter11);
                            s2.setAdapter(arrayAdapter11);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            break;
                        case 12:
                            e2.setText("");
                            e1.setText("");
                            ArrayAdapter arrayAdapter12 = new ArrayAdapter(convert.this,  R.layout.textsp1, Frequency);
                            arrayAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            s1.setAdapter(arrayAdapter12);
                            s2.setAdapter(arrayAdapter12);
                            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }


                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                    po2 = position;if(sel==false) {
                                        e1.setText("");
                                        e2.setText("");
                                    }
                                    sel=false;
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                            break;

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        }

        catch (Exception e){

            Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();

        }
        ImageView imageView=findViewById(R.id.imccn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=po;
                po=po2;
                po2=x;
                sel=true;
                String ss=e1.getText().toString();
                String ss2=e2.getText().toString();

                e2.setText(ss);
                e1.setText(ss2);

                s1.setSelection(po);
                s2.setSelection(po2);

            }
        });
        e1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                se1=b;
            }
        });
        e2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                se2=b;
            }
        });





        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable a) {

                if (se2 == true) {

                    int Enum=0,dotnum=0,Epos=-2,dotpos=-2,minpo=-2,minnum=0,numpos=0;


                    for(int i=0;i<a.toString().length();i++){
                        if(a.toString().charAt(i)=='E')
                        {
                            Enum++;
                            Epos=i;

                        }
                        if(a.toString().charAt(i)=='.')
                        {
                            dotnum++;
                            dotpos=i;
                        }
                        if(a.toString().charAt(i)=='-')
                        {
                            minnum++;
                            minpo=i;

                        }

                    }

                    if(Enum<=1&&minnum<=1&&dotnum<=1&&((a.toString().length()>1&&minpo==0&&a.toString().charAt(1)>='0'&&a.toString().charAt(1)<='9')||minpo==-2)&&((Epos>dotpos)||Epos==-2||dotpos==-2)&&Epos!=0&&dotpos!=0&&Epos!=a.toString().length()-1&&dotpos!=a.toString().length()-1){

                    String s = setEdi(a.toString());
                    if (!s.equals(a.toString())) {
                        int cursorPosition = e2.getSelectionStart();
                        e2.setText(s);


                        if (s.length() < a.length()) {
                            if (cursorPosition > 0)
                                e2.setSelection(cursorPosition - 1);

                        } else if (s.length() > a.length()) {
                            if (cursorPosition + 1 < s.length() + 1)
                                e2.setSelection(cursorPosition + 1);

                        } else if (s.length() == a.length())
                            e2.setSelection(cursorPosition);
                        String sq = "";
                        for (int i = 0; i < s.length(); i++) {
                            if (s.charAt(i) != ',')
                                sq += s.charAt(i);

                        }
                        s = sq;


                    }


                    switch (pop) {

                        case 0:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an = (BigDecimal.valueOf(length2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s)))).divide(BigDecimal.valueOf(length2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                if ((long) an == an)
                                    e1.setText(setEdi(String.valueOf((long) an)));
                                else
                                    e1.setText(setEdi(String.valueOf(an)));


                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }

                            break;
                        case 1:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an2 = (BigDecimal.valueOf(Mass2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Mass2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an2 == an2)
                                    e1.setText(setEdi(String.valueOf((long) an2)));
                                else
                                    e1.setText(setEdi(String.valueOf(an2)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }

                            break;
                        case 2:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an3 = (BigDecimal.valueOf(Time2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Time2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an3 == an3)
                                    e1.setText(setEdi(String.valueOf((long) an3)));
                                else
                                    e1.setText(setEdi(String.valueOf(an3)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 3:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an4 = (BigDecimal.valueOf(Pressure2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Pressure2[po2]), 100, RoundingMode.HALF_UP).doubleValue();

                                if ((long) an4 == an4)
                                    e1.setText(setEdi(String.valueOf((long) an4)));
                                else
                                    e1.setText(setEdi(String.valueOf(an4)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 4:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an5 = (BigDecimal.valueOf(Speed2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Speed2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                e1.setText("" + an5);
                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 5: {
                            if (po == 0 && po2 == 1) {

                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);


                                    }

                                    s = sq;
                                    double ans = ((BigDecimal.valueOf(9).divide(BigDecimal.valueOf(5), 100, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).add(BigDecimal.valueOf(32)).doubleValue();


                                    //double ans = (Double.parseDouble(s.toString()) * (9.0 / 5)) + 32;
                                    if ((long) ans == ans)
                                        e1.setText(setEdi(String.valueOf((long) ans)));
                                    else
                                        e1.setText(setEdi(String.valueOf(ans)));

                                    e1.setSelection(0);
                                }
                                if (s.equals("")) {

                                    e1.setText("");
                                }

                            } else if (po == 1 && po2 == 0) {
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double ans = (BigDecimal.valueOf(5).divide(BigDecimal.valueOf(9), 100, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())).subtract(BigDecimal.valueOf(32))).doubleValue();

                                    //double ans = (Double.parseDouble(s.toString()) - 32) * (5.0 / 9);
                                    if ((long) ans == ans)
                                        e1.setText(setEdi(String.valueOf((long) ans)));
                                    else
                                        e1.setText(setEdi(String.valueOf(ans)));

                                    e1.setSelection(0);
                                }
                                if (s.equals("")) {

                                    e1.setText("");
                                }
                            } else if (po == 2 && po2 == 1) {
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double ans = ((BigDecimal.valueOf(9).divide(BigDecimal.valueOf(5), 100, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())).subtract(BigDecimal.valueOf(273.15)))).add(BigDecimal.valueOf(32)).doubleValue();


                                    //   double ans = (Double.parseDouble(s.toString()) - 273.15) * (9.0 / 5) + 32;
                                    if ((long) ans == ans)
                                        e1.setText(setEdi(String.valueOf((long) ans)));
                                    else
                                        e1.setText(setEdi(String.valueOf(ans)));

                                    e1.setSelection(0);
                                }
                                if (s.equals("")) {

                                    e1.setText("");
                                }
                            } else if (po == 1 && po2 == 2) {
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double ans = ((BigDecimal.valueOf(5).divide(BigDecimal.valueOf(9), 100, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())).subtract(BigDecimal.valueOf(32)))).add(BigDecimal.valueOf(273.15)).doubleValue();


                                    //    double ans = (Double.parseDouble(s.toString()) - 32) * (5.0 / 9) + 273.15;
                                    if ((long) ans == ans)
                                        e1.setText(setEdi(String.valueOf((long) ans)));
                                    else
                                        e1.setText(setEdi(String.valueOf(ans)));

                                    e1.setSelection(0);
                                }
                                if (s.equals("")) {

                                    e1.setText("");
                                }
                            } else if (po == 0 && po2 == 2) {
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double ans = BigDecimal.valueOf(Double.parseDouble(s.toString())).add(BigDecimal.valueOf(273.15)).doubleValue();


                                    if ((long) ans == ans)
                                        e1.setText(setEdi(String.valueOf((long) ans)));
                                    else
                                        e1.setText(setEdi(String.valueOf(ans)));

                                    e1.setSelection(0);
                                }
                                if (s.equals("")) {

                                    e1.setText("");
                                }
                            } else if (po == 2 && po2 == 0) {
                                if (!s.equals("")) {
                                    String sq = "";
                                    for (int i = 0; i < s.length(); i++) {
                                        if (s.charAt(i) != ',')
                                            sq += s.charAt(i);

                                    }
                                    s = sq;
                                    double ans = BigDecimal.valueOf(Double.parseDouble(s.toString())).subtract(BigDecimal.valueOf(273.15)).doubleValue();


                                    if ((long) ans == ans)
                                        e1.setText(setEdi(String.valueOf((long) ans)));
                                    else
                                        e1.setText(setEdi(String.valueOf(ans)));

                                    e1.setSelection(0);
                                }
                                if (s.equals("")) {

                                    e1.setText("");
                                }
                            }
                        }

                        break;
                        case 6:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an7 = (BigDecimal.valueOf(Datastorge2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Datastorge2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an7 == an7)
                                    e1.setText(setEdi(String.valueOf((long) an7)));
                                else
                                    e1.setText(setEdi(String.valueOf(an7)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 7:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an8 = (BigDecimal.valueOf(Energy2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Energy2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an8 == an8)
                                    e1.setText(setEdi(String.valueOf((long) an8)));
                                else
                                    e1.setText(setEdi(String.valueOf(an8)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 8:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an9 = (BigDecimal.valueOf(Volume2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Volume2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an9 == an9)
                                    e1.setText(setEdi(String.valueOf((long) an9)));
                                else
                                    e1.setText(setEdi(String.valueOf(an9)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 9:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an10 = (BigDecimal.valueOf(FuelEconomy2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(FuelEconomy2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an10 == an10)
                                    e1.setText(setEdi(String.valueOf((long) an10)));
                                else
                                    e1.setText(setEdi(String.valueOf(an10)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 10:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an11 = (BigDecimal.valueOf(Area2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Area2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an11 == an11)
                                    e1.setText(setEdi(String.valueOf((long) an11)));
                                else
                                    e1.setText(setEdi(String.valueOf(an11)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 11:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an12 = (BigDecimal.valueOf(Datastorgetrasfer2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Datastorgetrasfer2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an12 == an12)
                                    e1.setText(setEdi(String.valueOf((long) an12)));
                                else
                                    e1.setText(setEdi(String.valueOf(an12)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;
                        case 12:
                            if (!s.equals("")) {
                                String sq = "";
                                for (int i = 0; i < s.length(); i++) {
                                    if (s.charAt(i) != ',')
                                        sq += s.charAt(i);

                                }
                                s = sq;
                                double an13 = (BigDecimal.valueOf(Frequency2[po]).multiply(BigDecimal.valueOf(Double.parseDouble(s.toString())))).divide(BigDecimal.valueOf(Frequency2[po2]), 100, RoundingMode.HALF_UP).doubleValue();
                                if ((long) an13 == an13)
                                    e1.setText(setEdi(String.valueOf((long) an13)));
                                else
                                    e1.setText(setEdi(String.valueOf(an13)));

                                e1.setSelection(0);
                            }
                            if (s.equals("")) {

                                e1.setText("");
                            }
                            break;


                    }

                }}
            }
        });













    }











    private String setEdi(String e) {



        int q=0;int dot=0;
        String a=e,n="",sum="";
        int co=a.length();
        for(int i=0;i<a.length();i++) {

            if((a.charAt(i)>='0'&&a.charAt(i)<='9')||a.charAt(i)=='E')
            {	n+=a.charAt(i);
                if(a.charAt(i)=='E'&&i+1<a.length()&&a.charAt(i+1)=='-')
                {n+=a.charAt(i+1);
                    i++;

                }


            }else if(a.charAt(i)!=','){

                if(dot==0) {
                    sum+=comma(n);
                    n="";

                    q++;}
                if(dot==1) {
                    sum+=n;
                    n="";
                }

                if(a.charAt(i)=='.') {
                    dot=1;
                    sum+=a.charAt(i);
                }
                else {
                    dot=0;
                    sum+=a.charAt(i);
                }



            }




        }

        if((a.length()>0&&a.charAt(a.length()-1)>='0'&&a.charAt(a.length()-1)<='9')||(a.length()>0&&a.charAt(a.length()-1)=='E')||(a.length()>1&&a.charAt(a.length()-1)=='-')&&a.charAt(a.length()-2)=='E')
        {if(dot==0) {
            sum+=comma(n);
            n="";

            q++;}
            if(dot==1) {
                sum+=n;
                n="";
            }
        }






        return sum;



    }

    private String comma(String n) {
        String s="",swap="";
        if(n.equals("")) {
            return "";

        }
        int coun=0;
        for(int i=n.length()-1;i>=0;i--) {
            s="";
            s+=n.charAt(i)+swap;
            swap=s;coun++;
            if(coun==3&&i!=0) {
                s="";
                s+=','+swap;
                swap=s;
                coun=0;
            }


        }
        return s;
    }






}

