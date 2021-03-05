package org.techtown.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResisterActivity extends AppCompatActivity {
    EditText btnSelectDate, btnSelectCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister);
        btnSelectDate=(EditText)findViewById(R.id.Birthday);
        btnSelectCar=(EditText)findViewById(R.id.carselect);
    }
    public void onPrev(View v)
    {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void onNext(View v){
        Intent intent = new Intent(this, ResisterActivity2.class);
        startActivity(intent);
        finish();
    }

    }

