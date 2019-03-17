package com.example.chinese_learning;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ActionsAdapter extends RecyclerView.Adapter<ActionsAdapter.ViewHolder> {
    List<Actions> mActionsList;
    class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView pictureView;
        ImageView portrait;
        TextView author;
        TextView mContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pictureView = itemView.findViewById(R.id.action_pictures);
            author = itemView.findViewById(R.id.author);
            mContent = itemView.findViewById(R.id.action_content);
            portrait = itemView.findViewById(R.id.action_portrait);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.action_item,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public ActionsAdapter(List<Actions> actionsList){
        mActionsList = actionsList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Actions actions = mActionsList.get(i);
        ActionPicturesAdapter picturesAdapter = new ActionPicturesAdapter(actions.getPictureList());
        LinearLayoutManager manager = new LinearLayoutManager(App.getContext());
        viewHolder.pictureView.setLayoutManager(manager);
        viewHolder.pictureView.setAdapter(picturesAdapter);
        viewHolder.mContent.setText(actions.getContent());
        viewHolder.author.setText((actions.getUserInfo().getName()));
        Glide.with(App.getContext()).load(actions.getUserInfo().getPortraitUri()).into(viewHolder.portrait);
    }

    @Override
    public int getItemCount() {
        return mActionsList.size();
    }
}
