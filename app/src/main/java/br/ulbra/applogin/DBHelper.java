package br.ulbra.applogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context,
                "BancoDados.db",
                null,
                1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE utilizador (" +
                "username TEXT PRIMARY KEY, " +
                "password TEXT)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS utilizador");

        onCreate(db);
    }

    public long criarUtilizador(String username,
                                String password){

        SQLiteDatabase db =
                this.getWritableDatabase();

        ContentValues cv =
                new ContentValues();

        cv.put("username", username);
        cv.put("password", password);

        return db.insert("utilizador",
                null,
                cv);
    }

    public String validarLogin(String username,
                               String password){

        SQLiteDatabase db =
                this.getReadableDatabase();

        Cursor c =
                db.rawQuery(
                        "SELECT * FROM utilizador WHERE username=? AND password=?",
                        new String[]{username,password});

        if(c.getCount() > 0){
            return "OK";
        }

        return "ERRO";
    }
}