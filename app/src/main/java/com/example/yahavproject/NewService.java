package com.example.yahavproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import androidx.annotation.Nullable;

public class NewService extends Service {
    /**this service plays the default ringtone on repeat
     */
    private MediaPlayer player;

    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create( this, Settings.System.DEFAULT_RINGTONE_URI );

        player.setLooping( true );


        player.start();

        // returns the status
        // of the program
        return START_STICKY;
    }

    @Override

    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
