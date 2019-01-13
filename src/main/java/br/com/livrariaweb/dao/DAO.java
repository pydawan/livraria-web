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
    DAO<T> insert(T t) throws DAOException;
    DAO<T> update(T t) throws DAOException;
    DAO<T> save(T t) throws DAOException;
    DAO<T> delete(T t) throws DAOException;
    DAO<T> deleteById(Integer id) throws DAOException;
    DAO<T> deleteAll() throws DAOException;
    T selectById(Integer id) throws DAOException;
    List<T> selectAll() throws DAOException;
}
