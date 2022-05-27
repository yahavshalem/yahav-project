package com.example.yahavproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class NewerService extends NewService {
    /**this service plays an audio file when initiated
     */
    private MediaPlayer player;

    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create( this, R.raw.call );

        player.setLooping( false );


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
