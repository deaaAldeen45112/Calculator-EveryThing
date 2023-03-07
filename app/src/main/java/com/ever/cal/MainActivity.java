package com.ever.cal;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.preference.PreferenceManager;

import com.ever.cal.savelist;
import com.google.android.material.navigation.NavigationView;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, pl, div, root, div2, pow, min, mul, an, eq, dot, c,  rach, steps;//ln, fac abs, sin, cos, tan, asin, acos, atan, log, logten, exp, pi, sec, csc, cot;
    ImageButton cd;
    static EditText edi;
    static TextView textView;
    int cout = 0;
    int coma=0;
//acsessdatalist acsessdatalist=new acsessdatalist(this);
    int decimal=10;
    int le = 0;
    int ri = 0;
    boolean i;
    int g = 1;
    ArrayList<savelist> dia=new ArrayList<>();

    String r1, r2;

    static int Theme = 0;
    SharedPreferences sp;
    SharedPreferences.Editor Edit;
    private DrawerLayout drawerLayout;
    private AppBarConfiguration mAppBarConfiguration;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    static ArrayList<String> ar = new ArrayList<String>();
    Toolbar toolbar;
    String eq2="";

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HwAds.init(this);
        BannerView bannerView=findViewById(R.id.hw_banner_view);
        AdParam adParam=new AdParam.Builder().build();
        bannerView.loadAd(adParam);
        // Obtain BannerView based on the configuration in


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Edit=sp.edit();
decimal=sp.getInt("dec",5);
coma=sp.getInt("coma",0);
        edi = findViewById(R.id.edit);
        textView = findViewById(R.id.textview);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n0 = findViewById(R.id.n0);
        pl = findViewById(R.id.plus);
        steps = findViewById(R.id.steps);
        div = findViewById(R.id.div);
        div2 = findViewById(R.id.div2);
        mul = findViewById(R.id.multi);
        min = findViewById(R.id.min);
        an = findViewById(R.id.an);
        eq = findViewById(R.id.eq);
        dot = findViewById(R.id.dot);
        c = findViewById(R.id.c);
        rach = findViewById(R.id.pat);
        cd = findViewById(R.id.re);
        pow = findViewById(R.id.pow);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            edi.setShowSoftInputOnFocus(false);
        }

