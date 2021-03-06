package com.example.loadlistimage;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.List;

import io.gresse.hugo.vumeterlibrary.VuMeterView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private List<Image> listImage;
    private MediaPlayer mediaPlayer;


    public ImageAdapter(List<Image> listImage, MediaPlayer mediaPlayer) {
        this.listImage = listImage;
        this.mediaPlayer = mediaPlayer;


    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());
        View view = mLayoutInflater.inflate(R.layout.image_view, parent, false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {

//        holder.mImageView.setImageResource(listImage.get(position).imageId);
        Glide.with(holder.itemView).load(listImage.get(position).imageId).into(holder.mImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.meterView.setVisibility(View.VISIBLE);
                holder.mPause.setVisibility(View.VISIBLE);
                holder.mPlay.setVisibility(View.INVISIBLE);

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    holder.meterView.setVisibility(View.INVISIBLE);
                    holder.mPause.setVisibility(View.INVISIBLE);
                    holder.mPlay.setVisibility(View.VISIBLE);
                } else {

                    String path = "android.resource://com.example.loadlistimage"+listImage.get(position).imageSound;
                    Uri uri = Uri.parse(path);

                    try {
                        mediaPlayer.setDataSource(v.getContext(),uri);
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
//                    setMediaPlayer(mediaPlayer);


                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return listImage.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        ImageView mPlay;
        ImageView mPause;
        VuMeterView meterView;


        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img);
            mPlay = itemView.findViewById(R.id.imgPlay);
            mPause = itemView.findViewById(R.id.imgPause);
            mPause.setVisibility(View.INVISIBLE);
            meterView = itemView.findViewById(R.id.vumater);
            meterView.setVisibility(View.INVISIBLE);
        }
    }


}
