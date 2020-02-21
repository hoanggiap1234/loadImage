package com.example.loadlistimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView mRecyclerView;
ImageAdapter mImageAdapter;
    Button mSetTime;
    Button mPausePress;
    Button mSetting;
private List<Image> mListImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListImages = new ArrayList<>();
        mListImages.add(new Image(R.drawable.sound_birds_song,R.raw.sound_birds_song));
        mListImages.add(new Image(R.drawable.sound_shower,R.raw.sound_shower));
        mListImages.add(new Image(R.drawable.sound_stream,R.raw.sound_stream));
        mListImages.add(new Image(R.drawable.sound_washer,R.raw.sound_washer));
        mListImages.add(new Image(R.drawable.sound_tv_noise,R.raw.sound_tv_noise));

        mSetTime = findViewById(R.id.btn_barSetTime);
        mSetTime.setVisibility(View.INVISIBLE);
        mPausePress = findViewById(R.id.btn_pausePress);
        mPausePress.setVisibility(View.INVISIBLE);
        mImageAdapter = new ImageAdapter(mListImages);
        mPausePress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetTime.setVisibility(View.VISIBLE);
                mPausePress.setVisibility(View.VISIBLE);

//                        mImageAdapter.pauseSound(v);
                        mPausePress.setVisibility(View.INVISIBLE);
                        mSetTime.setVisibility(View.INVISIBLE);
                        mSetting.setVisibility(View.INVISIBLE);

                mSetting.setVisibility(View.VISIBLE);
            }
        });
        mSetting = findViewById(R.id.btn_setting);
        mSetting.setVisibility(View.INVISIBLE);
        mRecyclerView = findViewById(R.id.rcv);


        LinearLayoutManager mLinearLayout = new LinearLayoutManager(getApplication());
        mRecyclerView.setAdapter(mImageAdapter);
        mRecyclerView.setLayoutManager(mLinearLayout);

    }

}
