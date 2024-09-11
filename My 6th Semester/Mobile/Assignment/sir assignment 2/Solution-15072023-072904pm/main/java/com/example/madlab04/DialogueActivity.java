package com.example.madlab04;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DialogueActivity extends AppCompatActivity {
    public void addLog(String paramString) {
        Intent intent = new Intent();
        intent.setAction("logMessage");
        intent.putExtra("sLine", paramString);
        sendBroadcast(intent);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_dialogue);
        setTitle("Dialogue Activity");
        addLog("DialogueActivity.onCreate() ...");
    }

    protected void onDestroy() {
        super.onDestroy();
        addLog("DialogueActivity.onDestroy() ...");
    }

    protected void onPause() {
        super.onPause();
        addLog("DialogueActivity.onPause() ...");
    }

    protected void onRestart() {
        super.onRestart();
        addLog("DialogueActivity.onRestart( ...");
    }

    protected void onResume() {
        super.onResume();
        addLog("DialogueActivity.onResume() ...");
    }

    protected void onStart() {
        super.onStart();
        addLog("DialogueActivity.onStart() ...");
    }

    protected void onStop() {
        super.onStop();
        addLog("DialogueActivity.onStop() ...");
    }
}
