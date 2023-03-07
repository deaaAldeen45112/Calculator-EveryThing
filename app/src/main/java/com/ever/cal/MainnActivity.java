package com.ever.cal;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import com.ever.cal.savelist;

import java.util.ArrayList;

public class MainnActivity extends AppCompatActivity  {
    Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, pl, div, root, div2, pow, min, mul, an, eq, dot, c,  rach, steps,ln, fac, abs, sin, cos, tan, asin, acos, atan, log, logten, exp, pi, sec, csc, cot;
    ImageButton cd;
    static Button toggleButton;
    static EditText edi;
    TextView textView;
    int cout = 0;
    // Expression expression;
    int le = 0;
    int coma=0;

    int decimal=10;
    String eq2="";
    int ri = 0;
    boolean i;
    int g = 1;
    ArrayList<savelist> dia=new ArrayList<>();
    SharedPreferences sp;
    SharedPreferences.Editor Edit;


    String r1, r2;

    static ArrayList<String> ar = new ArrayList<String>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch(MainActivity.Theme){

            case 1:
                setTheme(R.style.AppTheme_NoActionBar2);
                break;
            case 2:
                setTheme(R.style.AppTheme_NoActionBar3);
                break;
            case 3:
                setTheme(R.style.AppTheme_NoActionBar4);
                break;
            case 4:
                setTheme(R.style.AppTheme_NoActionBar5);
                break;
            case 5:
                setTheme(R.style.AppTheme_NoActionBar6);
                break;
            case 6:
                setTheme(R.style.AppTheme_NoActionBar7);
                break;
            case 7:
                setTheme(R.style.AppTheme_NoActionBar1);
                break;
            case 8:
                setTheme(R.style.AppTheme_NoActionBarb);
                break;

        }

        setContentView(R.layout.activity_mainn);
        toolbar = findViewById(R.id.scien);
        setSupportActionBar(toolbar);

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
        root = findViewById(R.id.root);
        div = findViewById(R.id.div);
        div2 = findViewById(R.id.div2);
        mul = findViewById(R.id.multi);
        min = findViewById(R.id.min);
        an = findViewById(R.id.an);
        eq = findViewById(R.id.eq);
        dot = findViewById(R.id.dot);
        c = findViewById(R.id.c);
        cd=findViewById(R.id.re);
        rach = findViewById(R.id.pat);
        toggleButton = findViewById(R.id.deaasld);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        atan = findViewById(R.id.atan);
        pow= findViewById(R.id.pow);
        acos = findViewById(R.id.acos);
        asin = findViewById(R.id.asin);
        exp = findViewById(R.id.e);
        abs = findViewById(R.id.abs);
        sec = findViewById(R.id.sec);
        csc = findViewById(R.id.csc);
        log = findViewById(R.id.log);
        logten = findViewById(R.id.logten);
        cot = findViewById(R.id.cot);
        pi = findViewById(R.id.pi);
        ln=findViewById(R.id.ln);
        fac=findViewById(R.id.fac);
        abs=findViewById(R.id.abs);
        sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Edit=sp.edit();
        decimal=sp.getInt("dec2",5);
        coma=sp.getInt("coma2",0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            edi.setShowSoftInputOnFocus(false);
        }


