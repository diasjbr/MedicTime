package android.pdm.ifpb.edu.br.medictime;

import java.util.List;


public interface DAO <T> {
    public void inserir(T novo);
    public void atualizar(T obj);
    public void remover(int id);
    public void remover(T obj);
    public T get(int id);
    public List<T> get();
}
