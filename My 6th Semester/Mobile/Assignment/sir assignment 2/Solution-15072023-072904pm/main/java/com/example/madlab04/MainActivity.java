package com.example.madlab04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver;

    Intent intentDialogue;

    Intent intentFull;

    static TextView txtLog;

    public static void addLog(String paramString) {
        TextView textView = txtLog;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(txtLog.getText().toString());
        stringBuilder.append("\n");
        stringBuilder.append(paramString);
        textView.setText(stringBuilder.toString());
    }

    public void onBtnDialogue(View ParamView)
    { startActivity(intentDialogue); }

    public void onBtnFull(View ParamView)
    { startActivity(intentFull); }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_main);
        txtLog = (TextView)findViewById(R.id.textview);
        txtLog.setMovementMethod(new ScrollingMovementMethod());
        intentDialogue = new Intent(getApplicationContext(), DialogueActivity.class);
        intentFull = new Intent(getApplicationContext(), FullActivity.class);
        broadcastReceiver = new BroadcastReceiver() {

            public void onReceive(Context param1Context, Intent param1Intent)
            { MainActivity.addLog(param1Intent.getStringExtra("sLine")); }
        };
        IntentFilter intentFilter = new IntentFilter("logMessage");
        registerReceiver(broadcastReceiver, intentFilter);
        addLog("MainActivity.onCreate() ...");
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
        addLog("MainActivity.onDestroy() ...");
    }

    protected void onPause() {
        super.onPause();
        addLog("MainActivity.onPause() ...");
    }

    protected void onRestart() {
        super.onRestart();
        addLog("MainActivity.onRestart( ...");
    }

    protected void onResume() {
        super.onResume();
        addLog("MainActivity.onResume() ...");
    }

    protected void onStart() {
        super.onStart();
        addLog("MainActivity.onStart() ...");
    }

    protected void onStop() {
        super.onStop();
        addLog("MainActivity.onStop() ...");
    }
}
