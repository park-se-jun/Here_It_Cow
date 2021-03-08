package org.techtown.example2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;

public class ResisterActivity3 extends AppCompatActivity implements VariableInterface{
    EditText btnSelectDate, btnSelectCar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister3);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

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

        EditText name = (EditText) findViewById(R.id.Name);
        EditText birth = (EditText) findViewById(R.id.Birthday);
        EditText carselect = (EditText) findViewById(R.id.carselect);
        EditText carnum = (EditText) findViewById(R.id.Carnumber);


        RegInfo.add(name.getText().toString());
        RegInfo.add(birth.getText().toString());
        RegInfo.add(carselect.getText().toString());
        RegInfo.add(carnum.getText().toString());

        onJoin();

        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void onJoin(){

        String url = "http://140.238.26.22/join";
        HashMap<String, String> map = new HashMap<>();

        map.put("ID",RegInfo.get(0));
        map.put("password",RegInfo.get(1));
        map.put("PhoneNum",RegInfo.get(2));
        map.put("Name",RegInfo.get(3));
        map.put("Birth",RegInfo.get(4));
        map.put("CarKind",RegInfo.get(5));
        map.put("CarNum",RegInfo.get(6));

        String result = HttpRequest.postRequest(url,map);

        if(statusCode.get(0) == 200){
            Toast toast=Toast.makeText(ResisterActivity3.this,"회원가입이 완료되었습니다.",Toast.LENGTH_SHORT);
            toast.show();
        }

        RegInfo.clear();
    }

}
