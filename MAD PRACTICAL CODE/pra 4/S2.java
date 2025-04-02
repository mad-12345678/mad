package com.example.prac4q1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;


public class S2 extends AppCompatActivity {
    TextView tvN,tvA,tvE;
    Button bnB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2);
        tvN = findViewById(R.id.tvN);
        tvA = findViewById(R.id.tvA);
        tvE = findViewById(R.id.tvE);
        bnB = findViewById(R.id.bnB);
        Intent i = getIntent();
        tvN.setText(i.getStringExtra("name"));
        tvA.setText(i.getStringExtra("age"));
        tvE.setText(i.getStringExtra("email"));
        bnB.setOnClickListener(v->{
            Intent back = new Intent(S2.this,MainActivity.class);
            startActivity(back);
        });
    }
}
