package com.example.test01;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FullActivity extends AppCompatActivity {
    public void addLog(String paramString) {
        Intent intent = new Intent();
        intent.setAction("logMessage");
        intent.putExtra("sLine", paramString);
        sendBroadcast(intent);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_full);
        setTitle("Full Screen Activity");
        addLog("FullActivity.onCreate() ...");
    }

    protected void onDestroy() {
        super.onDestroy();
        addLog("FullActivity.onDestroy() ...");
    }

    protected void onPause() {
        super.onPause();
        addLog("FullActivity.onPause() ...");
    }

    protected void onRestart() {
        super.onRestart();
        addLog("FullActivity.onRestart( ...");
    }

    protected void onResume() {
        super.onResume();
        addLog("FullActivity.onResume() ...");
    }

    protected void onStart() {
        super.onStart();
        addLog("FullActivity.onStart() ...");
    }

    protected void onStop() {
        super.onStop();
        addLog("FullActivity.onStop() ...");
    }
}
