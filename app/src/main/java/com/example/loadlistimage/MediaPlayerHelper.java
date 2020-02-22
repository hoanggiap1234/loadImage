package com.example.loadlistimage;

import android.content.Context;
import android.media.MediaPlayer;


public class MediaPlayerHelper {
private MediaPlayer mediaPlayer = new MediaPlayer();

    private static MediaPlayerHelper instance = new MediaPlayerHelper();

    public static MediaPlayerHelper getInstance() {

        return instance;
    }
    public MediaPlayer getMediaPlayer(){
        return mediaPlayer;
    }

}