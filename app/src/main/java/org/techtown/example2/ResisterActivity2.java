package org.techtown.example2;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;


public class ResisterActivity2 extends AppCompatActivity implements VariableInterface{
   Boolean chk,push_checksum;
   EditText user_phone_number,checksum;
   String user_auth_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister2);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Button reqButton = (Button) findViewById(R.id.requestButton);


        reqButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_phone_number= (EditText) findViewById(R.id.phone);
                sendAuth();
            }
        });


    }

    public void sendAuth(){

        String url = "http://10.21.20.95:4000/join/send";
        HashMap<String, String> map = new HashMap<>();

        user_auth_number = numberGen(4,1); // 4자리 중복 허용
        map.put("user_phone_number",user_phone_number.getText().toString());
        map.put("user_auth_number",user_auth_number);

        String result = HttpRequest.postRequest(url,map);

        // 인증번호 요청이 정상적으로 마무리 됐다면
        if(statusCode.get(0) == 200){
            Toast toast=Toast.makeText(ResisterActivity2.this,"인증번호 전송이 요청되었습니다.",Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Toast toast=Toast.makeText(ResisterActivity2.this,"인증번호 전송에 실패하였습니다.",Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public static String numberGen(int len, int dupCd ) {

        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수

        for(int i=0;i<len;i++) {

            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));

            if(dupCd==1) {
                //중복 허용시 numStr에 append
                numStr += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if(!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i-=1;
                }
            }
        }
        return numStr;
    }

    public void checkChecksum(View v){

        checksum = (EditText) findViewById(R.id.checksum);

        if(checksum.getText().toString().equals(user_auth_number)){
            // 인증번호 통과
            Toast toast=Toast.makeText(ResisterActivity2.this,"인증번호가 정상적으로 확인되었습니다.",Toast.LENGTH_SHORT);
            toast.show();
            chk = true;
            push_checksum = true;
        }else {
            // 인증번호 실패
            // Toast 메시지 생성
            Toast toast=Toast.makeText(ResisterActivity2.this,"인증번호를 다시 입력해주세요.",Toast.LENGTH_SHORT);
            toast.show();
            chk = false;
            push_checksum = false;
        }

    }
    public void onPrev(View v)
    {
        Intent intent = new Intent(this,ResisterActivity.class);
        startActivity(intent);
        finish();
    }
    public void onNext(View v){
        statusCode.clear();

        if(push_checksum) {
            if (chk) {
                //인증번호 통과 일시 다음 화면으로 전환
                RegInfo.add(user_phone_number.getText().toString());
                Intent intent = new Intent(this, ResisterActivity3.class);
                startActivity(intent);
                finish();
            } else {
                // toast 메시지 출력 => 최영찬
                Toast toast=Toast.makeText(ResisterActivity2.this,"인증번호를 다시 입력해주세요.",Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
        }else{
            // 인증번호 확인 버튼 눌러주세요 toast메시지 생성
            Toast toast=Toast.makeText(ResisterActivity2.this,"인증번호 확인을 눌러주세요.",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    }

