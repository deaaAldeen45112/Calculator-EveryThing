package com.ever.cal;

public class spandcal {
    private  String weightser;
    private String weightgram;
    private String weightoz;
    public spandcal(String weightser, String weightgram, String weightoz) {
        this.weightser = weightser;
        this.weightgram = weightgram;
        this.weightoz = weightoz;
    }

    public void setWeightser(String weightser) {
        this.weightser = weightser;
    }

    public void setWeightgram(String weightgram) {
        this.weightgram = weightgram;
    }

    public void setWeightoz(String weightoz) {
        this.weightoz = weightoz;
    }

    public String getWeightser() {
        return weightser;
    }

    public String getWeightgram() {
        return weightgram;
    }

    public String getWeightoz() {
        return weightoz;
    }
}
