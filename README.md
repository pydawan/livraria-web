LIVRARIA WEB
=

Sistema de Controle de Livraria escrito em **Java** e baseado na **Web**.

Entidades
==

1. Livro
    * id                    INTEIRO
    * título                TEXTO
    * autor                 TEXTO


TDD - TEST DRIVEN DEVELOPMENT
==
* 1. Crie um teste que falhe
* 1.1 Instancie um objeto de uma classe que ainda não existe
* 1.2 Implemente a classe (sem atributos, sem construtores e sem métodos)
* 1.3 Armazene valores em atributos que ainda não existem na classe
* 1.4 Implemente os atributos do item 1.3 com visibilidade pública na classe criada
* 1.5 Compare se o valores esperados são iguais aos valores armazenados nos atributos do objeto.
* 1.6 repita para cada teste
    * 1.6.1 se houve um erro então
        * 1.6.1.1 lance uma exceção informando a causa do erro (pode ser algum problema na compilação do código-fonte ou falta de memória
        principal ou secundária ao executar o programa).
    * 1.6.2 se houve uma falha então
        * 1.6.2.1 lance uma exceção informando que o valor esperado não é igual ao valor obtido.
    * 1.6.3 fim-repita
* 1.7 todos os testes foram bem-sucedidos
* 1.8 se necessário refatore a implementação da solução (aplicar encapsulamento, criar construtores, getters e setters, redefinir toString(), etc). 
