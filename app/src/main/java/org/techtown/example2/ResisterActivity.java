package org.techtown.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ResisterActivity extends AppCompatActivity {
    EditText btnSelectDate, btnSelectCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister);
        btnSelectDate=(EditText)findViewById(R.id.Birthday);
        btnSelectCar=(EditText)findViewById(R.id.carselect);
    }
    public void clickregister2(View v)
    {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void onNext(View v){
        Intent intent = new Intent(this,ResisterActivity2.class);
        startActivity(intent);
        finish();
    }

    }

