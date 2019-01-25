package br.com.livrariaweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.owlike.genson.Genson;

import br.com.livrariaweb.model.Livro;
import br.com.livrariaweb.service.LivroService;

/**
 * @author thiago-amm
 * @version v1.0.0 19/01/2019
 * @since v1.0.0
 */
@WebServlet(name = "livroController", urlPatterns = "/livros")
public class LivroController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    private LivroService livroService;
    private Genson genson;
    
    // Servlet Life Cyle
    
    // 1. The Servlet Container (Tomcat) loads the Servlet class.
    // 2. creates a instance of the Servlet class.
    
    // 3. calls init
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // this.livroService = new LivroService();
    }
    
    // 2. calls service
    // 2.1 Atende qualquer requisição HTTP (métodos GET, POST, PUT, DELETE, ...)
    // 2.2 Para cada requisição é criada uma nova thread. 
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }
    
    // 3. calls destroy
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }
    
    // atende apenas requisições HTTP GET.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		livroService = new LivroService();
    		List<Livro> livros = livroService.listarLivros();
    		response.setContentType("application/json");
    		response.setCharacterEncoding("UTF-8");
    		if ( !livros.isEmpty() ) {
    			response.setStatus(HttpServletResponse.SC_OK);
    			// 1. O header Accept é configurado na requisição HTTP enviada pelo cliente e informa o tipo de dados aceito (esperado) como resposta.
    			// 2. O header Content-Type é configurado na resposta HTTP e informa o tipo de dados retornado para o cliente.
    			// 3. Accept informa o tipo de dados consumido e o Content-Type informa o tipo de dados produzido (cliente/servidor).
    			if ( request.getHeader("Accept") != null && request.getHeader("Accept").contains("application/json") ) {
    				genson = new Genson();
        			String json = genson.serialize(livros);
        			response.getWriter().println(json);
            	} else {
            		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/livros/index.jsp");
        			request.setAttribute("livros", livros);
        			rd.forward(request, response);
            	}
    		} else {
    			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Nenhum livro cadastrado!");
    		}
    	} catch (Exception e) {
    		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
    	}
    }
    
}
