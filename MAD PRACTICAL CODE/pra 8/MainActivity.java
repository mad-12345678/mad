package com.example.p_8; 
 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Bu on; 
import android.widget.EditText; 
import android.widget.Toast; 
 
import androidx.ac vity.EdgeToEdge; 
import androidx.appcompat.app.AppCompatAc vity; 
import androidx.core.graphics.Insets; 
import androidx.core.view.ViewCompat; 
import androidx.core.view.WindowInsetsCompat; 
 
public class MainActivity extends AppCompatActivity { 
    private EditText etName, etEmail, etPhone; 
    private Bu on btnSave; 
    private DatabaseHelper databaseHelper; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        EdgeToEdge.enable(this); 
        setContentView(R.layout.ac vity_main); 
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { 
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); 
            v.setPadding(systemBars.le , systemBars.top, systemBars.right, systemBars.bo om); 
            return insets; 
        }); 
        etName = findViewById(R.id.etName); 
        etEmail = findViewById(R.id.etEmail); 
        etPhone = findViewById(R.id.etPhone); 
        btnSave = findViewById(R.id.btnSave); 
 
        databaseHelper = new DatabaseHelper(this); 
 
        btnSave.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                String name = etName.getText().toString().trim(); 
                String email = etEmail.getText().toString().trim(); 
                String phone = etPhone.getText().toString().trim(); 
 
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) { 
                    Toast.makeText(MainAc vity.this, "Please fill all fields", Toast.LENGTH_SHORT).show(); 
                } else { 
                    boolean isInserted = databaseHelper.insertUser(name, email, phone); 
                    if (isInserted) { 
                        Toast.makeText(MainAc vity.this, "User Inserted Successfully", 
Toast.LENGTH_SHORT).show(); 
                        etName.setText(""); 
                        etEmail.setText(""); 
                        etPhone.setText(""); 
                    } else { 
                        Toast.makeText(MainAc vity.this, "Inser on Failed", Toast.LENGTH_SHORT).show(); 
                    } 
                } 
            } 
        }); 
    } 
} 