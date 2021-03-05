package org.techtown.example2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ResisterActivity2 extends AppCompatActivity {
   EditText phone, checksum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister2);
        phone=(EditText)findViewById(R.id.phone);
        checksum=(EditText)findViewById(R.id.checksum);
    }
    public void requestChecksum(View v){

    }
    public void checkChecksum(View v){

    }
    public void onPrev(View v)
    {
        Intent intent = new Intent(this,ResisterActivity.class);
        startActivity(intent);
        finish();
    }
    public void onNext(View v){
        Intent intent = new Intent(this, ResisterActivity3.class);
        startActivity(intent);
        finish();
    }

    }

