package com.example.trabalho.dao;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trabalho.model.Times;
public class TimesDAO extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String TABELA = "times";
    private static final String DATABASE = "CadastroBSN";
    private static final String[] COLUNAS = { "id", "descricao", "sigla" };

    public TimesDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //comando DDL para criação da tabela SQLite
        String ddl = "CREATE TABLE " + TABELA + " (id INTEGER PRIMARY KEY, "
                + " descricao TEXT UNIQUE NOT NULL, sigla TEXT);";

        db.execSQL(ddl);
    }


    @Override
    //Esse método é executado automaticamente pelo sistema android, quando ele detectar que a versão do banco de dados mudou
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    //método utilizado para inserir um novo cadastro no banco de dados SQLite. Esse método irá receber uma instância do Modelo Aluno por parâmetro.
    public void insere(Times times) {
        ContentValues values = new ContentValues();

        values.put("descricao", times.getDescricao());
        values.put("sigla", times.getSigla());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public List<Times> getLista() {

        //ArraList criado para o retorno dos dados
        List<Times> times = new ArrayList<Times>();

        Cursor c = getWritableDatabase().query(
                TABELA,
                COLUNAS,
                null,
                null,
                null,
                null,
                null
        );

        //após abrir o cursor, deve-se percorrê-lo para popular o ArrayList que será retornado.
        while (c.moveToNext()) {
            Times times = new Times();

            times.setId(c.getLong(0));
            times.setDescricao(c.getString(1));
            times.setSigla(c.getString(2));

            times.add(times);
        }

        c.close();

        return times;
    }

    public void deletar(Times times) {
        String[] args = {times.getId().toString()};
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public void altera(Times times) {

        //Para realizar a alteraçãoao dos dados na base de dados SQLite é necessário
        ContentValues values = new ContentValues();

        values.put("descricao", times.getDescricao());
        values.put("sigla", times.getSigla());

        String[] args = {times.getId().toString()};
        getWritableDatabase().update(TABELA, values, "id=?", args );
    }

}
