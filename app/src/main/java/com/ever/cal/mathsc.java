package com.ever.cal;

import android.content.Context;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class mathsc {

static Context context;
    public static String patt(String s, Context context) {
       mathsc.context=context;
    try {


String r1="",r2="",r3="",r0="";
        String ss="",de="";
         int fin=0;
        Stack<Character> f=new Stack<>();
        Stack<Character>f2=new Stack<>();
        Stack<Character>f3=new Stack<>();
        String w=s;
        for(int i=0;i<s.length();i++) {
            f.add(s.charAt(i));
            if(s.charAt(i)==')')
            {

                do {


                    f2.add(f.peek());

                }while(f.pop()!='(');

                ss="";
                while(!f2.empty())
                {
                    if(f2.peek()!=')'&&f2.peek()!='(')
                        ss+=f2.pop();
                    else
                        f2.pop();

                }

                String fr="";
if(ss.contains("%^")){


    String dd=mathsc.problem(ss);
    w=w.replace(ss,dd);
    com.ever.cal.MainnActivity.ar.add(w);

    ss=dd;

}
                if(ss.contains("^")){
                r1=power(ss);
fin++;

                }
                if(!r1.equals("")&&(r1.contains("×")|| r1.contains("÷")))
                {r2=mut_div(r1);fin++;

                if(r2.equals("Erorr"))
                    return "Erorr";

                }
                else if(r1.equals("")&&(ss.contains("×")||ss.contains("÷")))
                {r2=mut_div(ss);fin++;

                if(r2.equals("Erorr"))
                    return "Erorr";

            }
                if(!r2.equals("")&&(r2.contains("+")||r2.contains("-")))
                { r3=min_plus(r2);fin++;

                if(r3.equals("Erorr"))
                    return "Erorr";

            }
                else  if(!r1.equals("")&&(r1.contains("+")||r1.contains("-")))
                {  r3=min_plus(r1);fin++;
                   if(r3.equals("Erorr"))
                    return "Erorr";

            }
                else if(r1.equals("")&&r2.equals("")&&(ss.contains("+")||ss.contains("-")))
                {  r3=min_plus(ss);fin++;
                 if(r3.equals("Erorr"))
                return "Erorr";

            }

                if(fin==0){

                    r0=power(ss);
                    w=w.replace("("+ss+")",r0);
                    MainnActivity.ar.add(w);
fr=r0;
                }

      fin=0;




                if(!r1.equals("")&&(!r2.equals("")||!r3.equals(""))){
                    int q=w.indexOf(ss);
                    w=mathsc.replace(w,q,q+ss.length(),r1);
                    MainnActivity.ar.add(w);
                    ss=r1;
                      }
                else if(!r1.equals("")&&!(!r2.equals("")||!r3.equals(""))){
                    int q=w.indexOf( "("+ss+")");
                    w=mathsc.replace(w,q,q+ss.length()+2,r1);
                    MainnActivity.ar.add(w);
                    fr=r1;
                    //Toast.makeText(context, w+" 2 "+r1, Toast.LENGTH_SHORT).show();
                }
                if(!r2.equals("")&&(!r3.equals(""))){
                    int q=w.indexOf( ss);
                    w=mathsc.replace(w,q,q+ss.length(),r2);
                    MainnActivity.ar.add(w);
                    ss=r2;
                        }
                else if(!r2.equals("")&&r3.equals("")){
                    int q=w.indexOf( "("+ss+")");
                    w=mathsc.replace(w,q,q+ss.length()+2,r2);

                    MainnActivity.ar.add(w);
                    fr=r2;
                    //Toast.makeText(context, w+" 4 "+r2, Toast.LENGTH_SHORT).show();
                }
                if(!r3.equals("")){
                    //                    Toast.makeText(context, (ss.length()+2)+"    "+w.indexOf("("+ ss+")")+" 5 "+w, Toast.LENGTH_SHORT).show();
int q=w.indexOf("("+ ss+")");
                    w=mathsc.replace(w,q,q+ss.length()+2,r3);


                    //w = w.replaceFirst( , r3);
                   // if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                        MainnActivity.ar.add(w);
                    fr=r3;
                   // Toast.makeText(context, +ss+" 5 "+w, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(context, r+" 1 ", Toast.LENGTH_SHORT).show();
                }
               r1="";
                r2="";
                r3="";


                for(int q=0;q<fr.length();q++) {
                    f.add(fr.charAt(q));


                }

            }}


        while(!f.empty()) {
            f3.add(f.pop());
        }

        while(!f3.empty()) {
            de+=f3.pop();

        }


        return de;}
        catch (Exception ex){
            return "Erorr";
        }




    }
    public static String mut_div(String s) {
        try {
            if(s.length()>=2&&s.charAt(0)=='-'&&s.charAt(1)=='-')
                s=s.substring(2,s.length());

            if(s.contains("--"))
              s=  s.replaceAll("--","+");


            if (s == "Erorr")
                return "Erorr";
            String s1 = "", s2 = "";



          

            while (s.contains("!")) {
                s = FAC(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("√")) {
                s = root(s);
                if (s == "Erorr")
                    return "Erorr";

            }
            if (MainnActivity.toggleButton.getText().toString().equals("DEG")) {
                while (s.contains("asin")) {
                    s = asinfin(s);

                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("acos")) {
                    s = acosfin(s);

                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("atan")) {
                    s = atanfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("sec")) {
                    s = secfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("cot")) {
                    s = cotfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }

                while (s.contains("csc")) {
                    s = cscfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("sin")) {
                    s = sinfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("tan")) {
                    s = tanfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("cos")) {
                    s = cosfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
            } else {

                while (s.contains("asin")) {
                    s = asinfinrad(s);

                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("acos")) {
                    s = acosfinrad(s);

                    if (s == "Erorr")
                        return "Erorr";
                }

                while (s.contains("atan"))
                    s = atanfinrad(s);

                while (s.contains("sec")) {
                    s = secfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("cot")) {
                    s = cotfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("csc")) {

                    s = cscfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("sin")) {
                    s = sinfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("tan")) {
                    s = tanfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }

                while (s.contains("cos")) {
                    s = cosfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
            }
            while (s.contains("ln")) {
                s = ln(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("logten")) {
                s = logten(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("log")) {
                s = logfun(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("abs")) {
                s = abs(s);
                if (s == "Erorr")
                    return "Erorr";
            }
             String n1 = "", n2 = "";
            double[] A = new double[100];
            char[] a = new char[100];
            int mi = 1;
            int x = 0, y = 0, c = 0;
            if (s.charAt(0) == '-') {
                mi = -1;

                c++;

            }
            for (int i = c; i < s.length(); i++) {
                if (i >= 2 && s.charAt(i - 1) == '+' && s.charAt(i) == '-')
                    a[y - 1] = '-';

                if (s.charAt(i) == '.' || (s.charAt(i) > 47 && s.charAt(i) < 58) || s.charAt(i) == 'E') {
                    n1 += s.charAt(i);
                    if (s.charAt(i) == 'E' && s.charAt(i + 1) == '-') {
                        n1 += s.charAt(i + 1);

                        i++;
                    }


                } else if ('-' == s.charAt(i)) {
                    if (n1 != "" && i + 1 < s.length() && (s.charAt(i + 1) > 47 && (s.charAt(i + 1) < 58) || s.charAt(i) == 'E')) {
                        a[y++] = '-';
                        A[x++] = mi * Double.parseDouble(n1);
                        mi = 1;

                        n1 = "";
                    } else {
                        if (n1 != "")
                            A[x++] = mi * Double.parseDouble(n1);
                        n1 = "";
                        mi = -1;
                    }
                } else {
                    //4-4+65
                    A[x++] = mi * Double.parseDouble(n1);
                    n1 = "";
                    a[y++] = s.charAt(i);
                    mi = 1;
                }
            }

            A[x++] = mi * Double.parseDouble(n1);
            for (int i = 0; i < y; i++) {
                if (a[i] == '×') {

                    A[i + 1] = BigDecimal.valueOf(A[i+1]).multiply(BigDecimal.valueOf(A[i])).doubleValue();

                } else if (a[i] == '÷') {
                    A[i + 1] =BigDecimal.valueOf(A[i]).divide(BigDecimal.valueOf(A[i+1]),100, RoundingMode.HALF_UP).doubleValue();


                }else {

                    if((long)A[i]-A[i]==0)
                    n2 += String.valueOf((long)A[i]);
                    else
                        n2 += String.valueOf(A[i]);

                    if (a[i] == '+')
                        n2 += "+";
                    if (a[i] == '-')
                        n2 += "-";
                }
            }
            {
                if((long)A[x-1]-A[x-1]==0)
                    n2 += String.valueOf((long)A[x-1]);
                else
                    n2 += String.valueOf(A[x-1]);
            }

            int cou = 0;
            String st = "";
            if (n2.length() > cou + 3 && n2.charAt(cou) == '-' && n2.charAt(cou + 1) == '0' && n2.charAt(cou + 2) == '.' && n2.charAt(cou + 3) == '0' && (n2.length() == cou + 4 || !(n2.charAt(cou + 4) > 47 && n2.charAt(cou + 4) <= 58))) {
                st += "0";

            }
            if (st.equals("0")) {
                n2 = n2.replaceFirst("-0.0", "0");
            }

            return n2;
        }
        catch (Exception e){
            return "Erorr";
        }

    }

    public static String pi(String s) {
        String s2 = "";
        try {


            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == 'π')
                    s2 += String.valueOf(Math.PI);
                else
                    s2 += s.charAt(i);
            }
        }
        catch (Exception E){return "Erorr";}
            return s2;

    }


    public static String min_plus(String s) {
        try {
            if(s.length()>=2&&s.charAt(0)=='-'&&s.charAt(1)=='-')
                s=s.substring(2,s.length());

            if(s.contains("--"))
               s= s.replaceAll("--","+");

            if (s == "Erorr")
                return "Erorr";
              String n1 = "";
            double[] A = new double[100];
            char[] a = new char[100];
            int mi = 1;
            int x = 0, y = 0, c = 0;


            while (s.contains("!")) {
                s = FAC(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("√")) {
                s = root(s);
                if (s == "Erorr")
                    return "Erorr";

            }
            if (MainnActivity.toggleButton.getText().toString().equals("DEG")) {
                while (s.contains("asin")) {
                    s = asinfin(s);

                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("acos")) {
                    s = acosfin(s);

                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("atan")) {
                    s = atanfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("sec")) {
                    s = secfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("cot")) {
                    s = cotfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }

                while (s.contains("csc")) {
                    s = cscfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("sin")) {
                    s = sinfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("tan")) {
                    s = tanfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("cos")) {
                    s = cosfin(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
            } else {

                while (s.contains("asin")) {
                    s = asinfinrad(s);

                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("acos")) {
                    s = acosfinrad(s);

                    if (s == "Erorr")
                        return "Erorr";
                }

                while (s.contains("atan"))
                    s = atanfinrad(s);

                while (s.contains("sec")) {
                    s = secfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("cot")) {
                    s = cotfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("csc")) {

                    s = cscfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("sin")) {
                    s = sinfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
                while (s.contains("tan")) {
                    s = tanfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }

                while (s.contains("cos")) {
                    s = cosfinrad(s);
                    if (s == "Erorr")
                        return "Erorr";
                }
            }
            while (s.contains("ln")) {
                s = ln(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("logten")) {
                s = logten(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("log")) {
                s = logfun(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("abs")) {
                s = abs(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            if (s.charAt(0) == '-' && (s.charAt(1) > 47 && s.charAt(1) < 58)) {
                mi = -1;

                c++;

            }
            for (int i = c; i < s.length(); i++) {

                if (i >= 2 && s.charAt(i - 1) == '+' && s.charAt(i) == '-')
                    a[y - 1] = '-';
                else {

                    if (s.charAt(i) == '.' || (s.charAt(i) > 47 && s.charAt(i) < 58) || s.charAt(i) == 'E') {


                        n1 += s.charAt(i);
                        if (s.charAt(i) == 'E' && s.charAt(i + 1) == '-') {
                            n1 += s.charAt(i + 1);

                            i++;
                        }

                    } else {
                        A[x++] = mi * Double.parseDouble(n1);
                        n1 = "";
                        a[y++] = s.charAt(i);

                        mi = 1;
                    }
                }
            }
            A[x++] = mi * Double.parseDouble(n1);


            for (int i = 0; i < y; i++) {
                if (a[i] == '+'){
                    double e1=BigDecimal.valueOf(A[i+1]).doubleValue(),e2=BigDecimal.valueOf(A[i]).doubleValue(),e3=BigDecimal.valueOf(A[i]).add(BigDecimal.valueOf(A[i+1])).doubleValue();
                    if((e1>=1e17&&e1<1e18)||(e2>=1e17&&e2<1e18))
                        if(e1>e2&&e2<1e4)
                            e3=e1;
                        else if(e2>e1&&e1<1e4)
                            e3=e2;


                    if((e1>=1e18&&e1<1e19)||(e2>=1e18&&e2<1e19))
                        if(e1>e2&&e2<1e7)
                            e3=e1;
                        else if(e2>e1&&e1<1e7)
                            e3=e2;



             A[i + 1] = e3;
        }
                if (a[i] == '-') {
                    double e1=BigDecimal.valueOf(A[i+1]).doubleValue(),e2=BigDecimal.valueOf(A[i]).doubleValue(),e3=BigDecimal.valueOf(A[i]).subtract(BigDecimal.valueOf(A[i+1])).doubleValue();
                    if((e1>=1e17&&e1<1e18)||(e2>=1e17&&e2<1e18))
                        if(e1>e2&&e2<1e4)
                            e3=e1;
                        else if(e2>e1&&e1<1e4)
                            e3=e2;


                    if((e1>=1e18&&e1<1e19)||(e2>=1e18&&e2<1e19))
                        if(e1>e2&&e2<1e7)
                            e3=e1;
                        else if(e2>e1&&e1<1e7)
                            e3=e2;



                    A[i + 1] = e3;

                }


            }
String res="";
            if((long)A[x-1]-A[x-1]==0)
                res += String.valueOf((long)A[x-1]);
            else
                res += String.valueOf(A[x-1]);



            return res;
        } catch (Exception e){
                return "Erorr";
            }
  }

    public static String tanfinrad(String s3) {
        int sin=s3.lastIndexOf("tan")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);
            }
            else {



                break;

            }


        }



        if(st.equals(""))
            return "Erorr";
        double v=(Math.tan((Double.parseDouble(st))));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);
        double v2=(Math.cos((Double.parseDouble(st))));
        double res3=Math.round(v2*Math.pow(10,10))/Math.pow(10,10);
if(res3==0)
    return "Erorr";

        sd=s3.replace("tan"+st,String.valueOf(res2));

        return sd;


    }



    public static String sinfinrad(String s3) {
        int sin=s3.lastIndexOf("sin")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);
      }
            else {



                break;

            }


        }



        if(st.equals(""))
            return "Erorr";

        double v=(Math.sin((Double.parseDouble(st))));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("sin"+st,String.valueOf(res2));
       return sd;


    }


    public static String cosfinrad(String s3) {
        int sin=s3.lastIndexOf("cos") + 3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }
        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";
        double v=(Math.cos((Double.parseDouble(st))));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("cos"+st,String.valueOf(res2));
        return sd;


    }

    public static String secfinrad(String s3) {
        int sin=s3.lastIndexOf("sec")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";

       double v2=Math.cos((Double.parseDouble(st)));
        double res3=Math.round(v2*Math.pow(10,10))/Math.pow(10,10);
        if(res3==0)
            return "Erorr";
        double v=(1.0/Math.cos(Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("sec"+st,String.valueOf(res2));

//System.out.println(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(st)))));
        return sd;


    }


    public static String cscfinrad(String s3){
            int sin = s3.lastIndexOf("csc") + 3;
            String st = "", sd = "";
            if (s3.charAt(sin) == '-') {

                sin++;
                st += '-';

            }
            for (int i = sin; i < s3.length(); i++) {

                if ((s3.charAt(i) == '.' || (s3.charAt(i) > 47 && s3.charAt(i) < 58) || s3.charAt(i) == 'E')) {
                    st += s3.charAt(i);

                    //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

                } else {


                    break;

                }


            }
        if(st.equals(""))
            return "Erorr";

        double v2=Math.sin(Double.parseDouble(st));
        double res3=Math.round(v2*Math.pow(10,10))/Math.pow(10,10);
        if(res3==0)
            return "Erorr";
        double v=(1.0/Math.sin(Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd = s3.replace("csc" + st, String.valueOf(res2));


            //System.out.println(String.valueOf(1/Math.sin(Math.toRadians(Double.parseDouble(st)))));

            return sd;
        }






    public static String cotfinrad(String s3) {
        int sin=s3.lastIndexOf("cot")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";

        double v2=Math.sin(Double.parseDouble(st));
        double res3=Math.round(v2*Math.pow(10,10))/Math.pow(10,10);
        if(res3==0)
            return "Erorr";
        double v=(Math.cos(Double.parseDouble(st))/Math.sin(Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("cot"+st,String.valueOf(res2));
        //System.out.println(sd);

        return sd;


    }







































    public static String asinfinrad(String s3) {
        int sin=s3.lastIndexOf("asin")+4;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }
        for(int i=sin;i<s3.length();i++) {
            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

            }
            else {


                break;

            }


        }




        if(st.equals(""))
            return "Erorr";
if(Double.parseDouble(st)>1||Double.parseDouble(st)<-1)
    return "Erorr";
        double v=Math.asin((Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("asin"+st,String.valueOf(res2));


        //System.out.println(sd);




        return sd;


    }
    public static String atanfinrad(String s3) {
        int sin=s3.lastIndexOf("atan")+4;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }
        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }


        if(st.equals(""))
            return "Erorr";
        double v=Math.atan((Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("atan"+st,String.valueOf((res2)));
        //System.out.println(sd);
        return sd;


    }
    public static String acosfinrad(String s3) {
        int sin=s3.lastIndexOf("acos")+4;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {


                break;

            }


        }
         if(st.equals(""))
            return "Erorr";
        if(Double.parseDouble(st)>1)
            return "Erorr";
        double v=Math.acos((Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);


        sd=s3.replace("acos"+st,String.valueOf(((res2))));



        return sd;


    }







    public static String logfun(String s3) {
        int sin=0;
         sin=s3.lastIndexOf("log")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }
        if(st.equals(""))
            return "Erorr";
        if(Double.parseDouble(st)<0)
            return "Erorr";

        sd=s3.replace("log"+st,String.valueOf(Math.log((Double.parseDouble(st)))));

        //System.out.println(sd);
        return sd;


    }
    public static String ln(String s3) {

      int sin=0;
        sin=s3.lastIndexOf("ln")+2;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }


        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";
        if(Double.parseDouble(st)<0)
            return "Erorr";

        sd=s3.replace("ln"+st,String.valueOf(Math.log((Double.parseDouble(st)))));

        //System.out.println(sd);
        return sd;


    }
    public static String FAC (String s3){

        String st = "", sd = "";
        int fac = s3.lastIndexOf("!") - 1;

        for (int i = fac; i >= 0; i--) {

            if ((s3.charAt(i) == '.' || (s3.charAt(i) > 47 && s3.charAt(i) < 58) || s3.charAt(i) == 'E')) {
                st += s3.charAt(i);
            } else
                break;


        }
        String q="";
        for(int i=st.length()-1;i>=0;i--)
            q+=st.charAt(i);
if(q.contains("."))
    return  "Erorr";

        //System.out.println(Math_fac((Long.parseLong(st))));
        sd=s3.replace(q+"!",String.valueOf(Math_fac(Double.parseDouble(q))));
        //System.out.print(sd);
        //System.out.println(sd);
        return sd;


    }


    public static String logten(String s3) {
        String st="",sd="";
        int sin=0;
        sin=s3.lastIndexOf("logten")+6;
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }


        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }
           if(st.equals(""))
            return "Erorr";
        if(Double.parseDouble(st)<0)
            return "Erorr";

        sd=s3.replace("logten"+st,String.valueOf(Math.log10((Double.parseDouble(st)))));

        return sd;


    }


    public static String abs(String s3) {
        int sin=s3.lastIndexOf("abs")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-'){

            sin++;
            st+='-';

        }
        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }
        if(st.equals(""))
            return "Erorr";
        sd=s3.replace("abs"+st,String.valueOf(Math.abs((Double.parseDouble(st)))));


        return sd;


    }



    public static double Math_fac ( double x){
        double fac = 1;
        for (int i = (int)x; i > 0; i--)
            fac *= i;
        return fac;
    }

    public static String tanfin(String s3) {
        int sin=s3.lastIndexOf("tan")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);
            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";
        double v2=(Math.cos(Math.toRadians(Double.parseDouble(st))));
        double res3=Math.round(v2*Math.pow(10,10))/Math.pow(10,10);
        if(res3==0)
            return "Erorr";
        double v=(Math.tan(Math.toRadians(Double.parseDouble(st))));
        //Toast.makeText(context, v+"", Toast.LENGTH_SHORT).show();
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("tan"+st,String.valueOf(res2));

        return sd;


    }



    public static String sinfin(String s3) {
        int sin=s3.lastIndexOf("sin")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";

        double v=(Math.sin(Math.toRadians(Double.parseDouble(st))));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("sin"+st,String.valueOf(res2));

//System.out.println(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(st)))));
        return sd;


    }


    public static String cosfin(String s3) {
        int sin=s3.lastIndexOf("cos") + 3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }
        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }


        if(st.equals(""))
            return "Erorr";
        double v=Math.cos(Math.toRadians(Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);


        sd=s3.replace("cos"+st,String.valueOf(res2));
        return sd;


    }

    public static String secfin(String s3) {
        int sin=s3.lastIndexOf("sec")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";
        double v2=Math.cos(Math.toRadians(Double.parseDouble(st)));
        double res3=Math.round(v2*Math.pow(10,10))/Math.pow(10,10);
        if(res3==0)
            return "Erorr";


        double v=1.0/Math.cos(Math.toRadians(Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("sec"+st,String.valueOf(res2));

//System.out.println(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(st)))));
        return sd;


    }


    public static String cscfin(String s3) {
        int sin=s3.lastIndexOf("csc")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }
        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }
        if(st.equals(""))
            return "Erorr";


        double v2=Math.sin(Math.toRadians(Double.parseDouble(st)));
        double res3=Math.round(v2*Math.pow(10,10))/Math.pow(10,10);
        if(res3==0)
            return "Erorr";


        double v=1.0/Math.sin(Math.toRadians(Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("csc"+st,String.valueOf(res2));


        //System.out.println(String.valueOf(1/Math.sin(Math.toRadians(Double.parseDouble(st)))));

        return sd;


    }



    public static String cotfin(String s3) {
        int sin=s3.lastIndexOf("cot")+3;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";

        double v2=Math.sin(Math.toRadians(Double.parseDouble(st)));
        double res3=Math.round(v2*Math.pow(10,10))/Math.pow(10,10);
        if(res3==0)
            return "Erorr";


          double v=Math.cos(Math.toRadians(Double.parseDouble(st)))/Math.sin(Math.toRadians(Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

           sd=s3.replace("cot"+st,String.valueOf(res2));
        //System.out.println(sd);

        return sd;


    }




    public static String asinfin(String s3) {
        int sin=s3.lastIndexOf("asin")+4;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }
        for(int i=sin;i<s3.length();i++) {
            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

            }
            else {


                break;

            }


        }
        if(Double.parseDouble(st)<-1||Double.parseDouble(st)>1||st.equals(""))
            return "Erorr";

            double v=Math.toDegrees(Math.asin((Double.parseDouble(st))));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);
       // Toast.makeText(context, ""+res2, Toast.LENGTH_SHORT).show();
        sd=s3.replace("asin"+st,String.valueOf(res2));


        //System.out.println(sd);




        return sd;


    }
    public static String atanfin(String s3) {
        int sin=s3.lastIndexOf("atan")+4;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }
        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {



                break;

            }


        }

        if(st.equals(""))
            return "Erorr";
        double v=Math.toDegrees(Math.atan((Double.parseDouble(st))));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);

        sd=s3.replace("atan"+st,String.valueOf(res2));

        //System.out.println(sd);
        return sd;


    }
    public static String acosfin(String s3) {
        int sin=s3.lastIndexOf("acos")+4;
        String st="",sd="";
        if(s3.charAt(sin)=='-') {

            sin++;
            st+='-';

        }

        for(int i=sin;i<s3.length();i++) {

            if((s3.charAt(i)=='.'||(s3.charAt(i)>47&&s3.charAt(i)<58)||s3.charAt(i)=='E'))
            {
                st+=s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            }
            else {


                break;

            }


        }
        if(Double.parseDouble(st)<-1||Double.parseDouble(st)>1||st.equals(""))
            return "Erorr";
        double v=Math.toDegrees(Math.acos(Double.parseDouble(st)));
        double res2=Math.round(v*Math.pow(10,10))/Math.pow(10,10);


        sd=s3.replace("acos"+st,String.valueOf(res2));



        return sd;


    }



    static String root(String s3) {


        int sin = s3.lastIndexOf("√") + 1;
        String st = "", sd = "";
        if (s3.charAt(sin) == '-') {

            sin++;
            st += '-';

        }

        for (int i = sin; i < s3.length(); i++) {

            if ((s3.charAt(i) == '.' || (s3.charAt(i) > 47 && s3.charAt(i) < 58) || s3.charAt(i) == 'E')) {
                st += s3.charAt(i);

                //s3=s3.replace("sin"+String.valueOf(st),String.valueOf(Math.sin(Double.parseDouble(st))));

            } else {


                break;

            }


        }
        if(Double.parseDouble(st)<0||st.equals("")) {
            return "Erorr";
        }

            sd = s3.replace("√" + st, String.valueOf(Math.sqrt((Double.parseDouble(st)))));
            return sd;
        }





    public static String power (String s){
        if(s.length()>=2&&s.charAt(0)=='-'&&s.charAt(1)=='-')
        s=s.substring(2,s.length());
        if(s.contains("--"))
            s=s.replaceAll("--","+");
        String n1 = "", n2 = "";
        double[] A = new double[100];
        char[] a = new char[100];
        String [] sss=new String[40];
        int mi = 1;String n3="";
        int x = 0, y = 0, c = 0;
        try{

        while (s.contains("!")) {
            s = FAC(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("√")) {
            s = root(s);
            if (s == "Erorr")
                return "Erorr";

        }
        if (MainnActivity.toggleButton.getText().toString().equals("DEG")) {
            while (s.contains("asin")) {
                s = asinfin(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("acos")) {
                s = acosfin(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("atan")) {
                s = atanfin(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("sec")) {
                s = secfin(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("cot")) {
                s = cotfin(s);
                if (s == "Erorr")
                    return "Erorr";
            }

            while (s.contains("csc")) {
                s = cscfin(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("sin")) {
                s = sinfin(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("tan")) {
                s = tanfin(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("cos")) {
                s = cosfin(s);
                if (s == "Erorr")
                    return "Erorr";
            }
        } else {

            while (s.contains("asin")) {
                s = asinfinrad(s);

                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("acos")) {
                s = acosfinrad(s);

                if (s == "Erorr")
                    return "Erorr";
            }

            while (s.contains("atan"))
                s = atanfinrad(s);

            while (s.contains("sec")) {
                s = secfinrad(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("cot")) {
                s = cotfinrad(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("csc")) {

                s = cscfinrad(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("sin")) {
                s = sinfinrad(s);
                if (s == "Erorr")
                    return "Erorr";
            }
            while (s.contains("tan")) {
                s = tanfinrad(s);
                if (s == "Erorr")
                    return "Erorr";
            }

            while (s.contains("cos")) {
                s = cosfinrad(s);
                if (s == "Erorr")
                    return "Erorr";
            }
        }
        while (s.contains("ln")) {
            s = ln(s);

            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("logten")) {
            s = logten(s);

            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("log")) {
            s = logfun(s);

            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("abs")) {
            s = abs(s);
            if (s == "Erorr")
                return "Erorr";
        }

        if (s.charAt(0) == '-') {
            mi = -1;

            c++;

        }
        for (int i = c; i < s.length(); i++) {

            if (s.charAt(i) == '.' || (s.charAt(i) > 47 && s.charAt(i) < 58) || s.charAt(i) == 'E') {

                n1 += s.charAt(i);
                if (s.charAt(i) == 'E' && s.charAt(i + 1) == '-') {
                    n1 += s.charAt(i + 1);

                    i++;
                }

            } else if ('-' == s.charAt(i)) {
                if (n1 != "" && i + 1 < s.length() && (s.charAt(i + 1) > 47 && (s.charAt(i + 1) < 58) || s.charAt(i) == 'E')) {
                    a[y++] = '-';
                    A[x++] = mi * Double.parseDouble(n1);
                    mi = 1;

                    n1 = "";
                } else {
                    if (n1 != "")
                        A[x++] = mi * Double.parseDouble(n1);
                    n1 = "";
                    mi = -1;
                }
            } else {
                 A[x++] = mi * Double.parseDouble(n1);
                n1 = "";
                a[y++] = s.charAt(i);
                mi = 1;
            }
        }

        A[x++] = mi * Double.parseDouble(n1);

        n1 = "";
        int r=0;

        for (int i = x-1; i >= 0; i--) {
            if (i<y&&a[i] == '^') {

                A[i] =mathsc.po( Math.pow(A[i], A[i + 1]));



            }

            else
            {
                if (a[i] == '+'||a[i] == '-'||a[i] == '÷'||a[i] == '×')
                {
                    if(A[i+1]-(long)A[i+1]==0)

                    {sss[r]="";
                        sss[r]+=a[i];
                        sss[r]+=(long)A[i+1];
                        r++;

                    }else {sss[r]="";
                        sss[r]+=a[i];
                        sss[r++]+=A[i+1];
                    }
                }
            }
        }


        if(A[0]-(long)A[0]==0)
            n3+=(long)A[0];
        else
            n3+=A[0];

        for(int i=r-1;i>=0;i--) {
            n3+=sss[i];

        }
        if(n3.contains("+-")){
            for(int i=0;i<n3.length()-1;i++) {
                if(n3.charAt(i)=='+'&&n3.charAt(i+1)=='-') {
                    n2+='-';
                    i++;
                }
                else
                    n2+=n3.charAt(i);

            }
        System.out.println(n3);
        n2+=n3.charAt(n3.length()-1);
            return n2;

        }
	           /* if(n2.contains("-0.0")&&(n2.length()==4||!(n2.charAt(4)>47&&n2.charAt(4)<58)))
	                n2.replaceFirst("-0.0","0.0");
*/}
catch (Exception e){
            return "Erorr";
        }





        return n3;






    }




static  String replace(String text,int start,int end,String res){



    int c=0;
    String new1="";
    for(int i=0;i<text.length();i++)
        if((i<start||i>=end))
            new1+=text.charAt(i);
        else if(c==0) {
            new1+=res;
            c++;

        }

return new1;


}

static  String problem(String s){
    String e="";
    while(s.contains("%^")) {

        for(int i=0;i<s.indexOf("%^");i++)
            if(s.charAt(i)=='-'||s.charAt(i)=='+'||s.charAt(i)=='×'||s.charAt(i)=='^'||s.charAt(i)=='%'||s.charAt(i)=='÷')
                e="";
            else
                e+=s.charAt(i);
       String e2=function(e);
        //Toast.makeText(context, e2+"  ok", Toast.LENGTH_SHORT).show();
        for(int i=0;i<e2.length();i++){

            if(e2.charAt(i)>=(int)'a'&&e2.charAt(i)<=(int)'z')
                return "Erorr";

        }
            String ww=String.valueOf(Double.parseDouble(e2)/100.0);
        s=s.replace(e+"%^",ww +"^");
    }

    return s;
    }


static  String divre(String s){
        String ne="";
        for (int i=0;i<s.length();i++){
            if(i<s.length()-1&&s.charAt(i)=='%'&&s.charAt(i+1)!='^'){
                ne+="÷100";
            }
            else if(i==s.length()-1&&s.charAt(i)=='%'){
                ne+="÷100";
            }
            else
                ne+=s.charAt(i);

        }





        return ne;

}





static String function(String s){

    while (s.contains("!")) {
        s = FAC(s);
        if (s == "Erorr")
            return "Erorr";
    }
    while (s.contains("√")) {
        s = root(s);
        if (s == "Erorr")
            return "Erorr";

    }
    if (MainnActivity.toggleButton.getText().toString().equals("DEG")) {
        while (s.contains("asin")) {
            s = asinfin(s);

            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("acos")) {
            s = acosfin(s);

            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("atan")) {
            s = atanfin(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("sec")) {
            s = secfin(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("cot")) {
            s = cotfin(s);
            if (s == "Erorr")
                return "Erorr";
        }

        while (s.contains("csc")) {
            s = cscfin(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("sin")) {
            s = sinfin(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("tan")) {
            s = tanfin(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("cos")) {
            s = cosfin(s);
            if (s == "Erorr")
                return "Erorr";
        }
    } else {

        while (s.contains("asin")) {
            s = asinfinrad(s);

            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("acos")) {
            s = acosfinrad(s);

            if (s == "Erorr")
                return "Erorr";
        }

        while (s.contains("atan"))
            s = atanfinrad(s);

        while (s.contains("sec")) {
            s = secfinrad(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("cot")) {
            s = cotfinrad(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("csc")) {

            s = cscfinrad(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("sin")) {
            s = sinfinrad(s);
            if (s == "Erorr")
                return "Erorr";
        }
        while (s.contains("tan")) {
            s = tanfinrad(s);
            if (s == "Erorr")
                return "Erorr";
        }

        while (s.contains("cos")) {
            s = cosfinrad(s);
            if (s == "Erorr")
                return "Erorr";
        }
    }
    while (s.contains("ln")) {
        s = ln(s);

        if (s == "Erorr")
            return "Erorr";
    }
    while (s.contains("logten")) {
        s = logten(s);

        if (s == "Erorr")
            return "Erorr";
    }
    while (s.contains("log")) {
        s = logfun(s);

        if (s == "Erorr")
            return "Erorr";
    }
    while (s.contains("abs")) {
        s = abs(s);
        if (s == "Erorr")
            return "Erorr";
    }

return s;
}


    public static String exp(String s) {

        String s2 = "";
        try {


            for (int i = 0; i < s.length()-1; i++)
             if(s.charAt(i)=='e'&&s.charAt(i+1)!='c'&&s.charAt(i+1)!='n')
                    s2 += String.valueOf(Math.exp(1));
                else
                    s2 += s.charAt(i);



            if(s.length()>0&&s.charAt(s.length()-1) == 'e')
                s2 += String.valueOf(Math.exp(1));
            else if(s.charAt(s.length()-1)!='e')
                s2+=s.charAt(s.length()-1);







        }



        catch (Exception E){return "Erorr";}
        return s2;



    }



    private static double po(double a){
        String e3=String.valueOf(a);
        String er="";int inE=0;
        int dec=-1,d=10;
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


        return Double.parseDouble(er);
    }


}























































//


