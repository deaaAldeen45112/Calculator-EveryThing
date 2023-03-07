package com.ever.cal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;


public class acsessdatalist {
    private SQLiteDatabase db;
    private SQLiteOpenHelper data2;
    public acsessdatalist(Context c){

        this.data2=new dat(c);

    }
    public void open(){
        this.db=this.data2.getWritableDatabase();
    }
    public void close() {
        if (this.db != null) {
            this.db.close();

        }

    }



    public ArrayList<savelist> select() {

        ArrayList<savelist>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select * from dia",null);
        if(c.moveToFirst()) {
            do {
              a.add(new savelist(c.getInt(0),c.getString(1),c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }

    public boolean insertData(String eq,String er) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("eq",eq);
        contentValues.put("eq2",er);
        long result = this.db.insert(datalist.ta_name,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean deleteData (int id) {
        int  d =this.db.delete(datalist.ta_name, "id=?",new String[] {String.valueOf(id)});
        return d>0;
    }


}

