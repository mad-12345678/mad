package com.example.prac5q2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCtxMenu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnCtxMenu = findViewById(R.id.btn_ctx_menu);
        registerForContextMenu(btnCtxMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Choose a color :");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.red) {
            btnCtxMenu.setBackgroundColor(Color.RED);
            return true;
        }
        if (id == R.id.green) {
            btnCtxMenu.setBackgroundColor(Color.GREEN);
            return true;
        }
        if (id == R.id.yellow) {
            btnCtxMenu.setBackgroundColor(Color.YELLOW);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}