textView.setMovementMethod(new ScrollingMovementMethod());
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
       Menu menu=navigationView.getMenu();
        MenuItem menuItem=menu.findItem(R.id.Theme);
        SpannableString s=new SpannableString(menuItem.getTitle());
        s.setSpan(new TextAppearanceSpan(this,R.style.text),0,s.length(),0);
        menuItem.setTitle(s);
        navigationView.setNavigationItemSelectedListener(this);


        final long[] offset = {-1};


        switch (Theme) {
            case 1:
                if (Build.VERSION.SDK_INT >= 21)
                    getWindow().setStatusBarColor(Color.parseColor("#03A9F4"));
                div.setBackgroundColor(Color.parseColor("#03A9F4"));
                pl.setBackgroundColor(Color.parseColor("#03A9F4"));
                mul.setBackgroundColor(Color.parseColor("#03A9F4"));
                div2.setBackgroundColor(Color.parseColor("#03A9F4"));
                c.setBackgroundColor(Color.parseColor("#03A9F4"));
                rach.setBackgroundColor(Color.parseColor("#03A9F4"));
                min.setBackgroundColor(Color.parseColor("#03A9F4"));


                break;
            case 2: {
                if (Build.VERSION.SDK_INT >= 21) {

                    //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
                    //getWindow().setNavigationBarColor(Color.parseColor("#CDDC39"));

                    //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                    getWindow().setStatusBarColor(Color.parseColor("#CDDC39"));
                    div.setBackgroundColor(Color.parseColor("#CDDC39"));
                    pl.setBackgroundColor(Color.parseColor("#CDDC39"));
                    mul.setBackgroundColor(Color.parseColor("#CDDC39"));
                    div2.setBackgroundColor(Color.parseColor("#CDDC39"));
                    c.setBackgroundColor(Color.parseColor("#CDDC39"));
                    rach.setBackgroundColor(Color.parseColor("#CDDC39"));
                    min.setBackgroundColor(Color.parseColor("#CDDC39"));
                    Theme = 2;


                }

            }
            break;
            case 3: {
                if (Build.VERSION.SDK_INT >= 21) {

                    //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
                    //getWindow().setNavigationBarColor(Color.parseColor("#03A9F4"));

                    //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                    getWindow().setStatusBarColor(Color.parseColor("#9C27B0"));
                    div.setBackgroundColor(Color.parseColor("#9C27B0"));
                    pl.setBackgroundColor(Color.parseColor("#9C27B0"));
                    mul.setBackgroundColor(Color.parseColor("#9C27B0"));
                    div2.setBackgroundColor(Color.parseColor("#9C27B0"));
                    c.setBackgroundColor(Color.parseColor("#9C27B0"));
                    rach.setBackgroundColor(Color.parseColor("#9C27B0"));
                    min.setBackgroundColor(Color.parseColor("#9C27B0"));
                    Theme = 3;


                }
            }
            break;
            case 4: {
                if (Build.VERSION.SDK_INT >= 21) {

                    //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
//                        getWindow().setNavigationBarColor(Color.parseColor("#E91E63"));

                    //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                    getWindow().setStatusBarColor(Color.parseColor("#E91E63"));
                    div.setBackgroundColor(Color.parseColor("#E91E63"));
                    pl.setBackgroundColor(Color.parseColor("#E91E63"));
                    mul.setBackgroundColor(Color.parseColor("#E91E63"));
                    div2.setBackgroundColor(Color.parseColor("#E91E63"));
                    c.setBackgroundColor(Color.parseColor("#E91E63"));
                    rach.setBackgroundColor(Color.parseColor("#E91E63"));
                    min.setBackgroundColor(Color.parseColor("#E91E63"));
                    Theme = 4;


                }
            }
            break;
            case 5: {
                if (Build.VERSION.SDK_INT >= 21) {

                    //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
                    //                      getWindow().setNavigationBarColor(Color.parseColor("#4CAF50"));

                    //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                    getWindow().setStatusBarColor(Color.parseColor("#4CAF50"));
                    div.setBackgroundColor(Color.parseColor("#4CAF50"));
                    pl.setBackgroundColor(Color.parseColor("#4CAF50"));
                    mul.setBackgroundColor(Color.parseColor("#4CAF50"));
                    div2.setBackgroundColor(Color.parseColor("#4CAF50"));
                    c.setBackgroundColor(Color.parseColor("#4CAF50"));
                    rach.setBackgroundColor(Color.parseColor("#4CAF50"));
                    min.setBackgroundColor(Color.parseColor("#4CAF50"));
                    Theme = 5;


                }
            }
            break;
            case 6: {
                if (Build.VERSION.SDK_INT >= 21) {

                    //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
                    //    getWindow().setNavigationBarColor(Color.parseColor("#8BC34A"));

                    //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                    getWindow().setStatusBarColor(Color.parseColor("#8BC34A"));
                    div.setBackgroundColor(Color.parseColor("#8BC34A"));
                    pl.setBackgroundColor(Color.parseColor("#8BC34A"));
                    mul.setBackgroundColor(Color.parseColor("#8BC34A"));
                    div2.setBackgroundColor(Color.parseColor("#8BC34A"));
                    c.setBackgroundColor(Color.parseColor("#8BC34A"));
                    rach.setBackgroundColor(Color.parseColor("#8BC34A"));
                    min.setBackgroundColor(Color.parseColor("#8BC34A"));
                    Theme = 6;


                }


            }
            break;
            case 7: {
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(Color.parseColor("#673AB7"));
                    div.setBackgroundColor(Color.parseColor("#673AB7"));
                    pl.setBackgroundColor(Color.parseColor("#673AB7"));
                    mul.setBackgroundColor(Color.parseColor("#673AB7"));
                    div2.setBackgroundColor(Color.parseColor("#673AB7"));
                    c.setBackgroundColor(Color.parseColor("#673AB7"));
                    rach.setBackgroundColor(Color.parseColor("#673AB7"));
                    min.setBackgroundColor(Color.parseColor("#673AB7"));
                    Theme = 7;


                }

            }
            break;
            case 8: {
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(Color.parseColor("#000000"));
                    div.setBackgroundColor(Color.parseColor("#000000"));
                    pl.setBackgroundColor(Color.parseColor("#000000"));
                    mul.setBackgroundColor(Color.parseColor("#000000"));
                    div2.setBackgroundColor(Color.parseColor("#000000"));
                    c.setBackgroundColor(Color.parseColor("#000000"));
                    rach.setBackgroundColor(Color.parseColor("#000000"));
                    min.setBackgroundColor(Color.parseColor("#000000"));
                    Theme = 8;


                }

            }
            break;

        }




        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("1");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "1" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "1" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);

               }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("2");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "2" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "2" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                setEdi(cursorPosition,0);
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("3");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "3" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "3" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("4");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "4" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "4" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void
            onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("5");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "5" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "5" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("6");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "6" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "6" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("7");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "7" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "7" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("8");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "8" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "8" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("9");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "9" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "9" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);
            }
        });
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPosition =0;
                cout = 0;

                textView.setText("");
                String div = edi.getText().toString();
                if (div.length() == 0) {

                    edi.setText("0");
                    edi.setSelection(1);
                    cursorPosition=1;
                } else {

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "0" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition=cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "0" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;


                    }
                }
                if(coma==0)
                    setEdi(cursorPosition,0);
            }
        });


        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {textView.setText("");
                String div = edi.getText().toString();
                int cursorPosition =0;
                if (div.length() != 0) {

                    cout = 0;

                        CharSequence enteredText = edi.getText().toString();
                        CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                        CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                        if (div.length() == edi.getSelectionStart() - 1) {
                            edi.setText(cursorToEnd + "+" + cursorToEnd2);
                            edi.setSelection(cursorToEnd.length());
                            cursorPosition = cursorToEnd.length();

                        } else {
                            edi.setText(cursorToEnd + "+" + cursorToEnd2);
                            edi.setSelection(cursorToEnd.length() + 1);
                            cursorPosition = cursorToEnd.length() + 1;


                        }

                    if (coma == 0)
                        setEdi(cursorPosition, 0);
                } }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { textView.setText("");
                String div = edi.getText().toString();
                int cursorPosition =0;
                if (div.length() != 0) {

                    cout = 0;

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "×" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition = cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "×" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;


                    }

                    if (coma == 0)
                        setEdi(cursorPosition, 0);
                } }

        });

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {textView.setText("");
                String div = edi.getText().toString();
                int cursorPosition =0;
                if (div.length() != 0) {

                    cout = 0;

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "-" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition = cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "-" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;


                    }

                    if (coma == 0)
                        setEdi(cursorPosition, 0);
                }
                else {
                    edi.setText(edi.getText() + "" + "-");
                    edi.setSelection(edi.getText().length());
                }
            }
        });




        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                String div = edi.getText().toString();
                int cursorPosition =0;
                if (div.length() != 0) {

                    cout = 0;

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "÷" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition = cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "÷" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                    }

                    if (coma == 0)
                        setEdi(cursorPosition, 0);
                }
            }


        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");

                String div = edi.getText().toString();
                int cursorPosition =0;
                if (div.length() != 0) {

                    cout = 0;
                    textView.setText("");
                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "^" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition = cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "^" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;


                    }

                    if (coma == 0)
                        setEdi(cursorPosition, 0);
                }
            }
        });
        div2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                String div = edi.getText().toString();
                int cursorPosition =0;
                if (div.length() != 0) {

                    cout = 0;

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "%" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition = cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "%" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                    }

                    if (coma == 0)
                        setEdi(cursorPosition, 0);
                }

            }
        });
        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cout = 0;
                textView.setText("");




                if (!edi.getText().toString().equals("")) {
                    {
                        String s=edi.getText().toString();
                        if (edi.length() > 0&&edi.getSelectionStart()>0) {
                            CharSequence enteredText=edi.getText().toString();
                            CharSequence cursorToEnd="";
                            CharSequence cursorToEnd2="";

                            if(edi.getSelectionStart() >= 1&&s.length()>2&&s.charAt(edi.getSelectionStart()-1)=='c'||s.charAt(edi.getSelectionStart()-1)=='g'||s.charAt(edi.getSelectionStart()-1)=='t') {
                                if (edi.getSelectionStart() >= 3) {
                                    cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart() - 3);
                                    cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                                }
                            }
                            else if(edi.getSelectionStart() >= 2&&s.length()>1&&(s.charAt(edi.getSelectionStart()-1)=='n'&&s.charAt(edi.getSelectionStart()-2)=='e')) {
                                if (edi.getSelectionStart() >= 6) {
                                    cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart() - 6);
                                    cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                                }
                            }
                            else if(edi.getSelectionStart() >= 2&&s.length()>1&&(s.charAt(edi.getSelectionStart()-1)=='n'&&s.charAt(edi.getSelectionStart()-2)=='l')) {
                                if (edi.getSelectionStart() >= 2) {
                                    cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart() - 2);
                                    cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart() , enteredText.length());

                                }}
                            else if(edi.getSelectionStart() >= 1&&s.length()>2&&s.charAt(edi.getSelectionStart()-1)=='s'||s.charAt(edi.getSelectionStart()-1)=='n') {
                                if (edi.getSelectionStart() >= 4&&s.length() > 3 && s.charAt(edi.getSelectionStart() - 4) == 'a'){
                                    cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart() - 4);
                                    cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                                }
                                else if (edi.getSelectionStart() >= 3){
                                    cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart() - 3);
                                    cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                                }

                            }


                            else    if (edi.getSelectionStart() >= 1) {
                                cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart() - 1);
                                cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                            }




                            edi.setText(cursorToEnd + "" + cursorToEnd2);
                           // edi.setSelection(cursorToEnd.length());


                         //   Toast.makeText(getBaseContext(),""+cursorToEnd.length()+"  "+cursorToEnd + "" + cursorToEnd2, Toast.LENGTH_SHORT).show();
