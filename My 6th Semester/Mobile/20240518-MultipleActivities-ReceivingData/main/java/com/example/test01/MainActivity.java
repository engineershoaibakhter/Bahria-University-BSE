package com.example.test01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent nameIntent;

    final int RC_NAME_ACTIVITY = 1;
    final int RC_REG_ACTIVITY = 2;
    final int RC_CGPA_ACTIVITY = 3;

    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameIntent = new Intent(getApplicationContext(), NameActivity.class);
        txtName = findViewById(R.id.txtName);
    }

    public void onTxtClicked(View view) {
        int id = view.getId();

        if (id == R.id.txtName) {
            startActivityForResult(nameIntent, RC_NAME_ACTIVITY);//Request Code of name Activity
        } else if (id == R.id.txtReg) {
            //startActivityForResult(regIntent, RC_REG_ACTIVITY)
        } else if (id == R.id.txtCGPA) {
            //startActivityForResult(cgpaIntent, RC_CGPA_ACTIVITY)
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        if (requestCode == RC_NAME_ACTIVITY) {//what was activity ?
            if (resultCode == R.id.btnSave) {//save or cancelled
                txtName.setText(i.getStringExtra("sName"));
            } else if (resultCode == R.id.btnCancel) {//save or cancelled
                //do nothing
            }

        } else if (resultCode == RC_REG_ACTIVITY) {

        } else if (resultCode == RC_CGPA_ACTIVITY) {

        }

    }
}