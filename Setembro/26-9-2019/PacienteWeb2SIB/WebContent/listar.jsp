<%@page import="br.fiap.modelo.Paciente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Pacientes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Lista de Pacientes</h1>
	</div>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">CPF</th>
					<th scope="col">Nome</th>
					<th scope="col">Fone</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Paciente> lista = (List<Paciente>) request.getAttribute("lista");

					for (Paciente paciente : lista) {
				%>
				<tr>
					<th scope="row">
						<%=
							paciente.getCpf()
						%>
					</th>
					<td>
						<%=
							paciente.getNome()
						%>
					</td>
					<td>
						<%=
							paciente.getFone()
						%>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>