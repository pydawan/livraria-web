package br.com.livrariaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Fábrica de conexões com o banco de dados do sistema.
 * 
 * @author thiago-amm
 * @version v1.0.0 12/01/2019
 * @since v1.0.0
 */
public class ConnectionFactory {
    
    private static final Logger logger = Logger.getLogger(ConnectionFactory.class); 
    
    public static Connection getConnection(String engine, String host, Integer port, String database, String user, String password) {
        Connection connection = null;
        String driver = "";
        String url = "";
        try {
            // 1. Configuração do engine
            engine = engine == null ? "" : engine.toLowerCase();
            if ( engine.equals("mysql") ) {
                driver = "com.mysql.cj.jdbc.Driver"; // com.mysql.jdbc.Driver (deprecated)
            }
            // 2. Configuração do host
            host = host == null ? "localhost" : host;
            // 3. Configuração da porta
            if (port == null) {
                if ( engine.equals("mysql") ) {
                    port = 3306;
                }
            }
            switch (engine) {
                case "mysql":
                    url = String.format("jdbc:%s://%s:%d/%s", engine, host, port, database);
                    break;
                default:
                    url = "";
            }
            Class.forName(driver); // registrando e carregando o driver JDBC.
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        } catch (SQLException e) {
            logger.error(e);
        }
        if (connection == null) {
            throw new IllegalStateException("Não foi possível obter a conexão!");
        }
        return connection;
    }
    
    public static Connection getMySqlConnection(String database, String user, String password) {
        return getConnection("mysql", null, null, database, user, password);
    }
    
    public static Connection getMySqlConnection(String database) {
        return getMySqlConnection(database, database, database);
    }
    
}
