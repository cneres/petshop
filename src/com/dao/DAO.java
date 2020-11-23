package com.dao;

import java.io.IOException;
import java.util.List;

public interface DAO<T> {

    T salvar(T entidade) throws IOException;
    T atualizar(T entidade) throws IOException;
    T buscarPorID(Integer ID);
    List<T> listar();
    void apagar(Integer id) throws IOException;
}
