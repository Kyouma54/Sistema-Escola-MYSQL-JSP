<%@page import="java.util.Collection"%>
<%@page import="com.eib.projetop1.beans.Cliente"%>
<%@page import="com.eib.projetop1.beans.Turma"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sistema Escola</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="frmGerenciador.jsp">Sistema Escola</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Perfil</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configurações</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="controller.do?command=logout"><i class="fa fa-sign-out fa-fw"></i> Sair</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="frmGerenciador.jsp"><i class="fa fa-home fa-fw"></i> Página Inicial</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> Coordenação<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Professores <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="frmCriarProfessor.jsp">Criar Professor</a>
                                        </li>
                                        <li>
                                            <a href="frmListarProfessor.jsp">Listar Professores</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                <li>
                                    <a href="#">Cursos <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="frmCriarCurso.jsp">Criar Curso</a>
                                        </li>
                                        <li>
                                            <a href="frmListarCurso.jsp">Listar Cursos</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                <li>
                                    <a href="#">Turmas <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="frmCriarTurma.jsp">Criar Turma</a>
                                        </li>
                                        <li>
                                            <a href="frmListarTurma.jsp">Listar Turmas</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-user fa-fw"></i> Autenticação<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#"> Perfis<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="frmCriarPerfil.jsp">Criar Perfil</a>
                                        </li>
                                        <li>
                                            <a href="frmListarPerfil.jsp">Listar Perfil</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                <li>
                                    <a href="#">Usuarios <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="frmCriarUsuario.jsp">Criar Usuario</a>
                                        </li>
                                        <li>
                                            <a href="frmListarUsuario.jsp">Listar Usuarios</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-building fa-fw"></i> Comercial<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Clientes <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="frmCriarCliente.jsp">Criar Cliente</a>
                                        </li>
                                        <li>
                                            <a href="frmListarCliente.jsp">Listar Clientes</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                <li>
                                    <a href="#">Matriculas <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="frmCriarMatricula.jsp">Criar Matricula</a>
                                        </li>
                                        <li>
                                            <a href="frmListarMatricula.jsp">Listar Matriculas</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <!-- /.row -->
            <div class="row align-items-start">
                <div class="col-lg-12">
                		<h2 class="page-header">Criar um cadastro</h2>
                		<% String msg = request.getParameter("msg");
                                	if(msg!=null){
                                %>
                                <div class="alert alert-danger alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                	${param.msg }
                            	</div>
                                <% 
                                	}
                                %>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Informações da Matricula</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="controller.do?command=criarMatricula" method="post">
                                <fieldset class="col-lg-8">
										  <div class="form-row">
										    <div class="form-group col-md-6">
										      <label for="nome">Nome</label>
										      <select class="form-control" id="nome" name="idCliente" required>
										      	<option value="">Selecione um Cliente</option>
										      	<% 
										      		Cliente c1 = new Cliente();
										    		Collection<Cliente> lista2 = c1.buscarTodos();
										    		  for(Cliente x : lista2){
										      	%>
										      		<option value="<%=x.getId_cliente()%>"><%=x.getNome()%></option>
										      	<%
										      		} 
										      	%>
										      </select>
										    </div>
										    <div class="form-group col-md-6">
										      <label for="turma">Turma</label>
										      <select class="form-control" id="turma" name="idTurma" required >
										      	<option value="">Selecione uma turma</option>
										      	<% 
										      		Turma t1 = new Turma();
										    		Collection<Turma> lista = t1.buscarTodos();
										    		
										    		  for(Turma x : lista){
										      	%>
										   
										      	<option value=<%=x.getId_turma()%>><%=x.getId_turma()%></option>
										      	<% 
										    		  }
										      	%>
										      </select>
										    </div>
										  </div>
										  
                                    <!-- Change this to a button or input when using this as a form -->
                                    <div class="form-group col-md-12">
                                    	<button type="submit" class="btn btn-outline btn-warning">Cadastrar</button>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="vendor/raphael/raphael.min.js"></script>
    <script src="vendor/morrisjs/morris.min.js"></script>
    <script src="data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
