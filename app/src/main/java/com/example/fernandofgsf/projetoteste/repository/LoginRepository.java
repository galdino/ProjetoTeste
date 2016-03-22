package com.example.fernandofgsf.projetoteste.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.fernandofgsf.projetoteste.util.Constantes;

/**
 * Created by fernando.fgsf on 21/03/2016.
 */
public class LoginRepository extends SQLiteOpenHelper {

    public LoginRepository(Context context  ) {
        super(context, Constantes.BD_NOME, null, Constantes.BD_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE TB_LOGIN ( ");
        query.append(" ID_LOGIN INTEGER PRIMARY KEY AUTOINCREMENT, ");
        query.append(" USUARIO TEXT(15) NOT NULL, ");
        query.append(" SENHA TEXT(15) NOT NULL)");

        db.execSQL(query.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void popularBD(){
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO TB_LOGIN (USUARIO, SENHA) VALUES (?, ?)");

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query.toString(), new String[] {"admin", "admin"});
    }

    public void listarLogins(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("TB_LOGIN", null, null, null, null, null, "USUARIO");
        while (cursor.moveToNext()){
            Log.d("Nome de usuário: ", cursor.getString(1));
        }
    }
}
