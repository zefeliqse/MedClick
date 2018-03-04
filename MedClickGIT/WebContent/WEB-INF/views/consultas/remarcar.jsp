<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	

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
	width: 690px;
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
<body>
<div align = "center">
<br><br><br><br>
<h1>Remarcar consulta</h1><br>
	<form action="/medc/consultas/remarcar" method="post">
		<div>
			<label>Médico:<br> </label> <input type="text" value="${con.crm}" name="crm" />
		</div>
		<div>
			<label>Data da Consulta: <br></label> <input type="text" value="<fmt:formatDate value="${con.dataConsulta.time}"
						pattern="dd/MM/yyyy" />"
				name="dataConsulta" />
		</div>
		<div>
			<input type="hidden" value="${con.id}" name="id"><br>
			<button type="submit" class = "button">Remarcar</button>
		</div>
	</form>

	</div>

			
</body>
</html>