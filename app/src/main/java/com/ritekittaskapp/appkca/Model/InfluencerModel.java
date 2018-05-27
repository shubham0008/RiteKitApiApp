package com.ritekittaskapp.appkca.Model;

import com.google.gson.annotations.SerializedName;

public class InfluencerModel {

    @SerializedName("username")
    private String iname;
    @SerializedName("photo")
    private String iphotoUrl;
    @SerializedName("followers")
    private long ifollowers;

    public InfluencerModel(String iname, String iphotoUrl, long ifollowers) {
        this.iname = iname;
        this.iphotoUrl = iphotoUrl;
        this.ifollowers = ifollowers;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIphotoUrl() {
        return iphotoUrl;
    }

    public void setIphotoUrl(String iphotoUrl) {
        this.iphotoUrl = iphotoUrl;
    }

    public long getIfollowers() {
        return ifollowers;
    }

    public void setIfollowers(long ifollowers) {
        this.ifollowers = ifollowers;
    }
}
