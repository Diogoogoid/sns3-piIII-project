<%-- 
    Document   : cadastrarUsuario
    Created on : 09/11/2017, 17:57:52
    Author     : diogo.felix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Usuario</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/menuPrincipal.css">
        <link rel="stylesheet" href="css/cadastrarUsuario.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
    <nav class="navbar navbar-default" style="margin-bottom:2px; ">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Astec</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="sair"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </nav>
    <nav class="navbar navbar-default sidebar" role="navigation">
        <div class="container-fluid">
            <div class="profile-usertitle">
                <div class="profile-usertitle-name">
                    Marcus Doe
                </div>
                <div class="profile-usertitle-job">
                    Developer
                </div>
            </div>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active format-active"><a href="/home">Home<span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-home"></span></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Usuarios <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a>
                        <ul class="dropdown-menu forAnimate" role="menu">
                            <li><a href="CadastrarUsuario">Cadastrar</a></li>
                            <li><a href="#">Consultar</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Clientes <span class="caret"></span><span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-list-alt"></span></a>
                        <ul class="dropdown-menu forAnimate" role="menu">
                            <li><a href="#">Cadastrar</a></li>
                            <li><a href="#">Consultar</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Produtos <span class="caret"></span><span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-th-list"></span></a>
                        <ul class="dropdown-menu forAnimate" role="menu">
                            <li><a href="#">Cadastrar</a></li>
                            <li><a href="#">Consultar</a></li>
                        </ul>
                    </li>
                    <li ><a href="#">Relatorio Vendas<span style="font-size:16px;" class="pull-right showopacity glyphicon glyphicon-tags"></span></a></li>
                </ul>
            </div>

        </div>
    </nav>
    <main id="page-content-wrapper" role="main">
        <form class="form-horizontal">
        <fieldset>
        <div class="panel panel-primary">
            <div class="panel-heading">Cadastro de Cliente</div>
            <div class="panel-body">
        <div class="form-group">
        <div class="col-md-11 control-label">
                <p class="help-block"><h11>*</h11> Campo Obrigatório </p>
        </div>
        </div>

                    
        <div id="newpost">
            <div class="form-group">
             <div class="col-md-2 control-label">
                 <h3>Dados cadastrais</h3>
             </div>
             </div>
        </div>
                
        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="Nome">Nome <h11>*</h11></label>  
          <div class="col-md-8">
          <input id="Nome" name="Nome" placeholder="" class="form-control input-md" required="" type="text" autofocus>
          </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="Nome">CPF <h11>*</h11></label>  
          <div class="col-md-2">
          <input id="cpf" name="cpf" placeholder="Apenas números" class="form-control input-md" required="" type="text" maxlength="11" pattern="[0-9]+$">
          </div>

          <label class="col-md-1 control-label" for="Nome">Nascimento<h11>*</h11></label>  
          <div class="col-md-2">
          <input id="dtnasc" name="dtnasc" placeholder="DD/MM/AAAA" class="form-control input-md" required="" type="text" maxlength="10" OnKeyPress="formatar('##/##/####', this)" onBlur="showhide()">
        </div>

        <!-- Multiple Radios (inline) -->

          <label class="col-md-1 control-label" for="radios">Sexo <h11>*</h11></label>
          <div class="col-md-4"> 
            <label required="" class="radio-inline" for="radios-0" >
              <input name="sexo" id="sexo" value="feminino" type="radio" required>
              Feminino
            </label> 
            <label class="radio-inline" for="radios-1">
              <input name="sexo" id="sexo" value="masculino" type="radio">
              Masculino
            </label>
          </div>
        </div>

        <!-- Prepended text-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="prependedtext">Telefone <h11>*</h11></label>
          <div class="col-md-2">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
              <input id="prependedtext" name="prependedtext" class="form-control" placeholder="XX XXXXX-XXXX" required="" type="text" maxlength="13" pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$"
              OnKeyPress="formatar('## #####-####', this)">
            </div>
          </div>

            <label class="col-md-1 control-label" for="prependedtext">Telefone</label>
             <div class="col-md-2">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
              <input id="prependedtext" name="prependedtext" class="form-control" placeholder="XX XXXXX-XXXX" type="text" maxlength="13"  pattern="\[0-9]{2}\ [0-9]{4,6}-[0-9]{3,4}$"
              OnKeyPress="formatar('## #####-####', this)">
            </div>
          </div>
         </div> 

        <!-- Prepended text-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="prependedtext">Email <h11>*</h11></label>
          <div class="col-md-5">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
              <input id="prependedtext" name="prependedtext" class="form-control" placeholder="email@email.com" required="" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" >
            </div>
          </div>
        </div>


        <!-- Search input-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="CEP">CEP <h11>*</h11></label>
          <div class="col-md-2">
            <input id="cep" name="cep" placeholder="Apenas números" class="form-control input-md" required="" value="" type="search" maxlength="8" pattern="[0-9]+$">
          </div>
          <div class="col-md-2">
              <button type="button" class="btn btn-primary" onclick="pesquisacep(cep.value)">Pesquisar</button>
            </div>
        </div>

        <!-- Prepended text-->
        <div class="form-group">
          <label class="col-md-2 control-label" for="prependedtext">Endereço</label>
          <div class="col-md-4">
            <div class="input-group">
              <span class="input-group-addon">Rua</span>
              <input id="rua" name="rua" class="form-control" placeholder="" required="" readonly="readonly" type="text">
            </div>

          </div>
            <div class="col-md-2">
            <div class="input-group">
              <span class="input-group-addon">Nº <h11>*</h11></span>
              <input id="numero" name="numero" class="form-control" placeholder="" required=""  type="text">
            </div>

          </div>

          <div class="col-md-3">
            <div class="input-group">
              <span class="input-group-addon">Bairro</span>
              <input id="bairro" name="bairro" class="form-control" placeholder="" required="" readonly="readonly" type="text">
            </div>

          </div>
        </div>

        <div class="form-group">
          <label class="col-md-2 control-label" for="prependedtext"></label>
          <div class="col-md-4">
            <div class="input-group">
              <span class="input-group-addon">Cidade</span>
              <input id="cidade" name="cidade" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
            </div>

          </div>

           <div class="col-md-2">
            <div class="input-group">
              <span class="input-group-addon">Estado</span>
              <input id="estado" name="estado" class="form-control" placeholder="" required=""  readonly="readonly" type="text">
            </div>

          </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
          <label class="col-md-2 control-label" for="Estado Civil">Estado Civil <h11>*</h11></label>
          <div class="col-md-2">
            <select required id="Estado Civil" name="Estado Civil" class="form-control">
                <option value=""></option>
              <option value="Solteiro(a)">Solteiro(a)</option>
              <option value="Casado(a)">Casado(a)</option>
              <option value="Divorciado(a)">Divorciado(a)</option>
              <option value="Viuvo(a)">Viuvo(a)</option>
            </select>
          </div>
          </div>
        </div>
            
        <!-- Seção login -->
        <div id="newpost">
            <div class="form-group">
             <div class="col-md-2 control-label">
                 <h3>Dados de acesso</h3>
             </div>
             </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="login">Login <h11>*</h11></label>
            <div class="col-md-3">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="login" name="login" class="form-control" placeholder="Digite o login" required="" type="text" maxlength="13">
                </div>
            </div>
        </div>  
        <div class="form-group">
            <label class="col-md-2 control-label" for="password">Senha <h11>*</h11></label>
            <div class="col-md-2">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" name="password" class="form-control" placeholder="******" type="password" maxlength="13" >
                </div>
            </div>
        </div>    
        <div class="form-group">
        <label class="col-md-2 control-label" for="Departamento">Departamento <h11>*</h11></label>
        <div class="col-md-2">
            <select required id="Departamento" name="Departamento" class="form-control">
                    <option value=""></option>
                    <option value="vendas">Vendas</option>
                    <option value="administrador">Administrador</option>
            </select>
        </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="permissao">Permissão <h11>*</h11></label>
            <div class="col-md-2">
                    <select required id="permissao" name="permissao" class="form-control">
                            <option value=""></option>
                            <option value="vendedor">Vendedor</option>
                    </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" for="permissao">Status <h11>*</h11></label>
            <div class="col-md-2">
                    <input type="checkbox" value="sim"> Ativo
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
          <label class="col-md-2 control-label" for="Cadastrar"></label>
          <div class="col-md-8">
            <button id="Cadastrar" name="Cadastrar" class="btn btn-success" type="Submit">Cadastrar</button>
            <button id="Cancelar" name="Cancelar" class="btn btn-danger" type="Reset">Cancelar</button>
          </div>
        </div>
         </div> 

        </fieldset>
        </form>        
       
    </main>
    </body>
    <script src="js/cadastrarUsuario.js"></script>
</html>
