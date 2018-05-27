package com.ritekittaskapp.appkca.Model;

import com.google.gson.annotations.SerializedName;

public class HashtagModel {


    @SerializedName("tag")
    private String htag;
    @SerializedName("tweets")
    private long htweets;
    @SerializedName("retweets")
    private long hretweets;
    @SerializedName("exposure")
    private double hexposure ;
    @SerializedName("links")
    private double hlink;
    @SerializedName("photos")
    private double hphotos;
    @SerializedName("mentions")
    private double hmentions;
    @SerializedName("color")
    private int hcolor;



    public HashtagModel(String htag, int hcolor, long hretweets, long htweets, double hexposure, double hlink, double hphotos, double hmentions) {
        this.htag = htag;
        this.hcolor = hcolor;
        this.hretweets = hretweets;
        this.htweets = htweets;
        this.hexposure = hexposure;
        this.hlink = hlink;
        this.hphotos = hphotos;
        this.hmentions = hmentions;
    }

    public String getHtag() {
        return htag;
    }

    public int getHcolor() {
        return hcolor;
    }

    public long getHretweets() {
        return hretweets;
    }

    public long getHtweets() {
        return htweets;
    }

    public double getHexposure() {
        return hexposure;
    }

    public double getHlink() {
        return hlink;
    }

    public double getHphotos() {
        return hphotos;
    }

    public double getHmentions() {
        return hmentions;
    }

    public void setHtag(String htag) {
        this.htag = htag;
    }

    public void setHcolor(int hcolor) {
        this.hcolor = hcolor;
    }

    public void setHretweets(long hretweets) {
        this.hretweets = hretweets;
    }

    public void setHtweets(long htweets) {
        this.htweets = htweets;
    }

    public void setHexposure(double hexposure) {
        this.hexposure = hexposure;
    }

    public void setHlink(double hlink) {
        this.hlink = hlink;
    }

    public void setHphotos(double hphotos) {
        this.hphotos = hphotos;
    }

    public void setHmentions(double hmentions) {
        this.hmentions = hmentions;
    }
}
