package com.ritekittaskapp.appkca.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StatisticsResourse {

    @SerializedName("result")
    private Boolean results;
    @SerializedName("code")
    private long code;
    @SerializedName("hashtags")
    private List<String> tags = new ArrayList<>();
    @SerializedName("message")
    private String message;
    @SerializedName("stats")
    private List<HashtagModel> stats = new ArrayList<>();
    @SerializedName("color")
    private List<String> colors = new ArrayList<>();

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HashtagModel> getStats() {
        return stats;
    }

    public void setStats(List<HashtagModel> stats) {
        this.stats = stats;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }
}
