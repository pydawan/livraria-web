package br.com.livrariaweb.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author thiago-amm
 * @version v1.0.0 09/01/2019
 * @since v1.0.0
 */
public class LivroTest {
    
    @Test
    public void test() {
        Livro livro = new Livro();
        livro.id = 1;
        Assert.assertTrue("FALHA: \"O id do livro não é igual a 1 como se esperava!\"", 1 == livro.id);
    }
    
}
