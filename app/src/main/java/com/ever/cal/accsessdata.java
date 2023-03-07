package com.ever.cal;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;

public class accsessdata {
    private SQLiteDatabase db;
    private SQLiteOpenHelper data2;
    public accsessdata(Context c){

        this.data2=new data(c);

    }
    public void open(){
        this.db=this.data2.getWritableDatabase();
    }
    public void close() {
        if (this.db != null) {
            this.db.close();

        }

    }



   /* public boolean insertData( String c) {
        ContentValues contentValues = new ContentValues();


        long result = this.db.insert(data.ta_name,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
*/




    public ArrayList<calclass> getAlltype() {
ArrayList<calclass>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select name,weightser,caloreiser from counter;",null);
        if(c.moveToFirst()) {
            do {
                a.add(new calclass(c.getString(0),c.getString(1),c.getString(2)));

            } while (c.moveToNext());
        }

     return  a;
    }
    public ArrayList<calclass> getAlltype2(String s) {
        ArrayList<calclass>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select name,weightser,caloreiser from counter Where name LIKE ? ;",new String[]{s+"%"});
        if(c.moveToFirst()) {
            do {
                a.add(new calclass(c.getString(0),c.getString(1),c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<spandcal> getweancalo2(String s) {//caloreioz
        ArrayList<spandcal>a=new ArrayList<>();
            Cursor c= this.db.rawQuery("select weightser,weightgram ,weightoz from counter where name LIKE ? ;",new String[]{s+"%"});
        if(c.moveToFirst()) {
            do {
                a.add(new spandcal(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<calo> getcalo2(String s) {//caloreioz
        ArrayList<calo>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select caloreiser,caloreigram ,caloreioz from counter WHERE name LIKE ?;",new String []{s+"%"});
        if(c.moveToFirst()) {
            do {
                a.add(new calo(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<calclass> getAlltype3(String s) {
        ArrayList<calclass>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select name,weightser,caloreiser from counter Where name =? ;",new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(new calclass(c.getString(0),c.getString(1),c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<spandcal> getweancalo3(String s) {//caloreioz
        ArrayList<spandcal>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select weightser,weightgram ,weightoz from counter where name =? ;",new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(new spandcal(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<calo> getcalo3(String s) {//caloreioz
        ArrayList<calo>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select caloreiser,caloreigram ,caloreioz from counter WHERE name = ?;",new String []{s});
        if(c.moveToFirst()) {
            do {
                a.add(new calo(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<String> gettype() {
        ArrayList<String>a=new ArrayList<>();
        a.add("Enter type :");
        Cursor c= this.db.rawQuery("select DISTINCT type from counter ;",null);
        if(c.moveToFirst()) {
            do {
                a.add(c.getString(0));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<String> gettAllname(String s) {
        ArrayList<String>a=new ArrayList<>();
        a.add("Enter name :");
        Cursor c= this.db.rawQuery("select name from counter WHERE type = ?" +";", new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(c.getString(0));

            } while (c.moveToNext());
        }

        return  a;
    }

    public ArrayList<calclass> getconsbytype(String s) {
        ArrayList<calclass>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select name,weightser,caloreiser from counter  where type = ? ",new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(new calclass(c.getString(0),c.getString(1),c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<calclass> getconsbyname(String s) {
        ArrayList<calclass>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select name,weightser,caloreiser from counter  where name = ? ",new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(new calclass(c.getString(0),c.getString(1),c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<spandcal> getweancalo() {//caloreioz
        ArrayList<spandcal>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select weightser,weightgram ,weightoz from counter  ;",null);
        if(c.moveToFirst()) {
            do {
                a.add(new spandcal(c.getString(0),
                c.getString(1),
                c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<spandcal> getweancalo(String s) {//caloreioz
        ArrayList<spandcal>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select weightser,weightgram ,weightoz from counter where type=? ;",new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(new spandcal(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<spandcal> getweancaloname(String s) {//caloreioz
        ArrayList<spandcal>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select weightser,weightgram ,weightoz from counter where name=? ;",new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(new spandcal(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<calo> getcalo() {//caloreioz
        ArrayList<calo>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select caloreiser,caloreigram ,caloreioz from counter;",null);
        if(c.moveToFirst()) {
            do {
                a.add(new calo(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }

    public ArrayList<calo> getcalo(String s) {//caloreioz
        ArrayList<calo>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select caloreiser,caloreigram ,caloreioz from counter WHERE type= ?;",new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(new calo(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public ArrayList<calo> getcaloname(String s) {//caloreioz
        ArrayList<calo>a=new ArrayList<>();
        Cursor c= this.db.rawQuery("select caloreiser,caloreigram ,caloreioz from counter WHERE name= ?;",new String[]{s});
        if(c.moveToFirst()) {
            do {
                a.add(new calo(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }

        return  a;
    }
    public String gettypeofname(String s) {//caloreioz
        ArrayList<calo>a=new ArrayList<>();
        String d="";
        Cursor c= this.db.rawQuery("select type from counter WHERE name= ?;",new String[]{s});
        if(c.moveToFirst()) {
            do {
              d=c.getString(0);

            } while (c.moveToNext());
        }

        return  d;
    }













   /* public Car getCar(int id) {


        Cursor res = this.db.rawQuery("select * from "+data.ts_name+" WHERE id=?",new String[]{String.valueOf(id)});

        if(res!=null&&res.moveToFirst()){


            Car car=new Car(res.getInt(0),res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
            res.close();
            return car;
        }

        res.close();
        return null;

    }

    public ArrayList<Car> search(String q){

        Cursor cursor= this.db.rawQuery("select * from "+data.ts_name+" WHERE name LIKE ?",new String[]{q});
        ArrayList<Car>cw=new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                Car c=new Car (cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5));
                cw.add(c);
            } while (cursor.moveToNext());

        }
        return cw;

    }


    public boolean updateData(Car c) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(data.co_1,c.getId());
        contentValues.put(data.co_2,c.getName());
        contentValues.put(data.co_3,c.getModel());
        contentValues.put(data.co_4,c.getColor());
        contentValues.put(data.co_5,c.getDescrption());
        contentValues.put(data.co_6,c.getImage());

        db.update(data.ts_name, contentValues, "id = ?",new String[] { String.valueOf(c.getId())});
        return true;
    }
    public boolean updateData2(int idold,int idnew) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(data.co_1,idnew);
        db.update(data.ts_name, contentValues, "id = ?",new String[] { String.valueOf(idold)});
        return true;
    }

    public boolean deleteData (int  id) {
        int  d =this.db.delete(data.ts_name, "id = ?",new String[] {String.valueOf(id)});
        return d>0;
    }



*/



}
