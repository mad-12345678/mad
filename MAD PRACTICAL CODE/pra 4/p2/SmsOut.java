package com.example.a4_1; 
 
import android.content.Intent; 
import android.net.Uri; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.*; 
 
import androidx.appcompat.app.AppCompatActivity; 
 
public class SmsOut extends AppCompatActivity { 
 
    Bu on bnS; 
    EditText etS; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_sms_out); 
 
        etS = findViewById(R.id.etS); 
        bnS = findViewById(R.id.bnS); 
 
        bnS.setOnClickListener(v -> { 
            Intent i = new Intent(Intent.ACTION_SENDTO); 
            i.setData(Uri.parse("smsto:" + etS.getText().toString())); 
            i.putExtra("sms_body", "Hello"); 
            startAc vity(i); 
        }); 
    } 
} 