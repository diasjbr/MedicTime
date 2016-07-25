package android.pdm.ifpb.edu.br.medictime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by luckschulze on 18/07/16.
 */
public class BancoHelper extends SQLiteOpenHelper{
    private static final String BANCO = "medictime.db";
    private static final int VERSAO = 1;

    public BancoHelper(Context context) {
        super(context, BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table medicamento (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "nome STRING," +
                "dose STRING," +
                "hora INTEGER," +
                "minutos INTEGER" +
                ");";
        db.execSQL(sql);
        Log.i("SCHULZE", "Tabela medicamento criada.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
