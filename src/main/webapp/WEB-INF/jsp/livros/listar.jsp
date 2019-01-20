<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.livrariaweb.model.Livro" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="stylesheet" type="text/css" href="static/bower_components/bootstrap/dist/css/bootstrap.min.css">
			
		<title>Livraria Web</title>
	</head>
	
	<body>
		<div class="container">
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
    	</div>
    	
    	<script src="static/bower_components/jquery/dist/jquery.min.js"></script>
    	<script src="static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	</body>
</html>