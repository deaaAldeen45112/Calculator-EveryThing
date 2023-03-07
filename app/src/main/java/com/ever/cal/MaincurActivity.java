package com.ever.cal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ever.cal.accsessdatacur;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.LocalDate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;

public class MaincurActivity extends AppCompatActivity {
Toolbar toolbar;
    String date;
    TextView textView;
    Spinner spinner,s1,s2;
    EditText e1,e2;
    int textsp1=0;
    boolean sel=false,se1,se2;
    com.ever.cal.accsessdatacur accsessdatacur;
    int textsp2=0;

    int close1=1;
    int close2=1;
    SharedPreferences sp;
    SharedPreferences.Editor Edit;
    ArrayList<String>arrayList=new ArrayList<>();
    String [] strings=new String[]{"EUR","GBP", "HKD", "IDR","DKK","INR","CHF","MXN","CZK","SGD","THB","HRK","MYR","NOK","CNY","BGN","PHP","SEK","PLN","ZAR","CAD","ISK","BRL","RON","NZD","TRY","JPY", "RUB","KRW","USD","HUF","AUD"};
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
        AndroidThreeTen.init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maincur);
        toolbar = findViewById(R.id.vtoolbar);
        setSupportActionBar(toolbar);
        accsessdatacur=new accsessdatacur(this);
       LocalDate localDate=LocalDate.now();
       date=localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth();

 textView=findViewById(R.id.tu);
        s1 = findViewById(R.id.chid1sp);
        s2 = findViewById(R.id.chid2sp);
        e1 = findViewById(R.id.cve1);
        e2 = findViewById(R.id.cve2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.textsp1, getResources().getStringArray(R.array.cur));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.textsp1, getResources().getStringArray(R.array.cur));
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(arrayAdapter2);

        ImageButton imageButton=findViewById(R.id.imcur);
        RequestQueue queue = Volley.newRequestQueue(this);
        sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

//volley https request to take result
        String apilink ="https://api.ratesapi.io/api/"+date;
        //Toast.makeText(this, date+"    "+sp.getString("date","2020-10-05"), Toast.LENGTH_SHORT).show();
if(!sp.getString("date","2020-10-20").equals(date)) {
// Request a string response from the provided URL.
   // Toast.makeText(getBaseContext(), date+"",Toast.LENGTH_SHORT).show();
// get --> more information ,small faster than post,not safe,post --> in pass,safe
    StringRequest stringRequest = new StringRequest(Request.Method.GET, apilink,
            new Response.Listener<String>() {
                @Override
// true connection
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string

                    JSONObject jsonObject;
                    try {
                        jsonObject = new JSONObject(response);
                        JSONObject jsonObject1 = jsonObject.getJSONObject("rates");
                        // JSONObject jsonObject2 = jsonObject.getJSONObject("date");
                        //Toast.makeText(MaincurActivity.this, response + "   " + response.substring(response.lastIndexOf("date") + 7, response.length() - 2), Toast.LENGTH_SHORT).show();
                        date = response.substring(response.lastIndexOf("date") + 7, response.length() - 2);
                        Iterator<String> Keys = jsonObject1.keys();
                        arrayList.add("1");
                        while (Keys.hasNext()) {
                            String key = Keys.next();
                            if (!key.equals("ILS"))
                                arrayList.add(jsonObject1.getString(key));

                        }
                        accsessdatacur.open();
                        for (int i = 0; i < arrayList.size(); i++) {
                            accsessdatacur.updateData2(strings[i], arrayList.get(i));

                        }
                        accsessdatacur.close();
                          Edit = sp.edit().putString("date", date);
                        Edit.apply();
                        textView.setText("last update : " + date);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            },
// false connection
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    accsessdatacur.open();

                    arrayList = accsessdatacur.select();
                    // Toast.makeText(getBaseContext(), arrayList.get(0)+"", Toast.LENGTH_SHORT).show();
                    accsessdatacur.close();
                   // Toast.makeText(getBaseContext(), date+"1",Toast.LENGTH_SHORT).show();
                    textView.setText("last update : " + sp.getString("date", "2020-10-20"));
                }
            });

// Add the request to the RequestQueue.
    queue.add(stringRequest);
}

else {
    accsessdatacur.open();

    arrayList = accsessdatacur.select();
    accsessdatacur.close();
    textView.setText("last update : " + sp.getString("date", "2020-10-20"));
}





        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        textsp1=position;
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


  textsp2=position;
 if(sel==false) {
     e1.setText("");
     e2.setText("");
 }
 sel=false;
 //((TextView)parent.getChildAt(0)).setTextSize(getResources().getDimension(R.dimen._8sdp));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

