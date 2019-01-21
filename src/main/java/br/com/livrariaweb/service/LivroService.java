package br.com.livrariaweb.service;

import java.util.List;

import br.com.livrariaweb.model.Livro;
import br.com.livrariaweb.persistence.dao.LivroDAO;

/**
 * @author thiago-amm
 * @version v1.0.0 19/01/2019
 * @since v1.0.0
 */
public class LivroService {
    
    private LivroDAO livroDAO;
    
    public LivroService(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }
    
    public LivroService() {
        this(new LivroDAO());
    }
    
    public static LivroService of(LivroDAO livroDAO) {
        return new LivroService(livroDAO);
    }
    
    public static LivroService of() {
        return new LivroService();
    }
    
    public List<Livro> listarLivros() {
        List<Livro> livros = livroDAO.selectAll();
        return livros;
    }
    
}
