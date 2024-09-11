package com.example.myapplication;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private SeekBar zoomSeekBar;
    private SeekBar brightnessSeekBar;
    private AudioManager audioManager;
    private VolumeReceiver volumeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        zoomSeekBar = findViewById(R.id.zoomSeekBar);
        brightnessSeekBar = findViewById(R.id.brightnessSeekBar);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        volumeReceiver = new VolumeReceiver();


        IntentFilter filter = new IntentFilter();
        filter.addAction("android.media.VOLUME_CHANGED_ACTION");
        registerReceiver(volumeReceiver, filter);


        textView.setText("Current volume: " + audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));


        zoomSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float scale = 1 + progress / 100f;
                textView.setScaleX(scale);
                textView.setScaleY(scale);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // do nothing
            }
        });


        brightnessSeekBar.setMax(255);
        try {

            int brightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
            brightnessSeekBar.setProgress(brightness);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(volumeReceiver);
    }


    private class VolumeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();


            if (action.equals("android.media.VOLUME_CHANGED_ACTION")) {

                int keyCode = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);


                if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
                    WindowManager.LayoutParams params = getWindow().getAttributes();
                    params.screenBrightness += 0.1f;
                    getWindow().setAttributes(params);
                    brightnessSeekBar.setProgress((int) (params.screenBrightness * 255));
                }


                if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
                    WindowManager.LayoutParams params = getWindow().getAttributes();
                    params.screenBrightness -= 0.1f;
                    getWindow().setAttributes(params);
                    brightnessSeekBar.setProgress((int) (params.screenBrightness * 255));
                }


                textView.setText("Current volume: " + audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            }
        }
    }
}
