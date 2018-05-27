package com.ritekittaskapp.appkca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
    private static final String API_KEY ="95bb80b51c9be00c9134e48374ad4b6ec8460f9911db" ;
    private static final String TAG ="API response" ;
    private List<InfluencerModel> influencerList;
    ApiInterface apiService,mpi;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_statistics_display);
        apiService= ApiClient.getClient().create(ApiInterface.class);
        String tag = getIntent().getExtras().get("tag").toString();

       recyclerView = (RecyclerView) findViewById(R.id.influenncer_recylcer_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        Log.e("This is hastag call",tag);
        getStatistics(tag);
        getInfluencers(tag);
    }


    void getInfluencers(String tag)
    {
        Call<InfluencersResourse> call = apiService.getInfluencer(tag,API_KEY);
        call.enqueue(new Callback<InfluencersResourse>() {
            @Override
            public void onResponse(Call<InfluencersResourse>call, Response<InfluencersResourse> response) {
                influencerList = response.body().getinfluencerList();

              recyclerView.setAdapter(new InfluencerAdapter(influencerList, getApplicationContext()));
               Log.d(TAG, influencerList.get(5).getIname()+" ");
            }

            @Override
            public void onFailure(Call<InfluencersResourse>call, Throwable t) {
                // Log error here since request failed
              Log.e(TAG, t.toString());
            }
        });
    }

    void getStatistics(String tag)
    {

        Call<StatisticsResourse> ball = apiService.getStats(tag,API_KEY);
        ball.enqueue(new Callback<StatisticsResourse>() {
            @Override
            public void onResponse(Call<StatisticsResourse>call, Response<StatisticsResourse> response) {
                HashtagModel stats = response.body().getStats().get(0);

                Log.d(TAG, stats.getHtag()+stats.getHlink()+"");
            }

            @Override
            public void onFailure(Call<StatisticsResourse> call, Throwable t) {

            }

        });
    }
}
