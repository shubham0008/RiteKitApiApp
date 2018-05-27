package com.ritekittaskapp.appkca.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class InfluencersResourse {


    @SerializedName("result")
    private Boolean results;
    @SerializedName("code")
    private long code;
    @SerializedName("message")
    private String message;
    @SerializedName("hashtag")
    private String hashtag;
    @SerializedName("influencers")
    private List<InfluencerModel> influencerList = new ArrayList<>();


    public Boolean getResults() {
        return results;
    }

    public void setResults(Boolean results) {
        this.results = results;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public List<InfluencerModel> getinfluencerList() {
        return influencerList;
    }

    public void setinfluencerList(List<InfluencerModel> influencerList) {
        this.influencerList = influencerList;
    }
}
