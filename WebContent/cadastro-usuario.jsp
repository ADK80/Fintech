<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FEF - Cadastro</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container formcentral">
<br>
<br>
	<h1 class="centertext">Cadastro</h1><br><br>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form action="usuario" method="post">
		<input type="hidden" value="cadastrar" name="acao">
		<div class="form-group" >
			<label for="id-login">Usuário</label>
			<input type="text" name="login" id="id-login" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-senha">Senha</label>
			<input type="password" name="senha" id="id-senha" class="form-control">
		</div><br>
		<!--<div class="form-group">
			<label for="id-fabricacao">Data de Fabricação</label>
			<input type="text" name="fabricacao" id="id-fabricacao" class="form-control">
		    </div>-->
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>