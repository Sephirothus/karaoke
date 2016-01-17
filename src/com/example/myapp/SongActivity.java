package com.example.myapp;

import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by konst on 15.01.16.
 */
public class SongActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);

        String[] songs = getResources().getStringArray(R.array.songs_list);
        String[] lyrics = getResources().getStringArray(R.array.lyrics_list);

        Bundle extras = getIntent().getExtras();
        final int songId = extras.getInt("songId");

        ((TextView) findViewById(R.id.songName)).setText(songs[songId]);
        ((TextView) findViewById(R.id.lyrics)).setText(lyrics[songId]);

        Button play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String songName = "song" + songId;
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(songName, "raw", getPackageName()));
                mediaPlayer.start();
            }
        });
    }
}
