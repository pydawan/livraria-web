<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.livrariaweb.model.Livro" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livraria Web</title>
</head>
<body>
    <h1>Livros Cadastrados</h1>
    <ol>
        <%
            List<Livro> livros = (List<Livro>) request.getAttribute("livros");
            for (Livro livro : livros) {
                out.println("<li>" + livro + "</li>");
            }
        %>
    </ol>
    <strong><a href="/livraria-web/">Voltar</a></strong>
</body>
</html>