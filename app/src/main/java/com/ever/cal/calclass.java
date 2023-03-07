package com.ever.cal;

public class calclass {
    private String name;
    private String we;
    private  String ca;


    public calclass(String name, String we, String ca){
        this.ca=ca;
        this.name=name;
        this.we=we;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWe(String we) {
        this.we = we;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

    public String getName() {
        return name;
    }

    public String getWe() {
        return we;
    }

    public String getCa() {
        return ca;
    }
}