if(coma==0)
                             setEdi(cursorToEnd.length(),-1);
else {edi.setSelection(cursorToEnd.length());

}



                        }

                    }

                }
            }
        });
        rach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");int cursorPosition =0;
                String div = edi.getText().toString();

                if (edi.getText().toString().equals("")||edi.getSelectionStart()==0) {
                    {
                        textView.setText("");
                        edi.setText("("+edi.getText());
                        edi.setSelection(1);
                        cursorPosition=1;
                    }
                } else {
                    char s = edi.getText().toString().charAt(edi.getSelectionStart() - 1);
                    if (s > 47 && s < 58 || s == ')' || s == '%' || s == '!') {
                        textView.setText("");
                        CharSequence enteredText = edi.getText().toString();
                        CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                        CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                        if (div.length() == edi.getSelectionStart() - 1) {
                            edi.setText(cursorToEnd + ")" + cursorToEnd2);
                            edi.setSelection(cursorToEnd.length());
                            cursorPosition=cursorToEnd.length();

                        } else {
                            edi.setText(cursorToEnd + ")" + cursorToEnd2);
                            edi.setSelection(cursorToEnd.length() + 1);
                            cursorPosition=cursorToEnd.length()+1;

                        }
                    }

                    else {
                        textView.setText("");
                        CharSequence enteredText = edi.getText().toString();
                        CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                        CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                        if (div.length() == edi.getSelectionStart() - 1) {
                            edi.setText(cursorToEnd + "(" + cursorToEnd2);
                            edi.setSelection(cursorToEnd.length());
                            cursorPosition=cursorToEnd.length();

                        } else {
                            edi.setText(cursorToEnd + "(" + cursorToEnd2);
                            edi.setSelection(cursorToEnd.length() + 1);
                            cursorPosition=cursorToEnd.length()+1;

                        }

                    }





                }

                if (coma == 0&&cursorPosition!=1)
                    setEdi(cursorPosition, 0);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cout = 0;
                edi.setText("");
                le = 0;
                ri = 0;

            }
        });





        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                String div = edi.getText().toString();
                int cursorPosition =0;
                if (div.length() != 0) {

                    cout = 0;

                    CharSequence enteredText = edi.getText().toString();
                    CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                    CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());
                    if (div.length() == edi.getSelectionStart() - 1) {
                        edi.setText(cursorToEnd + "." + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length());
                        cursorPosition = cursorToEnd.length();

                    } else {
                        edi.setText(cursorToEnd + "." + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;


                    }

                    if (coma == 0)
                        setEdi(cursorPosition, 0);
                }}
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cout++;
                r1="";
                r2="";
                String s = edi.getText().toString();
                String sq="";
                for(int i=0; i<s.length();i++)
                {
                    if(s.charAt(i)!=',')
                        sq+=s.charAt(i);

                }
                s=sq;

                if (edi.getText().toString().equals(""))
                    Toast.makeText(getBaseContext(), "Text Empty", Toast.LENGTH_SHORT).show();
                else {

                    int x=0,y=0;
                    for(int i=0;i<s.length();i++)
                        if(s.charAt(i)=='(')
                            x++;
                        else if(s.charAt(i)==')')
                            y++;


                    if(x!=y)
                        Toast.makeText(getBaseContext(), "There is a arc minus", Toast.LENGTH_SHORT).show();

                    else {
                        ar.clear();
                        ar.add( s);
 eq2=s;
                        // Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();

                        int errore=0;

                        if(s.length()>=1&&!((s.charAt(0)>=(int)'0'&&s.charAt(0)<=(int)'9')||(s.charAt(0) > 96 && s.charAt(0) < (int) 'z')||s.charAt(0)=='('||s.charAt(0)=='-'||s.charAt(0)=='.'||s.charAt(0)=='√')) {
                            errore++;
                            //Toast.makeText(getBaseContext(), "1", Toast.LENGTH_SHORT).show();
                        }
                        for(int i=1;i<s.length();i++) {
                            if (s.charAt(i - 1) > 96 && s.charAt(i - 1) < (int) 'z' && (s.charAt(i) == '!' ||s.charAt(i) == '.' ||s.charAt(i) == '+'  || s.charAt(i) == '%' || s.charAt(i) == '^' || s.charAt(i) == '+' || s.charAt(i) == '×' || s.charAt(i) == '÷')) {
                                errore++;
                                // Toast.makeText(getBaseContext(), "2", Toast.LENGTH_SHORT).show();
                            }
                            if (((s.charAt(i - 1) == '(' || s.charAt(i-1) == '×' || s.charAt(i - 1) == '.' || s.charAt(i - 1) == '-'  || s.charAt(i - 1) == '^'  || s.charAt(i - 1) == '÷') && (s.charAt(i) == '+'|| s.charAt(i) == '%' || s.charAt(i) == '^' || s.charAt(i) == '×' || s.charAt(i) == '÷')) || ((  s.charAt(i) == '+' || s.charAt(i ) == '.' || s.charAt(i) == '-'  || s.charAt(i) == '^' || s.charAt(i) == '×' || s.charAt(i) == '÷') && s.length() - 1 == i)) {
                                errore++;//Toast.makeText(getBaseContext(), "3", Toast.LENGTH_SHORT).show();
                            }
                            if (s.charAt(i - 1) == ')' && ((s.charAt(i) > 96 && s.charAt(i) < (int) 'z') || (s.charAt(i) >= (int) '0' && s.charAt(i) <= (int) '9')  || s.charAt(i) == '.')) {
                                errore++;
                                // Toast.makeText(getBaseContext(), "4", Toast.LENGTH_SHORT).show();
                            }
                            if(s.charAt(i-1)=='!'&&s.charAt(i)=='!') {
                                // Toast.makeText(getBaseContext(), "5", Toast.LENGTH_SHORT).show();
                                errore++;}
                            if((s.charAt(i - 1) == '.' ||s.charAt(i-1)=='+')&&s.charAt(i)=='-') {
                                // Toast.makeText(getBaseContext(), "5", Toast.LENGTH_SHORT).show();
                                errore++;
                            }
                            if(s.charAt(i-1)=='%'&&(s.charAt(i)>=(int)'0'&&s.charAt(i)<=(int)'9')) {
                                errore++;

                            }}
                        s = math.divre(s);


                        if(errore==0) {
                            String erroryorn = math.patt(s);
                             // Toast.makeText(getBaseContext(), erroryorn+"deaa", Toast.LENGTH_LONG).show();

                            if(erroryorn.equals("Erorr"))
                                Toast.makeText(MainActivity.this, "Wrong Mathematical expression", Toast.LENGTH_SHORT).show();
                            else{
                                if(!erroryorn.contains("+")&&!erroryorn.contains("-")&&!erroryorn.contains("×")&&!erroryorn.contains("÷")&&!erroryorn.contains("^")&&!erroryorn.contains("%"))
                                {erroryorn=math.power(erroryorn);

                                    if(erroryorn.equals("Erorr"))
                                        Toast.makeText(MainActivity.this, "Wrong Mathematical expression", Toast.LENGTH_SHORT).show();
                                    else {


                                        if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(erroryorn) && !erroryorn.equals("Erorr")) {


                                           // Toast.makeText(MainActivity.this, ar.get(ar.size() - 1).substring(2, ar.get(ar.size() - 1).length()) + "", Toast.LENGTH_SHORT).show();

                                            ar.add(erroryorn);

                                        }

                                        String e3=MainActivity.ar.get(ar.size()-1);
                                        String er="";int inE=0;
                                        int dec=-1,d=decimal;
                                        for(int i=0;i<e3.length();i++) {
                                            if(dec<d) {
                                                if(dec>=0)
                                                    dec++;
                                                if(e3.charAt(i)=='.') {
                                                    er+=e3.charAt(i);
                                                    dec++;
                                                }
                                                else if(e3.charAt(i)!='E') {
                                                    er+=e3.charAt(i);
                                                }
                                            }
                                            if
                                            (e3.charAt(i)=='E') {
                                                inE=i;
                                                break;


                                            }

                                        }
                                        if(inE!=0) {
                                            er+=e3.substring(inE,e3.length());
                                        }
if (coma==0)
                                        er= setEdi2(er);
                                        textView.setText(er + "");
                                        acsessdatalist acsessdatalist=new acsessdatalist(MainActivity.this);

                                        acsessdatalist.open();
                                        acsessdatalist.insertData(eq2,er);
                                        acsessdatalist.close();
                                        if(!textView.getText().toString().equals("")) {
                                            Edit.putString("k",textView.getText().toString());
                                            Edit.apply();}











                                    }                       }
                                else
                                {
                                    String  r1="",r2="",r3="",r0="";
                                    int der=0;
                                    int fin=0;
                                    String ss=erroryorn;
                                    String w=ss;

                                    if(ss.contains("%^")){


                                        String dd=math.problem(ss);
                                        if(dd.equals("Erorr"))
                                            der++;
                                        else
                                        { w=w.replace(ss,dd);
                                            MainActivity.ar.add(w);

                                            ss=dd;}
                                        // Toast.makeText(getBaseContext(),dd+" power ", Toast.LENGTH_SHORT).show();
                                    }




                                    if(ss.contains("^")){
                                        r1=math.power(ss);
                                        fin++;
                                       // Toast.makeText(getBaseContext(), r1+" power ", Toast.LENGTH_SHORT).show();
                                        if(r1.equals("Erorr"))
                                            der++;

                                    }
                                    if(!r1.equals("")&&(r1.contains("×")|| r1.contains("÷")))
                                    {r2=math.mut_div(r1);fin++;
                                        //Toast.makeText(getBaseContext(), r2+" ml ", Toast.LENGTH_SHORT).show();
                                        if(r2.equals("Erorr"))
                                            der++;


                                    }
                                    else if(r1.equals("")&&(ss.contains("×")||ss.contains("÷")))
                                    {r2=math.mut_div(ss);fin++;
                                         //Toast.makeText(getBaseContext(), r2+" m1 ", Toast.LENGTH_SHORT).show();
                                        if(r2.equals("Erorr"))
                                            der++;

                                    }
                                    if(!r2.equals("")&&(r2.contains("+")||r2.contains("-")))
                                    { r3=math.min_plus(r2);fin++;
                                        //Toast.makeText(getBaseContext(), r3+" pm ", Toast.LENGTH_SHORT).show();
                                        if(r3.equals("Erorr"))
                                            der++;

                                    }
                                    else  if(!r1.equals("")&&(r1.contains("+")||r1.contains("-")))
                                    {  r3=math.min_plus(r1);fin++;
                                     //   Toast.makeText(getBaseContext(), r3+" pm ", Toast.LENGTH_SHORT).show();
                                        if(r3.equals("Erorr"))
                                            der++;

                                    }
                                    else if(r1.equals("")&&r2.equals("")&&(ss.contains("+")||ss.contains("-")))
                                    {  r3=math.min_plus(ss);fin++;
                                        //Toast.makeText(getBaseContext(), r3+" pm ", Toast.LENGTH_SHORT).show();
                                        if(r3.equals("Erorr"))
                                            der++;

                                    }

                                    if(fin==0){

                                        r0=math.power(ss);
                                        if(r0.equals("Erorr"))
                                            der++;

                                        //w=w.replace(ss,r0);
                                        //MainnActivity.ar.add(++MainnActivity.rcc+" )"+w);

                                    }

                                    if(der==0) {
                                        if (!r1.equals("") && (!r2.equals("") || !r3.equals(""))) {
                                            int q = w.indexOf(ss);
                                            w = math.replace(w, q, q + ss.length(), r1);

                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainActivity.ar.add( w);
                                                ss = r1;

                                                //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                              //   Toast.makeText(getBaseContext(), w + " 1 " + r1, Toast.LENGTH_SHORT).show();
                                            }


                                        }else if (!r1.equals("") && !(!r2.equals("") || !r3.equals(""))) {

                                            int q = w.indexOf(ss);
                                            w = math.replace(w, q, q + ss.length(), r1);
                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainActivity.ar.add( w);

                                                //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                                // Toast.makeText(getBaseContext(), w + " 1 " + r1, Toast.LENGTH_SHORT).show();
                                            }
                                            //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                            //   Toast.makeText(getBaseContext(), w + " 2 " + r1, Toast.LENGTH_SHORT).show();
                                        }
                                        if (!r2.equals("") && (!r3.equals(""))) {

                                            int q = w.indexOf(ss);
                                            w = math.replace(w, q, q + ss.length(), r2);
                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainActivity.ar.add( w);
                                                ss = r2;
                                                //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                                // Toast.makeText(getBaseContext(), w + " 1 " + r1, Toast.LENGTH_SHORT).show();
                                            }

                                            // if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))

                                           // Toast.makeText(getBaseContext(), w + " 3 " + r2, Toast.LENGTH_SHORT).show();
                                        } else if (!r2.equals("") && r3.equals("")) {


                                            int q = w.indexOf(ss);
                                            w = math.replace(w, q, q + ss.length(), r2);
                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainActivity.ar.add( w);

                                                //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                                // Toast.makeText(getBaseContext(), w + " 1 " + r1, Toast.LENGTH_SHORT).show();
                                            }
                                            //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                           // Toast.makeText(getBaseContext(), w + " 4 " + r2, Toast.LENGTH_SHORT).show();
                                        }
                                        if (!r3.equals("")) {
                                            int q = w.indexOf(ss);
                                            w = math.replace(w, q, q + ss.length(), r3);


                                            //w = w.replaceFirst( , r3);
                                            // if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainActivity.ar.add( w);

                                            }
                                            // if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                            //Toast.makeText(getBaseContext(), w + " 5 " + r3, Toast.LENGTH_SHORT).show();
                                            //Toast.makeText(context, r+" 1 ", Toast.LENGTH_SHORT).show();
                                        }
                                        //Toast.makeText(getBaseContext(), erroryorn + "", Toast.LENGTH_LONG).show();

                                    }
                                    if (der!=0)
                                        Toast.makeText(MainActivity.this, "Wrong Mathematical expression", Toast.LENGTH_SHORT).show();
                                    else
                                    {
                                        String e3=MainActivity.ar.get(ar.size()-1);
                                        String er="";int inE=0;
                                        int dec=-1,d=decimal;
                                        for(int i=0;i<e3.length();i++) {
                                            if(dec<d) {
                                                if(dec>=0)
                                                    dec++;
                                                if(e3.charAt(i)=='.') {
                                                    er+=e3.charAt(i);
                                                    dec++;
                                                }
                                                else if(e3.charAt(i)!='E') {
                                                    er+=e3.charAt(i);
                                                }
                                            }
                                            if
                                            (e3.charAt(i)=='E') {
                                                inE=i;
                                                break;


                                            }

                                        }
                                        if(inE!=0) {
                                            er+=e3.substring(inE,e3.length());
                                        }



                                        if (coma==0)
                                            er= setEdi2(er);
                                        textView.setText(er + "");
                                        acsessdatalist acsessdatalist=new acsessdatalist(MainActivity.this);

                                        acsessdatalist.open();
                                        acsessdatalist.insertData(eq2,er);
                                        acsessdatalist.close();

                                        //showdilogesave(eq2+"="+er);
                                        if(!textView.getText().toString().equals("")) {
                                            Edit.putString("k",textView.getText().toString());
                                            Edit.apply();
                                            //Toast.makeText(MainActivity.this,div , Toast.LENGTH_SHORT).show();
                                        }
                                    }



                                }}}
                        else
                            Toast.makeText(MainActivity.this, "Wrong Mathematical expression", Toast.LENGTH_SHORT).show();


                    }}}

        });

        an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String div = textView.getText().toString();
                if(!div.equals("")) {
                    Edit.putString("k", div);
                    Edit.apply();
                    //Toast.makeText(MainActivity.this,div , Toast.LENGTH_SHORT).show();
                }
