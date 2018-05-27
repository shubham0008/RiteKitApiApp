package com.ritekittaskapp.appkca.Utility;

import com.ritekittaskapp.appkca.Model.HashtagResourse;
import com.ritekittaskapp.appkca.Model.InfluencersResourse;
import com.ritekittaskapp.appkca.Model.StatisticsResourse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

        @GET("v1/search/trending?green=1&latin=1&client_id=95bb80b51c9be00c9134e48374ad4b6ec8460f9911db")
        Call<HashtagResourse> getTrendingHashtags();

        @GET("v1/influencers/hashtag/{id}")
        Call<InfluencersResourse> getInfluencer(@Path("id") String id, @Query("client_id") String apiKey);

        @GET("v1/stats/multiple-hashtags")
        Call<StatisticsResourse> getStats(@Query("tags") String tag,@Query("client_id") String key);



}
