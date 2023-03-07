package com.ever.cal;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ever.cal.R;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;

public class Mainn2Activity extends AppCompatActivity {
  static   ListView listView;
 Toolbar toolbar;
    static ArrayList<bud2>ar;
   static newadapter2 newadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(this);
        setContentView(R.layout.activity_mainn2);
        toolbar = findViewById(R.id.savetool);
        setSupportActionBar(toolbar);
        LocalDate localDate=LocalDate.now();
        String calorei=getIntent().getStringExtra("Ok");
        LocalTime nowtime=LocalTime.now();
        listView=findViewById(R.id.list);
        accsessdata2te accsessdata=new accsessdata2te(this);
        accsessdata.open();
        String date=localDate.getDayOfWeek()+"-"+localDate.getMonthValue()+"-"+localDate.getYear();
        String time =nowtime.getHour()+"-"+nowtime.getMinute()+"-"+nowtime.getSecond();
        DateTimeFormatter pattren=DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ss=nowtime.format(pattren);
        accsessdata.insertData(new bud2(date, ss+"",calorei));
        ar=accsessdata.select2();
        newadapter=new newadapter2(ar,this);
        listView.setAdapter(newadapter);



    }




}
