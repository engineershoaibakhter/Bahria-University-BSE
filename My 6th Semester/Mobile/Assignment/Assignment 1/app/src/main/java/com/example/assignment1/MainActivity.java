package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.CheckBox;



public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2;
    private CheckBox checkbox1, checkbox2, checkbox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.firstRadioBtn);
        radioButton2 = findViewById(R.id.secondRadioBtn);

        radioButton1.setChecked(true);

    checkbox1 = findViewById(R.id.firstCheckBoxBtn);
    checkbox2 = findViewById(R.id.secondCheckBoxBtn);
    checkbox3 = findViewById(R.id.thirdCheckBoxBtn);

    }

    public void onSubmitRadio(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedText = selectedRadioButton.getText().toString();
            Toast.makeText(this, "Selected Option: " + selectedText, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        }
    }






    public void onSubmitClick(View view) {
        StringBuilder selectedCheckbox = new StringBuilder();

        if (checkbox1.isChecked()) {
            selectedCheckbox.append("First Checkbox\n");
        }
        if (checkbox2.isChecked()) {
            selectedCheckbox.append("Second Checkbox\n");
        }
        if (checkbox3.isChecked()) {
            selectedCheckbox.append("Third Checkbox\n");
        }
        if (selectedCheckbox.length() > 0) {
            Toast.makeText(this, "Your selected :\n" + selectedCheckbox.toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please select at least one checkbox", Toast.LENGTH_SHORT).show();
        }

    }
}

