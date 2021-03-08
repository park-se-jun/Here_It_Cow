package org.techtown.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;

public class ResisterActivity extends AppCompatActivity implements VariableInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister);
    }
    public void onPrev(View v)
    {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void onNext(View v){

        EditText name = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText pwd = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText pwd2 = (EditText) findViewById(R.id.editTextTextPersonName4);

        if(!pwd.getText().toString().equals(pwd2.getText().toString())){
            pwd.setText(null);
            pwd2.setText(null);
            return;
        }else {
            RegInfo.add(name.getText().toString());
            RegInfo.add(pwd.getText().toString());

            Intent intent = new Intent(this, ResisterActivity2.class);
            startActivity(intent);
            finish();

        }
    }

}

