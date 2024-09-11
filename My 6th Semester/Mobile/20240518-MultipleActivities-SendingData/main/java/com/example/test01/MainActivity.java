package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    EditText edtData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtData=findViewById(R.id.edtData);

        intent=new Intent(getApplicationContext(), SecondActivity.class);
    }

    public void onBtnSendClicked(View view) {
        String str=edtData.getText().toString();
        intent.putExtra("strData", str);
        startActivity(intent);
    }
}