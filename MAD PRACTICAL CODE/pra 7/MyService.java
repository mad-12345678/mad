
package com.example.p_7; 
import android.app.Service; 
import android.content.Intent; 
import android.media.MediaPlayer; 
import android.os.IBinder; 
import android.provider.Settings; 
import android.widget.Toast; 
import androidx.annotation.Nullable; 
public class MyService extends Service { 
    MediaPlayer mediaPlayer; 
 
    @Nullable 
    @Override 
    public IBinder onBind(Intent intent) { 
        return null; 
    } 
 
    @Override 
    public void onCreate() { 
        super.onCreate(); 
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show(); 
        mediaPlayer = MediaPlayer.create(this, 
Settings.System.DEFAULT_RINGTONE_URI); 
    } 
 
    @Override 
    public int onStartCommand(Intent intent, int flags, int startId) { 
        Toast.makeText(this, "Service Started - Playing Ringtone", 
Toast.LENGTH_SHORT).show(); 
        mediaPlayer.start(); 
        return START_STICKY; 
    } 
 
    @Override 
    public void onDestroy() { 
        super.onDestroy(); 
        Toast.makeText(this, "Service Stopped - Ringtone Stopped", 
Toast.LENGTH_SHORT).show(); 
        mediaPlayer.stop(); 
        mediaPlayer.release(); 
    } 
} 