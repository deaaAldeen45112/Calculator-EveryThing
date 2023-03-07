package com.ever.cal;

import android.content.Context;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class math {

    static Context context;
    public static String patt(String s) {
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


                        String dd=math.problem(ss);
                        w=w.replace(ss,dd);
                        MainActivity.ar.add(w);

                        ss=dd;
                        //Toast.makeText(context,ss+" power ", Toast.LENGTH_SHORT).show();
                    }
                    if(ss.contains("^")){
                        r1=power(ss);
                        fin++;
                        //Toast.makeText(context, r1+" power ", Toast.LENGTH_SHORT).show();
                    }
                    if(!r1.equals("")&&(r1.contains("×")|| r1.contains("÷")))
                    {r2=mut_div(r1);fin++;
                        //Toast.makeText(context, r2+" ml ", Toast.LENGTH_SHORT).show();
                        if(r2.equals("Erorr"))
                            return "Erorr";

                    }
                    else if(r1.equals("")&&(ss.contains("×")||ss.contains("÷")))
                    {r2=mut_div(ss);fin++;
                        //Toast.makeText(context, r2+" m1 ", Toast.LENGTH_SHORT).show();
                        if(r2.equals("Erorr"))
                            return "Erorr";

                    }
                    if(!r2.equals("")&&(r2.contains("+")||r2.contains("-")))
                    { r3=min_plus(r2);fin++;
                        //Toast.makeText(context, r2+r3+" 1pm ", Toast.LENGTH_SHORT).show();
                        if(r3.equals("Erorr"))
                            return "Erorr";

                    }
                    else  if(!r1.equals("")&&(r1.contains("+")||r1.contains("-")))
                    {  r3=min_plus(r1);fin++;
                        //Toast.makeText(context, r1+" "+r3+" 2pm ", Toast.LENGTH_SHORT).show();
                        if(r3.equals("Erorr"))
                            return "Erorr";

                    }
                    else if(r1.equals("")&&r2.equals("")&&(ss.contains("+")||ss.contains("-")))
                    {  r3=min_plus(ss);fin++;
                        //Toast.makeText(context, ss+" "+r3+" 3pm ", Toast.LENGTH_SHORT).show();
                        if(r3.equals("Erorr"))
                            return "Erorr";

                    }

                    if(fin==0){

                        r0=power(ss);
                        w=w.replace("("+ss+")",r0);
                        MainActivity.ar.add(w);
                        fr=r0;
                    }

                    fin=0;




                    if(!r1.equals("")&&(!r2.equals("")||!r3.equals(""))){
                        int q=w.indexOf(ss);
                        w=math.replace(w,q,q+ss.length(),r1);
                        MainActivity.ar.add(w);
                        ss=r1;
                        //  Toast.makeText(context, w+" 1 "+r1, Toast.LENGTH_SHORT).show();
                    }
                    else if(!r1.equals("")&&!(!r2.equals("")||!r3.equals(""))){
                        int q=w.indexOf( "("+ss+")");
                        w=math.replace(w,q,q+ss.length()+2,r1);
                        MainActivity.ar.add(w);
                        fr=r1;
                        //Toast.makeText(context, w+" 2 "+r1, Toast.LENGTH_SHORT).show();
                    }
                    if(!r2.equals("")&&(!r3.equals(""))){
                        int q=w.indexOf( ss);
                        w=math.replace(w,q,q+ss.length(),r2);
                        MainActivity.ar.add(w);
                        ss=r2;
                        //Toast.makeText(context, w+" 3 "+r2, Toast.LENGTH_SHORT).show();
                    }
                    else if(!r2.equals("")&&r3.equals("")){
                        int q=w.indexOf( "("+ss+")");
                        w=math.replace(w,q,q+ss.length()+2,r2);

                        MainActivity.ar.add(w);
                        fr=r2;
                        //Toast.makeText(context, w+" 4 "+r2, Toast.LENGTH_SHORT).show();
                    }
                    if(!r3.equals("")){
                        //                    Toast.makeText(context, (ss.length()+2)+"    "+w.indexOf("("+ ss+")")+" 5 "+w, Toast.LENGTH_SHORT).show();
                        int q=w.indexOf("("+ ss+")");
                        w=math.replace(w,q,q+ss.length()+2,r3);


                        //w = w.replaceFirst( , r3);
                        // if(  !MainnActivity.ar.get(MainnActivity.ar.size()-1).equals(w))
                        MainActivity.ar.add(w);
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
            if (s .equals("Erorr"))
                return "Erorr";

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


    public static String min_plus(String s) {
        try {
            if(s.length()>=2&&s.charAt(0)=='-'&&s.charAt(1)=='-')
                s=s.substring(2,s.length());

            if(s.contains("--"))
                s= s.replaceAll("--","+");
            if (s .equals("Erorr"))
                return "Erorr";
  String n1 = "";
            double[] A = new double[100];
            char[] a = new char[100];
            int mi = 1;
            int x = 0, y = 0, c = 0;

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




    public static String power (String s){
        if(s.length()>=2&&s.charAt(0)=='-'&&s.charAt(1)=='-')
            s=s.substring(2,s.length());
        if(s.contains("--"))
            s=s.replaceAll("--","+");
        if (s .equals("Erorr"))
            return "Erorr";

        String n1 = "", n2 = "";
        double[] A = new double[100];
        char[] a = new char[100];
        String [] sss=new String[40];
        int mi = 1;String n3="";
        int x = 0, y = 0, c = 0;
        try{

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

                    A[i] =math.po(Math.pow(A[i], A[i + 1]));



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

            String ww=String.valueOf(Double.parseDouble(e)/100.0);
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


