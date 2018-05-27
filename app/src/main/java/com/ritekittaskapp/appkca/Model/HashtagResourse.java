package com.ritekittaskapp.appkca.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HashtagResourse {

    @SerializedName("result")
    private Boolean results;
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private long code;
    @SerializedName("tags")
    private List<HashtagModel> tags = new ArrayList<>();


    public Boolean getResults() {
        return results;
    }

    public void setResults(Boolean results) {
        this.results = results;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public List<HashtagModel> getTags() {
        return tags;
    }

    public void setTags(List<HashtagModel> tags) {
        this.tags = tags;
    }
}
