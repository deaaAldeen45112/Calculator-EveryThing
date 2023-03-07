package com.ever.cal;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class data3 extends SQLiteAssetHelper {
    public static final String DB_name= "save2.db";
    public static final String co1_name="date";
    public static final String ta_name="save2";
    public  static  final String weight_se="hour";
    public  static  final String calorei_se="calorei";
    public data3(Context context) {
        super(context,DB_name , null, 1);
    }

}
