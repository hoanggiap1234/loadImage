package com.example.loadlistimage;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class FragmentListSound extends Fragment {
    private Button btnSettime;
    private Button btnPausePress;
    private Button btnSetting;
    private RecyclerView mRecyclerView;
    private ImageAdapter mImageAdapter;
    private List<Image> mListImage;
    private MediaPlayer mediaPlayer;

    public FragmentListSound(List<Image> mListImage, MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.mListImage =mListImage;
        mListImage.add(new Image(R.drawable.sound_birds_song, R.raw.sound_birds_song));
        mListImage.add(new Image(R.drawable.sound_shower, R.raw.sound_shower));
        mListImage.add(new Image(R.drawable.sound_stream, R.raw.sound_stream));
        mListImage.add(new Image(R.drawable.sound_washer, R.raw.sound_washer));
        mListImage.add(new Image(R.drawable.sound_tv_noise, R.raw.sound_tv_noise));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_list_sound, container, false);

        mRecyclerView = rootView.findViewById(R.id.rcv);
        btnSettime = rootView.findViewById(R.id.btn_barSetTime);
        btnPausePress = rootView.findViewById(R.id.btn_pausePress);
        btnSetting = rootView.findViewById(R.id.btn_setting);

        btnSettime.setVisibility(View.INVISIBLE);
//        btnPausePress.setVisibility(View.INVISIBLE);
        btnSetting.setVisibility(View.INVISIBLE);

        mImageAdapter = new ImageAdapter(mListImage, mediaPlayer);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setAdapter(mImageAdapter);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        btnPausePress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }

                Toast.makeText(getActivity(), ""+mediaPlayer.isPlaying(), Toast.LENGTH_SHORT).show();
            }
        });

//                if (mediaPlayer.isPlaying()) {
//                    btnSettime.setVisibility(View.VISIBLE);
//                    btnPausePress.setVisibility(View.VISIBLE);
//                    btnSetting.setVisibility(View.VISIBLE);
//                } else {
//                    btnSettime.setVisibility(View.INVISIBLE);
//                    btnPausePress.setVisibility(View.INVISIBLE);
//                    btnSetting.setVisibility(View.INVISIBLE);
//
//                }

        return rootView;
    }

}
