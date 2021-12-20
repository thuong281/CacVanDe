package com.example.myapplication.model;

import java.util.ArrayList;

public class CauHoi {
    private String noiDung,dapAnDung;
    private ArrayList<String> arrDapAnSai;
    private boolean coAnh;
    private int linkAnh;

    public boolean isCoAnh() {
        return coAnh;
    }

    public void setCoAnh(boolean coAnh) {
        this.coAnh = coAnh;
    }

    public int getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(int linkAnh) {
        this.linkAnh = linkAnh;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public ArrayList<String> getArrDapAnSai() {
        return arrDapAnSai;
    }

    public void setArrDapAnSai(ArrayList<String> arrDapAnSai) {
        this.arrDapAnSai = arrDapAnSai;
    }
    public void setArrDapAnSai(String dapAnSai) {//dapan1&dapan2&dâpn3
        String arrS[]=dapAnSai.split("&");
        this.arrDapAnSai = new ArrayList<>();
        for (String s : arrS){
            arrDapAnSai.add(s);
        }
    }
}