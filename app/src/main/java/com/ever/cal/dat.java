package com.ever.cal;


import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class dat extends SQLiteAssetHelper {
    public static final String DB_name="fin.db";
    public static final String one_name="eq";
    public static final String two_name="eq2";
    public static final String ta_name="dia";
    public dat(Context context) {


        super(context,DB_name , null, 1);
    }

}

