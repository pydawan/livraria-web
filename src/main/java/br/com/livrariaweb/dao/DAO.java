package br.com.livrariaweb.dao;

import java.util.List;

/**
 * Defines as operações básicas de acesso e manipulação aos dados 
 * armazenados no banco de dados.
 * 
 * @author thiago-amm
 * @version v1.0.0 12/01/2019
 * @since v1.0.0
 */
public interface DAO<T> {
    /**
     * Insere um registro no banco de dados.
     * @param t  referência para o objeto a ser inserido
     */
    void insert(T t) throws DAOException;
    void update(T t) throws DAOException;
    void save(T t) throws DAOException;
    void delete(T t) throws DAOException;
    void deleteById(Integer id) throws DAOException;
    void deleteAll() throws DAOException;
    T selectById(Integer id) throws DAOException;
    List<T> selectAll() throws DAOException;
}
