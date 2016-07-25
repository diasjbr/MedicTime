package android.pdm.ifpb.edu.br.medictime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckschulze on 18/07/16.
 */
public class DAOMedicamento implements DAO<Medicamento> {
    private BancoHelper banco;
    private static final String TABELA = "medicamento";

    public DAOMedicamento(Context context) {
        this.banco = new BancoHelper(context);
    }


    @Override
    public void inserir(Medicamento novo) {
        ContentValues cv = new ContentValues();
        cv.put("nome", novo.getNome());
        cv.put("dose", novo.getdose());
        cv.put("hora", novo.getHora());
        cv.put("minutos", novo.getMinutos());

        this.banco.getWritableDatabase().insert(TABELA, null, cv);
    }

    @Override
    public void atualizar(Medicamento obj) {

    }

    @Override
    public void remover(int id) {
        String[] where = {Integer.toString(id)};
        this.banco.getWritableDatabase().delete(TABELA, "id = ?", where);
    }

    @Override
    public void remover(Medicamento obj) {
        this.remover(obj.getId());
    }

    @Override
    public Medicamento get(int id) {
        return null;
    }

    @Override
    public List<Medicamento> get() {
        String[] colunas = {"id", "nome", "dose","hora", "minutos"};
        List<Medicamento> lista = new ArrayList<Medicamento>();

        Cursor c = this.banco.getReadableDatabase().query("medicamento", colunas, null, null, null, null, null);
        if (c.getCount() > 0){
            c.moveToFirst();
            do{
                Medicamento p = new Medicamento();
                p.setId(c.getInt(c.getColumnIndex(colunas[0])));
                p.setNome(c.getString(c.getColumnIndexOrThrow("nome")));
                p.setdose(c.getString(c.getColumnIndexOrThrow("dose")));
                p.setHora(c.getInt(c.getColumnIndexOrThrow("hora")));
                p.setMinutos(c.getInt(c.getColumnIndexOrThrow("minutos")));
                lista.add(p);
            }while (c.moveToNext());
        }

        return lista;
    }
}
