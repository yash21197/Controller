package com.example.yashu.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);
        final EditText editText4 = (EditText) findViewById(R.id.editText4);

        Button button1= (Button)findViewById(R.id.button1);
        Button button2= (Button)findViewById(R.id.button2);
        Button button3= (Button)findViewById(R.id.button3);
        Button button4= (Button)findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile_no = editText1.getText().toString();
                String system_no = editText2.getText().toString();
                String min = editText3.getText().toString();

                if(system_no.equals("")){
                    system_no = "null";
                }

                if(min.equals("")){
                    min = "null";
                }

                String message = "# ON : " + system_no + " : " + min + " #";

//                if(!mobile_no.equals("")) {
//                    sendSMS(mobile_no,message);
//                }else{
//                    Toast.makeText(getApplicationContext(), "enter mobile number", Toast.LENGTH_SHORT).show();
//                }

                if(mobile_no.equals("")) {
                    Toast.makeText(getApplicationContext(), "enter mobile number", Toast.LENGTH_SHORT).show();
                }else if(!system_no.equals("null") && Integer.parseInt(system_no) < 0){
                    Toast.makeText(getApplicationContext(), "system number should be >= 0", Toast.LENGTH_SHORT).show();
                }else if(!min.equals("null") && Integer.parseInt(min) <= 0){
                    Toast.makeText(getApplicationContext(), "minutes should be > 0", Toast.LENGTH_SHORT).show();
                }else {
                    sendSMS(mobile_no, message);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile_no = editText1.getText().toString();
                String system_no = editText4.getText().toString();

                if(system_no.equals("")){
                    system_no = "null";
                }

                String message = "# OFF : " + system_no + " #";

                if(mobile_no.equals("")) {
                    Toast.makeText(getApplicationContext(), "enter mobile number", Toast.LENGTH_SHORT).show();
                }else if(!system_no.equals("null") && Integer.parseInt(system_no) < 0){
                    Toast.makeText(getApplicationContext(), "system number should be >= 0", Toast.LENGTH_SHORT).show();
                }else {
                    sendSMS(mobile_no, message);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile_no = editText1.getText().toString();

                String message = "# SENSOR DATA #";

                if(mobile_no.equals("")) {
                    Toast.makeText(getApplicationContext(), "enter mobile number", Toast.LENGTH_SHORT).show();
                }else {
                    sendSMS(mobile_no, message);
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile_no = editText1.getText().toString();

                String message = "# LAST FEW MESSAGES #";
                if(mobile_no.equals("")) {
                    Toast.makeText(getApplicationContext(), "enter mobile number", Toast.LENGTH_SHORT).show();
                }else {
                    sendSMS(mobile_no, message);
                }
            }
        });

    }

    protected void sendSMS(String mobile_no,String message){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(mobile_no, null, message, null, null);
    }
}
