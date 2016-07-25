package android.pdm.ifpb.edu.br.medictime;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luckschulze on 19/07/16.
 */
public class MedicamentosList {
    private List<Medicamento> medicamentos = new ArrayList<Medicamento>();

    public MedicamentosList(){
    }
    public List<String> get(){
        List<String> l1 = new ArrayList<String>();
        for (Medicamento l: medicamentos) {
            l1.add(l.getNome());
        }
        return l1;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    public Medicamento adicionarLugar(Medicamento l){
        medicamentos.add(l);
        return l;
    }
    public Medicamento buscarMedicamento(String nome){
        for (Medicamento m: medicamentos) {
            if (m.getNome().equals(nome))
                return m;
        }
        return null;
    }

}
