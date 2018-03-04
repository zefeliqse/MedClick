<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Consultas</title>


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
    padding: 5px 10px;
   color: black;
    }
}
</style>


</head>
<body >



<div align = "center">

<br><br><br>






<ul>
						<li><a href="/medc/">Pagina inicial</a></li>
					</ul>
					
				
	<h1>Consultas do dia</h1>
	<table border="1" align="center">

		<tr>
			<th>Nº</th>
			<th>Médico</th>
			<th>Paciente</th>
			<th>Ação</th>
		</tr>
		<c:forEach var="dia" items="${dia}">
			<tr>
				<td>${dia.id}</td>
				<td>${dia.crm}</td>
				<td>${dia.cpf}</td>
				<td><a href="/medc/consultas/remarcar?id=${dia.id}">Remarcar</a>
			</tr>
		</c:forEach>
	</table>

	<h1>Consultas futuras</h1>
	<table border="1">

		<tr>
			<th>Nº</th>
			<th>Médico</th>
			<th>Paciente</th>
			<th>Data</th>
			<th>Ação</th>
		</tr>
		<c:forEach var="futuras" items="${futuras}">
			<tr>
				<td>${futuras.id}</td>
				<td>${futuras.crm}</td>
				<td>${futuras.cpf}</td>
				<td><fmt:formatDate value="${futuras.dataConsulta.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="/medc/consultas/cancelar?id=${futuras.id}">Cancelar</a>
			</tr>
		</c:forEach>
	</table>

	<h1>Consultas passadas</h1>
	<table border="1">

		<tr>
			<th>Nº</th>
			<th>Médico</th>
			<th>Paciente</th>
			<th>Data</th>
		</tr>
		<c:forEach var="passadas" items="${passadas}">
			<tr>
				<td>${passadas.id}</td>
				<td>${passadas.crm}</td>
				<td>${passadas.cpf}</td>
				<td><fmt:formatDate value="${passadas.dataConsulta.time}"
						pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>
	</table>

	<h1>Todas as consultas</h1>
	<table border="1">

		<tr>
			<th>Nº</th>
			<th>Médico</th>
			<th>Paciente</th>
			<th>Data</th>
		</tr>
		<c:forEach var="completa" items="${completa}">
			<tr>
				<td>${completa.id}</td>
				<td>${completa.crm}</td>
				<td>${completa.cpf}</td>
				<td><fmt:formatDate value="${completa.dataConsulta.time}"
						pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>
		
	</table>
	<br><br>
	<button class="button"><a href="/medc/logout">Logout</a></button>
</div>

</body>
</html>