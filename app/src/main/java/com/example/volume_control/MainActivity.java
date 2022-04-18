package com.example.volume_control;

import android.Manifest;
import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
AudioManager am;
SeekBar alarm,music,ringtone,system,voice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        am=(AudioManager)getSystemService( Context.AUDIO_SERVICE );
        alarm=findViewById( R.id.mainseekbar1 );
        music=findViewById( R.id.mainseekbar2 );
        ringtone=findViewById( R.id.mainseekbar3 );
        system=findViewById( R.id.mainseekbar4 );
        voice=findViewById( R.id.mainseekbar5 );
        control( alarm,AudioManager.STREAM_ALARM );
        control( music,AudioManager.STREAM_MUSIC );
        control( ringtone,AudioManager.STREAM_RING );
        control( system,AudioManager.STREAM_SYSTEM );
        control( voice,AudioManager.STREAM_VOICE_CALL );
       // Manifest.permission.MODIFY_AUDIO_SETTINGS

    }
    public void control(SeekBar seekBar, final int stream)
    {
        seekBar.setMax(am.getStreamMaxVolume( stream ));
        seekBar.setProgress( am.getStreamVolume( stream ) );
        seekBar.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               am.setStreamVolume( stream,progress,AudioManager.FLAG_PLAY_SOUND );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        } );
    }
}
