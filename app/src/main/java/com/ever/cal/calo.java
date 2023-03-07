package com.ever.cal;

public class calo {
    public String getCaloreiser() {
        return caloreiser;
    }

    public String getCaloreigram() {
        return caloreigram;
    }

    public String getCaloreioz() {
        return caloreioz;
    }

    public void setCaloreiser(String caloreiser) {
        this.caloreiser = caloreiser;
    }

    public void setCaloreigram(String caloreigram) {
        this.caloreigram = caloreigram;
    }

    public void setCaloreioz(String caloreioz) {
        this.caloreioz = caloreioz;
    }

    public calo(String caloreiser, String caloreigram, String caloreioz) {
        this.caloreiser = caloreiser;
        this.caloreigram = caloreigram;
        this.caloreioz = caloreioz;
    }

    private String caloreiser;
    private String caloreigram;
    private String caloreioz;




}
