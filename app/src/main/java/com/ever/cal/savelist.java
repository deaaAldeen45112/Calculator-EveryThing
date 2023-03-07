package com.ever.cal;

public class savelist {
   private  int id;
    private String eq;
    private String eq2;
    public void setEq2(String eq2) {
        this.eq2 = eq2;
    }

    public String getEq2() {
        return eq2;
    }



    public savelist(int id, String eq, String eq2) {
        this.id = id;
        this.eq = eq;
        this.eq2 = eq2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEq(String eq) {
        this.eq = eq;
    }

    public int getId() {
        return id;
    }

    public String getEq() {
        return eq;
    }
}
