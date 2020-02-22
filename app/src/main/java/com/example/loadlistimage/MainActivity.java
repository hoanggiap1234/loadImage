package com.example.loadlistimage;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private List<Image> mListImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        mListImages = new ArrayList<>();
        FragmentListSound fragment = new FragmentListSound(mListImages, mediaPlayer);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frm, fragment, "fragment")
                .commit();
    }

}
