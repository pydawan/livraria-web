package br.com.livrariaweb.persistence.dao;

/**
 * Representa as exceções a serem lançadas ao consultar ou manipular os dados no
 * banco de dados.
 * 
 * @author thiago-amm
 * @version v1.0.0 12/01/2019
 * @since v1.0.0
 */
public class DAOException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public DAOException() {
        super();
    }
    
    public DAOException(String message) {
        super(message);
    }
    
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DAOException(Throwable cause) {
        super(cause);
    }
    
}
