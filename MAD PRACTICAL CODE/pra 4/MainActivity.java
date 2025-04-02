package com.example.prac4q1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
        EditText etN,etA,etE;
        Button bnN,bnS;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etN = findViewById(R.id.etN);
        etA = findViewById(R.id.etA);
        etE = findViewById(R.id.etE);
        bnN = findViewById(R.id.bnN);
        bnS = findViewById(R.id.bnS);
        bnN.setOnClickListener(v->
        {
            Intent i = new Intent(MainActivity.this,S2.class);
            i.putExtra("name",etN.getText().toString());
            i.putExtra("Age ",etA.getText().toString());
            i.putExtra("Email ",etE.getText().toString());
            startActivity(i);
        });
        bnS.setOnClickListener(v-> {
            Intent i = new Intent(MainActivity.this,SmsOut.class);
            startActivity(i);
        });
    }
}