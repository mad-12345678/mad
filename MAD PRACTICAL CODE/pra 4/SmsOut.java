package com.example.prac4q1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SmsOut extends AppCompatActivity {
    Button bnS;
    EditText etS;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_out);
        etS = findViewById(R.id.etS);
        bnS = findViewById(R.id.bnS);
        bnS.setOnClickListener(v-> {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("sms to:"+etS.getText().toString()));
            i.putExtra("sms body","hello");
            startActivity(i);
        });

    }
}
