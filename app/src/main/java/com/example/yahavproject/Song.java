package com.example.yahavproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaRecorder;

import java.io.IOException;

public class Song {
    private String name;
    private Bitmap albumCover;
    private MediaPlayer audio;
    private boolean boostatus;
    private String status;



    public  Song(String name, Bitmap albumCover, MediaPlayer audio){
        this.name = name;
        this.albumCover = albumCover;
        this.audio = audio;
        this.boostatus = false;
        this.status = "not playing";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isBoostatus() {
        return boostatus;
    }

    public void setName(boolean v)
    {this.boostatus = v;}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Bitmap getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(Bitmap albumCover) {
        this.albumCover = albumCover;
    }

    public MediaPlayer getAudio() {
        return audio;
    }

    public void setAudio(MediaPlayer audio) {
        this.audio = audio;
    }
}
