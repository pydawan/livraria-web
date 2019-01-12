package br.com.livrariaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.livrariaweb.model.Livro;

/**
 * @author thiago-amm
 * @version v1.0.0 12/01/2019
 * @since v1.0.0
 */
public class LivroDAO implements DAO<Livro> {
    
    private static final String MENSAGEM_LIVRO_REFERENCIA_NAO_NULA = "O livro não pode ser uma referência nula!";
    private static final String MENSAGEM_LIVRO_ID_NAO_NULO = "O id do livro não pode ser nulo (null ou zero)!";
    
    public static LivroDAO of() {
        return new LivroDAO();
    }
    
    @Override
    public void insert(Livro livro) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        if (livro != null) {
            try {
                connection = ConnectionFactory.getMySqlConnection("livraria");
                if (connection != null) {
                    preparedStatement = connection.prepareStatement("INSERT INTO livros (titulo, autor) VALUES (?, ?)");
                    preparedStatement.setString(1, livro.getTitulo());
                    preparedStatement.setString(2, livro.getAutor());
                    preparedStatement.executeUpdate();
                }
            } catch (IllegalStateException | SQLException e) {
                throw new DAOException(e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new DAOException(e);
                }
            }
        } else {
            throw new DAOException(MENSAGEM_LIVRO_REFERENCIA_NAO_NULA);
        }
    }
    
    @Override
    public void update(Livro livro) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        if (livro != null) {
            try {
                connection = ConnectionFactory.getMySqlConnection("livraria");
                if (connection != null) {
                    preparedStatement = connection
                        .prepareStatement("UPDATE livros SET titulo = ?, autor = ? WHERE ID = ?");
                    preparedStatement.setString(1, livro.getTitulo());
                    preparedStatement.setString(2, livro.getAutor());
                    preparedStatement.setInt(3, livro.getId());
                    preparedStatement.executeUpdate();
                }
            } catch (IllegalStateException | SQLException e) {
                throw new DAOException(e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new DAOException(e);
                }
            }
        } else {
            throw new DAOException(MENSAGEM_LIVRO_REFERENCIA_NAO_NULA);
        }
    }
    
    @Override
    public void save(Livro livro) throws DAOException {
        if (livro != null) {
            if (livro.getId() == null || livro.getId() == 0) {
                this.insert(livro);
            } else {
                this.update(livro);
            }
        } else {
            throw new DAOException(MENSAGEM_LIVRO_REFERENCIA_NAO_NULA);
        }
    }
    
    @Override
    public void delete(Livro livro) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        if (livro != null) {
            try {
                connection = ConnectionFactory.getMySqlConnection("livraria");
                if (connection != null) {
                    preparedStatement = connection.prepareStatement("DELETE FROM livros WHERE ID = ?");
                    preparedStatement.setInt(1, livro.getId());
                    preparedStatement.executeUpdate();
                }
            } catch (IllegalStateException | SQLException e) {
                throw new DAOException(e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new DAOException(e);
                }
            }
        } else {
            throw new DAOException(MENSAGEM_LIVRO_REFERENCIA_NAO_NULA);
        }
    }
    
    @Override
    public void deleteById(Integer id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        id = id == null ? 0 : id;
        if (id != 0) {
            try {
                connection = ConnectionFactory.getMySqlConnection("livraria");
                if (connection != null) {
                    preparedStatement = connection.prepareStatement("DELETE FROM livros WHERE ID = ?");
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                }
            } catch (IllegalStateException | SQLException e) {
                throw new DAOException(e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new DAOException(e);
                }
            }
        } else {
            throw new DAOException(MENSAGEM_LIVRO_REFERENCIA_NAO_NULA);
        }
    }
    
    @Override
    public Livro selectById(Integer id) throws DAOException {
        Livro livro = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        id = id == null ? 0 : id;
        if (id != 0) {
            try {
                connection = ConnectionFactory.getMySqlConnection("livraria");
                preparedStatement = connection.prepareStatement("SELECT * FROM livros WHERE ID = ?");
                preparedStatement.setInt(1, id);
                preparedStatement.executeQuery();
                resultSet = preparedStatement.getResultSet();
                resultSet.next();
                livro = new Livro();
                livro.setId( resultSet.getInt(1) );
                livro.setTitulo( resultSet.getString(2) );
                livro.setAutor( resultSet.getString(3) );
            } catch (IllegalStateException | SQLException e) {
                throw new DAOException(e);
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    throw new DAOException(e);
                }
            }
        } else {
            throw new DAOException(MENSAGEM_LIVRO_ID_NAO_NULO);
        }
        return livro;
    }
    
    @Override
    public List<Livro> selectAll() throws DAOException {
        List<Livro> livros = Livro.EMPTY_LIVRO_LIST;
        Livro livro = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getMySqlConnection("livraria");
            if (connection != null) {
                preparedStatement = connection.prepareStatement("SELECT * FROM livros");
                preparedStatement.executeQuery();
                resultSet = preparedStatement.getResultSet();
                livros = new ArrayList<>();
                while (resultSet.next()) {
                    livro = new Livro();
                    livro.setId( resultSet.getInt(1) );
                    livro.setTitulo( resultSet.getString(2) );
                    livro.setAutor( resultSet.getString(3) );
                    livros.add(livro);
                }
            }
        } catch (IllegalStateException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
        return livros;
    }
    
    @Override
    public void deleteAll() throws DAOException {
        List<Livro> livros = this.selectAll();
        for (Livro livro : livros) {
            this.delete(livro);
        }
    }
    
    public static void checkForeignKeys(boolean value) throws DAOException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionFactory.getMySqlConnection("livraria");
            statement = connection.createStatement();
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = " + (value == true ? 1 : 0));
        } catch (IllegalStateException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
    
    public static void truncateTable() throws DAOException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionFactory.getMySqlConnection("livraria");
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE livros");
        } catch (IllegalStateException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
    
}
