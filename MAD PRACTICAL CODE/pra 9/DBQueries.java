package com.example.prctical_9; 
 
import android.content.ContentValues; 
import android.content.Context; 
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper; 
import android.os.Environment; 
import android.util.Log; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.util.ArrayList; 
 
public class DBQueries extends SQLiteOpenHelper { 
 
    private static final String DB_NAME = "mydb"; 
    private static final String TABLE_NAME = "user_info"; 
 
    public DBQueries(Context context) { 
        super(context, DB_NAME, null, 1); 
    } 
 
    @Override 
    public void onCreate(SQLiteDatabase db) { 
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY 
AUTOINCREMENT, name TEXT NOT NULL, phone TEXT NOT NULL)"); 
    } 
 
    @Override 
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); 
        onCreate(db); 
    } 
 
    public boolean insertContact(String name, String phone) { 
        SQLiteDatabase db = this.getWritableDatabase(); 
        ContentValues values = new ContentValues(); 
        values.put("name", name); 
        values.put("phone", phone); 
        long result = db.insert(TABLE_NAME, null, values); 
        db.close(); // Close DB to prevent memory leaks 
        return result != -1; 
    } 
 
    public ArrayList<String> getAllContacts() { 
        ArrayList<String> userList = new ArrayList<>(); 
        SQLiteDatabase db = this.getReadableDatabase(); 
 
        try (Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)) { 
            if (cursor.moveToFirst()) { 
                do { 
                    userList.add(cursor.getString(1) + " - " + cursor.getString(2)); // Name - Phone 
                } while (cursor.moveToNext()); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
 
        db.close(); // Close database connection 
        return userList; 
    } 
 
    public void copyDatabaseToExternalStorage(Context context) { 
        try { 
            File dbFile = new File(getReadableDatabase().getPath()); 
            File outFile = new File(context.getExternalFilesDir(null), "mydb_copy.db"); // Save in app
specific directory 
 
            FileInputStream fis = new FileInputStream(dbFile); 
            FileOutputStream fos = new FileOutputStream(outFile); 
 
            byte[] buffer = new byte[1024]; 
            int length; 
            while ((length = fis.read(buffer)) > 0) { 
                fos.write(buffer, 0, length); 
            } 
 
            fis.close(); 
            fos.close(); 
            Log.d("DB_COPY", "Database copied to " + outFile.getAbsolutePath()); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
}