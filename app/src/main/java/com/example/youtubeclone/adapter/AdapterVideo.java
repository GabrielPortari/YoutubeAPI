package com.example.youtubeclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeclone.R;
import com.example.youtubeclone.model.Video;

import java.util.ArrayList;
import java.util.List;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.MyViewHolder> {
    private List<Video> listaVideo = new ArrayList<>();
    private Context context;

    public AdapterVideo(List<Video> listaVideo, Context context) {
        this.listaVideo = listaVideo;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_recyclerview, parent, false);
        return new AdapterVideo.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaVideo.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textTitulo, textDescricao, textData;
        ImageView imageThumb;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitulo = itemView.findViewById(R.id.textTitulo);
            imageThumb = itemView.findViewById(R.id.imageViewThumb);
        }
    }
}
