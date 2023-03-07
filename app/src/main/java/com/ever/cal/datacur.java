package com.ever.cal;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class datacur extends SQLiteAssetHelper {
    public static final String DB_name="cur.db";
    public static final String co1_name="price";
    public static final String ta_name="mon";
public  static  final String weight_se="weightser";
    public  static  final String calorei_se="caloreiser";
    public datacur(Context context) {
        super(context,DB_name , null, 1);
    }

}


