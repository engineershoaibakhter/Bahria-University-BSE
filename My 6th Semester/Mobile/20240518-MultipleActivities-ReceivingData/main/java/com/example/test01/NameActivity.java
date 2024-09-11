package com.example.test01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NameActivity extends AppCompatActivity {

    EditText edtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        edtName=findViewById(R.id.edtName);
    }

    public void onBtnSaveClicked(View view) {
        Intent i=new Intent();
        i.putExtra("sName", edtName.getText().toString());

        setResult(R.id.btnSave, i);
        finish();
    }

    public void onBtnCancelClicked(View view) {
        setResult(R.id.btnCancel);
        finish();
    }
}