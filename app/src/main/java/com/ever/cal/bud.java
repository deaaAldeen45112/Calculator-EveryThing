package com.ever.cal;

public class bud {

    String name;
    String weight;
    String number;
    String calorei;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getNumber() {
        return number;
    }

    public String getCalorei() {
        return calorei;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCalorei(String calorei) {
        this.calorei = calorei;
    }

    public bud(String name, String weight, String number, String calorei) {
        this.name = name;
        this.weight = weight;
        this.number = number;
        this.calorei = calorei;
    }
}
