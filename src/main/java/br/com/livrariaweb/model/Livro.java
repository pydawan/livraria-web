package br.com.livrariaweb.model;

/**
 * Abstração de um livro no contexto do sistema.
 * 
 * @author thiago-amm
 * @version v1.0.0 09/01/2019
 * @since v1.0.0
 */
public class Livro {
    
    public int id;
    public String titulo;
    public String autor;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
}
