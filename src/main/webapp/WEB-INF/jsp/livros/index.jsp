<%@ include file="../../templates/header.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table id="listagem-livros"
                class="table table-bordered table-striped table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Título</th>
                        <th>Autor</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="livro" items="${livros}">
                        <tr>
                            <td>${livro.id}</td>
                            <td>${livro.titulo}</td>
                            <td>${livro.autor}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/livraria-web/">Voltar</a>
            <button id="listar">Listar jklfdjkldkl</button>
        </div>
    </div>
</div>
<%@ include file="../../templates/javascripts.jsp"%>
<script>
    $(document).ready(function() {
        console.log("jQuery loaded!");
        console.log('<%=request.getAttribute("livros")%>');
        
        $('#listar').click(function(event) {
            $.ajax({
                url : '/livraria-web/livros',
                method : 'GET',
                dataType : 'json',
                cache : false,
                success : function(response) {
                    console.log(response);
                },
                error : function(response) {
                    console.log(response);
                },
                complete : function(response) {
                    console.log(response.status + ' - ' + response.statusText);
                }
            });
        });
        
    });
</script>
<%@ include file="../../templates/footer.jsp"%>
