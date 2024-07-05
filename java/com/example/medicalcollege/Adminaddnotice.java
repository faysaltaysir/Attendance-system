package com.example.medicalcollege;

public class Adminaddnotice {


    private String hll;
    private String nme;
    private String cnt;
    private String rm;

    public Adminaddnotice(String hll, String nme, String  cnt, String rm) {
        this.hll = hll;
        this.nme = nme;
        this.cnt= cnt;
        this.rm= rm;
    }

    public String getLoc() {
        return hll;
    }


    public String getNme() {
        return nme;
    }

    public String getContact() {
        return cnt;
    }

    public String getRoom(){return rm;};

    public void setNme(String nme) {
        this.nme = nme;
    }

    public void setContact(String cnt) {
        this.cnt = cnt;
    }
    public void setRoom(String rm ){
        this.rm=rm;
    }
    public void setLoc(String hll) {
        this.hll = hll;
    }



}
