package com.example.customseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar sbDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomSeekBar bar = (CustomSeekBar) findViewById(R.id.seekBar);

        bar.setDots(new int[] {25, 50, 75});
        bar.setDotsDrawable(R.drawable.dot);

        sbDistance = (SeekBar) findViewById(R.id.sb_distance);
        sbDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            private int progress = 0;
            private boolean fromUser = true;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("MainActivity", "onProgressChanged pos: " + i + " fromUser: " + b);
                progress = i;
                fromUser = b;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("MainActivity", "onStopTrackingTouch pos: " + progress + " fromUser: " + fromUser);
                if (fromUser) {
                    double extras = progress / 15.0;
                    Log.d("MainActivity", "onStopTrackingTouch extras: " + extras);
                    int increments = (int) Math.round(extras);
                    Log.d("MainActivity", "onStopTrackingTouch increments: " + increments);
                    if (progress < 45) {
                        sbDistance.setProgress(15 * increments);
                    }
                }
            }
        });
    }
}
