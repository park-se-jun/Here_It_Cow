package org.techtown.example2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ResisterActivity3 extends AppCompatActivity {
    EditText btnSelectDate, btnSelectCar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister3);
        btnSelectDate=(EditText)findViewById(R.id.Birthday);
        btnSelectCar=(EditText)findViewById(R.id.carselect);
    }
    public void onBirthday(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(btnSelectDate.getWindowToken(),0);
        if (v == btnSelectDate) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            btnSelectDate.setText(year+ "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
    public void onCarselect(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(btnSelectDate.getWindowToken(),0);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = { "소형", "중형", "대형" };
        builder.setTitle("차량 구분을 선택하시오.");
        builder.setItems(items,new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int item){
                btnSelectCar.setText(items[item]);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void onPrev(View v)
    {
        Intent intent = new Intent(this,ResisterActivity2.class);
        startActivity(intent);
        finish();
    }
    public void onNext(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
