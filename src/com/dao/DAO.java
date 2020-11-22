package com.dao;

import java.util.List;

public interface DAO<T> {

    T salvar(T entidade);
    T atualizar(T entidade);
    T buscarPorID(Integer ID);
    List<T> listar();
    void apagar(Integer id);
}
