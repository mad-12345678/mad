package com.example.prac6q2;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnShowDialog = findViewById(R.id.showDialogButton);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                showCustomDialog();
            }
        });
    }
    public void showCustomDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCancelable(false);
        EditText editTextUserInput = dialog.findViewById(R.id.editTextUserInput);
        Button btnSubmit = dialog.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = editTextUserInput.getText().toString();
                if(!userInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Entered: " + userInput, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                 }
            }
        });
        dialog.show();
    }
}