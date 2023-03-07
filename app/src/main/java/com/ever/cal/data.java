package com.ever.cal;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class data extends SQLiteAssetHelper {
    public static final String DB_name="all.db";
    public static final String co1_name="name";
    public static final String ta_name="calorei";
public  static  final String weight_se="weightser";
    public  static  final String calorei_se="caloreiser";
    public data(Context context) {
        super(context,DB_name , null, 7);
    }

}


