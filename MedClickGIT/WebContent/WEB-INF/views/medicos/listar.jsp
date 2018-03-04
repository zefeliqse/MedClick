<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de médicos</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	color: white;

}
html, body{
	margin:0px;
	padding:0px;
	width:100%;
	height:100%;	
	background-color:#0099ff;
	background-size:100% 100%;
	background-position:center center;
	
}

a:hover {
	color: black;
}

a:active {
	color: white;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background: linear-gradient(to right, grey, #00bfff);
	border-radius: 20px;
	display: inline-block;
	width: 130px;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 10px 15px;
	text-decoration: none;
	float: center;
}

li a:hover:not (.active ) {
	background: linear-gradient(to left, grey, #00bfff);
}

.active {
	background-color: #4CAF50;
}
h1 {
	font-size: 50px;
	color: white;
	float: center;
	text-shadow: 1px 0px 0px purple;
}
table{
   border-collapse: collapse;
	border-color: white;
}
.button {
    background-color: gray;
    font-size: 12px; 
    padding: 10px 20px;
   color: black;
    }

}
</style>

</head>
<body>
<div align = "center">
<br><br><br>
	<h1>Médicos</h1>
	<br><br>
	<ul>
						<li><a href="/medc/">Pagina inicial</a></li>
					</ul><br><br>
	

	<table border="1">

		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>CRM</th>
			<th>Especialidade</th>
			<th>Data de Nascimento</th>
		</tr>

		<c:forEach var="lista" items="${lista}">
			<tr>
				<td>${lista.nome}</td>
				<td>${lista.email}</td>
				<td>${lista.telefone}</td>
				<td>${lista.crm}</td>
				<td>${lista.especialidade }</td>
				<td><fmt:formatDate value="${lista.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>

	</table>
	<br><br>
	<button class="button"><a href="/medc/logout">Logout</a></button>
	</div>
</body>
</html>