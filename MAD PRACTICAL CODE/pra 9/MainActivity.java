package com.example.prctical_9; 
 
import android.os.Bundle; 
import android.view.View; 
import android.widget.ArrayAdapter; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.ListView; 
import android.widget.Toast; 
 
import androidx.appcompat.app.AppCompatActivity; 
 
import java.util.ArrayList; 
 
public class MainActivity extends AppCompatActivity { 
 
    EditText etName, etPhone; 
    Button btnInsert, btnFetch, btnExport; 
    ListView lvUsers; 
    DBQueries dbQueries; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
 
        etName = findViewById(R.id.etName); 
        etPhone = findViewById(R.id.etPhone); 
        btnInsert = findViewById(R.id.btnInsert); 
        btnFetch = findViewById(R.id.btnFetch); 
        btnExport = findViewById(R.id.btnExport); 
        lvUsers = findViewById(R.id.lvUsers); 
 
        dbQueries = new DBQueries(this); 
 
        btnInsert.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                String name = etName.getText().toString().trim(); 
                String phone = etPhone.getText().toString().trim(); 
 
                if (!name.isEmpty() && !phone.isEmpty()) { 
                    boolean inserted = dbQueries.insertContact(name, phone); 
                    if (inserted) { 
                        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show(); 
                        etName.setText(""); 
                        etPhone.setText(""); 
                    } else { 
                        Toast.makeText(MainActivity.this, "Insertion Failed", 
Toast.LENGTH_SHORT).show(); 
                    } 
                } else { 
                    Toast.makeText(MainActivity.this, "Please enter all fields", 
Toast.LENGTH_SHORT).show(); 
                } 
            } 
        }); 
 
        btnFetch.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                ArrayList<String> userList = dbQueries.getAllContacts(); 
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, 
android.R.layout.simple_list_item_1, userList); 
                lvUsers.setAdapter(adapter); 
            } 
        }); 
 
        btnExport.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                dbQueries.copyDatabaseToExternalStorage(MainActivity.this); 
                Toast.makeText(MainActivity.this, "Database Exported", Toast.LENGTH_SHORT).show(); 
            } 
        }); 
    } 
} 