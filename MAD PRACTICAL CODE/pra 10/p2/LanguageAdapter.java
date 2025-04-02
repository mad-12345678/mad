package com.example.p_10_2; 
import android.view.LayoutInflater; 
import android.view.View; 
import android.view.ViewGroup; 
import android.widget.TextView; 
import androidx.annotation.NonNull; 
import androidx.recyclerview.widget.RecyclerView; 
import java.util.List; 
public class LanguageAdapter extends 
RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> { 
 
    private List<LanguageModel> languageList; 
 
    public LanguageAdapter(List<LanguageModel> languageList) { 
        this.languageList = languageList; 
    } 
    @NonNull 
    @Override 
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, 
int viewType) { 
        View view = LayoutInflater.from(parent.getContext()) 
                .inflate(R.layout.item_language, parent, false); 
        return new LanguageViewHolder(view); 
    } 
    @Override 
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int 
position) { 
        LanguageModel language = languageList.get(position); 
        holder.textViewLanguage.setText(language.getLanguageName()); 
    } 
    @Override 
    public int getItemCount() { 
        return languageList.size(); 
    } 
    public static class LanguageViewHolder extends RecyclerView.ViewHolder 
{   TextView textViewLanguage; 
        public LanguageViewHolder(@NonNull View itemView) { 
            super(itemView); 
            textViewLanguage = 
itemView.findViewById(R.id.textViewLanguage); 
        }    }} 