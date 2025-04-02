package com.example.practical3; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.*; 
import androidx.appcompat.app.AppCompatActivity; 
public class MainActivity extends AppCompatActivity { 
    EditText etN, etP, etA, etAge; 
    RadioGroup rgG; 
    DatePicker dpB; 
    Button bs; 
    TextView tvO; 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
        etN = findViewById(R.id.etN); 
        etP = findViewById(R.id.etP); 
        etA = findViewById(R.id.etA); 
        etAge = findViewById(R.id.etAge); 
        rgG = findViewById(R.id.rgG); 
        dpB = findViewById(R.id.dpB); 
        bs = findViewById(R.id.bs); 
        tvO = findViewById(R.id.tvO); 
 
        bs.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                String name = etN.getText().toString(); 
                String pass = etP.getText().toString(); 
                String addr = etA.getText().toString(); 
                String age = etAge.getText().toString(); 
 
                int gID = rgG.getCheckedRadioButtonId(); 
                RadioButton rb = findViewById(gID); 
                String gender = (rb != null) ? rb.getText().toString() : "Not selected"; 
 
                int d = dpB.getDayOfMonth(); 
                int m = dpB.getMonth(); 
                int y = dpB.getYear(); 
                String bD = d + "/" + m + "/" + y; 
 
                String output = "User: " + name + "\n" 
                        + "Password: " + pass + "\n" 
                        + "Address: " + addr + "\n" 
                        + "Gender: " + gender + "\n" 
                        + "Age: " + age + "\n" 
                        + "Date Of Birth: " + bD; 
 
                tvO.setText(output); 
            } 
        }); 
    } 
} 