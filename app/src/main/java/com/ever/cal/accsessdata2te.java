package com.ever.cal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class accsessdata2te {
    private SQLiteDatabase db;
    private SQLiteOpenHelper data2;
    public accsessdata2te(Context c){

        this.data2=new data3(c);

    }
    public void open(){
        this.db=this.data2.getWritableDatabase();
    }
    public void close() {
        if (this.db != null) {
            this.db.close();

        }

    }



    public boolean insertData(bud2 c) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(data3.co1_name,c.getDate());
        contentValues.put(data3.weight_se,c.getHour());
        contentValues.put(data3.calorei_se,c.getCalorei());
        long result = this.db.insert(data3.ta_name,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
   public ArrayList<bud2> select2() {
        ArrayList<bud2>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select * from save2 ;",null);
       if(c.moveToFirst()) {
            do {
                a.add(new bud2(c.getString(0),c.getString(1),c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }









    public boolean deleteData (String  date,String hour) {
        int  d =this.db.delete(data3.ta_name, "date = ? AND hour =?",new String[] {date,hour});
        return d>0;
    }




}