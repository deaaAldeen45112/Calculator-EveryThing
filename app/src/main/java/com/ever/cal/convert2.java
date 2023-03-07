package com.ever.cal;


public class convert2 {

    String [] cov={ "length","Mass","TIME", "Pressure", "Speed", "Temperature", "Datastorge", "Energy", "Volume", "FuelEconomy","Area","Datastorgetrasfer","Frequency"};

    class length{
        double Kilometre=1000;
        double Metre=1;
        double Centimetre=0.01;
        double Millimetre=0.001;
        double Micrometre=0.000001;
        double Nanometre=1e-9;
        double Mile=1609.34;
        double Yard=0.9144;
        double Foot=0.3048;
        double Inch=0.0254;
    }
    public 	class Mass{
        double Kilogram=1000;
        double Gram=1;
        double Milligram=0.001;
        double Microgram=0.000001;
        double Nanogram=0.000000001;
        double Imperialton=1.016e+6;
        double Pound=453.592;
        double Ounce=28.3495;
        double Stone=6350.29;
        double USton=907185;
    }
    class TIME {
        double Second=1;
        double Minute=60;
        double Hour=3600;
        double Day=3600*24;
        double Month=3600*24*30;
        double Week=3600*24*7;
        double Year=3600*24*365;
        double Decade=3.154e+8;
        double Century=3.154e+9;
        double MilliSecond=0.001;
        double MicroSecond=0.000001;
        double NanoSecond=0.000000001;

    }
    class Pressure{
        double Pascal=1e-5;
        double PoundForceBar=0.0689476;
        double Standerdatmosphere=1.0325;
        double Torr=0.00133322;
        double Bar=1;
    }
    class Speed{
        double MilesPerHour=0.44704;
        double FootPerSecond=0.3048;
        double KiloPerHour=0.277778;
        double Knot=0.514444;
        double MetrePerSecond=1;

    }

    class Datastorge{
        double bit=1;
        double kilobit=1000;
        double Kibibit=1000;
        double Megabit=1e6;
        double Mebibit=1.049e+6;
        double Gigabit=1e+9;
        double Gibibit=1.074e+9;
        double Terabit=1e+12;
        double Tebibit=1.1e+12;
        double Petabit=1e+15;
        double Pebibit=1.126e+15;
        double Byte=8;
        double kiloByte=8000;
        double KibiByte=8192;
        double MegaByte=8e+6;
        double MebiByte=8.389e+6;
        double GigaByte=8e+9;
        double GibiByte=8.59e+9;
        double TeraByte=8e+12;
        double TebiByte=8.796e+12;
        double PetaByte=8e+15;
        double PebiByte=9.007e+15;

    }


    class Energy{


        double Joule=1;
        double KiloJoule=1000;
        double Gramcalorie=4.184;
        double Kilocalorie=4184;
        double Watthour=3600;
        double KiloWatthour=3.6e+6;
        double ElectronVolt=1.6022e-19;
        double Britishthermalunit=1055.06;
        double UStherm=105480814.64345;
        double Foot_Pound=1.35582;
        //double cubicinch, thecubicfoot, thecubicyard,thecubicmile, theteaspoon, thetablespoon, thefluidounce, thefluiddram, thegill, thepint, thequart, thegallon, theminim, thebarrel, thecord, peck, bushel,  hogshead, theacrefoot,theboardfoot;
    }

    class Volume{

        double USliquidgallon=3.78541;
        double USliquidquart=0.946353;
        double USliquidpint=0.473176;
        double USlegalcup=0.24;
        double fluidounce=0.0295735;
        double UStablespoon=0.0147868;
        double USteaspoon=0.00492892;
        double Milliliter=0.001;
        double gallon=4.54609;
        double Imperailpint=1.13652;
        double Imperailquart=0.568261;
        double Imperailcup=0.284131;
        double Imperailtablespoon=0.0177582;
        double Imperailteaspoon=0.00591939;
        double liter =1;
        double cubicinch=28.3168, thecubicfoot=0.0163871;
    }

    class FuelEconomy{
        double KiloPerliter=1;
        double mileperUSgallon=0.425144;
        double mileUSgallon=0.354006;
        double literper100Km=100;


    }
    class Area{
        double SquareKilometre=1e+6;
        double SquareMetre=1;
        double SquareMile=2.59e+6;
        double SquareYard=0.836127;
        double SquareFoot=0.092903;
        double SquareInch=0.00064516;
        double Hectare=10000;
        double Acre=4046.86;
    }

    class Frequency{

        double Kilohertz=1000;
        double Megahertz=1e+6;
        double Gigahertz=1e+9;
        double hertz=1;
    }

    class Datastorgetrasfer{
        double bitpersecond=1;
        double kilobitpersecond=1000;
        double Kibibitpersecond=1024;
        double Megabitpersecond=1e+6;
        double Mebibitpersecond=1.049e+6;
        double Gigabitpersecond=1e+9;
        double Gibibitpersecond=1.074e+9;
        double Terabitpersecond=1e+12;
        double Tebibitpersecond=1.1e+12;
        double kiloBytepersecond=8000;
        double MegaBytepersecond=8e+6;
        double GigaBytepersecond=8e+9;
        double TeraBytepersecond=8e+12;

    }

}

