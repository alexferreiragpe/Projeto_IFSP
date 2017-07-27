package com.example.alexf.ifsp.banco;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;

import static android.content.Context.MODE_PRIVATE;

public class BancoController {
    private SQLiteDatabase ifspBanco = null;
    private Context context;
    private String nomeBanco;
    private SQLiteDatabase.CursorFactory cursor;

    public BancoController(Context context, String nomeBanco) {
        this.context = context;
        this.nomeBanco = nomeBanco;
     /*   cursor = new SQLiteDatabase.CursorFactory() {
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
                return null;
            }
        };*/

        this.verificaBanco();
    }


    private void verificaBanco() {
        ProviderStringCriacaoBanco criacaoBanco = new ProviderStringCriacaoBanco();
        try {
            Log.v("CRIACAO BANCO", "CURSOR");
            this.ifspBanco = context.getApplicationContext().openOrCreateDatabase(nomeBanco, MODE_PRIVATE, null);
            Log.v("CRIACAO BANCO", "CURSOR CRIADO");
            File database = context.getApplicationContext().getDatabasePath(nomeBanco + ".db");
            Log.v("CRIACAO BANCO", "ARQUIVO ENCONTRADO");

            for (String tabela : criacaoBanco.getCriacaoTabelas()) {
                this.ifspBanco.execSQL(tabela);
            }
            Log.v("CRIACAO BANCO", "TABELAS CRIADAS");

            // Verifica se database existe
            if (database.exists()) {
                //context.get
                Log.v("IFSP LOG: ", "Database Criada");
            } else {
                Log.v("CRIACAO BANCO", context.getApplicationContext().getDatabasePath(nomeBanco + ".db") + "");
                //database = new File(context.getFilesDir()+"/"+nomeBanco+".db");
                Log.e("IFSP LOG: ", "Database Faltando");
            }
        } catch (Exception e) {
            Log.e("IFSP ERROR", "Erro na criacao da Database");
        }
    }

    public void executarComandoSql(String sql) {
        ifspBanco.beginTransaction();
        ifspBanco.execSQL(sql);
        ifspBanco.setTransactionSuccessful();
        ifspBanco.endTransaction();
    }

    public Cursor realizarConsulta(String sql, String[] parametros) {
        Cursor cursor = ifspBanco.rawQuery(sql, parametros);
        return cursor;
    }
}
