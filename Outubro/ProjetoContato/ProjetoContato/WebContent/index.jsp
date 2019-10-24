<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Contatos</title>
		<link rel="stylesheet" href="estilo.css">
	</head>
	<body>
		<h1>Contatos</h1>

	<div>
  		<form action="cadastro" method="post">
			<label for="lnome">Nome</label><br>
    		<input type="text" id="nome" name="nome" placeholder="Nome do contato..."><br>
	  
			<label for="lemail">Email</label><br>
    		<input type="text" id="email" name="email" placeholder="Email do contato..."><br>
	  
			<label for="lendereco">Endereço</label><br>
			<input type="text" id="endereco" name="endereco" placeholder="Endereço do contato..."><br>
	  
			<label for="lnome">Data de Nascimento</label><br>
			<input type="date" id="data" name="data"><br>

    
			<label for="lgenero">Gênero</label><br>
			<input type="radio" id="feminino" name="genero" value="Feminino" checked>Feminino 
			<input type="radio" id="masculino" name="genero" value="Masculino">Masculino
			<input type="radio" id="indiferente" name="genero" value="Indiferente">Indiferente
	  	
    		<br>
    		<input type="submit" value="Cadastrar">
  		</form>
	</div>
		
	</body>
</html>