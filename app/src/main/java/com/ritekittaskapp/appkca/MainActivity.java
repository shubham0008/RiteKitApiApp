package com.ritekittaskapp.appkca;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

   // private static final String API_KEY ="95bb80b51c9be00c9134e48374ad4b6ec8460f9911db" ;
    private static final String TAG ="ABC" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.tag_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<HashtagResourse> call = apiService.getTrendingHashtags();
        call.enqueue(new Callback<HashtagResourse>() {
            @Override
            public void onResponse(Call<HashtagResourse>call, Response<HashtagResourse> response) {
                List <HashtagModel> hashtaglist = response.body().getTags();
                recyclerView.setAdapter(new HashtagListAdapter(hashtaglist, getApplicationContext()));


                Toast.makeText(getApplicationContext(),hashtaglist.get(0).getHtag(),Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Number of HashtagModels received: " + hashtaglist.size());
            }
            @Override
            public void onFailure(Call<HashtagResourse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });


    }
}
