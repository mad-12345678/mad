package com.example.p_7; 
 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.Toast; 
 
import androidx.activity.EdgeToEdge; 
import androidx.appcompat.app.AppCompatActivity; 
import androidx.core.graphics.Insets; 
import androidx.core.view.ViewCompat; 
import androidx.core.view.WindowInsetsCompat; 
 
public class MainActivity extends AppCompatActivity { 
    Button btnStart, btnStop, btnBack; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        EdgeToEdge.enable(this); 
        setContentView(R.layout.activity_main); 
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), 
(v, insets) -> { 
            Insets systemBars = 
insets.getInsets(WindowInsetsCompat.Type.systemBars()); 
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 
systemBars.bottom); 
            return insets; 
        }); 
 
        btnStart = findViewById(R.id.btnStart); 
        btnStop = findViewById(R.id.btnStop); 
        btnBack = findViewById(R.id.btnBack); 
 
        btnStart.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                startService(new Intent(MainActivity.this, 
MyService.class)); 
                Toast.makeText(MainActivity.this, "Starting Service...", 
Toast.LENGTH_SHORT).show(); 
            } 
        }); 
 
        btnStop.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                stopService(new Intent(MainActivity.this, 
MyService.class)); 
                Toast.makeText(MainActivity.this, "Stopping Service...", 
Toast.LENGTH_SHORT).show(); 
            } 
        }); 
 
        btnBack.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                startActivity(new Intent(MainActivity.this, 
MainActivity.class)); 
                Toast.makeText(MainActivity.this, "Returning to Main 
Screen", Toast.LENGTH_SHORT).show(); 
            } 
        }); 
    } 
}