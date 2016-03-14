package in.doomers.rahul.batterystatus;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
    MyReceiver myReceiver;
    IntentFilter filter;
    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this,"onbackpressed",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter = new IntentFilter("in.doomers.rahul.batterystatus");
        //batterychanged
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        //
        filter.addAction(Intent.ACTION_BATTERY_OKAY);
        //
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        //
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        //
        filter.addAction(Intent.ACTION_BOOT_COMPLETED);
        //
        filter.addAction(Intent.ACTION_DEVICE_STORAGE_LOW);
        //
        filter.addAction(Intent.ACTION_DEVICE_STORAGE_OK);
        //
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        //
        filter.addAction(AudioManager.ACTION_AUDIO_BECOMING_NOISY);

         myReceiver = new MyReceiver();
        registerReceiver(myReceiver, filter);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        registerReceiver(myReceiver, filter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(myReceiver);
        super.onPause();
    }




    }

