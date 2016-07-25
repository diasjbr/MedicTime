package android.pdm.ifpb.edu.br.medictime;

import android.widget.ImageView;

/**
 * Created by luckschulze on 17/07/16.
 */
    public class Medicamento {
    private int id;
    private String nome;
    private String dose;
    private int hora;
    private int minutos;

    public Medicamento(){

    }
    public Medicamento(String nome, String dose, int hora, int minutos) {
        this.nome = nome;
        this.dose = dose;
        this.hora = hora;
        this.minutos = minutos;

    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setdose(String dose) {
        this.dose = dose;
    }

    public String getdose() {
        return dose;
    }
    @Override
    public String toString() {
        return this.nome;
    }
}
