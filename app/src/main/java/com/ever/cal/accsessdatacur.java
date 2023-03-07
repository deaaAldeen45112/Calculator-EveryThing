package com.ever.cal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;

public class accsessdatacur {
    private SQLiteDatabase db;
    private SQLiteOpenHelper data2;
    public accsessdatacur(Context c){

        this.data2=new datacur(c);

    }
    public void open(){
        this.db=this.data2.getWritableDatabase();
    }
    public void close() {
        if (this.db != null) {
            this.db.close();

        }

    }

    public boolean updateData2(String sem,String price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(datacur.co1_name,price);
        db.update(datacur.ta_name, contentValues, "se=?",new String[] {sem});
        return true;
    }


    public  ArrayList<String> select() {

            ArrayList<String>a=new ArrayList<>();
            Cursor c= this.db.rawQuery("select price from mon ;",null);
            if(c.moveToFirst()) {
                do {
                    a.add((c.getString(0)));

                } while (c.moveToNext());
            }

            return  a;
        }




    }