div=sp.getString("k",div);
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + div + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() +div.length());


            }
        });

       steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),Main2Activity.class);
                intent.putStringArrayListExtra("send",ar);
                startActivity(intent);

            }
        });



        }

    public static String setEdi2(String er) {
        int q=0;int dot=0;
        String a=er,n="",sum="";
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





        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){


        int ite=item.getItemId();
        switch (ite){

            case R.id.his:
            { acsessdatalist acsessdatalist=new acsessdatalist(MainActivity.this);

                acsessdatalist.open();
                dia= acsessdatalist.select();
                acsessdatalist.close();

                BlankFragment blankFragment=new BlankFragment(MainActivity.this,dia);
                blankFragment.show(getSupportFragmentManager(),null);


            }
                break;
            case R.id.dec:{
                showdiloge();

            }
                break;
            case R.id.coma:{
                showdilogecoma();

            }
            break;
        }








            if(actionBarDrawerToggle.onOptionsItemSelected(item))
                return true;
                return  false;
            }
@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

    int id = menuItem.getItemId();
    switch (id) {
        case R.id.gpamenue: {
            Intent in = new Intent(this, Main3Activity.class);
            startActivity(in);
            return true;
        }
        case R.id.agemenu: {
            Intent in = new Intent(this, age.class);
            startActivity(in);
            return true;
        }
        case R.id.convertmenu: {
            Intent in = new Intent(this, convert.class);
            startActivity(in);
            return true;
        }
        case R.id.calmenu: {
            Intent in = new Intent(this,caloreis.class);
            startActivity(in);

            return true;
        }
        case R.id.bmimenu: {
            Intent in = new Intent(this, bmi.class);
            startActivity(in);
            return true;
        }
        case R.id.sccal: {
            Intent in = new Intent(this, MainnActivity.class);
            startActivity(in);
            return true;
        }
        case R.id.CUR: {
            Intent in = new Intent(this, MaincurActivity.class);
            startActivity(in);
            return true;
        }
     case R.id.Blue: {
            if (Build.VERSION.SDK_INT >= 21) {

                //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
               // getWindow().setNavigationBarColor(Color.parseColor("#03A9F4"));

                //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                getWindow().setStatusBarColor(Color.parseColor("#03A9F4"));
                div.setBackgroundColor(Color.parseColor("#03A9F4"));
                pl.setBackgroundColor(Color.parseColor("#03A9F4"));
                mul.setBackgroundColor(Color.parseColor("#03A9F4"));
                div2.setBackgroundColor(Color.parseColor("#03A9F4"));
                c.setBackgroundColor(Color.parseColor("#03A9F4"));
                rach.setBackgroundColor(Color.parseColor("#03A9F4"));
                min.setBackgroundColor(Color.parseColor("#03A9F4"));
                       /* sec.setBackgroundColor(Color.parseColor("#03A9F4"));
                        tan.setBackgroundColor(Color.parseColor("#03A9F4"));
                        cos.setBackgroundColor(Color.parseColor("#03A9F4"));
                        sin.setBackgroundColor(Color.parseColor("#03A9F4"));*/
                Theme = 1;
            }
        }
        break;
        case R.id.Lemon: {
            if (Build.VERSION.SDK_INT >= 21) {

                //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
//                getWindow().setNavigationBarColor(Color.parseColor("#CDDC39"));

                //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                getWindow().setStatusBarColor(Color.parseColor("#CDDC39"));
                div.setBackgroundColor(Color.parseColor("#CDDC39"));
                pl.setBackgroundColor(Color.parseColor("#CDDC39"));
                mul.setBackgroundColor(Color.parseColor("#CDDC39"));
                div2.setBackgroundColor(Color.parseColor("#CDDC39"));
                c.setBackgroundColor(Color.parseColor("#CDDC39"));
                rach.setBackgroundColor(Color.parseColor("#CDDC39"));
                min.setBackgroundColor(Color.parseColor("#CDDC39"));
                       /* sec.setBackgroundColor(Color.parseColor("#03A9F4"));
                        tan.setBackgroundColor(Color.parseColor("#03A9F4"));
                        cos.setBackgroundColor(Color.parseColor("#03A9F4"));
                        sin.setBackgroundColor(Color.parseColor("#03A9F4"));*/
                Theme = 2;


            }
        }
        break;
        case R.id.purple: {
            if (Build.VERSION.SDK_INT >= 21) {

                //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
                //getWindow().setNavigationBarColor(Color.parseColor("#03A9F4"));

                //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                getWindow().setStatusBarColor(Color.parseColor("#9C27B0"));
                div.setBackgroundColor(Color.parseColor("#9C27B0"));
                pl.setBackgroundColor(Color.parseColor("#9C27B0"));
                mul.setBackgroundColor(Color.parseColor("#9C27B0"));
                div2.setBackgroundColor(Color.parseColor("#9C27B0"));
                c.setBackgroundColor(Color.parseColor("#9C27B0"));
                rach.setBackgroundColor(Color.parseColor("#9C27B0"));
                min.setBackgroundColor(Color.parseColor("#9C27B0"));
                       /* sec.setBackgroundColor(Color.parseColor("#03A9F4"));
                        tan.setBackgroundColor(Color.parseColor("#03A9F4"));
                        cos.setBackgroundColor(Color.parseColor("#03A9F4"));
                        sin.setBackgroundColor(Color.parseColor("#03A9F4"));*/
                Theme = 3;


            }
        }
        break;
        case R.id.Pink: {
            if (Build.VERSION.SDK_INT >= 21) {

                //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
             //   getWindow().setNavigationBarColor(Color.parseColor("#E91E63"));

                //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                getWindow().setStatusBarColor(Color.parseColor("#E91E63"));
                div.setBackgroundColor(Color.parseColor("#E91E63"));
                pl.setBackgroundColor(Color.parseColor("#E91E63"));
                mul.setBackgroundColor(Color.parseColor("#E91E63"));
                div2.setBackgroundColor(Color.parseColor("#E91E63"));
                c.setBackgroundColor(Color.parseColor("#E91E63"));
                rach.setBackgroundColor(Color.parseColor("#E91E63"));
                min.setBackgroundColor(Color.parseColor("#E91E63"));
                       /* sec.setBackgroundColor(Color.parseColor("#03A9F4"));
                        tan.setBackgroundColor(Color.parseColor("#03A9F4"));
                        cos.setBackgroundColor(Color.parseColor("#03A9F4"));
                        sin.setBackgroundColor(Color.parseColor("#03A9F4"));*/
                Theme = 4;


            }
        }
        break;
        case R.id.Green: {
            if (Build.VERSION.SDK_INT >= 21) {

                //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
               // getWindow().setNavigationBarColor(Color.parseColor("#4CAF50"));

                //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                getWindow().setStatusBarColor(Color.parseColor("#4CAF50"));
                div.setBackgroundColor(Color.parseColor("#4CAF50"));
                pl.setBackgroundColor(Color.parseColor("#4CAF50"));
                mul.setBackgroundColor(Color.parseColor("#4CAF50"));
                div2.setBackgroundColor(Color.parseColor("#4CAF50"));
                c.setBackgroundColor(Color.parseColor("#4CAF50"));
                rach.setBackgroundColor(Color.parseColor("#4CAF50"));
                min.setBackgroundColor(Color.parseColor("#4CAF50"));
                       /* sec.setBackgroundColor(Color.parseColor("#03A9F4"));
                        tan.setBackgroundColor(Color.parseColor("#03A9F4"));
                        cos.setBackgroundColor(Color.parseColor("#03A9F4"));
                        sin.setBackgroundColor(Color.parseColor("#03A9F4"));*/
                Theme = 5;


            }
        }
        break;
        case R.id.LightGreen: {
            if (Build.VERSION.SDK_INT >= 21) {

                //getWindow().setNavigationBarDividerColor(Color.parseColor("#03A9F4"));
                //getWindow().setNavigationBarColor(Color.parseColor("#8BC34A"));

                //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                getWindow().setStatusBarColor(Color.parseColor("#8BC34A"));
                div.setBackgroundColor(Color.parseColor("#8BC34A"));
                pl.setBackgroundColor(Color.parseColor("#8BC34A"));
                mul.setBackgroundColor(Color.parseColor("#8BC34A"));
                div2.setBackgroundColor(Color.parseColor("#8BC34A"));
                c.setBackgroundColor(Color.parseColor("#8BC34A"));
                rach.setBackgroundColor(Color.parseColor("#8BC34A"));
                min.setBackgroundColor(Color.parseColor("#8BC34A"));
                       /* sec.setBackgroundColor(Color.parseColor("#03A9F4"));
                        tan.setBackgroundColor(Color.parseColor("#03A9F4"));
                        cos.setBackgroundColor(Color.parseColor("#03A9F4"));
                        sin.setBackgroundColor(Color.parseColor("#03A9F4"));*/
                Theme = 6;


            }


        }
        break;
        case R.id.deep: {
            if (Build.VERSION.SDK_INT >= 21) {

                //getWindow().setNavigationBarColor(Color.parseColor("#03A9F4"));
                //getWindow().setNavigationBarColor(Color.parseColor("#673AB7"));

                //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                getWindow().setStatusBarColor(Color.parseColor("#673AB7"));
                div.setBackgroundColor(Color.parseColor("#673AB7"));
                pl.setBackgroundColor(Color.parseColor("#673AB7"));
                mul.setBackgroundColor(Color.parseColor("#673AB7"));
                div2.setBackgroundColor(Color.parseColor("#673AB7"));
                c.setBackgroundColor(Color.parseColor("#673AB7"));
                rach.setBackgroundColor(Color.parseColor("#673AB7"));
                min.setBackgroundColor(Color.parseColor("#673AB7"));
                       /* sec.setBackgroundColor(Color.parseColor("#03A9F4"));
                        tan.setBackgroundColor(Color.parseColor("#03A9F4"));
                        cos.setBackgroundColor(Color.parseColor("#03A9F4"));
                        sin.setBackgroundColor(Color.parseColor("#03A9F4"));*/
                Theme = 7;


            }
        }
        break;
        case R.id.black: {
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().setStatusBarColor(Color.parseColor("#000000"));
                c.setBackgroundColor(Color.parseColor("#000000"));
                div.setBackgroundColor(Color.parseColor("#000000"));
                pl.setBackgroundColor(Color.parseColor("#000000"));
                mul.setBackgroundColor(Color.parseColor("#000000"));
                div2.setBackgroundColor(Color.parseColor("#000000"));

                rach.setBackgroundColor(Color.parseColor("#000000"));
                min.setBackgroundColor(Color.parseColor("#000000"));

               /*     getWindow().setNavigationBarColor(Color.parseColor("#000"));

                //toolbar.setBackgroundColor(Color.parseColor("#03A9F4"));
                       /* sec.setBackgroundColor(Color.parseColor("#03A9F4"));
                        tan.setBackgroundColor(Color.parseColor("#03A9F4"));
                        cos.setBackgroundColor(Color.parseColor("#03A9F4"));
                        sin.setBackgroundColor(Color.parseColor("#03A9F4"));*/
                Theme = 8;


            }

        }


    }
    return false;
}
    private static String comma(String n) {
        // TODO Auto-generated method stub
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








public void setEdi(int  cursorPosition,int asd){




    int q=0;int dot=0;
    String a=edi.getText().toString(),n="",sum="";
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

    edi.setText(sum);
    if(asd==2){
        edi.setSelection(edi.getText().toString().length());

    }
if(asd==-1) {


    if (sum.length() < co) {
        if (cursorPosition > 0)
            edi.setSelection(cursorPosition - 1);

    }
    if (sum.length() == co) {

        edi.setSelection(cursorPosition);

    }
    if (sum.length() > co) {
        if (cursorPosition > 0)
            edi.setSelection(cursorPosition +1);

    }
}

else if(asd==0)
{



     if (sum.length() > co) {
           edi.setSelection(cursorPosition + 1);

    }
    if (sum.length() == co) {
        edi.setSelection(cursorPosition);

    }
    if(co>sum.length()){


        edi.setSelection(cursorPosition-1);
    }


}



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ac, menu);
    return true;
    }


    private void   showdilogecoma() {
        TextView t=new TextView(this);
        t.setText("Decimal Places");
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("comma");
        String [] a=new String []{"with comma","without comma"};
        alertDialog.setSingleChoiceItems(a, sp.getInt("coma",0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
coma=i;
                Edit.putInt("coma", coma);
                Edit.apply();
            if(i==0){
                setEdi(edi.getSelectionStart(),2);

            }
            else if(i==1){
                String sq="";
                for(int i1=0; i1<edi.getText().toString().length();i1++)
                {
                    if(edi.getText().toString().charAt(i1)!=',')
                        sq+=edi.getText().toString().charAt(i1);

                }
                edi.setText(sq);
edi.setSelection(sq.length());
            }
            }
        });
        alertDialog.create().show();

    }


    private void   showdiloge() {
        TextView t=new TextView(this);
        t.setText("Decimal Places");


        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("decimal places");
        String [] a=new String []{"1","2","3","4","5","6","7","8","9","10","11","12"};
        alertDialog.setSingleChoiceItems(a, sp.getInt("dec",6)-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                decimal =i+1;
                Edit.putInt("dec", decimal);
                Edit.apply();
            }
        });
        alertDialog.create().show();

    }
    static public void  text(String ed){
        edi.setText(ed);
        edi.setSelection(ed.length());
        textView.setText("");

    }
}

