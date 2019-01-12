package br.com.livrariaweb.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstração de um livro no contexto do sistema.
 * 
 * @author thiago-amm
 * @version v1.0.0 09/01/2019
 * @since v1.0.0
 */
public class Livro {
    
    public static final List<Livro> EMPTY_LIVRO_LIST = Collections.unmodifiableList(new ArrayList<>(0)); 
    
    // Attributes
    private Integer id;
    private String titulo;
    private String autor;
    
    public Livro(Integer id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public Livro(String titulo, String autor) {
        this(null, titulo, autor);
    }
    
    public Livro() {
        this(null, null, null);
    }
    
    public static Livro of(Integer id, String titulo, String autor) {
        return new Livro(id, titulo, autor);
    }
    
    public static Livro of(String titulo, String autor) {
        return new Livro(titulo, autor);
    }
    
    public static Livro of() {
        return new Livro();
    }
    
    // Getters
    public Integer getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    // Setters
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return String.format("Livro (id = %s, titulo = %s, autor = %s)", id, titulo, autor);
    }
    
}
