package com.example.loadlistimage;

import android.content.Context;
import android.media.MediaPlayer;


public class MediaPlayerHelper {

    static MediaPlayer ref = new MediaPlayer();
    private static MediaPlayerHelper ourInstance = new MediaPlayerHelper();
    private Context appContext;
    private int position;

    public int getPosition() {
        return position;
    }

    public MediaPlayerHelper setPosition(int position) {
        this.position = position;
        return this;
    }

    public static Context get() {
        return getInstance().getContext();
    }

    public static synchronized MediaPlayerHelper getInstance() {
        return ourInstance;
    }

    public void init(Context context) {
        if (appContext == null) {
            this.appContext = context;
        }
    }

    private Context getContext() {
        return appContext;
    }

    public static MediaPlayer getSingletonMedia() {

        if (ref == null)
        // it's ok, we can call this constructor

        ref = MediaPlayer.create(get(),R.raw.sound_birds_song);

        return ref;
    }


}