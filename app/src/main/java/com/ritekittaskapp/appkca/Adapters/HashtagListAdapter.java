package com.ritekittaskapp.appkca.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ritekittaskapp.appkca.Model.HashtagModel;
import com.ritekittaskapp.appkca.R;
import com.ritekittaskapp.appkca.StatisticsDisplayActivity;

import java.util.List;


public class HashtagListAdapter extends RecyclerView.Adapter<HashtagListAdapter.TagViewHolder> {

    private List<HashtagModel> tags;
    private Context context;


    public static class TagViewHolder extends RecyclerView.ViewHolder {
        LinearLayout tagsLayout;
        TextView tagTitle;
        TextView views;
        ImageView trending;
        TextView rating;


        public TagViewHolder(View v) {
            super(v);
            tagsLayout = (LinearLayout) v.findViewById(R.id.tags_layout);
            tagTitle = (TextView) v.findViewById(R.id.tag_name);
            views = (TextView) v.findViewById(R.id.tag_views);
            trending = (ImageView) v.findViewById(R.id.trending);

        }
    }

    public HashtagListAdapter(List<HashtagModel> tags, Context context) {
        this.tags = tags;
        this.context = context;
    }

    @Override
    public HashtagListAdapter.TagViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hashtag_row_layout, parent, false);
        return new TagViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TagViewHolder holder, final int position) {

        holder.tagTitle.setText("#"+tags.get(position).getHtag());
        holder.views.setText(tags.get(position).getHexposure()+"");
        holder.tagsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(new Intent(context, StatisticsDisplayActivity.class).putExtra("tag",tags.get(position).getHtag()).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}