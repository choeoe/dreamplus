package com.example.chinese_learning;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ActionPicturesAdapter extends RecyclerView.Adapter<ActionPicturesAdapter.ViewHolder> {
    private List<String> mPicturesList;
    class ViewHolder extends RecyclerView.ViewHolder{
       private ImageView picture;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.picture_holder);
        }
    }
    public ActionPicturesAdapter(List<String> PL){
        mPicturesList = PL;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_holder,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String url = mPicturesList.get(i);
        Glide.with(App.getContext()).load(Uri.parse(url)).into(viewHolder.picture);
    }

    @Override
    public int getItemCount() {
        return mPicturesList.size();
    }
}