        textView.setMovementMethod(new ScrollingMovementMethod());
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "1" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "2" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "3" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "4" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "5" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "6" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "7" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "8" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "9" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "0" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length()+1);
                        cursorPosition=cursorToEnd.length()+1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "+" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "×" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "-" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "÷" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "^" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                        sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "%" + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                        sizetext();
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


                                if(coma==0)
                                setEdi(cursorToEnd.length(),-1);
                            else {edi.setSelection(cursorToEnd.length());

                            }


                            sizetext();
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
                            sizetext();
                        } else {
                            edi.setText(cursorToEnd + ")" + cursorToEnd2);
                            edi.setSelection(cursorToEnd.length() + 1);
                            cursorPosition=cursorToEnd.length()+1;
                            sizetext();
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
                            sizetext();
                        } else {
                            edi.setText(cursorToEnd + "(" + cursorToEnd2);
                            edi.setSelection(cursorToEnd.length() + 1);
                            cursorPosition=cursorToEnd.length()+1;
                            sizetext();
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
                        sizetext();
                    } else {
                        edi.setText(cursorToEnd + "." + cursorToEnd2);
                        edi.setSelection(cursorToEnd.length() + 1);
                        cursorPosition = cursorToEnd.length() + 1;

                        sizetext();
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
               s= mathsc.pi(s);
               s=mathsc.exp(s);
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
                        s = mathsc.divre(s);


                        if(errore==0) {
                            String erroryorn = mathsc.patt(s,getBaseContext());
                            // Toast.makeText(getBaseContext(), erroryorn+"deaa", Toast.LENGTH_LONG).show();

                            if(erroryorn.equals("Erorr"))
                                Toast.makeText(MainnActivity.this, "Wrong Mathematical expression", Toast.LENGTH_SHORT).show();
                            else{
                                if(!erroryorn.contains("+")&&!erroryorn.contains("-")&&!erroryorn.contains("×")&&!erroryorn.contains("÷")&&!erroryorn.contains("^")&&!erroryorn.contains("%"))
                                {erroryorn=mathsc.power(erroryorn);

                                    if(erroryorn.equals("Erorr"))
                                        Toast.makeText(MainnActivity.this, "Wrong Mathematical expression", Toast.LENGTH_SHORT).show();
                                    else {


                                        if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(erroryorn) && !erroryorn.equals("Erorr")) {


                                            // Toast.makeText(MainActivity.this, ar.get(ar.size() - 1).substring(2, ar.get(ar.size() - 1).length()) + "", Toast.LENGTH_SHORT).show();

                                            ar.add(erroryorn);

                                        }

                                        String e3=MainnActivity.ar.get(ar.size()-1);
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
                                        acsessdatalist acsessdatalist=new acsessdatalist(MainnActivity.this);

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


                                        String dd=mathsc.problem(ss);
                                        if(dd.equals("Erorr"))
                                            der++;
                                        else
                                        { w=w.replace(ss,dd);
                                            MainnActivity.ar.add(w);

                                            ss=dd;}
                                        // Toast.makeText(getBaseContext(),dd+" power ", Toast.LENGTH_SHORT).show();
                                    }




                                    if(ss.contains("^")){
                                        r1=mathsc.power(ss);
                                        fin++;
                                        // Toast.makeText(getBaseContext(), r1+" power ", Toast.LENGTH_SHORT).show();
                                        if(r1.equals("Erorr"))
                                            der++;

                                    }
                                    if(!r1.equals("")&&(r1.contains("×")|| r1.contains("÷")))
                                    {r2=mathsc.mut_div(r1);fin++;
                                        //Toast.makeText(getBaseContext(), r2+" ml ", Toast.LENGTH_SHORT).show();
                                        if(r2.equals("Erorr"))
                                            der++;


                                    }
                                    else if(r1.equals("")&&(ss.contains("×")||ss.contains("÷")))
                                    {r2=mathsc.mut_div(ss);fin++;
                                        //Toast.makeText(getBaseContext(), r2+" m1 ", Toast.LENGTH_SHORT).show();
                                        if(r2.equals("Erorr"))
                                            der++;

                                    }
                                    if(!r2.equals("")&&(r2.contains("+")||r2.contains("-")))
                                    { r3=mathsc.min_plus(r2);fin++;
                                        //Toast.makeText(getBaseContext(), r3+" pm ", Toast.LENGTH_SHORT).show();
                                        if(r3.equals("Erorr"))
                                            der++;

                                    }
                                    else  if(!r1.equals("")&&(r1.contains("+")||r1.contains("-")))
                                    {  r3=mathsc.min_plus(r1);fin++;
                                        //   Toast.makeText(getBaseContext(), r3+" pm ", Toast.LENGTH_SHORT).show();
                                        if(r3.equals("Erorr"))
                                            der++;

                                    }
                                    else if(r1.equals("")&&r2.equals("")&&(ss.contains("+")||ss.contains("-")))
                                    {  r3=mathsc.min_plus(ss);fin++;
                                        //Toast.makeText(getBaseContext(), r3+" pm ", Toast.LENGTH_SHORT).show();
                                        if(r3.equals("Erorr"))
                                            der++;

                                    }

                                    if(fin==0){

                                        r0=mathsc.power(ss);
                                        if(r0.equals("Erorr"))
                                            der++;

                                        //w=w.replace(ss,r0);
                                        //MainnActivity.ar.add(++MainnActivity.rcc+" )"+w);

                                    }

                                    if(der==0) {
                                        if (!r1.equals("") && (!r2.equals("") || !r3.equals(""))) {
                                            int q = w.indexOf(ss);
                                            w = mathsc.replace(w, q, q + ss.length(), r1);

                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainnActivity.ar.add( w);
                                                ss = r1;

                                                //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                                //   Toast.makeText(getBaseContext(), w + " 1 " + r1, Toast.LENGTH_SHORT).show();
                                            }


                                        }else if (!r1.equals("") && !(!r2.equals("") || !r3.equals(""))) {

                                            int q = w.indexOf(ss);
                                            w = mathsc.replace(w, q, q + ss.length(), r1);
                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainnActivity.ar.add( w);

                                                //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                                // Toast.makeText(getBaseContext(), w + " 1 " + r1, Toast.LENGTH_SHORT).show();
                                            }
                                            //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                            //   Toast.makeText(getBaseContext(), w + " 2 " + r1, Toast.LENGTH_SHORT).show();
                                        }
                                        if (!r2.equals("") && (!r3.equals(""))) {

                                            int q = w.indexOf(ss);
                                            w = mathsc.replace(w, q, q + ss.length(), r2);
                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainnActivity.ar.add( w);
                                                ss = r2;
                                                //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                                // Toast.makeText(getBaseContext(), w + " 1 " + r1, Toast.LENGTH_SHORT).show();
                                            }

                                            // if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))

                                            // Toast.makeText(getBaseContext(), w + " 3 " + r2, Toast.LENGTH_SHORT).show();
                                        } else if (!r2.equals("") && r3.equals("")) {


                                            int q = w.indexOf(ss);
                                            w = mathsc.replace(w, q, q + ss.length(), r2);
                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainnActivity.ar.add( w);

                                                //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                                // Toast.makeText(getBaseContext(), w + " 1 " + r1, Toast.LENGTH_SHORT).show();
                                            }
                                            //if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                            // Toast.makeText(getBaseContext(), w + " 4 " + r2, Toast.LENGTH_SHORT).show();
                                        }
                                        if (!r3.equals("")) {
                                            int q = w.indexOf(ss);
                                            w = mathsc.replace(w, q, q + ss.length(), r3);


                                            //w = w.replaceFirst( , r3);
                                            // if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                            if (ar.size() > 0 && !ar.get(ar.size() - 1).equals(w) && !erroryorn.equals("Erorr")) {

                                                MainnActivity.ar.add( w);

                                            }
                                            // if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                                            //Toast.makeText(getBaseContext(), w + " 5 " + r3, Toast.LENGTH_SHORT).show();
                                            //Toast.makeText(context, r+" 1 ", Toast.LENGTH_SHORT).show();
                                        }
                                        //Toast.makeText(getBaseContext(), erroryorn + "", Toast.LENGTH_LONG).show();

                                    }
                                    if (der!=0)
                                        Toast.makeText(MainnActivity.this, "Wrong Mathematical expression", Toast.LENGTH_SHORT).show();
                                    else
                                    {
                                        String e3=MainnActivity.ar.get(ar.size()-1);
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
                                        acsessdatalist acsessdatalist=new acsessdatalist(MainnActivity.this);

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
                            Toast.makeText(MainnActivity.this, "Wrong Mathematical expression", Toast.LENGTH_SHORT).show();
                        sizetext();
                    }}}

        });



        logten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "logten" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 6);
                cursorPosition=cursorToEnd.length()+6;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();


            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                int cursorPosition = 0;
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "log" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 3);
                cursorPosition=cursorToEnd.length()+3;
                if(coma==0)
                setEdi(cursorPosition,0);
                sizetextl();
            }
        });


        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "cos" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 3);
                cursorPosition=cursorToEnd.length()+3;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "tan" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 3);
                cursorPosition=cursorToEnd.length()+3;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });
        asin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "asin" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 4);
                cursorPosition=cursorToEnd.length()+4;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });

        acos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "acos" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 4);
                cursorPosition=cursorToEnd.length()+4;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });
        atan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "atan" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 4);
                cursorPosition=cursorToEnd.length()+4;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });
        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "abs" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 3);
                cursorPosition=cursorToEnd.length()+3;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });
        cot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "cot" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 3);
                cursorPosition=cursorToEnd.length()+3;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });
        csc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "csc" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 3);
                cursorPosition=cursorToEnd.length()+3;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "" + "π"+ cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 1);
                cursorPosition=cursorToEnd.length()+1;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();/*
                edi.setText(cursorToEnd + "" + Math.PI + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + String.valueOf(Math.PI).length());
                sizetextl();*/
            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "" +"e" + "" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 1);
                cursorPosition=cursorToEnd.length()+1;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });
        sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "sec" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 3);
                cursorPosition=cursorToEnd.length()+3;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();


            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "sin" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 3);
                cursorPosition=cursorToEnd.length()+3;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();


            }
        });


        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "ln" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 2);
                cursorPosition=cursorToEnd.length()+2;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();

            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                le++;
                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "√(" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 2);
                cursorPosition=cursorToEnd.length()+2;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();


            }
        });

        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + "!" + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() + 1);
                cursorPosition=cursorToEnd.length()+1;
                if(coma==0)
                    setEdi(cursorPosition,0);

                sizetextl();
            }
        });


        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.getText().toString().equals("DEG"))
                    toggleButton.setText("RAD");
                else
                    toggleButton.setText("DEG");

            }
        });


        an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String div = textView.getText().toString();
                if(!div.equals("")) {
                    Edit.putString("kk", div);
                    Edit.apply();
                   // Toast.makeText(MainnActivity.this,div , Toast.LENGTH_SHORT).show();
                }
                div=sp.getString("kk",div);
                int cursorPosition = edi.getSelectionStart();
                CharSequence enteredText = edi.getText().toString();
                CharSequence cursorToEnd = enteredText.subSequence(0, edi.getSelectionStart());
                CharSequence cursorToEnd2 = enteredText.subSequence(edi.getSelectionStart(), enteredText.length());

                edi.setText(cursorToEnd + div + cursorToEnd2);
                edi.setSelection(cursorToEnd.length() +div.length());
                sizetextl();


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

    private void sizetext () {

      /* if (edi.getText().toString().length() > 12)
            edi.setTextSize(32);
        if (edi.getText().toString().length() <= 12)
            edi.setTextSize(34);

*/
    }

    private void sizetextl () {

  /*      if (edi.getText().toString().length() > 12)
            edi.setTextSize(28);
        if (edi.getText().toString().length() <= 12)
            edi.setTextSize(32);

*/

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
        getMenuInflater().inflate(R.menu.ac2, menu);
        return true;
    }


    private void   showdilogecoma() {
        TextView t=new TextView(this);
        t.setText("Decimal Places");

       /* t.setBackgroundColor(Color.BLACK);
        t.setTextColor(Color.WHITE);
        t.setTextSize(TypedValue.COMPLEX_UNIT_DIP,42);
/*final float scale = getBaseContext().getResources().getDisplayMetrics().density;
int pi=(int )(getResources().getDimension(R.dimen.a)*scale+0.5f);
        Toast.makeText(this, ""+pi, Toast.LENGTH_SHORT).show();
*/
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("comma");
        String [] a=new String []{"with comma","without comma"};
        alertDialog.setSingleChoiceItems(a, sp.getInt("com2",0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                coma=i;
                Edit.putInt("com2", coma);
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
        alertDialog.setSingleChoiceItems(a, sp.getInt("dec2",6)-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                decimal =i+1;
                Edit.putInt("dec2", decimal);
                Edit.apply();
            }
        });
        alertDialog.create().show();

    }

    private String setEdi2(String er) {
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

            case R.id.his2:
                acsessdatalist acsessdatalist=new acsessdatalist(MainnActivity.this);

                acsessdatalist.open();
                dia= acsessdatalist.select();
                acsessdatalist.close();

                BlankFragment blankFragment=new BlankFragment(MainnActivity.this,dia);
                blankFragment.show(getSupportFragmentManager(),null);

            {

            }
            break;
            case R.id.dec2:{
                showdiloge();

            }
            break;
            case R.id.coma2:{
                showdilogecoma();

            }
            break;
        }
    return true;
    }




    }