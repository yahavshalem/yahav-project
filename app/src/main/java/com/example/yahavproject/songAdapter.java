package com.example.yahavproject;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class songAdapter extends ArrayAdapter <Song> {
    ImageView ibalbumcover;
    TextView tvname;
    TextView status;
    ArrayList<Song> songArrayList = new ArrayList<>();

    public songAdapter(Context context, int textViewResourceId, ArrayList<Song> objects) {
        super(context, textViewResourceId, objects);
        this.songArrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater =  (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.song_layout, null);
        tvname = (TextView)v.findViewById(R.id.tvname);
        ibalbumcover = (ImageView)v.findViewById(R.id.ibalbumcover);
        status = (TextView)v.findViewById(R.id.status);

        Song temp = songArrayList.get(position);

        ibalbumcover.setImageBitmap(temp.getAlbumCover());
        tvname.setText(temp.getName());
        status.setText(temp.getStatus());
        v.setTag(R.id.tvname, temp);
        v.setTag(R.id.status, status);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Song position = (Song) v.getTag(R.id.tvname);
                TextView t = (TextView) v.getTag(R.id.status);
                if(position.isBoostatus() == false)
                {
                    position.getAudio().start();
                    position.setName(true);
                    t.setText("playing");
                    position.getAudio().setLooping(true);

                }
                else
                {
                    position.setName(false);
                    position.getAudio().pause();
                    t.setText("not playing");

                }

            }
        });
        return v;

    }
}
