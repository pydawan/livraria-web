package br.com.livrariaweb.model;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author thiago-amm
 * @version v1.0.0 09/01/2019
 * @since v1.0.0
 */
public class LivroTest {
    
    private static final Logger logger = Logger.getLogger(LivroTest.class);
    
    @Test
    public void test() {
        try {
            Livro livro = new Livro();
            livro.setId(2);
            Assert.assertTrue("FALHA: \"O id do livro não é igual a 1 como se esperava!\"", 1 == livro.getId() );
            livro.setTitulo("O Senhor dos Anéis");
            Assert.assertEquals("FALHA: \"O título do livro não é igual a O Senhor dos Anéis como se esperava!\"", "O Senhor dos Anéis", livro.getTitulo() );
            livro.setAutor("J.R.R Tolkien");
            Assert.assertEquals("FALHA: \"O autor do livro não é igual a J.R.R Tolkien como se esperava!\"", "J.R.R Tolkien", livro.getAutor() );
            System.out.println(livro);
        } catch (AssertionError e) {
            logger.error(e);
            fail(e.getMessage());
        }
    }
    
}
