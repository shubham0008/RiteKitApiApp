package com.ritekittaskapp.appkca.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ritekittaskapp.appkca.Model.InfluencerModel;
import com.ritekittaskapp.appkca.R;

import java.util.List;

public class InfluencerAdapter extends RecyclerView.Adapter<InfluencerAdapter.InfluencerViewHolder> {

    private List<InfluencerModel> influencers;
    private Context context;


    public static class InfluencerViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView photo;
        TextView tweets;


        public InfluencerViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.i_name);
            photo = (ImageView) v.findViewById(R.id.i_photo);
            tweets = (TextView) v.findViewById(R.id.i_tweets);

        }
    }

    public InfluencerAdapter(List<InfluencerModel> influencers, Context context) {
        this.influencers = influencers;
        this.context = context;
    }

    @Override
    public InfluencerAdapter.InfluencerViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.influencer_layout, parent, false);
        return new InfluencerAdapter.InfluencerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(InfluencerAdapter.InfluencerViewHolder holder, final int position) {
        holder.name.setText(influencers.get(position).getIname().toString());
        holder.tweets.setText(influencers.get(position).getIfollowers()+"");


    }

    @Override
    public int getItemCount() {
        return influencers.size();
    }
}

