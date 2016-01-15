package com.example.myapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

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
                String path = "R.raw." + songId + ".mp3";
                //getResources().getIdentifier(path, null, getPackageName());
                //MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(path, null, getPackageName()));
                //mediaPlayer.start();
            }
        });
    }
}
