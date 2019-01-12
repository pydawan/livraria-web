package br.com.livrariaweb.model;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.livrariaweb.dao.ConnectionFactory;
import br.com.livrariaweb.dao.LivroDAO;

/**
 * @author thiago-amm
 * @version v1.0.0 12/01/2019
 * @since v1.0.0
 */
public class LivroDAOTest {
    
    @Before
    public void tearDown() {
        LivroDAO.checkForeignKeys(false);
        LivroDAO.truncateTable();
    }
    
    @Ignore
    @Test
    public void testConnection() {
        Connection connection = ConnectionFactory.getConnection("mysql", "localhost", 3306, "livraria", "livraria", "livraria");
        Assert.assertTrue(connection != null);
        connection = ConnectionFactory.getMySqlConnection("livraria", "livraria", "livraria");
        Assert.assertTrue(connection != null);
        connection = ConnectionFactory.getMySqlConnection("livraria");
        Assert.assertTrue(connection != null);
    }
    
    @Test
    public void testInsert() {
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.insert(Livro.of("Sítio do Picapau Amarelo", "Monteiro Lobato"));
        Livro livro = livroDAO.selectById(1);
        System.out.println(livro);
        Assert.assertTrue(livro != null);
        Assert.assertTrue(livro.getId() == 1);
        Assert.assertTrue(livro.getTitulo().equals("Sítio do Picapau Amarelo"));
        Assert.assertTrue(livro.getAutor().equals("Monteiro Lobato"));
    }
    
    @Test
    public void testSelectAll() {
        Livro livro = Livro.of("O Senhor dos Anéis", "J.R.R Tolkien");
        LivroDAO dao = new LivroDAO();
        dao.insert(livro);
        List<Livro> livros = dao.selectAll();
        Assert.assertTrue(livros != null);
        Assert.assertTrue(!livros.isEmpty());
        System.out.println(livros);
    }
    
}
