package com.example.p_10_2; 
 
import android.os.Bundle; 
 
import androidx.activity.EdgeToEdge; 
import androidx.appcompat.app.AppCompatActivity; 
import androidx.core.graphics.Insets; 
import androidx.core.view.ViewCompat; 
import androidx.core.view.WindowInsetsCompat; 
import androidx.recyclerview.widget.LinearLayoutManager; 
import androidx.recyclerview.widget.RecyclerView; 
 
import java.util.ArrayList; 
import java.util.List; 
 
public class MainActivity extends AppCompatActivity { 
 
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
        RecyclerView recyclerView = findViewById(R.id.recyclerView); 
 
        // Step 2: Create a list of programming languages 
        List<LanguageModel> languages = new ArrayList<>(); 
        languages.add(new LanguageModel("Java")); 
        languages.add(new LanguageModel("Python")); 
        languages.add(new LanguageModel("C++")); 
        languages.add(new LanguageModel("Kotlin")); 
        languages.add(new LanguageModel("Swift")); 
        languages.add(new LanguageModel("JavaScript")); 
        languages.add(new LanguageModel("Ruby")); 
        languages.add(new LanguageModel("Dart")); 
        languages.add(new LanguageModel("Go")); 
        languages.add(new LanguageModel("PHP")); 
        languages.add(new LanguageModel("Rust")); 
        languages.add(new LanguageModel("TypeScript")); 
 
        // Step 3: Set up RecyclerView 
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); 
        recyclerView.setAdapter(new LanguageAdapter(languages)); 
    } 
} 