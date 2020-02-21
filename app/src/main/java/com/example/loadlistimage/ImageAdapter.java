package com.example.loadlistimage;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.gresse.hugo.vumeterlibrary.VuMeterView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private List<Image> listImage;
    private MediaPlayer mediaPlayer;
    private int count = 0;

    public ImageAdapter(List<Image> listImage) {
        this.listImage = listImage;
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
                count++;
                playSound(v, position);
                holder.meterView.setVisibility(View.VISIBLE);
                holder.mPause.setVisibility(View.VISIBLE);
                holder.mPlay.setVisibility(View.INVISIBLE);
                holder.btnSetTime.setVisibility(View.VISIBLE);
                holder.btnPausePress.setVisibility(View.VISIBLE);
                holder.btnSetting.setVisibility(View.VISIBLE);
                if (count > 1) {
                    Toast.makeText(v.getContext(), ""+count, Toast.LENGTH_SHORT).show();
                    stopSound(v,position);
                    holder.meterView.setVisibility(View.INVISIBLE);
                    holder.mPause.setVisibility(View.INVISIBLE);
                    holder.mPlay.setVisibility(View.VISIBLE);
                    count=0;
                }
            }
        });
    }

    public void playSound(View v, int position) {
        int n = listImage.get(position).imageSound;
        mediaPlayer = MediaPlayer.create(v.getContext(), n);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void stopSound(View v, int position) {
        int n = listImage.get(position).imageSound;
        mediaPlayer = MediaPlayer.create(v.getContext(), n);
        mediaPlayer.stop();

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
Button btnSetTime;
Button btnPausePress;
Button btnSetting;


        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img);
            mPlay = itemView.findViewById(R.id.imgPlay);
            mPause = itemView.findViewById(R.id.imgPause);
            mPause.setVisibility(View.INVISIBLE);
            meterView = itemView.findViewById(R.id.vumater);
            meterView.setVisibility(View.INVISIBLE);
            btnSetTime = itemView.findViewById(R.id.btn_barSetTime);
            btnSetTime.setVisibility(View.INVISIBLE);
            btnPausePress=itemView.findViewById(R.id.btn_pausePress);
            btnPausePress.setVisibility(View.INVISIBLE);
            btnSetting.setVisibility(View.INVISIBLE);


        }

        public void setVisiblity() {
            meterView.setVisibility(View.INVISIBLE);
            mPause.setVisibility(View.INVISIBLE);
            mPlay.setVisibility(View.VISIBLE);
        }
    }
}