e1.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable a) {

        if(se1==true) {


            int Enum = 0, dotnum = 0, Epos = -2, dotpos = -2, minpo = -2, minnum = 0, numpos = 0;


            for (int i = 0; i < a.toString().length(); i++) {
                if (a.toString().charAt(i) == 'E') {
                    Enum++;
                    Epos = i;

                }
                if (a.toString().charAt(i) == '.') {
                    dotnum++;
                    dotpos = i;
                }
                if (a.toString().charAt(i) == '-') {
                    minnum++;
                    minpo = i;

                }

            }

            if(Enum<=1&&minnum<=1&&dotnum<=1&&((a.toString().length()>1&&minpo==0&&a.toString().charAt(1)>='0'&&a.toString().charAt(1)<='9')||minpo==-2)&&((Epos>dotpos)||Epos==-2||dotpos==-2)&&Epos!=0&&dotpos!=0&&Epos!=a.toString().length()-1&&dotpos!=a.toString().length()-1)
            {
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

                double d = ((BigDecimal.valueOf(Double.parseDouble(arrayList.get(textsp2))).multiply(BigDecimal.valueOf(Double.parseDouble(s)))).divide(BigDecimal.valueOf(Double.parseDouble(arrayList.get(textsp1))), 4, RoundingMode.HALF_UP)).doubleValue();

                if ((long) d == d)
                    e2.setText(  setEdi(String.valueOf((long)d)));
                else
                    e2.setText(  setEdi(String.valueOf(d)));

            }

            else if(!s.equals("")){
                String sq = "";
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != ',')
                        sq += s.charAt(i);

                }
                s = sq;

                double d = ((BigDecimal.valueOf(Double.parseDouble(arrayList.get(textsp2))).multiply(BigDecimal.valueOf(Double.parseDouble(s)))).divide(BigDecimal.valueOf(Double.parseDouble(arrayList.get(textsp1))), 4, RoundingMode.HALF_UP)).doubleValue();

            if ((long) d == d)
                e2.setText(  setEdi(String.valueOf((long)d)));
            else
                e2.setText(  setEdi(String.valueOf(d)));



        }

        else if(s.equals("")){

            e2.setText("");
            }
        }

       }}
});


       e2.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable a){
            if (se2 == true) {


                int Enum = 0, dotnum = 0, Epos = -2, dotpos = -2, minpo = -2, minnum = 0, numpos = 0;


                for (int i = 0; i < a.toString().length(); i++) {
                    if (a.toString().charAt(i) == 'E') {
                        Enum++;
                        Epos = i;

                    }
                    if (a.toString().charAt(i) == '.') {
                        dotnum++;
                        dotpos = i;
                    }
                    if (a.toString().charAt(i) == '-') {
                        minnum++;
                        minpo = i;

                    }

                }

                if(Enum<=1&&minnum<=1&&dotnum<=1&&((a.toString().length()>1&&minpo==0&&a.toString().charAt(1)>='0'&&a.toString().charAt(1)<='9')||minpo==-2)&&((Epos>dotpos)||Epos==-2||dotpos==-2)&&Epos!=0&&dotpos!=0&&Epos!=a.toString().length()-1&&dotpos!=a.toString().length()-1)         {   String s = setEdi(a.toString());
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

                        double d = ((BigDecimal.valueOf(Double.parseDouble(arrayList.get(textsp1))).multiply(BigDecimal.valueOf(Double.parseDouble(s)))).divide(BigDecimal.valueOf(Double.parseDouble(arrayList.get(textsp2))), 4, RoundingMode.HALF_UP)).doubleValue();

                        if ((long) d == d)
                            e1.setText(setEdi(String.valueOf((long) d)));
                        else
                            e1.setText(setEdi(String.valueOf(d)));

                    } else if (!s.equals("")) {
                        String sq = "";
                        for (int i = 0; i < s.length(); i++) {
                            if (s.charAt(i) != ',')
                                sq += s.charAt(i);

                        }
                        s = sq;

                        double d = ((BigDecimal.valueOf(Double.parseDouble(arrayList.get(textsp1))).multiply(BigDecimal.valueOf(Double.parseDouble(s)))).divide(BigDecimal.valueOf(Double.parseDouble(arrayList.get(textsp2))), 4, RoundingMode.HALF_UP)).doubleValue();

                        if ((long) d == d) {

                            e1.setText(setEdi(String.valueOf((long) d)));
                        } else {
                            e1.setText(setEdi(String.valueOf(d)));


                        }


                    } else if (s.equals("")) {

                        e1.setText("");
                    }
                }

            }
        }



        });
















imageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    int x=textsp1;
    textsp1=textsp2;
    textsp2=x;
    String ss=e1.getText().toString();
    String ss2=e2.getText().toString();

    e2.setText(ss);
    e1.setText(ss2);
    sel=true;
        s1.setSelection(textsp1);
        s2.setSelection(textsp2);



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
