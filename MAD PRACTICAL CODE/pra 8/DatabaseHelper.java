package com.example.p_8; 
 
import android.content.ContentValues; 
import android.content.Context; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper; 
 
public class DatabaseHelper extends SQLiteOpenHelper { 
    private static final String DATABASE_NAME = "UserDB"; 
    private static final int DATABASE_VERSION = 1; 
    private static final String TABLE_NAME = "user_info"; 
    private static final String COL_ID = "id"; 
    private static final String COL_NAME = "name"; 
    private static final String COL_EMAIL = "email"; 
    private static final String COL_PHONE = "phone"; 
 
    private Context context; 
 
 
    public DatabaseHelper(Context context) { 
        super(context, DATABASE_NAME, null, DATABASE_VERSION); 
        this.context = context; 
    } 
 
    // Crea ng the table 
    @Override 
    public void onCreate(SQLiteDatabase db) { 
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + 
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                COL_NAME + " TEXT, " + 
                COL_EMAIL + " TEXT, " + 
                COL_PHONE + " TEXT)"; 
        db.execSQL(createTable); 
    } 
    @Override 
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); 
        onCreate(db); 
    } 
    public boolean insertUser(String name, String email, String phone) { 
        SQLiteDatabase db = this.getWritableDatabase(); 
        ContentValues values = new ContentValues(); 
        values.put(COL_NAME, name); 
        values.put(COL_EMAIL, email); 
        values.put(COL_PHONE, phone); 
 
        long result = db.insert(TABLE_NAME, null, values); 
        db.close(); 
        return result != -1; 
    }