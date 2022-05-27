package com.example.yahavproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class ChooseMusic_Activity extends AppCompatActivity {
    ListView lv_songs;
    ArrayList<Song> songList;
    songAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_music);

        lv_songs = (ListView) findViewById(R.id.lv_songs);

        Bitmap icon_one = BitmapFactory.decodeResource(getResources(), R.drawable.elevator_music_icon_one);
        Bitmap icon_two = BitmapFactory.decodeResource(getResources(),R.drawable.elevator_music_icon_two);
        Bitmap maccabi = BitmapFactory.decodeResource(getResources(),R.drawable.maccabi);

        MediaPlayer elevator_music1 = MediaPlayer.create(getApplicationContext(), R.raw.elevator_music1);
        MediaPlayer elevator_music2 = MediaPlayer.create(getApplicationContext(), R.raw.elevator_music2);
        MediaPlayer macabi = MediaPlayer.create(getApplicationContext(), R.raw.macabi);

        Song song1 = new Song("Local Forecast - Slower", icon_one, elevator_music1);
        Song song2 = new Song("Bossa Nova", icon_two, elevator_music2);
        Song song3 = new Song("Maccabi", maccabi, macabi);

        songList = new ArrayList<Song>();
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);

        songAdapter = new songAdapter(getApplicationContext(), R.layout.activity_choose_music, songList);

        lv_songs.setAdapter(songAdapter);
    }
}