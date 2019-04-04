<%@ include file="../../templates/header.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <!-- Button to Open the Modal -->
                    <button 
                        type="button" 
                        class="btn btn-primary" 
                        data-toggle="modal" 
                        data-target="#myModal"
                        style="margin-bottom: 10px;">
                        Adicionar
                    </button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table id="listagem-livros" class="table table-bordered table-hover">
                        <thead class="text-center">
                            <tr>
                                <th>Id</th>
                                <th>Título</th>
                                <th>Autor</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="livro" items="${livros}">
                                <tr>
                                    <td>${livro.id}</td>
                                    <td>${livro.titulo}</td>
                                    <td>${livro.autor}</td>
                                    <td align="center">
                                        <button class="btn btn-warning">Editar</button>
                                        <button class="btn btn-danger">Remover</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="/livraria-web/" class="btn btn-link">Voltar</a>
                </div>
            </div>
            
            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Livro</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <!-- Modal body -->
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="id-livro">Id:</label>
                                    <input type="text" id="id-livro" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="titulo-livro">Título:</label>
                                    <input type="text" id="titulo-livro" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="autor-livro">Autor:</label>
                                    <input type="text" id="autor-livro" class="form-control">
                                </div>
                            </form>
                        </div>
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                        </div>
                    </div>
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
