package com.ritekittaskapp.appkca;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ritekittaskapp.appkca.Adapters.InfluencerAdapter;
import com.ritekittaskapp.appkca.Model.HashtagModel;
import com.ritekittaskapp.appkca.Model.InfluencerModel;
import com.ritekittaskapp.appkca.Model.InfluencersResourse;
import com.ritekittaskapp.appkca.Model.StatisticsResourse;
import com.ritekittaskapp.appkca.Utility.ApiClient;
import com.ritekittaskapp.appkca.Utility.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticsDisplayActivity extends AppCompatActivity {
    private static final String API_KEY = "95bb80b51c9be00c9134e48374ad4b6ec8460f9911db";
    private static final String TAG = "API response";
    private List<InfluencerModel> influencerList;
    TextView hTitle, hTweets, hRetweets, hViews, hMentions;
    ApiInterface apiService, mpi;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_statistics_display);
        apiService = ApiClient.getClient().create(ApiInterface.class);

        //Intent Filter
        String tag = getIntent().getExtras().get("tag").toString();

        //Getting Views from Layout
        hTitle = findViewById(R.id.hasttag_title);
        hTweets = findViewById(R.id.h_tweets);
        hMentions = findViewById(R.id.h_mentions);
        hRetweets = findViewById(R.id.h_retweets);
        hViews = findViewById(R.id.h_views);


        recyclerView = (RecyclerView) findViewById(R.id.influenncer_recylcer_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        Log.e("This is hastag call", tag);
        getStatistics(tag);
        getInfluencers(tag);

        //Net Connection Issue
        if (isNetConnected(getApplicationContext())) {
            Toast.makeText(getApplicationContext(), "Connected to Internet", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Not Connected to Internet", Toast.LENGTH_SHORT).show();

        }


    }


    void getInfluencers(String tag) {
        //Function for Getting Influencers
        Call<InfluencersResourse> call = apiService.getInfluencer(tag, API_KEY);
        call.enqueue(new Callback<InfluencersResourse>() {
            @Override
            public void onResponse(Call<InfluencersResourse> call, Response<InfluencersResourse> response) {
                influencerList = response.body().getinfluencerList();

                recyclerView.setAdapter(new InfluencerAdapter(influencerList, getApplicationContext()));
                Log.d(TAG, influencerList.get(5).getIname() + " ");
            }

            @Override
            public void onFailure(Call<InfluencersResourse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    void getStatistics(String tag) {
//Function For Hashtag Stats
        Call<StatisticsResourse> ball = apiService.getStats(tag, API_KEY);
        ball.enqueue(new Callback<StatisticsResourse>() {
            @Override
            public void onResponse(Call<StatisticsResourse> call, Response<StatisticsResourse> response) {
                HashtagModel stats = response.body().getStats().get(0);
                hTitle.setText("#" + stats.getHtag());
                hTweets.setText(" " + stats.getHtweets() + " Tweets");
                hViews.setText(" " + (int) stats.getHexposure());
                hRetweets.setText(" " + stats.getHretweets() + " Retweets");
                hMentions.setText(" " + stats.getHmentions());
                Log.d(TAG, stats.getHtag() + stats.getHlink() + "");
            }

            @Override
            public void onFailure(Call<StatisticsResourse> call, Throwable t) {

            }

        });
    }

    public static boolean isNetConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
