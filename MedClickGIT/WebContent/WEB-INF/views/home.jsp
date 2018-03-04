<!DOCTYPE html>
<html lang="pt-br">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MedClick</title>



<head>

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
	background:url("http://www.vizit.ks.ua/wp-content/uploads/2017/12/lhi24s1elq_big.jpg.c1b1fe8a65ec3090d2b88af39c3ed4c9-700x445.jpg") no-repeat;
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
	width: 700px;
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

.header {
	margin: auto;
	width: 100%;
	height: 100%;
	text-align: center;
	color: white;
}

h1 {
	font-size: 100px;
	color: white;
	float: center;
	text-shadow: 1px 0px 0px purple;
}
}
</style>
</head>
<body>


	<section id="sec1">
		<div class="header">
			<br> <br> <br> <br> <br> <br> <br>
			<br>
			<h1>Medclick</h1>
			<br>
			<div class="row" align="center">
				<div class="col-4 right menu">
					<ul>
						<li><a href="pacientes/login">Login</a></li>
						<li><a href="pacientes/form">Cadastro</a></li>
						<li><a href="consultas/marcar" >Marcar Consultas</a></li>
						<li><a href="consultas/lista" >Listar Consultas</a></li>
						<li><a href="pacientes/lista" >Listar Paciente</a></li>
						<li><a href="medicos/lista" >Listar Médicos</a></li>
					</ul>
				</div>
			</div>
	</section>
	
</body>
</html>