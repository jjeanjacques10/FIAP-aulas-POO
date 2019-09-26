<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Hotel Nacional dos Estudantes</h1>
		<hr></hr>
		<h4>Hospedagem:</h4>
		<form action="HospedagemServlet" methor="GET">
			<div class="form-group">
				<input type="number"  class="form-control" name="numeroNoites" placeholder="Número de noites">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary mb-2" name="botao">Consultar valor</button>
			</div>
		</form>
		<br />
		<div class="container">
		Valor da hospedagem: R$ ${valor}
		</div> 
	</div>
</body>
</html>