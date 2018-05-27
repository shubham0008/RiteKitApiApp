package com.ritekittaskapp.appkca;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.ritekittaskapp.appkca.Adapters.HashtagListAdapter;
import com.ritekittaskapp.appkca.Model.HashtagModel;
import com.ritekittaskapp.appkca.Model.HashtagResourse;
import com.ritekittaskapp.appkca.Utility.ApiClient;
import com.ritekittaskapp.appkca.Utility.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ritekittaskapp.appkca.StatisticsDisplayActivity.isNetConnected;

public class MainActivity extends AppCompatActivity {

    private static final String TAG1 = "Error in API";
    private static final String TAG = "State Log";
    private ApiInterface apiService;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.tag_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiService = ApiClient.getClient().create(ApiInterface.class);

        getHashtags();
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isNetConnected(getApplicationContext()))
                {    getHashtags();
                    Toast.makeText(getApplicationContext(),"Connected to Internet",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not Connected to Internet",Toast.LENGTH_SHORT).show();

                }


            }
        });
        if (isNetConnected(getApplicationContext()))
        {
            Toast.makeText(getApplicationContext(),"Connected to Internet",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Not Connected to Internet",Toast.LENGTH_SHORT).show();

        }


    }

    private void getHashtags() {
//Function for getting hashtags

        Call<HashtagResourse> call = apiService.getTrendingHashtags();
        call.enqueue(new Callback<HashtagResourse>() {
            @Override
            public void onResponse(Call<HashtagResourse> call, Response<HashtagResourse> response) {
                List<HashtagModel> hashtaglist = response.body().getTags();
                recyclerView.setAdapter(new HashtagListAdapter(hashtaglist, getApplicationContext()));
                swipeRefreshLayout.setRefreshing(false);
                Log.d(TAG, "Number of HashtagModels received: " + hashtaglist.size());
            }

            @Override
            public void onFailure(Call<HashtagResourse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG1, t.toString());
            }
        });
    }
}
